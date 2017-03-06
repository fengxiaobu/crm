package com.crm.dao;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.List;

/**
 * luopa 在 2017/3/4 创建.
 */
public class BaseDao<T> extends HibernateDaoSupport {
    private Class pClass;

    public BaseDao() {
        Class aClass = this.getClass();
        TypeVariable[] typeParameters = aClass.getTypeParameters();
        Type type = aClass.getGenericSuperclass();
        ParameterizedType parameterizedType = (ParameterizedType) type;

        Type[] types = parameterizedType.getActualTypeArguments();
        Class tCalzz = (Class) types[0];
        this.pClass=tCalzz;
    }

    public void save(T t) {
        this.getHibernateTemplate().save(t);
    }

    public void delete(T t) {
        this.getHibernateTemplate().delete(t);
    }

    public void update(T t) {
        this.getHibernateTemplate().update(t);
    }

    public T findByOne(Integer id){
       return (T) this.getHibernateTemplate().get(pClass,id);
    }

    public List<T> findAll(){
        return (List<T>) this.getHibernateTemplate().find("from "+pClass);
    }
}
