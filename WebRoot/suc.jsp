<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sjr" uri="/struts-jquery-richtext-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>login</title>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<s:head/>
<sj:head/>
  </head>
  <!-- ${pageContext.request.contextPath} tomcat部署路径，
          如：D:\apache-tomcat-6.0.18\webapps\struts2_upload\ -->
  <body>
  
  <div>
  <img src="${pageContext.request.contextPath}/<s:property value="'upload/'+path"/>" height="200" width="200"><br>
  商家名称：<s:property value="f.uid"/>
  </div>
  </body>
</html>

