package com.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Service;

import com.po.CstLinkman;

/**
 * A data access object (DAO) providing persistence and search support for
 * CstLinkman entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.po.CstLinkman
 * @author MyEclipse Persistence Tools
 */
@Service("CstLinkmanDAO")
public class CstLinkmanDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(CstLinkmanDAO.class);
	// property constants
	public static final String LKM_CUST_NAME = "lkmCustName";
	public static final String LKM_NAME = "lkmName";
	public static final String LKM_SEX = "lkmSex";
	public static final String LKM_POSTION = "lkmPostion";
	public static final String LKM_TEL = "lkmTel";
	public static final String LKM_MOBILE = "lkmMobile";
	public static final String LKM_MEMO = "lkmMemo";

	protected void initDao() {
		// do nothing
	}

	public void save(CstLinkman transientInstance) {
		log.debug("saving CstLinkman instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(CstLinkman persistentInstance) {
		log.debug("deleting CstLinkman instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CstLinkman findById(java.lang.Integer id) {
		log.debug("getting CstLinkman instance with id: " + id);
		try {
			CstLinkman instance = (CstLinkman) getHibernateTemplate().get(
					"com.po.CstLinkman", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<CstLinkman> findByExample(CstLinkman instance) {
		log.debug("finding CstLinkman instance by example");
		try {
			List<CstLinkman> results = (List<CstLinkman>) getHibernateTemplate()
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
		log.debug("finding CstLinkman instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from CstLinkman as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<CstLinkman> findByLkmCustName(Object lkmCustName) {
		return findByProperty(LKM_CUST_NAME, lkmCustName);
	}

	public List<CstLinkman> findByLkmName(Object lkmName) {
		return findByProperty(LKM_NAME, lkmName);
	}

	public List<CstLinkman> findByLkmSex(Object lkmSex) {
		return findByProperty(LKM_SEX, lkmSex);
	}

	public List<CstLinkman> findByLkmPostion(Object lkmPostion) {
		return findByProperty(LKM_POSTION, lkmPostion);
	}

	public List<CstLinkman> findByLkmTel(Object lkmTel) {
		return findByProperty(LKM_TEL, lkmTel);
	}

	public List<CstLinkman> findByLkmMobile(Object lkmMobile) {
		return findByProperty(LKM_MOBILE, lkmMobile);
	}

	public List<CstLinkman> findByLkmMemo(Object lkmMemo) {
		return findByProperty(LKM_MEMO, lkmMemo);
	}

	public List findAll() {
		log.debug("finding all CstLinkman instances");
		try {
			String queryString = "from CstLinkman";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public CstLinkman merge(CstLinkman detachedInstance) {
		log.debug("merging CstLinkman instance");
		try {
			CstLinkman result = (CstLinkman) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(CstLinkman instance) {
		log.debug("attaching dirty CstLinkman instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CstLinkman instance) {
		log.debug("attaching clean CstLinkman instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static CstLinkmanDAO getFromApplicationContext(ApplicationContext ctx) {
		return (CstLinkmanDAO) ctx.getBean("CstLinkmanDAO");
	}
	//-------------------------------------------
	public List findAll(Integer custId) {
		log.debug("finding all CstLinkman instances");
		try {
			String queryString = "from CstLinkman where cstCustomer.custId=?";
			return getHibernateTemplate().find(queryString,custId);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
}