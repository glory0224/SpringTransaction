package glory.spring.store.service;

import org.springframework.transaction.annotation.Transactional;

import glory.spring.store.dao.ItemDao;
import glory.spring.store.dao.PaymentInfoDao;
import glory.spring.store.dao.PurchaseOrderDao;
import glory.spring.store.vo.Item;
import glory.spring.store.vo.ItemNotFoundException;
import glory.spring.store.vo.PaymentInfo;
import glory.spring.store.vo.PurchaseOrder;
import glory.spring.store.vo.PurchaseOrderRequest;
import glory.spring.store.vo.PurchaseOrderResult;

public class PlaceOrderServiceImplThree implements PlaceOrderService {
	private ItemDao itemDao;
	private PaymentInfoDao paymentInfoDao;
	private PurchaseOrderDao purchaseOrderDao;
	public void setItemDao(ItemDao itemDao) {
	this.itemDao = itemDao;
	}
	public void setPaymentInfoDao(PaymentInfoDao paymentInformationDao) {
	this.paymentInfoDao = paymentInformationDao;
	}
	public void setPurchaseOrderDao(PurchaseOrderDao purchaseOrderDao) {
	this.purchaseOrderDao = purchaseOrderDao;
	}
	
	// 어노테이션 방식 이용 
	@Override
	@Transactional
	public PurchaseOrderResult order(PurchaseOrderRequest orderRequest) throws ItemNotFoundException {
		// 구매한 아이템의 id를 넣어준다.
				Item item = itemDao.findById(orderRequest.getItemId());
				// 만약 아이템이 없으면 사용자 예외 처리 
				if(item == null) 
					throw new ItemNotFoundException(orderRequest.getItemId());
				
				PaymentInfo paymentInfo = new PaymentInfo(item.getPrice());
				paymentInfoDao.insert(paymentInfo);
				
				PurchaseOrder order = new PurchaseOrder(
						item.getId(), orderRequest.getAddress(), paymentInfo.getId());
				
				purchaseOrderDao.insert(order);
				
				return new PurchaseOrderResult(item, paymentInfo, order);
	}

}
