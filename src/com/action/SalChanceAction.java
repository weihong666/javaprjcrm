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


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.PropertyFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;

import com.po.CstCustomer;
import com.po.SalChance;
import com.po.SysUser;
import com.service.BizService;
@Controller
@Namespace("/")
public class SalChanceAction implements ISalChanceAction {
	private SalChance salChance;
	private Integer chcId;
	
	private String path;
	
	private int page;
	private int rows;
	private String chcCustName;
	private String chcTitle;
	private String chcLinkman;
	
	
	@Resource(name="BizService")
	private BizService bizservice;
	
	
	public String getChcCustName() {
		return chcCustName;
	}

	public void setChcCustName(String chcCustName) {
		this.chcCustName = chcCustName;
	}

	public String getChcTitle() {
		return chcTitle;
	}

	public void setChcTitle(String chcTitle) {
		this.chcTitle = chcTitle;
	}

	public String getChcLinkman() {
		return chcLinkman;
	}

	public void setChcLinkman(String chcLinkman) {
		this.chcLinkman = chcLinkman;
	}

	public SalChance getSalChance() {
		return salChance;
	}

	public void setSalChance(SalChance salChance) {
		this.salChance = salChance;
	}

	public Integer getChcId() {
		return chcId;
	}

	public void setChcId(Integer chcId) {
		this.chcId = chcId;
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

	public BizService getBizservice() {
		return bizservice;
	}

	public void setBizservice(BizService bizservice) {
		this.bizservice = bizservice;
	}

	//======================================
	@Action(value="findAll_SalChance")
	public String findAll() {
		HttpSession session=ServletActionContext.getRequest().getSession();
		
		HttpServletResponse rep=ServletActionContext.getResponse();
		rep.setCharacterEncoding("utf-8");
		try {
			PrintWriter out=rep.getWriter();
			page=page==0?1:page;
			rows=rows==0?5:rows;
			if(page<1)page=1;
			if(rows<1)rows=5;
			//获取总行数
			int total=bizservice.getSalchancebiz().findMaxRow(chcCustName, chcTitle, chcLinkman);
			//获取每页记录的集合
			List<SalChance> lisch=bizservice.getSalchancebiz().findAll(chcCustName, chcTitle, chcLinkman, page, rows);
			Map<String,Object> map=new HashMap<String, Object>();
			map.put("total", total);
			map.put("rows", lisch);
			//编写属性过滤器,过滤掉集合属性
			PropertyFilter propertyFilter=new PropertyFilter(){

				public boolean apply(Object arg0, String name, Object arg2) {
					if(name.equals("salPlans")){
						return false;
					}
					
					return true;
				}
				
			};
			String schjsonstr=JSON.toJSONString(map, propertyFilter, SerializerFeature.DisableCircularReferenceDetect,SerializerFeature.DisableCircularReferenceDetect);
			out.print(schjsonstr);
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Action(value="delById_SalChance",results={@Result(name="ok",location="${path}",type="redirect")})
	public String delById() {
		boolean bl=bizservice.getSalchancebiz().delById(chcId);
		if(bl){
			path="html/~sale/list.jsp";
			return "ok";
		}else{
			path="html/~sale/error.jsp";
			return "error";
		}

	}
	
	@Action(value="findById_SalChance",results={@Result(name="ok",location="${path}",type="redirect")})
	public String findById() {
		SalChance oldsalChance=bizservice.getSalchancebiz().findById(chcId);
		HttpSession session=ServletActionContext.getRequest().getSession();
		session.setAttribute("oldsalChance", oldsalChance);
		path="html/~sale/edit.jsp";
		
		return "ok";

	}
	@Action(value="finddetail_SalChance",results={@Result(name="ok",location="${path}",type="redirect")})
	public String finddetail() {
		System.out.println(">>>>>>>>>>>>");
		SalChance oldsalChance1=bizservice.getSalchancebiz().findById(chcId);
		HttpSession session=ServletActionContext.getRequest().getSession();
		session.setAttribute("oldsalChance1", oldsalChance1);
		path="html/~sale/dispatch.jsp";
		return "ok";
	}
	@Action(value="finddetailabcd_SalChance",results={@Result(name="ok",location="${path}",type="redirect")})
	public String finddetailabcd() {
		System.out.println(">>>>>>>>>>>>");
		SalChance oldsalChance2=bizservice.getSalchancebiz().findById(chcId);
		HttpSession session=ServletActionContext.getRequest().getSession();
		session.setAttribute("oldsalChance2", oldsalChance2);
		path="html/~sale/dev_plan.jsp";
		return "ok";
	}
	@Action(value="finddetailabcde_SalChance",results={@Result(name="ok",location="${path}",type="redirect")})
	public String finddetailabcde() {
		System.out.println(">>>>>>>>>>>>");
		SalChance oldsalChance2=bizservice.getSalchancebiz().findById(chcId);
		HttpSession session=ServletActionContext.getRequest().getSession();
		session.setAttribute("oldsalChance2", oldsalChance2);
		path="html/~sale/dev_execute.jsp";
		return "ok";
	}
	@Action(value="finddetailabcdef_SalChance",results={@Result(name="ok",location="${path}",type="redirect")})
	public String finddetailabcdef() {
		System.out.println(">>>>>>>>>>>>");
		String s=null;
		SalChance oldsalChance2=bizservice.getSalchancebiz().findById(chcId);
		HttpSession session=ServletActionContext.getRequest().getSession();
		
		//=====================================
		CstCustomer cstCustomer=new CstCustomer();
		if(oldsalChance2.getChcCustName()!=null&&!oldsalChance2.getChcCustName().equals("")){
			cstCustomer.setCustName(oldsalChance2.getChcCustName());
		}
		if(oldsalChance2.getChcLinkman()!=null&&!oldsalChance2.getChcLinkman().equals("")){
			cstCustomer.setCustChieftain(oldsalChance2.getChcLinkman());
		}
		if(oldsalChance2.getChcTel()!=null&&!oldsalChance2.getChcTel().equals("")){
			cstCustomer.setCustTel(oldsalChance2.getChcTel());
		}
		if(oldsalChance2.getChcDueTo()!=null&&!oldsalChance2.getChcDueTo().equals("")){
			cstCustomer.setCustManagerName(oldsalChance2.getChcDueTo());
		}
		cstCustomer.setCustStatus(1);
		bizservice.getCustomerBiz().save(cstCustomer);
		path="html/~sale/dev.jsp";

		oldsalChance2.setChcStatus(1);
		session.setAttribute("oldsalChance2", oldsalChance2);
		bizservice.getSalchancebiz().update(oldsalChance2);
		path="html/~sale/dev.jsp";
		return "ok";
	}
	@Action(value="finddetailabcdefg_SalChance",results={@Result(name="ok",location="${path}",type="redirect")})
	public String finddetailabcdefg() {
		System.out.println(">>>>>>>>>>>>");
		SalChance oldsalChance2=bizservice.getSalchancebiz().findById(chcId);
		HttpSession session=ServletActionContext.getRequest().getSession();
		session.setAttribute("oldsalChance2", oldsalChance2);
		//====================================
		path="html/~sale/dev_detail.jsp";
		return "ok";
	}
	/*@Action(value="finddetailabcdefgh_SalChance",results={@Result(name="ok",location="${path}",type="redirect")})
	public String finddetailabcdefgh() {
		System.out.println(">>>>>>>>>>>>");
		SalChance oldsalChance2=bizservice.getSalchancebiz().findById(chcId);
		HttpSession session=ServletActionContext.getRequest().getSession();
		
		//====================================
		oldsalChance2.setChcStatus(2);
		session.setAttribute("oldsalChance2", oldsalChance2);
		bizservice.getSalchancebiz().update(oldsalChance2);
		path="html/~sale/dev.jsp";
		return "ok";
	}*/
	@Action(value="finddetailabcdefghl_SalChance",results={@Result(name="ok",location="${path}",type="redirect")})
	public String finddetailabcdefghl() {
		System.out.println(">>>>>>>>>>>>");
		SalChance oldsalChance2=bizservice.getSalchancebiz().findById(chcId);
		HttpSession session=ServletActionContext.getRequest().getSession();
		
		//====================================
		oldsalChance2.setChcStatus(0);
		session.setAttribute("oldsalChance2", oldsalChance2);
		bizservice.getSalchancebiz().update(oldsalChance2);
		path="html/~sale/dev.jsp";
		return "ok";
	}
	@Action(value="save_SalChance",results={
			@Result(name="ok",location="${path}",type="redirect"),
			@Result(name="fail",location="${path}",type="redirect")
	})

	public String save() {
		boolean bl=bizservice.getSalchancebiz().save(salChance);
		if(bl){
			path="html/~sale/list.jsp";
			return "ok";
		}else{
			path="html/~sale/error.jsp";
			return "error";
		}

	}
	@Action(value="init_SalChance",results={@Result(name="ok",location="${path}",type="redirect")})
	public String init(){
		
		HttpSession session=ServletActionContext.getRequest().getSession();
		List<SysUser> lisysuser=bizservice.getSysUserBiz().findAll();
		System.out.println(lisysuser.get(0).getUsrName()+"==========");
		session.setAttribute("lisysuser", lisysuser);
		path="finddetail_SalChance?chcId="+chcId;
		return "ok";
	}
	
	@Action(value="update_SalChance",results={
			@Result(name="ok",location="${path}",type="redirect"),
			@Result(name="fail",location="${path}",type="redirect")
	})
	public String update() {
		boolean bl=bizservice.getSalchancebiz().update(salChance);
		if(bl){
			path="html/~sale/list.jsp";
			return "ok";
		}else{
			path="html/~sale/error.jsp";
			return "error";
		}
	}

}
