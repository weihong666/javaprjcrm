package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Service;
@Service("PageDao")
public class PageDao extends HibernateDaoSupport {
	/**
	 * 获取最大行数
	 * */
	public int findMaxRow(String className){
		int maxrow=0;
		String sql="select count(*) from "+className+"";
		Query qy=getSession().createQuery(sql);
		maxrow=Integer.parseInt(qy.list().get(0).toString());
		return maxrow;
	}
	
	/***
	 * 获取每页的记录集合
	 * @param page 当前页数
	 * @param rows 每页记录数
	 * @param className 实体类的名称
	 * */
	public List<?> findAll(int page,int rows,String className){
		System.out.println("=============================");
		String sql="from "+className+"";
		Query qy=getSession().createQuery(sql);
		qy.setFirstResult((page-1)*rows);
		qy.setMaxResults(rows);
		return qy.list();
	}
}
