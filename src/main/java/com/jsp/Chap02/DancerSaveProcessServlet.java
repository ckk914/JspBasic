package com.jsp.Chap02;

import com.jsp.entity.Dancer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet("/chap02/dancer/process")
public class DancerSaveProcessServlet extends HttpServlet {
   //댄서들을 모아놓을 리스트
    public static List<Dancer> dancerList = new ArrayList<>();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("댄서 정보 등록중..."); //콘솔에 찍힘
        //http://localhost:8181/chap02/dancer/process?name=%EB%A7%90&crewName=1234&danceLevel=AMATEUR&genres=STREET

        //form에서 전송한 데이터 한글 인코딩
        req.setCharacterEncoding("utf-8");
        //주소창 데이터들 읽자⭐️
        String name = req.getParameter("name");
        String crewName = req.getParameter("crewName");
        String danceLevel = req.getParameter("danceLevel");
        //여러개 되도록 받음
        String[] genres = req.getParameterValues("genres");

        System.out.println("name = " + name);
        System.out.println("crewName = " + crewName);
        System.out.println("danceLevel = " + danceLevel);
        System.out.println("genres = " + Arrays.toString(genres));

        //댄서 객체 생성
        Dancer dancer = new Dancer();
        dancer.setName(name);
        dancer.setCrewName(crewName);
        dancer.setDanceLevel(Dancer.DanceLevel.valueOf(danceLevel));

        List<Dancer.Genre> genreList = new ArrayList<>();
        for(String genre:genres){
            genreList.add(Dancer.Genre.valueOf(genre));
        }
        dancer.setGenres(genreList);
        System.out.println("dancer = " + dancer);

        dancerList.add(dancer);

        //응답 메시지 생성
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");
        PrintWriter w = resp.getWriter();


        w.write("<!DOCTYPE html>\n");
        w.write("<html>\n");
        w.write("<head>\n");
        w.write("</head>\n");
        w.write("<body>\n");

        w.write("<h1>" + dancer.getName() + "님이 등록되었습니다. </h1>");
        w.write("<a href=\"/chap02/dancer/show-list\">댄서 정보 모아보기</a>");

        w.write("</body>\n");
        w.write("</html>");


    }

}
