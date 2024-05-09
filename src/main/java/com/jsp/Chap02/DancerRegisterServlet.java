package com.jsp.Chap02;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 만약에 클라이언트가 /chap02/dancer/register URL로
 * 요청을 보내면 댄서를 등록할 수 있는 양식 html을 응답해주세요
 */
//http://localhost:8181/chap02/dancer/register
// localhost = 127.0.0.1
@WebServlet("/chap02/dancer/register")
public class DancerRegisterServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");

        PrintWriter w = resp.getWriter();

        w.write("<!DOCTYPE html>\n");
        w.write("<html>\n");
        w.write("<head>\n");
        w.write("<style>\n");
        w.write("label { display: block; }\n");
        w.write("</style>\n");
        w.write("</head>\n");
        w.write("<body>\n");
        w.write("<form action=\"/chap02/dancer/process\" method=\"get\" id=\"reg-form\">");
        w.write("<label># 이름 : <input type=\"text\" name=\"name\"></label>");
        w.write("<label># 크루이름 : <input type=\"text\" name=\"crewName\"></label>");
        w.write("<label># 레벨 :<input type=\"radio\" name=\"danceLevel\" value=\"PROFESSIONAL\"> 프로 <input type=\"radio\" name=\"danceLevel\" value=\"AMATEUR\"> 아마추어 <input type=\"radio\" name=\"danceLevel\" value=\"BEGINNER\"> 초보자 </label>");
        w.write("<label># 장르 :<input type=\"checkbox\" name=\"genres\" value=\"HIPHOP\"> 힙합 <input type=\"checkbox\" name=\"genres\" value=\"STREET\"> 스트릿 <input type=\"checkbox\" name=\"genres\" value=\"KPOP\"> 케이팝 </label>");
        w.write("<label><button id=\"reg-btn\" type=\"submit\">등록</button></label>");
        w.write("</form>");
        w.write("</body>\n");
        w.write("</html>");
        //⭐️제출 버튼 누르면 form action으로 간다~!
        //form action get 으로 하면 다음과 같이 나온다~! ㄱ
        //http://localhost:8181/hello?name=111&crewName=222&danceLevel=AMATEUR&genres=STREET


    }
}
