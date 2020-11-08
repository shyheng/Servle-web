import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class oneServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("one 麻醉");
//        1通过当前请求对象生成资源文件申请报告对象
        RequestDispatcher report = request.getRequestDispatcher("/two");
//        2将报告对象发送给Tomcat
        report.forward(request,response);

    }
}
