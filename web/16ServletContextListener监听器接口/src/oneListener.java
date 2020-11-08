import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class oneListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("运行开始");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("关闭服务器");
    }
}
