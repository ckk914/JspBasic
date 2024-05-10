package com.jsp.chap04;

import com.jsp.entity.Dancer;
import com.jsp.repository.DancerJdbcRepo;
import com.jsp.repository.DancerMemoryRepo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//역할 : 댄서 목록 조회 요청을 받아서 데이터베이스에 있는 댄서 정보를 가져온 후
//       적당한 html을 찾아서 forwarding
@WebServlet("/chap04/show-list")
public class ShowDancerListServlet extends HttpServlet {
    //싱글톤은 new로 생성 못함~!
    private DancerJdbcRepo repo =DancerJdbcRepo.getInstance();
    //service 없으면 405 에러
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //내용 비었으면 하얀 화면 나옴

        //데이터베이스에 접근하여 댄서 목록을 가져옴~!⭐️
        List<Dancer> dancerList = repo.retrieve();
        System.out.println("dancerList =👻 " + dancerList);

        //jsp파일에게 보낼 데이터 수송 객체에 담기⭐️
        // forward할때 이것도 같이 넘어가서 jsp 에서 사용할 수 있따~!⭐️
        req.setAttribute("dancers",dancerList);
        //JSP 파일 열기
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/chap04/dancer-list.jsp");
        rd.forward(req,resp);
    }
}
