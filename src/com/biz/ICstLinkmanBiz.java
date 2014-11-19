package com.biz;

import java.util.List;

import com.po.CstLinkman;

public interface ICstLinkmanBiz {
	public boolean save(CstLinkman linkman);
	public boolean update(CstLinkman linkman);
	public boolean delById(Integer lkmId);
	public CstLinkman findById(Integer lkmId);
	public List<CstLinkman> findAll();
	public int findMaxRow();
	public List<CstLinkman> findAll(Integer lkmId);
}
