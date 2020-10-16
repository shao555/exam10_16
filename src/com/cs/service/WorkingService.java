package com.cs.service;

import com.cs.entity.Working;

import java.util.List;

public interface WorkingService {
    //查询方法
    public List<Working> findWorkInfoAll() throws Exception;

    //根据id查询方法
    public Working findInfoById(int id) throws Exception;

    //添加关键词方法
    public int addWorking(Working working) throws Exception;

}
