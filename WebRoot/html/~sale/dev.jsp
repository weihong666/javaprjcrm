<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>jb-aptech毕业设计项目</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
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
	<link href="../css/style.css" rel="stylesheet" type="text/css"/>
    <script src="../script/common.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link href="../css/style.css" rel="stylesheet" type="text/css">
<script src="../script/common.js"></script>
<script type="text/javascript">
 //----组合查询---------------------------------
    $(document).ready(function(){		
	 $("#find").click(function(){	

		$("#tt").datagrid({
			queryParams: {
				chcCustName:$("#chcCustName").val(),
				chcLinkman:$("#chcLinkman").val(),
				chcTitle:$("#chcTitle").val()
				

			}
		
		}
		); 

		//清空查询项
		$("#chcCustName").val("");
		$("#chcLinkman").val("");
		$("#chcTitle").val("");
		

		
		
});
	
	});

</script>
</head>
<body>

<div class="page_title">客户开发计划</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" id="find";" type="submit">查询</button> 
	</div>
<table class="query_form_table">
	<tr>
		<th>客户名称</th>
		<td><input name="chcCustName" id="chcCustName"/></td>
		<th>概要</th>
		<td><input name="chcTitle" id="chcTitle"/></td>
		<th>联系人</th>
		<td><input name="chcLinkman" id="chcLinkman" size="20" /></td>
	</tr>
	</table>
<br />
<div align="center">
<table class="easyui-datagrid" style=" height: 430px"
	data-options="url:'../../findAll_SalChance.action?t=<%=new Date().getTime()%>',
        fitColumns:true,
        singleSelect:true"
		pagination="true"
		rownumbers="true"
	    pageList="[5,10,15,20]"
		pageSize="5" 
		loadMsg="正在加载远程数据请稍后。。。。"
		align="center" id="tt"
		>
		<thead>
		<tr>
			<th data-options="field:'chcId',width:100,align:'center'">编号</th>
			<th data-options="field:'chcCustName',width:100,align:'center'">客户名称</th>
			<th data-options="field:'chcTitle',width:100,align:'center'">概要</th>
			<th data-options="field:'chcLinkman',width:100,align:'center'">联系人</th>
			<th data-options="field:'chcTel',width:100,align:'center'">联系人电话</th>
			<th data-options="field:'chcCreateDate',width:100,align:'center'">创建时间</th>
          	<th data-options="field:'chcStatus',width:50,align:'center',formatter: function(value,row,index){
								if (value=='1'){
									return '已归档';
								}
				
								if(value==null) {
									return '开发中';
								}
								if(value=='0') {
									return '已归档';
								}
							}
            				 
          			
          	
              	
          	">状态</th>
			<th data-options="field:'opt',width:100,align:'center',formatter: function(value,row,index){
													if(row.chcStatus==null){				
				return '<a href=../../finddetailabcd_SalChance.action?chcId='+row.chcId+'&t=<%=new Date().getTime()%>><img title=制定计划 src=../images/bt_plan.gif class=op_button /></a>'
				+'<a href=../../finddetailabcde_SalChance.action?chcId='+row.chcId+'&t=<%=new Date().getTime()%>><img title=执行计划 src=../images/bt_feedback.gif class=op_button /></a>'
				+'<a href=../../finddetailabcdef_SalChance.action?chcId='+row.chcId+'&t=<%=new Date().getTime()%>><img title=开发成功 src=../images/bt_yes.gif class=op_button /></a>';
															}else if(row.chcStatus==1){
															return'<a href=../../finddetailabcdefg_SalChance.action?chcId='+row.chcId+'&t=<%=new Date().getTime()%>><img title=查看 src=../images/bt_detail.gif class=op_button /></a>';					
														}else if(row.chcStatus==0){
														return'<a href=../../finddetailabcdefg_SalChance.action?chcId='+row.chcId+'&t=<%=new Date().getTime()%>><img title=查看 src=../images/bt_detail.gif class=op_button /></a>';
														}											
								} 
			">操作</th>
					</tr>
	   </thead>
</table>
</div>	
</body>
</html>
