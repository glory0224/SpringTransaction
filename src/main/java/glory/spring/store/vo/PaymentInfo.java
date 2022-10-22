package glory.spring.store.vo;

/*

 PAYMENT_INFO TABLE
 
CREATE table PAYMENT_INFO (
PAYMENT_INFO_ID NUMBER(5,0) NOT NULL,
PRICE NUMBER(5,0) NOT NULL,
constraint PAYMENT_INFO_PK primary key (PAYMENT_INFO_ID)
);

시퀀스 

create sequence PAYMENT_SEQ start with 1 increment by 1 maxvalue 99999
nocache nocycle noorder;


*/

public class PaymentInfo {
	private Integer id;
	private int price;
	
	public PaymentInfo() {
	}

	public PaymentInfo(int price) {
		this.price = price;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
