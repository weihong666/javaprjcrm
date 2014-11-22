package com.biz.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.biz.ICstCustomerBiz;
import com.po.CstCustomer;
import com.service.DaoService;
@Service("CstCustomerBiz")
@Transactional
public class CstCustomerBiz implements ICstCustomerBiz {
	@Resource(name="DaoService")
	private  DaoService daoService;
	
	public DaoService getDaoService() {
		return daoService;
	}

	public void setDaoService(DaoService daoService) {
		this.daoService = daoService;
	}
//--------------------------------------
	public boolean save(CstCustomer customer) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean update(CstCustomer customer) {
		try {
			daoService.getCustomerdao().merge(customer);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean delById(Integer cust_id) {
		CstCustomer customer=daoService.getCustomerdao().findById(cust_id);
		try {
			daoService.getCustomerdao().delete(customer);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public CstCustomer findById(Integer id) {
		
		return daoService.getCustomerdao().findById(id);
	}
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<CstCustomer> findAll() {
		
		return daoService.getCustomerdao().findAll();
	}
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public int findMaxRow() {
		// TODO Auto-generated method stub
		return daoService.getPagedao().findMaxRow("CstCustomer");
	}
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<CstCustomer> findAll(int page, int rows) {
		// TODO Auto-generated method stub
		return (List<CstCustomer>) daoService.getPagedao().findAll(page, rows, "CstCustomer");
	}
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<CstCustomer> findAll(String custNo, String custName,
			String custRegion, String custManagerName, String custLevelLabel,
			int page, int rows) {
		// TODO Auto-generated method stub
		return daoService.getCustomerdao().findAll(custNo, custName, custRegion, custManagerName, custLevelLabel, page, rows);
	}
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public int findMaxRow(String custNo, String custName, String custRegion,
			String custManagerName, String custLevelLabel) {
		// TODO Auto-generated method stub
		return daoService.getCustomerdao().findMaxRow(custNo, custName, custRegion, custManagerName, custLevelLabel);
	}
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List findAll(String str) {
		// TODO Auto-generated method stub
		return daoService.getCustomerdao().findAll(str);
	}

}
