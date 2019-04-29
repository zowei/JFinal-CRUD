package com.interceptor;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;
import com.service.UserService;

public class SelectValidator extends Validator {

	private UserService userService = new UserService();

	@Override
	protected void validate(Controller c) {
		// TODO Auto-generated method stub
		// 添加短路型验证
		this.setShortCircuit(true);
		validateRequiredString("user.id", "IDMsg", "必须输入ID!!!");
		int id = c.getParaToInt("user.id");
		if ((userService.isExistsUser(id))) {
			addError("IDMsg", "查无此人！！！");
		}

	}

	@Override
	protected void handleError(Controller c) {
		// TODO Auto-generated method stub
		c.render("inputId.html");
	}

}
