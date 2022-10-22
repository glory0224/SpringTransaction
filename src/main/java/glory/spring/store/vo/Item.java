package glory.spring.store.vo;

/*
 * ITEM TABLE

CREATE table ITEM (
ITEM_ID NUMBER(5,0) NOT NULL,
ITEM_NAME VARCHAR2(20),
PRICE NUMBER(5,0) NOT NULL,
constraint ITEM_PK primary key (ITEM_ID)
);

시퀀스 

create sequence ITEM_SEQ start with 1 increment by 1 maxvalue 99999 
nocache nocycle noorder;

샘플 데이터 

insert into item values (item_seq.nextval, '노트북', 50000);
insert into item values (item_seq.nextval, '모니터', 30000);
insert into item values (item_seq.nextval, '외장하드', 10000);
commit;


 */


public class Item {
	private Integer id;
	private String name;
	private int price;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
