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
    <s:debug/>
    <p>分类：&nbsp&nbsp&nbsp
    <s:iterator value="types" var="type">
      
      <s:url var="selectTypesUrl" action="selectByType">
         <s:param name="type.c_id" value="#type.getC_id()"/>
         <s:param name="type.c_name" value="#type.getC_name()"/>
      </s:url>
      <a href="${selectTypesUrl}"><s:property value="#type.c_name"/></a>&nbsp
    
    </s:iterator>
    <br>
    <p>风格：&nbsp&nbsp&nbsp
    <s:iterator value="forms" var="form">
      
      <s:url var="selectFormsUrl" action="selectByForm">
         <s:param name="form_string" value="#form"/>
      </s:url>
      <a href="${selectFormsUrl}"><s:property value="#form"/></a>&nbsp
    
    </s:iterator>
    <br>
    <p>品牌：&nbsp&nbsp&nbsp
    <s:iterator value="brands" var="brand">
      
      <s:url var="selectBrandUrl" action="selectByBrand">
         <s:param name="brand_string" value="#brand"/>
      </s:url>
      <a href="${selectBrandUrl}"><s:property value="#brand"/></a>&nbsp
    
    </s:iterator>
    <br>
    
     <p>价格区间  ： <s:url var="price1" action="selectByPrice">
         <s:param name="minprice" value="0"/>
         <s:param name="maxprice" value="999"/>
      </s:url>
      <a href="${price1}">0-999</a>&nbsp
      <s:url var="price2" action="selectByPrice">
         <s:param name="minprice" value="1000"/>
         <s:param name="maxprice" value="3999"/>
      </s:url>
      <a href="${price2}">1000-3999</a>&nbsp
      <s:url var="price3" action="selectByPrice">
         <s:param name="minprice" value="4000"/>
         <s:param name="maxprice" value="6999"/>
      </s:url>
      <a href="${price3}">4000-6999</a>&nbsp
      <s:url var="price4" action="selectByPrice">
         <s:param name="minprice" value="7000"/>
         <s:param name="maxprice" value="9999"/>
      </s:url>
      <a href="${price4}">7000-9999</a>&nbsp
      <div>
      <s:form action="selectByPrice" method="post">
      <s:textfield size="7" name="minprice" lable="low"/><s:textfield size="7" name="maxprice" lable="up"/>
      <s:submit value="确定"/>
      </s:form></div>
      
      <br/><a href = "user.jsp"><p >返回首页</a><br/>
  </body>
</html>

