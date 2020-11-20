package com.gec.Servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gec.pojo.User;
import com.gec.util.SessionTool;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Brice
 * @title: ${NAME}
 * @projectName mybatisdemo02
 * @description: TODO
 * @date 2020/10/309:59
 */
@WebServlet(urlPatterns = {"/loginUser","/addUser","/findAll"})
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        uri=uri.substring(uri.lastIndexOf("/")+1);
        if("loginUser".equals(uri)){
            String name = request.getParameter("name");
            String pwd = request.getParameter("pwd");
            User user = new User(0, name, pwd, null);
            SqlSession session = SessionTool.foundSession(true);
            User user1 = session.selectOne("UserMapper.findByName", user);
            if(user1!=null){
                if(user1.getUserPassword().equals(pwd)){
                    HttpSession session1 = request.getSession();
                    session1.setAttribute("user", user1);
                    response.sendRedirect("show.jsp");
                }else{
                    request.setAttribute("msg", "密码错误!");
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                }
            }else{
                request.setAttribute("msg", "没有该用户!");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        }else if("addUser".equals(uri)){
            String name = request.getParameter("name");
            String pwd = request.getParameter("pwd");
            String url = request.getParameter("url");
            User user = new User(0, name, pwd, url);
            SqlSession session = SessionTool.foundSession(true);
            User user1 = session.selectOne("UserMapper.findByName", user);
            if(user1==null){
                int iter = session.insert("UserMapper.addUser", user);
                if(iter>0){
                    response.sendRedirect("login.jsp");
                }else{
                    request.setAttribute("msg", "添加失败!");
                    request.getRequestDispatcher("register.jsp").forward(request, response);
                }
            }else{
                request.setAttribute("msg", "添加失败!用户已存在");
                request.getRequestDispatcher("register.jsp").forward(request, response);
            }

        }else if("findAll".equals(uri)){
            String limit = request.getParameter("limit");
            String page = request.getParameter("page");
            SqlSession session = SessionTool.foundSession(true);
            Map map = new HashMap();
            map.put("page", Integer.parseInt(page));
            map.put("limit", Integer.parseInt(limit));
            List<User> list = session.selectList("UserMapper.page", map);
            int count = session.selectOne("count");
            ObjectMapper om = new ObjectMapper();
            map = new HashMap<>();
            map.put("code",0);
            map.put("msg","");
            map.put("count",count);
            map.put("data",list);
            String json = om.writeValueAsString(map);
            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");
            response.getWriter().write(json);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
