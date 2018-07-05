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
<s:debug/>
  </head>
  
  <body>
    <s:form action="add_detail" method ="post">
       <s:hidden name="detail.detail_id"  value="%{furniture.detail_id}"/><br>
       <s:select name="detail.brand" list="%{brands}"  listKey="brand_name" listValue="brand_name" label="品牌" /><br>
       <s:select name="detail.form" list="%{forms}"  listKey="form_name" listValue="form_name" label="风格" /><br> 
       <sjr:ckeditor id="richTextEditor" name="detail.introduce" label="简介" rows="10" cols="80"
		width="730" height="250" value=""/>
       <s:submit value="添加"/>
    </s:form> 
    
  </body>
</html>

