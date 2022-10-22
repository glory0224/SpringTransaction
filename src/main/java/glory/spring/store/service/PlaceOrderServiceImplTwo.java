package glory.spring.store.service;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import glory.spring.store.dao.ItemDao;
import glory.spring.store.dao.PaymentInfoDao;
import glory.spring.store.dao.PurchaseOrderDao;
import glory.spring.store.vo.Item;
import glory.spring.store.vo.ItemNotFoundException;
import glory.spring.store.vo.PaymentInfo;
import glory.spring.store.vo.PurchaseOrder;
import glory.spring.store.vo.PurchaseOrderRequest;
import glory.spring.store.vo.PurchaseOrderResult;

public class PlaceOrderServiceImplTwo implements PlaceOrderService {

	private ItemDao itemDao;
	private PaymentInfoDao paymentInfoDao;
	private PurchaseOrderDao purchaseOrderDao;
	private TransactionTemplate transactionTemplate;
	
	//setter 생성 
	public void setItemDao(ItemDao itemDao) {
		this.itemDao = itemDao;
	}




	public void setPaymentInfoDao(PaymentInfoDao paymentInfoDao) {
		this.paymentInfoDao = paymentInfoDao;
	}




	public void setPurchaseOrderDao(PurchaseOrderDao purchaseOrderDao) {
		this.purchaseOrderDao = purchaseOrderDao;
	}




	public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
	}




	@Override
	public PurchaseOrderResult order(PurchaseOrderRequest orderRequest) throws ItemNotFoundException {
		return transactionTemplate.execute(new TransactionCallback<PurchaseOrderResult>() {

			@Override
			public PurchaseOrderResult doInTransaction(TransactionStatus status) {
				Item item = itemDao.findById(orderRequest.getItemId());
				if(item == null) 
					throw new ItemNotFoundException(orderRequest.getItemId());
				
				PaymentInfo paymentInfo = new PaymentInfo(item.getPrice());
				paymentInfoDao.insert(paymentInfo);
				
				PurchaseOrder order = new PurchaseOrder(
						item.getId(), orderRequest.getAddress(), paymentInfo.getId());
				
				purchaseOrderDao.insert(order);
				
				return new PurchaseOrderResult(item, paymentInfo, order);
			}
		});
	}

}
