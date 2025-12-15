<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
h1 {
	text-align:center;
}
</style>
</head>
<body>
<h1>회원 정보 출력</h1>
<form method="get" action="member">
검색어 : <input type="text" name="searchWord" value="${vo.name}">
<input type="submit" value="조회"> 
</form>
<table border=1 width=800 align=center>
	<tr align=center bgcolor="#ffff66">
		<td>아이디</td>
		<td>비밀번호</td>
		<td>이름</td>
		<td>이메일</td>
		<td>가입일자</td>
	</tr>
<c:forEach var="vo" items="${list }">
	<tr align=center>
		<td>${vo.id }</td>
		<td>${vo.pwd }</td>
		<td>${vo.name }</td>
		<td>${vo.email }</td>
		<td>${vo.joinDate }</td>
	</tr>
</c:forEach>
</table>
</body>
</html>