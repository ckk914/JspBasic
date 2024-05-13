package com.jsp.chap04;

import com.jsp.repository.DancerJdbcRepo;
import com.jsp.repository.DancerMemoryRepo;

//여기서 모든 객체 생성을 맡는다~!⭐️ 외주 개념
public class AppConfig {
    //메모리 디비가 필요한 상황
    public DancerMemoryRepo dancerMemoryRepo(){
        return DancerMemoryRepo.getInstance();
    }
    //실제 디비가 필요한 상황
    public DancerJdbcRepo dancerJdbcRepo(){
        return DancerJdbcRepo.getInstance();
    }

    public  AddNewDancerServlet addNewDancerServlet(){
        return new AddNewDancerServlet(dancerJdbcRepo());
    }

    public ShowDancerListServlet showDancerListServlet(){
        return new ShowDancerListServlet(dancerJdbcRepo());
    }
    public DancerRemoveServlet dancerRemoveServlet(){
        return new DancerRemoveServlet(dancerJdbcRepo());
    }
}
