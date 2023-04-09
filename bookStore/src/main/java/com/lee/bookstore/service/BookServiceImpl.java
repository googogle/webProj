package com.lee.bookstore.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.lee.bookstore.BookDAO;

@Service
public class BookServiceImpl implements BookService {
	@Autowired
	BookDAO bookDAO;

	@Override
	public String create(Map<String, Object> map) {
		int affectRowCount = this.bookDAO.insert(map);
		if (affectRowCount == 1) {
			return map.get("book_id").toString();
		}
		return null;
	}

	@Override
	public Map<String, Object> detail(Map<String, Object> map) {
		return this.bookDAO.selectDetail(map);
	}

	@Override
	public boolean edit(Map<String, Object> map) {
		int affectRowCount = this.bookDAO.update(map);
		return affectRowCount == 1;
	}

	@Override
	public boolean remove(Map<String, Object> map) {
		int affectRowCount = this.bookDAO.delete(map);
		return affectRowCount == 1;
	}

	@Override
	public List<Map<String, Object>> list(Map<String, Object> map) {
		return this.bookDAO.selectList(map);
	}

	@Override
	public Map<String, Object> search(Map<String, Object> map) {
		return this.bookDAO.search(map);
	}

}
