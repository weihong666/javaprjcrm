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
	private String usrAlevel;
	
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

	public String getUsrAlevel() {
		return usrAlevel;
	}

	public void setUsrAlevel(String usrAlevel) {
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
	public String save() {
		// TODO Auto-generated method stub
		return null;
	}

	public String update() {
		// TODO Auto-generated method stub
		return null;
	}

	public String delById() {
		// TODO Auto-generated method stub
		return null;
	}

	public String findById() {
		// TODO Auto-generated method stub
		return null;
	}
@Action(value="findAll_SysUser")
	public String findAll() {
		page = page == 0 ? 1 : page;
		rows = rows == 0 ? 5 : rows;
		/*System.out.println("=======================action");
		if (custRegion != null && custRegion == "全部") {
			custRegion = "";
		}
		if (custLevelLabel != null && custLevelLabel == "全部") {
			custLevelLabel = "";
		}*/
		// 获取总行数
		int total = bizService.getSysUserBiz().findMaxRow(usrId,usrName,usrRoleName,usrAlevel);
		// 获取每页记录的集合
		List<SysUser> lsSysUsers = bizService.getSysUserBiz().findAll(usrId,usrName,usrRoleName,usrAlevel,
				page, rows);

		Map<String, Object> map = new HashMap<String, Object>();

		map.put("total", total);
		map.put("rows", lsSysUsers);

		// 编写属性过滤器,过滤掉集合属性
		/*PropertyFilter propertyFilter = new PropertyFilter() {

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
		};*/

		String lsusjsonstr = JSONObject.toJSONString(map);

		PrintWriter out = getOut();
		out.print(lsusjsonstr);
		return null;

	}

	@Action(value = "check_SysUser", results = {
			@Result(name = "ok", location = "${path}", type = "redirect"),
			@Result(name = "fail", location = "${path}", type = "redirect") })
	public String check() {
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
