<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery-3.2.1.js"></script>
<script type="text/javascript">
	$(function() {
		tablesData();
	});
	function tablesData()
	{
		$.ajax({
			type:"post",
			url :"<%=request.getContextPath()%>/query",
			success : function(data) {
				tableData(data)
			}
		});
	}
	function tableData(data) {
		var aa = "";

		for (var i = 0; i < data.length; i++) {
			var id = data[i].id;
			var account = data[i].name;
			var pd = data[i].pd;
			aa += "<tr> <td><font color='black'>" + id + "</font></td>"
					+ "<td><font color='black'>" + account + "</font></td>"
					+ "<td><font color='black'>" + pd + "</font></td>"
					+"<td>"
					+"<a href='<%=request.getContextPath()%>/uesr/"+id+"'>修改</a>"
					+"</td>"
					+ "</tr>"
		}
		$("#tbodyId").append(aa);
	}
</script>
<body>
<a href="<%=request.getContextPath()%>/query">修改</a>
	<div align="center">
	<div>
	<a href="<%=request.getContextPath()%>/uesr1111"
		style="border: 1px solid #555; background-color: skybule; line-height: 14px; padding: 4px 10px;">添加</a>
	</div><br>
		<form id="formID">
			<table>
				<tr>
					<th>ID</th>
					<th>用户</th>
					<th>密码</th>
					<th>操作</th>
				</tr>
				<tbody id="tbodyId"></tbody>
			</table>
		</form>
	</div>
</body>
</html>