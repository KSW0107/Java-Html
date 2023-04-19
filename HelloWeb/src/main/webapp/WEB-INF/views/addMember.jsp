<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page = "menu.jsp"></jsp:include>
<jsp:include page = "nav.jsp"></jsp:include>

<% String lname = (String) session.getAttribute("sesInfo");%>
	
	<p>Session : <%=lname %></p>
	<form action="addMember.do">
		<table class="table">
			<tr>
				<th>사원번호</th>
				<td><input name=id> </td>
			</tr>
			<tr>
				<th>firstName</th>
				<td><input name=fname></td>
			</tr>
			<tr>
				<th>lastName</th>
				<td><input name=lname></td>
			</tr>
			<tr>
				<th>Email</th>
				<td><input name=email></td>
			</tr>
			<tr>
				<th>hire</th>
				<td><input name=hire></td>
			</tr>
			<tr>
				<th>job_id</th>
				<td><input name=job></td>
			</tr>
			<tfoot>
			<tr>
				<th colspan="2"><input type="submit" value="추가"></th>
			</tr>
			</tfoot>
		</table>
	</form>
	
<jsp:include page = "footer.jsp"></jsp:include>
