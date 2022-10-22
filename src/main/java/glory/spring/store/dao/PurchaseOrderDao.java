package glory.spring.store.dao;

import glory.spring.store.vo.PurchaseOrder;

// 구매 주문 결과 저장
public interface PurchaseOrderDao {
	void insert(PurchaseOrder order);
}
