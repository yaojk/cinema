<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
<title>网上商城</title>
<link href="${pageContext.request.contextPath}/assets/css/common.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/assets/css/product.css" rel="stylesheet" type="text/css"/>
<script>
	function saveCart(){
		document.getElementById("cartForm").submit();
	}
</script>

</head>
<body>

<div class="container header">
	<div class="span5">
		<div class="logo">
			<a>
				<img src="${pageContext.request.contextPath}/image/r___________renleipic_01/logo.gif" alt="">
			</a>
		</div>
	</div>
	<div class="span9">
<div class="headerAd">
					<img src="assets/image\r___________renleipic_01/header.jpg" alt="正品保障" title="正品保障" height="50" width="320">
</div>	</div>
	
	<%@ include file="menu.jsp" %>

</div><div class="container productContent">
		<div class="span6">
			<div class="hotProductCategory">
					<c:forEach items="${clist}" var="c">
						<dl>
							<dt>
								<a href="${pageContext.request.contextPath}/findbycid?cid=${c.cid }&page=1">${c.cname }</a>
							</dt>
							        <c:forEach items="${c.categorySeconds}" var="cs">
									<dd>
										<a href="${ pageContext.request.contextPath }/findbycsid?csid=${cs.csid }&page=1">${cs.csname}</a>
									</dd>
									</c:forEach>
						</dl>
				   </c:forEach>	
			</div>
			

		</div>
		
		<div class="span18 last">
			
			<div class="productImage">
					<a title="" style="outline-style: none; text-decoration: none;" id="zoom" href="http://image/r___________renleipic_01/bigPic1ea8f1c9-8b8e-4262-8ca9-690912434692.jpg" rel="gallery">
						<div class="zoomPad"><img style="opacity: 1;" title="" class="medium" src="${ pageContext.request.contextPath }/upload/${mv.mimage}"><div style="display: block; top: 0px; left: 162px; width: 0px; height: 0px; position: absolute; border-width: 1px;" class="zoomPup"></div><div style="position: absolute; z-index: 5001; left: 312px; top: 0px; display: block;" class="zoomWindow"><div style="width: 368px;" class="zoomWrapper"><div style="width: 100%; position: absolute; display: none;" class="zoomWrapperTitle"></div><div style="width: 0%; height: 0px;" class="zoomWrapperImage"><img src="%E5%B0%9A%E9%83%BD%E6%AF%94%E6%8B%89%E5%A5%B3%E8%A3%852013%E5%A4%8F%E8%A3%85%E6%96%B0%E6%AC%BE%E8%95%BE%E4%B8%9D%E8%BF%9E%E8%A1%A3%E8%A3%99%20%E9%9F%A9%E7%89%88%E4%BF%AE%E8%BA%AB%E9%9B%AA%E7%BA%BA%E6%89%93%E5%BA%95%E8%A3%99%E5%AD%90%20%E6%98%A5%E6%AC%BE%20-%20Powered%20By%20Mango%20Team_files/6d53c211-2325-41ed-8696-d8fbceb1c199-large.jpg" style="position: absolute; border: 0px none; display: block; left: -432px; top: 0px;"></div></div></div><div style="visibility: hidden; top: 129.5px; left: 106px; position: absolute;" class="zoomPreload">Loading zoom</div></div>
					</a>
				
			</div>
			<div class="name">${mv.mname}</div>
			<div class="sn">
				<div>编号：${mv.movieid }</div>
			</div>
			<div class="info">
				<dl>
					<dt>商城价:</dt>
					<dd>
						<strong>￥：${mv.shopprice }元</strong>
							参 考 价：
							<del>￥${mv.marketprice }元</del>
					</dd>
				</dl>
					<dl>
						<dt>促销:</dt>
						<dd>
								<a target="_blank" title="限时抢购 (2014-07-30 ~ 2015-01-01)">限时抢购</a>
						</dd>
					</dl>
					<dl>
						<dt>导演:</dt>
						<dd>
							<span>${mv.mdirector }</span>
						</dd>
					</dl>
					<dl>
						<dt>明星:</dt>
						<dd>
							<span>${mv.mstar }</span>
						</dd>
					</dl>
					<dl>
						<dt>类型:</dt>
						<dd>
							<span>${mv.mtype }</span>
						</dd>
					</dl>
					<dl>
						<dt>评分:</dt>
						<dd>
							<span>${mv.mscore }</span>
						</dd>
					</dl>
			</div>
			<form id="cartForm" action="${ pageContext.request.contextPath }/addcart" method="get" >
				<input type="hidden" name="movieid" value="${mv.movieid }"/>
				<div class="action">
						<dl class="quantity">
							<dt>购买数量:</dt>
							<dd>
								<input id="count" name="count" value="1" maxlength="4" onpaste="return false;" type="text"/>
							</dd>
							<dd>
								件
							</dd>
						</dl>
						
					<div class="buy">
							<input id="addCart" class="addCart" value="加入购物车" type="button" onclick="saveCart()"/>
					</div>
				</div>
			</form>
			<div id="bar" class="bar">
				<ul>
						<li id="introductionTab">
							<a href="#introduction">电影介绍</a>
						</li>
						<li id="introductionTab">
							<a href="#">选座购票</a>
						</li>
						<li id="introductionTab">
							<a href="#comment">热门评论</a>
						</li>
				</ul>
			</div>
				
				<div id="introduction" name="introduction" class="introduction">
					<div class="title">
						<strong>${mv.mstory }</strong>
					</div>
					<div>
						<img src="${pageContext.request.contextPath }/upload/${mv.mimage}">
					</div>
				</div>
				<div id="comment" name="comment" class="introduction">
					<div class="title">
						
					</div>
				</div>
				
				
				
		</div>
	</div>
<div class="container footer">
	<div class="span24">
		<div class="footerAd">
					<img src="assets/image\r___________renleipic_01/footer.jpg" alt="我们的优势" title="我们的优势" height="52" width="950">
</div>
</div>
	<div class="span24">
		<ul class="bottomNav">
					<li>
						<a href="#">关于我们</a>
						|
					</li>
					<li>
						<a href="#">联系我们</a>
						|
					</li>
					<li>
						<a href="#">诚聘英才</a>
						|
					</li>
					<li>
						<a href="#">法律声明</a>
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
						<a target="_blank">配送方式</a>
						|
					</li>
					<li>
						<a >SHOP++官网</a>
						|
					</li>
					<li>
						<a>SHOP++论坛</a>
						
					</li>
		</ul>
	</div>
	<div class="span24">
		<div class="copyright">Copyright © 2005-2015 网上商城 版权所有</div>
	</div>
</div>
</body>
</html>