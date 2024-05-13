package com.jsp.chap04;

import com.jsp.entity.Dancer;
import com.jsp.repository.DancerJdbcRepo;
import com.jsp.repository.DancerMemoryRepo;
import com.jsp.repository.DancerRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//http://localhost:8181/chap04/new-dancer?name=%ED%8C%8C%EC%9D%B8%EC%95%A0%ED%94%8C&crewName=%EB%8F%99%EB%82%A8%EC%95%84&danceLevel=PROFESSIONAL&genres=HIPHOP&genres=STREET
//역할: 새로운 댄서 정보를 데이터 베이스에 등록하기 위해
// 댄서 정보들을 가져와서 처리하는 역할 (파싱)
@WebServlet("/chap04/new-dancer")
public class AddNewDancerServlet extends HttpServlet {

    public AddNewDancerServlet(DancerRepository repo) {
        this.repo = repo;
    }

    //    private DancerJdbcRepo repo = DancerJdbcRepo.getInstance();
//  private DancerRepository repo = DancerJdbcRepo.getInstance();
  private DancerRepository repo;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //요청 파라미터를 읽어서 댄서 정보 가져오기
        req.setCharacterEncoding("utf-8");

        String name = req.getParameter("name");
        String crewName = req.getParameter("crewName");
        String danceLevel = req.getParameter("danceLevel");
        String[] genres = req.getParameterValues("genres");

//        System.out.println("name = " + name);
//        System.out.println("crewName = " + crewName);
//        System.out.println("danceLevel = " + danceLevel);
//        System.out.println("genres = " + Arrays.toString(genres));

        // 댄서 객체 생성
        Dancer dancer = new Dancer();

        dancer.setName(name);
        dancer.setCrewName(crewName);
        dancer.setDanceLevel(Dancer.DanceLevel.valueOf(danceLevel));

        List<Dancer.Genre> genreList = new ArrayList<>();
        for (String genre : genres) {
            genreList.add(Dancer.Genre.valueOf(genre));
        }
        dancer.setGenres(genreList);

        System.out.println("dancer = " + dancer);

        //생성된 댄서 객체를 데이터 베이스에 저장
        //데이터베이스 처리에 특화된 객체에게 위임⭐️
        repo.save(dancer);

        //jsp 에게 전달할 동적 데이터를 어떻게 전달할 것인가?
        //수송객체 (page, request, session, application)
        //request : 한번의 요청과 응답이 끝날동안만 보관
        //session : 브라우저가 꺼질때까지 or 세션시간이 만료될때까지 보관
//        req.setAttribute("dancerData",dancer);
//        req.setAttribute("name",name);
//        req.setAttribute("crew",crewName);
//        req.setAttribute("level",danceLevel);
        req.setAttribute("d",dancer);
        //적당한 html 응답(jsp 에게 맡김)
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/chap04/result.jsp");
        rd.forward(req,resp);

    }
}
