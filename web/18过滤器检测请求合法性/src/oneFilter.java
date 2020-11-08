import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class oneFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        1通过拦截请求对象得到请求包参数信息，从而到来访用户的真是年龄
        String age = servletRequest.getParameter("age");
//        2根据年龄，帮助http服务器判断本次请求合法性
        if (Integer.valueOf(age) < 70){
//            将拦截请求对象 和响应对象交还给Tomcat
            filterChain.doFilter(servletRequest, servletResponse);//放行
        }else {
//            过滤器代替http服务器拒绝本次请求
            servletResponse.setContentType("text/html;charset=utf-8");
            PrintWriter out = servletResponse.getWriter();
            out.print("<center><font style='color:red;font-size:40px'>大爷，别啊</font></center");
        }
    }
}
