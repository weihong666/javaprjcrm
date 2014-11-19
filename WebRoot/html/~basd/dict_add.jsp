<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

<link href="../css/style.css" rel="stylesheet" type="text/css">
<script src="../script/common.js"></script>
</head>
<body>

<div class="page_title">数据字典管理 > 新建数据字典条目</div>
<s:form id="ff" action="../../save_BasDict.action" method="post">
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="back();" type="button">返回</button>
	<button id="btsave" class="common_button" type="submit">保存</button>  
</div>

<table class="query_form_table" id="tid">
	<tr>
		<th>编号</th>
		<td><input readonly /></td>
		<th>类别</th>
		<td><input name="basDict.dictType" /><span class="red_star">*</span><br />（需要使用Ajax实现自动补全功能）</td>
	</tr>
	<tr>
		<th>条目</th>
		<td><input name="basDict.dictItem" /><span class="red_star">*</span></td>
		<th>值</th>
		<td><input name="basDict.dictValue" /><span class="red_star">*</span></td>
	</tr>	
	<tr>
		<th>是否可编辑</th>
		<!-- <td><s:checkbox name="basDict.dictIsEditable" value="0"/></td> -->
		
	     <td><input type="checkbox" name="basDict.dictIsEditable" id="checkid" value="1" /></td>

	     </tr>
	
</table>
</s:form>
</body>
</html>
