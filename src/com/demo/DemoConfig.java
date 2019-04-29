package com.demo;

import com.controller.HelloController;
import com.controller.UserController;
import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.core.JFinal;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.render.ViewType;
import com.jfinal.template.Engine;
import com.model.User;

//JFinal是一个终极类，不能被继承
//采用饿汉式单例模式，全局只有一个JFinal的对象
//获得这个对象的静态方法为JFinal.me()

public class DemoConfig extends JFinalConfig {

	public static void main(String[] args) {
		// eclipse下启动项目
		JFinal.start("WebRoot", 8083, "/", 5);

	}

	public void configConstant(Constants me) {
		PropKit.use("dbconfig.txt");
		me.setDevMode(PropKit.getBoolean("devMode"));
		me.setEncoding("utf-8");
		// render支持HTML
		me.setViewType(ViewType.JFINAL_TEMPLATE);
	}

	public void configRoute(Routes me) {
		me.add("/", HelloController.class, "/views");
		me.add("/user", UserController.class, "/views");

	}

	public void configEngine(Engine me) {
		// JFinal是一个单例模式，全局只有一个JFinal对象，想获得这个对象就必须调用它的me()方法
		me.addSharedObject("ctx", JFinal.me().getContextPath());
		me.addSharedFunction("/views/common/_layout.html");
		me.addSharedFunction("/views/common/_paginate.html");
	}

	public void configPlugin(Plugins me) {
		// 配置数据源
		DruidPlugin dp = new DruidPlugin(PropKit.get("jdbcUrl"), PropKit.get("user"), PropKit.get("password"));
		me.add(dp);
		// 配置ActiveRecord插件,此插件依赖于数据源dp
		ActiveRecordPlugin arp = new ActiveRecordPlugin(dp);
		// 映射表和实体bean，id作为主键
		arp.addMapping("user", "id", User.class);
		me.add(arp);
	}

	// 配置全局拦截器
	public void configInterceptor(Interceptors me) {
	}

	// 配置处理器
	public void configHandler(Handlers me) {
	}

}
