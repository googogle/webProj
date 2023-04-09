package com.lee.bookstore;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO {
	@Autowired
	SqlSessionTemplate sqlSellionTemlate;
	
	public int join(Map<String, Object> map) {
		return this.sqlSellionTemlate.insert("user.join", map);
	}
	
	public Map<String,Object> login(Map<String,Object> map) {
		return this.sqlSellionTemlate.selectOne("user.login", map);
	}
}
