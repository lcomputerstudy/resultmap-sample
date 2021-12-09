<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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