package org.jiang.base.test;

import java.util.List;
import java.util.Map;

import org.jiang.base.BaseService;
import org.jiang.role.entity.Role;
import org.jiang.role.service.RoleService;
import org.jiang.user.entity.User;
import org.jiang.user.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.Assert;

public class BaseTest {

	/**
	 * 测试IOC
	 */
	@Test
	public void getUserTest() {
		ApplicationContext application = new ClassPathXmlApplicationContext("classpath:spring/application.xml");
		Assert.notNull(application, "application is null");
		BaseService userService = application.getBean(BaseService.class);
		Assert.notNull(userService,"userService is null");
		String userName = userService.getUserNameById("testId");
		System.out.println(userName);
	}
	
	/**
	 * 测试jdbcTemplate
	 */
	@Test
	public void jdbcTemplateTest() {
		ApplicationContext application = new ClassPathXmlApplicationContext("classpath:spring/application.xml");
		JdbcTemplate jdbcTemplate = application.getBean(JdbcTemplate.class);
		String sql = "SELECT * FROM test_hibernate_user";
		List<Map<String,Object>> resultList = jdbcTemplate.queryForList(sql);
		System.out.println(resultList);
	}
	
	/**
	 * 测试事务
	 */
	@Test
	
	public void transactionTest() {
		ApplicationContext application = new ClassPathXmlApplicationContext("classpath:spring/application.xml");
		BaseService userService = application.getBean(BaseService.class);
		userService.updateRoleAndUserName("noTransaction05");
	}
	/**
	 * 测试xml拦截器
	 */
	@Test
	public void xmlAopTest() {
		
	}
	
	/**
	 * 测试注解拦截器
	 */
	@Test
	public void annotationAopTest() {
		ApplicationContext application = new ClassPathXmlApplicationContext("classpath:spring/application.xml");
		BaseService BaseService = application.getBean(BaseService.class);
		String result = BaseService.getUserNameById("001");
		System.out.println(result);
	}
	/**
	 * 测试mybatis整合
	 */
	@Test
	public void mybatisTest() {
		ApplicationContext application = new ClassPathXmlApplicationContext("classpath:spring/application.xml");
		UserService userService = application.getBean(UserService.class);
		User user = userService.getUserById("test001");
		System.out.println(user.toString());
		List<User> listUser = userService.findUserList();
		System.out.println(listUser);
	}
	
	/**
	 * 测试mybatis整合spring事务
	 */
	@Test
	public void mybatisTransactionTest() {
		ApplicationContext application = new ClassPathXmlApplicationContext("classpath:spring/application.xml");
		RoleService roleService = application.getBean(RoleService.class);
		UserService userService = application.getBean(UserService.class);
		Role role = new Role();
		role.setId("001");
		role.setRoleName("事务管理员2");
		
		User user = new User();
		user.setId("001");
		user.setUserName("事务管理员2");
	
		boolean result = userService.updateUserAndRole(user, role);
		System.out.println("更新结果="+result);
		
		List<Role> roleList = roleService.getRoleList();
		System.out.println(roleList);
	}
	
}
