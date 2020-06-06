<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style type="text/css">
   #image{
   border: 2px black solid;
   }
   
</style>
<title>LegalOfficerPage3</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>
<body>
<script type="text/javascript">
    function formValidation(){
	    var name=document.getElementById("name").value;
		if(name.length<2){
		    document.getElementById("message1").style.color="red";
		    document.getElementById("message1").innerHTML="invalid input";
		}
		else{
		    document.getElementById("message1").style.color="green";
		    document.getElementById("message1").innerHTML="<strong>valid</strong>";
		}
	}
    
    function appValidation(){
	    var app=document.getElementById("app").value;
		var r=/^\d{3}-\d{3}-\d{4}$/;
		if(r.test(app)){
		    document.getElementById("message2").style.color="green";
		    document.getElementById("message2").innerHTML="<strong>valid</strong>";
		}
		else{
		    document.getElementById("message2").style.color="red";
		    document.getElementById("message2").innerHTML="<strong>please use the XXX-XXX-XXXX format</strong>";
		}
	}
</script>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
<div class="container">
  <a class="navbar-brand" href="#">Bank X</a>
  <a class="navbar-brand" href="#">Legal Officer</a>
</div>
</nav>

<div class="container">
<h4>Applicant Details</h4>
<p>Name: Manaswini Mahala</p>
<p>Application Number: 000-000-0000</p>
<p>Email: manaswini.mahala@gmail.com</p>
<br>
<img src="167749846d74ab501bf9d6f865407d0d.png" id="image">
<br>


<h4>Please Fill the Details before submitting your response </h4>
<table align="center" border="0">
    <tr>
	<td >Name of Applicant:</td>
	<td><input id="name" type="text" onblur="formValidation();" placeholder="John Doe"/><span id="message1"/></td>
	</tr>
	
	<tr>
	<td>Application Number:</td>
	<td><input id="app"  onblur="appValidation();" placeholder="XXX-XXX-XXXX"/><span id="message2"/></td>
	</tr>
	
	<tr>
	<td> 
          <input type="radio" name="view" value="accepted" id="rb1" />Accept <br />
          <input type="radio" name="view" value="rejected" id="rb2"/>Reject <br /> 

    </td>
    </tr>
	
	<br>

</table>

<a href="fe4.jsp"> <button type="button" class="btn btn-outline-primary">Submit</button></a>


</div>

</body>
</html>