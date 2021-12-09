<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action = "/writeBoardProcess" enctype="multipart/form-data" method="post">
			<input type = "hidden" name = "bId" value = "${board.bId}" >
			<input type = "hidden" name = "bGroup" value = "${board.bGroup}" >
			<input type = "hidden" name = "bOrder" value = "${board.bOrder}" >
			<input type = "hidden" name = "bDepth" value = "${board.bDepth}" >
			<input type = "text" name = "bTitle" placeholder = "제목">
			<input type = "text" name = "bContent" placeholder = "내용">
			<div>
				<p><input multiple="multiple" type="file" name="file" value="files"></p>
			</div>
			<button type = "submit"> 작성하기</button>
		</form>
</body>
</html>