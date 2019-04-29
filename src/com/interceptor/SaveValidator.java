package com.interceptor;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;
import com.model.User;
import com.service.UserService;

public class SaveValidator extends Validator {

	private UserService userService = new UserService();

	@Override
	protected void validate(Controller c) {
		// 如果不添加短路型验证，则用户输入空值后进行第一个验证之后，还会进行第二个验证
		// 导致null值在转换为id的时候出现异常
		// 短路型验证，出现一个错误即不再验证接下来的
		this.setShortCircuit(true);
		validateRequiredString("user.id", "IDMsg", "必须输入ID!!!");
		int id = c.getParaToInt("user.id");
		if ((userService.isExistsId(id))) {
			addError("IDMsg", "ID已被注册，请更换ID！");
		}

	}

	@Override
	protected void handleError(Controller c) {
		// TODO Auto-generated method stub

		// 本质是创建于一个User储存了之前接收到的数据，然后serAttr("user",User)
		// 默认是储存在类名小写当中
		c.keepBean(User.class);
		// #(user.id??)即可获得之前写过的数据
		c.render("add.html");

	}

}
