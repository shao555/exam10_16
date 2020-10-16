package com.cs.test;

import com.cs.entity.Working;
import com.cs.service.impl.WorkingServiceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Test {

    public static void main(String[] args) throws Exception {


        findAll();
//        findById();

//        add();

    }

    private static void add() throws Exception {
        WorkingServiceImpl wsi = new WorkingServiceImpl();
        Working working = new Working();
        working.setTitle("做java项目");
        working.setContent("做出一个工作笔记系统");
        working.setType(1);
        Date d = new Date(110,9,16);
        working.setDate(d);
        int i = wsi.addWorking(working);
        if (i > 0) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");
        }
    }

    private static void findById() throws Exception {
        WorkingServiceImpl wsi = new WorkingServiceImpl();
        Working w = wsi.findInfoById(2);
        System.out.println(w.getTitle() + " " + w.getType() + " " + w.getDate());
    }

    private static void findAll() throws Exception {
        WorkingServiceImpl wsi = new WorkingServiceImpl();
        List<Working> list = wsi.findWorkInfoAll();
//        System.out.println(list);
//        for (Working w : list) {
//            System.out.println(w.getTitle() + " " + w.getType() + " " + w.getDate());
//        }
    }
}


