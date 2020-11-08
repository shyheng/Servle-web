import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Servlet3 extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String shu = "java<br/>mysql<br/>html";//既有文字和HTML语言
//设置响应头的content-type
        String shu1 = "<br>意大利<br>推送<br>shy";
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
//
        out.print(shu);
        out.print(shu1);
    }
}
