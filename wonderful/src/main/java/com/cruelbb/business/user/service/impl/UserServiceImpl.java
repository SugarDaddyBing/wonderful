package com.cruelbb.business.user.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.cruelbb.business.user.dao.UserMapper;
import com.cruelbb.business.user.po.UUser;
import com.cruelbb.business.user.service.UserService;
import com.cruelbb.core.dataSource.orm.mybatis.DynamicSqlSessionTemplate;

public class UserServiceImpl implements UserService {
	@Autowired
	private DynamicSqlSessionTemplate DynamicSqlSessionTemplate;

	public UUser login(String email, String pswd) {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("email", email);
		map.put("pswd", pswd);
		return DynamicSqlSessionTemplate.getMapper(UserMapper.class).login(map);
	}

}
