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
<sj:head/>
<s:actionerror/>
  </head>
  
  <body>
	    <s:form  action="count_fee" method ="post">
	       <s:textfield name = "order.username" value="%{order.username}" label="用户名"/>
	       <s:textfield name = "order.shoper" value="%{order.shoper}" label="商店id"/>
	       <s:textfield name = "name" value="%{name} " label="商品名"/>
	       <s:hidden name = "order.furniture_id" value="%{order.furniture_id}"/>
	       <s:textfield name = "order.count" label="请输入购买数量"/>
	       <sj:datepicker value="today" id="date" name="order.paydate" key="date" displayFormat="%{getText('format.date.input')}"
	   changeMonth="true" changeYear="true"/>
	       <s:submit value="确认并提交订单"/>
	    </s:form>
    
  </body>
</html>

