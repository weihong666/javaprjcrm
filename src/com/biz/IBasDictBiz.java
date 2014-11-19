package com.biz;
import com.po.*;
import java.util.*;

public interface IBasDictBiz {
      public boolean save(BasDict bdt);
      public boolean update(BasDict bdt);
      public boolean delById(Integer id);
      public BasDict findById(Integer id);
      public List<BasDict> findAll(String dtype,String ditem,String dvalue,int page,int rows);
  	  public int findMaxRow(String dtype,String ditem,String dvalue);
}
