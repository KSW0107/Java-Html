<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- 태그 라이브러리 -->
<style>
.center {
	text-align: center;
}

.pagination {
	display: inline-block;
}

.pagination a {
	color: black;
	float: left;
	padding: 8px 16px;
	text-decoration: none;
	transition: background-color .3s;
	border: 1px solid #ddd;
	margin: 0 4px;
}

.pagination a.active {
	background-color: #4CAF50;
	color: white;
	border: 1px solid #4CAF50;
}

.pagination a:hover:not(.active) {
	background-color: #ddd;
}
</style>

<p>${pageInfo}</p>
<c:set var="no" value="0"></c:set>
<!-- 변수 선언방식1 -->
<table class="table">
	<thead>
		<tr>
			<th>순번</th>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>조회수</th>
		</tr>
	</thead>
	<c:forEach var="notice" items="${list}">
		<tr>
			<%
			int no = 0;
			no = no + 1;
			%>
			<!-- 변수 선언방식2 -->
			<td><c:out value="${no=no+1 }"></c:out></td>
			<td><a href="getNotice.do?nid=${notice.noticeId }&page=${pageInfo.pageNum}">${notice.noticeId}</a></td>
			<td>${notice.noticeTitle }</td>
			<td>${notice.noticeWriter }</td>
			<td>${notice.hitCount }</td>
		</tr>
	</c:forEach>
</table>
<hr>
<div class="center">
	<div class="pagination">
		<c:if test="${pageInfo.prev}">
			<a href="noticeList.do?page=${pageInfo.startPage-1}">◁</a>
		</c:if>
		<c:forEach var="i" begin="${pageInfo.startPage }"
			end="${pageInfo.endPage }">
			<a class="${i == pageInfo.pageNum ? 'active': '' }" href="noticeList.do?page=${i } ">${i } </a>
		</c:forEach>
		<c:if test="${pageInfo.next}">
			<a href="noticeList.do?page=${pageInfo.endPage+1}">▷</a>
		</c:if>
	</div>
</div>
