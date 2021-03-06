<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<html lang="en">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta charset="utf-8" />
<title>人员成长档案管理系统</title>

<meta name="description" content="" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

<!-- bootstrap & fontawesome -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/bootstrap.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/font-awesome.css" />

<!-- page specific plugin styles -->

<!-- text fonts -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/ace-fonts.css" />

<!-- ace styles -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/ace.css"
	class="ace-main-stylesheet" id="main-ace-style" />

<!--[if lte IE 9]>
			<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/ace-part2.css" class="ace-main-stylesheet" />
		<![endif]-->

<!--[if lte IE 9]>
		  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/ace-ie.css" />
		<![endif]-->

<!-- inline styles related to this page -->

<!-- ace settings handler -->
<script src="${pageContext.request.contextPath}/assets/js/ace-extra.js"></script>

<!-- HTML5shiv and Respond.js for IE8 to support HTML5 elements and media queries -->

<!--[if lte IE 8]>
		<script src="${pageContext.request.contextPath}/assets/js/html5shiv.js"></script>
		<script src="${pageContext.request.contextPath}/assets/js/respond.js"></script>
		<![endif]-->
</head>

<body class="no-skin">
	<jsp:include page="../../WebPart/Head.jsp"></jsp:include>
	<div class="main-container" id="main-container">
		<script type="text/javascript">
			try {
				ace.settings.check('main-container', 'fixed')
			} catch (e) {
			}
		</script>
		<jsp:include page="../../WebPart/Menu.jsp"></jsp:include>
		<div class="main-content">
			<div class="main-content-inner">
				<div class="breadcrumbs" id="breadcrumbs">
					<script type="text/javascript">
						try {
							ace.settings.check('breadcrumbs', 'fixed')
						} catch (e) {
						}
					</script>
					<ul class="breadcrumb">
						<li><i class="ace-icon fa fa-home home-icon"></i><a href="#">PPMS</a>
						</li>
						<li><a href="#">员工培训/考试管理</a></li>
						<li class="active">新员工/转正考核</li>
					</ul>
					<jsp:include page="../../WebPart/SearchBox.jsp"></jsp:include>
				</div>
				<div class="page-content">
					<jsp:include page="../../WebPart/Skin.jsp"></jsp:include>
					<div class="row">
						<div class="col-xs-12">
							<!-- PAGE CONTENT BEGINS -->

							<div class="page-header">
								<h1>
								 新员工考核成绩单条修改
								</h1>
							</div>
							<form class="form-horizontal" role="form" method="post"
								action="employeeTrainExam.freshEmployeeExam.freshEmployeeExamSearch.modify.do">

								<input type="hidden"
									value="${requestScope.tbFreshemployeeexam.get(0).examid}"
									name="tbFreshemployeeexam.examid">
								<!-- #section:elements.form -->

								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right"
										for="form-input-readonly"> 区域： </label>

									<div class="col-sm-9">
										<input readonly="" type="text" class="col-xs-10 col-sm-5"
											id="form-input-readonly"
											value="${requestScope.tbArea.get(0).areadesc}"
											name="tbArea.areadesc" /> <span
											class="help-inline col-xs-12 col-sm-7"> </span>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right"
										for="form-input-readonly"> 营业厅编码： </label>

									<div class="col-sm-9">
										<input readonly="" type="text" class="col-xs-10 col-sm-5"
											id="form-input-readonly"
											value="${requestScope.tbFreshemployeeexam.get(0).organizationNj.orgid }"
											name="tbFreshemployeeexam.organizationNj.orgid" /> <span
											class="help-inline col-xs-12 col-sm-7"> </span>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right"
										for="form-input-readonly"> 营业厅名称： </label>

									<div class="col-sm-9">
										<input readonly="" type="text" class="col-xs-10 col-sm-5"
											id="form-input-readonly"
											value="${requestScope.tbFreshemployeeexam.get(0).organizationNj.org_Name }"
											name="tbFreshemployeeexam.organizationNj.org_Name" /> <span
											class="help-inline col-xs-12 col-sm-7"> </span>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right"
										for="form-input-readonly"> 姓名： </label>

									<div class="col-sm-9">
										<input readonly="" type="text" class="col-xs-10 col-sm-5"
											id="form-input-readonly"
											value="${requestScope.tbFreshemployeeexam.get(0).tbEmployee.employeename}"
											name="tbFreshemployeeexam.tbEmployee.employeename" /> 
									</div>
								</div>

								<!-- /section:elements.form -->
								<div class="space-4"></div>

								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right"
										for="form-input-readonly"> 工号： </label>

									<div class="col-sm-9">
										<input readonly="" type="text" class="col-xs-10 col-sm-5"
											id="form-input-readonly"
											value="${requestScope.tbFreshemployeeexam.get(0).tbEmployee.employeeid}"
											name="tbFreshemployeeexam.tbEmployee.employeeid" /> <span
											class="help-inline col-xs-12 col-sm-7"> </span>
									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right"
										for="form-input-readonly"> 身份证号： </label>

									<div class="col-sm-9">
										<input readonly="" type="text" class="col-xs-10 col-sm-5"
											id="form-input-readonly"
											value="${requestScope.tbFreshemployeeexam.get(0).tbEmployee.idnumber}"
											name="tbFreshemployeeexam.tbEmployee.idnumber" /> <span
											class="help-inline col-xs-12 col-sm-7"> </span>
									</div>
								</div>

								<div class="space-4"></div>

								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right"
										for="form-field-1"> 考试时间： </label>

									<div class="col-sm-9">
										<input type="text" id="form-field-1" placeholder="考试时间"
											class="col-xs-10 col-sm-5"
											name="tbFreshemployeeexam.examdate" />
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right"
										for="form-field-1"> 阶段： </label>

									<div class="col-sm-9">
										<select class="col-xs-10 col-sm-5" id="form-field-select-1"
											name="examstage" value="${requestScope.examstage}">
											<option value="1">入职期</option>
											<option value="2">实习期</option>
										</select>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right"
										for="form-field-1"> 培养周次： </label>

									<div class="col-sm-9">

										<input type="text" id="form-field-1" placeholder="第几周"
											class="col-xs-10 col-sm-5"
											value="${requestScope.tbFreshemployeeexam.get(0).week}"
											name="tbFreshemployeeexam.week" />

									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right"
										for="form-field-1"> 考试分数： </label>

									<div class="col-sm-9">
										<input type="text" id="form-field-1" placeholder="Grade"
											class="col-xs-10 col-sm-5"
											value="${requestScope.tbFreshemployeeexam.get(0).examscore}"
											name="tbFreshemployeeexam.examscore" /> <label
											class=" control-label no-padding-left" for="form-field-1">
											分 </label>
									</div>

								</div>

								<div class="clearfix form-actions">
									<div class="col-md-offset-3 col-md-9">
										<button class="btn btn-info" type="submit">
											<i class="ace-icon fa fa-check bigger-110"></i> 提交
										</button>

										&nbsp; &nbsp; &nbsp;
										<button class="btn" type="reset">
											<i class="ace-icon fa fa-undo bigger-110"></i> 重置
										</button>
									</div>
								</div>

							</form>

						</div>
						<!-- /.col -->
					</div>
					<!-- /.row -->
				</div>
				<!-- /.page-content -->
				<!-- PAGE CONTENT ENDS -->
			</div>
		</div>
	</div>
	</div>
	</div>
	<jsp:include page="../../WebPart/CopyRight.jsp"></jsp:include>
	</div>
	<jsp:include page="../../WebPart/Script.jsp"></jsp:include>
	<!-- page specific plugin scripts -->

	<!-- inline scripts related to this page -->
	<script>
		
	</script>
</body>
</html>