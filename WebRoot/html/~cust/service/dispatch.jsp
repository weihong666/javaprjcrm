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

<div class="page_title">�ͻ�������� > �������</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">����</button>
	<button class="common_button" onclick="reload();">��ѯ</button>  
</div>
<table class="query_form_table" height="53">
	<tr>
		<th height="28">�ͻ�</th>
		<td><input /></td>
		<th height="28">��Ҫ</th>
		<td><input /></td>
		<th height="28">��������</th>
		<td>
			<select name="D1">
				<option>ȫ��</option>
				<option>��ѯ</option>
				<option>����</option>
				<option>Ͷ��</option>
			</select>
		</td>
	</tr>
	<tr>
		<th height="22">��������</th>
		<td colspan="3">
			<input name="T2" size="10" /> - <input name="T1" size="10" /></td>
		<th height="22">״̬</th>
		<td>
			<select name="D1">
				<option selected>�´���</option>
			</select>
		</td>
	</tr>
</table>
<br />
<table class="data_list_table">
	<tr>
		<th>���</th>
		<th>�ͻ�</th>
		<th>��Ҫ</th>
		<th>��������</th>
		<th>������</th>
		<th>��������</th>
		<th>�����</th>
		<th>����</th>
	</tr>
	<tr>
		<td class="list_data_number">456</td>
		<td class="list_data_text">̫��ҩҵ</td>
		<td class="list_data_ltext">ѯ�������������˷ѳе���ʽ</td>
		<td class="list_data_text">��ѯ</td>
		<td class="list_data_text">С��</td>
		<td class="list_data_text">2007��12��02��</td>
		<td class="list_data_text">
			<select name="D2">
				<option>��ѡ��...</option>
				<option>С��</option>
				<option>����</option>
				<option>����</option>
				<option>��С��</option>
				<option>�ܽ���</option>
			</select>
			<button class="common_button" onclick="reload();">����</button>  
			
		</td>
		<td class="list_data_op">
						
			<img onclick="del('���ͻ����Ϻ���Ϣ�Ƽ����޹�˾��');" title="ɾ��" src="../../images/bt_del.gif" class="op_button" />  
			
		</td>
	</tr>
	<tr>
		<td class="list_data_number">455</td>
		<td class="list_data_text">̫��ҩҵ</td>
		<td class="list_data_ltext">ѯ���������۸�</td>
		<td class="list_data_text">��ѯ</td>
		<td class="list_data_text">С��</td>
		<td class="list_data_text">2007��12��02��</td>
		<td class="list_data_text">
			<select name="D3">
				<option>��ѡ��...</option>
				<option>С��</option>
				<option>����</option>
				<option>����</option>
				<option>��С��</option>
				<option>�ܽ���</option>
			</select>
			<button class="common_button" onclick="reload();">����</button>  
			
		</td>
		<td class="list_data_op">
						
			<img onclick="del('���ͻ����Ϻ���Ϣ�Ƽ����޹�˾��');" title="ɾ��" src="../../images/bt_del.gif" class="op_button" />  
			
		</td>
	</tr>
	<tr>
		<td class="list_data_number">454</td>
		<td class="list_data_text">��������̲ݹ�˾</td>
		<td class="list_data_ltext">ѯ���������۸�</td>
		<td class="list_data_text">��ѯ</td>
		<td class="list_data_text">С��</td>
		<td class="list_data_text">2007��12��02��</td>
		<td class="list_data_text">
			<select name="D4">
				<option>��ѡ��...</option>
				<option>С��</option>
				<option>����</option>
				<option>����</option>
				<option>��С��</option>
				<option>�ܽ���</option>
			</select>
			<button class="common_button" onclick="reload();">����</button>  
			
		</td>
		<td class="list_data_op">
						
			<img onclick="del('���ͻ����Ϻ���Ϣ�Ƽ����޹�˾��');" title="ɾ��" src="../../images/bt_del.gif" class="op_button" />  
			
		</td>
	</tr>
	<tr>
		<td class="list_data_number">453</td>
		<td class="list_data_text">��������̲ݹ�˾</td>
		<td class="list_data_ltext">ѯ���������۸�</td>
		<td class="list_data_text">����</td>
		<td class="list_data_text">С��</td>
		<td class="list_data_text">2007��12��02��</td>
		
		<td class="list_data_text">
			<select name="D5">
				<option>��ѡ��...</option>
				<option>С��</option>
				<option>����</option>
				<option>����</option>
				<option>��С��</option>
				<option>�ܽ���</option>
			</select>
			<button class="common_button" onclick="reload();">����</button>  
			
		</td>
		
		<td class="list_data_op">
						
			<img onclick="del('���ͻ����Ϻ���Ϣ�Ƽ����޹�˾��');" title="ɾ��" src="../../images/bt_del.gif" class="op_button" />  
			
		</td>
	</tr>
	<tr>
		<td class="list_data_number">452</td>
		<td class="list_data_text">��������̲ݹ�˾</td>
		<td class="list_data_ltext">ѯ���������۸�</td>
		<td class="list_data_text">��ѯ</td>
		<td class="list_data_text">С��</td>
		<td class="list_data_text">2007��12��02��</td>
		<td class="list_data_text">
			<select name="D6">
				<option>��ѡ��...</option>
				<option>С��</option>
				<option>����</option>
				<option>����</option>
				<option>��С��</option>
				<option>�ܽ���</option>
			</select>
			<button class="common_button" onclick="reload();">����</button>  
			
		</td>
		<td class="list_data_op">
						
			<img onclick="del('���ͻ����Ϻ���Ϣ�Ƽ����޹�˾��');" title="ɾ��" src="../../images/bt_del.gif" class="op_button" />  
			
		</td>
	</tr>
	<tr>
		<td class="list_data_number">451</td>
		<td class="list_data_text">��������̲ݹ�˾</td>
		<td class="list_data_ltext">ѯ���������۸�</td>
		<td class="list_data_text">Ͷ��</td>
		<td class="list_data_text">С��</td>
		<td class="list_data_text">2007��12��02��</td>
		<td class="list_data_text">
			<select name="D7">
				<option>��ѡ��...</option>
				<option>С��</option>
				<option>����</option>
				<option>����</option>
				<option>��С��</option>
				<option>�ܽ���</option>
			</select>
			<button class="common_button" onclick="reload();">����</button>  
			
		</td>
		<td class="list_data_op">
						
			<img onclick="del('���ͻ����Ϻ���Ϣ�Ƽ����޹�˾��');" title="ɾ��" src="../../images/bt_del.gif" class="op_button" />  
			
		</td>
	</tr>	
	<tr>
		<td class="list_data_number" height="15">540</td>
		<td class="list_data_text" height="15">��������̲ݹ�˾</td>
		<td class="list_data_ltext" height="15">ѯ���������۸�</td>
		<td class="list_data_text" height="15">����</td>
		<td class="list_data_text" height="15">С��</td>
		<td class="list_data_text" height="15">2007��12��02��</td>
		<td class="list_data_text" height="15">
			<select name="D8">
				<option>��ѡ��...</option>
				<option>С��</option>
				<option>����</option>
				<option>����</option>
				<option>��С��</option>
				<option>�ܽ���</option>
			</select>
			<button class="common_button" onclick="reload();">����</button>  
			
		</td>
		<td class="list_data_op" height="15">
						
			<img onclick="del('���ͻ����Ϻ���Ϣ�Ƽ����޹�˾��');" title="ɾ��" src="../../images/bt_del.gif" class="op_button" />  
			
		</td>
	</tr>	
	<tr>
		<td class="list_data_number" height="35">439</td>
		<td class="list_data_text" height="35">��������̲ݹ�˾</td>
		<td class="list_data_ltext" height="35">ѯ���������۸�</td>
		<td class="list_data_text" height="35">��ѯ</td>
		<td class="list_data_text" height="35">С��</td>
		<td class="list_data_text" height="35">2007��12��02��</td>
		<td class="list_data_text" height="35">
			<select name="D9">
				<option>��ѡ��...</option>
				<option>С��</option>
				<option>����</option>
				<option>����</option>
				<option>��С��</option>
				<option>�ܽ���</option>
			</select>
			<button class="common_button" onclick="reload();">����</button>  
			
		</td>
		<td class="list_data_op" height="35">
						
			<img onclick="del('���ͻ����Ϻ���Ϣ�Ƽ����޹�˾��');" title="ɾ��" src="../../images/bt_del.gif" class="op_button" />  
			
		</td>
	</tr>
	<tr>
		<td class="list_data_number">438</td>
		<td class="list_data_text">��������̲ݹ�˾</td>
		<td class="list_data_ltext">ѯ���������۸�</td>
		<td class="list_data_text">����</td>
		<td class="list_data_text">С��</td>
		<td class="list_data_text">2007��12��02��</td>
		<td class="list_data_text">
			<select name="D10">
				<option>��ѡ��...</option>
				<option>С��</option>
				<option>����</option>
				<option>����</option>
				<option>��С��</option>
				<option>�ܽ���</option>
			</select>
			<button class="common_button" onclick="reload();">����</button>  
			
		</td>
		<td class="list_data_op">
						
			<img onclick="del('���ͻ����Ϻ���Ϣ�Ƽ����޹�˾��');" title="ɾ��" src="../../images/bt_del.gif" class="op_button" />  
			
		</td>
	</tr>
	<tr>
		<td class="list_data_number">437</td>
		<td class="list_data_text">��������̲ݹ�˾</td>
		<td class="list_data_ltext">ѯ���������۸�</td>
		<td class="list_data_text">����</td>
		<td class="list_data_text">С��</td>
		<td class="list_data_text">2007��12��02��</td>
		<td class="list_data_text">
			<select name="D11">
				<option>��ѡ��...</option>
				<option>С��</option>
				<option>����</option>
				<option>����</option>
				<option>��С��</option>
				<option>�ܽ���</option>
			</select>
			<button class="common_button" onclick="reload();">����</button>  
			
		</td>
		<td class="list_data_op">
						
			<img onclick="del('���ͻ����Ϻ���Ϣ�Ƽ����޹�˾��');" title="ɾ��" src="../../images/bt_del.gif" class="op_button" />  
			
		</td>
	</tr>
	<tr>
		<th colspan="8" class="pager">
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