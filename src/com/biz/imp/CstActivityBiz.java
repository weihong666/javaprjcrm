package com.biz.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.biz.ICstActivityBiz;
import com.po.CstActivity;
import com.service.DaoService;
@Service("CstActivityBiz")
@Transactional
public class CstActivityBiz implements ICstActivityBiz {
	@Resource(name="DaoService")
	private DaoService daoService;
	
	
	public DaoService getDaoService() {
		return daoService;
	}

	public void setDaoService(DaoService daoService) {
		this.daoService = daoService;
	}
//-----------------------------------------------------------------
	public boolean save(CstActivity cstActivity) {
		try {
			daoService.getActivitydao().save(cstActivity);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean update(CstActivity cstActivity) {
		try {
			daoService.getActivitydao().merge(cstActivity);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean delById(Integer atvId) {
		CstActivity activity= daoService.getActivitydao().findById(atvId);
		try {
			daoService.getActivitydao().delete(activity);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public CstActivity findById(Integer atvId) {
		// TODO Auto-generated method stub
		return daoService.getActivitydao().findById(atvId);
	}
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<CstActivity> findAll() {
		// TODO Auto-generated method stub
		return daoService.getActivitydao().findAll();
	}
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public int findMaxRow() {
		// TODO Auto-generated method stub
		return daoService.getPagedao().findMaxRow("CstActivity");
	}
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<CstActivity> findAll(Integer id) {
		
		return (List<CstActivity>) daoService.getActivitydao().findAll(id);
	}

}
