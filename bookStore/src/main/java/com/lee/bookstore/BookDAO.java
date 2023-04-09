package com.lee.bookstore;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookDAO {
	@Autowired
	SqlSessionTemplate sqlSellionTemlate;

	public int insert(Map<String, Object> map) {
		return this.sqlSellionTemlate.insert("book.insert", map);
	}

	public Map<String, Object> selectDetail(Map<String, Object> map) {
		return this.sqlSellionTemlate.selectOne("book.select_detail", map);
	}

	public int update(Map<String, Object> map) {
		return this.sqlSellionTemlate.update("book.update", map);
	}

	public int delete(Map<String, Object> map) {
		return this.sqlSellionTemlate.delete("book.delete", map);
	}

	public List<Map<String, Object>> selectList(Map<String, Object> map) {
		return this.sqlSellionTemlate.selectList("book.select_list", map);
	}
	
	public Map<String, Object> search(Map<String, Object> map) {
		return this.sqlSellionTemlate.selectOne("book.search", map);
	}
}
