<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<form action="modifyMember.do" method="GET">
	<table class="table">
		<tr>
			<th>이메일</th>
			<td><input type="text" name="email" value="${info.email}"
				readonly></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="password" name="pass"
				value="${info.password }" ></td>
		</tr>
		<tr>
			<th>이름</th>
			<td><input type="text" name="name"
				value="${info.name }" readonly></td>
		</tr>
		<tr>
			<th>연락처</th>
			<td><input type="text" name="phone"
				value="${info.phone }" ></td>
		</tr>
		<tr>
			<th>주소</th>
			<td><input type="text" name="address"
				value="${info.address }" ></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
			
				<button type="submit">수정</button>
				<button type="button"
					onclick="location.href='main.do'">취소</button>

			</td>
		</tr>
	</table>
</form>

    