<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
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
<link href="../css/style.css" rel="stylesheet" type="text/css">
<script src="../script/common.js" charset="gb2312"></script>
<%--<script type="text/javascript">
	function save(){
		alert("保存成功!");
		}
	document.forms['ff'].submit();  
	}	
	
	</script>
--%>
</head>
<body>

	<div class="page_title">销售机会管理&nbsp; &gt; 指派销售机会</div>
	<s:form action="../../update_SalChance.action" method="post"
		name="form1" id="ff">
		<div class="button_bar">
			<button class="common_button" onclick="help('');">帮助</button>
			<button class="common_button" onclick="back();" type="button">返回</button>
			<button class="common_button" type="submit">保存</button>
		</div>
		<table class="query_form_table">
			<tr>
				<th>编号</th>
				<td>${oldsalChance1.chcId} <s:hidden name="salChance.chcId"
						value="%{#session.oldsalChance1.chcId}" /></td>
				<th>机会来源</th>
				<td>${oldsalChance1.chcSource} <s:hidden
						name="salChance.chcSource"
						value="%{#session.oldsalChance1.chcSource}" /></td>
			</tr>
			<tr>
				<th>客户名称</th>
				<td>${oldsalChance1.chcCustName} <s:hidden
						name="salChance.chcCustName"
						value="%{#session.oldsalChance1.chcCustName}" /></td>
				<th>成功机率（%）</th>
				<td>${oldsalChance1.chcRate} <s:hidden name="salChance.chcRate"
						value="%{#session.oldsalChance1.chcRate}" /></td>
			</tr>
			<tr>
				<th>概要</th>
				<td colspan="3">${oldsalChance1.chcTitle} <s:hidden
						name="salChance.chcTitle"
						value="%{#session.oldsalChance1.chcTitle}" /></td>
			</tr>
			<tr>
				<th>联系人</th>
				<td>${oldsalChance1.chcLinkman} <s:hidden
						name="salChance.chcLinkman"
						value="%{#session.oldsalChance1.chcLinkman}" /></td>
				<th>联系人电话</th>
				<td>${oldsalChance1.chcTel} <s:hidden name="salChance.chcTel"
						value="%{#session.oldsalChance1.chcTel}" /></td>
			</tr>
			<tr>
				<th>机会描述</th>
				<td colspan="3">${oldsalChance1.chcDesc} <s:hidden
						name="salChance.chcDesc" value="%{#session.oldsalChance1.chcDesc}" />
				</td>
			</tr>
			<tr>
				<th>创建人</th>
				<td>${user.usrName } <s:hidden name="salChance.chcCreateBy" value="'灰太狼'" />
					<s:hidden name="salChance.chcCreateId"></s:hidden> <s:hidden
						name="salChance.chcStatus"></s:hidden></td>
				<th>创建时间</th>
				<td>${oldsalChance1.chcCreateDate} <s:hidden
						name="salChance.chcCreateDate"
						value="%{#session.oldsalChance1.chcCreateDate}" /></td>
			</tr>
		</table>
		<br />
		<table class="query_form_table" id="table1">
			<tr>
				<th>指派给</th>
				<td><s:select name="salChance.chcDueTo"
						list="#session.lisysuser" listKey="usrName" listValue="usrName"
						value="%{#session.lisysuser.usrName}"></s:select> <span
					class="red_star">*</span>
				</td>
				<th>指派时间</th>
				<td><s:textfield name="salChance.chcDueDate" id="dispatch_date"
						readonly="true"></s:textfield> <span class="red_star">*</span>
				</td>
			</tr>
		</table>
		<script>
			setCurTime('dispatch_date');
		</script>
	</s:form>
</body>
</html>
