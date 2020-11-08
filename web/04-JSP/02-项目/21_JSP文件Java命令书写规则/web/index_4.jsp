<%@ page import="com.bjpowernode.entity.Student" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%
   //创建一个Student类型对象
    Student stu = new Student(10,"mike");
    List list= new ArrayList();
%>

学员编号:<%=stu.getSid()%><br/>
学员姓名:<%=stu.getSname()%>
