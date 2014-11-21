<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>jb-aptech毕业设计项目</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<link rel="stylesheet" href="../../jquery-easyui-1.3.4/themes/default/easyui.css" type="text/css"></link>
<link rel="stylesheet" href="../../jquery-easyui-1.3.4/themes/icon.css" type="text/css"></link>
<script type="text/javascript" src="../../jquery-easyui-1.3.4/jquery-1.9.1.js"></script>
<script type="text/javascript" src="../../jquery-easyui-1.3.4/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../../jquery-easyui-1.3.4/locale/easyui-lang-zh_CN.js"></script>

<link href="../css/style.css" rel="stylesheet" type="text/css">
<script src="../script/common.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	//----组合查询---------------------------------		
	$("#select").click(function(){	

		$("#tt").datagrid({
			queryParams: {
				lstCustName:$("#lstCustName").val(),
				lstCustManagerName:$("#lstCustManagerName").val()


			}
		
		}
		); 

		//清空查询项
		$("#lstCustName").val("");
		$("#lstCustManagerName").val("");


		
});
	
	});
</script>
</head>
<body>

<div class="page_title">客户流失分析</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" type="submit" id="select">查询</button> 
	</div>
	<table class="query_form_table" border="0" cellPadding="3" cellSpacing="0">
			<tr>
					<th>客户名称</th>
	<td><input name="lstCustName" id="lstCustName"/></td>
					<th>客户经理</th>

	<td><input name="lstCustManagerName" id="lstCustManagerName"/></td>
					
			</tr>
		</table><br />
<table  class="easyui-datagrid" style="height:425px;"   
        data-options="
        url:'../../findAllLost_CstLost.action?t=<%=new Date().getTime() %>',
        fitColumns:true, 
        singleSelect:true"         
        pagination="true" 
        rownumbers="true" 
        pageSize="10" 
        pageList="[10,20,30,40]" 
        loadMsg="正在在加载远程数据，请稍后......"
        align="center" id="tt"
        >   
	    <thead>   
	        <tr>   
	            <th data-options="field:'lstId',width:50,align:'center'">编号</th>   
	            <th data-options="field:'lstLostDate',width:100,align:'center'">年份</th>   
	            <th data-options="field:'lstCustName',width:50,align:'center'">客户</th>   
	            <th data-options="field:'lstCustManagerName',width:120,align:'center'">客户经理</th>   
	            <th data-options="field:'lstReason',width:100,align:'center' ">流失原因</th>   

	        </tr>   
	    </thead>   
	</table> 

</body>
</html>
