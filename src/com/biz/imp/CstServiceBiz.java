package com.biz.imp;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.biz.ICstServiceBiz;
import com.po.CstService;
import com.service.DaoService;
@Service("CstServiceBiz")
@Transactional
public class CstServiceBiz implements ICstServiceBiz {
	@Resource(name="DaoService")
	private DaoService daoService;
	
	public DaoService getDaoService() {
		return daoService;
	}

	public void setDaoService(DaoService daoService) {
		this.daoService = daoService;
	}

	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<CstService> findByYear(String year) {
		// TODO Auto-generated method stub
		return daoService.getServicedao().findByYear(year);
	}
	

	public boolean save(CstService cstService) {
		try {
			daoService.getServicedao().save(cstService);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean delById(Integer svrId) {
		CstService cstService	=daoService.getServicedao().findById(svrId);
		try {
			daoService.getServicedao().delete(cstService);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public CstService findById(Integer svrId) {
		
		return daoService.getServicedao().findById(svrId);
	}

	public boolean update(CstService cstService) {
		try {
			daoService.getServicedao().merge(cstService);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateend(CstService cstService) {
		try {
			daoService.getServicedao().merge(cstService);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<CstService> findAll(String svrCustName, String svrTitle,
			String svrType, String svrStatus, int page, int rows) {
		// TODO Auto-generated method stub
		return daoService.getServicedao().findAll(svrCustName, svrTitle, svrType, svrStatus, page, rows);
	}
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public int findMaxRow(String svrCustName, String svrTitle, String svrType,
			String svrStatus) {
		// TODO Auto-generated method stub
		return daoService.getServicedao().findMaxRows(svrCustName, svrTitle, svrType, svrStatus);
	}

	public boolean dispatch(Integer svrId, Integer svrDueId, String svrDueTo) {
		CstService cser = daoService.getServicedao().findById(svrId);
		cser.setSvrDueId(svrDueId);
		cser.setSvrDueTo(svrDueTo);
		cser.setSvrDueDate(new Date());
		cser.setSvrStatus("“—∑÷≈‰");
		try {
			daoService.getServicedao().merge(cser);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
