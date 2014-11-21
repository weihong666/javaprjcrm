package com.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.BasDictDAO;
import com.dao.CstActivityDAO;
import com.dao.CstCustomerDAO;
import com.dao.CstLinkmanDAO;
import com.dao.CstLostDAO;
import com.dao.CstServiceDAO;
import com.dao.OrdersDAO;
import com.dao.OrdersLineDAO;
import com.dao.PageDao;
import com.dao.ProductDAO;
import com.dao.SalChanceDAO;
import com.dao.SalPlanDAO;
import com.dao.StorageDAO;
import com.dao.SysUserDAO;

@Service("DaoService")
public class DaoService {
	@Resource(name = "PageDao")
	private PageDao pagedao;
	@Resource(name = "CstCustomerDAO")
	private CstCustomerDAO customerdao;

	@Resource(name = "CstLinkmanDAO")
	private CstLinkmanDAO linkmandao;

	@Resource(name = "CstServiceDAO")
	private CstServiceDAO servicedao;

	@Resource(name = "CstLostDAO")
	private CstLostDAO lostdao;

	@Resource(name = "OrdersDAO")
	private OrdersDAO ordersdao;
	
	@Resource(name = "CstActivityDAO")
	private CstActivityDAO activitydao;
	
	@Resource(name = "OrdersLineDAO")
	private OrdersLineDAO ordersLineDAO;
	
	@Resource(name="ProductDAO")
	private ProductDAO productDAO;
	
	@Resource(name="StorageDAO")
	private StorageDAO storageDAO;
	
	@Resource(name="BasDictDAO")
	private BasDictDAO basDictDAO;
	
	@Resource(name="SysUserDAO")
	private SysUserDAO sysUserDAO;
	@Resource(name="SalChanceDAO")
	private SalChanceDAO salchanceDAO;
	@Resource(name="SalPlanDAO")
	private SalPlanDAO salplanDAO;
	// ----------------------------------------------------
	
	
	public CstCustomerDAO getCustomerdao() {
		return customerdao;
	}

	public SalChanceDAO getSalchanceDAO() {
		return salchanceDAO;
	}

	public void setSalchanceDAO(SalChanceDAO salchanceDAO) {
		this.salchanceDAO = salchanceDAO;
	}

	public SalPlanDAO getSalplanDAO() {
		return salplanDAO;
	}

	public void setSalplanDAO(SalPlanDAO salplanDAO) {
		this.salplanDAO = salplanDAO;
	}

	public SysUserDAO getSysUserDAO() {
		return sysUserDAO;
	}

	public void setSysUserDAO(SysUserDAO sysUserDAO) {
		this.sysUserDAO = sysUserDAO;
	}

	public ProductDAO getProductDAO() {
		return productDAO;
	}

	public void setProductDAO(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}

	public StorageDAO getStorageDAO() {
		return storageDAO;
	}

	public void setStorageDAO(StorageDAO storageDAO) {
		this.storageDAO = storageDAO;
	}

	public BasDictDAO getBasDictDAO() {
		return basDictDAO;
	}

	public void setBasDictDAO(BasDictDAO basDictDAO) {
		this.basDictDAO = basDictDAO;
	}

	public OrdersLineDAO getOrdersLineDAO() {
		return ordersLineDAO;
	}

	public void setOrdersLineDAO(OrdersLineDAO ordersLineDAO) {
		this.ordersLineDAO = ordersLineDAO;
	}

	public CstActivityDAO getActivitydao() {
		return activitydao;
	}

	public void setActivitydao(CstActivityDAO activitydao) {
		this.activitydao = activitydao;
	}

	public PageDao getPagedao() {
		return pagedao;
	}

	public void setPagedao(PageDao pagedao) {
		this.pagedao = pagedao;
	}

	public void setCustomerdao(CstCustomerDAO customerdao) {
		this.customerdao = customerdao;
	}

	public CstLinkmanDAO getLinkmandao() {
		return linkmandao;
	}

	public void setLinkmandao(CstLinkmanDAO linkmandao) {
		this.linkmandao = linkmandao;
	}

	public CstServiceDAO getServicedao() {
		return servicedao;
	}

	public void setServicedao(CstServiceDAO servicedao) {
		this.servicedao = servicedao;
	}

	public CstLostDAO getLostdao() {
		return lostdao;
	}

	public void setLostdao(CstLostDAO lostdao) {
		this.lostdao = lostdao;
	}

	public OrdersDAO getOrdersdao() {
		return ordersdao;
	}

	public void setOrdersdao(OrdersDAO ordersdao) {
		this.ordersdao = ordersdao;
	}

}
