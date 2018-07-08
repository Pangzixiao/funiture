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
  <table width="85%" style="border:1px solid green">
    <tr>
    <td width="5%">订单号</td>
    <td width="20%">家具名称</td>
    <td width="10%">购买数量</td>
    <td width="10%">单价</td>
    <td width="10%">交易额</td>
    <td width="10%">交易日期</td>
    <td width="10%">详细信息</td>
    <td width="10%">显示评论</td>
    </tr>
    <s:iterator value="reports" var="row">
    <tr>
      <td width="5%"><s:property value="#row.order_id"/></td>
      <td width="20%"><s:property value="#row.furniture_name"/></td>
      <td width="10%"><s:property value="#row.count"/></td>
      <td width="10%"><s:property value="#row.price"/></td>
      <td width="10%"><s:property value="#row.cost"/></td>
      <td width="10%"><s:property value="#row.paydate"/></td>
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

