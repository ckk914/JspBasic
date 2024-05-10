<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    
    <h1>댄서 등록 결과 페이지 입니다.</h1>

    <%--
    String name = (String)request.getAttribute("name");
    String crew = (String)request.getAttribute("crew");
    --%>
      <h2>${d.name}님(소속: ${d.crewName} )이 정상 등록되었습니다~</h2>
      <h2>댄스 수준 : ${d.danceLevel}</h2>

    
    <a href="/chap04/dancer/form">새로운 댄서 등록하러 가기</a><br>
    <a href="/chap04/show-list">댄서 목록 조회하기</a>
</body>
</html>