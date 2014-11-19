package com.action;

import com.service.*;
import com.alibaba.fastjson.JSONObject;
import com.po.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@Controller
@Namespace("/")
public class BasDictAction implements IBasDictAction {
	private BasDict basDict;
	private Integer bid;
	private String dtype;
	private String ditem;
	private String dvalue;
	
	@Resource(name="BizService")
	private BizService bizs;
	
	private String path;
	
	private int page;
	private int rows;
	
    
	public String getDtype() {
		return dtype;
	}

	public void setDtype(String dtype) {
		this.dtype = dtype;
	}

	public String getDitem() {
		return ditem;
	}

	public void setDitem(String ditem) {
		this.ditem = ditem;
	}

	public String getDvalue() {
		return dvalue;
	}

	public void setDvalue(String dvalue) {
		this.dvalue = dvalue;
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

	public BasDict getBasDict() {
		return basDict;
	}

	public void setBasDict(BasDict basDict) {
		this.basDict = basDict;
	}

	public Integer getBid() {
		return bid;
	}

	public void setBid(Integer bid) {
		this.bid = bid;
	}


	@Action(value="save_BasDict",results={
			@Result(name="ok",location="${path}",type="redirect")
	})
	public String save() {
		/*************************************
		 * 当是否可编辑没有勾选直接设置该值为0  否 为不可编辑
		 * JSP页面为该字段设置为value为1，即为可编辑 
		 * 因为复选框checkbox 不选中的时候不返回任何参数或值,即null
		 ***********下面开始处理*****************/
		Integer baied=basDict.getDictIsEditable();
	    if(baied==null){
	    	basDict.setDictIsEditable(0);
	    }
	    /**************************************/
		boolean bl=bizs.getBasDictBiz().save(basDict);
	     
		if(bl){
			System.out.println("增加数据库记录成功");
			path="html/~basd/dict.jsp";
			return "ok";
		}else{
			System.out.println("增加数据库记录失败");
			path="error.jsp";
			return "fail";
		}
	}

	@Action(value="delById_BasDict")
	public String delById() {
		PrintWriter out=getOut();
		boolean bl =bizs.getBasDictBiz().delById(bid);
		if(bl){
			System.out.println("删除数据库记录成功");
			out.print(1);//删除成功返回1
		}else{
			System.out.println("删除数据库记录失败");
			out.print(0);//失败成功输出0
		}
		out.flush();
		out.close();
		return null;
	}

	@Action(value="findById_BasDict",results={
			@Result(name="ok",location="${path}",type="redirect")
	})
	public String findById() {
		
		HttpSession session = ServletActionContext.getRequest().getSession();

		BasDict oldbasdict=bizs.getBasDictBiz().findById(bid);
	    session.setAttribute("oldbasdict", oldbasdict);
	    path="html/~basd/dict_edit.jsp";
		return "ok";
	}
	
	@Action(value="findAll_BasDict")
	public String findAll() {
		page=page==0?1:page;
		rows=rows==0?10:rows;
		
		//获取总行数
		int total=bizs.getBasDictBiz().findMaxRow(dtype, ditem, dvalue);
				
		//获取每页记录的集合
		List<BasDict> lsbd= bizs.getBasDictBiz().findAll(dtype, ditem, dvalue, page, rows);
		
		Map<String,Object> map=new HashMap<String, Object>();
		
		map.put("total", total);
		map.put("rows", lsbd);
		
		String lsbdjsonstr=JSONObject.toJSONString(map);
		System.out.println("lsbdjsonstr------>"+lsbdjsonstr);
		PrintWriter out=getOut();
		out.print(lsbdjsonstr);
		out.flush();
		out.close();
		return null;
	}
	

	@Action(value="update_BasDict",results={
			@Result(name="ok",location="${path}",type="redirect")
	})
	public String update() {
        HttpSession session=ServletActionContext.getRequest().getSession();
		
		HttpServletResponse rep=ServletActionContext.getResponse();
		rep.setCharacterEncoding("gbk");

		try {
			PrintWriter out=rep.getWriter();
			
			/*************************************
			 * 当是否可编辑没有勾选直接设置该值为0  否 为不可编辑
			 * JSP页面为该字段设置为value为1，即为可编辑 
			 * 因为复选框checkbox 不选中的时候不返回任何参数或值,即null
			 ***********下面开始处理*****************/
			Integer baied=basDict.getDictIsEditable();
		    if(baied==null){
		    	basDict.setDictIsEditable(0);
		    }
		    /**************************************/
			boolean bl=bizs.getBasDictBiz().update(basDict);
			
			if(bl){
				BasDict obasDict=bizs.getBasDictBiz().findById(basDict.getDictId());
				session.setAttribute("obasDict", obasDict);
				
				//更新记录后重新拉取数据库全部数据放进session中,更新列表界面里的数据
				List<BasDict> nlsbd=bizs.getBasDictBiz().findAll(dtype, ditem, dvalue, page, rows);
				session.setAttribute("lsbd", nlsbd);
				System.out.println("修改数据库记录成功！");
				path="html/~basd/dict.jsp";
                return "ok";
			}
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public String doinit() {
		// TODO Auto-generated method stub
		return null;
	}

	public PrintWriter getOut(){
		HttpServletResponse rep=ServletActionContext.getResponse();
		rep.setCharacterEncoding("utf-8");
		PrintWriter out=null;
		try {
			out = rep.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return out;
	}

}
