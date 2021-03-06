<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s" %>

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


<script src="../../script/common.js"></script>
<link href="../../css/style.css" rel="stylesheet" type="text/css">
<script src="../../script/common.js"></script>
</head>
<%
String custId=request.getParameter("custId");
String custName=request.getParameter("custName");
if(custId!=null)custId=new String(custId.getBytes("iso8859-1"),"utf-8");
if(custName!=null)custName=new String(custName.getBytes("iso8859-1"),"utf-8");
request.setAttribute("custId", custId);
request.setAttribute("custName", custName);
%>
<body>

<div class="page_title">客户信息管理 &gt; 客户信息 &gt; 交往记录</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="to('activities_add.jsp');">新建</button>  
	<button class="common_button" onclick="back();" type="button">返回</button>  
</div>
<table class="query_form_table">
	<tr>
		<th>客户编号</th>
		<td>${custId }</td>
		<th>客户名称</th>
		<td>${custName }</td>
	</tr>
	</table>
<br />
<table class="easyui-datagrid" style="height:410px;"
		data-options="
        url:'../../../findAll_CstActivity.action?custId=${custId}',
        fitColumns:true, 
        singleSelect:true"
		pagination="true" rownumbers="true" pageSize="10"
		pageList="[5,10,15,20]" loadMsg="正在在加载远程数据，请稍后......" align="center"
		id="tt">
		<thead>
			<tr>
				<th data-options="field:'atvCustName',width:100,align:'center'">活动名称</th>
				<th data-options="field:'atvDate',width:300,align:'center'">时间</th>
				<th data-options="field:'atvPlace',width:100,align:'center'">地点</th>
				<th data-options="field:'atvTitle',width:100,align:'center'">概要</th>
				<th data-options="field:'atvDesc',width:100,align:'center'">详细信息</th>


				<th
					data-options="field:'opt',
	  width:300,
	           align:'center',
	           formatter:function(value,row,index){
	           return '<a href=../../../findById_CstActivity?id='+row.atvId+'&t=<%=new Date().getTime()%> ><img title=编辑 src=../../images/bt_edit.gif class=op_button /></a>'
	          
	           +'<a href=../../../delById_CstActivity?id='+row.atvId+'&t=<%=new Date().getTime()%> ><img title=删除 src=../../images/bt_del.gif class=op_buttons /></a>';
					} 	
	            ">操作</th>
			</tr>
		</thead>
	</table>
</body>
</html>
