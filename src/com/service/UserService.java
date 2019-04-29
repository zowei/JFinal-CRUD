package com.service;

import com.jfinal.plugin.activerecord.Page;
import com.model.User;

public class UserService {

	private final User dao = new User().dao();

	public Page<User> paginate(int pageNumber, int pageSize) {
		return dao.paginate(pageNumber, pageSize, "select *", "from user order by id desc");
	}

	public void deleteById(int id) {
		dao.deleteById(id);
	}

	// find()和finById()的区别是一个返回集合，一个返回对象
	public User findById(int id) {
		return dao.findById(id);
	}

	// 进行校验是否存在ID
	public Boolean isExistsId(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id) == null ? false : true;

	}

	// 进行校验是否存在ID
	public Boolean isExistsUser(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id) == null ? true : false;

	}

}
