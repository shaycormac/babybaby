<!--中文编码设置-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<title>新增家长信息</title>
<link rel=stylesheet href="/babyplan/css/demo.css" type="text/css">
</head>
<script src='/babyplan/common/date/date.js'></script>
<script type="text/javascript">
function ensure() {
	var oForm = document.getElementsByName("frmAction")[0];
	oForm.action = "/babyplan/ParentAddServlet";
	oForm.submit();
}
</script>

<body  topmargin="10" leftmargin="10"  >
<form name="frmAction"  method="post" action="" enctype="multipart/form-data">
	<table width="95%" border="0" cellpadding="3" cellspacing="1" class="toolBar" align="center">
      		<tr align=left class="colom">
			<td colspan="2" align="center" height="35" style="font-size:16px;"><b>新增家长信息</b></td>
		</tr>
		<tr bgcolor='#ffffff'>
			<td width='100' align='right' nowrap class='even'>宝宝学号&nbsp;</td>
			<td ><input type="text" name="studentNum" ></td>
		</tr>
		<tr bgcolor='#ffffff'>
			<td width='100' align='right' nowrap class='even'>姓名&nbsp;</td>
			<td ><input type="text" name="parentName" ></td>
		</tr>
		<tr bgcolor='#ffffff'>
			<td width='100' align='right' nowrap class='even'>联系方式&nbsp;</td>
			<td ><input type="text" name="parentTelePhone" ></td>
		</tr>
		<tr bgcolor='#ffffff'>
			<td width='100' align='right' nowrap class='even'>密码&nbsp;</td>
			<td ><input type="text" name="parentPwd" ></td>
		</tr>
		<tr bgcolor='#ffffff'>
			<td width='100' align='right' nowrap class='even'>性别&nbsp;</td>
			<td ><input type="radio" checked value="男" name="parentSex" >男
				<input type="radio" value="女" name="parentSex" >女</td>
		</tr>
		<tr bgcolor='#ffffff'>
			<td width='100' align='right' nowrap class='even'>昵称&nbsp;</td>
			<td ><input type="text" name="parentNickName" ></td>
		</tr>
		<tr bgcolor='#ffffff'>
			<td width='100' align='right' nowrap class='even'>头像&nbsp;</td>
			<td ><input type="file" name="parentHeader" ></td>
		</tr>
		<tr bgcolor='#ffffff'>
			<td width='100' align='right' nowrap class='even'>背景图&nbsp;</td>
			<td ><input type="file" name="backgroundPhoto" ></td>
		</tr>
		<tr bgcolor='#ffffff'>
			<td width='100' align='right' nowrap class='even'>家庭住址&nbsp;</td>
			<td ><input type="text" name="address" ></td>
		</tr>
		<tr >
		   	<td  height=35 colspan="2" >
	   			<input class="input" type="button" value="确定" onclick="ensure()" >
				<input class="input" type="button" value="返回" onclick="location.href='/babyplan/ParentsListServlet'" >
		   </td>
		</tr>        
	</table>
</form>
	<iframe name='hideFrame' style="display:none"></iframe>
</body>
</html>
