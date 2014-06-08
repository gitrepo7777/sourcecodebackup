<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html>
<head>

<LINK REL="stylesheet" TYPE="text/css" HREF="oreillyajax.css">

<title>NCAR New User Registration</title>
<script language="JavaScript" src="js/addUserAjax.js">
</script>
 
</head>
<body>
<h1>Signup Confirmation</h1>

You have successfully signed up as a user. <br />

<form:form commandName="addUserForm" method="post" action="flow.htm">
    <input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}"/>
    <input type="submit" name="_eventId_addNewUser" value="Add New User"/>
</form:form>
</body>
</html>
