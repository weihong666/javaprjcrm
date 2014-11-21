<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<script>
$(document).ready(function(){
	//----条件查询---------------------------------		
	$("#select").click(function(){	

		$("#tt").datagrid({
			queryParams: {
				pname:$("#pname").val(),
				ptype:$("#ptype").val(),
				pbatch:$("#pbatch").val()
			}
		
		}
		); 

		//清空查询项
		$("#pname").val("");
		$("#ptype").val("");
		$("#pbatch").val("");
		
		
});
	
	});

</script>
</head>
<body>

<div class="page_title">产品查询</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" id="select">查询</button>  
</div>
<table class="query_form_table">
	<tr>
		<th>名称</th>
		<td><input id="pname" name="pname" /></td>
		<th>型号</th>
		<td><input id="ptype" name="ptype" /></td>
		<th>数量</th>
		<td><input id="pbatch" name="pbatch"/></td>
	</tr>
</table>
<br />
<table class="easyui-datagrid" style="height:425px;"   
        data-options="
        url:'../../findAll_Product.action?t=<%=new Date().getTime() %>',
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
	            <th data-options="field:'prodId',width:70,align:'center'">编号</th>   
	            <th data-options="field:'prodName',width:200,align:'center'">名称</th>   
	            <th data-options="field:'prodType',width:135,align:'center'">型号</th>   
	            <th data-options="field:'prodBatch',width:135,align:'center'">数量</th>   
	            <th data-options="field:'prodUnit',width:135,align:'center'">单位</th>
	            <th data-options="field:'prodPrice',width:135,align:'center'">单价(元)</th>
	            <th data-options="field:'prodMemo',width:135,align:'center'">备注</th>    
	            <th data-options="field:'opt',width:100,align:'center'"></th>   
	        </tr>   
	    </thead>   
	</table> 
</body>
</html>
