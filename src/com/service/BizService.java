package com.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.biz.IBasDictBiz;
import com.biz.ICstActivityBiz;
import com.biz.ICstCustomerBiz;
import com.biz.ICstLinkmanBiz;
import com.biz.ICstLostBiz;
import com.biz.ICstServiceBiz;
import com.biz.IOrdersBiz;
import com.biz.IOrdersLineBiz;
import com.biz.IProductBiz;
import com.biz.ISalChanceBiz;
import com.biz.ISalPlanBiz;
import com.biz.IStorageBiz;
import com.biz.ISysUserBiz;

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
	
	@Resource(name="BasDictBiz")
	private IBasDictBiz basDictBiz;
	
	@Resource(name="ProductBiz")
	private IProductBiz productBiz;
	
	@Resource(name="StorageBiz")
	private IStorageBiz storageBiz;
	
	@Resource(name="SysUserBiz")
	private ISysUserBiz sysUserBiz;
	
	
	@Resource(name="CstServiceBiz")
	private ICstServiceBiz cstServiceBiz;
	
	@Resource(name="SalChanceBiz")
	private ISalChanceBiz salchancebiz;
	@Resource(name="SalPlanBiz")
	private ISalPlanBiz salplanbiz;

	
	
	public ISalChanceBiz getSalchancebiz() {
		return salchancebiz;
	}

	public void setSalchancebiz(ISalChanceBiz salchancebiz) {
		this.salchancebiz = salchancebiz;
	}

	public ISalPlanBiz getSalplanbiz() {
		return salplanbiz;
	}

	public void setSalplanbiz(ISalPlanBiz salplanbiz) {
		this.salplanbiz = salplanbiz;
	}

	public ICstServiceBiz getCstServiceBiz() {
		return cstServiceBiz;
	}

	public void setCstServiceBiz(ICstServiceBiz cstServiceBiz) {
		this.cstServiceBiz = cstServiceBiz;
	}

	public ISysUserBiz getSysUserBiz() {
		return sysUserBiz;
	}

	public void setSysUserBiz(ISysUserBiz sysUserBiz) {
		this.sysUserBiz = sysUserBiz;
	}

	public IBasDictBiz getBasDictBiz() {
		return basDictBiz;
	}

	public void setBasDictBiz(IBasDictBiz basDictBiz) {
		this.basDictBiz = basDictBiz;
	}

	public IProductBiz getProductBiz() {
		return productBiz;
	}

	public void setProductBiz(IProductBiz productBiz) {
		this.productBiz = productBiz;
	}

	public IStorageBiz getStorageBiz() {
		return storageBiz;
	}

	public void setStorageBiz(IStorageBiz storageBiz) {
		this.storageBiz = storageBiz;
	}

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
