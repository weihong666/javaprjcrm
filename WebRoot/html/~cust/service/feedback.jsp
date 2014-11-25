<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>jb-aptech��ҵ�����Ŀ</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
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

		//��ղ�ѯ��
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

<div class="page_title">�ͻ�������� &gt; ������</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">����</button>
	<button class="common_button"  id="select">��ѯ</button>  
</div>
<table class="query_form_table">
	<tr>
		<th height="28">�ͻ�</th>
		<td><input name="cstService.svrCustName" id="svrCustName"/></td>
		<th height="28">��Ҫ</th>
		<td><input name="cstService.svrTitle" id="svrTitle"/></td>
		<th height="28">��������</th>
		<td>
			<select name="cstService.svrType" id="svrType">
				<option>ȫ��</option>
				<option>��ѯ</option>
				<option>����</option>
				<option>Ͷ��</option>
			</select>
		</td>
	</tr>
	<tr>
		<th height="32">��������</th>
		<td colspan="3">
			<input name="cstService.svrCreateDate" size="10"  id="svrCreateDate"/> - <input name="T1" size="10" /></td>
		<th height="32">״̬</th>
		<td>
			<select name="svrStatus" id="svrStatus">
				<option value="�Ѵ���">�Ѵ���</option>
			</select>
		</td>
	</tr>
</table>
<br/>
<table class="easyui-datagrid" style="height:410px;"
		data-options="
        url:'../../../findAll_CstService.action?t=<%=new Date().getTime() %>',
        fitColumns:true, 
        queryParams: {
		svrStatus: '�Ѵ���'
		}, 
        singleSelect:true"
		pagination="true" rownumbers="true" pageSize="10"
		pageList="[10,20,30,40]" 
		loadMsg="�����ڼ���Զ�����ݣ����Ժ�......" align="center"
		id="tt">
		<thead>
			<tr>
				<th data-options="field:'svrId',width:100,align:'center'">���</th>
				<th data-options="field:'svrCustName',width:100,align:'center'">�ͻ�</th>
				<th data-options="field:'svrTitle',width:100,align:'center'">��Ҫ</th>
				<th data-options="field:'svrType',width:100,align:'center'">��������</th>
				<th data-options="field:'svrCreateBy',width:100,align:'center'">������</th>
				<th data-options="field:'svrCreateDate',width:100,align:'center'">��������</th>
				
				<th
					data-options="field:'opt',
	  			width:300,
	           align:'center',
	           formatter:function(value,row,index){
	           return '<a href=../../../findByIdFeedBack_CstService.action?id='+row.svrId+'><img title=���� src=../../images/bt_feedback.gif class=op_button /></a>'
						}
            				 ">����</th>   
			</tr>
		</thead>
	</table>
</body>
</html>
