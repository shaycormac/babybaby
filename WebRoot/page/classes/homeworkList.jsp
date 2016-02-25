<!--中文编码设置-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>家长信息列表</title>
<link rel=stylesheet href="/babyplan/css/demo.css" type="text/css">
<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache">
<META HTTP-EQUIV="Expires" CONTENT="0">
</head>
<script src="/babyplan/easyui/jquery-1.11.1.js"></script>
<script type="text/javascript">
	function selectAll() {
		var chkAll = document.getElementsByName("chkAll")[0];
		var chk = document.getElementsByName("chkhomework");
		for (var i = 0; i < chk.length; i++) {
			chk[i].checked = chkAll.checked;
		}
	}
	function add() {
		var oForm = document.getElementsByName("frmAction")[0];
		oForm.action = "/babyplan/page/classes/homeworkAdd.jsp";
		oForm.submit();
	}
	function edit() {
		var oForm = document.getElementsByName("frmAction")[0];
		oForm.action = "/babyplan/page/classes/homeworkEdit.jsp";
		oForm.submit();
	}
</script>
<script type="text/javascript">
$(document).ready(function(){
	$("#batch").click(function(){
		$("[name=show]").css("display","block");
		$("#chkoperation").css("display","block");
		$("#batch2").css("display","none");
	});
});
$(document).ready(function(){
	$("#more").click(function(){
		$("#show").toggle();
	});
});
</script>
<body topmargin="10" leftmargin="10">
	<form name="frmAction" method="post" action="">
	<table width="90%" border="0" cellpadding="3" cellspacing="1" align="center" id="chkoperation"
		style="display:none;">
			<tr>
				<td>
				<input type="checkBox" name="chkAll" onClick="selectAll()" />全选&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="button" onclick="dels()" value="删除" style="width: 80px;">&nbsp;&nbsp;
				<input type="button" onclick="javascript:location.href='homeworkList.jsp'" value="返回" style="width: 80px;">
				</td>
			</tr>
		</table>
		<table >
		<tr id="batch2"·>
			<td height="80" style="padding-left:60px;">
				<input type="button" value="添加" onclick="add()">&nbsp;&nbsp;
				<input type="button" id="batch" value="批量删除" style="width:80px;">&nbsp;&nbsp;
			</td>
		</tr>
	</table>
	<table width="90%"  align="center">
		<tr>
			<td width="5" name="show" style="display:none"><input type="checkbox"  name="chkhomework" ></td>
			<td>
				<ul>
					<li><a href="/babyplan/page/classes/homeworkEdit.jsp">在爸爸妈妈的帮助下，完成鸡蛋壳贴图</a></li>
				</ul>
			</td>
		</tr>
		<tr>
			<td width="5" name="show" style="display:none"><input type="checkbox"  name="chkhomework" ></td>
			<td>
				<ul>
					<li><a href="/babyplan/page/classes/homeworkEdit.jsp">宝爸宝妈们，和小朋友一起来跳踢踏舞吧！！</a></li>
				</ul>
			</td>
		</tr>
	</table>
		<table width='90%' class="tex004" align="center"  style="padding-top:10px;">
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

