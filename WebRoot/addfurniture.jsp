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
    <s:form  action="add_furniture" method ="post">
       <s:hidden key = "furniture.uid" value="%{furniture.uid} "/>
       <s:hidden key = "furniture.detail_id" value="%{furniture.detail_id}" />
       <s:textfield name="furniture.furniture_name" label="家具名称"/><br>
       <s:textfield name="furniture.furniture_id" label="家具id"/><br>
       <s:textfield name="furniture.price" label="价格"/><br>
       <s:select name="furniture.type" list="%{types}"  listKey="c_name" listValue="c_name" label="所属分类" /><br> 
       <s:submit value="添加"/>
    </s:form>
    
  </body>
</html>

