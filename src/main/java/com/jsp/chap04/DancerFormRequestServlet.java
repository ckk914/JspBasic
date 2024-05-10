package com.jsp.chap04;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//http://localhost:8181/chap04/dancer/form
//역할 : 댄서 등록 화면을 요청하면 해당 html 파일을 열기만 해주는 역할
@WebServlet("/chap04/dancer/form")
public class DancerFormRequestServlet extends HttpServlet {
    //service 오버라이딩
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //적당한 view에게 화면 처리를 위임⭐️
        //forwarding : 화면 파일을 찾아서 열어주는 개념
        //경로 기입
        //WEB-INF로 jsp 넣으면 경로가 화면에 표시 안됨
        // 이렇게 해줘야 외부 공격을 막을 수 있다. ⭐️
        // 보여줄 jsp를 select 한다~!
        // 방식 : client -> was(servlet) ->jsp (view) -> client
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/chap04/register.jsp");

        rd.forward(req,resp);
    }
}
