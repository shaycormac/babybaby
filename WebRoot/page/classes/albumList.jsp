<!--中文编码设置-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<title>班级相册列表</title>
<link rel=stylesheet href="/babyplan/css/demo.css" type="text/css">
<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache">
<META HTTP-EQUIV="Expires" CONTENT="0">
</head>
<script type="text/javascript">
function selectAll(){
	var chkAll=document.getElementsByName("chkAll")[0];
	var chk=document.getElementsByName("chkalbum");
	for(var i=0;i<chk.length;i++){
		chk[i].checked=chkAll.checked;
	}
}
function add(){
	var oForm=document.getElementsByName("frmAction")[0];
	oForm.action="/babyplan/page/classes/albumAdd.jsp";
	oForm.submit();
}
function show(){
	var oForm=document.getElementsByName("frmAction")[0];
	oForm.action="/babyplan/page/classes/photoList.jsp";
	oForm.submit();
}
function upload(){
	var oForm=document.getElementsByName("frmAction")[0];
	oForm.action="/babyplan/page/classes/photoAdd.jsp";
	oForm.submit();
}
</script>

<body style="background-color:#F8F8F8">
<form name="frmAction"  method="post" action="" >
	<table>
		<tr>
			<td height="80" style="padding-left:30px;">
				<input type="button" value="上传照片" onclick="upload()">
				<input type="button" onclick="add()" value="创建相册" style="width:80px;">
			</td>
		</tr>
		<tr>
			<td>
				<div id="photo" onclick="show()" style="width:160px;height:190px;background-color:#FFFFFF;
				margin-left:20px;float: left;">
					<div style="width:140px;height:140px;
					background-image: url(/babyplan/img/album/8.jpg);background-size:cover;margin:10px;">
						<div style="font-size: 30px;color: white;padding-top: 105px;float:right">250</div>
					</div>
					<div style="width:140px;margin: 10px;"> 
						六一儿童节
					</div>
				</div>
				<div style="width:160px;height:190px;background-color:#FFFFFF;
				margin-left:20px;float: left;">
					<div style="width:140px;height:140px;
					background-image: url(/babyplan/img/album/8.jpg);background-size:cover;margin:10px;">
						<div style="font-size: 30px;color: white;padding-top: 105px;float:right">250</div>
					</div>
					<div style="width:140px;margin: 10px;"> 
						六一儿童节
					</div>
				</div>
			</td>
		</tr>
	</table>
	<table width='95%' class="tex004" align="center">
			<tr>
				<td align='left'><a href='/studentweb/ListStudent?curPage=1'><span>首页</span></a>
					<c:if test="${page>1}">
						<a href='/studentweb/ListStudent?curPage=${page-1}'><span>上一页</span></a>
					</c:if> <c:if test="${page<pages}">
						<a href='/studentweb/ListStudent?curPage=${page+1}'><span>下一页</span></a>
					</c:if> <a href='/studentweb/ListStudent?curPage=${pages}'>尾页</a></td>
				<td>到第&nbsp;<input type="text" name="curPage"
					style="width: 30px;">&nbsp;页&nbsp;<input type="button" name="goPage" value="go">
				</td>
				<td align='left'>共<c:out value="${count}"></c:out>项&nbsp;&nbsp;<c:out
						value="${pages}"></c:out>页
				</td>
			</tr>
		</table>
</form>
</body>
</html>

