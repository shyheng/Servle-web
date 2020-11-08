package 监听器提高效率;

import jdbc工具包.JdbcUtil;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class oneListener implements ServletContextListener {
//    tomcat 预先创建20个Connection，在userDao.add执行
//    将实现好的connection交给add方法
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        JdbcUtil util = new JdbcUtil();
        Map map = new HashMap();
        for (int i = 0;i <20; i++ ){
            Connection con = util.getCon();
            System.out.println("在http，创建connection"+con);
            map.put(con,true);//true表示空闲，false表示被占用
        }
//        为了在http服务器运行期间，一直都可以使用20个connection
//        将这20个connection保存到全局作用域对象对象
        ServletContext application = sce.getServletContext();
        application.setAttribute("key1",map);
    }//map被销毁
//http服务器关闭，将全局作用域对象销毁
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext application = sce.getServletContext();
        Map map = (Map)application.getAttribute("key1");
        Iterator it = map.keySet().iterator();
        while (it.hasNext()){
            Connection con = (Connection) it.next();
            if (con != null){
                System.out.println("销毁connection"+con);
            }
        }
    }
}
