<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>jb-aptech毕业设计项目</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css"
	href="../../../jquery-easyui-1.3.4/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="../../../jquery-easyui-1.3.4/themes/icon.css">
	<link rel="stylesheet" href="../../css/style.css" type="text/css"></link>
<script type="text/javascript"
	src="../../../jquery-easyui-1.3.4/jquery-1.9.1.js"></script>
<script type="text/javascript"
	src="../../../jquery-easyui-1.3.4/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="../../../jquery-easyui-1.3.4/locale/easyui-lang-zh_CN.js"></script>
<link href="../../css/style.css" rel="stylesheet" type="text/css">
<script src="../../script/common.js"></script>
</head>


<body>

	<div class="page_title">客户信息管理 > 客户信息 > 交往记录 > 新建交往记录</div>
	<form action="../../../save_CstActivity.action" method="post">
		<div class="button_bar">
			<button class="common_button" onclick="help('');" type="button">帮助</button>
			<button class="common_button" onclick="back();" type="button">返回</button>
			<button class="common_button" type="submit">保存</button>
		</div>
		<table class="query_form_table">
			<tr>
				<th>时间</th>
				<td>
					<input name="activity.atvDate" class="easyui-datebox" />
			<%--
		<input name="activity.atvDate" />--%> 

					<input type=hidden name="activity.cstCustomer.custId"
					value="${custId }" /> <span class="red_star">*</span>
				</td>
				<th>地点</th>
				<td><input name="activity.atvPlace" size="20" /><span
					class="red_star">*</span>
				</td>
			</tr>
			<tr>
				<th>概要</th>
				<td><input name="activity.atvTitle" /><span class="red_star">*</span>
				</td>
				<th>客户活动名称</th>
				<td><input name="activity.atvCustName" />
				</td>
			</tr>
			<tr>
				<th>详细信息</th>
				<td colspan="3"><textarea name="activity.atvDesc" cols="50"
						rows="6"> </textarea></td>
			</tr>
		</table>
	</form>
</body>
</html>
