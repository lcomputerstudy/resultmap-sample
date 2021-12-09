<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
</head>
<body>
<table border=1  width=1000 id="tblList">
		<tr><td>이름</td> <td>아이디</td> <td>가입일자</td><td>권한</td></tr>
		<c:forEach items="${userList}" var="u">
		<tr>
			<td>${u.uName}</td>
			<td>${u.username}</td>
			<td>${u.uDateTime}</td>
			<td>${u.authorities}
			<c:choose>
				<c:when test = "${fn:contains(u.authorities, 'ROLE_ADMIN')}">
					<input type="button" value = "관리자 권한 삭제" class="btn_reply" username="${u.username}">
	      		</c:when>
	      		<c:otherwise>
	      			<input type="button" value = "관리자 권한 추가" class="btn_reply2" username="${u.username}">
	      		</c:otherwise>
			</c:choose>
		</tr>
		</c:forEach>
</table>
<script>
$(document).on('click', '.btn_reply', function () {
	let username = $(this).attr('username');
	
	$.ajax({
	  method: "POST",
	  url: "/deleteAdmin",
	  data: {username: username}
	})
	  .done(function( data ) {
	    	$('#tblList').html(data)
	  });
});

$(document).on('click', '.btn_reply2', function () {
	let username = $(this).attr('username');
	
	$.ajax({
	  method: "POST",
	  url: "/addAdmin",
	  data: {username: username}
	})
	  .done(function( data ) {
	    	$('#tblList').html(data)
	  });
});
</script>
</body>
</html>