<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
<title>�ͻ���ϵ����ϵͳ</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
</head>

<body style="border-bottom:solid 1px #666;">

<TABLE style="width:100%;">
<TR >
	<td ><img src="images/logo.gif"></td>
	<td style="font-family:����;font-size:33px;font-weight:bold;"> �ͻ���ϵ����ϵͳ</td>	
	<td width="25%" align="right" style="font-size:12px;" valign="bottom">��ǰ�û���${user.usrName }
	<s:if test="#session.user.usrAlevel==1">(�ͻ�����)</s:if>
	<s:if test="#session.user.usrAlevel==0">(��ͨԱ��)</s:if>
	&nbsp;&nbsp;<a href="../logout.jsp"  target="_parent">�˳�ϵͳ</a>  </td>
</tr>
</table>
</body>
</html>
