<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<META http-equiv="Cache-Control" content="no-cache">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>book list</h1>
	<table>
		<thead>
			<tr>
				<td>제목</td>
				<td>카테고리</td>
				<td>가격</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="row" items="${data}">
				<tr>
					<td><a href="/detail?bookId=${row.book_id}"> ${row.title}
					</a></td>
					<td>${row.category}</td>
					<td><fmt:formatNumber type="number" maxFractionDigits="3"
							value="${row.price}" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<p>
		<a href="/create">생성</a>
	</p>
</body>
</html>