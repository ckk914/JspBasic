
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<%
  String name = request.getParameter("n");
  int age = Integer.parseInt(request.getParameter("a"));
%>

<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
</head>
<body>
  <% for (int i = 0; i < 3; i++) { %>
    <h1>안녕 나는 greeting이야~~</h1>
  <% } %>

  <h2><%= name %>, <%= age %>살!</h2>

  <script>
    const $h1List = document.querySelectorAll('h1');

    $h1List.forEach($h1 => {
      $h1.style.color = 'red';
    });
  </script>
</body>
</html>