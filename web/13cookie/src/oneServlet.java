import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class oneServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName,money;
//        1调用请求对象，当前请求头的参数信息
        userName = request.getParameter("userName");
        money = request.getParameter("money");
//        2创建两个cookie对象   开卡
        Cookie card1 = new Cookie("userName",userName);
        Cookie card2 = new Cookie("money",money);
//        5试用阶段 指定card在客服端硬盘存活1分钟
        card2.setMaxAge(60);

//        3将两个cookie对象写到响应头     发卡
        response.addCookie(card1);
        response.addCookie(card2);
//        4将点餐页面写入到响应体
        request.getRequestDispatcher("/index_2.html").forward(request,response);

    }
}
