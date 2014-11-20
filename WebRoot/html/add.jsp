<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>jb-aptech毕业设计项目</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="css/style.css" rel="stylesheet" type="text/css">
<script src="script/common.js"></script>
</head>
<body>

<div class="page_title">用户信息管理 >用户信息 >新建用户</div>
<form action="../save_SysUser.action" method="post" >
<div class="button_bar">
	<button class="common_button" onclick="help('');" type="button">帮助</button>
	<button class="common_button" onclick="back();" type="button">返回</button>
	<button class="common_button" type="submit">保存</button>  
</div>
<table class="query_form_table">
	<tr>
		<th>姓名</th>
		<td><input name="sysUser.usrName"/>
		<%--<input type="hidden" name="linkman.cstCustomer.custId" value="${custId }" size="20" />
		--%><span class="red_star">*</span>
		<th>密码</th>
		<td><input name="sysUser.usrPassword"/>
		</td>
	</tr>
	<tr>
		<th>昵称</th>
		<td><input name="sysUser.usrRoleName"/><span class="red_star">*</span></td>
		<th>用户角色</th>
		<td><select name="sysUser.usrAlevel">
		<option value="1">客户经理</option>
		<option value="0">普通员工</option>
		</select>
		<span class="red_star">*</span></td>
	</tr>	
	
</table>
</form>
</body>
</html>
