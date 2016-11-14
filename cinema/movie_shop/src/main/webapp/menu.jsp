<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="span10 last">
	<div class="topNav clearfix">
		<ul>
			<c:if test="${sessionScope.existUser == null}">
			<li id="headerLogin" class="headerLogin" style="display: list-item;">
				<a href="${ pageContext.request.contextPath }/userfront/login">登录</a>|</li>
			<li id="headerRegister" class="headerRegister"
				style="display: list-item;"><a href="${ pageContext.request.contextPath }/userfront/regist">注册</a>|
			</li>
			</c:if>
			<c:if test="${sessionScope.existUser != null}">
			<li id="headerLogin" class="headerLogin" style="display: list-item;">
				${sessionScope.existUser.uname}
				|</li>
			<li id="headerLogin" class="headerLogin" style="display: list-item;">
				<a href="${ pageContext.request.contextPath }/order_findByUid.action?page=1">我的订单</a>
			|</li>
			<li id="headerRegister" class="headerRegister"
				style="display: list-item;"><a href="${ pageContext.request.contextPath }/userfront/destory">退出</a>|
			</li>
			</c:if>
		
			<li><a>会员中心</a> |</li>
			<li><a>购物指南</a> |</li>
			<li><a>关于我们</a></li>
		</ul>
	</div>
	<div class="cart">
		<a href="${ pageContext.request.contextPath }/mycart">购物车</a>
	</div>
	<div class="phone">
		客服热线: <strong>96008/53277764</strong>
	</div>
</div>
<div class="span24">
	<ul class="mainNav">
		<li><a href="${ pageContext.request.contextPath }/index/frontlist">首页</a> |</li>
		 <c:forEach items="${sessionScope.clist}" var="c" varStatus="status">
			<li><a href="${ pageContext.request.contextPath }/findbycid?cid=${c.cid }&page=1">${c.cname }</a> |</li>
		</c:forEach>
	</ul>
</div>