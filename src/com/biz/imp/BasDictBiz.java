package com.biz.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.service.*;

import com.biz.IBasDictBiz;
import com.po.BasDict;

@Service("BasDictBiz")
@Transactional
public class BasDictBiz implements IBasDictBiz {
	
	@Resource(name="DaoService")
	private DaoService daos;

	
	public DaoService getDaos() {
		return daos;
	}

	public void setDaos(DaoService daos) {
		this.daos = daos;
	}

	//------------------------------------------
	public boolean save(BasDict bdt) {
		try {
			daos.getBasDictDAO().save(bdt);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean update(BasDict bdt) {
		try {
			daos.getBasDictDAO().merge(bdt);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean delById(Integer id) {
		BasDict oldbd=daos.getBasDictDAO().findById(id);
		try {
			daos.getBasDictDAO().delete(oldbd);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public BasDict findById(Integer id) {
		return daos.getBasDictDAO().findById(id);
	}

	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<BasDict> findAll(String dtype,String ditem,String dvalue,int page,int rows) {
		return (List<BasDict>) daos.getBasDictDAO().findAll(dtype, ditem, dvalue, page, rows);
	}

	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public int findMaxRow(String dtype,String ditem,String dvalue) {
		// TODO Auto-generated method stub
		return daos.getBasDictDAO().findMaxRow(dtype, ditem, dvalue);
	}

}
