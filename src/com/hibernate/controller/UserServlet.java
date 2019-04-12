package com.hibernate.controller;

import com.hibernate.dao.UserDao;
import com.hibernate.entity.User;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.List;

/**
 * @author : 张晋飞
 * date : 2019/4/12
 */
@WebServlet("/user")
public class UserServlet extends javax.servlet.http.HttpServlet {
    protected void service(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        //页码
        int pageIndex =1; // 初始页码
        // 获取参数
        String index = request.getParameter("pageIndex");
        if(index!=null){
            pageIndex=Integer.parseInt(index);
        }
        // 每页条数
        int pageCount = 5;
        UserDao dao  =  new UserDao();
        int pages = dao.pages(pageCount);
        List<User> users = dao.queryPageUser(pageIndex, pageCount);

        request.setAttribute("pages",pages);
        request.setAttribute("users",users);
        request.getRequestDispatcher("/user.jsp").forward(request,response);
    }
}
