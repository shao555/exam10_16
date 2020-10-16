package com.cs.dao.impl;

import com.cs.basedao.BaseDao;
import com.cs.dao.WorkingDao;
import com.cs.entity.Working;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class WorkingDaoImpl extends BaseDao implements WorkingDao {


    //查询所有方法

    @Override
    public List<Working> findWorkInfoAll() throws Exception {
        List<Working> list = new ArrayList<>();

        String sql = "select * from Working order by Date";
        Object[] obj = null;
        ResultSet rs = execQuery(sql);
        while (rs.next()) {
            Working working = new Working();
            working.setId(rs.getInt(1));
            working.setTitle(rs.getString(2));
            working.setContent(rs.getString(3));
            working.setDate(rs.getDate(4));
            working.setType(rs.getInt(5));
            list.add(working);
        }
        getClose();
        return list;
//        return null;
    }

    //根据id查询方法
    @Override
    public Working findInfoById(int id) throws Exception {
        Working working = new Working();
        String sql = "select * from Working where Id = ?";
        Object[] obj = {id};
        ResultSet rs = execQuery(sql, obj);
        while (rs.next()) {
            working.setId(rs.getInt(1));
            working.setTitle(rs.getString(2));
            working.setContent(rs.getString(3));
            working.setDate(rs.getDate(4));
            working.setType(rs.getInt(5));
        }
        getClose();
        return working;
//        return null;
    }

    //添加关键词方法
    @Override
    public int addWorking(Working working) throws Exception {
        int index = -1;
        String sql = "INSERT INTO Working(Title,Content,`Type`,`Date`)VALUE(?,?,?,NOW())";
        Object[] obj = {working.getTitle(),working.getContent(),working.getType()};
        index = execUpdate(sql, obj);
        getClose();
        return index;
//        return 0;
    }

}
