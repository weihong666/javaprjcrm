<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>jb-aptech毕业设计项目</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<link rel="stylesheet" href="../../jquery-easyui-1.3.4/themes/default/easyui.css" type="text/css"></link>
<link rel="stylesheet" href="../../jquery-easyui-1.3.4/themes/icon.css" type="text/css"></link>
<script type="text/javascript" src="../../jquery-easyui-1.3.4/jquery-1.9.1.js"></script>
<script type="text/javascript" src="../../jquery-easyui-1.3.4/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../../jquery-easyui-1.3.4/locale/easyui-lang-zh_CN.js"></script>

<link href="../css/style.css" rel="stylesheet" type="text/css">
<script src="../script/common.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#index").click(function() { 
        			$("#tt").datagrid({
						queryParams: {
							str: $('#str').val()
						}
					});
					$('#myspan').text($('#str').val().substring(1));
					$('#str').val("按等级");
		});
	});
</script>
</head>
<body>

<div class="page_title">客户构成分析</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" id="index" type="submit" >查询</button> 
	</div>
<table class="query_form_table">
	<tr>
		<th>报表方式</th>
		<td>
			<select name="str" id="str">
				<option>按等级</option>
				<option>按信用度</option>
				<option>按满意度</option>
			</select>
		</td>

	<th>&nbsp;</th>
		<td>
			&nbsp;
		</td>
			</tr>
	</table>
<br />
<table  class="easyui-datagrid" style="height:425px;"   
        data-options="
        url:'../../findAllCustomerOrders_CstCustomer.action?t=<%=new Date().getTime() %>',
        fitColumns:true, 
        singleSelect:true"         
        pagination="true" 
        rownumbers="true" 
        pageSize="10" 
        pageList="[10,20,30,40]" 
        loadMsg="正在在加载远程数据，请稍后......"
        align="center" id="tt"
        >   
	    <thead>   
	        <tr>   
	            
	           <th data-options="field:'custName',width:145,align:'center',
	           											formatter: function(value,row,index){
															if (row[0]==1){
																			return '<img src=../images/star.jpg class=star_pic />';
																		}
																		if (row[0]==2){
																			return '<img src=../images/star.jpg class=star_pic /><img src=../images/star.jpg class=star_pic />';
																		}
																		if (row[0]==3){
																			return '<img src=../images/star.jpg class=star_pic /><img src=../images/star.jpg class=star_pic /><img src=../images/star.jpg class=star_pic />';
																		}
																		if (row[0]==4){
																			return '<img src=../images/star.jpg class=star_pic /><img src=../images/star.jpg class=star_pic /><img src=../images/star.jpg class=star_pic /><img src=../images/star.jpg class=star_pic />';
																		}
																		if (row[0]==5){
																			return '<img src=../images/star.jpg class=star_pic /><img src=../images/star.jpg class=star_pic /><img src=../images/star.jpg class=star_pic /><img src=../images/star.jpg class=star_pic /><img src=../images/star.jpg class=star_pic />';
																		}
																		if (row){
																			return row[0];
																		}
																	}"><span id="myspan">等级</span></th>
	            <th data-options="field:'total',width:180,align:'center',
	            formatter: function(value,row,index){
										 								if (row){
																			return row[1];
																		}
											}
	            ">客户数量</th>   
	            <th data-options="field:'dictValue',width:60,align:'center'"></th>   
	            <th data-options="field:'dictValue',width:60,align:'center'"></th>   
	 
	        </tr>   
	    </thead>   
	</table> 
</body>
</html>
