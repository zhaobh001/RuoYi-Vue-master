<template>

  <div class="dashboard-editor-container" >
    <el-row style="padding:0px 0px 0;margin-bottom:20px; margin-top:5px;">
      <chart-date-picker v-model="value" :type.sync="groupType" @handleChangeTime="handleChangeTime(type=0,$event)" ></chart-date-picker>
    </el-row>

    <el-row :gutter="24" v-loading="loading">
      <el-col :xs="24" :sm="24" :lg="8" >
        <div class="chart-wrapper" @click="handleAuthRoom()" >
          <gauge-chart  :chart-data="gaugechart1" />
        </div>
      </el-col>

      <el-col :xs="24" :sm="24" :lg="8" >
        <div class="chart-wrapper" @click="handleAuthRoom()" >
          <gauge-chart :chart-data="gaugechart2" />
        </div>
      </el-col>

      <el-col :xs="24" :sm="24" :lg="8" >
        <div class="chart-wrapper" @click="handleAuthRoom()" >
          <gauge-chart  :chart-data="gaugechart3" />
        </div>
      </el-col>

      <el-col :xs="24" :sm="24" :lg="8" >
        <div class="chart-wrapper" @click="handleAuthRoom()" >
          <gauge-chart  :chart-data="gaugechart4" />
        </div>
      </el-col>

      <el-col :xs="24" :sm="24" :lg="8" >
        <div class="chart-wrapper" @click="handleAuthRoom()" >
          <gauge-chart  :chart-data="gaugechart5" />
        </div>
      </el-col>

      <el-col :xs="24" :sm="24" :lg="8">
        <div class="chart-wrapper">
          <workload-chart :chart-data="workloadData"  />
        </div>
      </el-col>
    </el-row>
  </div>
</template>

<script>
  import PanelGroup from '../../dashboard/PanelGroup'
  import LineChart from '../../dashboard/LineChart'
  import RaddarChart from '../../dashboard/RaddarChart'
  import PieChart from '../../dashboard/PieChart'
  import BarChart from '../../dashboard/BarChart'
  import GaugeChart from '../../dashboard/GaugeChart'
  import InboundChart from '../../dashboard/InboundChart2'
  import OutboundChart from '../../dashboard/OutboundChart'
  import ChartDatePicker from '../../dashboard/ChartDatePicker'
  import WorkloadChart from '../../dashboard/WorkloadChart2'
  import { getInboundData,getOutboundData,getWorkloadData } from "@/api/system/index";

  export default {
    name: 'Index',
    components: {
      LineChart,
      PanelGroup,
      RaddarChart,
      PieChart,
      BarChart,
      GaugeChart,
      InboundChart,
      OutboundChart,
      ChartDatePicker,
      WorkloadChart
    },
    data() {
      return {
        loading: true,
        value: new Date(),
        groupType: "month",

        /*inboundData : {
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
        },*/
        inboundData : {
          graphicText:'入库分析',
          categoryList: [],
          legendList: ['种类', '同比'],
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

        gaugechart1 : {
          graphicText:'2023 11月 收货及时率',
          dataValue:'98',
          url:"/dataview/ontimearrive"
        },
        gaugechart2 : {
          graphicText:'2023 11月 报检及时率',
          dataValue:'100',
          url:"/dataview/ontimeincheck"
        },

        gaugechart3 : {
          graphicText:'2023 11月 入库及时率',
          dataValue:'95',
          url:"/dataview/ontimeup"
        },


        gaugechart4 : {
          graphicText:'2023 11月 出库及时率',
          dataValue:'95',
          url:"/dataview/outbound"
        },


        gaugechart5 : {
          graphicText:'2023 11月 齐套率',
          dataValue:'94',
          url:"/dataview/completerate"
        },




        /* outboundData : {
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
           url:''
         },*/

        outboundData : {
          graphicText:'出库分析',
          categoryList: [],
          legendList: ['种类','同比'],
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
        workloadData : {
          graphicText:'平均工作量分析',
          categoryList: ['1','2','3','4','5','6','7','8','9','10','11','12'],
          legendList: [],
          bar1Name:'',
          bar1List:[],
          bar2Name:'',
          bar2List:[],
          bar3Name:'',
          bar3List:[],
          Y1max:'60'
        },
      }
    },
    created() {
      console.log("进入执行");
      this.getList();
    },
    methods: {
      getList() {
        this.loading = false;
        this.getInboundData();
        this.getOutboundData();
        this.getworkloadData();
      },

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

      getworkloadData() {
        this.loading = false;
        getWorkloadData().then(response => {
            this.workloadData.legendList = response.legendList[3];
            this.workloadData.bar1List = response.bar1List;
            this.workloadData.bar2List = response.bar2List;
            this.workloadData.bar3List = response.bar3List;
            this.workloadData.bar1Name = response.bar1Name;
            this.workloadData.bar2Name = response.bar2Name;
            this.workloadData.bar3Name = response.bar3Name;
          }
        );
      },
      handleChangeTime() {
        console.log(this.groupType);

        if(this.groupType=='month'){
          this.gaugechart1.graphicText='2023 11月 收货及时率';
          this.gaugechart2.graphicText='2023 11月 报检及时率';
          this.gaugechart3.graphicText='2023 11月 入库及时率';
          this.gaugechart4.graphicText='2023 11月 出库及时率';
          this.gaugechart5.graphicText='2023 11月 齐套率';
        }

        if(this.groupType=='week'){
          this.gaugechart1.graphicText='2023 47周 收货及时率';
          this.gaugechart2.graphicText='2023 47周 报检及时率';
          this.gaugechart3.graphicText='2023 47周 入库及时率';
          this.gaugechart4.graphicText='2023 47周 出库及时率';
          this.gaugechart5.graphicText='2023 47周 齐套率';
        }
        this.getworkloadData();
      },
      handleSetLineChartData(type) {

      },
      /** 跳转页面 */
      handleAuthRoom: function() {
        /* this.$router.push("/dataview/completerate/index");*/
      },
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
