package com.biz;

import java.util.List;

import com.po.OrdersLine;

public interface IOrdersLineBiz {
public List<OrdersLine> findAll(Integer odrId);
public int findMaxRow();
/*public List<OrdersLine> findAll(Integer odrId,int page,int rows);
public int findMaxRow(Integer odrId);*/
}
