<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main Page</title>
</head>
<body>

	<p>Main Page</p>
	<p>Expression Language</p>
	${3>2} <!-- 간단한 연산식(주석 안에서 사용 X) -->
	${"Hello"}
	${10 -5 }
	${myName != null}
	${myName != null ? '<p>있음</p>' : '<p>없음</p>'}
</body>
</html>