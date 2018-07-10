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
  <s:debug/>
  </head>
  
  <body>
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
    <s:iterator value="formlist" var="form">
      <s:url var="selectFormsUrl" action="selectByFormType">
         <s:param name="type.c_id" value="%{type.c_id }"/>
         <s:param name="type.c_name" value="%{type.c_name}"/>
         <s:param name="form_string" value="#form.form_name"/>
      </s:url>
      <a href="${selectFormsUrl}"><s:property value="#form.form_name"/></a>&nbsp
    
    </s:iterator>
    <br>
    <p>品牌：&nbsp&nbsp&nbsp
    <s:iterator value="brandlist" var="brand">
      
      <s:url var="selectBrandUrl" action="selectByBrandType">
      <s:param name="type.c_id" value="%{type.c_id }"/>
         <s:param name="type.c_name" value="%{type.c_name}"/>
         <s:param name="brand_string" value="#brand.brand_name"/>
      </s:url>
      <a href="${selectBrandUrl}"><s:property value="#brand.brand_name"/></a>&nbsp
    
    </s:iterator>
    
    <br>
    
    <p>价格区间  ： <s:url var="price1" action="selectByPriceType">
    <s:param name="type.c_id" value="%{type.c_id }"/>
         <s:param name="type.c_name" value="%{type.c_name}"/>
         <s:param name="minprice" value="0"/>
         <s:param name="maxprice" value="999"/>
      </s:url>
      <a href="${price1}">0-999</a>&nbsp
      <s:url var="price2" action="selectByPriceType">
      <s:param name="type.c_id" value="%{type.c_id }"/>
         <s:param name="type.c_name" value="%{type.c_name}"/>
         <s:param name="minprice" value="1000"/>
         <s:param name="maxprice" value="3999"/>
      </s:url>
      <a href="${price2}">1000-3999</a>&nbsp
      <s:url var="price3" action="selectByPriceType">
      <s:param name="type.c_id" value="%{type.c_id }"/>
         <s:param name="type.c_name" value="%{type.c_name}"/>
         <s:param name="minprice" value="4000"/>
         <s:param name="maxprice" value="6999"/>
      </s:url>
      <a href="${price3}">4000-6999</a>&nbsp
      <s:url var="price4" action="selectByPriceType">
      <s:param name="type.c_id" value="%{type.c_id }"/>
         <s:param name="type.c_name" value="%{type.c_name}"/>
         <s:param name="minprice" value="7000"/>
         <s:param name="maxprice" value="9999"/>
      </s:url>
      <a href="${price4}">7000-9999</a>&nbsp
     
      <s:form action="selectByPriceType" method="post">
      <s:hidden name="type.c_id" value="%{type.c_id }"/>
      <s:hidden name="type.c_name" value="%{type.c_name}"/>
      <s:textfield size="7" name="minprice" lable="low"/><s:textfield size="7" name="maxprice" lable="up"/>
      
      <s:submit value="确定"/>
      </s:form>
      
      <s:form action="selectForOrder" method="post">
      <s:hidden name="type.c_id" value="%{type.c_id }"/>
      <s:hidden name="type.c_name" value="%{type.c_name}"/>
      <s:radio list="#{'0':'价格递增','1':'价格递减','2':'销量递增','3':'销量递减'}" name="sort_type" value="0"/>
      <s:submit value="查询"/>
      </s:form>
    <br/><a href = "user.jsp"><p>返回首页</p></a><br/>
    <table width="90%" style="border:1px solid green">
    <tr>
    <td width="5%">商家</td>
    <td width="10%">家具名称</td>
    <td width="5%">价格</td>
    <td width="10%">销售量</td>
    <td width="10%">详细信息</td>
    <td width="10%">显示评论</td>
    <td width="10%">加入购物车</td>
    <td width="10%">收藏</td>
    <td width="10%">查看图片</td>
    </tr>
    <s:iterator value="furnitures" var="row">

    <tr>
      <td width="5%"><s:property value="#row.uid"/></td>
      <td width="10%"><s:property value="#row.furniture_name"/></td>
      <td width="5%"><s:property value="#row.price"/></td>
      <td width="10%"><s:property value="#row.salevolume"/></td>
    
    <td width="10%" >
      <s:url var="showInfoUrl" action="showDetailByid">
         <s:param name="detail.detail_id" value="#row.detail_id"/>
      </s:url>
      <a href="${showInfoUrl}">查看详细信息</a>
    </td>
    <td width="10%" >
    <s:url var="showCommentUrl" action="showComment">
         <s:param name="comment.furniture_id" value="#row.furniture_id"/>
         <s:param name="comment.shoper" value="#row.uid"/>
      </s:url>
      <a href="${showCommentUrl}">显示评论</a>
    </td>
    
    <td width="10%" >
    <s:url var="addInCarUrl" action="addInCar">
         <s:param name="id" value="#row.furniture_id"/>
         <s:param name="car_furniture.shoper" value="#row.uid"/>
      </s:url>
      <a href="${addInCarUrl}">加入购物车</a>
    </td>
    
    <td width="10%" >
    <s:url var="addInFavoriteUrl" action="addInFavorite">
         <s:param name="id" value="#row.furniture_id"/>
         <s:param name="favorite.shoper" value="#row.uid"/>
      </s:url>
      <a href="${addInFavoriteUrl}">收藏 </a>
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

