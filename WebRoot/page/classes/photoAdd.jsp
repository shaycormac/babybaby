<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>上传照片</title>
</head>
<script type="text/javascript">
function ensure() {
	var oForm = document.getElementsByName("frmAction")[0];
	oForm.action = "/babyplan";
	oForm.submit();
}
</script>
<body>
<form name="frmAction"  method="post" action="" >
<div style="width:200px;margin-top: 200px;margin-left: 400px;">
	<table align="center">
		<tr height="50" align="left">
			<td>上传到&nbsp;&nbsp;<select name="" >
					<option value="" selected>六一儿童节</option>
				</select>
			</td>
		</tr>
		<tr align="left">
			<td><input type="file" value="选择照片" ></td>
		</tr>
		<tr>
		<td height="40">
		<input type="button" onclick="add()" value="确定" style="width:80px;">&nbsp;&nbsp;
		<input type="button" onclick="javascript:location.href='albumList.jsp'" value="返回" style="width:80px;">
		</td>
    </tr>
	</table>
</div>
</form>
</body>
</html>