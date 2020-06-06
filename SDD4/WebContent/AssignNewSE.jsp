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
	<h1>Bank Manager</h1>
	
	<p class="evaluator">
	Choose a site evaluator:
	<br>
	<br>
	<br>
	<input type="radio" id="e1" name="e1" >
	<label for="e1">Rakesh Sharma</label><br>
	
	<input type="radio" id="e2" name="e2" >
	<label for="e2">Raj Chakraborty</label><br>
	
	<input type="radio" id="e3" name="e3" >
	<label for="e3">Jhankar Modak</label><br>
	
	<input type="radio" id="e4" name="e4" >
	<label for="e4">Monali Thakur</label><br>
	
	<input type="radio" id="e5" name="e5" >
	<label for="e5">Harish Mitra</label><br>
	
	<input type="radio" id="e6" name="e6" >
	<label for="e6">Subhasis Bose</label><br>
	
	<input type="radio" id="e7" name="e7" >
	<label for="e7">Sukanto Basak</label><br>
	</p>
	
	<p class="site">
	Choose a site to be evaluated:
	<br>
	<br>
	<br>
	 <input type="radio" id="s1" name="s1" >
	<label for="s1">Gaur City, 12GT Road, Kolkata-700003 M:987456321</label><br>
	
	<input type="radio" id="s2" name="s2" >
	<label for="s2">72, Bagbazar Street, Kolkata-700230 M:1234567890</label><br>
	
	<input type="radio" id="s3" name="s3" >
	<label for="s3">12B, Hatibagan Main Road, Kolkata-753214 M:4561237899</label> <br>
	
	<input type="radio" id="s4" name="s4" >
	<label for="s4">12B, Janbazar Road, Kolkata-756614 M:8521479639</label> 
	</p>
	
	<p class="button">
	<input type=button onClick="location.href='AssignConfirm.jsp'" value='Assign this site to the site evaluator'>
	</p>
	
	</body>
	</html>
	
	