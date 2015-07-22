package ppms.domain;

import java.util.Date;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * TbOperationcheck entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see ppms.domain.TbOperationcheck
 * @author MyEclipse Persistence Tools
 */
public class TbOperationcheckDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(TbOperationcheckDAO.class);
	// property constants
	public static final String CUSTOMERMOBILENUMBER = "customermobilenumber";
	public static final String OPERATIONTYPE = "operationtype";
	public static final String PUNISHRESULT = "punishresult";
	public static final String CREATEDBY = "createdby";
	public static final String MODIFIEDBY = "modifiedby";

	public void save(TbOperationcheck transientInstance) {
		log.debug("saving TbOperationcheck instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TbOperationcheck persistentInstance) {
		log.debug("deleting TbOperationcheck instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TbOperationcheck findById(java.lang.String id) {
		log.debug("getting TbOperationcheck instance with id: " + id);
		try {
			TbOperationcheck instance = (TbOperationcheck) getSession().get(
					"ppms.domain.TbOperationcheck", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TbOperationcheck instance) {
		log.debug("finding TbOperationcheck instance by example");
		try {
			List results = getSession()
					.createCriteria("ppms.domain.TbOperationcheck")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding TbOperationcheck instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TbOperationcheck as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByCustomermobilenumber(Object customermobilenumber) {
		return findByProperty(CUSTOMERMOBILENUMBER, customermobilenumber);
	}

	public List findByOperationtype(Object operationtype) {
		return findByProperty(OPERATIONTYPE, operationtype);
	}

	public List findByPunishresult(Object punishresult) {
		return findByProperty(PUNISHRESULT, punishresult);
	}

	public List findByCreatedby(Object createdby) {
		return findByProperty(CREATEDBY, createdby);
	}

	public List findByModifiedby(Object modifiedby) {
		return findByProperty(MODIFIEDBY, modifiedby);
	}

	public List findAll() {
		log.debug("finding all TbOperationcheck instances");
		try {
			String queryString = "from TbOperationcheck";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TbOperationcheck merge(TbOperationcheck detachedInstance) {
		log.debug("merging TbOperationcheck instance");
		try {
			TbOperationcheck result = (TbOperationcheck) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TbOperationcheck instance) {
		log.debug("attaching dirty TbOperationcheck instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TbOperationcheck instance) {
		log.debug("attaching clean TbOperationcheck instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}