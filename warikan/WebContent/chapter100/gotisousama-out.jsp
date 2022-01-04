<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="bean.Contents"%>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="style.css">
	<title>計算結果</title>
</head>
<body>

<% Contents c=(Contents)request.getAttribute("contents") ;%>

<%
int total = c.getTotal(); //合計金額
int count = c.getCount(); //人数
int price = c.getPrice(); //端数処理後の一人あたりの金額
int gosa = c.getGosa(); //誤差
double origin = c.getOrigin(); //一人あたりの本来額
String msg = c.getMsg();//一番～な人
String round = c.getRound();//端数処理方法
int kanpa = c.getKanpa();//カンパ額
 %>

<%--メッセージの出力 --%>
<div class="main">
	<div>
		<h2>入力内容</h2>
	</div>

	<div>
		<table>
		<tr>
			<th>合計金額</th><td><%=total %> 円</td>
		</tr>
		<tr>
			<th>人数</th><td><%=count %></td>
		</tr>
		<tr>
			<th>カンパ額</th><td><%=kanpa %> 円</td>
		</tr>
		<tr>
			<th>端数処理</th>
				<td>
						<%if(round.equals("small")) {%>
						 10円単位
						 <%} else if (round.equals("big")){%>
						100円単位
						<%}%>
				</td>
			</tr>
		</table>
	</div>

	<hr>
	<div>
		<h2>計算結果</h2>
	</div>
	<div class="result">
		<%if (gosa < 0) {%>
				全員「<%= price%>円」です。<br>
				<span>「 <%=msg %>」</span>は<br>お釣りの「<%=-gosa%>円」を受け取ってください。<br>
		<%} else if (gosa == 0) {%>
				全員「<%=price%> 」円です。<br>
		<%} else if (gosa > 0) { %>
				1人あたり「<%= price %>円」ですが、<br>
				<span>「<%=msg %>」</span>は<br>端数を含めた「<%=price + gosa%>円」を支払ってください。<br>
				ありがとうございます！<br>
		<%}%>
				<p class="memo-origin">（端数処理前：1人あたり「<%=origin %>」円）</p><br>
	</div>
	<div>
		<img src="neko.png" class="neko">
	</div>
	<div class="memo-out">
		<P>ごちそうさまでした！</P>
	</div>
</div>
<hr>
<div class="footer">
	<p>© 2021 shimbayashi</p>
</div>
<%@include file="../footer.html" %>