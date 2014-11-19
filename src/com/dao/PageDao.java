package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Service;
@Service("PageDao")
public class PageDao extends HibernateDaoSupport {
	/**
	 * ��ȡ�������
	 * */
	public int findMaxRow(String className){
		int maxrow=0;
		String sql="select count(*) from "+className+"";
		Query qy=getSession().createQuery(sql);
		maxrow=Integer.parseInt(qy.list().get(0).toString());
		return maxrow;
	}
	
	/***
	 * ��ȡÿҳ�ļ�¼����
	 * @param page ��ǰҳ��
	 * @param rows ÿҳ��¼��
	 * @param className ʵ���������
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
