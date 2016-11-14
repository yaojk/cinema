<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<HTML>
	<HEAD>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<LINK href="${pageContext.request.contextPath}/assets/css/Style1.css" type="text/css" rel="stylesheet">
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/assets/jslib/bootstrap/css/bootstrap.css">
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/assets/css/theme.css">
		<link rel="stylesheet"
			href="${pageContext.request.contextPath}/assets/jslib/font-awesome/css/font-awesome.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/jslib/bootstrap/css/bootstrap-datetimepicker.min.css">
		<script src="${pageContext.request.contextPath}/assets/jslib/jquery-1.8.1.min.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/assets/jslib/bootstrap/js/bootstrap.min.js"></script>
		<script src="${pageContext.request.contextPath}/assets/jslib/bootstrap/js/bootstrap-datetimepicker.min.js"></script>
		<script src="${pageContext.request.contextPath}/assets/jslib/bootstrap/js/bootstrap-datetimepicker.zh-CN.js"></script>
	
	</HEAD>
	
	<body>
		<!--  -->
		<form id="userAction_save_do" name="Form1" action="${pageContext.request.contextPath}/movie/edit" method="post" enctype="multipart/form-data">
			<input type="hidden" name="movieid" value="${movie.movieid }">
			&nbsp;
			<table cellSpacing="1" cellPadding="5" width="100%" align="center" bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
				<tr>
					<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
						height="26">
						<strong><STRONG>修改商品</STRONG>
						</strong>
					</td>
				</tr>

				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						电影名称：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<input type="text" name="mname" value="${movie.mname }" id="userAction_save_do_logonName" class="bg"/>
					</td>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						是否热门：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<select name="misHot">
							<option value="1" <c:if test="${movie.misHot==1}">selected</c:if>>是</option>
							<option value="0" <c:if test="${movie.misHot==0}">selected</c:if>>否</option>
						</select>
					</td>
				</tr>
			<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						市场价格：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<input type="text" name="marketprice" value="${movie.marketprice }" id="userAction_save_do_logonName" class="bg"/>
					</td>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						商城价格：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<input type="text" name="shopprice" value="${movie.shopprice }" id="userAction_save_do_logonName" class="bg"/>
					</td>
				</tr>
					<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						导演：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<input type="text" name="mdirector" value="${movie.mdirector }" id="userAction_save_do_logonName" class="bg"/>
					</td>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						主演：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<input type="text" name="mstar" value="${movie.mstar }" id="userAction_save_do_logonName" class="bg"/>
					</td>
				</tr>
				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						电影类型：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<input type="text" name="mtype" value="${movie.mtype}" id="userAction_save_do_logonName" class="bg"/>
					</td>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						国家：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<input type="text" name="mcountry" value="${movie.mcountry}" id="userAction_save_do_logonName" class="bg"/>
					</td>
				</tr>
				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						首映时间：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						
						<input type="text" name="mpremiere" value="<fmt:formatDate value="${movie.mpremiere }" pattern="yyyy-MM-dd" />" id="userAction_save_do_logonName" class="bg"/>
					</td>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						时长：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<input type="text" name="mduration" value="${movie.mduration}" id="userAction_save_do_logonName" class="bg"/>
					</td>
				</tr>
				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						票数：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<input type="text" name="mticketcount" value="${movie.mticketcount }" id="userAction_save_do_logonName" class="bg"/>
					</td>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						评分：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<input type="text" name="mscore" value="${movie.mscore}" id="userAction_save_do_logonName" class="bg"/>
					</td>
				</tr>
				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						电影图片：
					</td>
					<td class="ta_01" bgColor="#ffffff" colspan="3">
						<span id="imgContent" class="mylabel">
							<c:if test="${movie.mimage!='' && movie.mimage!=null}">
	              				<img style="width:150px;height:150px;margin-left: 10px;" src="${ pageContext.request.contextPath }/upload/${movie.mimage}" >
		              		</c:if>
						</span>
						<a class="btn" href="javascript:void(0)" onclick="$('#img').click()">选择图片</a>
						<div style="opacity:0;">
							<input type="file" id="img" name="file" data-content="imgContent"/>
						</div>
					</td>
					
				</tr>
				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						所属的二级分类：
					</td>
					
				 <td class="ta_01" bgColor="#ffffff" colspan="3">
						<select name="csid">
							<c:forEach items="${cList}" var="c">
								<option value="${c.csid }" 
								 <c:if test="${c.csid  == movie.csid }">selected</c:if>
								>${c.csname }</option>
							</c:forEach>
						</select>
					</td>
			
				</tr>
				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						电影简介：
					</td>
					<td class="ta_01" bgColor="#ffffff" colspan="3">
						<textarea name="mstory" rows="5" cols="30" >${movie.mstory}</textarea>
					</td>
				</tr>
				<tr>
					<td class="ta_01" style="WIDTH: 100%" align="center"
						bgColor="#f5fafe" colSpan="4">
						<button type="submit" id="userAction_save_do_submit" value="确定" class="button_ok">
							&#30830;&#23450;
						</button>

						<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
						<button type="reset" value="重置" class="button_cancel">&#37325;&#32622;</button>

						<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
						<INPUT class="button_ok" type="button" onclick="history.go(-1)" value="返回"/>
						<span id="Label1"></span>
					</td>
				</tr>
			</table>
		</form>
	</body>
	<script>
		window.onload=function(){
			//绑定图片事件
			$("#img").change(function(e) {
		    	$("#"+$(this).attr("data-content")).html('');
		    	for (var i = 0; i < this.files.length; i++) {
		    		$("#"+$(this).attr("data-content")).append('<img style="width:150px;height:150px;margin-left: 10px;" src="'+ getObjectURL(this.files[i])+'">');
				}
		    });
		}
		function getObjectURL(file) {
		    var url = null ; 
		    if (window.createObjectURL!=undefined) { // basic
		        url = window.createObjectURL(file) ;
		    } else if (window.URL!=undefined) { // mozilla(firefox)
		        url = window.URL.createObjectURL(file) ;
		    } else if (window.webkitURL!=undefined) { // webkit or chrome
		        url = window.webkitURL.createObjectURL(file) ;
		    }
		    return url ;
		}
	</script>
</HTML>