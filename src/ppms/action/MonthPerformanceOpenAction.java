package ppms.action;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.poi.ss.formula.functions.T;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import ppms.action.interfaces.InitPage;
import ppms.domain.OrganizationNj;
import ppms.domain.TbMonthperformanceopen;
import ppms.domain.TbPerformance;
import ppms.genericDao.TbMonthperformanceopenDAO;
import ppms.serviceimpl.MonthperformanceopenServiceImp;
import ppms.serviceimpl.OrganizationNjServiceImp;

import com.opensymphony.xwork2.ActionSupport;
import com.sun.mail.handlers.message_rfc822;

/**
 *        项目名称：PPMS   类名称：MonthPerformanceOpenAction   类描述：   创建人：SuperPcf
 * 创建时间：2015-8-19 下午4:04:05   修改人：（修改人的名字） 修改时间：2015-8-19 下午4:04:05   修改备注：  
 * 
 * @version       
 */
public class MonthPerformanceOpenAction extends ActionSupport {

	/**
	 * 
	 * @字段：organizationNj : 营业厅实体类
	 */
	// private OrganizationNj organizationNj;
	// private TbMonthperformanceopen tbMonthperformanceopen;

	private String[] organizationNjs;

	private String openMonth;

	/**
	 * @return the openMonth
	 */
	public String getOpenMonth() {
		return openMonth;
	}

	/**
	 * @param openMonth
	 *            the openMonth to set
	 */
	public void setOpenMonth(String openMonth) {
		this.openMonth = openMonth;
	}

	@Autowired
	private OrganizationNjServiceImp orgService;
	@Autowired
	private MonthperformanceopenServiceImp mPerService;

	/**
	 * 
	 * @字段：request : 定义一个request 前后台传值
	 */
	protected HttpServletRequest request;

	public MonthPerformanceOpenAction() {

		request = ServletActionContext.getRequest();

	}

	public String[] getOrganizationNjs() {
		return organizationNjs;
	}

	public void setOrganizationNjs(String[] organizationNjs) {
		this.organizationNjs = organizationNjs;
	}

	/**
	 * @return the organizationNj
	 */

	/**
	 * 
	 * @方法名: monthPerformanceOpen
	 * 
	 * @描述:营业厅月度开通绩效上传功能 数据初始化
	 * 
	 * @param @return    设定文件
	 * 
	 * @return String    返回类型
	 * 
	 * @throws
	 */
	@Action(value = "performance.month.monthPerformanceOpen", results = {
			@Result(name = "success", location = "/WEB-INF/content/page/performance/monthPerformanceOpen.jsp"),
			@Result(name = "faild", location = "/WEB-INF/content/error.jsp") })
	public String monthPerformanceOpen() {

		try {

			// 获取月份
			Date date = new Date(System.currentTimeMillis());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
			openMonth = sdf.format(date);

			List<OrganizationNj> orgs = orgService.getOrganizationNjs();
			request.setAttribute("orgs", orgs);
			request.setAttribute("openMonth", openMonth);
		} catch (Exception e) {
			System.out.println("<<<<-------------->>>>>");
			e.printStackTrace();
		}

		return "success";
	}

	/**
	 * 
	 * @方法名: monthPerformanceOpen
	 * 
	 * @描述: 处理营业厅月度开通绩效上传功能
	 * 
	 * @param @return    设定文件
	 * 
	 * @return String    返回类型
	 * 
	 * @throws
	 */
	@Action(value = "performance.month.monthPerformanceOpen.add", results = {

			// ****************************************---------->>>>跳转待修改
			@Result(name = "success", location = "/WEB-INF/content/page/performance/monthPerformanceOpenResult.jsp"),
			@Result(name = "faild", location = "/WEB-INF/content/error.jsp") })
	public String addMonthPerformanceOpen() {

		try {

			if (organizationNjs != null) {
				for (String ids : organizationNjs) {
					int id = Integer.parseInt(ids);
					// 根据id拿到所有营业厅对象
					OrganizationNj organizations = orgService
							.getAllOrgsById(id);

					TbMonthperformanceopen tbMonthperformanceopen = new TbMonthperformanceopen();

					// 开通的营业厅id
					tbMonthperformanceopen.setOrganizationNj(organizations);

					tbMonthperformanceopen
							.setOpenmonth(Date.valueOf(openMonth));

					// service添加开通的营业厅
					mPerService.addMonthperformanceopen(tbMonthperformanceopen,
							Date.valueOf(openMonth));

				}

				// //测试开始
				// List <TbMonthperformanceopen>
				// tbMonthperformanceopens=mPerService.getMonthperformanceopens();
				// int i=0;
				// for(TbMonthperformanceopen tb:tbMonthperformanceopens ){
				// System.out.println(++i+"------->>>"+tb.getOpenid());
				// System.out.println(++i+"------->>>"+tb.getCreatedby());
				// System.out.println(++i+"------->>>"+tb.getCreatedtime());
				// System.out.println(++i+"------->>>"+tb.getModifiedby());
				// System.out.println("-------------<<<<<<<<<<<<<<<<!!!!!!!!>>>>>>>>>>>>---------------------");
				//
				// }
				// //测试结束

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}

}
