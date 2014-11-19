<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
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



<link href="../css/style.css" rel="stylesheet" type="text/css"></link>
<script src="../script/common.js"></script>


<script>
$(document).ready(function(){
	//----条件查询---------------------------------		
	$("#select").click(function(){	

		$("#tt").datagrid({
			queryParams: {
				dtype:$("#dtype").val(),
				ditem:$("#ditem").val(),
				dvalue:$("#dvalue").val()
			}
		
		}
		); 

		//清空查询项
		$("#dtype").val("");
		$("#ditem").val("");
		$("#dvalue").val("");
		
		
});
	
	});
	
function dodel(bid){
	alert("你选择要删除的编号为："+bid);
	var t=new Date().getTime();
	$.messager.confirm("提示","要真的删除吗?",function(r){
		if(r){
			//执行删除
			$.get("../../delById_BasDict.action?bid="+bid,dodelCallBack);
		}
	})
	
}
//删除的回调方法
function dodelCallBack(msg){
			if(msg=='1'){
				
				$.messager.alert('提示','已删除成功'); 	
				$('#tt').datagrid('reload');    // 重新载入当前页面数据  
				
			}else{
				$.messager.alert('提示','删除失败！');
			}
		}
</script>


</head>
<body>

<div class="page_title">数据字典管理</div>

<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="to('dict_add.jsp');">新建</button>
	<button id="select" class="common_button">查询</button>  
</div>

<table class="query_form_table">
	<tr>
		<th>类别</th>
		<td><input id="dtype" name="dtype"/></td>
		<th>条目</th>
		<td><input id="ditem" name="ditem"/></td>
		<th>值</th>
		<td><input id="dvalue" name="dvalue" onclick=""/></td>
	</tr>
</table>
<br />
<table  class="easyui-datagrid" style="height:425px;"   
        data-options="
        url:'../../findAll_BasDict.action?t=<%=new Date().getTime() %>',
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
	            <th data-options="field:'dictId',width:50,align:'center'">编号</th>   
	            <th data-options="field:'dictType',width:100,align:'center'">类别</th>   
	            <th data-options="field:'dictItem',width:50,align:'center'">条目</th>   
	            <th data-options="field:'dictValue',width:120,align:'center'">值</th>   
	            <th data-options="field:'dictIsEditable',width:100,align:'center',
											        		 formatter: function(value,row,index){
																if (value=='0'){
																	return '否';
																} 
																if (value=='1'){
																	return '是';
																} 
															}
	           											 ">是否可编辑</th>   
 
	            <th data-options="field:'opt',
	            				width:100,
	            				align:'center',
	            				formatter:function(value,row,index){
                                return '<a href=# onclick=dodel('+row.dictId+')>删除</a> '
                                +'<a href=../../findById_BasDict.action?bid='+row.dictId+'&t=<%=new Date().getTime() %>>修改</a>'										
	            							}
	            	
	            ">操作</th>   
	        </tr>   
	    </thead>   
	</table> 

</body>
</html>
