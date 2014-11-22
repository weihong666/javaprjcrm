package com.biz.imp;

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

}
