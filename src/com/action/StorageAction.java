package com.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSONObject;
import com.po.*;
import com.service.BizService;

@Controller
@Namespace("/")
public class StorageAction implements IStorageAction {

	private String pname;
	private String stkWarehouse; // 仓库名称

	@Resource(name = "BizService")
	private BizService bizs;

	private String path;

	private int page;
	private int rows;

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getStkWarehouse() {
		return stkWarehouse;
	}

	public void setStkWarehouse(String stkWarehouse) {
		this.stkWarehouse = stkWarehouse;
	}

	public BizService getBizs() {
		return bizs;
	}

	public void setBizs(BizService bizs) {
		this.bizs = bizs;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
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

	@Action(value = "findAll_Storage")
	public String findAll() {
		page = page == 0 ? 1 : page;
		rows = rows == 0 ? 10 : rows;

		// 获取总行数
		int total = bizs.getStorageBiz().findMaxRow(pname, stkWarehouse);
		// 获取每页记录的集合
		List<Storage> lsst = bizs.getStorageBiz().findAll(pname, stkWarehouse,
				page, rows);

		Map<String, Object> map = new HashMap<String, Object>();

		map.put("total", total);
		map.put("rows", lsst);

		String lsstjsonstr = JSONObject.toJSONString(map);
		System.out.println("lsstjsonstr------>" + lsstjsonstr);
		PrintWriter out = getOut();
		out.print(lsstjsonstr);
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
