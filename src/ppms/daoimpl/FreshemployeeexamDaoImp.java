/**  
 * @文件名: FreshemployeeexamDaoImp.java 
 * @包名 ppms.daoimpl 
 * @描述: TODO 
 * @修改人：
 * @修改时间：2015-8-21 下午8:57:39 
 * @修改内容：

 * @version V1.0  
 */
package ppms.daoimpl;

import java.util.List;

import org.hibernate.classic.Session;
import org.springframework.stereotype.Repository;

import com.sun.org.apache.bcel.internal.generic.NEW;

import ppms.dao.FreshemployeeexamDao;
import ppms.domain.OrganizationNj;
import ppms.domain.TbBecomeemployeeexam;
import ppms.domain.TbEmployee;
import ppms.domain.TbFreshemployeeexam;

/**
 *        项目名称：PPMS   类名称：FreshemployeeexamDaoImp   类描述：   创建人：SuperPcf
 * 创建时间：2015-8-21 下午8:57:39   修改人：（修改人的名字） 修改时间：2015-8-21 下午8:57:39   修改备注：  
 * 
 * @version       
 */
@Repository
public class FreshemployeeexamDaoImp extends BaseDaoImp implements
		FreshemployeeexamDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see ppms.dao.FreshemployeeexamDao#addFreshemployeeexam()
	 */
	@Override
	public void addFreshemployeeexam(Object object) {
		getHibernateTemplate().save(object);
	}

	@Override
	public List<TbFreshemployeeexam> getFreshemployeeexam() {

		return getHibernateTemplate().findByExample(new TbFreshemployeeexam());
	}

	@Override
	public List<OrganizationNj> getOrganizations() {

		return getHibernateTemplate().findByExample(new OrganizationNj());
	}

	@Override
	public List<TbEmployee> getTbEmployees() {

		return getHibernateTemplate().findByExample(new TbEmployee());
	}

	@Override
	public boolean update(TbFreshemployeeexam tbFreshemployeeexam) {
		Session openSession = null;
		try {
			openSession = this.getSessionFactory().openSession();

			openSession.beginTransaction();

			TbFreshemployeeexam load = (TbFreshemployeeexam) openSession.load(
					TbFreshemployeeexam.class, tbFreshemployeeexam.getExamid());

			load.setExamid(tbFreshemployeeexam.getExamid());
			// load.setOrganizationNj(tbBecomeemployeeexam.getOrganizationNj());

			// 待修改
			load.setOrganizationNj(null);
			load.setTbEmployee(tbFreshemployeeexam.getTbEmployee());
			load.setExamdate(tbFreshemployeeexam.getExamdate());
			load.setExamstage(tbFreshemployeeexam.getExamstage());
			load.setWeek(tbFreshemployeeexam.getWeek());

			load.setExamscore(tbFreshemployeeexam.getExamscore());
			load.setCreatedby(tbFreshemployeeexam.getCreatedby());
			load.setCreatedtime(tbFreshemployeeexam.getCreatedtime());
			load.setModifiedby(tbFreshemployeeexam.getModifiedby());
			load.setModifiedtime(tbFreshemployeeexam.getCreatedtime());

			openSession.update(load);

			openSession.getTransaction().commit();

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			openSession.getTransaction().rollback();
			return false;
		} finally {
			openSession.close();
		}

	}
}
