package com.hx.springboot.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hx.springboot.dao.ThymeleafDao;
import com.hx.springboot.service.ThymeleafService;
import com.hx.springboot.utils.Tools;

@Service
public class ThymeleafServiceImpl implements ThymeleafService {
	
	@Autowired
	private ThymeleafDao thymeleafDao;

	@Override
	public List<Map<String, Object>> queryList() {
		return thymeleafDao.queryList();
	}

	@Override
	public void saveUser(Map<String, Object> user) {
		thymeleafDao.saveUser(user);
	}

	@Override
	public void deleteUser(int id) {
		thymeleafDao.deleteUser(id);
	}

	@Override
	public Map<String, Object> queryUserById(int id) {
		Map<String, Object> user = thymeleafDao.queryUserById(id);
		String address = Tools.addressStringToCode(user.get("address").toString());
		user.put("address", address);
		return user;
	}

	@Override
	public void updateUser(Map<String, Object> user) {
		thymeleafDao.updateUser(user);
	}

}
