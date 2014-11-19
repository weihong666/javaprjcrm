package com.biz.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.biz.IOrdersBiz;
import com.po.Orders;
import com.service.DaoService;
@Service("OrdersBiz")
@Transactional
public class OrdersBiz implements IOrdersBiz {
	@Resource(name="DaoService")
	private DaoService daoService;
	

	public DaoService getDaoService() {
		return daoService;
	}

	public void setDaoService(DaoService daoService) {
		this.daoService = daoService;
	}
//-------------------------------
	public boolean save(Orders orders) {
		try {
			daoService.getOrdersdao().save(orders);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean update(Orders orders) {
		try {
			daoService.getOrdersdao().merge(orders);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean delById(Integer odrId) {
		Orders orders=daoService.getOrdersdao().findById(odrId);
		try {
			daoService.getOrdersdao().delete(orders);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public Orders findById(Integer odrId) {
		// TODO Auto-generated method stub
		return daoService.getOrdersdao().findById(odrId);
	}
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<Orders> findAll() {
		// TODO Auto-generated method stub
		return daoService.getOrdersdao().findAll();
	}
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public int findMaxRow() {
		// TODO Auto-generated method stub
		return daoService.getPagedao().findMaxRow("Orders");
	}
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<Orders> findAll(Integer odrId) {
		// TODO Auto-generated method stub
		return daoService.getOrdersdao().findAll(odrId);
	}

}
