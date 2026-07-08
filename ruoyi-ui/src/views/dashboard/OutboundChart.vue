<template>
  <div :class="className" :style="{height:height,width:width}"/>

</template>

<script>
  import * as echarts from 'echarts';

  require('echarts/theme/macarons') // echarts theme
  import resize from './mixins/resize'

  export default {
    mixins: [resize],
    props: {
      className: {
        type: String,
        default: 'chart'
      },
      width: {
        type: String,
        default: '100%'
      },
      height: {
        type: String,
        default: '300px'
      }
    },
    data() {
      return {
        chart: null
      }
    },
    mounted() {
      this.$nextTick(() => {
        this.initChart()
      })
    },
    beforeDestroy() {
      if (!this.chart) {
        return
      }
      this.chart.dispose()
      this.chart = null
    },
    methods: {
      initChart() {
        this.chart = echarts.init(this.$el, 'macarons')

        this.chart.setOption({

          tooltip: {
            trigger: 'axis',
            axisPointer: {
              type: 'cross',
              crossStyle: {
                color: '#999'
              }
            }
          },
          graphic: {
            type: "text",
            left: "center",
            bottom: "5",
            style: {
              text: "出库分析",
              textAlign: "center",
              fill: "#333",
              fontSize: 20,
              fontWeight: 700
            }
          },
          toolbox: {
            feature: {
              dataView: { show: true, readOnly: false },
              magicType: { show: true, type: ['line', 'bar'] },
              restore: { show: true },
              saveAsImage: { show: true }
            }
          },
          legend: {
            data: ['种类', '数量','种类同比','数量同比']
          },
          xAxis: [
            {
              type: 'category',
              data: ['2023-11','2023-10','2023-09','2023-08','2023-07','2023-06','2023-05','2023-04','2023-03','2023-02','2023-01','2022-12'],
              axisPointer: {
                type: 'shadow'
              }
            }
          ],
          yAxis: [
            {
              type: 'value',
              name: '数量',
              position: 'left',
              min: 0,
              max: 3462524,
              interval: 300000,
              axisLabel: {
                formatter: '{value}'
              }
            },
            {
              type: 'value',
              name: '种类',
              position: 'right',
              min: 0,
              max: 3943,
              interval: 300,
              axisLabel: {
                formatter: '{value}'
              }
            },
            {
              type: 'value',
              name: '同比',
              position: 'right',
              offset: 40, // y轴位置的偏移量
              min: -100,
              max: 150,
              interval: 30,
              axisLabel: {
                formatter: '{value}%'
              }
            }
          ],
          series: [
            {
              name: '数量',
              type: 'bar',
              itemStyle: {
                color: '#4A90E2',
                normal: {
                  label: {
                    show: true, //开启显示
                    position: 'top', //在上方显示
                    textStyle: {
                      //数值样式
                      color: 'black',
                      fontSize: 12,
                    },
                  },
                },
              },
              tooltip: {
                valueFormatter: function (value) {
                  return value + '';
                }
              },
              data: [
                576784,1448074.8,1228723,1417267.4,1299227,3462523.027,2708271.74,1304847.6,2361997.188,2007179.3,711463.8,1132162.77,1335783.12
              ]
            },
            /* {
               name: 'Precipitation',
               type: 'bar',
               tooltip: {
                 valueFormatter: function (value) {
                   return value + ' ml';
                 }
               },
               data: [
                 2.6, 5.9, 9.0, 26.4, 28.7, 70.7, 175.6, 182.2, 48.7, 18.8, 6.0, 2.3
               ]
             },*/
            {
              name: '种类',
              type: 'bar',
              yAxisIndex: 1,
              itemStyle: {
                color: '#14c8d4',
                normal: {
                  label: {
                    show: true, //开启显示
                    position: 'top', //在上方显示
                    textStyle: {
                      //数值样式
                      color: 'black',
                      fontSize: 12,
                    },
                  },
                },
              },
              tooltip: {
                valueFormatter: function (value) {
                  return value + '';
                }
              },
              data: [857,1941,1262,1983,1355,3943,3343,1666,2184,2607,1856,1746,1804]
            },
            {
              name: '种类同比',
              type: 'line',
              yAxisIndex: 2,
              itemStyle: {
                color: '#14d8d4',
                /*normal: {
                  label: {
                    show: true, //开启显示
                    position: 'top', //在上方显示
                    textStyle: {
                      //数值样式
                      color: 'black',
                      fontSize: 12,
                    },
                  },
                },*/
              },
              tooltip: {
                valueFormatter: function (value) {
                  return value + '%';
                }
              },
              data: [-52.49,-12.21,-37.34,-21,-53.23,42.5,17.3,-45.29,-49.35,-18.99,-24.03,-40.43,-44.46
              ]
            },
            {
              name: '数量同比',
              type: 'line',
              yAxisIndex: 2,
              itemStyle: {
                color: '#4A90E2',
                /*normal: {
                  label: {
                    show: true, //开启显示
                    position: 'top', //在上方显示
                    textStyle: {
                      //数值样式
                      color: 'black',
                      fontSize: 12,
                    },
                  },
                },*/
              },
              tooltip: {
                valueFormatter: function (value) {
                  return value + '%';
                }
              },
              data: [-56.82,-27.93,-68.68,-43.46,-43.63,68.52,87.81,0.95,-1.21,-39.53,-32.09,-29.04,-28.8]
            }
          ]
        })
      }
    }
  }
</script>

<style lang="scss" scoped>
  .panel-group {
    margin-top: 18px;

    .card-panel-col {
      margin-bottom: 32px;
    }

    .card-panel {
      height: 108px;
      cursor: pointer;
      font-size: 12px;
      position: relative;
      overflow: hidden;
      color: #666;
      background: #fff;
      box-shadow: 4px 4px 40px rgba(0, 0, 0, .05);
      border-color: rgba(0, 0, 0, .05);

      &:hover {
        .card-panel-icon-wrapper {
          color: #fff;
        }

        .icon-people {
          background: #40c9c6;
        }

        .icon-message {
          background: #36a3f7;
        }

        .icon-money {
          background: #f4516c;
        }

        .icon-shopping {
          background: #34bfa3
        }
      }

      .icon-people {
        color: #40c9c6;
      }

      .icon-message {
        color: #36a3f7;
      }

      .icon-money {
        color: #f4516c;
      }

      .icon-shopping {
        color: #34bfa3
      }

      .card-panel-icon-wrapper {
        float: left;
        margin: 14px 0 0 14px;
        padding: 16px;
        transition: all 0.38s ease-out;
        border-radius: 6px;
      }

      .card-panel-icon {
        float: left;
        font-size: 48px;
      }

      .card-panel-description {
        float: right;
        font-weight: bold;
        margin: 26px;
        margin-left: 0px;

        .card-panel-text {
          line-height: 18px;
          color: rgba(0, 0, 0, 0.45);
          font-size: 16px;
          margin-bottom: 12px;
        }

        .card-panel-num {
          font-size: 20px;
        }
      }
    }
  }

  @media (max-width:550px) {
    .card-panel-description {
      display: none;
    }

    .card-panel-icon-wrapper {
      float: none !important;
      width: 100%;
      height: 100%;
      margin: 0 !important;

      .svg-icon {
        display: block;
        margin: 14px auto !important;
        float: none !important;
      }
    }
  }
</style>
