package glory.spring.store.vo;

// 아이템을 찾지 못하는 경우의 사용자 정의 예외 
// Spring에서는 기본적으로 Exception은 트랜잭셕을 수행하지 않고 RuntimeException만 수행한다. 
public class ItemNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private Integer itemId;
	
	public ItemNotFoundException(Integer itemId) {
		super("not found item : id = " + itemId);
		this.itemId = itemId;
	}

	public Integer getItemId() {
		return itemId;
	}
	

}
