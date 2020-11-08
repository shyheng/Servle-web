<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/30
  Time: 10:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    int age =15;
%>

<%
    if(age >=18){
%>
      <font style="color:red;font-size:45px">热烈欢迎</font>
<%
    }else{
%>
       <font style="color:red;font-size:45px">谢绝入内</font>
<%
    }
%>
<!--
   {
          int age =15;
          if(age>=18){
            out.print(<font style="color:red;font-size:45px">热烈欢迎</font>)
          }else{
            out.print(<font style="color:red;font-size:45px">热烈欢迎</font>)
         }

    }

-->

