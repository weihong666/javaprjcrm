package com.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Service;

import com.po.CstCustomer;
import com.po.SysUser;

/**
 * A data access object (DAO) providing persistence and search support for
 * SysUser entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.po.SysUser
 * @author MyEclipse Persistence Tools
 */
@Service("SysUserDAO")
public class SysUserDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(SysUserDAO.class);
	// property constants
	public static final String USR_NAME = "usrName";
	public static final String USR_PASSWORD = "usrPassword";
	public static final String USR_ROLE_NAME = "usrRoleName";
	public static final String USR_ALEVEL = "usrAlevel";

	protected void initDao() {
		// do nothing
	}

	public void save(SysUser transientInstance) {
		log.debug("saving SysUser instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(SysUser persistentInstance) {
		log.debug("deleting SysUser instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public SysUser findById(java.lang.Integer id) {
		log.debug("getting SysUser instance with id: " + id);
		try {
			SysUser instance = (SysUser) getHibernateTemplate().get(
					"com.po.SysUser", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<SysUser> findByExample(SysUser instance) {
		log.debug("finding SysUser instance by example");
		try {
			List<SysUser> results = (List<SysUser>) getHibernateTemplate()
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
		log.debug("finding SysUser instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from SysUser as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<SysUser> findByUsrName(Object usrName) {
		return findByProperty(USR_NAME, usrName);
	}

	public List<SysUser> findByUsrPassword(Object usrPassword) {
		return findByProperty(USR_PASSWORD, usrPassword);
	}

	public List<SysUser> findByUsrRoleName(Object usrRoleName) {
		return findByProperty(USR_ROLE_NAME, usrRoleName);
	}

	public List<SysUser> findByUsrAlevel(Object usrAlevel) {
		return findByProperty(USR_ALEVEL, usrAlevel);
	}

	public List findAll() {
		log.debug("finding all SysUser instances");
		try {
			String queryString = "from SysUser";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public SysUser merge(SysUser detachedInstance) {
		log.debug("merging SysUser instance");
		try {
			SysUser result = (SysUser) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(SysUser instance) {
		log.debug("attaching dirty SysUser instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(SysUser instance) {
		log.debug("attaching clean SysUser instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static SysUserDAO getFromApplicationContext(ApplicationContext ctx) {
		return (SysUserDAO) ctx.getBean("SysUserDAO");
	}
	
	/***
	 * 
	 * 登录
	 * **/
	public SysUser check(SysUser us){
		String sql="from SysUser where usrName=? and usrPassword=?";
		Query qy=getSession().createQuery(sql);
		qy.setParameter(0, us.getUsrName());
		qy.setParameter(1, us.getUsrPassword());
		List<SysUser> ls=qy.list();
		if(ls!=null&&!ls.isEmpty()){
			return  ls.get(0);
		}
		return null;
	}
	
	//===============获取最大行数=====================
			public int findMaxRow(String usrId,String usrName,String usrRoleName,Integer usrAlevel){
				int maxrow=0;
				String sql="select count(*) from SysUser where 1=1";
				if(usrId!=null&&!usrId.trim().equals("")){
					String sql1=" and usrId='"+usrId+"'";
					sql+=sql1;
				}
				if(usrName!=null&&!usrName.trim().equals("")){
					String sql2=" and usrName='"+usrName+"'";
					sql+=sql2;
				}
				if(usrRoleName!=null&&!usrRoleName.trim().equals("")){
					String sql3=" and usrRoleName='"+usrRoleName+"'";
					sql+=sql3;
				}
				if(usrAlevel!=null&&!usrAlevel.equals("")){
					String sql4=" and usrAlevel='"+usrAlevel+"'";
					sql+=sql4;
				}
				
				Query qy=getSession().createQuery(sql);
				maxrow=Integer.parseInt(qy.list().get(0).toString());
				return maxrow;
			}
			public List<SysUser> findAll(String usrId,String usrName,String usrRoleName,Integer usrAlevel,int page,int rows){
				System.out.println("=============SysUser================");
				String sql="from SysUser where 1=1";
				if(usrId!=null&&!usrId.trim().equals("")){
					String sql1=" and usrId='"+usrId+"'";
					sql+=sql1;
				}
				if(usrName!=null&&!usrName.trim().equals("")){
					String sql2=" and usrName='"+usrName+"'";
					sql+=sql2;
				}
				if(usrRoleName!=null&&!usrRoleName.trim().equals("")){
					String sql3=" and usrRoleName='"+usrRoleName+"'";
					sql+=sql3;
				}
				if(usrAlevel!=null&&!usrAlevel.equals("")){
					String sql4=" and usrAlevel='"+usrAlevel+"'";
					sql+=sql4;
				}
				
				Query qy=getSession().createQuery(sql);
				qy.setFirstResult((page-1)*rows);
				qy.setMaxResults(rows);
				return qy.list();
			}
	
}