package com.cruelbb.business.user.dao;

import java.util.Map;

import com.cruelbb.business.user.model.UUser;

public interface UserMapper {
	UUser login(Map<String, Object> map);

}
