<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<html lang="en">
<head>  
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta charset="utf-8" />
<title>人员成长档案管理系统</title>
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
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/jquery-ui.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/datepicker.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/ui.jqgrid.css" />
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
			try { ace.settings.check('main-container', 'fixed') } catch (e) { }
		</script>
		<jsp:include page="../../WebPart/Menu.jsp"></jsp:include>
		<div class="main-content">
			<div class="main-content-inner">
				<div class="breadcrumbs" id="breadcrumbs">
					<script type="text/javascript">
						try { ace.settings.check('breadcrumbs', 'fixed') } catch (e) { }
					</script>
					<ul class="breadcrumb">
						<li><i class="ace-icon fa fa-home home-icon"></i><a href="#">Home</a>
						</li>
						<li><a href="#">Other Pages</a></li>
						<li class="active">Blank Page</li>
					</ul>
					<jsp:include page="../../WebPart/SearchBox.jsp"></jsp:include>
				</div>
				<div class="page-content">
					<jsp:include page="../../WebPart/Skin.jsp"></jsp:include>
					<div class="row">
						<div class="col-xs-12">
							<!-- PAGE CONTENT BEGINS -->
							<h3 class="header smaller lighter blue">标准化检查成绩查询</h3>
							
							<div class="clearfix">
								<div class="pull-right tableTools-container"></div>
							</div>
							<div class="table-header">标准化信息查询</div>
	
								<table id="dynamic-table" class="table table-striped table-bordered table-hover">
								<thead>
								<tr>
									<th>&nbsp;</th>
									<th>营业厅编码&nbsp;&nbsp;&nbsp;&nbsp;</th>
									<th>营业厅名称&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
									<th>月份&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
									<th>检查成绩&nbsp;&nbsp;&nbsp;&nbsp;</th>
									<th></th>
								</tr>	
								</thead>
								
								<tbody>
								<c:forEach items="${requestScope.TbStandardcheck}" var="tbStandardcheck">
								<tr>
									<td><input type="radio" name="selectBusinessHall" value="${tbStandardcheck.organizationNj.orgid}" checked></td>
                        			<td>${tbStandardcheck.organizationNj.orgid}</td>
									<td>${tbStandardcheck.org_Name}</td>
									<td>${tbStandardcheck.checkdate}</td>
									<td>${tbStandardcheck.checkscore}</td>
									<td>
									<div class="hidden-sm hidden-xs action-buttons">
											<a class="green" onclick="Modify(this)"  href="standardVisit.standard.standardSearch.update.do"> 
												<i class="fa fa-pencil bigger-130">修改</i>
											</a>							
									</div>
									</td>
								</tr>		
								</c:forEach>
								</table>
								<table style="width: 95%" cellspacing="0" cellpadding="0" align="center">
								<tr>
									<td  class="page" >
										&nbsp;共5页 当前第1页 
									<a href="#">首页</a> 
									<a href="#">上一页</a> 
									<a href="#">下一页</a> 
									<a href="#">末页</a>
									</td>
								</tr>
								</tbody>
								</table>
								<div id="grid-pager"></div>
								<script type="text/javascript">
									var $path_base = "..";//in Ace demo this will be used for editurl parameter
								</script>
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