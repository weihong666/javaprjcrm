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

<div class="page_title">客户流失管理 &gt; 确认流失</div>
<form action="../../../update_CstLost.action" method="post" name="form1" id="form1">
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	
	<button class="common_button" onclick="back();">返回</button>
	<button class="common_button" onclick="to('relay.jsp');" type="button">暂缓流失</button>
	<button class="common_button" type="submit">保存</button>
</div>
<table class="query_form_table">
	<tr>
		<th>编号</th>
		<td>${oldcstLost.lstId }
		<input type="hidden" name="cstLost.lstId" value="${oldcstLost.lstId }"/> 
		<input type="hidden" name="cstLost.cstCustomer.custId" value="${oldcstLost.cstCustomer.custId }"/> 
		</td>
		<th>客户</th>
		
		<td>${oldcstLost.lstCustName }
		<input type="hidden" name="cstLost.lstCustName" value="${oldcstLost.lstCustName }"/> 
		</td>
	</tr>
	<tr>
		<th>客户经理</th>
		<td>${oldcstLost.lstCustManagerName }
		<input type="hidden" name="cstLost.lstCustManagerName" value="${oldcstLost.lstCustManagerName }"/> 
		</td>
		<th>上次下单时间</th>
		<td>${oldcstLost.lstLastOrderDate }
		<input type="hidden" name="cstLost.lstLastOrderDate" value="${oldcstLost.lstLastOrderDate }"/> 
		</td>
	</tr>
	<tr>
		<th>暂缓措施</th>
		<td colspan="3">${oldcstLost.lstDelay }
		<input type="hidden" name="cstLost.lstDelay" value="${oldcstLost.lstDelay }"/>
		<input type="hidden" name="cstLost.lstStatus" value="已流失"/>
		<input type="hidden" name="cstLost.lstLostDate" value="${oldcstLost.lstLostDate }"/>
		</td>
	</tr>	
	<tr>
		<th>流失原因</th>
		<td colspan="3">
			<textarea rows="6" cols="50" name="cstLost.lstReason"></textarea><span class="red_star">*</span></td>
	</tr>
</table>
<br />
</form>
</body>
</html>
