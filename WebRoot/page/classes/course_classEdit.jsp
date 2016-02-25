<!--中文编码设置-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<title>修改课程信息</title>
<link rel=stylesheet href="/babyplan/css/demo.css" type="text/css">
</head>
<script src='/babyplan/common/date/date.js'></script>
<script type="text/javascript">

</script>

<body  topmargin="10" leftmargin="10"  >
<form name="frmAction"  method="post" action="" >
	<table width="95%" border="0" cellpadding="3" cellspacing="1" class="toolBar" align="center">
      		<tr align=left class="colom">
			<td colspan="2" align="center" height="35" style="font-size:16px;"><b>修改课程信息</b></td>
		</tr>
		<tr bgcolor='#ffffff'>
			<td width='100' align='right' nowrap >班级名称&nbsp;</td>
			<td ><input type="text" name="classNumber" value="小牛津班"></td>
		</tr>
		<tr bgcolor='#ffffff'>
			<td width='100' align='right' nowrap >课程名&nbsp;</td>
			<td ><input type="text" name="courseName"  value="数学"></td>
		</tr>
		<tr bgcolor='#ffffff'>
			<td width='100' align='right' nowrap >星期几&nbsp;</td>
			<td ><input type="text" name="weekDay" value="星期一" ></td>
		</tr>
		<tr bgcolor='#ffffff'>
			<td width='100' align='right' nowrap >第几节&nbsp;</td>
			<td ><input type="text" name="dayNumber" value="第一节" ></td>
		</tr>
		<tr >
		   	<td  height=35 colspan="2" >
	   			<input class="input" type="button" value="确定" onclick="ensure()" >
				<input class="input" type="button" value="返回" onclick="javascript:location.href='course_classList.jsp'" >
		   </td>
		</tr>        
	</table>
</form>
<iframe name='hideFrame' style="display:none"></iframe>
</body>
</html>
