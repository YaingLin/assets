/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2020/1/13 19:18:30                           */
/*==============================================================*/


drop table if exists car;

drop table if exists car_receive;

drop table if exists car_repair;

drop table if exists car_scrap;

drop table if exists car_type;

drop table if exists code_rule;

drop table if exists device;

drop table if exists device_receive;

drop table if exists device_repair;

drop table if exists device_scrap;

drop table if exists device_type;

drop table if exists dictionary;

drop table if exists furniture_book;

drop table if exists furniture_books_receive;

drop table if exists furniture_books_repair;

drop table if exists furniture_books_scrap;

drop table if exists furniture_books_type;

drop table if exists house;

drop table if exists house_receive;

drop table if exists land;

drop table if exists land_receive;

drop table if exists organization;

drop table if exists permission;

drop table if exists role;

drop table if exists role_permission;

drop table if exists user;

/*==============================================================*/
/* Table: car                                                   */
/*==============================================================*/
create table car
(
   id                   varchar(32) not null,
   ctid                 varchar(32) comment '车辆类型id',
   code                 varchar(7) comment '车辆流水号',
   residualrate         numeric(3,3) comment '净残值率',
   useyear              numeric(2,0) comment '使用年限',
   residual             numeric(16,2) comment '净值',
   original             numeric(16,2) comment '原值',
   status               numeric(2,0) comment '状态 1-入库、2-出库中、3-出库、4-领用、5-报修',
   proddate             varchar(32) comment '生产日期',
   creator              varchar(32) comment '登记人',
   createtime           varchar(32) comment '登记时间',
   buyer                varchar(32) comment '购买人',
   bugdate              varchar(32) comment '购买日期',
   sno                  varchar(32) comment '序列号',
   crtm                 varchar(32) comment '创建时间',
   mdtm                 varchar(32) comment '修改时间',
   primary key (id)
);

alter table car comment '车辆明细';

/*==============================================================*/
/* Table: car_receive                                           */
/*==============================================================*/
create table car_receive
(
   id                   varchar(32) not null,
   cid                  varchar(32) comment '车辆id',
   receipt              varchar(9) comment '单据号',
   recipients           varchar(32) comment '领用人',
   receivedate          varchar(32) comment '领取时间',
   returndate           varchar(32) comment '归还日期',
   status               numeric(1,0) comment '状态 1-领用、2-归还',
   receiveremarks       varchar(200) comment '领用备注',
   returnremarks        varchar(200) comment '归还备注',
   crtm                 varchar(32) comment '创建时间',
   mdtm                 varchar(32) comment '修改时间',
   primary key (id)
);

alter table car_receive comment '车辆领用表';

/*==============================================================*/
/* Table: car_repair                                            */
/*==============================================================*/
create table car_repair
(
   id                   varchar(32) not null,
   cid                  varchar(32) comment '车辆id',
   damager              varchar(32) comment '报修人',
   damagedate           varchar(32) comment '报修时间',
   damageremarks        varchar(200) comment '报修备注',
   repairdate           varchar(32) comment '维修时间',
   repairer             varchar(32) comment '维修人',
   repairremarks        varchar(200) comment '维修备注',
   status               numeric(1,0) comment '状态 1-报修、2-维修',
   crtm                 varchar(32) comment '创建时间',
   mdtm                 varchar(32) comment '修改时间',
   primary key (id)
);

alter table car_repair comment '车辆维修表';

/*==============================================================*/
/* Table: car_scrap                                             */
/*==============================================================*/
create table car_scrap
(
   id                   varchar(32) not null,
   cid                  varchar(32) comment '车辆id',
   scraper              varchar(32) comment '报废人',
   scraperdate          varchar(32) comment '报废日期',
   scrapremarks         varchar(200) comment '报废备注',
   status               numeric(1,0) comment '状态 1-申请、2-准许、3-拒绝',
   approver             varchar(32) comment '审批人',
   approvalremarks      varchar(200) comment '审批意见',
   approvaldate         varchar(32) comment '申请日期',
   crtm                 varchar(32) comment '创建时间',
   mdtm                 varchar(32) comment '修改时间',
   primary key (id)
);

alter table car_scrap comment '车辆报废';

/*==============================================================*/
/* Table: car_type                                              */
/*==============================================================*/
create table car_type
(
   id                   varchar(32) not null,
   name                 varchar(50) comment '名字',
   brand                varchar(100) comment '品牌',
   intlcode             varchar(100) comment '国际编号',
   model                varchar(100) comment '型号',
   specifications       varchar(100) comment '规格',
   remarks              varchar(200) comment '备注',
   crtm                 varchar(32) comment '创建时间',
   mdtm                 varchar(32) comment '修改时间',
   primary key (id)
);

alter table car_type comment '车辆类型';

/*==============================================================*/
/* Table: code_rule                                             */
/*==============================================================*/
create table code_rule
(
   id                   varchar(32) not null,
   name                 varchar(50) comment '名字',
   rule                 varchar(50) comment '规则表达式',
   current              varchar(300) comment '当前流水号',
   remarks              varchar(200) comment '备注',
   crtm                 varchar(32) comment '创建时间',
   mdtm                 varchar(32) comment '修改时间',
   primary key (id)
);

alter table code_rule comment '流水号规则表';

/*==============================================================*/
/* Table: device                                                */
/*==============================================================*/
create table device
(
   id                   varchar(32) not null,
   dtid                 varchar(32) comment '设备类型id',
   code                 varchar(7) comment '设备流水号',
   residualrate         numeric(3,3) comment '净残值率',
   useyear              numeric(2,0) comment '使用年限',
   residual             numeric(16,2) comment '净值',
   original             numeric(16,2) comment '原值',
   status               numeric(2,0) comment '状态 1-入库、2-出库中、3-出库、4-领用、5-报修',
   proddate             varchar(32) comment '生产日期',
   creator              varchar(32) comment '登记人',
   createtime           varchar(32) comment '登记时间',
   buyer                varchar(32) comment '购买人',
   bugdate              varchar(32) comment '购买日期',
   sno                  varchar(32) comment '序列号',
   crtm                 varchar(32) comment '创建时间',
   mdtm                 varchar(32) comment '修改时间',
   primary key (id)
);

alter table device comment '设备明细';

/*==============================================================*/
/* Table: device_receive                                        */
/*==============================================================*/
create table device_receive
(
   id                   varchar(32) not null,
   did                  varchar(32) comment '设备id',
   receipt              varchar(9) comment '单据号',
   recipients           varchar(32) comment '领用人',
   receivedate          varchar(32) comment '领取时间',
   returndate           varchar(32) comment '归还日期',
   status               numeric(1,0) comment '状态 1-领用、2-归还',
   receiveremarks       varchar(200) comment '领用备注',
   returnremarks        varchar(200) comment '归还备注',
   crtm                 varchar(32) comment '创建时间',
   mdtm                 varchar(32) comment '修改时间',
   primary key (id)
);

alter table device_receive comment '设备领用表';

/*==============================================================*/
/* Table: device_repair                                         */
/*==============================================================*/
create table device_repair
(
   id                   varchar(32) not null,
   did                  varchar(32) comment '设备id',
   damager              varchar(32) comment '报修人',
   damagedate           varchar(32) comment '报修时间',
   damageremarks        varchar(200) comment '报修备注',
   repairdate           varchar(32) comment '维修时间',
   repairer             varchar(32) comment '维修人',
   repairremarks        varchar(200) comment '维修备注',
   status               numeric(1,0) comment '状态 1-报修、2-维修',
   crtm                 varchar(32) comment '创建时间',
   mdtm                 varchar(32) comment '修改时间',
   primary key (id)
);

alter table device_repair comment '设备维修表';

/*==============================================================*/
/* Table: device_scrap                                          */
/*==============================================================*/
create table device_scrap
(
   id                   varchar(32) not null,
   did                  varchar(32) comment '设备id',
   scraper              varchar(32) comment '报废人',
   scraperdate          varchar(32) comment '报废日期',
   scrapremarks         varchar(200) comment '报废备注',
   status               numeric(1,0) comment '状态 1-申请、2-准许、3-拒绝',
   approver             varchar(32) comment '审批人',
   approvalremarks      varchar(200) comment '审批意见',
   approvaldate         varchar(32) comment '申请日期',
   crtm                 varchar(32) comment '创建时间',
   mdtm                 varchar(32) comment '修改时间',
   primary key (id)
);

alter table device_scrap comment '设备报废';

/*==============================================================*/
/* Table: device_type                                           */
/*==============================================================*/
create table device_type
(
   id                   varchar(32) not null,
   name                 varchar(50) comment '名字',
   brand                varchar(100) comment '品牌',
   intlcode             varchar(100) comment '国际编号',
   model                varchar(100) comment '型号',
   remarks              varchar(200) comment '备注',
   crtm                 varchar(32) comment '创建时间',
   mdtm                 varchar(32) comment '修改时间',
   primary key (id)
);

alter table device_type comment '设备类型';

/*==============================================================*/
/* Table: dictionary                                            */
/*==============================================================*/
create table dictionary
(
   id                   varchar(32) not null,
   dkey                 varchar(50) comment '键',
   dvalue               varchar(500) comment '值',
   crtm                 varchar(32) comment '创建时间',
   mdtm                 varchar(32) comment '修改时间',
   primary key (id)
);

alter table dictionary comment '数据字典';

/*==============================================================*/
/* Table: furniture_book                                        */
/*==============================================================*/
create table furniture_book
(
   id                   varchar(32) not null,
   fbtid                varchar(32) comment '家具图书类型id',
   code                 varchar(7) comment '家具图书流水号',
   name                 varchar(50) comment '名字',
   residualrate         numeric(3,3) comment '净残值率',
   useyear              numeric(2,0) comment '使用年限',
   residual             numeric(16,2) comment '净值',
   original             numeric(16,2) comment '原值',
   status               numeric(2,0) comment '状态 1-入库、2-出库中、3-出库、4-领用、5-报修',
   proddate             varchar(32) comment '生产日期',
   creator              varchar(32) comment '登记人',
   createtime           varchar(32) comment '登记时间',
   buyer                varchar(32) comment '购买人',
   bugdate              varchar(32) comment '购买日期',
   sno                  varchar(32) comment '序列号',
   crtm                 varchar(32) comment '创建时间',
   mdtm                 varchar(32) comment '修改时间',
   primary key (id)
);

alter table furniture_book comment '家具图书明细';

/*==============================================================*/
/* Table: furniture_books_receive                               */
/*==============================================================*/
create table furniture_books_receive
(
   id                   varchar(32) not null,
   fbid                 varchar(32) comment '家具图书id',
   receipt              varchar(9) comment '单据号',
   recipients           varchar(32) comment '领用人',
   receivedate          varchar(32) comment '领取时间',
   returndate           varchar(32) comment '归还日期',
   status               numeric(1,0) comment '状态 1-领用、2-归还',
   receiveremarks       varchar(200) comment '领用备注',
   returnremarks        varchar(200) comment '归还备注',
   crtm                 varchar(32) comment '创建时间',
   mdtm                 varchar(32) comment '修改时间',
   primary key (id)
);

alter table furniture_books_receive comment '家具图书领用表';

/*==============================================================*/
/* Table: furniture_books_repair                                */
/*==============================================================*/
create table furniture_books_repair
(
   id                   varchar(32) not null,
   fbid                 varchar(32) comment '家具图书id',
   damager              varchar(32) comment '报修人',
   damagedate           varchar(32) comment '报修时间',
   damageremarks        varchar(200) comment '报修备注',
   repairdate           varchar(32) comment '维修时间',
   repairer             varchar(32) comment '维修人',
   repairremarks        varchar(200) comment '维修备注',
   status               numeric(1,0) comment '状态 1-报修、2-维修',
   crtm                 varchar(32) comment '创建时间',
   mdtm                 varchar(32) comment '修改时间',
   primary key (id)
);

alter table furniture_books_repair comment '家具图书维修表';

/*==============================================================*/
/* Table: furniture_books_scrap                                 */
/*==============================================================*/
create table furniture_books_scrap
(
   id                   varchar(32) not null,
   fbid                 varchar(32) comment '家具图书id',
   scraper              varchar(32) comment '报废人',
   scraperdate          varchar(32) comment '报废日期',
   scrapremarks         varchar(200) comment '报废备注',
   status               numeric(1,0) comment '状态 1-申请、2-准许、3-拒绝',
   approver             varchar(32) comment '审批人',
   approvalremarks      varchar(200) comment '审批意见',
   approvaldate         varchar(32) comment '申请日期',
   crtm                 varchar(32) comment '创建时间',
   mdtm                 varchar(32) comment '修改时间',
   primary key (id)
);

alter table furniture_books_scrap comment '家具图书报废';

/*==============================================================*/
/* Table: furniture_books_type                                  */
/*==============================================================*/
create table furniture_books_type
(
   id                   varchar(32) not null,
   type                 int(1) comment '类型：1、家具   2、图书',
   name                 varchar(50) comment '名字',
   brand                varchar(100) comment '品牌/出版社',
   intlcode             varchar(100) comment '国际编号',
   remarks              varchar(200) comment '备注',
   crtm                 varchar(32) comment '创建时间',
   mdtm                 varchar(32) comment '修改时间',
   primary key (id)
);

alter table furniture_books_type comment '家具图书类型';

/*==============================================================*/
/* Table: house                                                 */
/*==============================================================*/
create table house
(
   id                   varchar(32) not null,
   owner                varchar(100) comment '屋主
            ',
   property             varchar(100) comment '房屋性质',
   address              varchar(100) comment '房屋位置
            ',
   area                 double(10,4) comment '房屋面积
            ',
   service_life         varchar(20) comment '使用期限
            ',
   remarks              varchar(200) comment '备注信息',
   status               int comment '房屋状态：0、闲置  1、已分配  2、其他',
   crtm                 varchar(32) comment '创建时间',
   mdtm                 varchar(32) comment '修改时间',
   primary key (id)
);

alter table house comment '房屋明细';

/*==============================================================*/
/* Table: house_receive                                         */
/*==============================================================*/
create table house_receive
(
   id                   varchar(32) not null,
   hid                  varchar(32) comment '房屋id
            ',
   oid                  varchar(32) comment '分配单位
            ',
   creator              varchar(32) comment '登记用户',
   remarks              varchar(200) comment '备注
            ',
   crtm                 varchar(32) comment '创建时间',
   mdtm                 varchar(32) comment '修改时间',
   primary key (id)
);

alter table house_receive comment '房屋分配情况';

/*==============================================================*/
/* Table: land                                                  */
/*==============================================================*/
create table land
(
   id                   varchar(32) not null,
   property             varchar(100) comment '土地性质',
   address              varchar(100) comment '土地位置
            ',
   area                 double(10,4) comment '土地面积
            ',
   service_life         varchar(20) comment '使用期限
            ',
   remarks              varchar(200) comment '备注信息',
   status               int comment '土地状态：0、闲置  1、已分配  2、其他',
   crtm                 varchar(32) comment '创建时间',
   mdtm                 varchar(32) comment '修改时间',
   primary key (id)
);

alter table land comment '土地明细';

/*==============================================================*/
/* Table: land_receive                                          */
/*==============================================================*/
create table land_receive
(
   id                   varchar(32) not null,
   lid                  varchar(32) comment '土地编号
            ',
   oid                  varchar(32) comment '分配单位
            ',
   creator              varchar(32) comment '登记用户',
   remarks              varchar(200) comment '备注
            ',
   crtm                 varchar(32) comment '创建时间',
   mdtm                 varchar(32) comment '修改时间',
   primary key (id)
);

alter table land_receive comment '土地分配情况';

/*==============================================================*/
/* Table: organization                                          */
/*==============================================================*/
create table organization
(
   id                   varchar(32) not null,
   pid                  varchar(32) comment '父级id',
   name                 varchar(50) comment '名字',
   remarks              varchar(200) comment '备注',
   sort                 numeric comment '排序',
   level                numeric comment '等级',
   crtm                 varchar(32) comment '创建时间',
   mdtm                 varchar(32) comment '修改时间',
   primary key (id)
);

alter table organization comment '组织机构';

/*==============================================================*/
/* Table: permission                                            */
/*==============================================================*/
create table permission
(
   id                   varchar(32) not null,
   pid                  varchar(32) comment '父级id',
   name                 varchar(50) comment '名字',
   url                  varchar(500) comment 'url',
   sort                 numeric(8,0) comment '序号',
   remarks              varchar(200) comment '备注',
   level                numeric comment '等级',
   crtm                 varchar(32) comment '创建时间',
   mdtm                 varchar(32) comment '修改时间',
   primary key (id)
);

alter table permission comment '权限';

/*==============================================================*/
/* Table: role                                                  */
/*==============================================================*/
create table role
(
   id                   varchar(32) not null,
   name                 varchar(50) comment '名字',
   remarks              varchar(200) comment '备注',
   crtm                 varchar(32) comment '创建时间',
   mdtm                 varchar(32) comment '修改时间',
   primary key (id)
);

alter table role comment '角色';

/*==============================================================*/
/* Table: role_permission                                       */
/*==============================================================*/
create table role_permission
(
   id                   varchar(32) not null,
   rid                  varchar(32) comment '角色id',
   pid                  varchar(32) comment '权限id',
   primary key (id)
);

alter table role_permission comment '角色权限中间表';

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
create table user
(
   id                   varchar(32) not null,
   rid                  varchar(32) comment '角色id',
   ogid                 varchar(32) comment '组织机构id',
   name                 varchar(50) comment '姓名',
   pwd                  varchar(50) comment '密码',
   sex                  numeric(8,0) comment '性别 1-男、2-女',
   birth                varchar(20) comment '生日',
   phone                varchar(11) comment '手机',
   email                varchar(500) comment '邮件',
   logintime            varchar(20) comment '登录时间',
   loginip              varchar(500) comment '登录ip',
   crtm                 varchar(32) comment '创建时间',
   mdtm                 varchar(32) comment '修改时间',
   primary key (id)
);

alter table user comment '用户';

alter table car add constraint FK_Reference_10 foreign key (buyer)
      references user (id) on delete restrict on update restrict;

alter table car add constraint FK_Reference_5 foreign key (ctid)
      references car_type (id) on delete restrict on update restrict;

alter table car add constraint FK_Reference_9 foreign key (creator)
      references user (id) on delete restrict on update restrict;

alter table car_receive add constraint FK_Reference_6 foreign key (cid)
      references car (id) on delete restrict on update restrict;

alter table car_repair add constraint FK_Reference_7 foreign key (cid)
      references car (id) on delete restrict on update restrict;

alter table car_scrap add constraint FK_Reference_8 foreign key (cid)
      references car (id) on delete restrict on update restrict;

alter table device add constraint FK_Reference_11 foreign key (creator)
      references user (id) on delete restrict on update restrict;

alter table device add constraint FK_Reference_12 foreign key (buyer)
      references user (id) on delete restrict on update restrict;

alter table device add constraint FK_Reference_13 foreign key (dtid)
      references device_type (id) on delete restrict on update restrict;

alter table device_receive add constraint FK_Reference_14 foreign key (did)
      references device (id) on delete restrict on update restrict;

alter table device_repair add constraint FK_Reference_16 foreign key (did)
      references device (id) on delete restrict on update restrict;

alter table device_scrap add constraint FK_Reference_15 foreign key (did)
      references device (id) on delete restrict on update restrict;

alter table furniture_book add constraint FK_Reference_23 foreign key (fbtid)
      references furniture_books_type (id) on delete restrict on update restrict;

alter table furniture_book add constraint FK_Reference_24 foreign key (creator)
      references user (id) on delete restrict on update restrict;

alter table furniture_book add constraint FK_Reference_25 foreign key (buyer)
      references user (id) on delete restrict on update restrict;

alter table furniture_books_receive add constraint FK_Reference_26 foreign key (fbid)
      references furniture_book (id) on delete restrict on update restrict;

alter table furniture_books_repair add constraint FK_Reference_28 foreign key (fbid)
      references furniture_book (id) on delete restrict on update restrict;

alter table furniture_books_scrap add constraint FK_Reference_27 foreign key (fbid)
      references furniture_book (id) on delete restrict on update restrict;

alter table house_receive add constraint FK_Reference_17 foreign key (id)
      references house (id) on delete restrict on update restrict;

alter table house_receive add constraint FK_Reference_19 foreign key (oid)
      references organization (id) on delete restrict on update restrict;

alter table house_receive add constraint FK_Reference_20 foreign key (creator)
      references user (id) on delete restrict on update restrict;

alter table land_receive add constraint FK_Reference_18 foreign key (id)
      references land (id) on delete restrict on update restrict;

alter table land_receive add constraint FK_Reference_21 foreign key (oid)
      references organization (id) on delete restrict on update restrict;

alter table land_receive add constraint FK_Reference_22 foreign key (creator)
      references user (id) on delete restrict on update restrict;

alter table role_permission add constraint FK_Reference_3 foreign key (rid)
      references role (id) on delete restrict on update restrict;

alter table role_permission add constraint FK_Reference_4 foreign key (pid)
      references permission (id) on delete restrict on update restrict;

alter table user add constraint FK_Reference_1 foreign key (rid)
      references role (id) on delete restrict on update restrict;

alter table user add constraint FK_Reference_2 foreign key (ogid)
      references organization (id) on delete restrict on update restrict;

