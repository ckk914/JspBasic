<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.jsp.entity.Dancer" %>

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

  <%
      List<Dancer> dancers = (List<Dancer>) request.getAttribute("dancers");
  %>

  <h1>댄서 정보 목록</h1>
  <ul id="dancer-list">
    <% for (Dancer d : dancers) { %>

      <li>
        # 이름: <span class="dancer-name"><%= d.getName() %></span>,
        # 크루명: <%= d.getCrewName() %>,
        # 레벨: <%= d.getDanceLevel() %>,
        # 페이: <%= d.getDanceLevel().getPayPerEvent() %>원
        <button class="del-btn">삭제</button>
    </li>

    <% } %>
  </ul>

  <a href="/chap04/dancer/form">다시 등록하기</a>

</body>
</html>