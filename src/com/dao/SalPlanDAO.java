package com.dao;

import java.util.Date;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Service;

import com.po.SalChance;
import com.po.SalPlan;

/**
 * A data access object (DAO) providing persistence and search support for
 * SalPlan entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.po.SalPlan
 * @author MyEclipse Persistence Tools
 */
@Service("SalPlanDAO")
public class SalPlanDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(SalPlanDAO.class);
	// property constants
	public static final String PLA_TODO = "plaTodo";
	public static final String PLA_RESULT = "plaResult";

	protected void initDao() {
		// do nothing
	}

	public void save(SalPlan transientInstance) {
		log.debug("saving SalPlan instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(SalPlan persistentInstance) {
		log.debug("deleting SalPlan instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public SalPlan findById(java.lang.Integer id) {
		log.debug("getting SalPlan instance with id: " + id);
		try {
			SalPlan instance = (SalPlan) getHibernateTemplate().get(
					"com.po.SalPlan", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<SalPlan> findByExample(SalPlan instance) {
		log.debug("finding SalPlan instance by example");
		try {
			List<SalPlan> results = (List<SalPlan>) getHibernateTemplate()
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
		log.debug("finding SalPlan instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from SalPlan as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<SalPlan> findByPlaTodo(Object plaTodo) {
		return findByProperty(PLA_TODO, plaTodo);
	}

	public List<SalPlan> findByPlaResult(Object plaResult) {
		return findByProperty(PLA_RESULT, plaResult);
	}

	public List findAll() {
		log.debug("finding all SalPlan instances");
		try {
			String queryString = "from SalPlan";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public SalPlan merge(SalPlan detachedInstance) {
		log.debug("merging SalPlan instance");
		try {
			SalPlan result = (SalPlan) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(SalPlan instance) {
		log.debug("attaching dirty SalPlan instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(SalPlan instance) {
		log.debug("attaching clean SalPlan instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static SalPlanDAO getFromApplicationContext(ApplicationContext ctx) {
		return (SalPlanDAO) ctx.getBean("SalPlanDAO");
	}
	
	//==================================
		@SuppressWarnings("unchecked")
		public List<SalChance> findAll(String chcCustName,String chcTitle,String chcLinkman,int page,int rows){
			int pnum=(page-1)*rows;
			String sql="from SalChance where 1=1";
			if(chcCustName!=null&&!chcCustName.trim().equals("")){
				String sql1=" and chcCustName='"+chcCustName+"'";
				
				sql+=sql1;
				
			}
			if(chcTitle!=null&&!chcTitle.trim().equals("")){
				String sql2=" and chcTitle='"+chcTitle+"'";
				sql+=sql2;
			}
			if(chcLinkman!=null&&!chcLinkman.trim().equals("")){
				String sql3=" and chcLinkman='"+chcLinkman+"'";
				sql+=sql3;
				System.out.println("================================="+"sql");
			}
			Query query=getSession().createQuery(sql);
			query.setFirstResult(pnum);
			query.setMaxResults(rows);
			List<SalChance> lisalChance=query.list();
			return lisalChance;
		}
		public int findMaxRow(String chcCustName,String chcTitle,String chcLinkman){
			int maxrow=0;
			String sql="select count(*) from SalChance where 1=1";
			if(chcCustName!=null&&!chcCustName.trim().equals("")){
				String sql1=" and chcCustName='"+chcCustName+"'";
				sql+=sql1;
			}
			if(chcTitle!=null&&!chcTitle.trim().equals("")){
				String sql2=" and chcTitle='"+chcTitle+"'";
				sql+=sql2;
			}
			if(chcLinkman!=null&&!chcLinkman.trim().equals("")){
				String sql3=" and chcLinkman='"+chcLinkman+"'";
				sql+=sql3;
			}
			Query query=getSession().createQuery(sql);
			maxrow=Integer.parseInt(query.list().get(0).toString());
			return maxrow;
			
		}
		//=======================================
		public List findAll(Integer chcId) {
			System.out.println(chcId+"====dao======");
			log.debug("finding all SalPlan instances");
			try {
				String queryString = "from SalPlan where salChance.chcId=? order by plaId";
				return getHibernateTemplate().find(queryString, chcId);
			} catch (RuntimeException re) {
				log.error("find all failed", re);
				throw re;
			}
		}

}