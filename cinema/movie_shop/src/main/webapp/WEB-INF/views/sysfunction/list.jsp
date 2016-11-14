<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<HTML>
	<HEAD>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="${pageContext.request.contextPath}/assets/css/Style1.css" rel="stylesheet" type="text/css" />
		<script language="javascript" src="${pageContext.request.contextPath}/assets/js/public.js"></script>
		<script type="text/javascript">
			function addUser(){
				window.location.href = "${pageContext.request.contextPath}/sysfunctionController/ad";
			}
		</script>
	</HEAD>
	<body>
		<br>
			<table cellSpacing="1" cellPadding="0" width="100%" align="center" bgColor="#f5fafe" border="0">
				<TBODY>
					<tr>
						<td class="ta_01" align="center" bgColor="#afd1f3">
							<strong>功能列表</strong>
						</TD>
					</tr>
					<tr>
						<td class="ta_01" align="right">
							<button type="button" id="add" name="add" value="添加顶层功能" class="button_add" onclick="addUser()">
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
										父功能
									</td>
									<td align="center" width="17%">
										功能名称
									</td>
									<td align="center" width="17%">
										功能地址
									</td>
									<td align="center" width="17%">
										功能状态
									</td>
									<td width="7%" align="center">
										编辑
									</td>
								</tr>
									<c:choose>
							<c:when test="${!empty funList}">	
							<c:forEach items="${funList}" var="item">
								<c:if test="${item.sysFunid!=\"-1\"}">
										<tr onmouseover="this.style.backgroundColor = 'white'"
											onmouseout="this.style.backgroundColor = '#F5FAFE';">
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="18%">
												${item.funpname}
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="17%">
												${item.funname}
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="17%">
												${item.funurl}
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="17%">
												<c:choose>
													<c:when test="${item.funstate==\"1\"}">
														正常		
													</c:when>
													<c:otherwise>锁定</c:otherwise>
												</c:choose>
											</td>
											<td align="center" style="HEIGHT: 22px">
												<a href="${ pageContext.request.contextPath }/sysfunctionController/load?id=${item.funid}">
													<img src="${pageContext.request.contextPath}/assets/images/i_edit.gif" border="0" style="CURSOR: hand">
												</a>
											</td>
										</tr>
										</c:if>
							</c:forEach>
							</c:when>
							<c:otherwise>
								<tr onmouseover="this.style.backgroundColor = 'white'"
											onmouseout="this.style.backgroundColor = '#F5FAFE';">
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="18%">
												${item.funpname}
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="17%">
												${item.funname}
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="17%">
												${item.funurl}
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="17%">
												<c:choose>
													<c:when test="${item.funstate==\"1\"}">
														正常		
													</c:when>
													<c:otherwise>锁定</c:otherwise>
												</c:choose>
											</td>
											<td align="center" style="HEIGHT: 22px">
												<a href="${ pageContext.request.contextPath }/sysfunctionController/load?id=${item.funid}">
													<img src="${pageContext.request.contextPath}/assets/images/i_edit.gif" border="0" style="CURSOR: hand">
												</a>
												<a href="${pageContext.request.contextPath}/sysfunctionController/load?fid=${fun.funid}&fname=${fun.funname}">子功能</a>
											</td>
										</tr>
							</c:otherwise>
						</c:choose>
							</table>
						</td>
					</tr>
				</TBODY>
			</table>
	</body>
</HTML>

