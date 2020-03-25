### 使用说明

#### 一、环境准备
  本项目基于jdk8以及gradle4.0以上版本
  1.此demo使用前需要先本地安装好mysql数据库,并手动创建maxrocky库(mysql 账号/密码 root/123456)
  2.在数据库中执行src -> main -> resources -> schema-maxrocky.sql 中的sql语句
  3.在idea中安装lombok插件
  4. File -> setting -> Annotation Processors  中 勾选Enable annotation processing
  5.启动项目,在浏览器中访问 http://localhost:8088/swagger-ui.html

#### 二、项目说明
  本项目仅作参考,具体规范可根据各项目组实际要求做调整,其中包含分页、异常、swagger、lombok等常用工具编写demo
  ##### java
  src -> main -> java -> com -> maxrocky -> common -> utils  此目录为项目常用工具类，可熟悉。
  src -> main -> java -> com -> maxrocky -> controller       此目录编写controller层业务逻辑
  src -> main -> java -> com -> maxrocky -> service          此目录编写service层业务逻辑
  src -> main -> java -> com -> maxrocky -> repository       此目录编写repository层业务逻辑
  src -> main -> java -> com -> maxrocky -> entity           此目录存放实体类
  ##### resources
  src -> main -> resource -> application.yml                 配置文件
  src -> main -> resource -> exception.properties            异常信息编写
  src -> main -> resource -> readme.txt                      说明书

#### 三、其他
VO:给前端需要展示的数据
DTO:代表需要前端传过来,要接受的数据
PO:与数据库做交互的类
