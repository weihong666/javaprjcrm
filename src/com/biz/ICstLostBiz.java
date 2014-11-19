package com.biz;

import java.util.List;

import com.po.CstLost;
public interface ICstLostBiz {
	public boolean save(CstLost cstLost);
	public boolean update(CstLost cstLost);
	public boolean delById(Integer id);
	public CstLost findById(Integer id);
	public List<CstLost> findAll();
	public int findMaxRow();
	public List<CstLost> findAll(int page,int rows);
	public List<CstLost> findAll(String lstCustName,String lstCustManagerName,String lstStatus,int page,int rows);
	public int findMaxRow(String lstCustName,String lstCustManagerName,String lstStatus);
}
