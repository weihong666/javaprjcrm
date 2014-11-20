<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

<div class="page_title">数据字典管理 > 编辑数据字典条目</div>
<s:form action="../../update_BasDict.action" id="btsave" method="post">
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="back();">返回</button>
	<button id="btupdate" class="common_button" type="submit">保存</button>
</div>
<table class="query_form_table">
	<tr>
		<th>编号</th>
		<td>${oldbasdict.dictId }</td>
		<th>类别</th>
		<td><input value="${oldbasdict.dictType }" id="dictType" name="basDict.dictType" class="easyui-validatebox" data-options="required:true"/>
		<input type="hidden" id="dictType" name="basDict.dictId" value="${oldbasdict.dictId }" />
		<span class="red_star">*</span><br /></td>
	     
	</tr>
	<tr>
		<th>条目</th>
		<td><input value="${oldbasdict.dictItem }" id="dictItem" name="basDict.dictItem" class="easyui-validatebox" data-options="required:true" /><span class="red_star">*</span></td>
		<th>值</th>
		<td><input value="${oldbasdict.dictValue }" id="dictValue" name="basDict.dictValue" class="easyui-validatebox" data-options="required:true" /><span class="red_star">*</span></td>
	</tr>	
	<tr>
		<th>是否可编辑</th>
		<td><input type="checkbox" id="" name="basDict.dictIsEditable" value="1" /></td>
		<th>&nbsp;</th>
		<td>&nbsp;</td>
	</tr>
</table>
</s:form>
</body>
</html>
