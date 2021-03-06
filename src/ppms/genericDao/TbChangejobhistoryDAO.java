package ppms.genericDao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.springframework.stereotype.Repository;

import ppms.domain.TbChangejobhistory;

/**
 * A data access object (DAO) providing persistence and search support for
 * TbChangejobhistory entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see ppms.domain.TbChangejobhistory
 * @author MyEclipse Persistence Tools
 */
@Repository
public class TbChangejobhistoryDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory
			.getLog(TbChangejobhistoryDAO.class);
	// property constants
	public static final String CREATEDBY = "createdby";
	public static final String MODIFIEDBY = "modifiedby";

	public void save(TbChangejobhistory transientInstance) {
		log.debug("saving TbChangejobhistory instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TbChangejobhistory persistentInstance) {
		log.debug("deleting TbChangejobhistory instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TbChangejobhistory findById(java.lang.String id) {
		log.debug("getting TbChangejobhistory instance with id: " + id);
		try {
			TbChangejobhistory instance = (TbChangejobhistory) getHibernateTemplate()
					.get("ppms.domain.TbChangejobhistory", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}


	public TbChangejobhistory merge(TbChangejobhistory detachedInstance) {
		log.debug("merging TbChangejobhistory instance");
		try {
			TbChangejobhistory result = (TbChangejobhistory) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TbChangejobhistory instance) {
		log.debug("attaching dirty TbChangejobhistory instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TbChangejobhistory instance) {
		log.debug("attaching clean TbChangejobhistory instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}