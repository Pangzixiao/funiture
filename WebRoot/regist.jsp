<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
 <%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
   
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<s:actionerror/>
	<s:debug/>
  </head>
  
  <body>
    <s:form action = "regist" method="post">
    <s:textfield name="uid" label="用户名"/>
    <s:password name ="pass" label="密码" />
    <s:password name="repass" label="确认密码"/>
    <s:textfield name="phone" label="手机号"/>
    <s:radio list="#{'0':'商家','1':'普通用户'}" name="type" value="1"/>     
     <s:submit/>
    </s:form>
  </body>
</html>
