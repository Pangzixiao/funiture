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
  <s:debug/>
  <body>
    <s:form action="add_form" method ="post">
       <s:select name ="forms.c_id" list="%{types}"  listKey="c_id" listValue="c_name" label="分类"></s:select>
       <s:textfield key="forms.form_name" label="风格名"/><br>
       <s:submit/>
    </s:form>
    
  </body>
</html>

