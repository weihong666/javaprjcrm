<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>jb-aptech��ҵ�����Ŀ</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link href="../css/style.css" rel="stylesheet" type="text/css">
<script src="../script/common.js"></script>
</head>
<body>

<div class="page_title">���ۻ������</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">����</button>
	<button class="common_button" onclick="to('add.jsp');">�½�</button>  
	<button class="common_button" onclick="reload();">��ѯ</button> 
	</div>
<table class="query_form_table">
	<tr>
		<th>�ͻ�����</th>
		<td><input /></td>
		<th>��Ҫ</th>
		<td><input /></td>
		<th>��ϵ��</th>
		<td>
			<input name="T1" size="20" />
		</td>
	</tr>
	</table>
<br />
<table class="data_list_table">
	<tr>
		<th>���</th>
		<th>�ͻ�����</th>
		<th>��Ҫ</th>
		<th>��ϵ��</th>
		<th>��ϵ�˵绰</th>
		<th>����ʱ��</th>
		<th>����</th>
	</tr>
	<tr>
		<td class="list_data_number">1</td>
		<td class="list_data_text">�������</td>
		<td class="list_data_ltext">�ɹ��ʼǱ���������</td>
		<td class="list_data_text">������</td>
		<td class="list_data_text">13729239239</td>
		<td class="list_data_text">2007��12��06��</td>
		<td class="list_data_op">
			<img onclick="to('dispatch.jsp');" title="ָ��" src="../images/bt_linkman.gif" class="op_button" />
			<img onclick="to('edit.jsp');" title="�༭" src="../images/bt_edit.gif" class="op_button" />
			<img onclick="del('�����ۻ��᣺�ɹ��ʼǱ���������');" title="ɾ��" src="../images/bt_del.gif" class="op_button" />
			
		</td>
	</tr>
	<tr>
		<th colspan="7" class="pager">
<div class="pager">
	��59����¼ ÿҳ<input value="10" size="2" />��
	��<input value="1" size="2"/>ҳ/��5ҳ
	<a href="#">��һҳ</a>
	<a href="#">��һҳ</a>
	<a href="#">��һҳ</a>
	<a href="#">���һҳ</a>
	ת��<input value="1" size="2" />ҳ
	<button width="20" onclick="reload();">GO</button>
</div>
		</th>
	</tr>
</table>
</body>
</html>