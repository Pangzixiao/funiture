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
    <table style="border:1px solid green"><tr><td>分类<td>修改内容<td>查看风格<td>查看品牌
    <s:iterator value="list" var="row">
    <tr>
      <td><s:property value="#row.c_name"/>
      <td>
      <s:url var="updateUrl" action="findType">
         <s:param name="type.c_id" value="#row.getC_id()"/>
      </s:url>
      <a href="${updateUrl}">修改内容</a>
    </td>
    
    <td>
      <s:url var="showFormsUrl" action="showFormsByid">
         <s:param name="forms.c_id" value="#row.getC_id()"/>
      </s:url>
      <a href="${showFormsUrl}">查看风格</a>
    </td>
    
    <td>
      <s:url var="showBrandUrl" action="showBrandByid">
         <s:param name="brand.c_id" value="#row.getC_id()"/>
      </s:url>
      <a href="${showBrandUrl}">查看品牌</a>
    </td>
    
    
    </tr>
    </s:iterator>
  </body>
</html>

