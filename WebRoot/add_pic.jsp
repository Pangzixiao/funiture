<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>文件上传</title>
</head>
<body>
<br>文件上传
    <s:form  method="post" enctype="multipart/form-data" action="addPic">
        <s:textfield key="f.furniture_id" value="%{f.furniture_id}" />
        <s:textfield key="f.uid" value="%{f.uid}"/>
        <s:file name="image"/>
     <s:submit/>
    </s:form>
    
</body>
</html>