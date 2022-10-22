package glory.spring.store.vo;

/*
 
PURCHASE_ORDER TABLE

CREATE table PURCHASE_ORDER (
PURCHASE_ORDER_ID NUMBER(5,0) NOT NULL,
ITEM_ID NUMBER(5,0) NOT NULL,
PAYMENT_INFO_ID NUMBER(5,0) NOT NULL,
ADDRESS VARCHAR2(20) NOT NULL,
constraint PURCHASE_ORDER_PK primary key (PURCHASE_ORDER_ID)
);

시퀀스

create sequence PURCHASE_SEQ start with 1 increment by 1 
maxvalue 99999 nocache nocycle noorder;
 
 
*/


public class PurchaseOrder {
	private Integer id;
	private Integer itemId;
	private String address;
	private Integer paymentInfoId;
	
	public PurchaseOrder() {
	}

	public PurchaseOrder(Integer itemId, String address, Integer paymentInfoId) {
		this.itemId = itemId;
		this.address = address;
		this.paymentInfoId = paymentInfoId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getPaymentInfoId() {
		return paymentInfoId;
	}

	public void setPaymentInfoId(Integer paymentInfoId) {
		this.paymentInfoId = paymentInfoId;
	}
	
	
}
