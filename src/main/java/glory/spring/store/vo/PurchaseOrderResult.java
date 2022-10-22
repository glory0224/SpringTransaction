package glory.spring.store.vo;

public class PurchaseOrderResult {
	private Item item;
	private PaymentInfo paymentInfo;
	private PurchaseOrder order;
	
	public PurchaseOrderResult(Item item, PaymentInfo paymentInfo, PurchaseOrder order) {
		this.item = item;
		this.paymentInfo = paymentInfo;
		this.order = order;
	}

	public Item getItem() {
		return item;
	}

	public PaymentInfo getPaymentInfo() {
		return paymentInfo;
	}

	public PurchaseOrder getOrder() {
		return order;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public void setPaymentInfo(PaymentInfo paymentInfo) {
		this.paymentInfo = paymentInfo;
	}

	public void setOrder(PurchaseOrder order) {
		this.order = order;
	}
	
	
}
