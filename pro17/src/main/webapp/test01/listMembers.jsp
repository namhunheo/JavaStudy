<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<% request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.cls1 {
	font-size: 40px;
	text-align:center;
}
.cls2 {
	font-size : 20px;
	text-align : center;
}
</style>
<script>
let msg = "${msg == 'addMember' ? '등록' : msg == 'modified' ? '수정' : msg == 'deleted' ? '삭제' : ''}";
window.onload = function() {
	if (msg) alert('회원정보를 '+msg+'했습니다.');
}

// 삭제클릭하면 실행
function delMember(id) {
	if (confirm('삭제하시겠습니까?')) {
		location.href='/pro17/member/delMember.do?id='+id;
	}
}
/*
<c:choose>
<c:when test="${msg == 'addMember'}">
	window.onload = function() {
		alert('회원을 등록했습니다.');
	}
</c:when>
<c:when test="${msg == 'modified'}">
window.onload = function() {
	alert('회원정보를 수정했습니다.');
}
</c:when>
<c:when test="${msg == 'deleted'}">
window.onload = function() {
	alert('회원정보를 삭제했습니다.');
}
</c:when>
</c:choose>
*/

</script>
</head>
<body>
<p class="cls1">회원 정보</p>
<div  class="cls2">
<form method="get" action="member">
검색어 : <input type="text" name="searchWord" value="${vo.name}">
<input type="submit" value="조회"> 
</form>
</div>
<table border=1 align="center">
	<tr align=center bgcolor="lightgreen">
		<td width="7%">아이디</td>
		<td width="7%">비밀번호</td>
		<td width="7%">이름</td>
		<td width="7%">이메일</td>
		<td width="7%">가입일자</td>
		<td width="7%">수정</td>
		<td width="7%">삭제</td>
	</tr>
	<c:choose>
		<c:when test="${empty memberList }">
			<tr>
				<td colspan="7"><b>등록된 회원이 없습니다.</b>
			</tr>
		</c:when>
		<c:when test="${!empty memberList }">
			<c:forEach var="vo" items="${memberList }">
				<tr align=center>
					<td>${vo.id }</td>
					<td>${vo.pwd }</td>
					<td>${vo.name }</td>
					<td>${vo.email }</td>
					<td>${vo.joinDate }</td>
					<td><a href="/pro17/member/modMemberForm.do?id=${vo.id}">수정</a>
					<td><a href="javascript:delMember('${vo.id }');">삭제</a>
				</tr>
			</c:forEach>
		</c:when>
	</c:choose>
</table>
<a href="/pro17/member/memberForm.do"><p class="cls2">회원 가입하기</p></a>
</body>
</html>