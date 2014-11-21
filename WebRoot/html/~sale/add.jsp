<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="java.math.BigDecimal"%>
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
<link href="../css/style.css" rel="stylesheet" type="text/css" />
<script src="../script/common.js" charset="gb2312"></script>
<script type="text/javascript">
	function save() {
		if (document.getElementById("chcCustName").value == "") {
			alert("请输入客户名称");
			document.getElementById("chcCustName").focus();
			return;
		}
		if (document.getElementById("chcRate").value == "") {
			alert("请输入成功机率");
			document.getElementById("chcRate").focus();
			return;
		}
		if (document.getElementById("chcTitle").value == "") {
			alert("请输入概要");
			document.getElementById("chcTitle").focus();
			return;
		}
		if (document.getElementById("chcDesc").value == "") {
			alert("请输入机会描述");
			document.getElementById("chcDesc").focus();
			return;
		}
		document.forms['ff'].submit();
	}
</script>

</head>
<body>

	<div class="page_title">销售机会管理&nbsp; &gt; 新建销售机会</div>
	<form action="../../save_SalChance.action" method="post" name="form1"
		id="ff">
		<div class="button_bar">

			<button class="common_button" onclick="help('');">帮助</button>
			<button class="common_button" onclick="back();" type="button">返回</button>
			<button class="common_button" onclick="save()">保存</button>
		</div>
		<table class="query_form_table">
			<tr>
				<th>编号</th>
				<td><input name="salChance.chcId" readonly />
				</td>
				<th>机会来源</th>
				<td><input name="salChance.chcSource" size="20" />
				</td>
			</tr>
			<tr>
				<th>客户名称</th>
				<td><input name="salChance.chcCustName" id="chcCustName" /><span
					class="red_star">*</span>
				</td>
				<th>成功机率</th>
				<td><input name="salChance.chcRate" id="chcRate" /><span
					class="red_star">*</span>
				</td>
			</tr>
			<tr>
				<th>概要</th>
				<td colspan="3"><input name="salChance.chcTitle" size="52"
					id="chcTitle" /><span class="red_star">*</span>
				</td>
			</tr>
			<tr>
				<th>联系人</th>
				<td><input name="salChance.chcLinkman" size="20" />
				</td>
				<th>联系人电话</th>
				<td><input name="salChance.chcTel" size="20" />
				</td>
			</tr>
			<tr>
				<th>机会描述</th>
				<td colspan="3"><textarea rows="6" cols="50"
						name="salChance.chcDesc" id="chcDesc" /></textarea><span class="red_star">*</span>
				</td>
			</tr>
			<tr>
				<th>创建人</th>
				<td><input name="salChance.chcCreateBy" value="灰太狼" readonly
					size="20" id="chcCreateBy" /> <span class="red_star">*</span></td>
				<th>创建时间</th>
				<td><input id="t1" name="salChance.chcCreateDate" readonly
					size="20" /><span class="red_star">*</span>
				</td>
			</tr>
		</table>
		<br />
		<table disabled class="query_form_table" id="table1">
			<tr>
				<th>指派给</th>
				<td><select name="D1">
						<option>请选择...</option>
				</select> <span class="red_star">*</span>
				</td>
				<th>指派时间</th>
				<td><input id="t2" name="salChance.chcDueDate" readonly
					size="20" /><span class="red_star">*</span>
				</td>
			</tr>
		</table>
		<script>
			setCurTime('t1');
			setCurTime('t2');
		</script>
	</form>
</body>
</html>
