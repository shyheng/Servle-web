import javax.servlet.*;
import java.io.IOException;

public class oneFilter implements Filter {
//    通知请对象使用utf-8对象当前信息进行一次重新编辑
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("utf-8");//增强
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
