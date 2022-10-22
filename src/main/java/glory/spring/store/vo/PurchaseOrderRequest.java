package glory.spring.store.vo;

// 구매 주문 요구사항
public class PurchaseOrderRequest {
	private Integer itemId;
	private String address;
	public Integer getItemId() {
		return itemId;
	}
	public String getAddress() {
		return address;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
