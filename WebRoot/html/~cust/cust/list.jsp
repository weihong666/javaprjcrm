<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>jb-aptech毕业设计项目</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<%String path=request.getContextPath(); %>
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
<script type="text/javascript">
$(document).ready(function(){
	//----组合查询---------------------------------		
	$("#select").click(function(){	

		$("#tt").datagrid({
			queryParams: {
				custNo:$("#custNo").val(),
				custName:$("#custName").val(),
				custRegion:$("#custRegion").val(),
				custManagerName:$("#custManagerName").val(),
				custLevelLabel:$("#custLevelLabel").val()

			}
		
		}
		); 

		//清空查询项
		$("#custNo").val("");
		$("#custName").val("");
		$("#custRegion").val("");
		$("#custManagerName").val("");
		$("#custLevelLabel").val("");
		
		
});
	
	});
</script>
</head>

<body>

	<div class="page_title">客户信息管理</div>

	<div class="button_bar">
		<button class="common_button" onclick="help('');">帮助</button>
		<button class="common_button" id="select" >查询</button>
	</div>
	<table class="query_form_table">
		<tr>
			<th>客户编号</th>
			<td><input name="custNo" id="custNo"/></td>
			<th>名称</th>
			<td><input name="custName" id="custName"/>
			</td>
			<th>地区</th>
			<td><select name="custRegion" id="custRegion">
					<option value="">全部</option>
					<option value="北京">北京</option>
					<option value="华北">华北</option>
					<option value="中南">中南</option>
					<option value="东北">东北</option>
					<option value="西部">西部</option>
			</select></td>
		</tr>
		<tr>
			<th>客户经理</th>
			<td><input name="custManagerName" id="custManagerName"/>
			</td>
			<th>客户等级</th>
			<td><select name="custLevelLabel" id="custLevelLabel">
					<option value="">全部</option>
					<option value="战略合作伙伴">战略合作伙伴</option>
					<option value="合作伙伴">合作伙伴</option>
					<option value="大客户">大客户</option>
					<option value="普通客户">普通客户</option>
			</select></td>
			<th></th>
			<td></td>
		</tr>
	</table>

	<br />
	<table class="easyui-datagrid" style="height:410px;"
		data-options="
        url:'../../../findAll_CstCustomer.action?=<%=new Date().getTime() %>',
        fitColumns:true, 
        singleSelect:true"
		pagination="true" rownumbers="true" pageSize="10"
		pageList="[5,10,15,20]" loadMsg="正在在加载远程数据，请稍后......" align="center"
		id="tt">
		<thead>
			<tr>
				<th data-options="field:'custId',width:100,align:'center'">序号</th>
				<th data-options="field:'custNo',width:100,align:'center'">客户编号</th>
				<th data-options="field:'custName',width:100,align:'center'">名称</th>
				<th data-options="field:'custRegion',width:100,align:'center'">地区</th>
				<th data-options="field:'custManagerName',width:100,align:'center'">客户经理</th>
				<th data-options="field:'custLevelLabel',width:100,align:'center'">客户等级</th>
				<th
					data-options="field:'opt',
	  			width:300,
	           align:'center',
	           formatter:function(value,row,index){
	           return '<a href=../../../findById_CstCustomer?id='+row.custId+'&t=<%=new Date().getTime()%>><img title=编辑 src=../../images/bt_edit.gif class=op_button/></a>'
	           +' <a href=activities.jsp?custId='+row.custId+'&custName='+row.custName+'><img title=交往记录 src=../../images/bt_acti.gif class=op_button /></a>'
	           +' <a href=linkman.jsp?custId='+row.custId+'&custName='+row.custName+'><img title=联系人 src=../../images/bt_linkman.gif class=op_button /></a>'
	           +'<a href=orders.jsp?custId='+row.custId+'&custName='+row.custName+' ><img  title=历史订单   src=../../images/bt_orders.gif class=op_button /></a>'
	           +'<a href=../../../delById_CstCustomer?id='+row.custId+' ><img title=删除 src=../../images/bt_del.gif class=op_buttons /></a>';
					} 	
	            ">操作</th>
			</tr>
		</thead>
	</table>
</body>
</html>
