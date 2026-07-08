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
          <inbound-chart :chart-data="inboundData" @handleSetInboundData="handleSetInboundKindData"/>        </div>
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



  import RaddarChart from '../../dashboard/RaddarChart'
  import PieChart from '../../dashboard/PieChart'
  import BarChart from '../../dashboard/BarChart'


  import InboundChart from '../../dashboard/InboundChart'
  import {getInboundData,getInboundDatabykindqty,getInbounddetail } from "@/api/system/index";


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
      RaddarChart,
      PieChart,
      BarChart,

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

        inboundData : {
          graphicText:'入库分析',
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
          url:"/dataview/inbound"
        },
        inboundQtyData : {
          graphicText:'入库数量',
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
          graphicText:'入库种类',
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
          graphicText:'入库种类明细',
          categoryList: [],
          yAxisname:'种类(种)',
          bar1List:[],
          Y1max:''
        },

        inboundrateData : {
          graphicText:'入库种类占比分析',
          categoryList: [],
          bar1List:[],
        },


        value: new Date(),
        groupType: "month",
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
      getInboundData() {
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
      },

      getList() {
        this.loading = false;
        this.getInboundData();
        this.getInbounddetail();
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

      getInbounddetail() {
        this.loading = false;
        getInbounddetail(this.mode,this.year_month).then(response => {
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
          this.inbounddetailData.graphicText='入库种类明细';
          this.inbounddetailData.yAxisname='种类' ;
          this.inboundrateData.graphicText='入库种类占比分析';
          this.year_month=name;
          this.getInbounddetail();
        }
        if(seriesName=="数量"){
          this.mode='qty';
          this.inbounddetailData.graphicText='入库数量明细';
          this.inbounddetailData.yAxisname='数量' ;
          this.inboundrateData.graphicText='入库数量占比分析';
          this.year_month=name;
          this.getInbounddetail();
        }

      },
      handleSetInboundQtyData(seriesName,name,value) {
        console.log("参数接收"+seriesName);
        console.log("参数接收"+name);
        console.log("参数接收"+value);

        this.inbounddetailData.graphicText='入库数量明细';
        this.yAxisname='数量' ;
        this.inboundrateData.graphicText='入库数量占比分析';


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
