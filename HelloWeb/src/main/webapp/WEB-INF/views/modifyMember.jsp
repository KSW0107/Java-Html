<%@page import="com.yedam.domain.Employee"%>
<%@page import="com.yedam.persistence.EmpDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page = "menu.jsp"></jsp:include>
<jsp:include page = "nav.jsp"></jsp:include>

	<%
	//사원번호 조회 -> employee
	String id = request.getParameter("id");
	EmpDAO dao = new EmpDAO();
	Employee result = (Employee) request.getAttribute("empInfo");
	%>

	<form action="modifyMember.do" method="post">
		<table class="table">
			<tr>
				<th>사원번호</th>
				<td><input name=id value=<%=result.getEmployeeId()%> readonly>
				</td>
			</tr>
			<tr>
				<th>firstName</th>
				<td><input name=fname value=<%=result.getFirstName()%>></td>
			</tr>
			<tr>
				<th>lastName</th>
				<td><input name=lname value=<%=result.getLastName()%>></td>
			</tr>
			<tr>
				<th>Email</th>
				<td><input name=email value=<%=result.getEmail()%>></td>
			</tr>
			<tr>
				<td colspan="2">
				<input type="submit" value="수정"> 
				<input type="button" value="삭제">
				</td>
			</tr>
		</table>
	</form>

	<script>
		//Document Object Model
		let btn = document.querySelector('input[type="button"]'); /* 선택자 */
		console.log(btn); /* 맞게 적용되는지 확인 */
		btn.onclick = function() {
			/* alert("클릭됨"); */
			let frm = document.querySelector('form');
			frm.action = "delMember.do";
			frm.submit();  
		}
	</script>
<jsp:include page = "footer.jsp"></jsp:include>