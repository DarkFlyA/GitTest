<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	// ajax
	function page(pageCount,pageSize){
		// 1.创建XHR(XMLHttpRequest)对象
		var xhr = new XMLHttpRequest();
		// 2.创建事件监听
		xhr.onreadystatechange = function(e) {
			// 0  建立链接
			// 1 链接建立完成
			// 2 发送请求
			// 3 请求发送完毕
			// 4 响应
			// 5 关闭
			if (xhr.readyState == 4) {
				// 此时代表响应
				eval("var list = " + xhr.responseText);
				var html = "";
				for ( var index in list) {
					var stu = list[index];
					html += "<tr>";
					html += "<td>" + stu.sno + "</td>";
					html += "<td>" + stu.sname + "</td>";
					html += "<td>" + stu.sage + "</td>";
					html += "<td>" + stu.ssex + "</td>";
					html += "</tr>";
				}
				var data = document.getElementById("data");
				data.innerHTML = html;
			}
		}
		// 3.打开连接
		xhr.open("GET", "/stu?ajax=true&pageCount=" + pageCount + "&pageSize=" + pageSize);
		// 4.发送请求
		xhr.send();
	}
</script>
</head>
<body onload="page(1,4)">
	当前时间:<%=new Date()%>
	<table>
		<thead>
			<th>学号</th>
			<th>姓名</th>
			<th>年龄</th>
			<th>性别</th>
		</thead>
		<tbody id="data">
		</tbody>
	</table>
	<button onclick="page(1,4)">1</button>
	<button onclick="page(2,4)">2</button>
	<button onclick="page(3,4)">3</button>
</body>
</html>