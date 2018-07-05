<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
    <%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <s:debug/>
    <title></title>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<s:head/>
  </head>
  
  <body>
  <div >
  <table>
  <tr>
  <td>简介:</td>
  <td><s:property value="detail.introduce"/></td>
  </tr>
  
  <tr>
  <td>品牌:</td>
  <td><s:property value="detail.brand"/></td>
  </tr>
  
  <tr>
  <td>风格:</td>
  <td><s:property value="detail.form"/></td>
  </tr>
  </table>  
    
  </body>
</html>

