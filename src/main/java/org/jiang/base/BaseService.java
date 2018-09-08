package org.jiang.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BaseService {

	@Autowired
	private BaseDao userDao;
	
	public String getUserNameById(String id) {
		return userDao.getUserName(id);
	}
	
	@Transactional
	public void updateRoleAndUserName(String name) {
		userDao.updateRoelName(name);
		userDao.updateUserName(name);
	}
}
