package com.biz;

import java.util.List;

import com.po.*;

public interface IProductBiz {
	 public List<Product> findAll(String pname,String ptype,String pbatch,int page,int rows);
	 public int findMaxRow(String pname,String ptype,String pbatch);
}
