<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2020/6/16
  Time: 14:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
//从请求作用域中得到oneServlet添加进去的集合
    List<Student> stulist =(List) request.getAttribute("key");
%>