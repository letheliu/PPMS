package ppms.domain;

import java.util.Date;
import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * TbEmployee entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see ppms.domain.TbEmployee
 * @author MyEclipse Persistence Tools
 */
public class TbEmployeeDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(TbEmployeeDAO.class);
	// property constants
<<<<<<< HEAD
	public static final String EMPLOYEENAME = "employeename";
	public static final String EMPLOYEECODE = "employeecode";
	public static final String IDNUMBER = "idnumber";
	public static final String IDPASSWORD = "idpassword";
	public static final String ORGTYPE = "orgtype";
	public static final String SEX = "sex";
	public static final String BANKNAME = "bankname";
	public static final String BANKNUMBER = "banknumber";
	public static final String STATUS = "status";
	public static final String ACADEMICDEGREE = "academicdegree";
	public static final String ADDRESSAREA = "addressarea";
	public static final String ADDRESS = "address";
	public static final String MOBILENUMBER = "mobilenumber";
	public static final String SHORTMOBILENUMBER = "shortmobilenumber";
	public static final String SCHOOLNAME = "schoolname";
	public static final String SPECIALIZATION = "specialization";
	public static final String TEL = "tel";
	public static final String FRONTBACKFLAG = "frontbackflag";
	public static final String BACKJOBCOMMENT = "backjobcomment";
	public static final String TELECOMLEVEL = "telecomlevel";
	public static final String MOBILELEVEL = "mobilelevel";
	public static final String EMPLOYEETYPE = "employeetype";
	public static final String QUALIFICATION = "qualification";
	public static final String OPERATOREXPIRE = "operatorexpire";
	public static final String OPERATORVALIDFLAG = "operatorvalidflag";
	public static final String AUDITEXPIRE = "auditexpire";
	public static final String AUDITVALIDFLAG = "auditvalidflag";
	public static final String REMARK = "remark";
	public static final String CREATEDBY = "createdby";
	public static final String MODIFIEDBY = "modifiedby";
=======
	public static final String EMPLOYEE_NAME = "employeeName";
	public static final String EMPLOYEE_CODE = "employeeCode";
	public static final String ID_NUMBER = "idNumber";
	public static final String ID_PASSWORD = "idPassword";
	public static final String ORG_TYPE = "orgType";
	public static final String SEX = "sex";
	public static final String BANK_NAME = "bankName";
	public static final String BANK_NUMBER = "bankNumber";
	public static final String STATUS = "status";
	public static final String ACADEMIC_DEGREE = "academicDegree";
	public static final String ADDRESS_AREA = "addressArea";
	public static final String ADDRESS = "address";
	public static final String MOBILE_NUMBER = "mobileNumber";
	public static final String SHORT_MOBILE_NUMBER = "shortMobileNumber";
	public static final String SCHOOL_NAME = "schoolName";
	public static final String SPECIALIZATION = "specialization";
	public static final String TEL = "tel";
	public static final String FRONT_BACK_FLAG = "frontBackFlag";
	public static final String BACK_JOB_COMMENT = "backJobComment";
	public static final String TELECOM_LEVEL = "telecomLevel";
	public static final String MOBILE_LEVEL = "mobileLevel";
	public static final String EMPLOYEE_TYPE = "employeeType";
	public static final String QUALIFICATION = "qualification";
	public static final String OPERATOR_EXPIRE = "operatorExpire";
	public static final String OPERATOR_VALID_FLAG = "operatorValidFlag";
	public static final String AUDIT_EXPIRE = "auditExpire";
	public static final String AUDIT_VALID_FLAG = "auditValidFlag";
	public static final String REMARK = "remark";
	public static final String CREATED_BY = "createdBy";
	public static final String MODIFIED_BY = "modifiedBy";
>>>>>>> b0633ca887c97320693bf68c51508c4ad9c3a727

	public void save(TbEmployee transientInstance) {
		log.debug("saving TbEmployee instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TbEmployee persistentInstance) {
		log.debug("deleting TbEmployee instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TbEmployee findById(java.lang.String id) {
		log.debug("getting TbEmployee instance with id: " + id);
		try {
			TbEmployee instance = (TbEmployee) getSession().get(
					"ppms.domain.TbEmployee", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TbEmployee instance) {
		log.debug("finding TbEmployee instance by example");
		try {
			List results = getSession()
					.createCriteria("ppms.domain.TbEmployee")
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
		log.debug("finding TbEmployee instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TbEmployee as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

<<<<<<< HEAD
	public List findByEmployeename(Object employeename) {
		return findByProperty(EMPLOYEENAME, employeename);
	}

	public List findByEmployeecode(Object employeecode) {
		return findByProperty(EMPLOYEECODE, employeecode);
	}

	public List findByIdnumber(Object idnumber) {
		return findByProperty(IDNUMBER, idnumber);
	}

	public List findByIdpassword(Object idpassword) {
		return findByProperty(IDPASSWORD, idpassword);
	}

	public List findByOrgtype(Object orgtype) {
		return findByProperty(ORGTYPE, orgtype);
=======
	public List findByEmployeeName(Object employeeName) {
		return findByProperty(EMPLOYEE_NAME, employeeName);
	}

	public List findByEmployeeCode(Object employeeCode) {
		return findByProperty(EMPLOYEE_CODE, employeeCode);
	}

	public List findByIdNumber(Object idNumber) {
		return findByProperty(ID_NUMBER, idNumber);
	}

	public List findByIdPassword(Object idPassword) {
		return findByProperty(ID_PASSWORD, idPassword);
	}

	public List findByOrgType(Object orgType) {
		return findByProperty(ORG_TYPE, orgType);
>>>>>>> b0633ca887c97320693bf68c51508c4ad9c3a727
	}

	public List findBySex(Object sex) {
		return findByProperty(SEX, sex);
	}

<<<<<<< HEAD
	public List findByBankname(Object bankname) {
		return findByProperty(BANKNAME, bankname);
	}

	public List findByBanknumber(Object banknumber) {
		return findByProperty(BANKNUMBER, banknumber);
=======
	public List findByBankName(Object bankName) {
		return findByProperty(BANK_NAME, bankName);
	}

	public List findByBankNumber(Object bankNumber) {
		return findByProperty(BANK_NUMBER, bankNumber);
>>>>>>> b0633ca887c97320693bf68c51508c4ad9c3a727
	}

	public List findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

<<<<<<< HEAD
	public List findByAcademicdegree(Object academicdegree) {
		return findByProperty(ACADEMICDEGREE, academicdegree);
	}

	public List findByAddressarea(Object addressarea) {
		return findByProperty(ADDRESSAREA, addressarea);
=======
	public List findByAcademicDegree(Object academicDegree) {
		return findByProperty(ACADEMIC_DEGREE, academicDegree);
	}

	public List findByAddressArea(Object addressArea) {
		return findByProperty(ADDRESS_AREA, addressArea);
>>>>>>> b0633ca887c97320693bf68c51508c4ad9c3a727
	}

	public List findByAddress(Object address) {
		return findByProperty(ADDRESS, address);
	}

<<<<<<< HEAD
	public List findByMobilenumber(Object mobilenumber) {
		return findByProperty(MOBILENUMBER, mobilenumber);
	}

	public List findByShortmobilenumber(Object shortmobilenumber) {
		return findByProperty(SHORTMOBILENUMBER, shortmobilenumber);
	}

	public List findBySchoolname(Object schoolname) {
		return findByProperty(SCHOOLNAME, schoolname);
=======
	public List findByMobileNumber(Object mobileNumber) {
		return findByProperty(MOBILE_NUMBER, mobileNumber);
	}

	public List findByShortMobileNumber(Object shortMobileNumber) {
		return findByProperty(SHORT_MOBILE_NUMBER, shortMobileNumber);
	}

	public List findBySchoolName(Object schoolName) {
		return findByProperty(SCHOOL_NAME, schoolName);
>>>>>>> b0633ca887c97320693bf68c51508c4ad9c3a727
	}

	public List findBySpecialization(Object specialization) {
		return findByProperty(SPECIALIZATION, specialization);
	}

	public List findByTel(Object tel) {
		return findByProperty(TEL, tel);
	}

<<<<<<< HEAD
	public List findByFrontbackflag(Object frontbackflag) {
		return findByProperty(FRONTBACKFLAG, frontbackflag);
	}

	public List findByBackjobcomment(Object backjobcomment) {
		return findByProperty(BACKJOBCOMMENT, backjobcomment);
	}

	public List findByTelecomlevel(Object telecomlevel) {
		return findByProperty(TELECOMLEVEL, telecomlevel);
	}

	public List findByMobilelevel(Object mobilelevel) {
		return findByProperty(MOBILELEVEL, mobilelevel);
	}

	public List findByEmployeetype(Object employeetype) {
		return findByProperty(EMPLOYEETYPE, employeetype);
=======
	public List findByFrontBackFlag(Object frontBackFlag) {
		return findByProperty(FRONT_BACK_FLAG, frontBackFlag);
	}

	public List findByBackJobComment(Object backJobComment) {
		return findByProperty(BACK_JOB_COMMENT, backJobComment);
	}

	public List findByTelecomLevel(Object telecomLevel) {
		return findByProperty(TELECOM_LEVEL, telecomLevel);
	}

	public List findByMobileLevel(Object mobileLevel) {
		return findByProperty(MOBILE_LEVEL, mobileLevel);
	}

	public List findByEmployeeType(Object employeeType) {
		return findByProperty(EMPLOYEE_TYPE, employeeType);
>>>>>>> b0633ca887c97320693bf68c51508c4ad9c3a727
	}

	public List findByQualification(Object qualification) {
		return findByProperty(QUALIFICATION, qualification);
	}

<<<<<<< HEAD
	public List findByOperatorexpire(Object operatorexpire) {
		return findByProperty(OPERATOREXPIRE, operatorexpire);
	}

	public List findByOperatorvalidflag(Object operatorvalidflag) {
		return findByProperty(OPERATORVALIDFLAG, operatorvalidflag);
	}

	public List findByAuditexpire(Object auditexpire) {
		return findByProperty(AUDITEXPIRE, auditexpire);
	}

	public List findByAuditvalidflag(Object auditvalidflag) {
		return findByProperty(AUDITVALIDFLAG, auditvalidflag);
=======
	public List findByOperatorExpire(Object operatorExpire) {
		return findByProperty(OPERATOR_EXPIRE, operatorExpire);
	}

	public List findByOperatorValidFlag(Object operatorValidFlag) {
		return findByProperty(OPERATOR_VALID_FLAG, operatorValidFlag);
	}

	public List findByAuditExpire(Object auditExpire) {
		return findByProperty(AUDIT_EXPIRE, auditExpire);
	}

	public List findByAuditValidFlag(Object auditValidFlag) {
		return findByProperty(AUDIT_VALID_FLAG, auditValidFlag);
>>>>>>> b0633ca887c97320693bf68c51508c4ad9c3a727
	}

	public List findByRemark(Object remark) {
		return findByProperty(REMARK, remark);
	}

<<<<<<< HEAD
	public List findByCreatedby(Object createdby) {
		return findByProperty(CREATEDBY, createdby);
	}

	public List findByModifiedby(Object modifiedby) {
		return findByProperty(MODIFIEDBY, modifiedby);
=======
	public List findByCreatedBy(Object createdBy) {
		return findByProperty(CREATED_BY, createdBy);
	}

	public List findByModifiedBy(Object modifiedBy) {
		return findByProperty(MODIFIED_BY, modifiedBy);
>>>>>>> b0633ca887c97320693bf68c51508c4ad9c3a727
	}

	public List findAll() {
		log.debug("finding all TbEmployee instances");
		try {
			String queryString = "from TbEmployee";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TbEmployee merge(TbEmployee detachedInstance) {
		log.debug("merging TbEmployee instance");
		try {
			TbEmployee result = (TbEmployee) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TbEmployee instance) {
		log.debug("attaching dirty TbEmployee instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TbEmployee instance) {
		log.debug("attaching clean TbEmployee instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}