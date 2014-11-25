<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags"  prefix="s" %>
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
<form  name="form1" action="../../../updateend_CstService.action" method="post" id="ff">
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="back();">返回</button> 
	<input type="submit" name="btupdate" id="btupdate" value="保存"/> 
</div>
<table class="query_form_table">
	<tr>
		<th>编号</th>
		<td>${oldcstService.svrId}<input type="hidden" name="cstService.svrId" value="${oldcstService.svrId}"/></td>
		<th>服务类型</th>
		<td>
			${oldcstService.svrType}<input type="hidden" name="cstService.svrType" value="${oldcstService.svrType}"/></td>
	</tr>
	<tr>
		<th>概要</th>
		<td colspan="3">${oldcstService.svrTitle}<input type="hidden" name="cstService.svrTitle" value="${oldcstService.svrTitle}"/></td>
	</tr>	
	<tr>
		<th>客户</th>
		<td>${oldcstService.svrCustName}<input type="hidden" name="cstService.svrCustName" value="${oldcstService.svrCustName}"/></td>
		<th>状态</th>
			<td><input type="hidden" name="cstService.svrStatus" value="已归档"/>${oldcstService.svrStatus}</td>
	</tr>	
	<tr>
		<th>服务请求</th>
		<td colspan="3">${oldcstService.svrRequest}<input type="hidden" name="cstService.svrRequest" value="${oldcstService.svrRequest}"/><br>
　</td>
	</tr>
	<tr>
		<th>创建人</th>
		<td>${oldcstService.svrCreateBy}<input type="hidden" name="cstService.svrCreateBy" value="${oldcstService.svrCreateBy}"/></td>
		<th>创建时间</th>
		<td>${oldcstService.svrCreateDate}<input type="hidden" name="cstService.svrCreateDate" value="${oldcstService.svrCreateDate}"/></td>
	</tr>
	</table>
<br />
<table class="query_form_table" id="table3">
	<tr>
		<th>分配给</th>
		<td>${oldcstService.svrDueTo}<input type="hidden" name="cstService.svrDueTo" value="${oldcstService.svrDueTo}"/></td>
		<th>分配时间</th>
		<td>${oldcstService.svrDueDate}<input type="hidden" name="cstService.svrDueDate" value="${oldcstService.svrDueDate}"/></td>
	</tr>
</table>
<br />	
<table class="query_form_table" id="table1">
	<tr>
		<th>服务处理</th>
		<td colspan="3">${oldcstService.svrDeal}<input type="hidden" name="cstService.svrDeal" value="${oldcstService.svrDeal}"/></td>
	</tr>
	<tr>
		<th>处理人</th>
		<td>${oldcstService.svrDealBy}<input type="hidden" name="cstService.svrDealBy" value="${oldcstService.svrDealBy}"/></td>
		<th>处理时间</th>
		<td>${oldcstService.svrDealDate}<input type="hidden" name="cstService.svrDealDate" value="${oldcstService.svrDealDate}"/></td>
	</tr>
</table>
<br />
<table class="query_form_table" id="table2">
	<tr>
		<th>处理结果</th>
		<td><input name="cstService.svrResult" id="svrResult" size="20" /><span class="red_star">*</span></td>
		<th>满意度</th>
		<td>
			<select name="cstService.svrSatisfy" id="svrSatisfy">
				<option value="0">请选择...</option>
				<option value="5">☆☆☆☆☆</option>
				<option value="4">☆☆☆☆</option>
				<option value="3">☆☆☆</option>
				<option value="2">☆☆</option>
				<option value="1">☆</option>
			</select><span class="red_star">*</span></td>
	</tr>
</table>
</form>
</body>
</html>
