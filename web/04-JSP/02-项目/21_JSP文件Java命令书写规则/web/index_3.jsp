<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/30
  Time: 9:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
   int num1 =100;
   int num2 =200;
%>

<!--在JSP文件，通过输出标记，通知JSP将Java变量的值写入到响应体-->
变量num1的值:<%=num1%><br/>
变量num2的值:<%=num2%><br/>
<!--执行标记还可以通知Jsp将运算结果写入到响应体-->
num1 + num2 = <%=num1+num2%>