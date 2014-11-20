package com.biz;

import java.util.List;

import com.po.Orders;

public interface IOrdersBiz {
	public boolean save(Orders orders);
	public boolean update(Orders orders);
	public boolean delById(Integer odrId);
	public Orders findById(Integer odrId);
	public List<Orders> findAll();
	public int findMaxRow();
	public List<Orders> findAll(Integer odrId);
	public boolean saveOrder(Orders orders) ;
}
