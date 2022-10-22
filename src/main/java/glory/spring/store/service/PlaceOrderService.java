package glory.spring.store.service;

import glory.spring.store.vo.ItemNotFoundException;
import glory.spring.store.vo.PurchaseOrderRequest;
import glory.spring.store.vo.PurchaseOrderResult;

//구매 서비스 추상화 
public interface PlaceOrderService {
	public PurchaseOrderResult order(PurchaseOrderRequest orderRequest)
											throws ItemNotFoundException;
}
