<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
      table tr td{
        border: 1px solid #bcbcbc;
      }
      table {
        width: 1000px;
        height: 150px;
      }
      td {
        text-align: center;
      }
</style>
</head>
<body>
<table>
	<tr><td>번호</td><td>제목</td> <td>내용</td> <td>작성자</td><td>시간</td></tr>
	<c:forEach items="${boardlist}" var="b">
		<tr>
			<td>${b.bRownum}</td>
			<td><a href = "/readBoard?bId=${b.bId}&bGroup=${b.bGroup}">${b.bTitleall}</a></td>
			<td>${b.bContent}</td>
			<td>${b.bWriter}</td>
			<td>${b.bDateTime}</td>
			<td><a href = "/writeBoard?bId=${b.bId}&bGroup=${b.bGroup}&bOrder=${b.bOrder}&bDepth=${b.bDepth}">답글쓰기</a></td>
		</tr>
	</c:forEach>
</table>
<form name = "searchBox" method="post" action="/searchProcess">
	<select name="searchOption">
		<option value="all" <c:out value="${map.searchOption == 'all' ? 'selected' : ''}"/> >제목+작성자+내용</option>
		<option value="title" <c:out value="${map.searchOption == 'title' ? 'selected' : ''}"/> >제목</option>
		<option value="writer" <c:out value="${map.searchOption == 'writer' ? 'selected' : ''}"/> >작성자</option>
		<option value="content" <c:out value="${map.searchOption == 'content' ? 'selected' : ''}"/> >내용</option>
	</select>
		<input name="keyword" value="${map.keyword}">
		<input type="submit" value="조회">
</form>
<div style = "padding: 0px 0px 0px 917px;">
	<a href = "/writeBoard?bId=0">글쓰기</a>
</div>
</body>
</html>