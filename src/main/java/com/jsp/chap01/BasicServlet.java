package com.jsp.chap01;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

//역할 : http 통신의 요청과 응답 데이터를 손쉽게 처리할 수 있게
//       도와주는 클래스

//잘만들어진 것을 통해 상속받아 사용
//WAS(톰캣)에게 이 서블릿을 언제 호출할지 URL 을 매핑
//http://127.0.0.1:8181/login 로 접속
@WebServlet(urlPatterns = "/login")
public class BasicServlet extends HttpServlet {
    //⭐️톰캣에서 자체적으로 객체를 만든다~!
    //⭐️직접 호출하지 않아도 톰캣이 실행한다~!
    // 생성자 (호출되는지 확인 목적)
    public  BasicServlet(){
        //접속하면 메시지 팝업
        System.out.println("\n\n\nBasic Servlet 객체가 생성됨~!\n\n\n");
    }

    //서버는 클라이언트에서 요청이 들어오면
    //http 메세지를 분석하여 요청 내용을 파악해야함
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //요청 메시지 정보를 쉽게 읽도록 많은 메서드를 제공

        // 요청 방식 (조회, 생성, 수정 , 삭제)
        String method = req.getMethod();
        //요청 url
        String requestURI = req.getRequestURI();

        //요청 파라미터 정보
        String queryString = req.getQueryString();
        //요청 헤더 정보 읽기
        //request header  개발자도구 네트워크에 있는 속성들 다 가져올 수 있다⭐️
        String header = req.getHeader("cache-control");
        //http://127.0.0.1:8181/login?name=kim&age=30&grade=A

        //method = GET
        //requestURI = /login
        //queryString = name=kim&age+30&grade=A

        System.out.println("method = " + method);
        System.out.println("requestURI = " + requestURI);
        System.out.println("queryString = " + queryString);
        System.out.println("header = " + header);

        //쿼리 스트링 (요청 파라미터) 하나씩 읽기
        String name = req.getParameter("name");
        String age = req.getParameter("age");
        String grade = req.getParameter("grade");

        System.out.println("name = " + name); //kim
        System.out.println("age = " + age);   // 30
        System.out.println("grade = " + grade); //A

        //서버의 응답 처리
        // 요리를 해야한다
        // ㄴ 비지니스 로직 : 나이를 기반으로 출생년도를 계산
        // 학점이 F면 과락 처리, 아니면 통과 처리
        int birthYear = 0;
        try {
            birthYear= LocalDate.now().getYear() - Integer.parseInt(age) + 1;
        } catch (NumberFormatException e) {
            resp.setStatus(400);
            return;
        }
        String message;

        switch (grade.toUpperCase()) {
            case "F":
                message = "재수강 하셔야 합니다.";
                break;
            default:
                message = "시험에 통과하셨습니다.";
        }


        //응답 메시지 생성 (http response message)
        resp.setStatus(200);
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");

        //응답 바디에 넣을 html 생성
        PrintWriter w = resp.getWriter();  //html 생성할 펜 호출
        w.write("<!DOCTYPE html>\n");
        w.write("<html>\n");
        w.write("<head>\n");
        w.write("</head>\n");
        w.write("<body>\n");
        w.write("   \t<h1>\n");
        w.write(String.format("%s님은 %d년생입니다.", name, birthYear));
        w.write("   </h1>\n");
        w.write("<h2>"+message+"</h2>");
        w.write("</body>\n");
        w.write("</html>");

    }
}
