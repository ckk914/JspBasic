package com.jsp.chap04;

import com.jsp.entity.Dancer;
import com.jsp.repository.DancerJdbcRepo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/chap04/remove")
public class DancerRemoveServlet extends HttpServlet {

    private final DancerJdbcRepo repo = DancerJdbcRepo.getInstance();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("삭제 요청 서버에 들어옴~!");

        //삭제를 하려면 데이터베이스에서 해당 데이터를 지워야함
        // 지우려면 대체 뭘 지워야하는지 클라이언트가 알려줘야 함
        //클라이언트에서 보낸 url에 붙은 id 값 읽어오기
        String id = req.getParameter("id");
        System.out.println("id = " + id);

        //db에 삭제 명령
        repo.delete(id);


    }
}
