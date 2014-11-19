package com.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.PropertyFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.po.Orders;
import com.po.OrdersLine;
import com.service.BizService;

@Controller
@Namespace("/")
public class OrdersLineAction implements IOrdersLineAction {
	@Resource(name="BizService")
	private BizService bizService;
	private OrdersLine ordersLine;
	private String path;
	private int id;
	private int page;
	private int rows;

	//------------------------------------------
	public BizService getBizService() {
		return bizService;
	}

	public void setBizService(BizService bizService) {
		this.bizService = bizService;
	}

	public OrdersLine getOrdersLine() {
		return ordersLine;
	}

	public void setOrdersLine(OrdersLine ordersLine) {
		this.ordersLine = ordersLine;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	
//========================================================
	@Action(value = "findAll_OrdersLine")
	public String findAll() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		page=page==0?1:page;
		rows=rows==0?5:rows;
		//获取总行数
		int total=bizService.getOrdersLine().findMaxRow();
		//获取每页记录的集合
		System.out.println("total================"+total);System.out.println("id======================"+id);
		
		List<OrdersLine> lsordersline=bizService.getOrdersLine().findAll(id);
		

		Map<String,Object> map=new HashMap<String, Object>();
		
		map.put("total", total);
		map.put("rows", lsordersline);
		

		//编写属性过滤器,过滤掉集合属性
		PropertyFilter propertyFilter=new PropertyFilter() {
			
			public boolean apply(Object arg0, String pname, Object arg2) {
				if(pname.equals("orderses")){
					return false;
				}
				if(pname.equals("cstLosts")){
					return false;
				}
				if(pname.equals("cstLinkmans")){
					return false;
				}
				if(pname.equals("cstActivities")){
					return false;
				}
				if(pname.equals("cstServices")){
					return false;
				}
				if(pname.equals("storages")){
					return false;
				}
				if(pname.equals("ordersLines")){
					return false;
				}
				return true;
			}
};
		
		String lsusjsonstr=JSONObject.toJSONString(map,propertyFilter,SerializerFeature.DisableCircularReferenceDetect,SerializerFeature.WriteDateUseDateFormat);
		
		PrintWriter out=getOut();
		out.print(lsusjsonstr);
		out.flush();
		out.close();
		return null;
	}
	public PrintWriter getOut() {
		HttpServletResponse rep = ServletActionContext.getResponse();
		rep.setCharacterEncoding("utf-8");
		PrintWriter out = null;
		try {
			out = rep.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return out;
	}


}
