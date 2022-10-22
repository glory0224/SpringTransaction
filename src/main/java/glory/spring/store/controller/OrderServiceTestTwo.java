package glory.spring.store.controller;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import glory.spring.store.service.PlaceOrderService;
import glory.spring.store.vo.PurchaseOrderRequest;
import glory.spring.store.vo.PurchaseOrderResult;

public class OrderServiceTestTwo {
	private PlaceOrderService placeOrderService;
	private AbstractApplicationContext context;
	public OrderServiceTestTwo() {
		// 배열로 가져올 때, 여러개의 xml 파일을 가져올 수 있다. 
	String[] configLocations = new String[] { "applicationcontext.xml","transactionTwo.xml" };
	context = new ClassPathXmlApplicationContext(configLocations);
	placeOrderService = (PlaceOrderService) 
	context.getBean("placeOrderService");
	
	}
	
	public void order() {
		PurchaseOrderRequest orderRequest = new PurchaseOrderRequest();
		orderRequest.setItemId(2);
		orderRequest.setAddress("서울 강남구");
		PurchaseOrderResult orderResult = placeOrderService.order(orderRequest);
		System.out.println("주문상태 정보");
		System.out.println("아이템 : " + orderResult.getItem().getId());
		System.out.println("가격 : " + orderResult.getPaymentInfo().getPrice());
		}
	
	public void close() {
		context.close();
		}
	
	public static void main(String[] args) {
		OrderServiceTestTwo test = new OrderServiceTestTwo();
		test.order();
		test.close();
	}

}
