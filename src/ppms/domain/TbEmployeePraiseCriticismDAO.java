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
 * TbEmployeepraisecriticism entities. Transaction control of the save(),
 * update() and delete() operations can directly support Spring
 * container-managed transactions or they can be augmented to handle
 * user-managed Spring transactions. Each of these methods provides additional
 * information for how to configure it for the desired type of transaction
 * control.
 * 
 * @see ppms.domain.TbEmployeepraisecriticism
 * @author MyEclipse Persistence Tools
 */
public class TbEmployeepraisecriticismDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(TbEmployeepraisecriticismDAO.class);
	// property constants
	public static final String PRAISECRITICISMTYPE = "praisecriticismtype";
	public static final String CAUSE = "cause";
	public static final String PRAISECRITICISMLEVEL = "praisecriticismlevel";
	public static final String ORGPRAISECRITICMRELATIONID = "orgpraisecriticmrelationid";
	public static final String CREATEDBY = "createdby";
	public static final String MODIFIEDBY = "modifiedby";

	public void save(TbEmployeepraisecriticism transientInstance) {
		log.debug("saving TbEmployeepraisecriticism instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TbEmployeepraisecriticism persistentInstance) {
		log.debug("deleting TbEmployeepraisecriticism instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TbEmployeepraisecriticism findById(java.lang.String id) {
		log.debug("getting TbEmployeepraisecriticism instance with id: " + id);
		try {
			TbEmployeepraisecriticism instance = (TbEmployeepraisecriticism) getSession()
					.get("ppms.domain.TbEmployeepraisecriticism", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TbEmployeepraisecriticism instance) {
		log.debug("finding TbEmployeepraisecriticism instance by example");
		try {
			List results = getSession()
					.createCriteria("ppms.domain.TbEmployeepraisecriticism")
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
		log.debug("finding TbEmployeepraisecriticism instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TbEmployeepraisecriticism as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByPraisecriticismtype(Object praisecriticismtype) {
		return findByProperty(PRAISECRITICISMTYPE, praisecriticismtype);
	}

	public List findByCause(Object cause) {
		return findByProperty(CAUSE, cause);
	}

	public List findByPraisecriticismlevel(Object praisecriticismlevel) {
		return findByProperty(PRAISECRITICISMLEVEL, praisecriticismlevel);
	}

	public List findByOrgpraisecriticmrelationid(
			Object orgpraisecriticmrelationid) {
		return findByProperty(ORGPRAISECRITICMRELATIONID,
				orgpraisecriticmrelationid);
	}

	public List findByCreatedby(Object createdby) {
		return findByProperty(CREATEDBY, createdby);
	}

	public List findByModifiedby(Object modifiedby) {
		return findByProperty(MODIFIEDBY, modifiedby);
	}

	public List findAll() {
		log.debug("finding all TbEmployeepraisecriticism instances");
		try {
			String queryString = "from TbEmployeepraisecriticism";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TbEmployeepraisecriticism merge(
			TbEmployeepraisecriticism detachedInstance) {
		log.debug("merging TbEmployeepraisecriticism instance");
		try {
			TbEmployeepraisecriticism result = (TbEmployeepraisecriticism) getSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TbEmployeepraisecriticism instance) {
		log.debug("attaching dirty TbEmployeepraisecriticism instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TbEmployeepraisecriticism instance) {
		log.debug("attaching clean TbEmployeepraisecriticism instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}