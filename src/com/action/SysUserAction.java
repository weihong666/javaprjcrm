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
import com.po.SysUser;
import com.service.BizService;

@Controller
@Namespace("/")
public class SysUserAction implements ISysUserAction {
	@Resource(name = "BizService")
	private BizService bizService;

	private String path;
	private int id;
	private SysUser sysUser;
	private int page;
	private int rows;
	private String usrId; 
	private String usrName; 
	private String usrRoleName;
	private Integer usrAlevel;
	private int userId;
	
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsrId() {
		return usrId;
	}

	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}

	public String getUsrName() {
		return usrName;
	}

	public void setUsrName(String usrName) {
		this.usrName = usrName;
	}

	public String getUsrRoleName() {
		return usrRoleName;
	}

	public void setUsrRoleName(String usrRoleName) {
		this.usrRoleName = usrRoleName;
	}

	public Integer getUsrAlevel() {
		return usrAlevel;
	}

	public void setUsrAlevel(Integer usrAlevel) {
		this.usrAlevel = usrAlevel;
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

	public SysUser getSysUser() {
		return sysUser;
	}

	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}

	public BizService getBizService() {
		return bizService;
	}

	public void setBizService(BizService bizService) {
		this.bizService = bizService;
	}

	// --------------------------------------------------
	@Action(value = "save_SysUser", results = {
			@Result(name = "ok", location = "${path}", type = "redirect"),
			@Result(name = "fail", location = "${path}", type = "redirect") })
	public String save() {
		boolean bl = bizService.getSysUserBiz().save(sysUser);
		
		if (bl) {
			path = "html/user.jsp";
			return "ok";
		} else {
			path = "error.jsp";
			return "fail";
		}
	}

	@Action(value = "update_SysUser", results = {
			@Result(name = "ok", location = "${path}", type = "redirect"),
			@Result(name = "fail", location = "${path}", type = "redirect") })
	public String update() {
		
		
		boolean bl = bizService.getSysUserBiz().update(sysUser);
		if (bl) {
			
			path = "html/user.jsp";
			return "ok";
		} else {
			path = "error.jsp";
			return "fail";
		}
	}

	@Action(value = "delById_SysUser", results = {
			@Result(name = "ok", location = "${path}", type = "redirect"),
			@Result(name = "fail", location = "${path}", type = "redirect") })
	public String delById() {
		boolean bl = bizService.getSysUserBiz().delById(id);
		if (bl) {
			path = "html/user.jsp";
			return "ok";
		} else {
			path = "error.jsp";
			return "fail";
		}
	}
	@Action(value = "findById_SysUser", results = { @Result(name = "ok", location = "${path}", type = "redirect") })
	public String findById() {
		HttpSession session=ServletActionContext.getRequest().getSession();	
		/*session.setAttribute("id", id);
		session.setAttribute("custName", bizService.getCustomerBiz().findById(id).getCustName());*/
		SysUser oldUser = bizService.getSysUserBiz().findById(id);
		if(oldUser!=null){
			session.setAttribute("oldUser", oldUser);
			path = "html/edit.jsp";
			return "ok";
		}
		
		return null;
	}
	@Action(value = "findByUserId_SysUser", results = { @Result(name = "ok", location = "${path}", type = "redirect") })
	public String findByUserId() {
		HttpSession session=ServletActionContext.getRequest().getSession();	
		/*session.setAttribute("id", id);
		session.setAttribute("custName", bizService.getCustomerBiz().findById(id).getCustName());*/
		SysUser oldUserId = bizService.getSysUserBiz().findById(userId);
		if(oldUserId!=null){
			session.setAttribute("oldUserId", oldUserId);
			path = "html/edit.jsp";
			return "ok";
		}
		
		return null;
	}
@Action(value="findAll_SysUser")
	public String findAll() {
		page = page == 0 ? 1 : page;
		rows = rows == 0 ? 5 : rows;
	/*	if (usrAlevel != null && usrAlevel == "全部") {
			usrAlevel = "";
		}
		if (usrAlevel != null && usrAlevel == "客户经理") {
			usrAlevel = 1;
		}
		if (usrAlevel != null && usrAlevel == "普通员工") {
			usrAlevel = 0;
		}*/
		// 获取总行数
		int total = bizService.getSysUserBiz().findMaxRow(usrId,usrName,usrRoleName,usrAlevel);
		// 获取每页记录的集合
		List<SysUser> lsSysUsers = bizService.getSysUserBiz().findAll(usrId,usrName,usrRoleName,usrAlevel,
				page, rows);
		Map<String, Object> map = new HashMap<String, Object>();

		map.put("total", total);
		map.put("rows", lsSysUsers);

		
		String lsusjsonstr = JSONObject.toJSONString(map);

		PrintWriter out = getOut();
		out.print(lsusjsonstr);
		return null;

	}

	@Action(value = "check_SysUser", results = {
			@Result(name = "ok", location = "${path}", type = "redirect"),
			@Result(name = "fail", location = "${path}", type = "redirect") })
	public String check() {
		System.out.println("执行action:check_SysUser");
		HttpSession session = ServletActionContext.getRequest().getSession();
		SysUser user = bizService.getSysUserBiz().check(sysUser);
		if (user != null) {
			session.setAttribute("user", user);
			List<SysUser> lsus = bizService.getSysUserBiz().findAll();
			session.setAttribute("elsus", lsus);
				path = "html/index.jsp";		
			return "ok";
		} else {
			session.setAttribute("error", "用户名或者密码错误！");
			path = "login.jsp";
			return "fail";
		}
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
