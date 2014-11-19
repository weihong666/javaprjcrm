package com.biz.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.biz.IProductBiz;
import com.po.Product;
import com.service.DaoService;

@Service("ProductBiz")
@Transactional
public class ProductBiz implements IProductBiz {
	@Resource(name="DaoService")
	private DaoService daos;

	public DaoService getDaos() {
		return daos;
	}

	public void setDaos(DaoService daos) {
		this.daos = daos;
	}

	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<Product> findAll(String pname,String ptype,String pbatch,int page,int rows) {
		// TODO Auto-generated method stub
		return (List<Product>) daos.getProductDAO().findAll(pname, ptype, pbatch, page, rows);
	}

	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public int findMaxRow(String pname,String ptype,String pbatch) {
		// TODO Auto-generated method stub
		return daos.getProductDAO().findMaxRow(pname, ptype, pbatch);
	}


}
