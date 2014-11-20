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

<div class="page_title">客户信息管理 > 用户信息信息 >编辑用户</div>

<form action="../update_SysUser.action?t=<%=new Date().getTime() %>" method="post">
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="back();" type="button">返回</button>
	<button class="common_button" type="submit">保存</button>  
</div>
<table class="query_form_table" id="table1">
	<tr>
		<th>姓名</th>
		<td>
		<s:textfield  name="sysUser.usrName" value="%{#session.user.usrName}" size="20" /><span class="red_star">*</span>
		<s:hidden name="sysUser.usrId"  value="%{#session.user.usrId}"/>
		<s:hidden name="sysUser.usrAlevel"  value="%{#session.user.usrAlevel}"/>
      
      
		</td>
		
		<th>密码</th>
		<td>
		<s:textfield  name="sysUser.usrPassword"  value="%{#session.user.usrPassword}"/>
		</td>
	</tr>
	<tr>
		<th>昵称</th>
		<td><s:textfield name="sysUser.usrRoleName" value="%{#session.user.usrRoleName}" size="20" /><span class="red_star">*</span></td>
	</tr>	
	
</table>
</form>

</body>
</html>
