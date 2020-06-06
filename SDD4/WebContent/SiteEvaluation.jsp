<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="design2.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Site Evaluator</h1>
	<br><br>
	<center>
	<p class="evaluator">
	<form>
		Address is correct: <input type="text" name="address"><br><br><br>
		Present owner name is correct: <input type="text" name="OwnName1"><br><br><br>
		Owner does want to sell:<input type="text" name="sell"><br><br><br>
		House is in good condition:<input type="text" name="condition"><br><br><br>
		House area mentioned is correct:<input type="text" name="area"><br><br><br>
		There is no legal dispute:<input type="text" name="dispute"><br><br><br>
	</p>
	</form>
	</center>
	
	<p class="button">
	<input type=button onClick="location.href='BankManagerHP.jsp'" value='Submit site evaluation report'>
	</p>
</body>
</html>