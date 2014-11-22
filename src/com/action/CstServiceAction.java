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
}
