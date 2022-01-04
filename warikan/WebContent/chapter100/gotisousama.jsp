<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="style.css">
	<title>割り勘-四捨五入サイト</title>
</head>

<body>
<div class="main">
	<div>
		<h1>わりかん計算</h1>
	</div>
	<div>
		<img src="dentaku.png" class="dentaku">
	</div>

	<form action="Calc" method="get" >

	<div>
		<table class="table-in">
			<tr>
				<th>合計金額</th>
				<td><input type="text" name="total" size="7" maxlength="6"> 円</td>
			</tr>
			<tr>
				<th>人数</th>
				<td><input type="number" name="count" size="7" min="2" max="99"> 人</td>
			</tr>
			<tr>
				<th>カンパ額</th>
					<td><input type="text" name="kanpa" size="7" maxlength="6" value ="0"> 円</td>
			</tr>
			<tr>
				<th>端数処理(四捨五入)</th>
				<td>
					 <label>
						<input type="radio" name="round" value="small" checked> 10円単位
					</label>
				</td>
				<td>
					<label>
						<input type="radio" name="round" value="big"> 100円単位
					 </label>
				</td>
			</tr>
		</table>
	</div>
	<div>
		<button class="button1" type="submit" name="start">スタート</button>
		<button class="button2" type="reset" name="cancel">リセット</button>
	</div>
</form>
	<div class="memo">
		<p>端数を払う人・もらう人はランダムで表示されます</p>
	</div>
</div>
<hr>
<div class="footer">
	<p>© 2021 shimbayashi</p>
</div>

<%@include file="../footer.html" %>