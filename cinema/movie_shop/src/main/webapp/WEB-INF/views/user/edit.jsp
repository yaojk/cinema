<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<HTML>
	<HEAD>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<LINK href="${pageContext.request.contextPath}/assets/css/Style1.css" type="text/css" rel="stylesheet">
	</HEAD>
	
	<body>
		<form id="userAction_save_do" name="Form1" action="${pageContext.request.contextPath}/user/edit" method="post">
			<input type="hidden" name="uid" value="${users.uid }" />
			&nbsp;
			<table cellSpacing="1" cellPadding="5" width="100%" align="center" bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
				<tr>
					<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
						height="26">
						<strong><STRONG>编辑用户</STRONG>
						</strong>
					</td>
				</tr>

				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						用户名称：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<input type="text" name="username" value="${users.username }" id="userAction_save_do_logonName" class="bg"/>
					</td>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						用户状态：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<select name="ustate">
							<option value="1" <c:if test="${users.ustate==1}">selected</c:if>>是</option>
							<option value="0" <c:if test="${users.ustate==0}">selected</c:if>>否</option>
						</select>
					</td>
				</tr>
			<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						密码：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<input type="text" name="password" value="${users.password }" id="userAction_save_do_logonName" class="bg"/>
					</td>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						真实名称：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<input type="text" name="uname" value="${users.uname }" id="userAction_save_do_logonName" class="bg"/>
					</td>
				</tr>
					<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						邮箱：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<input type="text" name="uemail" value="${users.uemail }" id="userAction_save_do_logonName" class="bg"/>
					</td>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						手机号：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<input type="text" name="uphone" value="${users.uphone }" id="userAction_save_do_logonName" class="bg"/>
					</td>
				</tr>
				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						地址：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<input type="text" name="uaddr" value="${users.uaddr }" id="userAction_save_do_logonName" class="bg"/>
					</td>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						激活码：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<input type="text" name="code" value="${users.code }" id="userAction_save_do_logonName" class="bg"/>
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
</HTML>