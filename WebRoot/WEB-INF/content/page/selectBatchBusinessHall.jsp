<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html >
<head>
<meta http-equiv="Content-Language" content="en-us" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<base target="main" />
<link rel="stylesheet" type="text/css" href="../css/frontmiddle.css" />
<script language="javascript">

</script>
<script src="../js/Calendar.js" type="text/javascript"></script>
</head>

<body>
	<table  cellspacing="0" cellpadding="0" class="tablewk" align="center">
		<tr>
			<td >
				<br />
				<table cellpadding="0" cellspacing="0" width="95%" style="height: 30px" align="center">
					<tr>
						<td class=" titlebold">营业厅查询</td>
					</tr>
				</table>
				<table cellpadding="0" cellspacing="0" width="95%"  align="center">
					<tr>
						<td class="line"></td>
					</tr>
				</table>
				<br />
				<form name="form1">
					<table cellpadding="0" cellspacing="0" width="95%"  align="center" class="tableserch">
						<tr>
							<td align="right">区域：</td>
							<td align="left">
								<select name="select" style="width:155px;">
									<option value="0"></option>
									<option value="1">城东</option>
									<option value="2">城南</option>
									<option value="3">城西</option>
									<option value="4">城北</option>
								</select>
							</td>
							<td align="right">片区：</td>
							<td align="left">
								<select name="select2" style="width:155px;">
									<option value="0"></option>
									<option value="1">鼓楼区</option>
									<option value="2">白下区</option>
									<option value="3">下关区</option>
									<option value="4">鼓楼区</option>
								</select>
							</td>
						</tr>
						<tr>
							<td align="right">营业厅编码：</td>
							<td align="left"><input type="text" name="businessHallCode" /></td>
							<td align="right">营业厅名称：</td>
							<td align="left"><input type="text" name="businessHallName" /></td>
						</tr>
						<tr>
							<td colspan="4" align="center">
								<input name="Button1" type="button" value="查询" class="btn_2" />
								<input name="Button2" type="reset" value="重置" class="btn_2" />
							</td>
						</tr>
					</table>
				</form>
				<br />
				<table cellpadding="0" cellspacing="0" class="tablelist" align="center">
					<tr>
						<th>&nbsp;</th>
						<th>序号</th>
						<th>营业厅编码</th>
						<th>营业厅名称</th>
						<th>区域</th>
						<th>片区</th>
					</tr>	
					<tr>
						<td align="center"><input type="checkbox" name="checkbox1" value="0"></td>
						<td>1</td>
						<td>A001</td>
						<td>南京新华书店沟通100服务</td>
						<td>城西</td>
						<td>鼓楼区</td>
					</tr>	
					<tr>
						<td align="center"><input type="checkbox" name="checkbox2" value="1"></td>
						<td>2</td>
						<td>A002</td>
						<td>国美淮海路指定专营店</td>
						<td>城南</td>
						<td>白下区</td>
					</tr>	
					<tr>
						<td align="center"><input type="checkbox" name="checkbox3" value="2"></td>
						<td>3</td>
						<td>A003</td>
						<td>中央商场指定专营店</td>
						<td>城南</td>
						<td>下关区</td>
					</tr>	
					<tr>
						<td align="center"><input type="checkbox" name="checkbox4" value="3"></td>
						<td>4</td>
						<td>A004</td>
						<td>中山北路指定专营店</td>
						<td>城北</td>
						<td>下关区</td>
					</tr>	
					<tr>
						<td align="center"><input type="checkbox" name="checkbox5" value="4"></td>
						<td>5</td>
						<td>A005</td>
						<td>南京新华书店沟通100服务</td>
						<td>城东</td>
						<td>鼓楼区</td>
					</tr>	
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
				</table>
				<br />
				<table cellpadding="0" cellspacing="0" width="95%" align="center">
					<tr>
						<td align="center" >
							<input type="button" name="doSelectButton" value="确定" class="btn_2" onclick="window.close();"/>
							<input type="button" name="doCloseButton" value="关闭" class="btn_2" onclick="window.close();"/>
						</td>
					</tr>
				</table>
				<br />
			</td>
		</tr>
	</table>
</body>
</html>