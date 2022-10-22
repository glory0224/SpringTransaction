package glory.spring.store.dao;

import glory.spring.store.vo.Item;

public interface ItemDao {
	// 아이템 검색 
	Item findById(Integer itemId);
}
