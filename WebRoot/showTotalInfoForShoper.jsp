<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
    <%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <s:debug/>
    <title>login</title>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<s:head/>
  </head>
  
  <body>
    <table width="70%" style="border:1px solid green">
    <tr>
    <td width="20%" >家具名称</td>
    <td width="10%" >单价</td>
    <td width="10%" >销售量</td>
    <td width="10%" >总销售额</td>
    </tr>
    
    <s:iterator value="list" var="row">

    <tr>
      <td width="20%" ><s:property value="#row.furniture_name"/></td>
      <td width="10%" ><s:property value="#row.price"/></td>
      <td width="10%" ><s:property value="#row.salevolume"/></td>
      <td width="10%" ><s:property value="#row.price*#row.salevolume"/></td>
    <td width="10%">
      <s:url var="showInfoUrl" action="showDetailByid">
         <s:param name="detail.detail_id" value="#row.detail_id"/>
      </s:url>
      <a href="${showInfoUrl}">查看详细信息</a>
    </td>
     <td width="10%">
    <s:url var="showCommentUrl" action="showComment">
         <s:param name="comment.furniture_id" value="#row.furniture_id"/>
         <s:param name="comment.shoper" value="#row.uid"/>
      </s:url>
      <a href="${showCommentUrl}">显示评论</a>
    </td>
    </tr>
    </s:iterator>
    </table> 
  </body>
</html>

