package com.controller;

import com.interceptor.SaveValidator;
import com.interceptor.SelectValidator;
import com.interceptor.UpdateValidator;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.model.User;
import com.service.UserService;

public class UserController extends Controller {

	UserService userService = new UserService();

	public void index() {
		setAttr("userpage", userService.paginate(getParaToInt(0, 1), 10));
		render("listuser.html");
	}

	// 跳转add.html页面
	public void add() {
	}

	// 提交add页面增加的数据
	@Before(SaveValidator.class)
	public void save() {
		getModel(User.class).save();
		redirect("/user");
	}

	// 删除数据
	public void delete() {
		userService.deleteById(getParaToInt());
		redirect("/user");
	}

	// 跳转到edit.html页面
	public void edit() {
		setAttr("ue", userService.findById(getParaToInt()));
		render("/views/edit.html");
	}

	// 提交修改后的数据
	@Before(UpdateValidator.class)
	public void update() {
		getModel(User.class).update();
		redirect("/user");
	}

	// 进入inputId.html页面输入ID进行查询
	public void select() {
		render("inputId.html");
	}

	// 进行查询，显示查询结果
	@Before(SelectValidator.class)
	public void selectById() {
		setAttr("us", userService.findById(getParaToInt("user.id")));
		render("show.html");
	}

}
