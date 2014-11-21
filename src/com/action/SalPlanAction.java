package com.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletResponse;
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
import com.opensymphony.xwork2.ActionContext;
import com.po.SalChance;
import com.po.SalPlan;
import com.service.BizService;

@Controller
@Namespace("/")
public class SalPlanAction implements ISalPlanAction {
	private SalPlan salplan;
	private Integer plaId;
	private Integer chcId;
	private String path;
	@Resource(name="BizService")
	private BizService bizservice;
	
	

	public SalPlan getSalplan() {
		return salplan;
	}

	public void setSalplan(SalPlan salplan) {
		this.salplan = salplan;
	}

	public Integer getPlaId() {
		return plaId;
	}

	public void setPlaId(Integer plaId) {
		this.plaId = plaId;
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

	public BizService getBizservice() {
		return bizservice;
	}

	public void setBizservice(BizService bizservice) {
		this.bizservice = bizservice;
	}

	//=======================================
	@Action(value="delById_SalPlan")
	public String delById() {
		ServletResponse response=ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		boolean b=bizservice.getSalplanbiz().delById(plaId);
		try {
			PrintWriter out=response.getWriter();
			if(b){
				out.print(1);
			}else{
				out.print(0);
			}
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@Action(value="findAll_SalPlan")
	public String findAll() {
		System.out.println(chcId+"====action======");
		HttpServletResponse rep=ServletActionContext.getResponse();
		rep.setCharacterEncoding("utf-8");
		try {
			PrintWriter out=rep.getWriter();	
			//获取每页记录的集合
			List<SalPlan> lisal=bizservice.getSalplanbiz().findAll(chcId);
			Map<String,Object> map=new HashMap<String, Object>();
			map.put("rows", lisal);
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
	@Action(value="findById_SalPlan",results={@Result(name="ok",location="${path}",type="redirect")})
	public String findById() {
		SalPlan oldsalPlan=bizservice.getSalplanbiz().findById(plaId);
		HttpSession session=ServletActionContext.getRequest().getSession();
		session.setAttribute("oldsalPlan", oldsalPlan);
		path="html/~sale/dev_plan.jsp";
		
		return "ok";
	}
	@Action(value="finddetail_SalPlan",results={@Result(name="ok",location="${path}",type="redirect")})
	public String finddetail() {		
		//System.out.println(">>>>>>>>>>>>");
		SalPlan oldsalPlan1=bizservice.getSalplanbiz().findById(plaId);
		HttpSession session=ServletActionContext.getRequest().getSession();
		session.setAttribute("oldsalPlan1", oldsalPlan1);
		path="html/~sale/dev_plan.jsp";
		return "ok";
	}
	@Action(value="save_SalPlan")
	public String save() {
		System.out.println(salplan.getPlaDate()+"******date");
		System.out.println(salplan.getPlaTodo()+"******todo");
		ServletResponse response=ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		boolean b=bizservice.getSalplanbiz().save(salplan);
		try {
			PrintWriter out=response.getWriter();
			if(b){
				out.print(1);
			}else{
				out.print(0);
			}
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Action(value="update_SalPlan")
	public String update() {
		ServletResponse response=ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		boolean b=bizservice.getSalplanbiz().update(salplan);
		try {
			PrintWriter out=response.getWriter();
			if(b){
				out.print(1);
			}else{
				out.print(0);
			}
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


}
