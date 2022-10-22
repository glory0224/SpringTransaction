<!-- 오라클 테이블 정보 정리 -->

<!-- 물건 정보 --> 

CREATE table ITEM (
ITEM_ID NUMBER(5,0) NOT NULL,
ITEM_NAME VARCHAR2(20),
PRICE NUMBER(5,0) NOT NULL,
constraint ITEM_PK primary key (ITEM_ID)
);

create sequence ITEM_SEQ start with 1 increment by 1 maxvalue 99999 
nocache nocycle noorder;

insert into item values (item_seq.nextval, '노트북', 50000);
insert into item values (item_seq.nextval, '모니터', 30000);
insert into item values (item_seq.nextval, '외장하드', 10000);
commit;

drop table ITEM;
drop sequence ITEM_SEQ;

<!-- 결제 정보 -->

CREATE table PAYMENT_INFO (
PAYMENT_INFO_ID NUMBER(5,0) NOT NULL,
PRICE NUMBER(5,0) NOT NULL,
constraint PAYMENT_INFO_PK primary key (PAYMENT_INFO_ID)
);

create sequence PAYMENT_SEQ start with 1 increment by 1 maxvalue 99999
nocache nocycle noorder;

drop table PAYMENT_INFO;
drop sequence PAYMENT_SEQ;

<!-- 구매 목록 -->

CREATE table PURCHASE_ORDER (
PURCHASE_ORDER_ID NUMBER(5,0) NOT NULL,
ITEM_ID NUMBER(5,0) NOT NULL,
PAYMENT_INFO_ID NUMBER(5,0) NOT NULL,
ADDRESS VARCHAR2(100) NOT NULL,
constraint PURCHASE_ORDER_PK primary key (PURCHASE_ORDER_ID)
);

create sequence PURCHASE_SEQ start with 1 increment by 1 
maxvalue 99999 nocache nocycle noorder;

drop table PURCHASE_ORDER;
drop sequence PURCHASE_SEQ;

<!-- 롤백을 위한 중복 데이터 삽입 -->
insert into purchase_order values(2, 1, 100, '서울 중구');
commit;
insert into purchase_order values(4, 1, 100, '서울 중구');
commit;
insert into purchase_order values(6, 1, 100, '서울 동작구');
commit;