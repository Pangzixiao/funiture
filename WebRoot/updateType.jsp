<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    
    <title>login</title>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<s:head/>
  </head>
  
  <body>
    <s:form action="updateType" method ="post">
       <s:hidden key = "type.c_id"/>
       <s:textfield key="type.c_name" label="更改后的分类名"/><br>
       <s:submit/>
    </s:form>
    
  </body>
</html>

