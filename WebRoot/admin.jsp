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
  <s:debug/>
  <p>管理员登录成功</p><br>
  <p>数据无价，请尽量不要修改数据。</p><br>
  <a href="showTypes">显示所有分类</a>
  <a href="addFormsForType">添加风格</a>
  <a href="addBrandForType">添加品牌</a>
  <a href="exit">退出</a>
  </body>
</html>

