<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>菜单</title>
<link href="${pageContext.request.contextPath}/assets/css/left.css" rel="stylesheet" type="text/css"/>
<link rel="StyleSheet" href="${pageContext.request.contextPath}/assets/css/dtree.css" type="text/css" />
</head>
<body>
<table width="100" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="12"></td>
  </tr>
</table>
<table width="100%" border="0">
  <tr>
    <td>
<div class="dtree">

	<a href="javascript: d.openAll();">展开所有</a> | <a href="javascript: d.closeAll();">关闭所有</a>
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/dtree.js"></script>
	<script type="text/javascript">
		<!--
		d = new dTree('d');
		d.add('01',-1,'商城管理树');
		d.add('0101','01','用户管理','','','mainFrame');
		d.add('010101','0101','用户管理','${pageContext.request.contextPath}/user/list?page=1','','mainFrame');
		d.add('0102','01','一级分类管理','','','mainFrame');
		d.add('010201','0102','一级分类管理','${pageContext.request.contextPath}/category/list','','mainFrame');
		d.add('0103','01','二级分类管理');
		d.add('010301','0103','二级分类管理','${pageContext.request.contextPath}/categorysecond/list?page=1','','mainFrame');
		d.add('0104','01','电影管理');
		d.add('010401','0104','商品管理','${pageContext.request.contextPath}/movie/list?page=1','','mainFrame');
		d.add('0105','01','订单管理');
		d.add('010501','0105','订单管理','${pageContext.request.contextPath}/orders/list?page=1','','mainFrame');
		d.add('0106','01','评论管理');
		d.add('010601','0106','评论管理','${pageContext.request.contextPath}/comment/list?page=1','','mainFrame');
		d.add('0107','01','公告管理');
		d.add('010701','0107','公告管理','${pageContext.request.contextPath}/assets/adminOrder_findAll.action?page=1','','mainFrame');
		d.add('0108','01','新闻管理');
		d.add('010801','0108','新闻管理','${pageContext.request.contextPath}/assets/adminOrder_findAll.action?page=1','','mainFrame');
		d.add('0109','01','管理员管理');
		d.add('010901','0109','管理员管理','${pageContext.request.contextPath}/assets/adminOrder_findAll.action?page=1','','mainFrame');
		
		d.add('02',-1,'权限管理树');
		d.add('0201','02','角色管理','','','mainFrame');
		d.add('020101','0201','角色管理','${pageContext.request.contextPath}/assets/userAdmin_findAll.action?page=1','','mainFrame');
		d.add('0202','02','系统功能管理','','','mainFrame');
		d.add('020201','0202','系统功能管理','${pageContext.request.contextPath}/assets/adminCategory_findAll.action','','mainFrame');
		document.write(d);
		//-->
	</script>
</div>	</td>
  </tr>
</table>
</body>
</html>
