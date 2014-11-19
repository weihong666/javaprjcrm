package com.biz.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.biz.ICstLinkmanBiz;
import com.po.CstLinkman;
import com.service.DaoService;
@Service("CstLinkmanBiz")
@Transactional
public class CstLinkmanBiz implements ICstLinkmanBiz {
	@Resource(name="DaoService")
	private DaoService daoService;
	
	
	public DaoService getDaoService() {
		return daoService;
	}

	public void setDaoService(DaoService daoService) {
		this.daoService = daoService;
	}
//-------------------------------------------------

	public boolean save(CstLinkman linkman) {
		try {
			daoService.getLinkmandao().save(linkman);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean update(CstLinkman linkman) {
		try {
			daoService.getLinkmandao().merge(linkman);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean delById(Integer lkmId) {
		CstLinkman linkman= daoService.getLinkmandao().findById(lkmId);
		try {
			daoService.getLinkmandao().delete(linkman);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public CstLinkman findById(Integer lkmId) {
		// TODO Auto-generated method stub
		return daoService.getLinkmandao().findById(lkmId);
	}
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<CstLinkman> findAll() {
		// TODO Auto-generated method stub
		return daoService.getLinkmandao().findAll();
	}
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public int findMaxRow() {
		// TODO Auto-generated method stub
		return daoService.getPagedao().findMaxRow("CstLinkman");
	}
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<CstLinkman> findAll(Integer lkmId) {
		// TODO Auto-generated method stub
		return daoService.getLinkmandao().findAll(lkmId);
	}
	
}
