package org.jiang.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BaseDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public String getUserName(String id) {
		return id+"=test";
	}
	
	public void updateUserName(String userName) {
		String sql = "update test_hibernate_user set username='"+userName+"' where id='000000'";
		jdbcTemplate.execute(sql);
	}
	
	public void updateRoelName(String roleName) {
		String rolesql = "update user_role set role_name='"+roleName+"' where id='001'";
		jdbcTemplate.execute(rolesql);
	}
}
