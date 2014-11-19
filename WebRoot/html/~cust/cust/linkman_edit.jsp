<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>jb-aptech毕业设计项目</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="../../css/style.css" rel="stylesheet" type="text/css">
<script src="../../script/common.js"></script>

</head>
<body>

<div class="page_title">客户信息管理 > 客户信息 > 联系人 > 编辑联系人</div>
<form action="../../../update_CstLinkman.action" method="post">
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="back();">返回</button>
	<button class="common_button" type="submit">保存</button>  
</div>
<table class="query_form_table" id="table1">
	<tr>
		<th>姓名</th>
		<td>
		<s:textfield readonly="readonly" name="linkman.lkmName" value="%{#session.oldlinkman.lkmName}" size="20" /><span class="red_star">*</span>
		<s:hidden name="linkman.lkmId"  value="%{#session.oldlinkman.lkmId}"/>
      	<s:hidden name="linkman.cstCustomer.custId"  value="%{#session.oldlinkman.cstCustomer.custId}"/>
      
		</td>
		
		<th>性别</th>
		<td>
		<s:radio name="linkman.lkmSex" list="#{'男':'男','女':'女'}" listKey="key" listValue="value" value="%{#session.oldlinkman.lkmSex}"/>
		</td>
	</tr>
	<tr>
		<th>职位</th>
		<td><s:textfield name="linkman.lkmPostion" value="%{#session.oldlinkman.lkmPostion}" size="20" /><span class="red_star">*</span></td>
		<th>办公电话</th>
		<td><s:textfield name="linkman.lkmTel" value="%{#session.oldlinkman.lkmTel}" size="20" /><span class="red_star">*</span></td>
	</tr>	
	<tr>
		<th>手机</th>
		<td><s:textfield  name="linkman.lkmMobile" value="%{#session.oldlinkman.lkmMobile}" size="20" /></td>
		
		<th>备注</th>
		<td><s:textfield name="linkman.lkmMemo" /></td>
	</tr>
</table>
</form>
</body>
</html>
