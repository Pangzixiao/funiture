<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
    <%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sjr" uri="/struts-jquery-richtext-tags"%>
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
    <s:form action="Login" method ="post">
       <s:textfield key="user.uid" label="用户名"/><br>
       <s:password key="user.pass" label="密码"/><br>
       <s:radio list="#{'0':'管理员','1':'商家','2':'普通用户'}" name="type" value="2"/>
       <s:submit/>
    </s:form>
    
  </body>
</html>

