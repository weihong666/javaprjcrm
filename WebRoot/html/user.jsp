<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<s:if test="#session.user.usrAlevel==0">
<c:redirect url="mywork.jsp"></c:redirect>
</s:if>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>jb-aptech毕业设计项目</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<%
	String path = request.getContextPath();
%>
<link rel="stylesheet" type="text/css"
	href="../jquery-easyui-1.3.4/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="../jquery-easyui-1.3.4/themes/icon.css">
<link rel="stylesheet" href="css/style.css" type="text/css"></link>
<script type="text/javascript"
	src="../jquery-easyui-1.3.4/jquery-1.9.1.js"></script>
<script type="text/javascript"
	src="../jquery-easyui-1.3.4/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="../jquery-easyui-1.3.4/locale/easyui-lang-zh_CN.js"></script>

<script type="text/javascript" src="script/common.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		//----组合查询---------------------------------		
		$("#select").click(function() {

			$("#tt").datagrid({
				queryParams : {
					usrId : $("#usrId").val(),
					usrName : $("#usrName").val(),
					usrRoleName : $("#usrRoleName").val(),
					usrAlevel : $("#usrAlevel").val()
				}

			});

			//清空查询项
			$("#usrId").val("");
			$("#usrName").val("");
			$("#usrRoleName").val("");
			$("#usrAlevel").val("");
		});

	});
</script>
</head>

<body>

	<div class="page_title">用户信息管理</div>

	<div class="button_bar">
		<button class="common_button" onclick="help('');">帮助</button>
		<s:if test="#session.user.usrAlevel==1">
			<button class="common_button" onclick="to('add.jsp');">新建</button>
		</s:if>
		<button class="common_button" onclick="to('edit.jsp?id=${usrId}');">编辑</button>
		<button class="common_button" id="select" type="submit">查询</button>
	</div>

	<table class="query_form_table">
		<tr>
			<th>用户编号</th>
			<td><input name="usrId" id="usrId" />
			</td>
			<th>姓名</th>
			<td><input name="usrName" id="usrName" /></td>

		</tr>
		<tr>
			<th>昵称</th>
			<td><input name="usrRoleName" id="usrRoleName" />
			</td>
			<th>权限</th>
			<td><select name="sysUser.usrAlevel">
					<option value="">全部</option>
					<option value="1">客户经理</option>
					<option value="0">普通员工</option>
			</select> <span class="red_star">*</span>
			</td>

		</tr>
	</table>

	<br />

	<table class="easyui-datagrid" style="height:410px;"
		data-options="
        url:'../findAll_SysUser.action?t=<%=new Date().getTime()%>',
        fitColumns:true, 
        singleSelect:true"
		pagination="true" rownumbers="true" pageSize="10"
		pageList="[5,10,15,20]" loadMsg="正在在加载远程数据，请稍后......" align="center"
		id="tt">
		<thead>
			<tr>
				<th data-options="field:'usrId',width:100,align:'center'">用户编号</th>
				<th data-options="field:'usrName',width:100,align:'center'">用户姓名</th>
				<th data-options="field:'usrRoleName',width:100,align:'center'">用户昵称</th>
				<th
					data-options="field:'usrAlevel',width:100,align:'center',
					 formatter:function(value,row,index){
					 	if(value==1){
					 		return '客户经理';
					 	}else{
					 		return '普通员工';
					 	}
					 }
				">用户权限</th>
				<th
					data-options="field:'opt',
	  			width:300,
	           align:'center',
	           formatter:function(value,row,index){
	       
	           return '<a href=../delById_SysUser?id='+row.usrId+' ><img title=删除 src=images/bt_del.gif class=op_buttons /></a>';
					} ">操作</th>
			</tr>
		</thead>
	</table>

</body>
</html>
