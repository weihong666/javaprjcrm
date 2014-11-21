package com.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Service;

import com.po.CstLost;

/**
 * A data access object (DAO) providing persistence and search support for
 * CstLost entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.po.CstLost
 * @author MyEclipse Persistence Tools
 */
@Service("CstLostDAO")
public class CstLostDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(CstLostDAO.class);
	// property constants
	public static final String LST_CUST_NAME = "lstCustName";
	public static final String LST_CUST_MANAGER_NAME = "lstCustManagerName";
	public static final String LST_DELAY = "lstDelay";
	public static final String LST_REASON = "lstReason";
	public static final String LST_STATUS = "lstStatus";

	protected void initDao() {
		// do nothing
	}

	public void save(CstLost transientInstance) {
		log.debug("saving CstLost instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(CstLost persistentInstance) {
		log.debug("deleting CstLost instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CstLost findById(java.lang.Integer id) {
		log.debug("getting CstLost instance with id: " + id);
		try {
			CstLost instance = (CstLost) getHibernateTemplate().get(
					"com.po.CstLost", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<CstLost> findByExample(CstLost instance) {
		log.debug("finding CstLost instance by example");
		try {
			List<CstLost> results = (List<CstLost>) getHibernateTemplate()
					.findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding CstLost instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from CstLost as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<CstLost> findByLstCustName(Object lstCustName) {
		return findByProperty(LST_CUST_NAME, lstCustName);
	}

	public List<CstLost> findByLstCustManagerName(Object lstCustManagerName) {
		return findByProperty(LST_CUST_MANAGER_NAME, lstCustManagerName);
	}

	public List<CstLost> findByLstDelay(Object lstDelay) {
		return findByProperty(LST_DELAY, lstDelay);
	}

	public List<CstLost> findByLstReason(Object lstReason) {
		return findByProperty(LST_REASON, lstReason);
	}

	public List<CstLost> findByLstStatus(Object lstStatus) {
		return findByProperty(LST_STATUS, lstStatus);
	}

	public List findAll() {
		log.debug("finding all CstLost instances");
		try {
			String queryString = "from CstLost";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public CstLost merge(CstLost detachedInstance) {
		log.debug("merging CstLost instance");
		try {
			CstLost result = (CstLost) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(CstLost instance) {
		log.debug("attaching dirty CstLost instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CstLost instance) {
		log.debug("attaching clean CstLost instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static CstLostDAO getFromApplicationContext(ApplicationContext ctx) {
		return (CstLostDAO) ctx.getBean("CstLostDAO");
	}
	
	//===============获取最大行数=====================
			public int findMaxRow(String lstCustName,String lstCustManagerName,String lstStatus){
				int maxrow=0;
				String sql="select count(*) from CstLost where 1=1";
				if(lstCustName!=null&&!lstCustName.trim().equals("")){
					String sql1=" and lstCustName='"+lstCustName+"'";
					sql+=sql1;
				}
				if(lstCustManagerName!=null&&!lstCustManagerName.trim().equals("")){
					String sql2=" and lstCustManagerName='"+lstCustManagerName+"'";
					sql+=sql2;
				}
				if(lstStatus!=null&&!lstStatus.trim().equals("")){
					String sql3=" and lstStatus='"+lstStatus+"'";
					sql+=sql3;
				}
				Query qy=getSession().createQuery(sql);
				maxrow=Integer.parseInt(qy.list().get(0).toString());
				return maxrow;
			}
			public List<CstLost> findAll(String lstCustName,String lstCustManagerName,String lstStatus,int page,int rows){
				System.out.println("=============CstCustomer================");
				String sql="from CstLost where 1=1";
				if(lstCustName!=null&&!lstCustName.trim().equals("")){
					String sql1=" and lstCustName='"+lstCustName+"'";
					sql+=sql1;
				}
				if(lstCustManagerName!=null&&!lstCustManagerName.trim().equals("")){
					String sql2=" and lstCustManagerName='"+lstCustManagerName+"'";
					sql+=sql2;
				}
				if(lstStatus!=null&&!lstStatus.trim().equals("")){
					String sql3=" and lstStatus='"+lstStatus+"'";
					sql+=sql3;
				}
				
				Query qy=getSession().createQuery(sql);
				qy.setFirstResult((page-1)*rows);
				qy.setMaxResults(rows);
				return qy.list();
			}
			
			//===================流失统计查询===================================================
			
			
			//===============获取最大行数=====================
			public int findMaxRow(String lstCustName,String lstCustManagerName){
				int maxrow=0;
				String sql="select count(*) from CstLost where lstStatus='已流失' and 1=1";
				if(lstCustName!=null&&!lstCustName.trim().equals("")){
					String sql1=" and lstCustName='"+lstCustName+"'";
					sql+=sql1;
				}
				if(lstCustManagerName!=null&&!lstCustManagerName.trim().equals("")){
					String sql2=" and lstCustManagerName='"+lstCustManagerName+"'";
					sql+=sql2;
				}
				
				Query qy=getSession().createQuery(sql);
				maxrow=Integer.parseInt(qy.list().get(0).toString());
				return maxrow;
			}
			public List<CstLost> findAll(String lstCustName,String lstCustManagerName,int page,int rows){
				System.out.println("=============CstCustomer================");
				String sql="from CstLost where lstStatus='已流失' and 1=1";
				if(lstCustName!=null&&!lstCustName.trim().equals("")){
					String sql1=" and lstCustName='"+lstCustName+"'";
					sql+=sql1;
				}
				if(lstCustManagerName!=null&&!lstCustManagerName.trim().equals("")){
					String sql2=" and lstCustManagerName='"+lstCustManagerName+"'";
					sql+=sql2;
				}
				
				
				Query qy=getSession().createQuery(sql);
				qy.setFirstResult((page-1)*rows);
				qy.setMaxResults(rows);
				return qy.list();
			}
}