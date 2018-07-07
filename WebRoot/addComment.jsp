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
    <s:form  action="addComment" method ="post">
       <s:hidden key = "comment.shoper" value="%{comment.shoper} "/>
       <s:hidden key = "comment.furniture_id" value="%{comment.furniture_id}" />
       <s:hidden key = "comment.user" value="%{comment.user}" />
       <sjr:ckeditor id="richTextEditor" name="comment.comment" label="评论" rows="10" cols="80"
		width="730" height="250" value=""/>
       <s:submit value="添加"/>
    </s:form>
  </body>
</html>

