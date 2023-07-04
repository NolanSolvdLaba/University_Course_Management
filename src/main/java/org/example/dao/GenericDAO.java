package org.example.dao;

import org.apache.ibatis.session.SqlSession;
import org.example.util.MyBatisUtil;

import java.util.List;

public abstract class GenericDAO<T> {
    protected SqlSession sqlSession;

    public GenericDAO() {
        sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
    }

    public void create(T entity) {
        sqlSession.insert(getCreateQuery(), entity);
        sqlSession.commit();
    }

    public T getById(int id) {
        return sqlSession.selectOne(getGetByIdQuery(), id);
    }

    public void update(T entity) {
        sqlSession.update(getUpdateQuery(), entity);
        sqlSession.commit();
    }

    public void delete(int id) {
        sqlSession.delete(getDeleteQuery(), id);
        sqlSession.commit();
    }

    public List<T> getAll() {
        return sqlSession.selectList(getGetAllQuery());
    }

    // Abstract methods to be implemented by subclasses

    protected abstract String getCreateQuery();

    protected abstract String getGetByIdQuery();

    protected abstract String getUpdateQuery();

    protected abstract String getDeleteQuery();

    protected abstract String getGetAllQuery();
}
