package org.jiang.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BaseService {

	@Autowired
	private BaseDao baseDao;
	
	public String getUserNameById(String id) {
		return baseDao.getUserName(id);
	}
	
	@Transactional
	public void updateRoleAndUserName(String name) {
		baseDao.updateRoelName(name);
		baseDao.updateUserName(name);
	}
}
