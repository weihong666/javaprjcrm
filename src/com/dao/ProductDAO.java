package com.dao;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Service;

import com.po.Product;

/**
 * A data access object (DAO) providing persistence and search support for
 * Product entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.po.Product
 * @author MyEclipse Persistence Tools
 */
@Service("ProductDAO")
public class ProductDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(ProductDAO.class);
	// property constants
	public static final String PROD_NAME = "prodName";
	public static final String PROD_TYPE = "prodType";
	public static final String PROD_BATCH = "prodBatch";
	public static final String PROD_UNIT = "prodUnit";
	public static final String PROD_PRICE = "prodPrice";
	public static final String PROD_MEMO = "prodMemo";
	public static final String PROD_TOTAL = "prodTotal";

	protected void initDao() {
		// do nothing
	}

	public void save(Product transientInstance) {
		log.debug("saving Product instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Product persistentInstance) {
		log.debug("deleting Product instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Product findById(java.lang.Integer id) {
		log.debug("getting Product instance with id: " + id);
		try {
			Product instance = (Product) getHibernateTemplate().get(
					"com.po.Product", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Product> findByExample(Product instance) {
		log.debug("finding Product instance by example");
		try {
			List<Product> results = (List<Product>) getHibernateTemplate()
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
		log.debug("finding Product instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Product as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Product> findByProdName(Object prodName) {
		return findByProperty(PROD_NAME, prodName);
	}

	public List<Product> findByProdType(Object prodType) {
		return findByProperty(PROD_TYPE, prodType);
	}

	public List<Product> findByProdBatch(Object prodBatch) {
		return findByProperty(PROD_BATCH, prodBatch);
	}

	public List<Product> findByProdUnit(Object prodUnit) {
		return findByProperty(PROD_UNIT, prodUnit);
	}

	public List<Product> findByProdPrice(Object prodPrice) {
		return findByProperty(PROD_PRICE, prodPrice);
	}

	public List<Product> findByProdMemo(Object prodMemo) {
		return findByProperty(PROD_MEMO, prodMemo);
	}

	public List<Product> findByProdTotal(Object prodTotal) {
		return findByProperty(PROD_TOTAL, prodTotal);
	}

	public List findAll() {
		log.debug("finding all Product instances");
		try {
			String queryString = "from Product";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Product merge(Product detachedInstance) {
		log.debug("merging Product instance");
		try {
			Product result = (Product) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Product instance) {
		log.debug("attaching dirty Product instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Product instance) {
		log.debug("attaching clean Product instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ProductDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ProductDAO) ctx.getBean("ProductDAO");
	}
	
	
	//按条件查询，包含分页设置
	public List findAll(String pname,String ptype,String pbatch,int page,int rows) {

			String hql = "from Product where 1=1";
			if(pname!=null&&!pname.trim().equals("")){
				String hql1=" and prodName='"+pname+"'";
				hql+=hql1;
			}
			if(ptype!=null&&!ptype.trim().equals("")){
				String hql2=" and prodType='"+ptype+"'";
				hql+=hql2;
			}
			if(pbatch!=null&&!pbatch.trim().equals("")){
				String hql3=" and prodBatch='"+pbatch+"'";
				hql+=hql3;
			}
			hql+=" order by prodId";//排序
			Query qy=getSession().createQuery(hql);
			qy.setFirstResult((page-1)*rows);
			qy.setMaxResults(rows);
			return qy.list();

	}

	
	//查找最大行
	public int findMaxRow(String pname,String ptype,String pbatch){
		int maxrow=0;
		String hql="select count(*) from Product where 1=1";
		
		if(pname!=null&&!pname.trim().equals("")){
			String hql1=" and prodName='"+pname+"'";
			hql+=hql1;
		}
		if(ptype!=null&&!ptype.trim().equals("")){
			String hql2=" and prodType='"+ptype+"'";
			hql+=hql2;
		}
		if(pbatch!=null&&!pbatch.trim().equals("")){
			String hql3=" and prodBatch='"+pbatch+"'";
			hql+=hql3;
		}
		
		Query qy=getSession().createQuery(hql);
		maxrow=Integer.parseInt(qy.list().get(0).toString());
		return maxrow;
	}

}