import 用户类.question;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class questionServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title,optionA,optionB,optionC,optionD,answer;
        questionDao dao = new questionDao();
        question qusetion = null;
        int result = 0;
//        1调用请求对象读取请求信息，得到新增内容
        title= request.getParameter("title");
        optionA= request.getParameter("optionA");
        optionB= request.getParameter("optionB");
        optionC= request.getParameter("optionC");
        optionD= request.getParameter("optionD");
        answer= request.getParameter("answer");
//        2调用dao对象将Insert命令推送到数据库，并且得到处理结果
        qusetion = new question(null,title,optionA,optionB,optionC,optionD,answer);
        result = dao.add(qusetion);
//        3通过请求转发，向Tomcat索要info.jsp将处理结果写入响应体
        if (result == 1){
            request.setAttribute("info","试题添加成功");
        }else {
            request.setAttribute("info","试题添加失败");
        }
        request.getRequestDispatcher("/info.jsp").forward(request,response);
    }
}
