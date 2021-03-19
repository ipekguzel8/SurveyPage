package com.uniyaz.Core.Service;

import com.uniyaz.Core.Dao.BaseDao;
import com.uniyaz.Core.Domain.BaseEntity;

import java.util.List;

/**
 * Created by ipekg on 2021
 */
public class BaseService <E extends BaseEntity, D extends BaseDao>{
    D dao;

    public BaseService(Class<D> dao) {
        try {
            Class<?> aClass = Class.forName(dao.getName());
            this.dao = (D) aClass.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    public E save(E entity) {
        return (E) dao.save(entity);
    }

    public List<E> findAll() {
        return dao.findAll();
    }

    public void delete(E entity) {
        dao.delete(entity);
    }

    public E findById(Long id) {
        return (E) dao.findById(id);
    }

    public D getDao() {
        return dao;
    }
}
