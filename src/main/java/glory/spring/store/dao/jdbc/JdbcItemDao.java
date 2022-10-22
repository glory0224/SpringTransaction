package glory.spring.store.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import glory.spring.store.dao.ItemDao;
import glory.spring.store.vo.Item;

public class JdbcItemDao implements ItemDao {
	
	private JdbcTemplate jdbcTemplate;
	
	public JdbcItemDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	

	@Override
	public Item findById(Integer itemId) {
		
		return jdbcTemplate.queryForObject("select * from ITEM where ITEM_ID = ?",
											new RowMapper<Item>() {

												@Override
												public Item mapRow(ResultSet rs, int row) throws SQLException {
													Item item = new Item();
													item.setId(rs.getInt("ITEM_ID"));
													item.setPrice(rs.getInt("PRICE"));
													return item;
												}
							
		}, new Object[] {itemId});
	}

}
