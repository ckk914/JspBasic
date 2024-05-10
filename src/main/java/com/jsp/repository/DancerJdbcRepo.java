package com.jsp.repository;

import com.jsp.chap05.Person;
import com.jsp.entity.Dancer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static com.jsp.Chap02.DancerSaveProcessServlet.dancerList;

// 역할 : 실제 데이터 베이스에 댄서들을 CRUD
// MODEL 역할
public class DancerJdbcRepo {
    //싱글톤 구현하기 위한 생성
    private static DancerJdbcRepo repo = new DancerJdbcRepo();
    //싱글톤 구현 (객체 생성을 하나로 막기 위함)
    private DancerJdbcRepo(){}
    //싱글 객체를 리턴하는 매서드
    public static DancerJdbcRepo getInstance(){
        return repo;
    }
    //<-----------------------------------------------------------
    private String username = "root"; //db 계정명
    private String password = "mariadb"; //패스워드
    private String url = "jdbc:mariadb://localhost:3306/spring5"; //db url:데이터베이스 설치 위치
    private String driverClassName = "org.mariadb.jdbc.Driver"; //db 벤더별 전용 커넥터 클래스

    //댄서를 데이터베이스에 저장하는 기능
    public boolean save(Dancer dancer){
        try(Connection conn = DriverManager.getConnection(url, username, password);) {
            //1. 연결 드라이버 로딩
            Class.forName(driverClassName);

            //2. 데이터베이스 접속
            // try문으로 옮김

            System.out.println("conn = " + conn);
            //여기까지 에러 안나면 연결 성공.!
            // conn = org.mariadb.jdbc.Connection@59717824

            //3. 실행할 SQL 생성
            String sql = "INSERT INTO tbl_dancer(name,crew_name,dance_level)" +
                    " VALUES (?,?,?)";

            //4. SQL 실행 객체 생성
            PreparedStatement pstmt = conn.prepareStatement(sql);

            //5. ?값 채우기 (VALUE)
            pstmt.setString(1,dancer.getName());
            pstmt.setString(2,dancer.getCrewName());
            pstmt.setString(3,dancer.getDanceLevel().toString());

            //6. 실행 명령
            //INSERT, UPDATE, DELETE 값은 같은 명령 사용
            pstmt.executeUpdate();
            return true;

            //7. 데이터베이스 연결 해제
            //ㄴ try로 묶여서 나가면 종료됨
        } catch (Exception e) {
            e.printStackTrace();
            return  false;
        }
    }

    //댄서 리스트를 반환하는 기능
    public List<Dancer> retrieve(){
        try(Connection conn = DriverManager.getConnection(url,username,password)){

            Class.forName(driverClassName);

            String sql = "SELECT * FROM tbl_dancer " +
                    "ORDER BY id DESC";
            //sql실행 객체 생성
            PreparedStatement pstmt = conn.prepareStatement(sql);

            //? 채우기

            //실행 명령 = select 는 다른 메서드를 사용
            //ResultSet : SELECT 의 결과 집합 표를 가져옴
            ResultSet rs = pstmt.executeQuery();

            //ResultSet 데이터 가져오기
            // next 하면 1행 , 두번하면 2행
//            rs.next(); //표의 행을 지목하는 커서
//            rs.next();  //데이터가 있으면 true 없으면 false
            List<Person> people = new ArrayList<>();
            //데이터 가져오기
            while (rs.next()){
                //커서가 가리키는 행의 데이터를 하나씩 추출⭐️
                int id = rs.getInt("id");//db안에 있는 컬럼 이름
                String name = rs.getString("name");
                String crewname = rs.getString("crew_name");
                String dancelevel = rs.getString("dance_level");


                Dancer dancer = new Dancer();
                dancer.setName(name);
                dancer.setCrewName(crewname);
                dancer.setDanceLevel(Dancer.DanceLevel.valueOf(dancelevel));

                dancerList.add(dancer);
//                System.out.println("person = " + person);
            }
            return dancerList;

        }
        catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
