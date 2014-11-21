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
<script type="text/javascript">
	function update(id) {
		//动态改变form表单的id并取值
		$('#' + id).form('submit', {
			url : '../../update_SalPlan',
			onSubmit : function() {
				return true;
			},
			success : function(data) {
				if (data == 1) {
					alert("修改成功");
					$('#tt').datagrid('reload');
					clearForm();
				} else {
					alert("修改失败");
				}

			}
		});

	}
	function clearForm() {

		$('#' + id).val("");

	}
</script>
</head>
<body>

	<div class="page_title">客户开发计划 &gt; 执行计划</div>
	<div class="button_bar">
		<button class="common_button" onclick="help('');">帮助</button>
		<button class="common_button"
			onclick="alert('开发失败，已归档。');window.location.href='../../finddetailabcdef_SalChance.action?chcId=${oldsalChance2.chcId}';">终止开发</button>
		<button class="common_button" onclick="back();" type="button">返回</button>
		<button class="common_button" onclick="to('dev_plan.jsp');">制定计划</button>
		<button class="common_button"
			onclick="alert('用户开发成功，已添加新客户记录。');window.location.href='../../finddetailabcdef_SalChance.action?chcId=${oldsalChance2.chcId}';">开发成功</button>

	</div>
	<table class="query_form_table">
		<tr>
			<th>编号</th>
			<td>${oldsalChance2.chcId}</td>
			<th>机会来源</th>
			<td>${oldsalChance2.chcSource}</td>
		</tr>
		<tr>
			<th>客户名称</th>
			<td>${oldsalChance2.chcCustName}</td>
			<th>成功机率（%）</th>
			<td>${oldsalChance2.chcRate}</td>
		</tr>
		<tr>
			<th>概要</th>
			<td colspan="3">${oldsalChance2.chcTitle}</td>
		</tr>
		<tr>
			<th>联系人</th>
			<td>${oldsalChance2.chcLinkman}</td>
			<th>联系人电话</th>
			<td>${oldsalChance2.chcTel}</td>
		</tr>
		<tr>
			<th>机会描述</th>
			<td colspan="3">${oldsalChance2.chcDesc}</td>
		</tr>
		<tr>
			<th>创建人</th>
			<td>${oldSalChance2.chcCreateBy }</td>
			<th>创建时间</th>
			<td>${oldsalChance2.chcCreateDate}</td>
		</tr>
		<tr>
			<th>指派给</th>
			<td>${oldsalChance2.chcDueTo}</td>
			<th>指派时间</th>
			<td><s:date name="#session.oldsalChance2.chcDueDate"
					format="yyyy-MM-dd" />
			</td>
		</tr>
	</table>
	<br />
	<table class="easyui-datagrid" style="width:880px;height:100px"
		align="center"
		data-options="
				url:'<%=request.getContextPath()%>/findAll_SalPlan?chcId=${oldsalChance2.chcId}&time=<%=new Date().getTime() %>',
	        	fitColumns:true,singleSelect:true,
	        	loadMsg:'正在加载数据，请稍后...',

	        	pageList:[5,10,15,20]
	        	
        	"
		id="tt">
		<thead>
			<tr>
				<th
					data-options="field:'plaDate',width:100,align:'center',formatter: function(value,row,index){
														if (value){
															return value.substring(0,10);
														} else {
															return value;
														}
													}">日期</th>
				<th data-options="field:'plaTodo',width:380,align:'center'">计划</th>
				<th
					data-options="field:'op',width:380,align:'left',formatter: function(value,row,index){
										return '<form id='+row.plaId+' method=post><input size=50 name=salplan.plaResult value='+row.plaResult+'/>'
											+'<input type=hidden name=salplan.plaId value='+row.plaId+' />'
											+'<input type=hidden name=salplan.salChance.chcId value='+row.salChance.chcId+' />'
											+'<input type=hidden name=salplan.plaDate value='+row.plaDate+' />'
											+'<input type=hidden name=salplan.plaTodo value='+row.plaTodo+' />'
											+' <button class=common_button onclick=update(row.plaId)>保存</button>'
											+'</form>'; 
					 } ">执行效果</th>

			</tr>
		</thead>
	</table>
</body>
</html>
