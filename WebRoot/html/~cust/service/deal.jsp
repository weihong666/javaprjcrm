<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<s:if test="#session."></s:if>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>jb-aptech毕业设计项目</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<% String path=request.getContextPath(); %>
<link rel="stylesheet" href="../../../jquery-easyui-1.3.4/themes/default/easyui.css" type="text/css"></link>
<link rel="stylesheet" href="../../../jquery-easyui-1.3.4/themes/icon.css" type="text/css"></link>
<script type="text/javascript" src="../../../jquery-easyui-1.3.4/jquery-1.9.1.js"></script>
<script type="text/javascript" src="../../../jquery-easyui-1.3.4/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../../../jquery-easyui-1.3.4/locale/easyui-lang-zh_CN.js"></script>

<link href="../../css/style.css" rel="stylesheet" type="text/css">
<script src="../../script/common.js"></script>
<script type="text/javascript">
$(document).ready(function(){
		
		$("#select").click(function(){	
alert($("#svrCustName").val());
		$("#tt").datagrid({
			queryParams: {
				svrCustName:$("#svrCustName").val(),
				svrTitle:$("#svrTitle").val(),
				svrType:$("#svrType").val(),
				svrCreateDate:$("#svrCreateDate").val(),
				svrStatus:$("#svrStatus").val()
				
			}
		
		}
		
		); 

		//清空查询项
		$("#svrCustName").val("");
		$("#svrTitle").val("");
		$("#svrType").val("");
		$("#svrCreateDate").val("");
		$("#svrStatus").val("");
		
		
});
		});
</script>
</head>
<body>

<div class="page_title">客户服务管理 &gt; 服务处理</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button"  id="select">查询</button>  
</div>
<table class="query_form_table">
	<tr>
		<th height="28">客户</th>
		<td><input name="svrCustName" id="svrCustName"/></td>
		<th height="28">概要</th>
		<td><input name="svrTitle" id="svrTitle"/></td>
		<th height="28">服务类型</th>
		<td>
			<select name="cstService.svrType" id="svrType">
				<option value="">全部</option>
				<option value="咨询">咨询</option>
				<option value="建议">建议</option>
				<option value="投诉">投诉</option>
			</select>
		</td>
	</tr>
	<tr>
		<th height="32">创建日期</th>
		<td colspan="3">
			<input name="cstService.svrCreateDate" id="svrCreateDate" size="10" /> - <input name="T1" size="10" /></td>
		<th height="32">状态</th>
		<td>
			<select name="cstService.svrStatus" id="svrStatus">
				<option selected value="已分配">已分配</option>
			</select>
		</td>
	</tr>
</table>
<br />
<table class="easyui-datagrid" style="height:410px;"
		data-options="
        url:'../../../findAll_CstService.action?t=<%=new Date().getTime() %>',
        fitColumns:true, 
        queryParams: {
		svrStatus: '已分配'
		}, 
		
        singleSelect:true"
		pagination="true" rownumbers="true" pageSize="10"
		pageList="[10,20,30,40]" 
		loadMsg="正在在加载远程数据，请稍后......" align="center"
		id="tt">
		<thead>
			<tr>
				<th data-options="field:'svrId',width:100,align:'center'">编号</th>
				<th data-options="field:'svrCustName',width:100,align:'center'">客户</th>
				<th data-options="field:'svrTitle',width:100,align:'center'">概要</th>
				<th data-options="field:'svrType',width:100,align:'center'">服务类型</th>
				<th data-options="field:'svrCreateBy',width:100,align:'center'">创建人</th>
				 <th data-options="field:'svrCreateDate',width:140,align:'center',
            								formatter: function(value,row,index){
												if(value){
														return value.substring(0,10);
														}
           									 		}
            ">创建日期</th>   
				
				<th
					data-options="field:'opt',
	  			width:300,
	           align:'center',
	           formatter:function(value,row,index){
	           return '<a href=../../../findById_CstService.action?id='+row.svrId+'><img title=处理 src=../../images/bt_deal.gif class=op_buttons/></a>'
						}
            				 ">操作</th>   
			</tr>
		</thead>
	</table>
</body>
</html>
