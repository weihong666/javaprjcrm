package com.dao;

import java.util.Date;
import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Service;

import com.po.Orders;

/**
 * A data access object (DAO) providing persistence and search support for
 * Orders entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.po.Orders
 * @author MyEclipse Persistence Tools
 */
@Service("OrdersDAO")
public class OrdersDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(OrdersDAO.class);
	// property constants
	public static final String ODR_CUSTOMER = "odrCustomer";
	public static final String ODR_ADDR = "odrAddr";
	public static final String ODR_STATUS = "odrStatus";
	public static final String ODR_TOTAL = "odrTotal";

	protected void initDao() {
		// do nothing
	}

	public void save(Orders transientInstance) {
		log.debug("saving Orders instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Orders persistentInstance) {
		log.debug("deleting Orders instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Orders findById(java.lang.Integer id) {
		log.debug("getting Orders instance with id: " + id);
		try {
			Orders instance = (Orders) getHibernateTemplate().get(
					"com.po.Orders", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Orders> findByExample(Orders instance) {
		log.debug("finding Orders instance by example");
		try {
			List<Orders> results = (List<Orders>) getHibernateTemplate()
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
		log.debug("finding Orders instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Orders as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Orders> findByOdrCustomer(Object odrCustomer) {
		return findByProperty(ODR_CUSTOMER, odrCustomer);
	}

	public List<Orders> findByOdrAddr(Object odrAddr) {
		return findByProperty(ODR_ADDR, odrAddr);
	}

	public List<Orders> findByOdrStatus(Object odrStatus) {
		return findByProperty(ODR_STATUS, odrStatus);
	}

	public List<Orders> findByOdrTotal(Object odrTotal) {
		return findByProperty(ODR_TOTAL, odrTotal);
	}

	public List findAll() {
		log.debug("finding all Orders instances");
		try {
			String queryString = "from Orders";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Orders merge(Orders detachedInstance) {
		log.debug("merging Orders instance");
		try {
			Orders result = (Orders) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Orders instance) {
		log.debug("attaching dirty Orders instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Orders instance) {
		log.debug("attaching clean Orders instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static OrdersDAO getFromApplicationContext(ApplicationContext ctx) {
		return (OrdersDAO) ctx.getBean("OrdersDAO");
	}
	
	//-------------------------------------
	public List findAll(int custId) {
		log.debug("finding all Orders instances");
		try {
			String queryString = "from Orders where cstCustomer.custId=?";
			return getHibernateTemplate().find(queryString,custId);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
}