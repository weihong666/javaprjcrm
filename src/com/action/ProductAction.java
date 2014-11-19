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
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.jmx.HibernateService;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.*;
import com.po.*;
import com.service.BizService;

@Controller
@Namespace("/")
public class ProductAction implements IProductAction {

	@Resource(name="BizService")
	private BizService bizs;
	
	private int page;
	private int rows;
	private String pname;
	private String ptype;
	private String pbatch;
	
	
	
	public BizService getBizs() {
		return bizs;
	}

	public void setBizs(BizService bizs) {
		this.bizs = bizs;
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

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPtype() {
		return ptype;
	}

	public void setPtype(String ptype) {
		this.ptype = ptype;
	}

	public String getPbatch() {
		return pbatch;
	}

	public void setPbatch(String pbatch) {
		this.pbatch = pbatch;
	}

	@Action(value="findAll_Product")
	public String findAll() {
	
		
			page=page==0?1:page;
			rows=rows==0?10:rows;
			
			//鑾峰彇鎬昏鏁�
			int total=bizs.getProductBiz().findMaxRow(pname, ptype, pbatch);
			//鑾峰彇姣忛〉璁板綍鐨勯泦鍚�
			List<Product> lspd=bizs.getProductBiz().findAll(pname, ptype, pbatch, page, rows);
			
			Map<String,Object> map=new HashMap<String, Object>();
			
			map.put("total", total);
			map.put("rows", lspd);
			
			//缂栧啓杩囨护鍣紝杩囨护鍏宠仈瀛楁
			PropertyFilter propertyFilter=new PropertyFilter() {
				
				public boolean apply(Object arg0, String name, Object arg2) {
					//杩囨护ordersLines灞炴�
					if(name.equals("ordersLines")){
						return false;
					}
					if(name.equals("storages")){
						return false;
					}
					if(name.equals("cstActivities")){
						return false;
					}
					if(name.equals("cstServices")){
						return false;
					}
					if(name.equals("cstLosts")){
						return false;
					}
					if(name.equals("orderses")){
						return false;
					}
					if(name.equals("cstLinkmans")){
						return false;
					}
					return true;
				}
			};
			
			String lspdjsonstr=JSONObject.toJSONString(map,propertyFilter,SerializerFeature.DisableCircularReferenceDetect);
			System.out.println("lspdjsonstr------>"+lspdjsonstr);
			PrintWriter out=getOut();
			out.print(lspdjsonstr);
			out.flush();
			out.close();
			return null;
	
	}

	public PrintWriter getOut(){
		HttpServletResponse rep=ServletActionContext.getResponse();
		rep.setCharacterEncoding("utf-8");
		PrintWriter out=null;
		try {
			out = rep.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return out;
	}
}
