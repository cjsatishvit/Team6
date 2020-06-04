<!DOCTYPE html>

<html>
<head>
	<title>Account Register</title>
</head>
<body>
<form action="ControllerServlet" method="GET">
	<input type="hidden" name="command" value="ADD"/>
	Customer Id :<input type="text" name="customerid" />
	<br><br>
	Name 
	<br>
	 &nbsp;<input type="text" name="firstName" size=15 placeholder="First Name"/>
	 &nbsp;&nbsp;&nbsp;
	 <input type="text" name="lastName" size=15 placeholder="Last Name"/>
	
	<br/><br/>
	Set a Password <br>
	<input type="password" name="pass" placeholder="PASSWORD"/><br>
	Confirm Password <br>
	<input type="password" name="confirm_pass" placeholder="CONFIRM PASSWORD"> 
	<br><br>
	Address 
	<br>
	<input type="text" name="line1" placeholder="Address Line 1" size=65/>
	<br>
	<input type="text" name="line2" placeholder="Address Line 2" size=65/>
	<br>
	<input type="text" name="city" placeholder="City"/>
	<input type="text" name="state" placeholder="State"/>
	<input type="text" name="pincode" placeholder="Pin Code"/>
	<br/><br/>
	Gender<br>
	<input type="radio" name ="gender" value="Male"/> Male
	<input type="radio" name ="gender" value="Female"/> Female
	<input type="radio" name ="gender" value="Other"/> Other
	<br><br>
	Date of Birth &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Email
	<br>
	<input type="date" name="birthday" placeholder="dd/mm/yyyy"/>
	&nbsp;&nbsp;&nbsp;
	<input type="email" name="email" placeholder="xyz@abc.rst" size=30/>
	<br><br>
	Phone Details <br>
	<input type="text" name="phone" placeholder="Primary Phone No"/>
	&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="text" name="phone2" placeholder="Secondary Phone No"/>	
	<br><br>
	<button type="submit" value="Submit">Submit</button>
</form>
</body>
</html>