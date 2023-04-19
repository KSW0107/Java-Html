<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="my"%> <!-- 태그 라이브러리 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../main.jsp"></jsp:include> <!-- 해당 페이지 포함헤서 출력 -->
	
	<!-- if문 -->
	<my:if test="${list == null}">
	<p>${list}</p>
	</my:if>
	
	<!-- for문 -->
	<my:forEach var="i" begin="1" end="10" step="1" >
	<p>${i}</p>
	</my:forEach>
	
	<!-- 확장된 for문 -->
	<my:forEach var="notice" items="${list}">
	<p>${notice}</p>
	</my:forEach>
</body>
</html>