<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<s:if test="#session.oldsalChance==null">
	<c:redirect url="findAll_SalChance.action"></c:redirect>
</s:if>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>jb-aptech毕业设计项目</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css"
	href="../../jquery-easyui-1.3.4/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="../../jquery-easyui-1.3.4/themes/icon.css">
	<link rel="stylesheet" href="../../css/style.css" type="text/css"></link>
<script type="text/javascript"
	src="../../jquery-easyui-1.3.4/jquery-1.9.1.js"></script>
<script type="text/javascript"
	src="../../jquery-easyui-1.3.4/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="../../jquery-easyui-1.3.4/locale/easyui-lang-zh_CN.js"></script>
   <link href="../css/style.css" rel="stylesheet" type="text/css">
    <script src="../script/common.js"></script>
</head>
<body>

<div class="page_title">销售机会管理&nbsp; &gt; 编辑销售机会</div>
<form action="../../update_SalChance.action" method="post" name="form1" id="ff">
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="back();" type="button">返回</button>
	<button class="common_button" type="submit">保存</button>  
</div>
<table class="query_form_table">
	<tr>
		<th>编号</th>
		<td><s:textfield name="salChance.chcId" value="%{#session.oldsalChance.chcId}" readonly="true"/></td>
		<th>机会来源</th>
		<td>
			<s:textfield name="salChance.chcSource" size="20" value="%{#session.oldsalChance.chcSource}"/></td>
	</tr>
	<tr>
		<th>客户名称</th>
		<td><s:textfield name="salChance.chcCustName" value="%{#session.oldsalChance.chcCustName}"/><span class="red_star">*</span></td>
		<th>成功机率</th>
		<td><s:textfield name="salChance.chcRate" value="%{#session.oldsalChance.chcRate}"/><span class="red_star">*</span></td>
	</tr>	
	<tr>
		<th>概要</th>
		<td colspan="3"><s:textfield name="salChance.chcTitle" size="52" value="%{#session.oldsalChance.chcTitle}"/><span class="red_star">*</span></td>
	</tr>
	<tr>
		<th>联系人</th>
		<td><s:textfield name="salChance.chcLinkman" size="20" value="%{#session.oldsalChance.chcLinkman}"/></td>
		<th>联系人电话</th>
		<td><s:textfield name="salChance.chcTel" size="20" value="%{#session.oldsalChance.chcTel}"/></td>
	</tr>
	<tr>
		<th>机会描述</th>
		<td colspan="3"><s:textarea rows="6" cols="50" name="salChance.chcDesc" value="%{#session.oldsalChance.chcDesc}"></s:textarea><span class="red_star">*</span></td>
	</tr>
	<tr>
		<th>创建人</th>
		<td>
		<s:textfield name="salChance.chcCreateBy" value="%{#session.user.usrName }" readonly="true" size="20" id="chcCreateBy" />
		<s:hidden name="salChance.chcCreateId" id="chcCreateId" />
		<s:hidden name="salChance.chcStatus" id="chcStatus" />
		<span class="red_star">*</span>
		</td>
		<th>创建时间</th>
		<td><s:textfield id="t1" name="salChance.chcCreateDate" readonly="true" size="20" value="%{#session.oldsalChance.chcCreateDate}"/><span class="red_star">*</span></td>
	</tr>
</table>
<br />
<table disabled class="query_form_table" id="table1">
	<tr>
		<th>指派给</th>
		<td>
			<s:select name="salChance.chcDueId" list="#session.lisysuser"
							listKey="usrId" listValue="usrName" value="usrId"
							headerValue="请选择..." headerKey="-1" id="dueId"/>
			<s:hidden name="salChance.chcDueId"></s:hidden>
			<span class="red_star">*</span>
			</td>
		<th>指派时间</th>
		<td>
			<input id="t2" name="salChance.chcDueDate" readonly="true" size="20" /><span class="red_star">*</span></td>
	</tr>
</table>
<script>
	setCurTime('t1');
	setCurTime('t2');
</script>
</form>
</body>
</html>
