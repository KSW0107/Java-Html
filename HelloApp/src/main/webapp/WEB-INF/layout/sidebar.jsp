<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="border-end bg-white" id="sidebar-wrapper">
	<c:choose>
	<c:when test="${info.name != null}">
	<div class="sidebar-heading border-bottom bg-light">
		Hello!<br> ${info.name }
	</div>
	</c:when>
	<c:otherwise>
	<div class="sidebar-heading border-bottom bg-light">
		Hello! <br>Guest
	</div>
	</c:otherwise>
	</c:choose>
	<div class="list-group list-group-flush">
		<a class="list-group-item list-group-item-action list-group-item-light p-3"
			href="noticeList.do">공지사항목록</a> 
			<c:choose>
			<c:when test="${info.name !=null }">
		<a class="list-group-item list-group-item-action list-group-item-light p-3"
			href="noticeAddForm.do">공지사항등록</a>
			</c:when>
		</c:choose>
		<c:choose>
			<c:when test="${info.name==null }">
				<a
					class="list-group-item list-group-item-action list-group-item-light p-3"
					href="loginForm.do">로그인</a>
			</c:when>
			<c:when test="${info.name!=null }">
				<a
					class="list-group-item list-group-item-action list-group-item-light p-3"
					href="logout.do">로그아웃</a>
			</c:when>
		</c:choose>
		<a class="list-group-item list-group-item-action list-group-item-light p-3"
			href="#!">Profile</a> 
		<a class="list-group-item list-group-item-action list-group-item-light p-3"
			href="#!">Status</a> 
		<a class="list-group-item list-group-item-action list-group-item-light p-3"
			href="#!">Status</a>
	</div>
</div>