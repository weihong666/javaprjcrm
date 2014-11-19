package com.biz;

import java.util.List;

import com.po.CstActivity;


public interface ICstActivityBiz {
	public boolean save(CstActivity cstActivity);
	public boolean update(CstActivity cstActivity);
	public boolean delById(Integer atvId);
	public CstActivity findById(Integer atvId);
	public List<CstActivity> findAll();
	public int findMaxRow();
	public List<CstActivity> findAll(Integer id);
}
