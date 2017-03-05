package com.medicine.mybatis.base.dao;

import java.util.List;

public interface BaseDao {
	public void add(String namespace, Object o);
	public void add(String namespace, String id, Object o);	
	public Object addAndReturn(String namespace, String id, Object o);
	public List list(String namespace);
	public List list(String namespace, String id);
	public List list(String namespace, String id, Object param);
	public Object get(String namespace, String id,Object o);
	public void  update(String namespace,String id,Object b);
	public void delete(String namespace,String id,Object b);
}
