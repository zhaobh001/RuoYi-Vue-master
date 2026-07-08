<template>
  <!-- 授权用户 -->
  <el-dialog title="选择库房" :visible.sync="visible" width="800px" top="5vh" append-to-body>
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true">
      <el-form-item label="库房编码" prop="storeroomno">
        <el-input
          v-model="queryParams.storeroomno"
          placeholder="请输入库房编码"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="库房名称" prop="storeroomname">
        <el-input
          v-model="queryParams.storeroomname"
          placeholder="请输入库房名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>
    <el-row>
      <el-table @row-click="clickRow" ref="table" :data="storeroomList" @selection-change="handleSelectionChange" height="260px">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column label="序号" align="center" prop="storeroomid" width="100" />
        <el-table-column
          label="库房编码"
          align="center"
          prop="storeroomno"
          :show-overflow-tooltip="true"
        />
        <el-table-column
          label="库房名称"
          align="center"
          prop="storeroomname"
          :show-overflow-tooltip="true"
        />
        <el-table-column label="自采子库" align="center" prop="data2" />
        <el-table-column label="VMI子库" align="center" prop="data1" />

        <el-table-column label="库房结构" align="center" prop="roomtag" width="100">
          <template slot-scope="scope">
            <dict-tag :options="dict.type.sys_storeroom_roomtag" :value="scope.row.roomtag"/>
          </template>
        </el-table-column>
      </el-table>
      <pagination
        v-show="total>0"
        :total="total"
        :page.sync="queryParams.pageNum"
        :limit.sync="queryParams.pageSize"
        @pagination="getList"
      />
    </el-row>
    <div slot="footer" class="dialog-footer">
      <el-button type="primary" @click="handleSelectStoreroom">确 定</el-button>
      <el-button @click="visible = false">取 消</el-button>
    </div>
  </el-dialog>
</template>

<script>
import { unallocatedStoreroomList, authStoreroomSelectAll } from "@/api/system/role";
export default {
  dicts: ['sys_storeroom_roomtag'],
  props: {
    // 角色编号
    roleId: {
      type: [Number, String]
    }
  },
  data() {
    return {
      // 遮罩层
      visible: false,
      // 选中数组值
      roomIds: [],
      // 总条数
      total: 0,
      // 未授权用户数据
      storeroomList: [],
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        roleId: undefined,
        storeroomno: undefined,
        storeroomname: undefined
      }
    };
  },
  methods: {
    // 显示弹框
    show() {
      this.queryParams.roleId = this.roleId;
      this.getList();
      this.visible = true;
    },
    clickRow(row) {
      this.$refs.table.toggleRowSelection(row);
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.roomIds = selection.map(item => item.storeroomid);
    },
    // 查询表数据
    getList() {
      unallocatedStoreroomList(this.queryParams).then(res => {
        this.storeroomList = res.rows;
        this.total = res.total;
      });
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    /** 选择授权用户操作 */
    handleSelectStoreroom() {
      const roleId = this.queryParams.roleId;
      const roomIds = this.roomIds.join(",");
      if (roomIds == "") {
        this.$modal.msgError("请选择要分配的库房");
        return;
      }
      authStoreroomSelectAll({ roleId: roleId, roomIds: roomIds }).then(res => {
        this.$modal.msgSuccess(res.msg);
        if (res.code === 200) {
          this.visible = false;
          this.$emit("ok");
        }
      });
    }
  }
};
</script>
