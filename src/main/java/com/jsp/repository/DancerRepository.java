package com.jsp.repository;

import com.jsp.entity.Dancer;

import java.util.List;

//추상화된 역할: Dancer 데이터를 CRUD 해라 ~!
//구체적으로 어떻게?? 어디에서? DB에서 ? 세이브 파일에서 ?
// 모르겠고 아무튼 CRUD해
public interface DancerRepository {

    boolean save(Dancer dancer);

    List<Dancer> retrieve();

    void delete(String id);
}
