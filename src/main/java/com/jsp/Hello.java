package com.jsp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
//127.0.0.1/hello 를 웹페이지에 켜야 나타남
//⭐️▽ 하단에 있는게 /hello 를 가능케하는 것
@WebServlet("/hello")
public class Hello extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        System.out.println("Hello!! my web");

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        PrintWriter w = resp.getWriter();

        w.write("<!DOCTYPE html>\n");
        w.write("<html>\n");
        w.write("<head>\n");
        w.write("</head>\n");
        w.write("<body>\n");
        w.write("   \t<h1>안녕하십니까??  <button>버튼</button>");
        w.write("   </h1>");
        w.write("</body>\n");
        w.write("</html>");
    }




}
