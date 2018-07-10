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
    <table width="80%" style="border:1px solid green">
    <tr>
    <td width="5%">商家</td>
    <td width="10%">家具名称</td>
    <td width="5%">价格</td>
    <td width="10%">销售量</td>
    <td width="10%">详细信息</td>
    <td width="10%">显示评论</td>
    <td width="10%">从购物车中移除</td>
    <td width="10%">购买</td>
    <td width="10%">查看图片</td>
    </tr>
    <s:iterator value="list" var="row">

    <tr>
      <td width="5%"><s:property value="#row.uid"/></td>
      <td width="10%"><s:property value="#row.furniture_name"/></td>
      <td width="5%"><s:property value="#row.price"/></td>
      <td width="10%"><s:property value="#row.salevolume"/></td>

    
    <td width="10%">
      <s:url var="showInfoUrl" action="showDetailByid">
         <s:param name="detail.detail_id" value="#row.detail_id"/>
      </s:url>
      <a href="${showInfoUrl}">详细信息</a>
    </td>
     <td width="10%">
    <s:url var="showCommentUrl" action="showComment">
         <s:param name="comment.furniture_id" value="#row.furniture_id"/>
         <s:param name="comment.shoper" value="#row.uid"/>
      </s:url>
      <a href="${showCommentUrl}">显示评论</a>
    </td>
    
    <td width="10%">
    <s:url var="removeFromCarUrl" action="removeFromCar">
         <s:param name="id" value="#row.furniture_id"/>
         <s:param name="car_furniture.shoper" value="#row.uid"/>
      </s:url>
      <a href="${removeFromCarUrl}">从购物车中移除</a>
    </td>
    
    <td width="10%">
    <s:url var="payUrl" action="pay">
         <s:param name="order.furniture_id" value="#row.furniture_id"/>
         <s:param name="name" value="#row.furniture_name"/>
         <s:param name="order.shoper" value="#row.uid"/>
      </s:url>
      <a href="${payUrl}">购买</a>
    </td>
    
    <td width="10%">
    <s:url var="showPicUrl" action="showPic">
         <s:param name="f.furniture_id" value="#row.furniture_id"/>
         <s:param name="f.uid" value="#row.uid"/>
      </s:url>
      <a href="${showPicUrl}">查看图片</a>
    </td>
    </tr>
    </s:iterator>
    
    </table>
  </body>
</html>

