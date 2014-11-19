package com.biz;

import java.util.List;

import com.po.CstCustomer;

public interface ICstCustomerBiz {
public boolean save(CstCustomer customer);
public boolean update(CstCustomer customer);
public boolean delById(Integer cust_id);
public CstCustomer findById(Integer id);
public List<CstCustomer> findAll();
public int findMaxRow();
public List<CstCustomer> findAll(int page,int rows);
public List<CstCustomer> findAll(String custNo,String custName,String custRegion,String custManagerName,String custLevelLabel,int page,int rows);
public int findMaxRow(String custNo,String custName,String custRegion,String custManagerName,String custLevelLabel);
}
