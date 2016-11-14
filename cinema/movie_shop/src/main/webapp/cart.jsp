<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0043)http://localhost:8080/mango/cart/list.jhtml -->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>购物车</title>

<link href="${pageContext.request.contextPath}/assets/css/common.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/assets/css/cart.css" rel="stylesheet" type="text/css"/>


</head>
<body>
<div class="container header">
	<div class="span5">
		<div class="logo">
			<a href="http://localhost:8080/mango/">
				<img src="${pageContext.request.contextPath}/image/r___________renleipic_01/logo.gif" alt="">
			</a>
		</div>
	</div>
	<div class="span9">
<div class="headerAd">
				<img src="${pageContext.request.contextPath}/assets/image/header.jpg" width="320" height="50" alt="正品保障" title="正品保障">
</div>	</div>
	
	<%@ include file="menu.jsp" %>
	
</div>	<div class="container cart">
	
		<c:if test="${sessionScope.cart.cartItems != null }">
		<div class="span24">
			  
				<table>
					<tbody>
					<tr>
						<th>图片</th>
						<th>电影</th>
						<th>价格</th>
						<th>数量</th>
						<th>小计</th>
						<th>操作</th>
					</tr>
						
						<c:forEach items="${sessionScope.cart.cartItems}" var="cartItem">
						<tr>
							<td width="60">
								<img src="${pageContext.request.contextPath}/upload/${cartItem.movie.mimage}">
							</td>
							<td>
								<a target="_blank">${cartItem.movie.mname }</a>
							</td>
							<td>
								￥${cartItem.movie.shopprice }
							</td>
							<td class="quantity" width="60">
								${cartItem.count }
							</td>
							<td width="140">
								<span class="subtotal">￥${cartItem.subtotal }</span>
							</td>
							<td>
								<a href="${ pageContext.request.contextPath }/removecart?movieid=${cartItem.movie.movieid}" class="delete">删除</a>
							</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
				<dl id="giftItems" class="hidden" style="display: none;">
				</dl>
				<div class="total">
					<em id="promotion"></em>
							<em>
								登录后确认是否享有优惠
							</em>
					赠送积分: <em id="effectivePoint">${sessionScope.cart.total }</em>
					商品金额: <strong id="effectivePrice">￥${sessionScope.cart.total }元</strong>
				</div>
				<div class="bottom">
					<a href="${ pageContext.request.contextPath }/clearcart" id="clear" class="clear">清空购物车</a>
					<a href="${ pageContext.request.contextPath }/saveorder" id="submit" class="submit">提交订单</a>
				</div>
				
		</div>
		</c:if>
		<c:if test="${sessionScope.cart.cartItems == null }">
			<div class="span24">
				<div class="step step1">
					<span><h2>亲!您还没有购物!请先去购物!</h2></span>
				</div>
			</div>
		</c:if>
	</div>
<div class="container footer">
	<div class="span24">
		<div class="footerAd">
					<img src="${pageContext.request.contextPath}/assets/image/footer.jpg" width="950" height="52" alt="我们的优势" title="我们的优势">
</div>	</div>
	<div class="span24">
		<ul class="bottomNav">
				<li>
						<a >关于我们</a>
						|
					</li>
					<li>
						<a>联系我们</a>
						|
					</li>
					<li>
						<a>招贤纳士</a>
						|
					</li>
					<li>
						<a>法律声明</a>
						|
					</li>
					<li>
						<a>友情链接</a>
						|
					</li>
					<li>
						<a target="_blank">支付方式</a>
						|
					</li>
					<li>
						<a  target="_blank">配送方式</a>
						|
					</li>
					<li>
						<a>服务声明</a>
						|
					</li>
					<li>
						<a>广告声明</a>
						
					</li>
		</ul>
	</div>
	<div class="span24">
		<div class="copyright">Copyright © 2005-2015 网上商城 版权所有</div>
	</div>
</div>
</body></html>