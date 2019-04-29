package com.interceptor;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

public class UpdateValidator extends Validator {

	@Override
	protected void validate(Controller c) {
		validateRequiredString("user.id", "IDMsg", "不能修改ID！！!");

	}

	@Override
	protected void handleError(Controller c) {
		// TODO Auto-generated method stub
		c.render("/views/edit.html");
	}

}
