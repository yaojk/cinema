<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<HTML>
	<HEAD>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="${pageContext.request.contextPath}/css/Style1.css" rel="stylesheet" type="text/css" />
		<script language="javascript" src="${pageContext.request.contextPath}/js/public.js"></script>
		<script type="text/javascript">
			function addProduct(){
				window.location.href = "${pageContext.request.contextPath}/movie/add";
			}
		</script>
	</HEAD>
	<body>
		<br>
		<form id="Form1" name="Form1" action="${pageContext.request.contextPath}/user/list.jsp" method="post">
			<table cellSpacing="1" cellPadding="0" width="100%" align="center" bgColor="#f5fafe" border="0">
				<TBODY>
					<tr>
						<td class="ta_01" align="center" bgColor="#afd1f3">
							<strong>商品列表</strong>
						</TD>
					</tr>
					<tr>
						<td class="ta_01" align="right">
							<button type="button" id="add" name="add" value="添加" class="button_add" onclick="addProduct()">
&#28155;&#21152;
</button>

						</td>
					</tr>
					<tr>
						<td class="ta_01" align="center" bgColor="#f5fafe">
							<table cellspacing="0" cellpadding="1" rules="all"
								bordercolor="gray" border="1" id="DataGrid1"
								style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
								<tr
									style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">

									<td align="center" width="18%">
										序号
									</td>
									<td align="center" width="17%">
										电影图片
									</td>
									<td align="center" width="17%">
										电影名称
									</td>
									<td align="center" width="17%">
										电影票价格
									</td>
									<td align="center" width="17%">
										市场价格
									</td>
									<td align="center" width="17%">
										导演
									</td>
									<td align="center" width="17%">
										主演
									</td>
									<td align="center" width="17%">
										电影类型
									</td>
									<td align="center" width="17%">
										国家
									</td>
									<td align="center" width="17%">
										故事简介
									</td>
									<td align="center" width="17%">
										首映时间
									</td>
									<td align="center" width="17%">
										总票数
									</td>
									<td align="center" width="17%">
										评分
									</td>
									<td align="center" width="17%">
										所属二级分类
									</td>
									<td align="center" width="17%">
										是否热门
									</td>
									<td width="7%" align="center">
										编辑
									</td>
									<td width="7%" align="center">
										删除
									</td>
								</tr>
								<c:forEach items="${pageBean.list}" var="p" varStatus="status">
										<tr onmouseover="this.style.backgroundColor = 'white'"
											onmouseout="this.style.backgroundColor = '#F5FAFE';">
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="18%">
												${ status.index + 1}
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="17%">
												<img width="40" height="45" src="${ pageContext.request.contextPath }/upload/${p.mimage}">
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="17%">
												${p.mname}
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="17%">
												${p.shopprice }
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="17%">
												${p.marketprice }
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="17%">
												${p.mdirector }
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="17%">
												${p.mstar }
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="17%">
												${p.mtype }
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="17%">
												${p.mcountry }
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="17%">
												${p.mstory }
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="17%">
												${p.mduration }
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="17%">
												${p.mticketcount }
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="17%">
												${p.mscore }
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="17%">
												${p.csid }
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="17%">
						
											<c:if test="${p.misHot==1}">
												是
											</c:if>
											<c:if test="${p.misHot!=1}">
												否
											</c:if>	
											</td>
											<td align="center" style="HEIGHT: 22px">
												<a href="${ pageContext.request.contextPath }/movie/edit?movieid=${p.movieid}">
													<img src="/assets/images/i_edit.gif" border="0" style="CURSOR: hand">
												</a>
											</td>
									
											<td align="center" style="HEIGHT: 22px">
												<a href="${ pageContext.request.contextPath }/movie/delete?movieid=${p.movieid}">
													<img src="/assets/images/i_del.gif" width="16" height="16" border="0" style="CURSOR: hand">
												</a>
											</td>
										</tr>
									</c:forEach>
							</table>
						</td>
					</tr>
					<tr align="center">
						<td colspan="7">
							第${pageBean.page}/${ pageBean.totalPage}页 
							<c:if test="${ pageBean.page  !=1 }">
								<a href="${ pageContext.request.contextPath }/movie/list?page=1">首页</a>|
								<a href="${ pageContext.request.contextPath }/movie/list?page=${ pageBean.page-1}">上一页</a>|
							</c:if>
							<c:if test="${ pageBean.page  !=  pageBean.totalPage}">
								<a href="${ pageContext.request.contextPath }/movie/list?page=${ pageBean.page+1}">下一页</a>|
								<a href="${ pageContext.request.contextPath }/movie/list?page=${ pageBean.totalPage}">尾页</a>|
							</c:if>
						
						</td>
					</tr>
				</TBODY>
			</table>
		</form>
	</body>
	
</HTML>

