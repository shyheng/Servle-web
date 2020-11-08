import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class twoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int jaozi = 30;
        int miantiao = 10;
        int gaifu = 12;
        int money = 0,xiaofei=0,balance =0;
        String food,userName = null;
        Cookie cookieArray[]=null;
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        Cookie newCard = null;
//         1读取请求头参数，获得   用户点餐类型
        food = request.getParameter("food");
//        2读取请求头cookie，   得到用户会员卡
        cookieArray = request.getCookies();
//        3根据食物类型进行  消费处理
        for (Cookie card : cookieArray){
            String key = card.getName();
            String value = card.getValue();
            if ("userName".equals(key)){
                userName = value;
            }else if ("money".equals(key)){
                money = Integer.valueOf(value);
                if ("饺子".equals(food)){
                    if (jaozi>money){
                        out.print("用户"+userName+"余额不足，请充值");
                    }else {
                        newCard = new Cookie("money",(money-jaozi)+"");
                        xiaofei = jaozi;
                        balance = money-jaozi;
                    }
                }else if ("面条".equals(food)){
                    if (miantiao>money){
                        out.print("用户"+userName+"余额不足，请充值");
                    }else {
                        newCard = new Cookie("money",(money-miantiao)+"");
                        xiaofei = miantiao;
                        balance = money-miantiao;
                    }
                }else if ("盖饭".equals(food)){
                    if (gaifu>money){
                        out.print("用户"+userName+"余额不足，请充值");
                    }else {
                        newCard = new Cookie("money",(money-gaifu)+"");
                        xiaofei = gaifu;
                        balance = money-gaifu;
                    }
                }
            }
        }
//        4将cookie交给用户，
        response.addCookie(newCard);
//        5并将消费记录写入响应体
        out.print("用户"+userName+"本次消费"+xiaofei+"余额"+balance);
    }
}
