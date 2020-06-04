<html>
<head><title>Loan Application Against Car </title></head>
<body>
<form action="ControllerServlet" method="GET">
	<input type="hidden" name="command" value="CONFIRM" /> 
	
	YOU HAVE LOGGED IN !<br>
	APPLICATION FORM
	
	Account No: <input type = "text" name = "accountNo"/><br><br>
	Loan-id: <input type = "text" name = "loan_id" /><br>
	Loan-Type <input type = "text" name = "loan_type" value="Against Car"/>
	<br/><br/>
	
	Name 
	<br>
	 &nbsp;<input type="text" name="firstName" size=15 placeholder="First Name"/>
	 &nbsp;&nbsp;&nbsp;
	 <input type="text" name="lastName" size=15 placeholder="Last Name"/>
	
	<br/><br/>
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
	<input type="radio" name ="gender" /> Male
	<input type="radio" name ="gender" /> Female
	<input type="radio" name ="gender" /> Other
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
	<br> <br>
	Occupation Details<br><br>
	Organization Name <br>
	<input type="text" name="orgname" placeholder="Name of Organization"/>
	<br><br>
	Address<br>
	<input type="text" name="orgline1" placeholder="Address Line 1" size=65/>
	<br>
	<input type="text" name="orgline2" placeholder="Address Line 2" size=65/>
	<br>
	<input type="text" name="orgcity" placeholder="City"/>
	<input type="text" name="orgstate" placeholder="State"/>
	<input type="text" name="orgpincode" placeholder="Pin Code"/>
	<br/><br/>
	Designation<br>
	<input type="text" name="designation" placeholder="Current Designation"/>
	<br><br>
	Salary<br>
	<input type="radio" name ="salary" value="2.5" /> Up to Rs 2.5Lakhs <br>
	<input type="radio" name ="salary" value="5.0"/> From Rs 2.5Lakhs to Rs 5Lakhs <br>
	<input type="radio" name ="salary" value="10.0"/> Above Rs 5 Lakhs <br>
	<br><br>
	Choose a Manufacturer <br>
	<input type="text" name="manufacturer" placeholder="manufacturer"/> <br><br>
	Select Car Model <br>
	<input type="text" name="model" placeholder="Car Model"/> <br><br>
	Date of Manufacture<br>
	<input type="date" name="manufactureDate" placeholder="dd/mm/yyyy"/>
	<br><br>
	Insurance Cover 
	<input type="radio" name="insuranceCover" value="yes"/>Yes
	<input type="radio" name="insuranceCover" value="no" />No
	<br><br>
	Loan Amount <input type="text" name="loan_amount"/> 
	Loan Time   <input type="text" name="loan_time"/>
	<br><br>
	Upload Documents<br><br>
	Registration Certificate &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Insurance Papers <br>
	<input type="file" name="registration"/>
	<input type="file" name="insurance"/><br><br>
	<button type="submit" value="Submit">Submit</button>
	
</form>
</body>
</html>