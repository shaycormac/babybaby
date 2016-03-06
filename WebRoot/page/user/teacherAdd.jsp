<!--中文编码设置-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<title>新增教师信息</title>
<link rel=stylesheet href="/babyplan/css/demo.css" type="text/css">
</head>
<script src='/babyplan/common/date/date.js'></script>
<script type="text/javascript">
function ensure() 
{
	var oForm = document.getElementsByName("frmAction")[0];
	var teacherNumber = document.getElementsByName("teacherNumber")[0].value;
	var teacherPwd = document.getElementsByName("teacherPwd")[0].value;
	var classNumber= document.getElementsByName("classNumber")[0].value;
	var teacherName = document.getElementsByName("teacherName")[0].value;
	var teacherHeader = document.getElementsByName("teacherHeader")[0].value;
	var teacherBirthday = document.getElementsByName("teacherBirthday")[0].value;
	var teacherTelePhone= document.getElementsByName("teacherTelePhone")[0].value;
	var rewardShow = document.getElementsByName("rewardShow")[0].value;
	if(teacherBirthday && teacherHeader && teacherName && teacherNumber && teacherPwd && teacherTelePhone)
		{
	oForm.action = "/babyplan/TeacherAddServlet";
	oForm.submit();
		}
	else {
		alert("请尽可能的完善资料，求你了！！");
	}
}
</script>

<body  topmargin="10" leftmargin="10"  >
<form name="frmAction"  method="post" action="" enctype="multipart/form-data">
	<table width="95%" border="0" cellpadding="3" cellspacing="1" class="toolBar" align="center">
      		<tr align=left class="colom">
			<td colspan="2" align="center" height="35" style="font-size:16px;"><b>新增教师信息</b></td>
		</tr>
		<tr bgcolor='#ffffff'>
			<td width='100' align='right' nowrap class='even'>教师号&nbsp;</td>
			<td ><input type="text" name="teacherNumber" ></td>
		</tr>
		<tr bgcolor='#ffffff'>
			<td width='100' align='right' nowrap class='even'>密码&nbsp;</td>
			<td ><input type="text" name="teacherPwd" ></td>
		</tr>
		<tr bgcolor='#ffffff'>
			<td width='100' align='right' nowrap class='even'>权限&nbsp;</td>
			<td >
				<select name="power" style="width:50px;">
					<option value="0">0</option>
					<option value="1" selected>1</option>
				</select>
			</td>
		</tr>
		<tr bgcolor='#ffffff'>
			<td width='100' align='right' nowrap class='even'>班级号&nbsp;</td>
			<td ><input type="text" name="classNumber" ></td>
		</tr>
		<tr bgcolor='#ffffff'>
			<td width='100' align='right' nowrap class='even'>姓名&nbsp;</td>
			<td ><input type="text" name="teacherName" ></td>
		</tr>
		<tr bgcolor='#ffffff'>
			<td width='100' align='right' nowrap class='even'>性别&nbsp;</td>
			<td ><input type="radio" checked value="男" name="teacherSex" >男
				<input type="radio" value="女" name="teacherSex" >女</td>
		</tr>
		<tr bgcolor='#ffffff'>
			<td width='100' align='right' nowrap class='even'>头像&nbsp;</td>
			<td ><input type="file" name="teacherHeader" ></td>
		</tr>
		
		<tr bgcolor='#ffffff'>
			<td width='100' align='right' nowrap class='even'>出生日期&nbsp;</td>
			<td >
				<input type="text" name="teacherBirthday"  value="2016-01-01" >
				<INPUT type='button' value='选择日期'
				onclick=javascript:document.all['teacherBirthday'].value=selectDate()></td>
		</tr>
		<tr bgcolor='#ffffff'>
			<td width='100' align='right' nowrap class='even'>联系方式&nbsp;</td>
			<td ><input type="text" name="teacherTelePhone" ></td>
		</tr>
		<tr bgcolor='#ffffff'>
			<td width='100' align='right' nowrap class='even'>毕业院校&nbsp;</td>
			<td ><input type="text" name="graduateSchool" ></td>
		</tr>
		<tr bgcolor='#ffffff'>
			<td width='100' align='right' nowrap class='even'>学历&nbsp;</td>
			<td ><input type="text" name="degree" ></td>
		</tr>
		<tr bgcolor='#ffffff'>
			<td width='100' align='right' nowrap class='even'>专业&nbsp;</td>
			<td ><input type="text" name="specialty" ></td>
		</tr>
		<tr bgcolor='#ffffff'>
			<td width='100' align='right' nowrap class='even'>在校奖励&nbsp;</td>
			<td ><input type="text" name="reward" ></td>
		</tr>
		<tr bgcolor='#ffffff'>
			<td width='100' align='right' nowrap class='even'>证书展示&nbsp;</td>
			<td ><input type="file" name="rewardShow" ></td>
		</tr>
		<tr bgcolor='#ffffff'>
			<td width='100' align='right' nowrap class='even'>专业技能评价&nbsp;</td>
			<td ><textarea cols=30 rows=5 name="evaluate" ></textarea>
			</td>
		</tr>

		<tr >
		   	<td  height=35 colspan="2" >
	   			<input class="input" type="button" value="确定" onclick="ensure()" >
				<input class="input" type="button" value="返回" onclick="location.href='/babyplan/TeacherListServlet'" >
		   </td>
		</tr>        
	</table>
</form>
<iframe name='hideFrame' style="display:none"></iframe>
</body>
</html>
