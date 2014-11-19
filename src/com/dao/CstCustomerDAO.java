package com.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Service;

import com.po.CstCustomer;

/**
 * A data access object (DAO) providing persistence and search support for
 * CstCustomer entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.po.CstCustomer
 * @author MyEclipse Persistence Tools
 */
@Service("CstCustomerDAO")
public class CstCustomerDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(CstCustomerDAO.class);
	// property constants
	public static final String CUST_NO = "custNo";
	public static final String CUST_NAME = "custName";
	public static final String CUST_REGION = "custRegion";
	public static final String CUST_MANAGER_NAME = "custManagerName";
	public static final String CUST_LEVEL_LABEL = "custLevelLabel";
	public static final String CUST_ADDR = "custAddr";
	public static final String CUST_ZIP = "custZip";
	public static final String CUST_TEL = "custTel";
	public static final String CUST_FAX = "custFax";
	public static final String CUST_WEBSITE = "custWebsite";
	public static final String CUST_LICENCE_NO = "custLicenceNo";
	public static final String CUST_CHIEFTAIN = "custChieftain";
	public static final String CUST_BANK = "custBank";
	public static final String CUST_BANK_ACCOUNT = "custBankAccount";
	public static final String CUST_LOCAL_TAX_NO = "custLocalTaxNo";
	public static final String CUST_NATIONAL_TAX_NO = "custNationalTaxNo";
	public static final String CUST_STATUS = "custStatus";

	protected void initDao() {
		// do nothing
	}

	public void save(CstCustomer transientInstance) {
		log.debug("saving CstCustomer instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(CstCustomer persistentInstance) {
		log.debug("deleting CstCustomer instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CstCustomer findById(java.lang.Integer id) {
		log.debug("getting CstCustomer instance with id: " + id);
		try {
			CstCustomer instance = (CstCustomer) getHibernateTemplate().get(
					"com.po.CstCustomer", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<CstCustomer> findByExample(CstCustomer instance) {
		log.debug("finding CstCustomer instance by example");
		try {
			List<CstCustomer> results = (List<CstCustomer>) getHibernateTemplate()
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
		log.debug("finding CstCustomer instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from CstCustomer as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<CstCustomer> findByCustNo(Object custNo) {
		return findByProperty(CUST_NO, custNo);
	}

	public List<CstCustomer> findByCustName(Object custName) {
		return findByProperty(CUST_NAME, custName);
	}

	public List<CstCustomer> findByCustRegion(Object custRegion) {
		return findByProperty(CUST_REGION, custRegion);
	}

	public List<CstCustomer> findByCustManagerName(Object custManagerName) {
		return findByProperty(CUST_MANAGER_NAME, custManagerName);
	}

	public List<CstCustomer> findByCustLevelLabel(Object custLevelLabel) {
		return findByProperty(CUST_LEVEL_LABEL, custLevelLabel);
	}

	public List<CstCustomer> findByCustAddr(Object custAddr) {
		return findByProperty(CUST_ADDR, custAddr);
	}

	public List<CstCustomer> findByCustZip(Object custZip) {
		return findByProperty(CUST_ZIP, custZip);
	}

	public List<CstCustomer> findByCustTel(Object custTel) {
		return findByProperty(CUST_TEL, custTel);
	}

	public List<CstCustomer> findByCustFax(Object custFax) {
		return findByProperty(CUST_FAX, custFax);
	}

	public List<CstCustomer> findByCustWebsite(Object custWebsite) {
		return findByProperty(CUST_WEBSITE, custWebsite);
	}

	public List<CstCustomer> findByCustLicenceNo(Object custLicenceNo) {
		return findByProperty(CUST_LICENCE_NO, custLicenceNo);
	}

	public List<CstCustomer> findByCustChieftain(Object custChieftain) {
		return findByProperty(CUST_CHIEFTAIN, custChieftain);
	}

	public List<CstCustomer> findByCustBank(Object custBank) {
		return findByProperty(CUST_BANK, custBank);
	}

	public List<CstCustomer> findByCustBankAccount(Object custBankAccount) {
		return findByProperty(CUST_BANK_ACCOUNT, custBankAccount);
	}

	public List<CstCustomer> findByCustLocalTaxNo(Object custLocalTaxNo) {
		return findByProperty(CUST_LOCAL_TAX_NO, custLocalTaxNo);
	}

	public List<CstCustomer> findByCustNationalTaxNo(Object custNationalTaxNo) {
		return findByProperty(CUST_NATIONAL_TAX_NO, custNationalTaxNo);
	}

	public List<CstCustomer> findByCustStatus(Object custStatus) {
		return findByProperty(CUST_STATUS, custStatus);
	}

	public List findAll() {
		log.debug("finding all CstCustomer instances");
		try {
			String queryString = "from CstCustomer";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public CstCustomer merge(CstCustomer detachedInstance) {
		log.debug("merging CstCustomer instance");
		try {
			CstCustomer result = (CstCustomer) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(CstCustomer instance) {
		log.debug("attaching dirty CstCustomer instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CstCustomer instance) {
		log.debug("attaching clean CstCustomer instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static CstCustomerDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (CstCustomerDAO) ctx.getBean("CstCustomerDAO");
	}
	//===============获取最大行数=====================
		public int findMaxRow(String custNo,String custName,String custRegion,String custManagerName,String custLevelLabel){
			int maxrow=0;
			String sql="select count(*) from CstCustomer where 1=1";
			if(custNo!=null&&!custNo.trim().equals("")){
				String sql1=" and custNo='"+custNo+"'";
				sql+=sql1;
			}
			if(custName!=null&&!custName.trim().equals("")){
				String sql2=" and custName='"+custName+"'";
				sql+=sql2;
			}
			if(custRegion!=null&&!custRegion.trim().equals("")){
				String sql3=" and custRegion='"+custRegion+"'";
				sql+=sql3;
			}
			if(custManagerName!=null&&!custManagerName.trim().equals("")){
				String sql4=" and custManagerName='"+custManagerName+"'";
				sql+=sql4;
			}
			if(custLevelLabel!=null&&!custLevelLabel.trim().equals("")){
				String sql5=" and custLevelLabel='"+custLevelLabel+"'";
				sql+=sql5;
			}
			Query qy=getSession().createQuery(sql);
			maxrow=Integer.parseInt(qy.list().get(0).toString());
			return maxrow;
		}
		public List<CstCustomer> findAll(String custNo,String custName,String custRegion,String custManagerName,String custLevelLabel,int page,int rows){
			System.out.println("=============CstCustomer================");
			String sql="from CstCustomer where 1=1";
			if(custNo!=null&&!custNo.trim().equals("")){
				String sql1=" and custNo='"+custNo+"'";
				sql+=sql1;
			}
			if(custName!=null&&!custName.trim().equals("")){
				String sql2=" and custName='"+custName+"'";
				sql+=sql2;
			}
			if(custRegion!=null&&!custRegion.trim().equals("")){
				String sql3=" and custRegion='"+custRegion+"'";
				sql+=sql3;
			}
			if(custManagerName!=null&&!custManagerName.trim().equals("")){
				String sql4=" and custManagerName='"+custManagerName+"'";
				sql+=sql4;
			}
			if(custLevelLabel!=null&&!custLevelLabel.trim().equals("")){
				String sql5=" and custLevelLabel='"+custLevelLabel+"'";
				sql+=sql5;
			}
			Query qy=getSession().createQuery(sql);
			qy.setFirstResult((page-1)*rows);
			qy.setMaxResults(rows);
			return qy.list();
		}
}