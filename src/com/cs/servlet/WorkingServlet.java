package com.cs.servlet;

import com.cs.entity.Working;
import com.cs.service.impl.WorkingServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "WorkingServlet", urlPatterns = "/WorkingServlet")
public class WorkingServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        WorkingServiceImpl wsi = new WorkingServiceImpl();
        String comm = request.getParameter("comm");
        if ("list".equals(comm)) {
            try {
                List<Working> list = wsi.findWorkInfoAll();
//                System.out.println("comm " + comm);
//                System.out.println("list " + list);
                if (list != null) {
                    request.setAttribute("list", list);
                    request.getRequestDispatcher("list.jsp").forward(request, response);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if ("se".equals(comm)) {
            String id = request.getParameter("id");
            int ids = Integer.parseInt(id);
            try {
                Working w = wsi.findInfoById(ids);
                if (w != null) {
                    request.setAttribute("w", w);
                    request.getRequestDispatcher("show.jsp").forward(request, response);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if ("提交".equals(comm)) {

            String title = request.getParameter("title");
            String content = request.getParameter("content");
            String type = request.getParameter("type");
            int types = Integer.parseInt(type);
//            Date date = new Date(System.currentTimeMillis());
            Working working = new Working();
            working.setTitle(title);
            working.setContent(content);
            working.setType(types);
            working.setDate(working.getDate());
            try {
                int i = wsi.addWorking(working);
                System.out.println(i);
                if (i > 0) {
                    response.sendRedirect("WorkingServlet?comm=list");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
