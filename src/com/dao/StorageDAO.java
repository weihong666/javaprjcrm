package com.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Service;

import com.po.Storage;

/**
 * A data access object (DAO) providing persistence and search support for
 * Storage entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.po.Storage
 * @author MyEclipse Persistence Tools
 */
@Service("StorageDAO")
public class StorageDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(StorageDAO.class);
	// property constants
	public static final String STK_WAREHOUSE = "stkWarehouse";
	public static final String STK_WARE = "stkWare";
	public static final String STK_COUNT = "stkCount";
	public static final String STK_MEMO = "stkMemo";

	protected void initDao() {
		// do nothing
	}

	public void save(Storage transientInstance) {
		log.debug("saving Storage instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Storage persistentInstance) {
		log.debug("deleting Storage instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Storage findById(java.lang.Integer id) {
		log.debug("getting Storage instance with id: " + id);
		try {
			Storage instance = (Storage) getHibernateTemplate().get(
					"com.po.Storage", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Storage> findByExample(Storage instance) {
		log.debug("finding Storage instance by example");
		try {
			List<Storage> results = (List<Storage>) getHibernateTemplate()
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
		log.debug("finding Storage instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Storage as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Storage> findByStkWarehouse(Object stkWarehouse) {
		return findByProperty(STK_WAREHOUSE, stkWarehouse);
	}

	public List<Storage> findByStkWare(Object stkWare) {
		return findByProperty(STK_WARE, stkWare);
	}

	public List<Storage> findByStkCount(Object stkCount) {
		return findByProperty(STK_COUNT, stkCount);
	}

	public List<Storage> findByStkMemo(Object stkMemo) {
		return findByProperty(STK_MEMO, stkMemo);
	}

	public List findAll() {
		log.debug("finding all Storage instances");
		try {
			String queryString = "from Storage";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Storage merge(Storage detachedInstance) {
		log.debug("merging Storage instance");
		try {
			Storage result = (Storage) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Storage instance) {
		log.debug("attaching dirty Storage instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Storage instance) {
		log.debug("attaching clean Storage instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static StorageDAO getFromApplicationContext(ApplicationContext ctx) {
		return (StorageDAO) ctx.getBean("StorageDAO");
	}
	
	//按条件查询，包含分页设置
			public List findAll(String pname,String stkWarehouse,int page,int rows) {

				    String hql="from Storage where 1=1";
					if(pname!=null&&!pname.trim().equals("")){
						String hql1=" and product.prodName ='"+pname+"'";
						hql+=hql1;
					}
					if(stkWarehouse!=null&&!stkWarehouse.trim().equals("")){
						String hql2=" and stkWarehouse='"+stkWarehouse+"'";
						hql+=hql2;
					}
					
					hql+=" order by stkId";//排序
					Query qy=getSession().createQuery(hql);
					qy.setFirstResult((page-1)*rows);
					qy.setMaxResults(rows);
					return qy.list();

			}

			
			//查找最大行
		
			public int findMaxRow(String pname,String stkWarehouse){
				int maxrow=0;
				String hql="select count(*) from Storage where 1=1";
				
				if(pname!=null&&!pname.trim().equals("")){
					String hql1=" and product.prodName ='"+pname+"'";
					hql+=hql1;
				}
				if(stkWarehouse!=null&&!stkWarehouse.trim().equals("")){
					String hql2=" and stkWarehouse='"+stkWarehouse+"'";
					hql+=hql2;
				}
				
				Query qy=getSession().createQuery(hql);
				maxrow=Integer.parseInt(qy.list().get(0).toString());
				return maxrow;
			}

}