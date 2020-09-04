CREATE DATABASE MANAGE_COMFERENCE;

USE  MANAGE_COMFERENCE;
create table HOINGHI (
   ID_HN                int                 not null  auto_increment,
   TEN_HN               nvarchar(50)        null,
   MOTA                 nvarchar(150)       null,
   MOTA_CHITIET         nvarchar(1000)     null,
   HINHANH              varchar(200)        null,
   THOIGIAN             datetime               null,
   ID_DIADIEM				int       null,
   constraint PK_HOINGHI primary key (ID_HN)
);

create table DIADIEM (
   ID_DD                int                not null  auto_increment,
   TEN_DD               nvarchar(50)        null,
   DIACHI               nvarchar(200)       null,
   SUCCHUA         		int    null,
   constraint PK_DIADIEM primary key (ID_DD)
);

create table  AD_USER(
   ID_ACCOUNT           int                  not null auto_increment,
   HOTEN            nvarchar(50)        null,
   USERNAME            nvarchar(50)        null,
   PASSWORD_Acc        	nvarchar(50)           null,
   EMAIL               varchar(50)         null,
   LOAI                bool 				null,
   constraint AD_USER primary key (ID_ACCOUNT)
);

create table  PARTICIPANTS(
	ID			int not null auto_increment,
   ID_PAR          int                  not null ,
   ID_COMFERENCE  int                  not null ,
   constraint PARTICIPANTS primary key ( ID )
);
create table  PARTICIPANTS_SIGNUP(
   ID			int not null auto_increment,
   ID_PAR          int                  not null ,
   ID_COMFERENCE  int                  not null ,
   constraint PARTICIPANTS primary key (ID)
);
alter table PARTICIPANTS
   add constraint FK_PAR_PARTICIPANTS foreign key (ID_PAR)
      references AD_USER (ID_ACCOUNT);

alter table PARTICIPANTS
   add constraint FK_COMF_PARTICIPANTS foreign key (ID_COMFERENCE)
      references HOINGHI (ID_HN);
      
alter table PARTICIPANTS_SIGNUP
   add constraint FK_PAR_PARTICIPANTS_SIGNUP foreign key (ID_PAR)
      references AD_USER (ID_ACCOUNT);

alter table PARTICIPANTS_SIGNUP
   add constraint FK_COMF_PARTICIPANTS_SIGNUP foreign key (ID_COMFERENCE)
      references HOINGHI (ID_HN);
      
alter table HOINGHI
   add constraint FK_DIADIEM_HOINGHI foreign key ( ID_DIADIEM)
      references DIADIEM (ID_DD);