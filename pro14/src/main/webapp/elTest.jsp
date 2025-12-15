<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="elTest.*" %>
<%
//request.setAttribute("name", "홍길동");
//String name = (String)request.getAttribute("name");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>elTest.jsp</h1>
request의 name : ${name }<br>
${member.name }<br>
세션 : ${id}<br>
세션의 name : ${sessionScope.name }<br>
로그인세션여부 : ${empty loginSession }<br>
파라미터 : ${param.page }<br>
<%
MemberVO vo = (MemberVO)request.getAttribute("member");
%>
<%=vo.getId() == null ? "" : vo.getId() %><br>
${member.id }<br>
<h2>JSTL</h2>
<c:out value="${name }"/><br>
<c:if test="${!empty loginSession }"> <!-- loginSession값이 비어있지 않으면 -->
${loginSession.name }님 안녕하세요!
</c:if>
<c:if test="${empty loginSession }">
로그인하세요
</c:if>
<br>
<c:forEach var="map" items="${list }">
	${map.title }<br>
</c:forEach>
<br>
<img src="<c:url value="/img/cat1.jpg"/>">
<br>
숫자 천단위 컴마 : <fmt:formatNumber value="${price }"/><br>
날짜 포맷 : <fmt:formatDate value="${date }" pattern="yyyy-MM-dd"/><br>
메서드 호출 :



</body>
</html>






