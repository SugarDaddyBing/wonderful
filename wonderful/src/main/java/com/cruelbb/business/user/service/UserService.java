package com.cruelbb.business.user.service;

import com.cruelbb.business.user.model.UUser;

public interface UserService {

	UUser login(String email, String pswd);
}
