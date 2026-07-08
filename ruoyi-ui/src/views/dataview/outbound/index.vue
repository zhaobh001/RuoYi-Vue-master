<template>

  <div class="dashboard-editor-container">
    <el-row style="padding:0px 0px 0;margin-bottom:20px; margin-top:5px;">
      <chart-date-picker v-model="value" :type.sync="groupType" @handleChangeTime="handleChangeTime(type=0,$event)"></chart-date-picker>
    </el-row>

    <!-- <el-row :gutter="32">
       <el-col :xs="24" :sm="24" :lg="8">
         <div class="chart-wrapper">
           <raddar-chart />
         </div>
       </el-col>
       <el-col :xs="24" :sm="24" :lg="8">
         <div class="chart-wrapper">
           <pie-chart />
         </div>
       </el-col>
       <el-col :xs="24" :sm="24" :lg="8">
         <div class="chart-wrapper">
           <bar-chart />
         </div>
       </el-col>
     </el-row>-->


    <!--<panel-group @handleSetLineChartData="handleSetLineChartData" />
    <el-row style="background:#fff;padding:16px 16px 0;margin-bottom:32px;">
      <line-chart :chart-data="lineChartData" />
    </el-row>-->
    <!--    <el-row style="background:#fff;padding:16px 16px 0;margin-bottom:32px;">
          <line-chart :chart-data="lineChartData" />
        </el-row>-->
    <el-row :gutter="32">
      <el-col :xs="32" :sm="32" :lg="32">
        <div class="chart-wrapper">
          <inbound-chart :chart-data="outboundData" @handleSetInboundData="handleSetInboundKindData"/>        </div>
      </el-col>
    </el-row>


    <el-row :gutter="32">
      <el-col :xs="32" :sm="32" :lg="12">
        <div class="chart-wrapper">
          <inbounddetail-chart :chart-data="inbounddetailData" />
        </div>
      </el-col>

      <el-col :xs="32" :sm="32" :lg="12">
        <div class="chart-wrapper">
          <inboundrate-chart :chart-data="inboundrateData"/>
        </div>
      </el-col>
    </el-row>
  </div>
</template>

<script>
  import WorkoderChart from '../../dashboard/WorkoderChart'
  import ChartDatePicker from '../../dashboard/ChartDatePicker'
  import LineChart from '../../dashboard/LineChart'
  import PanelGroup from '../../dashboard/PanelGroup'
  import InbounddetailChart from '../../dashboard/InbounddetailChart'
  import InboundrateChart from '../../dashboard/InboundrateChart'
  import InboundkindChart from '../../dashboard/InboundkindChart'
  import InboundqtyChart from '../../dashboard/InboundqtyChart'

  import InboundChart from '../../dashboard/InboundChart'
  import {getOutboundData,getOutbounddetail} from "@/api/system/index";

  export default {
    name: 'Index',
    components: {
      ChartDatePicker,
      WorkoderChart,
      InbounddetailChart,
      InboundChart,
      LineChart,
      PanelGroup,
      InboundrateChart,
      InboundkindChart,
      InboundqtyChart
    },
    data() {
      return {

        outboundData : {
          graphicText:'出库分析',
          categoryList: [],
          legendList: ['种类', '数量','种类同比','数量同比'],
          Y1max:'',
          Y2max:'',
          Y3min: -100,
          Y3max: 150,
          qtydataList: [],
          kinddataList: [],
          YOYqtyList: [],
          YOYkindList: [],
          url:"/dataview/outbound"
        },

        inboundQtyData : {
          graphicText:'出库数量',
          categoryList: ['1','2','3','4','5','6','7','8','9','10','11','12'],
          legendList: [],
          bar1Name:'',
          bar1List:[],
          bar2Name:'',
          bar2List:[],
          bar3Name:'',
          bar3List:[],
          Y1max:''
        },
        inboundKindData : {
          graphicText:'出库种类',
          categoryList: [],
          legendList: [],
          bar1Name:'',
          bar1List:[],
          bar2Name:'',
          bar2List:[],
          bar3Name:'',
          bar3List:[],
          Y1max:''
        },
        inbounddetailData : {
          graphicText:'出库种类明细',
          categoryList: [],
          yAxisname:'种类(种)',
          bar1List:[],
          Y1max:''
        },

        inboundrateData : {
          graphicText:'出库种类占比分析',
          categoryList: [],
          bar1List:[],
        },


        value: new Date(),
        groupType: "month",
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

        mode:'kind',
        month_id:"",
        year_id:"",
        year_month:""
      }
    },
    created() {
      console.log("进入执行");
      this.getList();
    },
    methods: {
    /*  getInboundData() {
        this.loading = false;
        getInboundData().then(response => {
            this.inboundData.categoryList = response.categoryList;
            this.inboundData.qtydataList = response.qtydataList;
            this.inboundData.kinddataList = response.kinddataList;
            this.inboundData.YOYqtyList = response.YOYqtyList;
            this.inboundData.YOYkindList = response.YOYkindList;
            this.inboundData.Y1max = response.Y1max;
            this.inboundData.Y2max = response.Y2max;
          }
        );
      },*/

      getList() {
        this.loading = false;
        this.getOutboundData();
        this.getOutbounddetail();
      },

      getOutboundData() {
        this.loading = false;
        getOutboundData().then(response => {
            this.outboundData.categoryList = response.categoryList;
            this.outboundData.qtydataList = response.qtydataList;
            this.outboundData.kinddataList = response.kinddataList;
            this.outboundData.YOYqtyList = response.YOYqtyList;
            this.outboundData.YOYkindList = response.YOYkindList;
            this.outboundData.Y1max = response.Y1max;
            this.outboundData.Y2max = response.Y2max;
          }
        );
      },
      getInboundDatabykindqty() {
        this.loading = false;
        getInboundDatabykindqty().then(response => {
            this.inboundKindData.legendList = response.legendList;
            this.inboundKindData.bar1List = response.bar1KindList;
            this.inboundKindData.bar2List = response.bar2KindList;
            this.inboundKindData.bar3List = response.bar3KindList;
            this.inboundKindData.bar1Name = response.bar1Name;
            this.inboundKindData.bar2Name = response.bar2Name;
            this.inboundKindData.bar3Name = response.bar3Name;
            this.inboundKindData.Y1max = response.Y2max;

            this.inboundQtyData.legendList = response.legendList;
            this.inboundQtyData.bar1List = response.bar1List;
            this.inboundQtyData.bar2List = response.bar2List;
            this.inboundQtyData.bar3List = response.bar3List;
            this.inboundQtyData.bar1Name = response.bar1Name;
            this.inboundQtyData.bar2Name = response.bar2Name;
            this.inboundQtyData.bar3Name = response.bar3Name;
            this.inboundQtyData.Y1max = response.Y1max;
          }
        );
      },

      getOutbounddetail() {
        this.loading = false;
        getOutbounddetail(this.mode,this.year_month).then(response => {
            this.inbounddetailData.categoryList = response.categoryList;
            this.inbounddetailData.bar1List = response.bar1List;
            this.inbounddetailData.Y1max = response.Y1max;

            this.inboundrateData.categoryList = response.categoryList;
            this.inboundrateData.bar1List = response.bar2List;
          }
        );
      },
      handleSetInboundKindData(seriesName,name,value) {
        console.log("参数接收"+seriesName);
        console.log("参数接收"+name);
        console.log("参数接收"+value);

        if(seriesName=="种类"){
          this.mode='kind';
          this.inbounddetailData.graphicText='出库种类明细';
          this.inbounddetailData.yAxisname='种类(种)' ;
          this.inboundrateData.graphicText='出库种类占比分析';
          this.year_month=name;
          this.getOutbounddetail();
        }
        if(seriesName=="数量"){
          this.mode='qty';
          this.inbounddetailData.graphicText='出库数量明细';
          this.inbounddetailData.yAxisname='数量(件)' ;
          this.inboundrateData.graphicText='出库数量占比分析';
          this.year_month=name;
          this.getOutbounddetail();
        }

      },
      handleSetInboundQtyData(seriesName,name,value) {
        console.log("参数接收"+seriesName);
        console.log("参数接收"+name);
        console.log("参数接收"+value);

        this.inbounddetailData.graphicText='出库数量明细';
        this.yAxisname='数量' ;
        this.inboundrateData.graphicText='出库数量占比分析';


        this.month_id=name
        this.year_id=seriesName

        this.getInbounddetail();
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
