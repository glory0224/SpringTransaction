package glory.spring.store.controller;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import glory.spring.store.service.PlaceOrderService;
import glory.spring.store.vo.PurchaseOrderRequest;
import glory.spring.store.vo.PurchaseOrderResult;

public class OrderServiceTestOne {
	
	private PlaceOrderService placeOrderService;
	private AbstractApplicationContext context;
	
	public OrderServiceTestOne() {
		String[] configLocations = new String[] { "transactionOne.xml"};
		context = new ClassPathXmlApplicationContext(configLocations);
		placeOrderService = (PlaceOrderService) context.getBean("placeOrderService");
				
	}

	public void order() {
		PurchaseOrderRequest orderRequest = new PurchaseOrderRequest();
		orderRequest.setItemId(1);
		orderRequest.setAddress("인천광역시 연수구");
		PurchaseOrderResult orderResult = placeOrderService.order(orderRequest);
		System.out.println("주문상태 정보");
		System.out.println("아이템 : " + orderResult.getItem().getId());
		System.out.println("가격 : " + orderResult.getPaymentInfo().getPrice());
		System.out.println("원격 커밋 테스트 확인용 ");
	}
	
	public void close() {
		context.close();
	}
	
	
	public static void main(String[] args) {
		OrderServiceTestOne test = new OrderServiceTestOne();
		test.order();
		test.close();
	}

}
