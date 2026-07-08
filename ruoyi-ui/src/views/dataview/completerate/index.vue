<template>

  <div class="dashboard-editor-container">
    <el-row style="padding:0px 0px 0;margin-bottom:20px; margin-top:5px;">
      <chart-date-picker v-model="value" :type.sync="groupType" @handleChangeTime="handleChangeTime(type=0,$event)"></chart-date-picker>
    </el-row>
    <!--<panel-group @handleSetLineChartData="handleSetLineChartData" />-->

    <!--    <el-row style="background:#fff;padding:16px 16px 0;margin-bottom:32px;">
          <line-chart :chart-data="lineChartData" />
        </el-row>-->

   <el-row :gutter="32">
      <el-col :xs="32" :sm="32" :lg="12">
        <div class="chart-wrapper">
          <workoder-chart/>
        </div>
      </el-col>

     <el-col :xs="32" :sm="32" :lg="12">
       <div class="chart-wrapper">
         <workdetail-chart/>
       </div>
     </el-col>

     <el-col :xs="32" :sm="32" :lg="12">
       <div class="chart-wrapper">
         <workdetailrate-chart/>
       </div>
     </el-col>


     <!--
          <el-col :xs="32" :sm="32" :lg="12">
            <div class="chart-wrapper">
              <inbound-chart />
            </div>
          </el-col>
          <el-col :xs="32" :sm="32" :lg="12">
            <div class="chart-wrapper">
              <workload-chart />
            </div>
          </el-col>
          <el-col :xs="32" :sm="32" :lg="12">
            <div class="chart-wrapper">
              <outbound-chart/>
            </div>
          </el-col>-->


    </el-row>
    <el-table
      v-if="refreshTable"
      v-loading="loading"
      :data="deptList"
      :default-expand-all="isExpandAll"
    >
      <el-table-column prop="workDate" label="计划日期" width="260"></el-table-column>
      <el-table-column prop="matCode" label="物料编号" width="200"></el-table-column>
      <el-table-column prop="matName" label="物料名称" width="200"></el-table-column>
      <el-table-column prop="qty" label="需求数量" width="200"></el-table-column>
      <el-table-column prop="qty" label="需求数量" width="200"></el-table-column>
      <el-table-column prop="collQty" label="备货数量" width="200"></el-table-column>
      <el-table-column prop="requirQty" label="缺料数量" width="200"></el-table-column>
      <el-table-column prop="banzu" label="班组" width="200"></el-table-column>
    </el-table>
  </div>
</template>

<script>
  import WorkoderChart from '../../dashboard/WorkoderChart'
  import ChartDatePicker from '../../dashboard/ChartDatePicker'
  import WorkdetailChart from '../../dashboard/WorkdetailChart'
  import WorkdetailrateChart from '../../dashboard/WorkdetailrateChart'

  const lineChartData = {
    newVisitis: {
      expectedData: [100, 120, 161, 134, 105, 160, 165],
      actualData: [120, 82, 91, 154, 162, 140, 145]
    },
    messages: {
      expectedData: [200, 192, 120, 144, 160, 130, 140],
      actualData: [180, 160, 151, 106, 145, 150, 130]
    },
    purchases: {
      expectedData: [80, 100, 121, 104, 105, 90, 100],
      actualData: [120, 90, 100, 138, 142, 130, 130]
    },
    shoppings: {
      expectedData: [130, 140, 141, 142, 145, 150, 160],
      actualData: [120, 82, 91, 154, 162, 140, 130]
    }
  }

  export default {
    name: 'Index',
    components: {
      WorkoderChart,
      ChartDatePicker,
      WorkdetailChart,
      WorkdetailrateChart
    },
    data() {
      return {
        value: new Date(),
        groupType: "week",
        lineChartData: lineChartData.newVisitis,
        // 遮罩层
        loading: false,
        // 显示搜索条件
        showSearch: true,
        // 表格树数据
        deptList: [
          {workDate:'2023-10-25',matCode:'10117805',matName:'框架断路器|E3H/E25MSFHR3PMYCYU1220V4COS2',qty:'2',collQty:'1',requirQty:'1',banzu:'变流2组制造组(MES)'},
          {workDate:'2023-10-25',matCode:'10117805',matName:'框架断路器|E3H/E25MSFHR3PMYCYU1220V4COS2',qty:'2',collQty:'1',requirQty:'1',banzu:'变流2组制造组(MES)'},
          {workDate:'2023-10-25',matCode:'10201173',matName:'框架断路器|MVS25T33F202S2+XFMN_220V+4NO4NC',qty:'4',collQty:'3',requirQty:'1',banzu:'变流2组制造组(MES)'},
          {workDate:'2023-10-25',matCode:'10201173',matName:'框架断路器|MVS25T33F202S2+XFMN_220V+4NO4NC',qty:'4',collQty:'1',requirQty:'3',banzu:'变流2组制造组(MES)'}
          ],
        // 弹出层标题
        title: "",
        // 是否显示弹出层
        open: false,
        // 是否展开，默认全部展开
        isExpandAll: true,
        // 重新渲染表格状态
        refreshTable: true,
        // 查询参数
        queryParams: {
          deptName: undefined,
          status: undefined
        },
      }
    },
    methods: {
      handleSetLineChartData(type) {
        this.lineChartData = lineChartData[type]
      }
    }
  }
</script>

<style lang="scss" scoped>
  .dashboard-editor-container {
    padding: 0px;
    background-color: rgb(240, 242, 245);
    position: relative;

    .chart-wrapper {
      background: #fff;
      padding: 16px 16px 0;
      margin-bottom: 32px;
    }
  }

  @media (max-width:1024px) {
    .chart-wrapper {
      padding: 8px;
    }
  }
</style>
