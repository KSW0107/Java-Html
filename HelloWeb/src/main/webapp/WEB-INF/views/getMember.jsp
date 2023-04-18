<%@page import="com.yedam.domain.Employee"%>
<%@page import="com.yedam.persistence.EmpDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page = "menu.jsp"></jsp:include>
<jsp:include page = "nav.jsp"></jsp:include>

	<%
	Employee emp = (Employee) request.getAttribute("empInfo");
	//EmpDAO dao = new EmpDAO();
  	//Employee result = dao.getEmp(Integer.parseInt(id));
	%>

	<table class="table">
		<tr>
			<th>사원번호</th>
			<td>
				<%=emp.getEmployeeId() %>
			</td>
		</tr>
		<tr>
			<th>사원이름</th>
			<td>
				<%=emp.getLastName() %>
			</td>
		</tr>
		<tr>
			<th>사원이메일</th>
			<td>
				<%=emp.getEmail() %>
			</td>
		</tr>

	</table>

<jsp:include page = "footer.jsp"></jsp:include>