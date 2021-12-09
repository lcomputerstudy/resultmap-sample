<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<style>
      table tr td{
        border: 1px solid #bcbcbc;
      }
      table {
        width: 1000px;
        height: 200px;
      }
      td {
        text-align: center;
      }
</style>
</head>
<body>
<table>
	<tr><td>${board.bTitle}</td></tr>
	<tr><td style="text-align:right;">${board.bDateTime}</td></tr>
	<tr><td style="text-align:right;">조회수 : ${board.bViews}</td></tr>
	<tr><td style="text-align:right;">작성자 : ${board.bWriter}</td></tr>
	<tr style="height:700px"><td>${board.bContent}</td></tr>
</table>
<c:if test = "${not empty fileinfolist}">
	<c:forEach items="${fileinfolist}" var="f">
		<div>
			<img src="/images/${f.fName}" style="width: 500px; height: 500px;">
		</div>
	</c:forEach>
</c:if>
<c:choose>
<c:when test = "${user.uName == board.bWriter}">
	<a href = "/adjustBoard?bId=${board.bId}">수정</a>
	<a href = "/deleteBoard?bId=${board.bId}">삭제</a>
</c:when>
<c:when test = "${fn:contains(user.authorities, 'ROLE_ADMIN')}">
	<a href = "/deleteBoard?bId=${board.bId}">삭제</a>
</c:when>
</c:choose>
<table id="cmtList">
	<c:forEach items="${commentlist}" var="c">
		<tr>
			<td style="width:700px;">${c.cContentall}</td>
			<td>${c.cWriter}</td>
			<td>${c.cDateTime}</td>
			<td><button type="button" class="btn_reply">답글 쓰기</button></td>
		</tr>
		<tr style="display: none;">
				<td colspan="4">
					<p> <input type = "text" name = "cContent"></p>
					<p> <input type = "button" value = "답글 쓰기" class="btnReply2" cId="${c.cId}" cGroup="${c.cGroup}" cOrder="${c.cOrder}" cDepth="${c.cDepth}"></p>
				</td>
			</tr>
	</c:forEach>
</table>
<table>
	<tr style = "height : 10px;">
		<td colspan="4">
				<p> <input type = "text" name = "cContent" id = "cntnt"></p>
				<p>	<input type = "button" value = "댓글 쓰기" class="btnReply3"></p>
		</td>
	</tr>
</table>

<script>
$(document).on('click', '.btn_reply', function () {
	$(this).parent().parent().next().show();
});

$(document).on('click', '.btnReply2', function () {
	let cId = $(this).attr('cId');
	let cGroup = $(this).attr('cGroup');
	let cDepth = $(this).attr('cDepth');
	let cOrder = $(this).attr('cOrder');
	let cContent = $(this).parent().prev().find('input[name="cContent"]').val();
	
	$.ajax({
	  method: "POST",
	  url: "/writeComment",
	  data: {bId: ${board.bId}, cMaster: ${board.bGroup}, cId: cId, cGroup: cGroup, cDepth: cDepth, cOrder: cOrder, cContent: cContent}
	})
	  .done(function( data ) {
	    	$('#cmtList').html(data)
	  });
});

$(document).on('click', '.btnReply3', function () {
	let cContent = $(this).parent().prev().find('input[name="cContent"]').val();
	
	$.ajax({
	  method: "POST",
	  url: "/writeComment",
	  data: {bId: ${board.bId}, cMaster: ${board.bGroup}, cContent: cContent, cId:0}
	})
	  .done(function( data ) {
	    	$('#cmtList').html(data)
	    	$("#cntnt").val("");
	  });
});
</script>
</body>
</html>