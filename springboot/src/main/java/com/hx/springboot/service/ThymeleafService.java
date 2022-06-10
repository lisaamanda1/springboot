package com.hx.springboot.service;

import java.util.List;
import java.util.Map;

public interface ThymeleafService {
	
	public List<Map<String, Object>> queryList();

	public void saveUser(Map<String, Object> user);

	public void deleteUser(int id);

	public Map<String, Object> queryUserById(int id);

	public void updateUser(Map<String, Object> user);
	
}
