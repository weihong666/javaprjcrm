package com.biz.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.biz.ISalPlanBiz;
import com.po.SalChance;
import com.po.SalPlan;
import com.service.DaoService;
@Service("SalPlanBiz")
@Transactional
public class SalPlanBiz implements ISalPlanBiz {
	@Resource(name="DaoService")
	private DaoService daoservice;

	public DaoService getDaoservice() {
		return daoservice;
	}

	public void setDaoservice(DaoService daoservice) {
		this.daoservice = daoservice;
	}
	//========================================

	public boolean delById(Integer plaId) {
		SalPlan sch=daoservice.getSalplanDAO().findById(plaId);
		try {
			daoservice.getSalplanDAO().delete(sch);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<SalPlan> findAll(Integer chcId) {
		System.out.println(chcId+"====biz======");
		return daoservice.getSalplanDAO().findAll(chcId);
	}
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public SalPlan findById(Integer plaId) {
		
		return daoservice.getSalplanDAO().findById(plaId);
	}
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public int findMaxRow() {
		
		return daoservice.getPagedao().findMaxRow("SalPlan");
	}

	public boolean save(SalPlan spl) {
		try {
			daoservice.getSalplanDAO().save(spl);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean update(SalPlan salplan) {
		try {
			daoservice.getSalplanDAO().merge(salplan);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public List<SalPlan> findAll(int page, int rows) {
		// TODO Auto-generated method stub
		return null;
	}


	
}
