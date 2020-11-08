import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class twoServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//         从当前请求对象得到oneservlet写到共享数据中
        String value = (String) request.getAttribute("key1");
        System.out.println("two得到共享数据"+value);
    }
}
