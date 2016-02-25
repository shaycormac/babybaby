<!--中文编码设置-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>教师信息列表</title>
<link rel=stylesheet href="/babyplan/css/demo.css" type="text/css">
<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache">
<META HTTP-EQUIV="Expires" CONTENT="0">
</head>
<script src="/babyplan/easyui/jquery-1.11.1.js"></script>
<script type="text/javascript">
	function selectAll() {
		var chkAll = document.getElementsByName("chkAll")[0];
		var chk = document.getElementsByName("chkTeacher");
		for (var i = 0; i < chk.length; i++) {
			chk[i].checked = chkAll.checked;
		}
	}
	function add() {
		var oForm = document.getElementsByName("frmAction")[0];
		oForm.action = "/babyplan/page/user/teacherAdd.jsp";
		oForm.submit();
	}
	function edit() {
		var oForm = document.getElementsByName("frmAction")[0];
		oForm.action = "/babyplan/page/user/teacherEdit.jsp";
		oForm.submit();
	}
</script>
<script type="text/javascript">
$(document).ready(function(){
	$("#selectText").focus(function(){
		var v=$(this).val();
		if(v==$(this).prop("defaultValue")){
			$(this).val("");
		}
	}).blur(function(){
		//当前值为空，则这个域的值设为默认值
		var v=$(this).val();
		if(v==""){
			$(this).val($(this).prop("defaultValue"));
		}
	});
});
</script>
<body topmargin="10" leftmargin="10">
	<form name="frmAction" method="post" action="add.jsp">
		<table width="99%" border="0" cellpadding="3" cellspacing="1"
			class="toolTable" align="center" height="60">
			<tr class="colom">
				<td style="padding: 30px;"><input type="text" name="name" value="请输入姓名或教师号" id="selectText">&nbsp;&nbsp;
					<input type="button" onclick="query()" value="查询" style="width: 80px;"></td>
			</tr>
		</table>
		<p></p>
		<table width="99%" border="0" cellpadding="3" cellspacing="1"
			align="center">
			<tr>
				<td>
				<input type="button" onclick="add()" value="添加" style="width: 80px;">
				<input type="button" onclick="edit()"value="修改" style="width: 80px;"> 
				<input type="button" onclick="del()" value="删除" style="width: 80px;">
				</td>
			</tr>
		</table>
		<table width="99%" border="0" cellpadding="3" cellspacing="1"
			class="toolTable" align="center">
			<!--此处为列标题-->
			<tr align="center" class="colom" height="30">
				<td><input type="checkBox" name="chkAll" onClick="selectAll()" /></td>
				<td align='center'>班级名称</td>
				<td>姓名</td>
				<td>性别</td>
				<td>出生日期</td>
				<td>联系方式</td>
				<td>毕业院校</td>
				<td>学历</td>
				<td>在校奖励</td>
				<td>专业技能评价</td>
			</tr>
			<tr class='even' height="30">
				<td align='center'><input type='checkbox' name='chkTeacher' value='1'>
				<td align=center>小牛津班</td>
				<td align=center>白骨精</td>
				<td align=center>女</td>
				<td align=center>1982-02-03</td>
				<td align=center>13995662746</td>
				<td align=center>武汉大学</td>
				<td align=center>本科</td>
				<td align=center>专业一等奖</td>
				<td align=center>英语八级</td>
			</tr>

		</table>
		<table width='99%' class="tex004" align="center">
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

