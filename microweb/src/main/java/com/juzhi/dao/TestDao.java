package com.juzhi.dao;

import com.juzhi.entity.Hello;

import java.util.List;

/**
 * Created by xjwan on 5/10/14.
 */
public interface TestDao {
    public void saveHello(Hello hello);

    List<Hello> findHelloById(int id);
}
