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
  <table width="90%" style="border:1px solid green">
    <tr><td width="10%">user</td><td width="80%">comment</td></tr>
    <s:iterator value="comments" var="row">
    <tr>
      <td width="10%"><s:property value="#row.user"/></td>
      <td width="80%"><s:property value="#row.comment"/></td>
    </tr>
    </s:iterator>
    </table>
  </body>
</html>

