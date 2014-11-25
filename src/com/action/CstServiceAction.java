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
import com.po.CstLost;
import com.po.CstService;
import com.service.BizService;

@Controller
@Namespace("/")
public class CstServiceAction implements ICstServiceAction {
	@Resource(name = "BizService")
	private BizService bizService;
	private String year;
	
	private Integer id;

	private int page;
	private int rows;
	private CstService cstService;
	private String path;
	private String svrCustName;
	private String svrTitle;
	private String svrType;
	private String svrCreateDate;
	private String svrStatus;
	
	private Integer svrId;
	private Integer svrDueId;
	private String svrDueTo;
	
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
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


	public CstService getCstService() {
		return cstService;
	}


	public void setCstService(CstService cstService) {
		this.cstService = cstService;
	}


	public String getPath() {
		return path;
	}


	public void setPath(String path) {
		this.path = path;
	}


	public String getSvrCustName() {
		return svrCustName;
	}


	public void setSvrCustName(String svrCustName) {
		this.svrCustName = svrCustName;
	}


	public String getSvrTitle() {
		return svrTitle;
	}


	public void setSvrTitle(String svrTitle) {
		this.svrTitle = svrTitle;
	}


	public String getSvrType() {
		return svrType;
	}


	public void setSvrType(String svrType) {
		this.svrType = svrType;
	}


	public String getSvrCreateDate() {
		return svrCreateDate;
	}


	public void setSvrCreateDate(String svrCreateDate) {
		this.svrCreateDate = svrCreateDate;
	}


	public String getSvrStatus() {
		return svrStatus;
	}


	public void setSvrStatus(String svrStatus) {
		this.svrStatus = svrStatus;
	}


	public Integer getSvrId() {
		return svrId;
	}


	public void setSvrId(Integer svrId) {
		this.svrId = svrId;
	}


	public Integer getSvrDueId() {
		return svrDueId;
	}


	public void setSvrDueId(Integer svrDueId) {
		this.svrDueId = svrDueId;
	}


	public String getSvrDueTo() {
		return svrDueTo;
	}


	public void setSvrDueTo(String svrDueTo) {
		this.svrDueTo = svrDueTo;
	}


	public String getYear() {
		return year;
	}


	public void setYear(String year) {
		this.year = year;
	}


	public BizService getBizService() {
		return bizService;
	}


	public void setBizService(BizService bizService) {
		this.bizService = bizService;
	}

//==========================================
	@Action(value="findByYear_CstService")
	public String findByYear() {
		List<CstService> lsServices = bizService.getCstServiceBiz().findByYear(year);

		Map<String, Object> map = new HashMap<String, Object>();


		map.put("rows", lsServices);

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

	@Action(value = "save_CstService", results = { @Result(name = "ok", location = "${path}", type = "redirect") })
	public String save() {
		boolean bl = bizService.getCstServiceBiz().save(cstService);
		if (bl) {
			path = "html/~cust/service/dispatch.jsp";

			return "ok";
		}
		return null;
	}

	@Action(value = "findAll_CstService")
	public String findAll() {
	
		PrintWriter out = getOut();
		page = page == 0 ? 1 : page;
		rows = rows == 0 ? 10 : rows;
		List<CstService> cstlist = bizService.getCstServiceBiz().findAll(
				svrCustName, svrTitle, svrType, svrStatus, page, rows);

		int total = bizService.getCstServiceBiz().findMaxRow(svrCustName,
				svrTitle, svrType, svrStatus);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", total);
		map.put("rows", cstlist);

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
				if (pname.equals("storages")) {
					return false;
				}
				if (pname.equals("ordersLines")) {
					return false;
				}
				return true;
			}
		};

		String cstjsonstr = JSONObject.toJSONString(map, propertyFilter,
				SerializerFeature.DisableCircularReferenceDetect,
				SerializerFeature.WriteDateUseDateFormat);

		out.print(cstjsonstr);


		out.flush();
		out.close();
		return null;
	}

	@Action(value = "findById_CstService", results = { @Result(name = "ok", location = "${path}", type = "redirect") })
	public String findById() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		CstService oldcstService = bizService.getCstServiceBiz().findById(id);
		session.setAttribute("oldcstService", oldcstService);
		path = "html/~cust/service/deal_detail.jsp";
		return "ok";
	}

	@Action(value = "findByIdFeedBack_CstService", results = { @Result(name = "ok", location = "${path}", type = "redirect") })
	public String findByIdFeedBack() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		CstService oldcstService = bizService.getCstServiceBiz().findById(id);
		session.setAttribute("oldcstService", oldcstService);

		path = "html/~cust/service/feedback_detail.jsp";

		return "ok";
	}

	@Action(value = "findByIdDetail_CstService", results = { @Result(name = "ok", location = "${path}", type = "redirect") })
	public String findByIdDetail() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		CstService oldcstService = bizService.getCstServiceBiz().findById(id);
		session.setAttribute("oldcstService", oldcstService);

		path = "html/~cust/service/detail.jsp";

		return "ok";
	}

	@Action(value = "delById_CstService")
	public String delById() {
		boolean bl = bizService.getCstServiceBiz().delById(id);
		PrintWriter out = getOut();

		if (bl) {
			out.print(1);
		} else {
			out.print(0);
		}
		out.flush();
		out.close();
		return null;
	}

	public String doinit() {
		// TODO Auto-generated method stub
		return null;
	}


	@Action(value = "update_CstService", results = { @Result(name = "ok", location = "${path}", type = "redirect") })
	public String update() {
	/*	CstService oldcstService=bizService.getCstServiceBiz().findById(id);
		if(oldcstService.getSvrStatus()=="已分配"){
			
			oldcstService.setSvrStatus("已处理");
		}*/
		boolean bl = bizService.getCstServiceBiz().update(cstService);
		if (bl) {
			path = "html/~cust/service/feedback.jsp";
			return "ok";
		}
		return null;
	}

	@Action(value = "updateend_CstService", results = { @Result(name = "ok", location = "${path}", type = "redirect") })
	public String updateend() {
		boolean bl = bizService.getCstServiceBiz().update(cstService);
		if (bl) {
			path = "html/~cust/service/arch.jsp";
			return "ok";
		}
		return null;
	}
	@Action(value="dispatch_CstService",results={
			@Result(name="ok",location="${path}",type="redirect")
	})
	public String dispatch() {
		boolean bl=bizService.getCstServiceBiz().dispatch(svrId, svrDueId, svrDueTo);
		if(bl){
			path="html/~cust/service/dispatch.jsp";
			return "ok";
		}
		return null;
	}

}
