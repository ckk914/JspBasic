package com.jsp.repository;

import com.jsp.entity.Dancer;

import javax.servlet.http.HttpServlet;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// 역할 : 메모리 데이터 베이스에 댄서들을 CRUD
// MODEL 역할
public class DancerMemoryRepo implements DancerRepository{
    //싱글톤 구현하기 위한 생성
    private static DancerMemoryRepo repo = new DancerMemoryRepo();
    //싱글톤 구현 (객체 생성을 하나로 막기 위함)
    private DancerMemoryRepo(){}
    //싱글 객체를 리턴하는 매서드
    public static DancerMemoryRepo getInstance(){
        return repo;
    }
    //<-----------------------------------------------------------
    //데이터베이스 역할을 할 자료구조
    private List<Dancer> dancerList = new ArrayList<>();

    //댄서를 데이터베이스에 저장하는 기능
    public boolean save(Dancer dancer){
        if(dancer ==null) return false;
        dancerList.add(dancer);
        System.out.println(dancerList);
        return true;
    }

    //댄서 리스트를 반환하는 기능
    public List<Dancer> retrieve(){
        return dancerList;
    }


    public void delete(String id) {
        List<Dancer> dancers = dancerList.stream()
                .filter(dancer -> dancer.getId() == Integer.parseInt(id))
                .collect(Collectors.toList());

        if (!dancers.isEmpty()) {
            dancerList.remove(dancers.get(0));
        }
    }

}
