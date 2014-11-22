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
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.PropertyFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.po.CstLinkman;
import com.po.CstService;
import com.po.Orders;
import com.service.BizService;

@Controller
@Namespace("/")
public class OrdersAction implements IOrdersAction {
	private Orders orders;
	private String path;
	private int id;
	private String custName;
	private int page;
	private int rows;
	private int custId;
	private String odrDate;
	private String odrCustomer;
	@Resource(name = "BizService")
	private BizService bizService;
//------------------------------------------------------------		

	public Orders getOrders() {
		return orders;
	}

	public String getOdrDate() {
		return odrDate;
	}

	public void setOdrDate(String odrDate) {
		this.odrDate = odrDate;
	}

	public String getOdrCustomer() {
		return odrCustomer;
	}

	public void setOdrCustomer(String odrCustomer) {
		this.odrCustomer = odrCustomer;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
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

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
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

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public BizService getBizService() {
		return bizService;
	}

	public void setBizService(BizService bizService) {
		this.bizService = bizService;
	}
	//-----------------------------------------------------------
	@Action(value = "save_Orders", results = {
			@Result(name = "ok", location = "${path}", type = "redirect"),
			@Result(name = "fail", location = "${path}", type = "redirect") })
	public String save() {
		boolean bl=bizService.getOrdersBiz().save(orders);
		if(bl){
			path="html/~cust/cust/orders.jsp";
			return "ok";
		}else{
			path="error.jsp";
			return "fail";
		}
	}
	@Action(value = "update_Orders", results = {
			@Result(name = "ok", location = "${path}", type = "redirect"),
			@Result(name = "fail", location = "${path}", type = "redirect") })
	public String update() {
		boolean bl=bizService.getOrdersBiz().update(orders);
		if(bl){
			path="html/~cust/cust/orders.jsp";
			return "ok";
		}else{
			path="error.jsp";
			return "fail";
		}
	}
	@Action(value = "delById_Orders", results = {
			@Result(name = "ok", location = "${path}", type = "redirect"),
			@Result(name = "fail", location = "${path}", type = "redirect") })
	public String delById() {
		boolean bl=bizService.getOrdersBiz().delById(id);
		if(bl){
			path="html/~cust/cust/orders.jsp";
			return "ok";
		}else{
			path="error.jsp";
			return "fail";
		}
	}
	@Action(value = "findById_Orders", results = { @Result(name = "ok", location = "${path}", type = "redirect") })
	public String findById() {
		HttpSession session = ServletActionContext.getRequest().getSession();

		Orders oldorders=bizService.getOrdersBiz().findById(id);
		if(oldorders!=null){
		session.setAttribute("oldorders", oldorders);
		path = "html/~cust/cust/orders_detail.jsp";
		return "ok";
		}
		return null;
	}
	@Action(value = "findAll_Orders")
	public String findAll() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		page=page==0?1:page;
		rows=rows==0?5:rows;
		System.out.println(custId+"================");
		//获取总行数
		int total=bizService.getOrdersBiz().findMaxRow();
		//获取每页记录的集合
		List<Orders> lsorders=bizService.getOrdersBiz().findAll(custId);
		System.out.println("**************"+lsorders.get(0).getOdrStatus());
		System.out.println("==="+lsorders.size());
		session.setAttribute("custName", custName);
		session.setAttribute("custId", custId);
		Map<String,Object> map=new HashMap<String, Object>();
		
		map.put("total", total);
		map.put("rows", lsorders);
		

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
	@Action(value = "findByTotal_Orders")
	public String findByTotal() {
		List<Orders> lsOrders = bizService.getOrdersBiz().findByTotal(odrDate, odrCustomer,orders.getOdrId());

		Map<String, Object> map = new HashMap<String, Object>();


		map.put("rows", lsOrders);

		// 编写属性过滤器,过滤掉集合属性
		PropertyFilter propertyFilter = new PropertyFilter() {

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
				if(pname.equals("ordersLines")){
					return false;
				}
				return true;
			}
		};

		String lsusjsonstr=JSONObject.toJSONString(map,propertyFilter,SerializerFeature.DisableCircularReferenceDetect,SerializerFeature.WriteDateUseDateFormat);

		PrintWriter out = getOut();
		out.print(lsusjsonstr);
		return null;
	}

}
