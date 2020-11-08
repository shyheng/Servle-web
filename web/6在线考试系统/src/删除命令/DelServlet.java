package 删除命令;

import 调用方法.userDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class DelServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId;
        userDao dao = new userDao();
        int result= 0;
        PrintWriter out =null;
//        1调用请求对象，读取参数
        userId = request.getParameter("userId");
//        2调用dao ，将用户编号填充到delete命令并发送到数据库服务器上
         result =  dao.delete(userId);
//        3调用响应对象，将处理结果用二进制写到响应体中
        response.setContentType("text/html;charset=utf-8");
        out = response.getWriter();
        if (result == 1){
            out.print("<font style='color:red;font-size:40'>用户信息删除成功</font>");
        }else {
            out.print("<font style='color:red;font-size:40'>用户信息删除失败</font>");
        }
    }
}
