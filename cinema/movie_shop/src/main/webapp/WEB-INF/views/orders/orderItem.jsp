<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<table width="100%">
	<c:forEach items="${orderItems}" var="o">
	<tr>
		<td><img width="40" height="45" src="${ pageContext.request.contextPath }/upload/${o.movie.mimage}"></td>
		<td>${o.movie.mname }</td>
		<td>${o.count }</td>
		<td>${o.subtotal }</td>
	</tr>
	</c:forEach>
</table>