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

import com.po.BasDict;
import com.po.CstCustomer;
import com.service.BizService;
import com.service.DaoService;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.PropertyFilter;

@Controller
@Namespace("/")
public class CstCustomerAction implements ICstCustomerAction {
	private CstCustomer customer;
	private String path;
	private int id;
	private String custNo;
	private String custName;
	private String custRegion;
	private String custManagerName;
	private String custLevelLabel;

	private int page;
	private int rows;
	@Resource(name = "BizService")
	private BizService bizService;

	public String getCustNo() {
		return custNo;
	}

	public void setCustNo(String custNo) {
		this.custNo = custNo;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustRegion() {
		return custRegion;
	}

	public void setCustRegion(String custRegion) {
		this.custRegion = custRegion;
	}

	public String getCustManagerName() {
		return custManagerName;
	}

	public void setCustManagerName(String custManagerName) {
		this.custManagerName = custManagerName;
	}

	public String getCustLevelLabel() {
		return custLevelLabel;
	}

	public void setCustLevelLabel(String custLevelLabel) {
		this.custLevelLabel = custLevelLabel;
	}

	public CstCustomer getCustomer() {
		return customer;
	}

	public void setCustomer(CstCustomer customer) {
		this.customer = customer;
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

	public String save() {
		
		return null;
	}

	/**
	 * ���¿ͻ���Ϣ
	 * **/
	@Action(value = "update_CstCustomer", results = {
			@Result(name = "ok", location = "${path}", type = "redirect"),
			@Result(name = "fail", location = "${path}", type = "redirect") })
	public String update() {
		
		
		boolean bl = bizService.getCustomerBiz().update(customer);
		if (bl) {
			
			path = "html/~cust/cust/list.jsp";
			return "ok";
		} else {
			path = "error.jsp";
			return "fail";
		}
	}

	/**
	 * ɾ���ͻ���Ϣ
	 * **/
	@Action(value = "delById_CstCustomer", results = {
			@Result(name = "ok", location = "${path}", type = "redirect"),
			@Result(name = "fail", location = "${path}", type = "redirect") })
	public String delById() {
		boolean bl = bizService.getCustomerBiz().delById(id);
		if (bl) {
			path = "html/~cust/cust/list.jsp";
			return "ok";
		} else {
			path = "error.jsp";
			return "fail";
		}
	}

	/**
	 * ����id���ҿͻ�
	 * **/
	@Action(value = "findById_CstCustomer", results = { @Result(name = "ok", location = "${path}", type = "redirect") })
	public String findById() {
		HttpSession session=ServletActionContext.getRequest().getSession();
		
		session.setAttribute("id", id);
		session.setAttribute("custName", bizService.getCustomerBiz().findById(id).getCustName());
		CstCustomer oldcustomer = bizService.getCustomerBiz().findById(id);
		if(oldcustomer!=null){
			session.setAttribute("oldcustomer", oldcustomer);
			path = "html/~cust/cust/edit.jsp";
			return "ok";
		}
		
		return null;
	}
	/*public String findById() {
		HttpSession session=ServletActionContext.getRequest().getSession();
	
		session.setAttribute("custNo", custNo);
		session.setAttribute("custName", bizService.getCstCustomerBiz().findById(custNo).getCustName());
		
		CstCustomer oldcstCustomer=bizService.getCstCustomerBiz().findById(custNo);
		if (oldcstCustomer!=null) {
			session.setAttribute("oldcstCustomer", oldcstCustomer);
			path="html/~cust/cust/edit.jsp";
			return "ok";
		}
		return null;
	}*/
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


	@Action(value = "findAll_CstCustomer")
	public String findAll() {
		HttpSession session=ServletActionContext.getRequest().getSession();
		page = page == 0 ? 1 : page;
		rows = rows == 0 ? 5 : rows;
		
		if (custRegion != null && custRegion == "ȫ��") {
			custRegion = "";
		}
		if (custLevelLabel != null && custLevelLabel == "ȫ��") {
			custLevelLabel = "";
		}
		List<BasDict> lscustRegion=bizService.getBasDictBiz().findAll("����");
		System.out.println("=============^^^^^*****%%%%%#####==========action"+lscustRegion.size());
		session.setAttribute("lscustRegion", lscustRegion);
		List<BasDict> lscustLevelLabel=bizService.getBasDictBiz().findAll("��ҵ�ͻ��ȼ�");
		
		session.setAttribute("lscustLevelLabel", lscustLevelLabel);
		// ��ȡ������
		int total = bizService.getCustomerBiz().findMaxRow(custNo, custName,
				custRegion, custManagerName, custLevelLabel);
		// ��ȡÿҳ��¼�ļ���
		List<CstCustomer> lscustomer = bizService.getCustomerBiz().findAll(
				custNo, custName, custRegion, custManagerName, custLevelLabel,
				page, rows);

		Map<String, Object> map = new HashMap<String, Object>();

		map.put("total", total);
		map.put("rows", lscustomer);

		// ��д���Թ�����,���˵���������
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
