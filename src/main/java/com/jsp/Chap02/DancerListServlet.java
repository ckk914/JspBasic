package com.jsp.Chap02;

import com.jsp.entity.Dancer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet("/chap02/dancer/show-list")
public class DancerListServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 결과 출력
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        PrintWriter w = resp.getWriter();

        w.write("<!DOCTYPE html>\n");
        w.write("<html>\n");
        w.write("<head>\n");
        w.write("</head>\n");
        w.write("<body>\n");

        w.write("<ul>");

        List<Dancer> dancerList = DancerSaveProcessServlet.dancerList;

        for (Dancer foundDancer : dancerList) {
            w.write(String.format("<li># 이름 : %s, 크루명: %s, 수준: %s, 공연당페이: %d원, 장르: %s</li>\n"
                    , foundDancer.getName(), foundDancer.getCrewName(),
                    foundDancer.getDanceLevel().getLevelDescription(),
                    foundDancer.getDanceLevel().getPayPerEvent(),
                    foundDancer.getGenres()));
        }

        w.write("</ul>");

        w.write("<a href=\"/chap02/dancer/register\">새로운 등록하기</a>");

        w.write("</body>\n");
        w.write("</html>");


    }
}
