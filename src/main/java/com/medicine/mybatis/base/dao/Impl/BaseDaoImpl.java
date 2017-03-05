package com.medicine.mybatis.base.dao.Impl;


import com.medicine.mybatis.base.dao.BaseDao;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;


public class BaseDaoImpl extends SqlSessionDaoSupport implements BaseDao {
	/**
	 * 把beans.xml中配置好的session工厂注入进来
	 */
	@Autowired
	@Qualifier(value = "sqlSessionFactory") // 可以省略
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	public void add(String namespace, Object o) {
		SqlSession session = getSqlSession();
		session.insert(namespace + ".add", o);

	}

	public void add(String namespace, String id, Object o) {
		SqlSession session = getSqlSession();
		session.insert(namespace + "." + id, o);
	}
	
	public Object addAndReturn(String namespace, String id, Object o) {
		SqlSession session = getSqlSession();
		return session.insert(namespace + "." + id, o);
	}

	public List list(String namespace) {
		SqlSession session = getSqlSession();
		List list = session.selectList(namespace + ".list");
		return list;
	}

	public List list(String namespace, String id) {
		SqlSession session = getSqlSession();
		List list = session.selectList(namespace + "." + id);
		return list;
	}

	public List list(String namespace, String id, Object param) {
		SqlSession session = getSqlSession();
		List list = session.selectList(namespace + "." + id, param);
		return list;
	}

	public Object get(String namespace, String id, Object b) {
		SqlSession session = getSqlSession();
		Object o = session.selectOne(namespace + "." + id, b);
		return o;
	}

	public void update(String namespace, String id, Object b) {
		SqlSession session = getSqlSession();
		session.update(namespace + "." + id, b);
	}

	public void delete(String namespace, String id, Object b) {
		SqlSession session = getSqlSession();

		session.delete(namespace + "." + id, b);
	}
}
