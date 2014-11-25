<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>jb-aptech毕业设计项目</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="../../css/style.css" rel="stylesheet" type="text/css">
<script src="../../script/common.js"></script>
</head>
<body>

<div class="page_title">客户服务管理 &gt; 服务处理</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="back();">返回</button>  
</div>
<table class="query_form_table">
	<tr>
		<th>编号</th>
		<td>${oldcstService.svrId}</td>
		<th>服务类型</th>
		<td>${oldcstService.svrType}</td>
	</tr>
	<tr>
		<th>概要</th>
		<td colspan="3">${oldcstService.svrTitle}</td>
	</tr>	
	<tr>
		<th>客户</th>
		<td>${oldcstService.svrCustName}</td>
		<th>状态</th>
		<td>${oldcstService.svrStatus}</td>
	</tr>	
	<tr>
		<th>服务请求</th>
		<td colspan="3">${oldcstService.svrRequest}<br>
　</td>
	</tr>
	<tr>
		<th>创建人</th>
		<td>${oldcstService.svrCreateBy}</td>
		<th>创建时间</th>
		<td>${oldcstService.svrCreateDate}</td>
	</tr>
	</table>
<br />
<table class="query_form_table" id="table3">
	<tr>
		<th>分配给</th>
		<td>
			${oldcstService.svrDueTo}</td>
		<th>分配时间</th>
		<td>${oldcstService.svrDueDate}</td>
	</tr>
</table>
<br />	
<table class="query_form_table" id="table1">
	<tr>
		<th>服务处理</th>
		<td colspan="3">${oldcstService.svrDeal}</td>
	</tr>
	<tr>
		<th>处理人</th>
		<td>${oldcstService.svrDealBy}</td>
		<th>处理时间</th>
		<td>${oldcstService.svrDealDate}</td>
	</tr>
</table>
<br />
<table class="query_form_table" id="table2">
	<tr>
		<th>处理结果</th>
		<td>${oldcstService.svrResult}</td>
		<th>满意度</th>
		<td>
		<c:if test="${oldcstService.svrSatisfy eq 5}">
		<img src="../../images/star.jpg" class="star_pic" />
		<img src="../../images/star.jpg" class="star_pic" />
		<img src="../../images/star.jpg" class="star_pic" />
		<img src="../../images/star.jpg" class="star_pic" />
		<img src="../../images/star.jpg" class="star_pic" />
		</c:if>
		<c:if test="${oldcstService.svrSatisfy eq 4}">
		<img src="../../images/star.jpg" class="star_pic" />
		<img src="../../images/star.jpg" class="star_pic" />
		<img src="../../images/star.jpg" class="star_pic" />
		<img src="../../images/star.jpg" class="star_pic" />
		</c:if>
		<c:if test="${oldcstService.svrSatisfy eq 3}">
		<img src="../../images/star.jpg" class="star_pic" />
		<img src="../../images/star.jpg" class="star_pic" />
		<img src="../../images/star.jpg" class="star_pic" />
		</c:if>
		<c:if test="${oldcstService.svrSatisfy eq 2}">
		<img src="../../images/star.jpg" class="star_pic" />
		<img src="../../images/star.jpg" class="star_pic" />
		</c:if>
		<c:if test="${oldcstService.svrSatisfy eq 1}">
		<img src="../../images/star.jpg" class="star_pic" />
		</c:if>
		</td>
	</tr>
</table>
</body>
</html>
