package ppms.action;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Result;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import ppms.daoimpl.BaseDaoImp;
import ppms.domain.TbInnovation;
import ppms.excel.CommonExcelParser;
import ppms.excel.template.IExcelTemp;
import ppms.exception.ErrorInfo;
import ppms.exception.ExcelParserException;
import ppms.serviceimpl.InvocationServiceImp;

import com.google.gson.Gson;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Excel文件批量上传Action
 * 
 * @author shark
 * @update 2015下午4:31:58
 * @function
 * 
 */
public class FileAction extends ActionSupport {

	/**
	 * 上传的Excel文件
	 */
	private File file;
	private String fileFileName;
	private String expect;

	private ExcelParserException exception;
	@Autowired
	private InvocationServiceImp service;
	@Autowired
	@Qualifier("baseDaoImp")
	private BaseDaoImp dao;

	public FileAction() {
		this.exception = new ExcelParserException();
	}

	public String getExpect() {
		return expect;
	}

	public void setExpect(String expect) {
		this.expect = expect;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}


	@org.apache.struts2.convention.annotation.Action(value = "/upload", results = {
			@Result(name = "error", location = "/WEB-INF/content/page/error.jsp") })
	public String upload() {

		Session session =null;
		// 基于myFile创建一个文件输入流
		try {

			if (!fileFileName.endsWith(".xls")) {

				exception.addErrorInfo(new ErrorInfo("文件导入失败，文件名"
						+ fileFileName + "不符合，请导入.xls格式文件"));
			} else {

				expect = new String(expect.getBytes("iso8859-1"), "utf-8");

				if (expect.equals(fileFileName)) {
					List<Object> objs = new CommonExcelParser(dao, exception)
							.toObjs2(file, fileFileName);
					
					session= dao.getSessionFactory().openSession();
					
					session.beginTransaction();
					for(int i=0;i<objs.size();i++){

						try {
							session.save(objs.get(i));
						} catch (Exception e) {
							ErrorInfo error=new ErrorInfo(i,"行:"+e.getMessage());
							exception.addErrorInfo(error);
							e.printStackTrace();
							
						}
					}

					session.getTransaction().commit();
					System.out.println(fileFileName);
				} else {
					exception.addErrorInfo(new ErrorInfo("该页面要求上传" + expect
							+ "，你上传的是" + fileFileName + ",请检查"));
					System.out.println(expect + "不是" + fileFileName + "请检查");
					return "error";
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null){
				session.close();
			}
			if (exception.getErrors().size() > 0) {
				ServletActionContext.getRequest().setAttribute("errorInfos",
						exception.getErrors());
				try {
					ServletActionContext.getRequest().getInputStream().close();
					ServletActionContext.getResponse().getWriter().write("sfasdf");
				} catch (Exception e) {
					e.printStackTrace();
				} 
				return null;
			}
			return null;
		}

	}

}
