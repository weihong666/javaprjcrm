<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>jb-aptech��ҵ�����Ŀ</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link rel="stylesheet" type="text/css" href="../../easyui/themes/default/easyui.css"/>
	<link rel="stylesheet" type="text/css" href="../../easyui/themes/icon.css"/>
	<script type="text/javascript" src="../../easyui/jquery-1.9.1.js"></script>
	<script type="text/javascript" src="../../easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript"	src="../../easyui/locale/easyui-lang-zh_CN.js"></script>
   <link href="../css/style.css" rel="stylesheet" type="text/css">
<link href="../css/style.css" rel="stylesheet" type="text/css">
<script src="../script/common.js"></script>
</head>
<body>

<div class="page_title">�ͻ������ƻ� &gt; �鿴</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">����</button>
	<button class="common_button" onclick="back();">����</button>
	</div>
<table class="query_form_table">
	<tr>
		<th>���</th>
		<td>${oldsalChance2.chcId}</td>
		<th>������Դ</th>
		<td>${oldsalChance2.chcSource}</td>
	</tr>
	<tr>
		<th>�ͻ�����</th>
		<td>${oldsalChance2.chcCustName}</td>
		<th>�ɹ����ʣ�%��</th>
		<td>${oldsalChance2.chcRate}</td>
	</tr>	
	<tr>
		<th>��Ҫ</th>
		<td colspan="3">${oldsalChance2.chcTitle}</td>
	</tr>
	<tr>
		<th>״̬</th>
		<td colspan="3">
		<s:if test="#session.oldsalChance2.chcStatus==1">�����ɹ�
		</s:if>	     
      <s:if
       test="#session.oldsalChance2.chcStatus==0">����ʧ��
      </s:if>
		</td>
	</tr>
	
	<tr>
		<th>��ϵ��</th>
		<td>${oldsalChance2.chcLinkman}</td>
		<th>��ϵ�˵绰</th>
		<td>${oldsalChance2.chcTel}</td>
	</tr>
	<tr>
		<th>��������</th>
		<td colspan="3">${oldsalChance2.chcDesc}</td>
	</tr>
	<tr>
		<th>������</th>
		<td>${oldSalChance2.chcCreateBy }</td>
		<th>����ʱ��</th>
		<td>${oldsalChance2.chcCreateDate}</td>
	</tr>
	<tr>
		<th>ָ�ɸ�</th>
		<td>${oldsalChance2.chcDueTo}</td>
		<th>ָ��ʱ��</th>
		<td><s:date name="#session.oldsalChance2.chcDueDate" format="yyyy-MM-dd" /></td>
	</tr>
</table>
<br />
<table class="easyui-datagrid" style="width:860px;height:100px"
			align="center"
			data-options="
				url:'<%=request.getContextPath()%>/findAll_SalPlan?chcId=${oldsalChance2.chcId}&time=<%=new Date().getTime() %>',
	        	fitColumns:true,singleSelect:true,
	        	loadMsg:'���ڼ������ݣ����Ժ�...',

	        	pageList:[5,10,15,20]
	        	
        	"
			id="tt">
			<thead>
				<tr>
					<th data-options="field:'plaDate',width:100,align:'center',formatter: function(value,row,index){
														if (value){
															return value.substring(0,10);
														} else {
															return value;
														}
													}">����</th>
					<th data-options="field:'plaTodo',width:380,align:'center'">�ƻ�</th>
					<th data-options="field:'plaResult',width:380,align:'center'">ִ��Ч��</th>
			
				</tr>
			</thead>
		</table>	
</body>
</html>
