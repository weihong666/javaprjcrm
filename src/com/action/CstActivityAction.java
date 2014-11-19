package com.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
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
import com.po.CstActivity;
import com.po.CstCustomer;
import com.service.BizService;

@Controller
@Namespace("/")
public class CstActivityAction implements ICstActivityAction {
	private CstActivity activity;
	private String path;
	private int id;
	private String custName;
	private int page;
	private int rows;
	private int custId;
	@Resource(name = "BizService")
	private BizService bizService;

	// -------------------------------------------


	public CstActivity getActivity() {
		return activity;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public void setActivity(CstActivity activity) {
		this.activity = activity;
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

	public BizService getBizService() {
		return bizService;
	}

	public void setBizService(BizService bizService) {
		this.bizService = bizService;
	}

	// -------------------------------------------------
	@Action(value="save_CstActivity",results={
			@Result(name="ok",location="${path}",type="redirect"),
			@Result(name="fail",location="${path}",type="redirect")
	})
	public String save() {	
		boolean bl=bizService.getCstActivityBiz().save(activity);
		if(bl){
			path = "html/~cust/cust/activities.jsp";
			return "ok";
		}else{
			path="error.jsp";
			return "fail";
		}
	}
	@Action(value="update_CstActivity",results={
			@Result(name="ok",location="${path}",type="redirect"),
			@Result(name="fail",location="${path}",type="redirect")
	})
	public String update() { 
		boolean bl=bizService.getCstActivityBiz().update(activity);
		if(bl){
			path = "html/~cust/cust/activities.jsp";
			return "ok";
		}else{
			path="error.jsp";
			return "fail";
		}
		
	}
	@Action(value="delById_CstActivity",results={
			@Result(name="ok",location="${path}",type="redirect"),
			@Result(name="fail",location="${path}",type="redirect")
	})
	public String delById() {
	 
			boolean bl=bizService.getCstActivityBiz().delById(id);
			if(bl){
				path =  "html/~cust/cust/activities.jsp";
				return "ok";
			}else{
				path = "html/~cust/cust/activities.jsp";
				return "fail";
			}	
	}
	@Action(value = "findById_CstActivity", results = { @Result(name = "ok", location = "${path}", type = "redirect") })
	public String findById() {
		HttpSession session = ServletActionContext.getRequest().getSession();

		CstActivity oldcstActivity=bizService.getCstActivityBiz().findById(id);
		session.setAttribute("oldcstActivity", oldcstActivity);
		path = "html/~cust/cust/activities_edit.jsp";
		return "ok";
	}

	@Action(value = "findAll_CstActivity")
	public String findAll() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		page=page==0?1:page;
		rows=rows==0?5:rows;
		//获取总行数
		int total=bizService.getCstActivityBiz().findMaxRow();
		//获取每页记录的集合
		List<CstActivity> lsactivity=bizService.getCstActivityBiz().findAll(custId);
		
		session.setAttribute("custName", custName);
		session.setAttribute("custId", custId);
		Map<String,Object> map=new HashMap<String, Object>();
		
		map.put("total", total);
		map.put("rows", lsactivity);
		

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
