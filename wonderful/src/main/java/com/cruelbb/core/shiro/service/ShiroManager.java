package com.cruelbb.core.shiro.service;

public interface ShiroManager {

	/**
	 * 加载过滤配置信息
	 *
	 * @return
	 */
	String loadFilterChainDefinitions();

	/**
	 * 重新构建权限过滤器
	 */
	void reCreateFilterChains();
}
