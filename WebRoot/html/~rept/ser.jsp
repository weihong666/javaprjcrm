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
	$(document).ready(function() {
		$("#index").click(function() { 
        			$("#tt").datagrid({
						queryParams: {
							year: $('#year').val()
						}
					});
					$('#year').val("");
		});
	});
</script>
</head>
<body>

<div class="page_title">客户服务分析</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="reload();" id="index">查询</button> 
	</div>
<table class="query_form_table">
	<tr>
		<th>年份</th>
		<td>
			<select name="year" id="year">
				<option value="">全部</option>
				<option value="2005">2005</option>
				<option value="2006">2006</option>
				<option value="2007">2007</option>
				<option value="2008">2008</option>
				<option value="2009">2009</option>
				<option value="1999">1999</option>
				<option value="2000">2000</option>
				<option value="2010">2010</option>
				<option value="2011">2011</option>
				<option value="2012">2012</option>
				<option value="2013">2013</option>
				<option value="2014">2014</option>
			</select>
		</td>
		<th>&nbsp;</th>
		<td>
			&nbsp;
		</td>
	</tr>
	</table>
<br />
<table  class="easyui-datagrid" style="height:425px;"   
        data-options="
        url:'../../findByYear_CstService.action?t=<%=new Date().getTime() %>',
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
	             
	           <th data-options="field:'custName',width:145,align:'center',
	           											formatter: function(value,row,index){
															if (row){
																return row[0];
															} 
														}

	            ">条目</th>   
	            <th data-options="field:'total',width:180,align:'center',
	            formatter: function(value,row,index){
															if (row){
																return row[1];
															} 
														}
	            ">服务数量</th>   
	            <th data-options="field:'dictValue',width:60,align:'center'"></th>   
	            <th data-options="field:'dictValue',width:60,align:'center'"></th>   
	 
	        </tr>   
	    </thead>   
	</table> 
</body>
</html>
