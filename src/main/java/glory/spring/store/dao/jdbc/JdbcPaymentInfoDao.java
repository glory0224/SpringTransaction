package glory.spring.store.dao.jdbc;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import glory.spring.store.dao.PaymentInfoDao;
import glory.spring.store.vo.PaymentInfo;

public class JdbcPaymentInfoDao implements PaymentInfoDao {

	private SimpleJdbcInsert insert;
	private NamedParameterJdbcTemplate namedJdbcTemplate;
	
	
	
	public JdbcPaymentInfoDao(SimpleJdbcInsert insert) {
		this.insert = insert;
		insert.withTableName("PAYMENT_INFO").usingColumns("PAYMENT_INFO_ID", "PRICE");
	}

	

	public void setNamedJdbcTemplate(NamedParameterJdbcTemplate namedJdbcTemplate) {
		this.namedJdbcTemplate = namedJdbcTemplate;
	}
	
	
	// seq 증가 메소드 
	public int nextVal() {
		return namedJdbcTemplate.queryForObject("select payment_seq.nextval from dual", Collections.emptyMap(), Integer.class);
	}




	@Override
	public void insert(PaymentInfo paymentInfo) {
		Map<String, Object> paramValueMap = new HashMap<String, Object>();
		paymentInfo.setId(nextVal());
		paramValueMap.put("PAYMENT_INFO_ID", paymentInfo.getId());
		paramValueMap.put("PRICE", paymentInfo.getPrice());
		insert.execute(paramValueMap); // SimpleJdbcInsert 클래스 이용 
	}

	
}