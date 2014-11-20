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
<link href="../../css/style.css" rel="stylesheet" type="text/css">
<script src="../../script/common.js"></script>
</head>
<body>

<div class="page_title">客户信息管理 &gt; 客户信息 &gt; 历史订单 &gt; 订单明细 </div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="back();" type="button">返回</button>  
</div>
<table class="query_form_table" height="59">
	<tr>
		<th>订单编号</th>
		<td>${oldorders.odrId }</td>
		<th>日期</th>
		<td>${oldorders.odrDate }</td>
	</tr>
	<tr>
		<th height="28">送货地址</th>
		<td>${oldorders.odrAddr }　</td>
		<th height="28">总金额（元）</th>
		<td>${oldorders.odrTotal }</td>
	</tr>
	<tr>
		<th height="28">状态</th>
		<td>${oldorders.odrStatus }　</td>
		<th height="28">&nbsp;</th>
		<td>&nbsp;</td>
	</tr>
	</table>
<br />

<table class="easyui-datagrid" style="height:410px;"
		data-options="
        url:'../../../findAll_OrdersLine.action?id=${oldorders.odrId }&t=<%=new Date().getTime() %>',
        fitColumns:true, 
        singleSelect:true"
		pagination="true" rownumbers="true" pageSize="10"
		pageList="[5,10,15,20]" loadMsg="正在在加载远程数据，请稍后......" align="center"
		id="tt">
		<thead>
			<tr>
				<th data-options="field:'Name',width:100,align:'center',
				formatter: function(value,row,index){
						if (row.product){
							return row.product.prodName;
						} else {
							return value;
							}
				}
				">商品</th>
				<th data-options="field:'oddCount',width:100,align:'center',
				formatter: function(value,row,index){
						if (row.product){
							return row.product.prodBatch;
						} else {
							return value;
							}
				}
				">数量</th>
				<th data-options="field:'oddUnit',width:100,align:'center',
				formatter: function(value,row,index){
						if (row.product){
							return row.product.prodBatch;
						} else {
							return value;
							}
				}
				">单位</th>
				<th data-options="field:'oddPrice',width:100,align:'center',
				formatter: function(value,row,index){
						if (row.product){
							return row.product.prodPrice;
						} else {
							return value;
							}
				}
				">单价（元）</th>
				<th data-options="field:'custManagerName',width:100,align:'center',
				formatter: function(value,row,index){
						if (row.product){
							return row.product.prodPrice*row.product.prodBatch;
						} else {
							return value;
							}
				}
				">金额（元）</th>
				
			</tr>
		</thead>
	</table>

</body>
</html>
