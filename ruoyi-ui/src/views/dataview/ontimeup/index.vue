<template>
  <div class="dashboard-editor-container">
    <el-row style="padding:0px 0px 0;margin-bottom:20px; margin-top:5px;">
      <chart-date-picker v-model="value" :type.sync="groupType" @handleChangeTime="handleChangeTime(type=0,$event)"></chart-date-picker>
    </el-row>

    <el-row :gutter="32">
      <el-col :xs="32" :sm="32" :lg="32">
        <div class="chart-wrapper">
          <Ontime-chart :chart-data="inboundData" @handleSetInboundData="handleSetInboundKindData"/>        </div>
      </el-col>
    </el-row>

    <el-row :gutter="32">
      <el-col :xs="32" :sm="32" :lg="12">
        <div class="chart-wrapper">
          <OntimeUp-chart :chart-data="inbounddetailData" />
        </div>
      </el-col>

      <el-col :xs="32" :sm="32" :lg="12">
        <div class="chart-wrapper">
          <OntimeQtykindup-chart :chart-data="ontimeQtykindData"/>
        </div>
      </el-col>
    </el-row>

    <el-row :gutter="32">
      <el-col :xs="32" :sm="32" :lg="32">
        <div class="chart-wrapper">
          <el-table
            v-if="refreshTable"
            v-loading="loading"
            :data="deptList"
            :default-expand-all="isExpandAll"
          >
            <el-table-column prop="workDate" label="装箱单号" width="260"></el-table-column>
            <el-table-column prop="matCode" label="供应商" width="200"></el-table-column>
            <el-table-column prop="matName" label="入库数量" width="200"></el-table-column>
            <el-table-column prop="qty" label="入库日期" width="200"></el-table-column>
            <el-table-column prop="ziku" label="入库库房" width="200"></el-table-column>
            <el-table-column prop="collQty" label="入库状态" width="200"></el-table-column>
            <el-table-column prop="requirQty" label="采集人" width="200"></el-table-column>
          </el-table>
          <pagination
            v-show="total>0"
            :total="total"
            placement="center"
            :page.sync="queryParams.pageNum"
            :limit.sync="queryParams.pageSize"
            @pagination=""
          />
        </div>
      </el-col>


    </el-row>
  </div>
</template>

<script>
  import WorkoderChart from '../../dashboard/WorkoderChart'

  import LineChart from '../../dashboard/LineChart'
  import PanelGroup from '../../dashboard/PanelGroup'

  import InboundrateChart from '../../dashboard/InboundrateChart'

  import InboundqtyChart from '../../dashboard/InboundqtyChart'



  import RaddarChart from '../../dashboard/RaddarChart'
  import PieChart from '../../dashboard/PieChart'
  import BarChart from '../../dashboard/BarChart'

  import ChartDatePicker from '../../dashboard/ChartDatePicker'
  import OntimeChart from '../../dashboard/OntimeChart'
  import OntimeOrderChart from '../../dashboard/OntimeOrderChart'
  import OntimeQtykindChart from '../../dashboard/OntimeQtykindChart'
  import OntimeUpChart from '../../dashboard/OntimeUpChart'
  import OntimeQtykindupChart from '../../dashboard/OntimeQtykindupChart'



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
      WorkoderChart,
      LineChart,
      PanelGroup,
      InboundrateChart,
      InboundqtyChart,


      ChartDatePicker,
      OntimeChart,
      OntimeOrderChart,
      OntimeQtykindChart,
      OntimeUpChart,
      OntimeQtykindupChart

    },
    data() {
      return {

        total:100,
        inboundData : {
          graphicText:'入库及时率分析',
          categoryList: ['202301','202302','202303','202304','202305','202306','202307','202308','202309','202310','202311'],
          legendList: ['外库平库', '厂内立库','所有库房'],
          Y1max:'1',
          qtydataList: [0.98,0.96,0.98,0.96,0.98,0.96,0.98,0.96,0.98,0.96,0.98],
          kinddataList: [0.99,0.95,0.99,0.95,0.99,0.95,0.99,0.95,0.99,0.95,0.96],
          YOYqtyList: [0.98,0.96,0.98,0.96,0.98,0.96,0.98,0.96,0.98,0.96,0.98],
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
          graphicText:'到货装箱单',
          categoryList : ['外库平库', '厂内立库'],
          legendList: ['正常收货','延时收货'],
          yAxisname:'单数',
          qtydataList:[98,70],
          kinddataList:[2,1],
          Y1max:'100'
        },

        ontimeQtykindData : {
          graphicText:'收货种类数量',
          categoryList : ['外库平库', '厂内立库'],
          legendList: ['正常收货','延时收货'],
          yAxisname:'单数',
          qtydataList:[98,70],
          kinddataList:[2,1],
          Y1max:'100'
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
          {workDate:'ZXDS2311240142',matCode:'厦门唯恩电气有限公司',  matName:'1', qty:'2023-11-27',ziku:'厂内立库',collQty:'正常收货',requirQty:'**'},
          {workDate:'ZXDS2311220464',matCode:'北京金雨星技贸有限公司',matName:'45',qty:'2023-11-27',ziku:'外库平库',collQty:'正常收货',requirQty:'**'},
          {workDate:'ZXDS2311270146',matCode:'欧伏电气股份有限公司',  matName:'21',qty:'2023-11-27',ziku:'外库平库',collQty:'正常收货',requirQty:'**'},
          {workDate:'ZXDS2311270055',matCode:'欧伏电气股份有限公司',  matName:'10',qty:'2023-11-27',ziku:'外库平库',collQty:'正常收货',requirQty:'**'},
          {workDate:'ZXDS2311270059',matCode:'欧伏电气股份有限公司',  matName:'50',qty:'2023-11-27',ziku:'外库平库',collQty:'正常收货',requirQty:'**'}
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
        /*getInboundData().then(response => {
            this.inboundData.categoryList = response.categoryList;
            this.inboundData.qtydataList = response.qtydataList;
            this.inboundData.kinddataList = response.kinddataList;
            this.inboundData.YOYqtyList = response.YOYqtyList;
            this.inboundData.YOYkindList = response.YOYkindList;
            this.inboundData.Y1max = response.Y1max;
            this.inboundData.Y2max = response.Y2max;
          }
        );*/
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
        /*getInbounddetail(this.mode,this.year_month).then(response => {
            this.inbounddetailData.categoryList = response.categoryList;
            this.inbounddetailData.bar1List = response.bar1List;
            this.inbounddetailData.Y1max = response.Y1max;

            this.inboundrateData.categoryList = response.categoryList;
            this.inboundrateData.bar1List = response.bar2List;
          }
        );*/
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
