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

<div class="page_title">客户流失管理 &gt; 暂缓流失</div>
<form action="../../../updateold_CstLost.action" method="post">
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	
	<button class="common_button" onclick="back();" type="button" type="button">返回</button>
	<button class="common_button" onclick="to('list.jsp');" type="button">确认流失</button>
	<button class="common_button" type="submit">保存</button>
</div>
<table class="query_form_table">
<tr>
		<th>编号</th>
		<td>${oodcstLost.lstId }
		<input type="hidden" name="cstLost.lstId" value="${oodcstLost.lstId }"/> 
		<input type="hidden" name="cstLost.cstCustomer.custId" value="${oodcstLost.cstCustomer.custId }"/> 
		</td>
		<th>客户</th>
		
		<td>${oodcstLost.lstCustName }
	<input type="hidden" name="cstLost.lstCustName" value="${oodcstLost.lstCustName }"/>
		</td>
	</tr>
	<tr>
		<th>客户经理</th>
		<td>${oodcstLost.lstCustManagerName }
		<input type="hidden" name="cstLost.lstCustManagerName" value="${oodcstLost.lstCustManagerName }"/> 
		</td>
		<th>上次下单时间</th>
		<td>${oodcstLost.lstLastOrderDate }
		<input type="hidden" name="cstLost.lstLastOrderDate" value="${oodcstLost.lstLastOrderDate }"/> 
		</td>
	</tr>
	<tr>
		<th>暂缓措施</th>
		<td colspan="3">${oodcstLost.lstDelay }
		<input type="hidden" name="cstLost.lstDelay" value="${oodcstLost.lstDelay }"/>
		<input type="hidden" name="cstLost.lstStatus" value="${oodcstLost.lstStatus }"/>
		<input type="hidden" name="cstLost.lstLostDate" value="${oodcstLost.lstLostDate }"/>
		</td>
	</tr>	
	<tr>
		<th>追加暂缓措施</th>
		<td colspan="3">
			<textarea rows="6" cols="50" name="cstLost.lstDelay">${oodcstLost.lstDelay }<br></textarea><span class="red_star">*</span></td>
	</tr>
	<%--<tr>
		<th>编号</th>
		<td>1</td>
		<th>客户</th>
		<td>阳光实业</td>
	</tr>
	<tr>
		<th>客户经理</th>
		<td>
			球球</td>
		<th>上次下单时间</th>
		<td>
			2005年12月07日</td>
	</tr>	
	<tr>
		<th>暂缓措施</th>
		<td colspan="3">
			打电话给客户了解不再购买本公司产品的原因。<br>
			发送新产品目录给客户。</td>
	</tr>
	<tr>
		<th>追加暂缓措施</th>
		<td colspan="3">
			<textarea rows="6" cols="50"></textarea><span class="red_star">*</span></td>
	</tr>
--%></table>
</form>
<br />
</body>
</html>
