# 金风科技 WMS 仓储管理系统

> 基于 RuoYi-Vue v3.8.5 二次开发的仓储管理系统 (Warehouse Management System)
>
> **描述来源**：`pom.xml → <description>金风科技WMS系统</description>`

---

## 一、项目概览

| 项       | 值                                                          |
| -------- | ----------------------------------------------------------- |
| 项目名称 | ruoyi (金风科技 WMS 系统)                                   |
| 版本     | 3.8.5                                                       |
| 基础框架 | RuoYi-Vue（若依前后端分离版）                               |
| 后端     | Spring Boot 2.5.14 + Spring Security + MyBatis + JWT        |
| 前端     | Vue 2 + Element UI 2.15 + ECharts 5.4 + Axios               |
| 数据库   | MySQL（`sql/ry_20220822.sql`, `sql/quartz.sql`），Druid 连接池 |
| 缓存     | Redis                                                       |
| 定时任务 | Quartz                                                      |
| Java     | 1.8                                                         |
| 构建     | Maven（父 POM 多模块）                                      |

在线体验（原若依演示环境）：http://vue.ruoyi.vip ｜ 文档：http://doc.ruoyi.vip

---

## 二、目录结构

```
RuoYi-Vue-master/
├── ruoyi-admin        # 启动模块 / Web 层：所有 Controller、application.yml
├── ruoyi-framework    # 框架核心：Security、AOP、数据源、拦截器、Web 配置
├── ruoyi-system       # 业务系统模块：WMS + 若依 System 的 Domain/Mapper/Service
├── ruoyi-quartz       # 定时任务模块（quartz 调度）
├── ruoyi-generator    # 代码生成器
├── ruoyi-common       # 通用工具、注解、常量、异常、Redis、XSS 等
├── ruoyi-ui           # Vue 前端工程（源码 + 已 build 的 dist）
├── sql/               # 建库脚本（ry_20220822.sql、quartz.sql）
├── doc/               # 使用手册（若依环境使用手册.docx）
├── bin/               # 启动、清理、打包脚本
├── ry.bat / ry.sh     # 一键启动脚本
├── pom.xml            # Maven 父 POM
└── README.md          # 若依原始 README
```

---

## 三、后端模块职责

### 1. `ruoyi-admin` — 应用入口
- `com.ruoyi.RuoYiApplication`：Spring Boot 启动类。
- `com.ruoyi.web.controller.system` 中除若依原生的 `SysUser/Menu/Role/Dept/Dict/Config/...` 之外，新增的 **WMS 业务控制器**：
  - `BigScreenDataController` — 大屏数据聚合
  - `PushController` — 消息 / 数据推送
  - `StoreroomController` — 库房管理
  - `SysTerminalController` — 终端（RF/PDA）管理
  - `SysMessageController` — 站内消息
  - `ZxdController` — 专项定制接口
- `ruoyi-admin/src/main/java/com/ruoyi/web/controller/tool/TestController.java` — 测试接口。
- `resources/application.yml`：主配置（端口 **8086**，含文件上传路径 `D:/ruoyi/uploadPath`）。
- `resources/application-druid.yml`：Druid 数据源配置。
- `resources/mybatis/mybatis-config.xml`：MyBatis 全局配置；XxxMapper.xml 分散在各模块的 `resources/mapper` 下。

### 2. `ruoyi-system` — 业务领域（WMS 核心）
`com.ruoyi.system.domain` 下共 **66 个实体类**，除若依内建 `Sys*` 外，WMS 领域实体覆盖以下环节：

| 业务域    | 主要实体                                                                                                    |
| --------- | ----------------------------------------------------------------------------------------------------------- |
| 到货/收货 | `ArrivalsBill`, `ArrivalsDetail`, `ArrivalsAbnormal`, `ArrivalsBillChecker`, `ArrivalsDetailColl`           |
| 入库      | `Inorder`, `Intask`, `Intaskitem`, `Incollectdata`, `Inproof`, `UpShelvesInfo`, `UpShelvesInfoReq`          |
| 出库      | `Outorder`, `Outbill`, `Outtask`, `Outtaskitem`, `Outcollectdata`, `Outproof`, `Outpallet`, `Outsubinventory` |
| 库位/库房 | `Storeroom`, `Storesite`, `Sterrooutexit`, `Repertory`                                                      |
| 托盘/物料 | `Pallet`, `PalletItem`, `BindingTrayInfo`, `PmMaterial`, `MaterialQty`, `ItemListInfo`, `InventoryInfo`     |
| 移库/下架 | `Moveinout`, `Moveout`, `DownShelvesInfo`, `ExceptShelvesInfo`, `TransferInfo`                              |
| 盘点/异常 | `Checkbill`, `Checktask`, `Checkcollectdata`, `InvCheckInfos`, `Expcollectdata`, `IpqcRes`                  |
| 领料      | `DrawmaterialRfBill`, `DrawmaterialRfBillItem`                                                              |
| 接口/集成 | `CuxWmsOrderHeaderInterface`（Oracle EBS 接口）、`InterfaceWmsToWcs`（WCS 对接）、`DcConnect`, `MtlSenderInfo` |
| 排队/其他 | `BbQueue`, `Tuser`                                                                                          |

每个 domain 均有对应 `Mapper`、`IXxxService` + `XxxServiceImpl`，以及 `resources/mapper/system/*.xml`。

### 3. `ruoyi-framework` — 基础设施
- `security/` — Spring Security + JWT（`TokenService`、`JwtAuthenticationTokenFilter`）
- `datasource/` — 多数据源切换（`DynamicDataSource`）
- `aspectj/` — 日志 / 数据权限 / 数据脱敏切面
- `interceptor/` — 全局重复提交拦截
- `config/` — Web、Druid、Swagger、CORS、异步线程池等 Bean 配置
- `manager/` — 异步任务调度容器（`AsyncManager`）

### 4. `ruoyi-common` — 通用能力
`annotation / config / constant / core / domin / enums / exception / filter / redis / utils / xss` 等基础包。

### 5. `ruoyi-quartz` — 定时任务
`config/controller/domain/mapper/service/task/util` 完整实现 Quartz 集群调度，用于同步 EBS 单据、超时预警、报表汇总等场景。

### 6. `ruoyi-generator` — 代码生成器
Velocity 模板一键生成 Controller/Service/Mapper/Vue 页面。

---

## 四、前端结构（`ruoyi-ui`）

```
src/views/
├── dashboard/       # 首页大屏与业务图表 (28 个 ECharts 组件)
│   ├── InboundChart / InboundqtyChart / InboundrateChart / InbounddetailChart
│   ├── OutboundChart
│   ├── OntimeChart / OntimeCheckChart / OntimeOrderChart / OntimeUpChart / OntimeQtykind*Chart
│   ├── WorkloadChart / WorkloadChart2 / WorkdetailChart / WorkdetailrateChart / WorkoderChart
│   ├── PanelGroup / GaugeChart / BarChart / LineChart / PieChart / RaddarChart
│   └── ChartDatePicker
├── dataview/        # 二级大屏页面
│   ├── indexNew        # 大屏主页
│   ├── inbound         # 入库看板
│   ├── outbound        # 出库看板
│   ├── ontimearrive    # 到货及时率
│   ├── ontimeincheck   # 入检及时率
│   ├── ontimeup        # 上架及时率
│   └── completerate    # 完工率
├── system/          # 若依系统管理页面
│   ├── user / role / menu / dept / post / dict / config / notice / storeroom
├── monitor/         # 服务/缓存/在线用户监控
├── tool/            # Swagger、代码生成、表单构建
├── index.vue        # 主布局（含 index_bk / index_bk2 备份）
├── login.vue / register.vue / redirect.vue
└── error/           # 401 / 404 页面
```

主要依赖：`vue 2 + element-ui 2.15.10 + echarts 5.4.0 + axios 0.24 + vue-cli-service`。
构建：`npm run dev`（开发）｜ `npm run build:prod`（生产）；`dist/` 已内置一份预打包结果。

---

## 五、启动方式

### 1. 数据库
```bash
mysql> source sql/ry_20220822.sql        # 若依基础表
mysql> source sql/quartz.sql             # 定时任务表
# WMS 业务表脚本由项目内其他 *.sql 文件（如 fill_unit_name.sql / split_and_aggregate.sql）补齐
```

### 2. Redis
本地启动 Redis（默认 `localhost:6379`，密码 `123456`，可在 `application.yml` 修改）。

### 3. 后端
```bash
# Windows
ry.bat
# Linux / Git Bash
./ry.sh
# 或直接
mvn clean package -Dmaven.test.skip=true
java -jar ruoyi-admin/target/ruoyi-admin.jar
```
服务端口：**8086** ｜ 上传路径：`D:/ruoyi/uploadPath`（Linux 改为 `/home/ruoyi/uploadPath`）。

### 4. 前端
```bash
cd ruoyi-ui
npm install --registry=https://registry.npmmirror.com
npm run dev            # 开发：http://localhost:80
npm run build:prod     # 生产打包
```
默认演示账号：`admin / admin123`。

---

## 六、与原版 RuoYi 的差异

1. **定位变更**：由通用后台管理框架 → 面向金风科技的仓储管理系统（WMS）。
2. **业务模块新增**：`ruoyi-system` 加入近 60 个 WMS 领域实体（收/发/存/盘/移/异常/接口）。
3. **接口集成**：包含与 **Oracle EBS**（`CuxWmsOrderHeaderInterface`）和 **WCS**（`InterfaceWmsToWcs`）的双向数据接口。
4. **终端支持**：`SysTerminalController` + RF/PDA 交互相关表（`Drawmaterial*`, `*collectdata`）。
5. **数据可视化**：前端新增大量业务看板、大屏、及时率/完工率/工作量图表组件。
6. **推送/消息**：`PushController` + `GeTuiUtilsService`（个推）用于消息推送。
7. **首页定制**：`views/index.vue` 与备份文件 `index_bk.vue / index_bk2.vue` 说明首页经过多轮改版。

---

## 七、辅助 SQL / 脚本

| 文件                        | 用途                                     |
| --------------------------- | ---------------------------------------- |
| `check_cdc_detailed.sql`    | 排查 CDC 变更数据捕获                    |
| `fill_unit_name.sql`        | 批量回填单位名称                         |
| `split_and_aggregate.sql`   | 数据拆分与聚合脚本                       |
| `sql/ry_20220822.sql`       | 若依基础系统表建库脚本                   |
| `sql/quartz.sql`            | Quartz 定时任务调度表                    |

---

## 八、参考与备注

- **原若依文档**：http://doc.ruoyi.vip ｜ 源仓库：https://gitee.com/y_project/RuoYi-Vue
- **本地手册**：`doc/若依环境使用手册.docx`
- **License**：MIT（见 `LICENSE`）。
- Java 8 + Spring Boot 2.5.14 语料，如需升级 JDK 17 / Spring Boot 3 需重新评估 Swagger、Druid、fastjson2、jjwt 等依赖兼容性。
- 项目根目录内的 `hs_err_pid25896.log` 与 `replay_pid25896.log` 为历史 JVM 崩溃日志，可在清理时移除。

---

_最近提交：`35d5e16 wms服务端初始化`（分支：`main`）_
