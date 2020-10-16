package com.cs.service.impl;

import com.cs.dao.impl.WorkingDaoImpl;
import com.cs.entity.Working;
import com.cs.service.WorkingService;

import java.util.List;

public class WorkingServiceImpl implements WorkingService {

    WorkingDaoImpl wdi = new WorkingDaoImpl();


    @Override
    public List<Working> findWorkInfoAll() throws Exception {
        return wdi.findWorkInfoAll();
//        return null;
    }

    @Override
    public Working findInfoById(int id) throws Exception {
        return wdi.findInfoById(id);
//        return null;
    }

    @Override
    public int addWorking(Working working) throws Exception {
        return wdi.addWorking(working);
//        return 0;
    }
}
