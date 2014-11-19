package com.biz.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.biz.IOrdersLineBiz;
import com.po.OrdersLine;
import com.service.DaoService;
@Service("OrdersLineBiz")
@Transactional
public class OrdersLineBiz implements IOrdersLineBiz {
	@Resource(name="DaoService")
	private DaoService daoService;
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<OrdersLine> findAll(Integer odrId) {
		// TODO Auto-generated method stub
		return daoService.getOrdersLineDAO().findAll(odrId);
	}
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public int findMaxRow() {
		// TODO Auto-generated method stub
		return daoService.getPagedao().findMaxRow("OrdersLine");
	}
	
//	@Transactional(propagation=Propagation.NOT_SUPPORTED)
//	public List<OrdersLine> findAll(Integer odrId, int page, int rows) {
//		// TODO Auto-generated method stub
//		return daoService.getOrdersLineDAO().findAll(odrId, page, rows);
//	}
//	@Transactional(propagation=Propagation.NOT_SUPPORTED)
//	public int findMaxRow(Integer odrId) {
//		// TODO Auto-generated method stub
//		return daoService.getOrdersLineDAO().findMaxRow(odrId);
//	}

}
