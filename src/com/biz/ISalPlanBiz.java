package com.biz;

import java.util.List;

import com.po.SalChance;
import com.po.SalPlan;

public interface ISalPlanBiz {
	public boolean save(SalPlan spl);
	public boolean delById(Integer plaId);
	public boolean update(SalPlan spl);
	public SalPlan findById(Integer plaId);
	public List<SalPlan> findAll(int page,int rows);
	public List findAll(Integer chcId);
	public int findMaxRow();
	
}
