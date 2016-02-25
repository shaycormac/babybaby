<!--中文编码设置-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<title>编辑作业信息</title>
<link rel=stylesheet href="/babyplan/css/demo.css" type="text/css">
</head>
<script type="text/javascript">
function ensure() {
	var oForm = document.getElementsByName("frmAction")[0];
	oForm.action = "/babyplan";
	oForm.submit();
}
</script>
<body  topmargin="10" leftmargin="10"  >
<form name="frmAction"  method="post" action="" >
	<table width="95%" border="0" cellpadding="3" cellspacing="1" class="toolBar" align="center">
      		<tr align=left class="colom">
			<td colspan="2" align="center" height="35" style="font-size:16px;"><b>编辑作业信息</b></td>
		</tr>
		<tr bgcolor='#ffffff'>
			<td width='100' align='right' nowrap class='even'>标题&nbsp;</td>
			<td ><input type="text" name="hwTitle" value="完成鸡蛋壳贴图"></td>
		</tr>
		<tr bgcolor='#ffffff'>
			<td width='100' align='right' nowrap class='even'>类型&nbsp;</td>
			<td ><img src="/babyplan/img/homework/t1.png" name="hwType" width="80"></td>
		</tr>
		<tr bgcolor='#ffffff'>
			<td width='100' align='right' nowrap class='even'>说明&nbsp;</td>
			<td ><textarea cols=30 rows=5 name="hwExplain" >在爸爸妈妈的帮助下，完成鸡蛋壳贴图</textarea></td>
		</tr>
		<tr bgcolor='#ffffff'>
			<td width='100' align='right' nowrap class='even'>内容&nbsp;</td>
			<td ><img src="/babyplan/img/homework/p1.png" name="hwPicture" width="80"></td>
		</tr>
		<tr bgcolor='#ffffff'>
			<td width='100' align='right' nowrap class='even'>发布时间&nbsp;</td>
			<td ><input type="text" name="hwPublishTime" value="2016-02-02"></td>
		</tr>
		<tr bgcolor='#ffffff'>
			<td width='100' align='right' nowrap class='even'>截止时间&nbsp;</td>
			<td ><input type="text" name="hwEndTime" value="2016-02-07"></td>
		</tr>
		<tr >
		   	<td  height=35 colspan="2" >
		   		<input class="input" type="button" value="确定" onclick="ensure()">
				<input class="input" type="button" value="返回" onclick="javascript:location.href='homeworkList.jsp'" >
		   </td>
		</tr>        
	</table>
</form>
<iframe name='hideFrame' style="display:none"></iframe>
</body>
</html>
