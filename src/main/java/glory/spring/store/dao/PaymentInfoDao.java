package glory.spring.store.dao;

import glory.spring.store.vo.PaymentInfo;

public interface PaymentInfoDao {
	//결제 정보 저장
	void insert(PaymentInfo paymentInfo);
}
