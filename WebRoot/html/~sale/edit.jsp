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

<div class="page_title">���ۻ������&nbsp; &gt; �༭���ۻ���</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">����</button>
	<button class="common_button" onclick="back();">����</button>
	<button class="common_button" onclick="save('list.jsp');">����</button>  
</div>
<table class="query_form_table">
	<tr>
		<th>���</th>
		<td><input readonly value="1" /></td>
		<th>������Դ</th>
		<td>
			<input name="T4" size="20" /></td>
	</tr>
	<tr>
		<th>�ͻ�����</th>
		<td><input value="��ǵ���" /><span class="red_star">*</span></td>
		<th>�ɹ����ʣ�%��</th>
		<td><input value="70" /><span class="red_star">*</span></td>
	</tr>	
	<tr>
		<th>��Ҫ</th>
		<td colspan="3"><input value="�ɹ��ʼǱ���������" name="T0" size="52" /><span class="red_star">*</span></td>
	</tr>
	<tr>
		<th>��ϵ��</th>
		<td><input name="T21" value="������" size="20" /></td>
		<th>��ϵ�˵绰</th>
		<td><input name="T5" value="13729239239" size="20" /></td>
	</tr>
	<tr>
		<th>��������</th>
		<td colspan="3"><textarea rows="6" cols="50" name="S1">...</textarea><span class="red_star">*</span></td>
	</tr>
	<tr>
		<th>������</th>
		<td><input name="T19" value="��ӱ" readonly size="20" /><span class="red_star">*</span></td>
		<th>����ʱ��</th>
		<td><input id="t1" name="T15" value="2007-12-6 16:09:8" readonly size="20" /><span class="red_star">*</span></td>
	</tr>
</table>
<br />
<table disabled class="query_form_table" id="table1">
	<tr>
		<th>ָ�ɸ�</th>
		<td>
			<select name="D1">
				<option>��ѡ��...</option>
				<option>С��</option>
				<option>����</option>
				<option>����</option>
				<option>��С��</option>
				<option>�ܽ���</option>
			</select> <span class="red_star">*</span></td>
		<th>ָ��ʱ��</th>
		<td>
			<input id="t2" name="T20" readonly size="20" /><span class="red_star">*</span></td>
	</tr>
</table>
<script>
	setCurTime('t1');
	setCurTime('t2');
</script>
</body>
</html>