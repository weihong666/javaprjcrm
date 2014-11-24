package com.biz.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import com.biz.ICstLostBiz;
import com.po.CstLost;
import com.service.DaoService;
@Service("CstLostBiz")
@Transactional
public class CstLostBiz implements ICstLostBiz {
	@Resource(name="DaoService")
	private DaoService daoService;

	public DaoService getDaoService() {
		return daoService;
	}

	public void setDaoService(DaoService daoService) {
		this.daoService = daoService;
	}

	public boolean save(CstLost cstLost) {
		try {
			daoService.getLostdao().save(cstLost);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
//===================================
	public boolean update(CstLost cstLost) {
		try {
			daoService.getLostdao().merge(cstLost);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean delById(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public CstLost findById(Integer id) {
		// TODO Auto-generated method stub
		return daoService.getLostdao().findById(id);
	}
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<CstLost> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public int findMaxRow() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<CstLost> findAll(int page, int rows) {
		// TODO Auto-generated method stub
		return null;
	}
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<CstLost> findAll(String lstCustName, String lstCustManagerName,
			String lstStatus, int page, int rows) {
		// TODO Auto-generated method stub
		return daoService.getLostdao().findAll(lstCustName, lstCustManagerName, lstStatus, page, rows);
	}
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public int findMaxRow(String lstCustName, String lstCustManagerName,
			String lstStatus) {
		// TODO Auto-generated method stub
		return daoService.getLostdao().findMaxRow(lstCustName, lstCustManagerName, lstStatus);
	}
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public int findMaxRow(String lstCustName, String lstCustManagerName) {
		// TODO Auto-generated method stub
		return daoService.getLostdao().findMaxRow(lstCustName, lstCustManagerName);
	}
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<CstLost> findAll(String lstCustName, String lstCustManagerName,
			int page, int rows) {
		// TODO Auto-generated method stub
		return daoService.getLostdao().findAll(lstCustName, lstCustManagerName, page, rows);
	}

}
