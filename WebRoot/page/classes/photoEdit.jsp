<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编辑照片信息</title>
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
	<table width="50%" align="center" bgcolor="#F8F8F8">
			<tr bgcolor="#E4E4E4">
				<td height="40" style="text-indent: 1em;"><b>编辑照片信息</b></td>
			</tr>
			<tr>
				<td style="text-indent: 2em;padding-top: 20px;">已选择10张</td>
			</tr>
			<tr>
				<td style="padding-left: 2em;padding-top: 20px;">
					<input type="text" name="albumName" title="default" value="编辑名称" style="width:445px;"></td>
			</tr>
			<tr>
				<td style="padding-left: 2em;padding-top: 20px;">
					<textarea name="albumDescribe" cols="53" title="default" rows="5">描述照片</textarea></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td colspan="2" height="40" align="right" style="padding-top: 20px;padding-right: 45px;">
					<input type="button" name="test" value="确定" onclick="ensure()"/>&nbsp;&nbsp;
					<input type="button" name="test" value="返回"  onclick="javascript:location.href='photoList.jsp'"/>
				</td>
			</tr>
	</table>
</form>
</body>
</html>