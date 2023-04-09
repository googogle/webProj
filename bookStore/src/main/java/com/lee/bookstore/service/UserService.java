package com.lee.bookstore.service;

import java.util.Map;

public interface UserService {

	Boolean join(Map<String, Object> map);

	Map<String, Object> login(Map<String, Object> map);



}
