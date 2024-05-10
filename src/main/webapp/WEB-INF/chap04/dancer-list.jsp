<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
  <style>
    .del-btn {
        padding: 5px 10px;
        outline: none;
        border: none;
        background: red;
        border-radius: 10px;
        color: #fff;
        margin-left: 10px;
        margin-bottom: 10px;
        cursor: pointer;
    }
    .del-btn:hover {
        border: 1px solid orange;
        opacity: 0.8;
    }
</style>
</head>
<body>
  
  <h1>댄서 정보 목록</h1>
  <ul id="dancer-list">

    <!--  for (Dancer d : dancers)  -->
    <c:forEach var="d" items="${dancers}">
      <li>
        # 이름: <span class="dancer-name">${d.name}</span>,
        # 크루명: ${d.crewName},
        # 레벨: ${d.danceLevel},
        # 페이: ${d.danceLevel.payPerEvent}원
        <button class="del-btn">삭제</button>
      </li>
    </c:forEach>

    
  </ul>

  <a href="/chap04/dancer/form">다시 등록하기</a>

</body>
</html>