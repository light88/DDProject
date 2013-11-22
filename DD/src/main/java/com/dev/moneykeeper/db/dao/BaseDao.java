package com.dev.moneykeeper.db.dao;

import java.util.List;

/**
 * DD
 * Created by light on 11/16/13.
 */
public interface BaseDao<T> {

    long add(T t);

    T get(long id);

    List<T> getAll();

    long update(T t);

    boolean remove(long id);

    long count();

}