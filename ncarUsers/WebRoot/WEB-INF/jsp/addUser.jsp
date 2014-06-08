<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page language="java"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<title>NCAR New User Registration</title>
<script language="JavaScript" src="js/addUserAjax.js"></script>
</head>
<body>
<h1>NCAR New User Registration</h1>
<form:form commandName="addUserForm" method="post" action="flow.htm">
	<input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}">
	<table>
	<tr>
		<td>Username:</td>
		<td align="left">
			<form:input path="user.userName" id="userName" onblur="validateUsername();" />
		</td>
	</tr>
	<tr>
		<td>Password:</td>
		<td align="left">
			<form:input path="user.password" id="password" />
		</td>
	</tr>
	<tr>
	   <td>	&nbsp;	</td>
	</tr>
	<tr>
		<td>First Name:</td>
		<td align="left">
			<form:input path="user.firstName" id="email" />
		</td>
	</tr>
	<tr>
		<td>Last Name:</td>
		<td align="left">
			<form:input path="user.lastName" id="email" />
		</td>
	</tr>
	<tr>
		<td>Email:</td>
		<td align="left">
			<form:input path="user.email" id="email" />
		</td>
	</tr>
    <tr>
        <td>Lab:</td>
		<td align="left">
		  <form:select id="lab" path="user.lab" onclick="updateDivisions();">
		      <form:option value="0" label="--Please Select--" />
		      <form:options items="${addUserForm.labs}" itemValue="ID"
					itemLabel="name" />
		  </form:select>
		</td>
	</tr>
	<tr>
		<td>Division:</td>
		<td align="left">
			<form:select id="division" path="user.division" disabled="true">
			</form:select>
		</td>
	</tr>
    <tr>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<input type="submit" name="_eventId_submit" value="Submit">
		</td>
	</tr>
	</table>
	</form:form>
</body>
</html>
