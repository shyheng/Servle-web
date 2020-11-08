package 注册命令;

import 用户类.User;
import 调用方法.userDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class userServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        声明
        String userName,password,sex,email;
        userDao dao = new userDao();
        User user = null;
        int result = 0;
        PrintWriter out =  null;
//        1调用请求对象，读取请求头的参数信息，得到用户信息
        userName = request.getParameter("userName");
        password = request.getParameter("password");
        sex = request.getParameter("sex");
        email = request.getParameter("email");
//        2调用userdao 将用户对象填充到insert命令，并借助jdbc发送到数据库中
        user = new User(null,userName,password,sex,email);
        Date stardate =new Date();
        result = dao.add(user,request);
        Date enddate= new Date();
        System.out.println("添加消耗时间"+(enddate.getTime()-stardate.getTime())+"毫秒");
//        3调用响应对象，将处理结果以 二进制的形式写入响应体
        response.setContentType("text/html;charset=utf-8");
        out = response.getWriter();
        if (result == 1){
            out.print("<font style='color:red;font-size:40'>用户信息注册成功</font>");
        }else {
            out.print("<font style='color:red;font-size:40'>用户信息注册失败</font>");
        }
    }
}
