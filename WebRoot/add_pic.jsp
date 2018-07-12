<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>选择图片</title>
</head>
<body>
<br>选择商品图片
    <s:form  method="post" enctype="multipart/form-data" action="addPic">
        <s:hidden key="f.furniture_id" value="%{f.furniture_id}" />
        <s:hidden key="f.uid" value="%{f.uid}"/>
        <s:file name="image"/>
     <s:submit value="提交"/>
    </s:form>
    
</body>
</html>