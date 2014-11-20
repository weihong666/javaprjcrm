package com.biz;

import java.util.List;

import com.po.SysUser;

public interface ISysUserBiz {
	public boolean save(SysUser user);
	public boolean update(SysUser user);
	public boolean delById(Integer usrId);
	public SysUser findById(Integer usrId);
	public List<SysUser> findAll();
	public int findMaxRow();
	public List<SysUser> findAll(Integer usrId);
	public SysUser check(SysUser user);
	public int findMaxRow(String usrId,String usrName,String usrRoleName,Integer usrAlevel);
	public List<SysUser> findAll(String usrId,String usrName,String usrRoleName,Integer usrAlevel,int page,int rows);
}
