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
    <table style="border:1px solid green"><tr><td>funitureName<td>price<td>salevolume<td>select</tr>
    
    <s:iterator value="list" var="row">

    <tr>
      <td><s:property value="#row.furniture_name"/>
      <td><s:property value="#row.price"/>
      <td><s:property value="#row.salevolume"/>
      <td><s:property value="#row.furniture_id"/>
      <td><s:property value="#row.uid"/>
    
    <td>
      <s:url var="showInfoUrl" action="showDetailByid">
         <s:param name="detail.detail_id" value="#row.detail_id"/>
      </s:url>
      <a href="${showInfoUrl}">查看详细信息</a>
    </td>
     <td>
    <s:url var="showCommentUrl" action="showComment">
         <s:param name="comment.furniture_id" value="#row.furniture_id"/>
         <s:param name="comment.shoper" value="#row.uid"/>
      </s:url>
      <a href="${showCommentUrl}">显示评论</a>
    </td>
    
    <td>
    <s:url var="removeFromCarUrl" action="removeFromCar">
         <s:param name="id" value="#row.furniture_id"/>
         <s:param name="car_furniture.shoper" value="#row.uid"/>
      </s:url>
      <a href="${removeFromCarUrl}">从购物车中移除</a>
    </td>
    
    <td>
    <s:url var="payUrl" action="pay">
         <s:param name="order.furniture_id" value="#row.furniture_id"/>
         <s:param name="name" value="#row.furniture_name"/>
         <s:param name="order.shoper" value="#row.uid"/>
      </s:url>
      <a href="${payUrl}">购买</a>
    </td>
    
    <td>
    <s:url var="showPicUrl" action="">
         <s:param name="comment.furniture_id" value="#row.furniture_id"/>
         <s:param name="comment.shoper" value="row.uid"/>
      </s:url>
      <a href="${showCommentUrl}">查看图片</a>
    </td>
    </tr>
    </s:iterator>
    
    
  </body>
</html>

