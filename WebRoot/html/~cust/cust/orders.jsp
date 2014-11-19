<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

<div class="page_title">客户信息管理 > 客户信息 > 历史订单 </div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>  
	<button class="common_button" onclick="back();">返回</button>  
</div>
<table class="query_form_table">
	<tr>
		<th>客户编号</th>
		<td>${custId}</td>
		<th>客户名称</th>
		<td>${custName}</td>
	</tr>
	</table>
<br />

<table class="easyui-datagrid" style="height:410px;"
		data-options="
        url:'../../../findAll_Orders.action?custId=${custId}',
        fitColumns:true, 
        singleSelect:true"
		pagination="true" rownumbers="true" pageSize="10"
		pageList="[5,10,15,20]" loadMsg="正在在加载远程数据，请稍后......" align="center"
		id="tt">
		<thead>
			<tr>
				<th data-options="field:'odrId',width:100,align:'center'">订单编号</th>
				<th data-options="field:'odrDate',width:100,align:'center'">日期</th>
				<th data-options="field:'odrAddr',width:100,align:'center'">送货地址</th>
				
				
				<th data-options="field:'odrStatus',width:200,align:'center',
				formatter: function(value,row,index){
						if (value==1){
							return '已回款';
						} else {
							return '未回款';
							}
				}
				
				">状态</th>


				<th
					data-options="field:'opt',
	  width:300,
	           align:'center',
	           formatter:function(value,row,index){
	           return '<a href=../../../findById_Orders.action?id='+row.odrId+'&t=<%=new Date().getTime()%> ><img title=查看明细 src=../../images/bt_detail.gif class=op_button /></a>';
					} 	
	            ">操作</th>
			</tr>
		</thead>
</table>

<%--<table class="data_list_table">
	<tr>
		<th>订单编号</th>
		<th>日期</th>
		<th>送货地址</th>
		<th>状态</th>
		<th>操作</th>
	</tr>
	<tr>
		<td class="list_data_text">1343445</td>
		<td class="list_data_text">2007年11月13日</td>
		<td class="list_data_text">北京海淀区劳动路205号</td>
		<td class="list_data_text">未回款</td>
		<td class="list_data_op">
			<img onclick="to('orders_detail.jsp');" title="查看明细" src="../../images/bt_detail.gif" class="op_button" /></td>
	</tr>
	<tr>
		<td class="list_data_text">1343444</td>
		<td class="list_data_text">2007年10月29日</td>
		<td class="list_data_text">北京海淀区劳动路205号</td>
		<td class="list_data_text">已回款</td>
		<td class="list_data_op">
			<img onclick="to('orders_detail.jsp');" title="查看明细" src="../../images/bt_detail.gif" class="op_button" />
		</td>
	</tr>
	<tr>
		<td class="list_data_text">1343443</td>
		<td class="list_data_text">2007年10月29日</td>
		<td class="list_data_text">北京海淀区劳动路205号</td>
		<td class="list_data_text">已回款</td>
		<td class="list_data_op">
			<img onclick="to('orders_detail.jsp');" title="查看明细" src="../../images/bt_detail.gif" class="op_button" />
			&nbsp;
		</td>
	</tr>
		<tr>
		<th colspan="100" class="pager">
<div class="pager">
	共59条记录 每页<input value="10" size="2" />条
	第<input value="1" size="2"/>页/共5页
	<a href="#">第一页</a>
	<a href="#">上一页</a>
	<a href="#">下一页</a>
	<a href="#">最后一页</a>
	转到<input value="1" size="2" />页
	<button width="20" onclick="reload();">GO</button>
</div>
		</th>
	</tr>
	</table>
--%></body>
</html>
