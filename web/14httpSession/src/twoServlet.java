import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;

public class twoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        1调用请求对象向Tomcat索要当前所在服务端私人储物柜
        HttpSession session = request.getSession();
//        2将session 中所有的key读取出来，存放一个枚举对象
        Enumeration goodsNames = session.getAttributeNames();
        while (goodsNames.hasMoreElements()){
            String goodsName =(String) goodsNames.nextElement();
            int goodsNum =(int)session.getAttribute(goodsName);
            System.out.println("商品名称"+goodsName+"商品数量"+goodsNum);
        }
//        2从私人储物柜得到之前存放商品信息
//        3调用相应对象将得到的商品结合table标签写入到响应体交给浏览器
    }
}
