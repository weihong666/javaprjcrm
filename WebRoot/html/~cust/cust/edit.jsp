<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>jb-aptech毕业设计项目</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="../../css/style.css" rel="stylesheet" type="text/css">
<script src="../../script/common.js"></script>
</head>
<body>
<form action="../../../update_CstCustomer" method="post" name="form1" id="form1">
<div class="page_title">客户信息管理 > 客户信息</div>


<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="to('linkman.jsp');">联系人</button>
	<button class="common_button" onclick="to('activities.jsp');">交往记录</button>
	<button class="common_button" onclick="to('orders.jsp');">历史订单</button>
	
	<button class="common_button" onclick="back();" type="button">返回</button>
	<button class="common_button" type="submit" >保存</button>
</div>
<table class="query_form_table">
	<tr>
		<th>客户编号</th>
		<td>
		<s:textfield name="customer.custNo" value="%{#session.oldcustomer.custNo}"/>
		<s:hidden name="customer.custId"  value="%{#session.oldcustomer.custId}"/>
		
		</td>
		<th>名称</th>
		<td><s:textfield name="customer.custName" value="%{#session.oldcustomer.custName}"/><span class="red_star">*</span></td>
	</tr>
	<tr>
		<th>地区</th>
		<td>
		<s:select name="customer.custRegion"  list="#session.lscustRegion" listKey="dictItem" listValue="dictItem" value="#session.oldcustomer.custRegion"></s:select>
			<%--<select name="customer.custRegion">
				<option>请选择...</option>
				<option selected>北京</option>
				<option>华北</option>
				<option>中南</option>
				<option>东北</option>
				<option>西部</option>
			</select>
			--%><span class="red_star">*</span></td>
		<th>客户经理</th>
		<td>
		<s:select name="customer.custManagerName"  list="#session.lsUsers" listKey="usrName" listValue="usrName" value="#session.oldcustomer.custManagerName"></s:select>
			<%--<select name="customer.custManagerName">
				<option>请选择...</option>
				<option selected>小明</option>
				<option>旺财</option>
				<option>球球</option>
				<option>孙小美</option>
				<option>周洁轮</option>
			</select>--%><span class="red_star">*</span>
		</td>
	</tr>	
	<tr>
		<th>客户等级</th>
		<td>
		<s:select name="customer.custLevelLabel"  list="#session.lscustLevelLabel" listKey="dictItem" listValue="dictItem" value="#session.oldcustomer.custLevelLabel"></s:select>
			<%--<select name="customer.custLevelLabel">
				<option>请选择...</option>
				<option selected>战略合作伙伴</option>
				<option>合作伙伴</option>
				<option>大客户</option>
				<option>重点开发客户</option>
				<option>普通客户</option>
			</select>
			
			--%><span class="red_star">*</span>
		</td>
		<th>　</th>
		<td>　</td>
	</tr>
	<tr>
		<th>客户满意度</th>
		<td>
			<select name="customer.custSatisfy">
					<option value="">未指定</option>
					<option value="5">☆☆☆☆☆</option>
					<option value="4">☆☆☆☆</option>
					<option value="3" selected="selected">☆☆☆</option>
					<option value="2">☆☆</option>
					<option value="1">☆</option></select><span class="red_star">*</span>
		</td>
		<th>客户信用度</th>
		<td>
			<select name="customer.custCredit">
					<option value="">未指定</option>
					<option value="5">☆☆☆☆☆</option>
					<option value="4">☆☆☆☆</option>
					<option value="3" selected="selected">☆☆☆</option>
					<option value="2">☆☆</option>
					<option value="1">☆</option></select><span class="red_star">*</span>
		</td>
	</tr>
</table>
<br />
<table class="query_form_table" id="table1">
	<tr>
		<th>地址</th>
		<td><input name="customer.custAddr" value="北京市海淀区成府路702号"  /><span class="red_star">*</span>
		</td>
		<th>邮政编码</th>
		<td><input  name="customer.custZip" value="100027"  size="20" /><span class="red_star">*</span></td>
	</tr>
	<tr>
		<th>电话</th>
		<td>
			<input   name="customer.custTel" value="010-62283393"  size="20"  /><span class="red_star">*</span></td>
		<th>传真</th>
		<td>
			<input value="010-62283396" name="customer.custFax" size="20"  /><span class="red_star">*</span>
		</td>
	</tr>	
	<tr>
		<th>网址</th>
		<td>
			<input value="www.conghai.com" name="customer.custWebsite" size="20"  /><span class="red_star">*</span>
		</td>
		<th>　</th>
		<td>　</td>
	</tr>

</table>
<br />
<table class="query_form_table" id="table2">
	<tr>
		<th>营业执照注册号</th>
		<td><input value="123456" name="customer.custLicenceNo" size="20" /></td>
		<th>法人</th>
		<td><input value="聪颖" name="customer.custChieftain" size="20" /><span class="red_star">*</span>
		</td>
	</tr>
	<tr>
		<th>注册资金（万元）</th>
		<td>
			<input value="10000" name="customer.custBankroll" size="20" /> </td>
		<th>年营业额</th>
		<td>
			<input value="100000" name="customer.custTurnover" size="20" />
		</td>
	</tr>	
	<tr>
		<th>开户银行</th>
		<td>
			<input value="北京银行 中关村支行" name="customer.custBank" size="20" /><span class="red_star">*</span>
		</td>
		<th>银行帐号</th>
		<td><input value="62258827238382838" name="customer.custBankAccount" size="20" /><span class="red_star">*</span></td>
	</tr>
	<tr>
		<th>地税登记号</th>
		<td>
			<input value="1111" name="customer.custLocalTaxNo" size="20" /></td>
		<th>国税登记号</th>
		<td><input value="" name="customer.custNationalTaxNo" size="20" /></td>
	</tr>
</table>
<p>　</p>
</form>
</body>
</html>
