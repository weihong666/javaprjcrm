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
<link href="../../css/style.css" rel="stylesheet" type="text/css">
<script src="../../script/common.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	//----组合查询---------------------------------		
	$("#select").click(function(){	

		$("#tt").datagrid({
			queryParams: {
				lstCustName:$("#lstCustName").val(),
				lstCustManagerName:$("#lstCustManagerName").val(),
				lstStatus:$("#lstStatus").val()

			}
		
		}
		); 

		//清空查询项
		$("#lstCustName").val("");
		$("#lstCustManagerName").val("");
		$("#lstStatus").val("");

		
});
	
	});
</script>
</head>

<body>

<div class="page_title">客户流失管理</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" id="select">查询</button>  
</div>
<table class="query_form_table">
	<tr>
		<th>客户</th>
		<td><input name="lstCustName" id="lstCustName"/></td>
		<th>客户经理</th>
		<td><input name="lstCustManagerName" id="lstCustManagerName"/></td>
		<th>状态</th>
		<td>
			<select name="lstStatus" id="lstStatus">
				<option value="">全部</option>
				<option value="预警">预警</option>
				<option value="暂缓流失">暂缓流失</option>
				<option value="已流失">已流失</option>
			</select>
		</td>
	</tr>
	</table>
<br />
<table class="easyui-datagrid" style="height:410px;"
		data-options="
        url:'../../../findAll_CstLost.action?=<%=new Date().getTime() %>',
        fitColumns:true, 
        singleSelect:true"
		pagination="true" rownumbers="true" pageSize="10"
		pageList="[5,10,15,20]" loadMsg="正在在加载远程数据，请稍后......" align="center"
		id="tt">
		<thead>
			<tr>
				<th data-options="field:'lstId',width:100,align:'center'">编号</th>
				<th data-options="field:'lstCustName',width:100,align:'center'">客户</th>
				<th data-options="field:'lstCustManagerName',width:100,align:'center'">客户经理</th>
				<th data-options="field:'lstLastOrderDate',width:100,align:'center'">上次下单时间</th>
				<th data-options="field:'lstLostDate',width:100,align:'center'">确认流失时间</th>
				<th data-options="field:'lstStatus',width:100,align:'center'">状态</th>
				<th
					data-options="field:'opt',
	  			width:300,
	           align:'center',
	           formatter:function(value,row,index){
	           if(row.lstStatus=='暂缓流失'){
	           return ' <a href=../../../delById_CstLost.action?id='+row.lstId+'&t=<%=new Date().getTime()%>><img title=暂缓流失 src=../../images/bt_relay.gif class=op_button /></a>';
		          
	           }
	           else if(row.lstStatus=='预警'){
		           	return '<a href=../../../findById_CstLost.action?id='+row.lstId+'&t=<%=new Date().getTime()%>><img title=确认流失 src=../../images/bt_confirm.gif class=op_button /></a>'
		           +' <a href=../../../delById_CstLost.action?id='+row.lstId+'&t=<%=new Date().getTime()%>><img title=暂缓流失 src=../../images/bt_relay.gif class=op_button /></a>';
	           }
					} 	
	            ">操作</th>
			</tr>
	</thead>
	</table>
<%--<table class="data_list_table">
	<tr>
		<th>编号</th>
		<th>客户</th>
		<th>客户经理</th>
		<th>上次下单时间</th>
		<th>确认流失时间</th>
		<th>状态</th>
		<th>操作</th>
	</tr>
	<tr>
		<td class="list_data_number">1</td>
		<td class="list_data_text">阳光实业</td>
		<td class="list_data_ltext">球球</td>
		<td class="list_data_text">2005年12月07日</td>
		<td class="list_data_text">　</td>
		<td class="list_data_text">暂缓流失</td>
		<td class="list_data_op">
			<img onclick="to('confirm.jsp');" title="确认流失" src="../../images/bt_confirm.gif" class="op_button" />
			<img onclick="to('relay.jsp');" title="暂缓流失" src="../../images/bt_relay.gif" class="op_button" />
			
		</td>
	</tr>
	<tr>
		<th colspan="7" class="pager">
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
