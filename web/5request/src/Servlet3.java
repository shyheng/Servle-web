import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * get在请求头中可以获取中文
 * post在请求体中不可以使用中文。=，需要改request的字符集
 */
public class Servlet3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//更改读取方式
        request.setCharacterEncoding("utf-8");
        //        通过请求体获取参数信息

        String value= request.getParameter("userName");
        System.out.println("从请求体中获取参数 "+value);
//        获取不了中文

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        通过请求头读取参数信息
        String userName = request.getParameter("userName");
        System.out.println("从请求头中获取参数 "+userName);
//        可以获取中文
    }
}
