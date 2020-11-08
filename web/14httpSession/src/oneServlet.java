import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class oneServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String goodsName;
//        1调用请求对象读取请求参数，得到用户本次选购商品名
        goodsName = request.getParameter("goodsName");
//        2调用请求对象向Tomcat索要用户所在的服务端的私人出柜
        HttpSession session = request.getSession();
//        3将商品添加到当前用户的私人储物柜
        Integer goodsNum = (Integer) session.getAttribute(goodsName);
        if (goodsNum == null){
            session.setAttribute(goodsName,1);
        }else {
            session.setAttribute(goodsName,goodsName+1);
        }
    }
}
