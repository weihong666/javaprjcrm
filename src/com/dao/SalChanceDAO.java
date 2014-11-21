package com.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Service;

import com.po.SalChance;

/**
 * A data access object (DAO) providing persistence and search support for
 * SalChance entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.po.SalChance
 * @author MyEclipse Persistence Tools
 */
@Service("SalChanceDAO")
public class SalChanceDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(SalChanceDAO.class);
	// property constants
	public static final String CHC_SOURCE = "chcSource";
	public static final String CHC_CUST_NAME = "chcCustName";
	public static final String CHC_TITLE = "chcTitle";
	public static final String CHC_LINKMAN = "chcLinkman";
	public static final String CHC_TEL = "chcTel";
	public static final String CHC_DESC = "chcDesc";
	public static final String CHC_CREATE_BY = "chcCreateBy";
	public static final String CHC_DUE_TO = "chcDueTo";
	public static final String CHC_STATUS = "chcStatus";

	protected void initDao() {
		// do nothing
	}

	public void save(SalChance transientInstance) {
		log.debug("saving SalChance instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(SalChance persistentInstance) {
		log.debug("deleting SalChance instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public SalChance findById(java.lang.Integer id) {
		log.debug("getting SalChance instance with id: " + id);
		try {
			SalChance instance = (SalChance) getHibernateTemplate().get(
					"com.po.SalChance", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<SalChance> findByExample(SalChance instance) {
		log.debug("finding SalChance instance by example");
		try {
			List<SalChance> results = (List<SalChance>) getHibernateTemplate()
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
		log.debug("finding SalChance instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from SalChance as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<SalChance> findByChcSource(Object chcSource) {
		return findByProperty(CHC_SOURCE, chcSource);
	}

	public List<SalChance> findByChcCustName(Object chcCustName) {
		return findByProperty(CHC_CUST_NAME, chcCustName);
	}

	public List<SalChance> findByChcTitle(Object chcTitle) {
		return findByProperty(CHC_TITLE, chcTitle);
	}

	public List<SalChance> findByChcLinkman(Object chcLinkman) {
		return findByProperty(CHC_LINKMAN, chcLinkman);
	}

	public List<SalChance> findByChcTel(Object chcTel) {
		return findByProperty(CHC_TEL, chcTel);
	}

	public List<SalChance> findByChcDesc(Object chcDesc) {
		return findByProperty(CHC_DESC, chcDesc);
	}

	public List<SalChance> findByChcCreateBy(Object chcCreateBy) {
		return findByProperty(CHC_CREATE_BY, chcCreateBy);
	}

	public List<SalChance> findByChcDueTo(Object chcDueTo) {
		return findByProperty(CHC_DUE_TO, chcDueTo);
	}

	public List<SalChance> findByChcStatus(Object chcStatus) {
		return findByProperty(CHC_STATUS, chcStatus);
	}

	public List findAll() {
		log.debug("finding all SalChance instances");
		try {
			String queryString = "from SalChance";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public SalChance merge(SalChance detachedInstance) {
		log.debug("merging SalChance instance");
		try {
			SalChance result = (SalChance) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(SalChance instance) {
		log.debug("attaching dirty SalChance instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(SalChance instance) {
		log.debug("attaching clean SalChance instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static SalChanceDAO getFromApplicationContext(ApplicationContext ctx) {
		return (SalChanceDAO) ctx.getBean("SalChanceDAO");
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
}