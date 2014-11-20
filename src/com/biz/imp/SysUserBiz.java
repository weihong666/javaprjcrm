package com.biz.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.biz.ISysUserBiz;
import com.po.SysUser;
import com.service.DaoService;
@Service("SysUserBiz")
@Transactional
public class SysUserBiz implements ISysUserBiz {
	@Resource(name="DaoService")
	private DaoService daoService;

	public DaoService getDaoService() {
		return daoService;
	}

	public void setDaoService(DaoService daoService) {
		this.daoService = daoService;
	}

	public boolean save(SysUser user) {
		try {
			daoService.getSysUserDAO().save(user);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean update(SysUser user) {
		try {
			daoService.getSysUserDAO().merge(user);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean delById(Integer usrId) {
		SysUser user=daoService.getSysUserDAO().findById(usrId);
		try {
			daoService.getSysUserDAO().delete(user);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public SysUser findById(Integer usrId) {
		// TODO Auto-generated method stub
		return daoService.getSysUserDAO().findById(usrId);
	}
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<SysUser> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public int findMaxRow() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<SysUser> findAll(Integer usrId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public SysUser check(SysUser user) {
		// TODO Auto-generated method stub
		return daoService.getSysUserDAO().check(user);
	}
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public int findMaxRow(String usrId, String usrName, String usrRoleName,
			Integer usrAlevel) {
		// TODO Auto-generated method stub
		return daoService.getSysUserDAO().findMaxRow(usrId, usrName, usrRoleName, usrAlevel);
	}
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<SysUser> findAll(String usrId, String usrName,
			String usrRoleName, Integer usrAlevel, int page, int rows) {
		// TODO Auto-generated method stub
		return daoService.getSysUserDAO().findAll(usrId, usrName, usrRoleName, usrAlevel, page, rows);
	}
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List findAllUser(Integer usrAlevel) {
		// TODO Auto-generated method stub
		return daoService.getSysUserDAO().findAll(usrAlevel);
	}

}
