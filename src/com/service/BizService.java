package com.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.biz.ICstActivityBiz;
import com.biz.ICstCustomerBiz;
import com.biz.ICstLinkmanBiz;
import com.biz.ICstLostBiz;
import com.biz.IOrdersBiz;
import com.biz.IOrdersLineBiz;

@Service("BizService")
public class BizService {
	@Resource(name = "CstCustomerBiz")
	private ICstCustomerBiz customerBiz;
	@Resource(name = "CstActivityBiz")
	private ICstActivityBiz cstActivityBiz;
	@Resource(name = "CstLinkmanBiz")
	private ICstLinkmanBiz cstLinkmanBiz;
	@Resource(name = "OrdersBiz")
	private IOrdersBiz ordersBiz;
	@Resource(name = "OrdersLineBiz")
	private IOrdersLineBiz ordersLine;
	@Resource(name = "CstLostBiz")
	private ICstLostBiz lostBiz;
	
	
	
	

	public ICstLostBiz getLostBiz() {
		return lostBiz;
	}

	public void setLostBiz(ICstLostBiz lostBiz) {
		this.lostBiz = lostBiz;
	}

	public IOrdersLineBiz getOrdersLine() {
		return ordersLine;
	}

	public void setOrdersLine(IOrdersLineBiz ordersLine) {
		this.ordersLine = ordersLine;
	}

	public IOrdersBiz getOrdersBiz() {
		return ordersBiz;
	}

	public void setOrdersBiz(IOrdersBiz ordersBiz) {
		this.ordersBiz = ordersBiz;
	}

	public ICstLinkmanBiz getCstLinkmanBiz() {
		return cstLinkmanBiz;
	}

	public void setCstLinkmanBiz(ICstLinkmanBiz cstLinkmanBiz) {
		this.cstLinkmanBiz = cstLinkmanBiz;
	}

	public ICstCustomerBiz getCustomerBiz() {
		return customerBiz;
	}

	public void setCustomerBiz(ICstCustomerBiz customerBiz) {
		this.customerBiz = customerBiz;
	}

	public ICstActivityBiz getCstActivityBiz() {
		return cstActivityBiz;
	}

	public void setCstActivityBiz(ICstActivityBiz cstActivityBiz) {
		this.cstActivityBiz = cstActivityBiz;
	}

	

}
