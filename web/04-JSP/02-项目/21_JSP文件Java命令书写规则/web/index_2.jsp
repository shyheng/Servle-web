<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/30
  Time: 9:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
  //在jsp文件中，只有书写在执行标记中内容才会被当做Java命令
  //1.声明Java变量
  int num1 = 100;
  int num2 = 200;
  //2.声明运行表达式：数学运算，关系运算，逻辑运算
  int num3 = num1 + num2; //数学运算
  int num4 = num2>=num1?num2:num1;//关系运算
  boolean num5 = num2>=200 && num1>=100;//逻辑运算
  //3.声明控制语句
   if(num2>=num1){

   }else{

   }

   for(int i=1;i<=10;i++){

   }
%>
