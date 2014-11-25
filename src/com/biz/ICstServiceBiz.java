package com.biz;

import java.util.List;

import com.po.CstService;

public interface ICstServiceBiz {
	public List<CstService> findByYear(String year);
	public boolean save(CstService cstService);
	public List<CstService>  findAll(String svrCustName,String svrTitle,String svrType,String svrStatus, int page,int rows);
	public int findMaxRow(String svrCustName,String svrTitle,String svrType,String svrStatus);
	public boolean delById(Integer svrId);
	public CstService findById(Integer svrId);
	public boolean update(CstService cstService);
	public boolean updateend(CstService cstService);
	//·ÖÅä
    public boolean dispatch(Integer svrId,Integer svrDueId,String svrDueTo);
}
