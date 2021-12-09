<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action = "/adjustBoardProcess" method="post">
		<input type = "hidden" name = "bId" value = "${board.bId}" >
		<input type = "text" name = "bTitle" placeholder = "${board.bTitle}">
		<input type = "text" name = "bContent" placeholder = "${board.bContent}">
		<button type = "submit"> 작성하기</button>
	</form>
</body>
</html>