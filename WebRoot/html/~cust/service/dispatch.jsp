<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags"  prefix="s" %>

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

function dodelete(id){
			var t=new Date().getTime();
		$.messager.confirm("提示","要真的删除吗?",function(r){
			if(r){
				//执行删除
				$.post("../../../delById_CstService.action?id="+id+"&time="+t,dodeletCallBack);
			}
		})
		}
		function dodeletCallBack(msg){
			if(msg=='1'){
				$.messager.alert('提示','已删除！'); 
				
				$('#tt').datagrid('reload');    // 重新载入当前页面数据  
				
			}else{
				$.messager.alert('提示','删除失败！');
			}
		}
		
$(document).ready(function(){
		
		$("#select").click(function(){	
			
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

<div class="page_title">客户服务管理 > 服务分配</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" type="submit" id="select">查询</button>  
</div>
<table class="query_form_table" height="53 ">
	<tr>
		<th height="28">客户</th>
		<td><input name="cstService.svrCustName" id="svrCustName"/></td>
		<th height="28">概要</th>
		<td><input name="cstService.svrTitle" id="svrTitle"/></td>
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
		<th height="22">创建日期</th>
		<td colspan="3">
			<input name="cstService.svrCreateDate" id="svrCreateDate" size="10" /> <!-- - <input name="T1" size="10" /> --></td>
		<th height="22">状态</th>
		<td>
			<select name="cstService.svrStatus" id="svrStatus">
			
				<option value="新创建">新创建</option>
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
		svrStatus: '新创建'
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
			    <th data-options="field:'svrCreateDate',width:80,align:'center',
					         formatter: function(value,row,index){
												if(value){
														return value.substring(0,10);
														}
           									 		}
            ">创建日期</th>   
				 <th data-options="
            					field:'svrDueTo',
            					width:100,
            					align:'center',
            					formatter: function(value,row,index){
            						return '<form  action=../../../dispatch_CstService.action  method=post>'  
            									+'<select name=svrDueTo >'
												+'<option >请选择...</option>'
												+'<option value= 小明  >小明</option>'
												+'<option value= 旺财  >旺财</option>'
												+'<option value= 球球  >球球</option>'
												+'<option value= 孙小美  >孙小美</option>'
												+'</select>'
												+'<input type=submit name=bt  id=bt value=分配   />'
												
												+'<input type=hidden name=svrId value='+row.svrId+'  />'
											+'</form>';
            					}
            				 
            				">分配给</th>   
				<th
					data-options="field:'opt',
	  			width:300,
	           align:'center',
	           formatter:function(value,row,index){
	           return '<a href=# onclick=dodelete('+row.svrId+')><img title=删除 src=../../images/bt_del.gif class=op_buttons /></a>'
							}
            				 ">操作</th>   
			</tr>
		</thead>
	</table>

</body>
</html>
