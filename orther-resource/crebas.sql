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
   ctid                 varchar(32) comment '��������id',
   code                 varchar(7) comment '������ˮ��',
   residualrate         numeric(3,3) comment '����ֵ��',
   useyear              numeric(2,0) comment 'ʹ������',
   residual             numeric(16,2) comment '��ֵ',
   original             numeric(16,2) comment 'ԭֵ',
   status               numeric(2,0) comment '״̬ 1-��⡢2-�����С�3-���⡢4-���á�5-����',
   proddate             varchar(32) comment '��������',
   creator              varchar(32) comment '�Ǽ���',
   createtime           varchar(32) comment '�Ǽ�ʱ��',
   buyer                varchar(32) comment '������',
   bugdate              varchar(32) comment '��������',
   sno                  varchar(32) comment '���к�',
   crtm                 varchar(32) comment '����ʱ��',
   mdtm                 varchar(32) comment '�޸�ʱ��',
   primary key (id)
);

alter table car comment '������ϸ';

/*==============================================================*/
/* Table: car_receive                                           */
/*==============================================================*/
create table car_receive
(
   id                   varchar(32) not null,
   cid                  varchar(32) comment '����id',
   receipt              varchar(9) comment '���ݺ�',
   recipients           varchar(32) comment '������',
   receivedate          varchar(32) comment '��ȡʱ��',
   returndate           varchar(32) comment '�黹����',
   status               numeric(1,0) comment '״̬ 1-���á�2-�黹',
   receiveremarks       varchar(200) comment '���ñ�ע',
   returnremarks        varchar(200) comment '�黹��ע',
   crtm                 varchar(32) comment '����ʱ��',
   mdtm                 varchar(32) comment '�޸�ʱ��',
   primary key (id)
);

alter table car_receive comment '�������ñ�';

/*==============================================================*/
/* Table: car_repair                                            */
/*==============================================================*/
create table car_repair
(
   id                   varchar(32) not null,
   cid                  varchar(32) comment '����id',
   damager              varchar(32) comment '������',
   damagedate           varchar(32) comment '����ʱ��',
   damageremarks        varchar(200) comment '���ޱ�ע',
   repairdate           varchar(32) comment 'ά��ʱ��',
   repairer             varchar(32) comment 'ά����',
   repairremarks        varchar(200) comment 'ά�ޱ�ע',
   status               numeric(1,0) comment '״̬ 1-���ޡ�2-ά��',
   crtm                 varchar(32) comment '����ʱ��',
   mdtm                 varchar(32) comment '�޸�ʱ��',
   primary key (id)
);

alter table car_repair comment '����ά�ޱ�';

/*==============================================================*/
/* Table: car_scrap                                             */
/*==============================================================*/
create table car_scrap
(
   id                   varchar(32) not null,
   cid                  varchar(32) comment '����id',
   scraper              varchar(32) comment '������',
   scraperdate          varchar(32) comment '��������',
   scrapremarks         varchar(200) comment '���ϱ�ע',
   status               numeric(1,0) comment '״̬ 1-���롢2-׼��3-�ܾ�',
   approver             varchar(32) comment '������',
   approvalremarks      varchar(200) comment '�������',
   approvaldate         varchar(32) comment '��������',
   crtm                 varchar(32) comment '����ʱ��',
   mdtm                 varchar(32) comment '�޸�ʱ��',
   primary key (id)
);

alter table car_scrap comment '��������';

/*==============================================================*/
/* Table: car_type                                              */
/*==============================================================*/
create table car_type
(
   id                   varchar(32) not null,
   name                 varchar(50) comment '����',
   brand                varchar(100) comment 'Ʒ��',
   intlcode             varchar(100) comment '���ʱ��',
   model                varchar(100) comment '�ͺ�',
   specifications       varchar(100) comment '���',
   remarks              varchar(200) comment '��ע',
   crtm                 varchar(32) comment '����ʱ��',
   mdtm                 varchar(32) comment '�޸�ʱ��',
   primary key (id)
);

alter table car_type comment '��������';

/*==============================================================*/
/* Table: code_rule                                             */
/*==============================================================*/
create table code_rule
(
   id                   varchar(32) not null,
   name                 varchar(50) comment '����',
   rule                 varchar(50) comment '������ʽ',
   current              varchar(300) comment '��ǰ��ˮ��',
   remarks              varchar(200) comment '��ע',
   crtm                 varchar(32) comment '����ʱ��',
   mdtm                 varchar(32) comment '�޸�ʱ��',
   primary key (id)
);

alter table code_rule comment '��ˮ�Ź����';

/*==============================================================*/
/* Table: device                                                */
/*==============================================================*/
create table device
(
   id                   varchar(32) not null,
   dtid                 varchar(32) comment '�豸����id',
   code                 varchar(7) comment '�豸��ˮ��',
   residualrate         numeric(3,3) comment '����ֵ��',
   useyear              numeric(2,0) comment 'ʹ������',
   residual             numeric(16,2) comment '��ֵ',
   original             numeric(16,2) comment 'ԭֵ',
   status               numeric(2,0) comment '״̬ 1-��⡢2-�����С�3-���⡢4-���á�5-����',
   proddate             varchar(32) comment '��������',
   creator              varchar(32) comment '�Ǽ���',
   createtime           varchar(32) comment '�Ǽ�ʱ��',
   buyer                varchar(32) comment '������',
   bugdate              varchar(32) comment '��������',
   sno                  varchar(32) comment '���к�',
   crtm                 varchar(32) comment '����ʱ��',
   mdtm                 varchar(32) comment '�޸�ʱ��',
   primary key (id)
);

alter table device comment '�豸��ϸ';

/*==============================================================*/
/* Table: device_receive                                        */
/*==============================================================*/
create table device_receive
(
   id                   varchar(32) not null,
   did                  varchar(32) comment '�豸id',
   receipt              varchar(9) comment '���ݺ�',
   recipients           varchar(32) comment '������',
   receivedate          varchar(32) comment '��ȡʱ��',
   returndate           varchar(32) comment '�黹����',
   status               numeric(1,0) comment '״̬ 1-���á�2-�黹',
   receiveremarks       varchar(200) comment '���ñ�ע',
   returnremarks        varchar(200) comment '�黹��ע',
   crtm                 varchar(32) comment '����ʱ��',
   mdtm                 varchar(32) comment '�޸�ʱ��',
   primary key (id)
);

alter table device_receive comment '�豸���ñ�';

/*==============================================================*/
/* Table: device_repair                                         */
/*==============================================================*/
create table device_repair
(
   id                   varchar(32) not null,
   did                  varchar(32) comment '�豸id',
   damager              varchar(32) comment '������',
   damagedate           varchar(32) comment '����ʱ��',
   damageremarks        varchar(200) comment '���ޱ�ע',
   repairdate           varchar(32) comment 'ά��ʱ��',
   repairer             varchar(32) comment 'ά����',
   repairremarks        varchar(200) comment 'ά�ޱ�ע',
   status               numeric(1,0) comment '״̬ 1-���ޡ�2-ά��',
   crtm                 varchar(32) comment '����ʱ��',
   mdtm                 varchar(32) comment '�޸�ʱ��',
   primary key (id)
);

alter table device_repair comment '�豸ά�ޱ�';

/*==============================================================*/
/* Table: device_scrap                                          */
/*==============================================================*/
create table device_scrap
(
   id                   varchar(32) not null,
   did                  varchar(32) comment '�豸id',
   scraper              varchar(32) comment '������',
   scraperdate          varchar(32) comment '��������',
   scrapremarks         varchar(200) comment '���ϱ�ע',
   status               numeric(1,0) comment '״̬ 1-���롢2-׼��3-�ܾ�',
   approver             varchar(32) comment '������',
   approvalremarks      varchar(200) comment '�������',
   approvaldate         varchar(32) comment '��������',
   crtm                 varchar(32) comment '����ʱ��',
   mdtm                 varchar(32) comment '�޸�ʱ��',
   primary key (id)
);

alter table device_scrap comment '�豸����';

/*==============================================================*/
/* Table: device_type                                           */
/*==============================================================*/
create table device_type
(
   id                   varchar(32) not null,
   name                 varchar(50) comment '����',
   brand                varchar(100) comment 'Ʒ��',
   intlcode             varchar(100) comment '���ʱ��',
   model                varchar(100) comment '�ͺ�',
   remarks              varchar(200) comment '��ע',
   crtm                 varchar(32) comment '����ʱ��',
   mdtm                 varchar(32) comment '�޸�ʱ��',
   primary key (id)
);

alter table device_type comment '�豸����';

/*==============================================================*/
/* Table: dictionary                                            */
/*==============================================================*/
create table dictionary
(
   id                   varchar(32) not null,
   dkey                 varchar(50) comment '��',
   dvalue               varchar(500) comment 'ֵ',
   crtm                 varchar(32) comment '����ʱ��',
   mdtm                 varchar(32) comment '�޸�ʱ��',
   primary key (id)
);

alter table dictionary comment '�����ֵ�';

/*==============================================================*/
/* Table: furniture_book                                        */
/*==============================================================*/
create table furniture_book
(
   id                   varchar(32) not null,
   fbtid                varchar(32) comment '�Ҿ�ͼ������id',
   code                 varchar(7) comment '�Ҿ�ͼ����ˮ��',
   name                 varchar(50) comment '����',
   residualrate         numeric(3,3) comment '����ֵ��',
   useyear              numeric(2,0) comment 'ʹ������',
   residual             numeric(16,2) comment '��ֵ',
   original             numeric(16,2) comment 'ԭֵ',
   status               numeric(2,0) comment '״̬ 1-��⡢2-�����С�3-���⡢4-���á�5-����',
   proddate             varchar(32) comment '��������',
   creator              varchar(32) comment '�Ǽ���',
   createtime           varchar(32) comment '�Ǽ�ʱ��',
   buyer                varchar(32) comment '������',
   bugdate              varchar(32) comment '��������',
   sno                  varchar(32) comment '���к�',
   crtm                 varchar(32) comment '����ʱ��',
   mdtm                 varchar(32) comment '�޸�ʱ��',
   primary key (id)
);

alter table furniture_book comment '�Ҿ�ͼ����ϸ';

/*==============================================================*/
/* Table: furniture_books_receive                               */
/*==============================================================*/
create table furniture_books_receive
(
   id                   varchar(32) not null,
   fbid                 varchar(32) comment '�Ҿ�ͼ��id',
   receipt              varchar(9) comment '���ݺ�',
   recipients           varchar(32) comment '������',
   receivedate          varchar(32) comment '��ȡʱ��',
   returndate           varchar(32) comment '�黹����',
   status               numeric(1,0) comment '״̬ 1-���á�2-�黹',
   receiveremarks       varchar(200) comment '���ñ�ע',
   returnremarks        varchar(200) comment '�黹��ע',
   crtm                 varchar(32) comment '����ʱ��',
   mdtm                 varchar(32) comment '�޸�ʱ��',
   primary key (id)
);

alter table furniture_books_receive comment '�Ҿ�ͼ�����ñ�';

/*==============================================================*/
/* Table: furniture_books_repair                                */
/*==============================================================*/
create table furniture_books_repair
(
   id                   varchar(32) not null,
   fbid                 varchar(32) comment '�Ҿ�ͼ��id',
   damager              varchar(32) comment '������',
   damagedate           varchar(32) comment '����ʱ��',
   damageremarks        varchar(200) comment '���ޱ�ע',
   repairdate           varchar(32) comment 'ά��ʱ��',
   repairer             varchar(32) comment 'ά����',
   repairremarks        varchar(200) comment 'ά�ޱ�ע',
   status               numeric(1,0) comment '״̬ 1-���ޡ�2-ά��',
   crtm                 varchar(32) comment '����ʱ��',
   mdtm                 varchar(32) comment '�޸�ʱ��',
   primary key (id)
);

alter table furniture_books_repair comment '�Ҿ�ͼ��ά�ޱ�';

/*==============================================================*/
/* Table: furniture_books_scrap                                 */
/*==============================================================*/
create table furniture_books_scrap
(
   id                   varchar(32) not null,
   fbid                 varchar(32) comment '�Ҿ�ͼ��id',
   scraper              varchar(32) comment '������',
   scraperdate          varchar(32) comment '��������',
   scrapremarks         varchar(200) comment '���ϱ�ע',
   status               numeric(1,0) comment '״̬ 1-���롢2-׼��3-�ܾ�',
   approver             varchar(32) comment '������',
   approvalremarks      varchar(200) comment '�������',
   approvaldate         varchar(32) comment '��������',
   crtm                 varchar(32) comment '����ʱ��',
   mdtm                 varchar(32) comment '�޸�ʱ��',
   primary key (id)
);

alter table furniture_books_scrap comment '�Ҿ�ͼ�鱨��';

/*==============================================================*/
/* Table: furniture_books_type                                  */
/*==============================================================*/
create table furniture_books_type
(
   id                   varchar(32) not null,
   type                 int(1) comment '���ͣ�1���Ҿ�   2��ͼ��',
   name                 varchar(50) comment '����',
   brand                varchar(100) comment 'Ʒ��/������',
   intlcode             varchar(100) comment '���ʱ��',
   remarks              varchar(200) comment '��ע',
   crtm                 varchar(32) comment '����ʱ��',
   mdtm                 varchar(32) comment '�޸�ʱ��',
   primary key (id)
);

alter table furniture_books_type comment '�Ҿ�ͼ������';

/*==============================================================*/
/* Table: house                                                 */
/*==============================================================*/
create table house
(
   id                   varchar(32) not null,
   owner                varchar(100) comment '����
            ',
   property             varchar(100) comment '��������',
   address              varchar(100) comment '����λ��
            ',
   area                 double(10,4) comment '�������
            ',
   service_life         varchar(20) comment 'ʹ������
            ',
   remarks              varchar(200) comment '��ע��Ϣ',
   status               int comment '����״̬��0������  1���ѷ���  2������',
   crtm                 varchar(32) comment '����ʱ��',
   mdtm                 varchar(32) comment '�޸�ʱ��',
   primary key (id)
);

alter table house comment '������ϸ';

/*==============================================================*/
/* Table: house_receive                                         */
/*==============================================================*/
create table house_receive
(
   id                   varchar(32) not null,
   hid                  varchar(32) comment '����id
            ',
   oid                  varchar(32) comment '���䵥λ
            ',
   creator              varchar(32) comment '�Ǽ��û�',
   remarks              varchar(200) comment '��ע
            ',
   crtm                 varchar(32) comment '����ʱ��',
   mdtm                 varchar(32) comment '�޸�ʱ��',
   primary key (id)
);

alter table house_receive comment '���ݷ������';

/*==============================================================*/
/* Table: land                                                  */
/*==============================================================*/
create table land
(
   id                   varchar(32) not null,
   property             varchar(100) comment '��������',
   address              varchar(100) comment '����λ��
            ',
   area                 double(10,4) comment '�������
            ',
   service_life         varchar(20) comment 'ʹ������
            ',
   remarks              varchar(200) comment '��ע��Ϣ',
   status               int comment '����״̬��0������  1���ѷ���  2������',
   crtm                 varchar(32) comment '����ʱ��',
   mdtm                 varchar(32) comment '�޸�ʱ��',
   primary key (id)
);

alter table land comment '������ϸ';

/*==============================================================*/
/* Table: land_receive                                          */
/*==============================================================*/
create table land_receive
(
   id                   varchar(32) not null,
   lid                  varchar(32) comment '���ر��
            ',
   oid                  varchar(32) comment '���䵥λ
            ',
   creator              varchar(32) comment '�Ǽ��û�',
   remarks              varchar(200) comment '��ע
            ',
   crtm                 varchar(32) comment '����ʱ��',
   mdtm                 varchar(32) comment '�޸�ʱ��',
   primary key (id)
);

alter table land_receive comment '���ط������';

/*==============================================================*/
/* Table: organization                                          */
/*==============================================================*/
create table organization
(
   id                   varchar(32) not null,
   pid                  varchar(32) comment '����id',
   name                 varchar(50) comment '����',
   remarks              varchar(200) comment '��ע',
   sort                 numeric comment '����',
   level                numeric comment '�ȼ�',
   crtm                 varchar(32) comment '����ʱ��',
   mdtm                 varchar(32) comment '�޸�ʱ��',
   primary key (id)
);

alter table organization comment '��֯����';

/*==============================================================*/
/* Table: permission                                            */
/*==============================================================*/
create table permission
(
   id                   varchar(32) not null,
   pid                  varchar(32) comment '����id',
   name                 varchar(50) comment '����',
   url                  varchar(500) comment 'url',
   sort                 numeric(8,0) comment '���',
   remarks              varchar(200) comment '��ע',
   level                numeric comment '�ȼ�',
   crtm                 varchar(32) comment '����ʱ��',
   mdtm                 varchar(32) comment '�޸�ʱ��',
   primary key (id)
);

alter table permission comment 'Ȩ��';

/*==============================================================*/
/* Table: role                                                  */
/*==============================================================*/
create table role
(
   id                   varchar(32) not null,
   name                 varchar(50) comment '����',
   remarks              varchar(200) comment '��ע',
   crtm                 varchar(32) comment '����ʱ��',
   mdtm                 varchar(32) comment '�޸�ʱ��',
   primary key (id)
);

alter table role comment '��ɫ';

/*==============================================================*/
/* Table: role_permission                                       */
/*==============================================================*/
create table role_permission
(
   id                   varchar(32) not null,
   rid                  varchar(32) comment '��ɫid',
   pid                  varchar(32) comment 'Ȩ��id',
   primary key (id)
);

alter table role_permission comment '��ɫȨ���м��';

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
create table user
(
   id                   varchar(32) not null,
   rid                  varchar(32) comment '��ɫid',
   ogid                 varchar(32) comment '��֯����id',
   name                 varchar(50) comment '����',
   pwd                  varchar(50) comment '����',
   sex                  numeric(8,0) comment '�Ա� 1-�С�2-Ů',
   birth                varchar(20) comment '����',
   phone                varchar(11) comment '�ֻ�',
   email                varchar(500) comment '�ʼ�',
   logintime            varchar(20) comment '��¼ʱ��',
   loginip              varchar(500) comment '��¼ip',
   crtm                 varchar(32) comment '����ʱ��',
   mdtm                 varchar(32) comment '�޸�ʱ��',
   primary key (id)
);

alter table user comment '�û�';

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

