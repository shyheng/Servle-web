package 登录命令;

import 调用方法.userDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName,password;
        userDao dao = new userDao();
        int result = 0;
//        1调用请求对象对请求体使用utf-8字符集进行重新编辑
        request.setCharacterEncoding("utf-8");
//        2调用请求对象读取请求体参数信息
        userName = request.getParameter("userName");
        password = request.getParameter("password");
//        3调用dao将查询验证信息推送到数据库上
        result = dao.login(userName,password);
//        4调用响应对象，根据验证结果不同资源文件地址写入到响应头中交给浏览器
        if(result == 1){//用户存在
//            在判定用户身份合法后，通过请求对象向Tomcat申请当前HttpSession
            HttpSession session = request.getSession();
            response.sendRedirect("/myweb/index.html");
        }else {
            response.sendRedirect("/myweb/login_error.html");
        }
    }


}
