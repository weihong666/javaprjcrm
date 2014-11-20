<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<s:if test="#session.oldcstActivity==null">
	<c:redirect url="../../../findAll_CstActivity.action"></c:redirect>
</s:if>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>jb-aptech毕业设计项目</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="../../css/style.css" rel="stylesheet" type="text/css">
<script src="../../script/common.js"></script>
</head>
<body>

<div class="page_title">客户信息管理 &gt; 客户信息 &gt; 交往记录 &gt; 编辑交往记录</div>
<form action="../../../update_CstActivity" method="post">
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="back();" type="button">返回</button>
	<button type="submit" class="common_button">保存</button>  
</div>
<table class="query_form_table" id="table1">
	<tr>
		<th>时间</th>
		<td>
		<s:textfield name="activity.atvDate"  class="easyui-datebox" value="%{#session.oldcstActivity.atvDate.toLocaleString()}" size="20" />
      	<s:hidden name="activity.atvId"  value="%{#session.oldcstActivity.atvId}"/>
      	<s:hidden name="activity.cstCustomer.custId"  value="%{#session.oldcstActivity.cstCustomer.custId}"/>
      
		<span class="red_star">*</span></td>
		<th>地点</th>
		<td>
			<s:textfield name="activity.atvPlace" value="%{#session.oldcstActivity.atvPlace}" size="20" />
			<span class="red_star">*</span></td>
	</tr>
	<tr>
		<th>概要</th>
		<td>
		<s:textfield name="activity.atvTitle" value="%{#session.oldcstActivity.atvTitle}" size="20" />
		<span class="red_star">*</span></td>
		<th>客户活动名称</th>
		<td><s:textfield name="activity.atvCustName" value="%{#session.oldcstActivity.atvCustName}" size="20" /></td>
	</tr>	
	<tr>
		<th>详细信息</th>
		<td colspan="3">
			<s:textarea cols="50" rows="6"  name="activity.atvDesc" value="%{#session.oldcstActivity.atvDesc}" />
		</td>
	</tr>
</table>
</form>
</body>
</html>
