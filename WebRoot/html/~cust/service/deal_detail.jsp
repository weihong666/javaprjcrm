<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>jb-aptech��ҵ�����Ŀ</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link href="../../css/style.css" rel="stylesheet" type="text/css">
<script src="../../script/common.js"></script>
</head>
<body>

<div class="page_title">�ͻ�������� &gt; ������</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">����</button>
	<button class="common_button" onclick="back();">����</button> 
	<button class="common_button" onclick="save('feedback.jsp');">����</button>  
</div>
<table class="query_form_table">
	<tr>
		<th>���</th>
		<td>456</td>
		<th>��������</th>
		<td>
			��ѯ</td>
	</tr>
	<tr>
		<th>��Ҫ</th>
		<td colspan="3">ѯ�������������˷ѳе���ʽ</td>
	</tr>	
	<tr>
		<th>�ͻ�</th>
		<td>̫��ҩҵ</td>
		<th>״̬</th>
		<td>�ѷ���</td>
	</tr>	
	<tr>
		<th>��������</th>
		<td colspan="3">�����������˷���γе���<br>
��</td>
	</tr>
	<tr>
		<th>������</th>
		<td>С��</td>
		<th>����ʱ��</th>
		<td>2007��12��02�� 15ʱ26��58��</td>
	</tr>
	</table>
<br />
<table class="query_form_table" id="table3">
	<tr>
		<th>�����</th>
		<td>
			����</td>
		<th>����ʱ��</th>
		<td>2007��12��02�� 15ʱ28��06��</td>
	</tr>
</table>
<br />	
<table class="query_form_table" id="table1">
	<tr>
		<th>������</th>
		<td colspan="3"><textarea rows="6" cols="50"></textarea><span class="red_star">*</span></td>
	</tr>
	<tr>
		<th>������</th>
		<td><input name="T17" value="��ӱ" readonly size="20" /><span class="red_star">*</span></td>
		<th>����ʱ��</th>
		<td><input id="t3" name="T16" readonly size="20" /><span class="red_star">*</span></td>
	</tr>
</table>
<br />
<table disabled class="query_form_table" id="table2">
	<tr>
		<th>�������</th>
		<td><input name="T10" size="20" /><span class="red_star">*</span></td>
		<th>�����</th>
		<td>
			<select name="D1">
				<option>��ѡ��...</option>
				<option>������</option>
				<option>�����</option>
				<option>����</option>
				<option>���</option>
				<option>��</option>
			</select><span class="red_star">*</span></td>
	</tr>
</table>
<script>
	setCurTime('t3');
</script>
</body>
</html>