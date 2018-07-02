<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
    <%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
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
    <table style="border:1px solid green"><tr><td>forms_name
    <s:iterator value="list" var="row">
    <tr>
      <td><s:property value="#row.c_id"/>
      <td><s:property value="#row.form_name"/>
    
    <td>
      <s:url var="delFormUrl" action="del_form">
         <s:param name="forms.c_d" value="#row.c_id"/>
         <s:param name="forms.form_name" value="#row.form_name"/>
      </s:url>
      <a href="${delFormUrl}">删除</a>
    </td>
    </tr>
    </s:iterator>
    
    <s:url var="addFormUrl" action="find_form">
         <s:param name="forms.c_d" value="#row.c_id"/>
         <s:param name="forms.form_name" value="row.form_name"/>
      </s:url>
      <a href="${addFormUrl}">添加</a>
  </body>
</html>

