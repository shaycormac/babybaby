<!--中文编码设置-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<title>编辑相册信息</title>
<link rel=stylesheet href="/babyplan/css/demo.css" type="text/css">
</head>
<script src="/babyplan/easyui/jquery-1.11.1.js"></script>
<script type="text/javascript">
function ensure() {
	var oForm = document.getElementsByName("frmAction")[0];
	oForm.action = "/babyplan";
	oForm.submit();
}
</script>

<body>
<form name="frmAction"  method="post" action="" >
	<table width="60%" align="center">
			<tr bgcolor="#E4E4E4">
				<td colspan="2" height="40" style="text-indent: 1em;"><b>编辑信息</b></td>
			</tr>
			<tr>
				<td width="150" height="60" align="right">名称：</td>
				<td><input type="text" name="albumName" title="default" value="白雪公主" style="width:420px;"></td>
			</tr>
			<tr>
				<td width="150" align="right" >简介：</td>
				<td><textarea name="albumDescribe" cols="50" title="default" rows="5">简介</textarea></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
			</tr>
			<tr bgcolor="#E4E4E4">
				<td colspan="2" height="40" align="right" style="text-indent: 1em;">
					<input type="button" name="test" value="确定" style="width:80px;" onclick="ensure()"/>&nbsp;&nbsp;
					<input type="button" name="test" value="返回" onclick="javascript:location.href='storySongList.jsp'" style="width:80px;"/>
				</td>
			</tr>
	</table>
</form>
</body>
</html>
