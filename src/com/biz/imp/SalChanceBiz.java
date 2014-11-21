package com.biz.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.biz.ISalChanceBiz;
import com.po.SalChance;
import com.service.DaoService;
@Service("SalChanceBiz")
@Transactional
public class SalChanceBiz implements ISalChanceBiz {
		@Resource(name="DaoService")
		private DaoService daoservice;
		
	
	public DaoService getDaoservice() {
			return daoservice;
		}
		public void setDaoservice(DaoService daoservice) {
			this.daoservice = daoservice;
		}
	public boolean delById(Integer chcId) {
		SalChance sch=daoservice.getSalchanceDAO().findById(chcId);
		try {
			daoservice.getSalchanceDAO().delete(sch);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	@SuppressWarnings("unchecked")
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<SalChance> findAll(int page, int rows) {
		
		return (List<SalChance>) daoservice.getPagedao().findAll(page, rows, "SalChance");
	}
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public SalChance findById(Integer chcId) {
		
		return daoservice.getSalchanceDAO().findById(chcId);
	}
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public int findMaxRow() {
		
		return daoservice.getPagedao().findMaxRow("SalChance");
	}

	public boolean save(SalChance sch) {
		
		try {
			daoservice.getSalchanceDAO().save(sch);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean update(SalChance sch) {
		try {
			daoservice.getSalchanceDAO().merge(sch);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<SalChance> findAll(String chcCustName, String chcTitle,
			String chcLinkman, int page, int rows) {
		// TODO Auto-generated method stub
		return daoservice.getSalchanceDAO().findAll(chcCustName, chcTitle, chcLinkman, page, rows);
	}
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public int findMaxRow(String chcCustName, String chcTitle, String chcLinkman) {
		// TODO Auto-generated method stub
		return daoservice.getSalchanceDAO().findMaxRow(chcCustName, chcTitle, chcLinkman);
	}
	
	
}
