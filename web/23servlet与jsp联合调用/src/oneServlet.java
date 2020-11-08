import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class oneServlet extends HttpServlet {
//    处理业务----得到结果-----查询学院信息
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Student s1 = new Student(10,"sk");
        Student s2 = new Student(20,"fs");
        List stulist= new ArrayList();
        stulist.add(s1);
        stulist.add(s2);

//        将处理结果添加到请求作用域对象
        request.setAttribute("key",stulist);

//        通过请求转发方案，向Tomcat申请调用user.jsp
//        同时将request与response通过user.jsp
        request.getRequestDispatcher("/user.jsp").forward(request,response);
    }
}
