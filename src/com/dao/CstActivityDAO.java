package com.dao;

import java.util.Date;
import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Service;

import com.po.CstActivity;

/**
 * A data access object (DAO) providing persistence and search support for
 * CstActivity entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.po.CstActivity
 * @author MyEclipse Persistence Tools
 */
@Service("CstActivityDAO")
public class CstActivityDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(CstActivityDAO.class);
	// property constants
	public static final String ATV_CUST_NAME = "atvCustName";
	public static final String ATV_PLACE = "atvPlace";
	public static final String ATV_TITLE = "atvTitle";
	public static final String ATV_DESC = "atvDesc";

	protected void initDao() {
		// do nothing
	}

	public void save(CstActivity transientInstance) {
		log.debug("saving CstActivity instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(CstActivity persistentInstance) {
		log.debug("deleting CstActivity instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CstActivity findById(java.lang.Integer id) {
		log.debug("getting CstActivity instance with id: " + id);
		try {
			CstActivity instance = (CstActivity) getHibernateTemplate().get(
					"com.po.CstActivity", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<CstActivity> findByExample(CstActivity instance) {
		log.debug("finding CstActivity instance by example");
		try {
			List<CstActivity> results = (List<CstActivity>) getHibernateTemplate()
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
		log.debug("finding CstActivity instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from CstActivity as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<CstActivity> findByAtvCustName(Object atvCustName) {
		return findByProperty(ATV_CUST_NAME, atvCustName);
	}

	public List<CstActivity> findByAtvPlace(Object atvPlace) {
		return findByProperty(ATV_PLACE, atvPlace);
	}

	public List<CstActivity> findByAtvTitle(Object atvTitle) {
		return findByProperty(ATV_TITLE, atvTitle);
	}

	public List<CstActivity> findByAtvDesc(Object atvDesc) {
		return findByProperty(ATV_DESC, atvDesc);
	}

	public List findAll() {
		log.debug("finding all CstActivity instances");
		try {
			String queryString = "from CstActivity";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public CstActivity merge(CstActivity detachedInstance) {
		log.debug("merging CstActivity instance");
		try {
			CstActivity result = (CstActivity) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(CstActivity instance) {
		log.debug("attaching dirty CstActivity instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CstActivity instance) {
		log.debug("attaching clean CstActivity instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static CstActivityDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (CstActivityDAO) ctx.getBean("CstActivityDAO");
	}
	//----------------------------------
	public List findAll(Integer custId) {
		log.debug("finding all CstActivity instances");
		try {
			String queryString = "from CstActivity where cstCustomer.custId=?";
			return getHibernateTemplate().find(queryString,custId);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
}