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
  <b>成功</b>
  <s:url var="addCommentUrl" action="findcomment">
         <s:param name="comment.user" value="%{order.username}"/>
         <s:param name="comment.shoper" value="%{order.shoper}"/>
         <s:param name="comment.furniture_id" value="%{order.furniture_id}"/>
      </s:url>
      <a href="${addCommentUrl}">添加评论</a>&nbsp
  <a href="gettypes">返回首页</a>
  </body>
</html>

