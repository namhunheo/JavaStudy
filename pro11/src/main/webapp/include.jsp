<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<% 
String name = "홍길동"; 
%>
<body>
	<h1>안녕하세요 쇼핑몰 중심 JSP 시작입니다.!!</h1>
	<%//@ include file="cat_image.jsp" %>
	<jsp:include page="cat_image.jsp"></jsp:include>
	<h1>안녕하세요 쇼핑몰 중심 JSP 끝입니다.</h1>
</body>
</html>