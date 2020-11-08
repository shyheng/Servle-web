package 查看命令;

import 用户类.User;
import 调用方法.userDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class userFindServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        userDao dao = new userDao();
        PrintWriter out;


//        1调用dao  将查询命名推送到数据库服务器中，用户得到消息list
        List<User> userList = dao.findAll();
//        2调用响应对象将用户信息结合<table>标签命令以二进制形式写入响应体
        response.setContentType("text/html;charset=utf-8");
        out = response.getWriter();
        out.print("<table border='2' align='center'>");
        out.print("<tr>");
        out.print("<td>用户编号</td>");
        out.print("<td>用户姓名</td>");
        out.print("<td>用户密码</td>");
        out.print("<td>用户性别</td>");
        out.print("<td>用户邮箱</td>");
        out.print("<td>操作</td>");
        out.print("</tr>");

        for (User user : userList){
            out.print("<tr>");
            out.print("<td>"+user.getUserId()+"</td>");
            out.print("<td>"+user.getUserName()+"</td>");
            out.print("<td>********</td>");
            out.print("<td>"+user.getSex()+"</td>");
            out.print("<td>"+user.getEmail()+"</td>");
            out.print("<td><a href='/myweb/shy2Del?userId="+user.getUserId()+"'>删除用户</a></td>");
            out.print("</tr>");
        }

        out.print("</table>");


    }
}
