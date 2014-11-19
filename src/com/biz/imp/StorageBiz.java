package com.biz.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.biz.IStorageBiz;
import com.po.Storage;
import com.service.DaoService;

@Service("StorageBiz")
@Transactional
public class StorageBiz implements IStorageBiz {

	@Resource(name="DaoService")
	private DaoService daos;

	public DaoService getDaos() {
		return daos;
	}

	public void setDaos(DaoService daos) {
		this.daos = daos;
	}
	
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<Storage> findAll(String pname, String stkWarehouse, int page,
			int rows) {
		// TODO Auto-generated method stub
		return daos.getStorageDAO().findAll(pname, stkWarehouse, page, rows);
	}

	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public int findMaxRow(String pname, String stkWarehouse) {
		// TODO Auto-generated method stub
		return daos.getStorageDAO().findMaxRow(pname, stkWarehouse);
	}

}
