<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags"  prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>jb-aptech毕业设计项目</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="../../css/style.css" rel="stylesheet" type="text/css">
<script src="../../script/common.js"></script>
</head>
<body>
<s:form name="form1" action="../../../save_CstService.action" method="post" id="ff">
<div class="page_title">客户服务管理 > 服务创建</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button"  type="submit">保存</button>  
  
</div>
<table class="query_form_table">
	<tr>
		<th>编号</th>
		<td><input disabled="disabled"  value="系统自增"/></td>
		<th>服务类型</th>
		<td>
			<select name="cstService.svrType">
				<option value="咨询">咨询</option>
				<option value="投诉">投诉</option>
				<option value="建议">建议</option>
			</select><span class="red_star">*</span>
		</td>
	</tr>
	<tr>
		<th>概要</th>
		<td colspan="3"><input name="cstService.svrTitle" /><span class="red_star">*</span></td>
	</tr>	
	<tr>
		<th>客户</th>
		<td><input name="cstService.svrCustName" /><span class="red_star">*</span></td>
		<th>状态</th>
		<td>新创建<input  type="hidden" name="cstService.svrStatus" value="新创建"/></td>
		
	</tr>	
	<tr>
		<th>服务请求</th>
		<td colspan="3"><s:textarea  name="cstService.svrRequest"  rows="6" cols="50"/><span class="red_star">*</span></td>
	</tr>
	<tr>
		<th>创建人</th>
		<td><input name="cstService.svrCreateBy" value=${user.usrName } readonly size="20" /><span class="red_star">*</span></td>
		<th>创建时间</th>
		<td><input id="t1" type="text"name="cstService.svrCreateDate" value="<%=new Date().toLocaleString() %>"  readonly size="20" /><span class="red_star">*</span></td>
	</tr>
	</table>
<br />
<table disabled class="query_form_table" id="table3">
	<tr>
		<th>分配给</th>
		<td>
			<select name="cstService.svrDueTo">
				<option>请选择...</option>
				<option>小明</option>
				<option>旺财</option>
				<option>球球</option>
				<option>孙小美</option>
				<option>周洁轮</option>
			</select> <span class="red_star">*</span></td>
		<th>分配时间</th>
		<td><input id="t2" name="cstService.svrDueDate" readonly size="20" /><span class="red_star">*</span></td>
	</tr>
</table>
<br />	
<table disabled class="query_form_table" id="table1">
	<tr>
		<th>服务处理</th>
		<td colspan="3"><textarea  name="cstService.svrDeal" rows="6" cols="50"></textarea><span class="red_star">*</span></td>
	</tr>
	<tr>
		<th>处理人</th>
		<td><input name="cstService.svrDealBy" value="刘颖" readonly size="20" /><span class="red_star">*</span></td>
		<th>处理时间</th>
		<td><input id="t3" name="cstService.svrDealDate" readonly size="20" /><span class="red_star">*</span></td>
	</tr>
</table>
<br />
<table disabled class="query_form_table" id="table2">
	<tr>
		<th>处理结果</th>
		<td><input name="cstService.svrResult" size="20" /><span class="red_star">*</span></td>
		<th>满意度</th>
		<td>
			<select name="cstService.svrSatisfy" id="svrSatisfy">
				<option value="0">请选择...</option>
				<option value="5">☆☆☆☆☆</option>
				<option value="4">☆☆☆☆</option>
				<option value="3">☆☆☆</option>
				<option value="2">☆☆</option>
				<option value="1">☆</option>
			</select><span class="red_star">*</span></td>
	</tr>
</table>
</s:form>
<script>
	setCurTime('t1');
	setCurTime('t2');
	setCurTime('t3');
</script>
</body>
</html>
