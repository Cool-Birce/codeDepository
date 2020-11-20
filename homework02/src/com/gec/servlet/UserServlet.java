package com.gec.servlet;

import com.gec.bean.PageBean;
import com.gec.bean.User;
import com.gec.service.UserService;
import com.gec.service.impl.UserServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Brice
 * @title: ${NAME}
 * @projectName homework02
 * @description: TODO
 * @date 2020/10/2619:39
 */
@WebServlet(urlPatterns = {"/save.action","/login.action","/update.action","/delete.action","/loginForm.action"})
public class UserServlet extends javax.servlet.http.HttpServlet {
    private UserService us = new UserServiceImpl();
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String uri = request.getRequestURI();
        uri= uri.substring(uri.lastIndexOf("/")+1);
        System.out.println(uri);
        if("save.action".equals(uri)){
        String userName = request.getParameter("userName");
        String pwd = request.getParameter("pwd");
        String url = request.getParameter("url");
        User user = new User(userName, pwd, url);
        boolean result = us.save(user);
        if (!result){
            response.getWriter().append("注册成功!");
        }else{
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        }else if("login.action".equals(uri)){

            String userName = request.getParameter("userName");
            String pwd = request.getParameter("pwd");
            User user = us.find(userName, pwd);
            if (user!=null){
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                response.sendRedirect("loginForm.action");
            }else{
                response.sendRedirect("login.jsp");
            }
        }else if("loginForm.action".equals(uri)){
            HttpSession session = request.getSession(true);
            User user = (User) session.getAttribute("user");
            int pageNow=1;
            PageBean<User> pagebean = us.page(pageNow);
            request.setAttribute("pagebean", pagebean);
            request.setAttribute("user", user);
            request.getRequestDispatcher("show.jsp").forward(request, response);
        }else if("delete.action".equals(uri)){
            int id = Integer.parseInt(request.getParameter("id"));
            boolean result = us.delete(id);
            if (result){
                response.sendRedirect("loginForm.action");
            }else{
                response.getWriter().append("删除失败");
            }

        }else if("update.action".equals(uri)){
            int id = Integer.parseInt(request.getParameter("id"));
            String userName = request.getParameter("userName");
            String pwd = request.getParameter("pwd");
            String email = request.getParameter("email");
            User user = new User(id, userName, pwd, email);
            boolean result = us.update(user);
            if (result){
                response.sendRedirect("loginForm.action");
            }else{
                response.getWriter().append("修改失败");
            }
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        this.doPost(request, response);
    }
}
