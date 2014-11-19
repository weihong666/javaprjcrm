package com.biz;

import java.util.List;

import com.po.*;

public interface IStorageBiz {
	 public List<Storage> findAll(String pname,String stkWarehouse,int page,int rows);
	 public int findMaxRow(String pname,String stkWarehouse);
}
