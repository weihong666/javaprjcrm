<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
<title>客户关系管理系统</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
</head>

<body style="border-bottom:solid 1px #666;">

<TABLE style="width:100%;">
<TR >
	<td ><img src="images/logo.gif"></td>
	<td style="font-family:黑体;font-size:33px;font-weight:bold;"> 客户关系管理系统</td>	
	<td width="25%" align="right" style="font-size:12px;" valign="bottom">当前用户：${user.usrName }
	<s:if test="#session.user.usrAlevel==1">(客户经理)</s:if>
	<s:if test="#session.user.usrAlevel==0">(普通员工)</s:if>
	&nbsp;&nbsp;<a href="../logout.jsp"  target="_parent">退出系统</a>  </td>
</tr>
</table>
</body>
</html>
