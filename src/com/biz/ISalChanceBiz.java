package com.biz;

import java.util.List;

import com.po.SalChance;

public interface ISalChanceBiz {
	public boolean save(SalChance sch);
	public boolean delById(Integer chcId);
	public boolean update(SalChance sch);
	public SalChance findById(Integer chcId);
	public List<SalChance> findAll(int page,int rows);
	public int findMaxRow();
	public int findMaxRow(String chcCustName,String chcTitle,String chcLinkman);
	public List<SalChance> findAll(String chcCustName,String chcTitle,String chcLinkman,int page,int rows);
}
