<%@page import="com.wang.beans.Student"%>
<%@page import="com.jason.page.bean.PageInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%PageInfo<Student> pageInfo = (PageInfo<Student>)request.getAttribute("pageInfo"); %>
	<table>
		<thead>
			<th>学号</th>
			<th>姓名</th>
			<th>年龄</th>
			<th>性别</th>
		</thead>
		<tbody>
			<%for (Student stu : pageInfo) { %>
			<tr>
				<td><%=stu.getSno() %></td>
				<td><%=stu.getSname() %></td>
				<td><%=stu.getSage() %></td>
				<td><%=stu.getSsex() %></td>
			</tr>
			<%} %>
		</tbody>
	</table>
	
	<a href="/stu?pageSize=<%=pageInfo.getPageSize() %>&pageCount=<%=pageInfo.getFristPage() %>">首页</a>
	<a href="/stu?pageSize=<%=pageInfo.getPageSize() %>&pageCount=<%=pageInfo.getPrePage() %>">上一页</a>
	<%for (int i = 1; i <= pageInfo.getTotalPage(); i++) { %>
		<%if (i != pageInfo.getPageCount()) { %>
			<a href="/stu?pageSize=<%=pageInfo.getPageSize() %>&pageCount=<%=i %>"><%=i %></a>
		<%} else { %>
			<%=i %>
		<%} %>
	<%} %>
	<a href="/stu?pageSize=<%=pageInfo.getPageSize() %>&pageCount=<%=pageInfo.getNextPage() %>">下一页</a>
	<a href="/stu?pageSize=<%=pageInfo.getPageSize() %>&pageCount=<%=pageInfo.getLastPage() %>">尾页</a>
	
</body>
</html>