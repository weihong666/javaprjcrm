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
import com.po.CstCustomer;
import com.po.CstLost;
import com.service.BizService;

@Controller
@Namespace("/")
public class CstLostAction implements ICstLostAction {
	private CstLost cstLost;
	private int id;
	private String path;
	private int lstId;
	private int page;
	private int rows;
	private String lstCustName;
	private String lstCustManagerName;
	private String lstStatus;
	@Resource(name = "BizService")
	private BizService bizService;
	
	
	
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public int getLstId() {
		return lstId;
	}

	public void setLstId(int lstId) {
		this.lstId = lstId;
	}

	public String getLstCustName() {
		return lstCustName;
	}

	public void setLstCustName(String lstCustName) {
		this.lstCustName = lstCustName;
	}

	public String getLstCustManagerName() {
		return lstCustManagerName;
	}

	public void setLstCustManagerName(String lstCustManagerName) {
		this.lstCustManagerName = lstCustManagerName;
	}

	public String getLstStatus() {
		return lstStatus;
	}

	public void setLstStatus(String lstStatus) {
		this.lstStatus = lstStatus;
	}

	public BizService getBizService() {
		return bizService;
	}

	public void setBizService(BizService bizService) {
		this.bizService = bizService;
	}

	public CstLost getCstLost() {
		return cstLost;
	}

	public void setCstLost(CstLost cstLost) {
		this.cstLost = cstLost;
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
//======================================================================
	@Action(value = "save_CstLost", results = {
			@Result(name = "ok", location = "${path}", type = "redirect"),
			@Result(name = "fail", location = "${path}", type = "redirect") })
	public String save() {
		boolean bl = bizService.getLostBiz().save(cstLost);
		if (bl) {
			
			path = "html/~cust/lost/list.jsp";
			return "ok";
		} else {
			path = "error.jsp";
			return "fail";
		}
	}
	
	/***
	 * 已流失
	 * **/
	@Action(value = "update_CstLost", results = {
			@Result(name = "ok", location = "${path}", type = "redirect"),
			@Result(name = "fail", location = "${path}", type = "redirect") })
	public String update() {
		boolean bl = bizService.getLostBiz().update(cstLost);
		if (bl) {
			
			path = "html/~cust/lost/list.jsp";
			return "ok";
		} else {
			path = "error.jsp";
			return "fail";
		}
	}
	/***
	 * 暂缓流失
	 * **/
	@Action(value = "updateold_CstLost", results = {
			@Result(name = "ok", location = "${path}", type = "redirect"),
			@Result(name = "fail", location = "${path}", type = "redirect") })
	public String updateold() {
	/*	HttpSession session=ServletActionContext.getRequest().getSession();
		
		CstLost oodcstLost=bizService.getLostBiz().findById(cstLost.getLstId());
		oodcstLost.setLstDelay(cstLost.getLstDelay());*/
		boolean bl = bizService.getLostBiz().update(cstLost);
		
		if (bl) {	
			path = "html/~cust/lost/list.jsp";
			return "ok";
		} else {
			path = "error.jsp";
			return "fail";
		}
	}
	@Action(value = "delById_CstLost", results = { 
			@Result(name = "ok", location = "${path}", type = "redirect") })
	public String delById() {
		CstLost oodcstLost = bizService.getLostBiz().findById(id);
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("oodcstLost", oodcstLost);
		path = "html/~cust/lost/relay.jsp";
		return "ok";
	}
	
	/***
	 * 已流失
	 * **/
	@Action(value = "findById_CstLost", results = { 
			@Result(name = "ok", location = "${path}", type = "redirect") })
	public String findById() {
		CstLost oldcstLost = bizService.getLostBiz().findById(id);
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("oldcstLost", oldcstLost);
		path = "html/~cust/lost/confirm.jsp";
		return "ok";
	}
	@Action(value = "findAll_CstLost")
	public String findAll() {
		page = page == 0 ? 1 : page;
		rows = rows == 0 ? 5 : rows;
		System.out.println("=======================action");
		if (lstStatus != null && lstStatus == "全部") {
			lstStatus = "";
		}
		/*if (custLevelLabel != null && custLevelLabel == "全部") {
			custLevelLabel = "";
		}*/
		// 获取总行数
		int total = bizService.getLostBiz().findMaxRow(lstCustName, lstCustManagerName, lstStatus);
		// 获取每页记录的集合
		List<CstLost> lsLosts = bizService.getLostBiz().findAll(lstCustName, lstCustManagerName, lstStatus, page, rows);

		Map<String, Object> map = new HashMap<String, Object>();

		map.put("total", total);
		map.put("rows", lsLosts);

		// 编写属性过滤器,过滤掉集合属性
		PropertyFilter propertyFilter = new PropertyFilter() {

			public boolean apply(Object arg0, String pname, Object arg2) {
				if (pname.equals("orderses")) {
					return false;
				}
				if (pname.equals("cstLosts")) {
					return false;
				}
				if (pname.equals("cstLinkmans")) {
					return false;
				}
				if (pname.equals("cstActivities")) {
					return false;
				}
				if (pname.equals("cstServices")) {
					return false;
				}
				return true;
			}
		};

		String lsusjsonstr = JSONObject.toJSONString(map, propertyFilter);

		PrintWriter out = getOut();
		out.print(lsusjsonstr);
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
	@Action(value = "findAllLost_CstLost")
	public String findAllLost() {
		page = page == 0 ? 1 : page;
		rows = rows == 0 ? 5 : rows;

		// 获取总行数
		int total = bizService.getLostBiz().findMaxRow(lstCustName, lstCustManagerName);
		// 获取每页记录的集合
		List<CstLost> lsLosts = bizService.getLostBiz().findAll(lstCustName, lstCustManagerName, page, rows);
		
		Map<String, Object> map = new HashMap<String, Object>();

		map.put("total", total);
		map.put("rows", lsLosts);
	
		// 编写属性过滤器,过滤掉集合属性
		PropertyFilter propertyFilter = new PropertyFilter() {

			public boolean apply(Object arg0, String pname, Object arg2) {
				if (pname.equals("orderses")) {
					return false;
				}
				if (pname.equals("cstLosts")) {
					return false;
				}
				if (pname.equals("cstLinkmans")) {
					return false;
				}
				if (pname.equals("cstActivities")) {
					return false;
				}
				if (pname.equals("cstServices")) {
					return false;
				}
				return true;
			}
		};

		String lsusjsonstr = JSONObject.toJSONString(map, propertyFilter);

		PrintWriter out = getOut();
		out.print(lsusjsonstr);
		return null;
	}
}
