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
import com.po.CstActivity;
import com.po.CstCustomer;
import com.po.CstLinkman;
import com.service.BizService;

@Controller
@Namespace("/")
public class CstLinkmanAction implements ICstLinkmanAction {
	private CstLinkman linkman;
	private String path;
	private int id;
	private String custName;
	private int page;
	private int rows;
	private int custId;
	@Resource(name = "BizService")
	private BizService bizService;

	public CstLinkman getLinkman() {
		return linkman;
	}

	public void setLinkman(CstLinkman linkman) {
		this.linkman = linkman;
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

	// ---------------------------------------
	@Action(value = "save_CstLinkman", results = {
			@Result(name = "ok", location = "${path}", type = "redirect"),
			@Result(name = "fail", location = "${path}", type = "redirect") })
	public String save() {
		boolean bl = bizService.getCstLinkmanBiz().save(linkman);
		path = "html/~cust/cust/linkman.jsp";
		if (bl) {
			
			return "ok";
		} else {
			path = "error.jsp";
			return "fail";
		}
	}

	@Action(value = "update_CstLinkman", results = {
			@Result(name = "ok", location = "${path}", type = "redirect"),
			@Result(name = "fail", location = "${path}", type = "redirect") })
	public String update() {
		/*HttpSession session=ServletActionContext.getRequest().getSession();	
		CstLinkman oldLinkman=bizService.getCstLinkmanBiz().findById(linkman.getCstCustomer().getCustId());
		oldLinkman.getCstCustomer().setCustName(linkman.getCstCustomer().getCustName());*/
		
		boolean bl = bizService.getCstLinkmanBiz().update(linkman);
		if (bl) {
			path = "html/~cust/cust/linkman.jsp";
			return "ok";
		} else {
			path = "error.jsp";
			return "fail";
		}
	}

	@Action(value = "delById_CstLinkman", results = {
			@Result(name = "ok", location = "${path}", type = "redirect"),
			@Result(name = "fail", location = "${path}", type = "redirect") })
	public String delById() {
		boolean bl = bizService.getCstLinkmanBiz().delById(id);
		if (bl) {
			path = "html/~cust/cust/linkman.jsp";
			return "ok";
		} else {
			path = "error.jsp";
			return "fail";
		}
	}

	@Action(value = "findById_CstLinkman", results = { @Result(name = "ok", location = "${path}", type = "redirect") })
	public String findById() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		CstLinkman oldLinkman=bizService.getCstLinkmanBiz().findById(id);
		if(oldLinkman!=null){
			System.out.println("oldLinkman======================"+oldLinkman);
			session.setAttribute("oldlinkman", oldLinkman);
			path = "html/~cust/cust/linkman_edit.jsp";
			return "ok";
		}
		return null;
	}
	@Action(value = "findAll_CstLinkman")
	public String findAll() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("custId", custId);
		session.setAttribute("custName", bizService.getCustomerBiz()
				.findById(custId).getCustName());
		page=page==0?1:page;
		rows=rows==0?5:rows;
		//获取总行数
		int total=bizService.getCstLinkmanBiz().findMaxRow();
		//获取每页记录的集合
		List<CstLinkman> lsLinkmans=bizService.getCstLinkmanBiz().findAll(custId);
		
		/*session.setAttribute("custName", custName);
		session.setAttribute("custId", custId);*/
		Map<String,Object> map=new HashMap<String, Object>();
		
		map.put("total", total);
		map.put("rows", lsLinkmans);
		

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
				if(pname.equals("storages")){
					return false;
				}
				if(pname.equals("products")){
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
