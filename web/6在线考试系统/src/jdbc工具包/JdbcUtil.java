package jdbc工具包;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.sql.*;
import java.util.Iterator;
import java.util.Map;

// jdbc工具包.JdbcUtil obj = new jdbc工具包.JdbcUtil();  obj.getCon()
// jdbc工具包.JdbcUtil obj = new jdbc工具包.JdbcUtil();  obj.createStatement();
// jdbc工具包.JdbcUtil.getCon();
public class JdbcUtil {

     final String URL="jdbc:mysql://localhost:3306/shy?useUnicode=true&characterEncoding=utf8";
     final String USERNAME="root";
     final String PASSWORD="1234";
     PreparedStatement ps= null;
     Connection con = null;


//     通过全局对象，得到全局对象
    public Connection getCon(HttpServletRequest request){
//        1通过请求对象，得到全局作用域对象
        ServletContext application = request.getServletContext();
//        2从全局作用域对象得到map
        Map map =(Map)application.getAttribute("key1");
//        3从map得到一个处于空闲状态Connection
        Iterator it = map.keySet().iterator();
        while (it.hasNext()){
            con = (Connection) it.next();
            boolean flag =(boolean)map.get(con);
            if (flag == true){
                map.put(con,false);
                break;
            }
        }
        return con;
    }


    public  PreparedStatement createStatement(String sql,HttpServletRequest request){

        try {
            ps =  getCon(request).prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ps;
    }

    public  void close(HttpServletRequest request){
        if(ps!=null){
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        ServletContext aplirequest = request.getServletContext();
        Map map =(Map) aplirequest.getAttribute("key1");
        map.put(con,true);

    }

    //将jar包中driver实现类加载到JVM中
    static{
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //封装连接通道创建细节
    public  Connection   getCon(){

        try {
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    //封装交通工具创建细节
    public  PreparedStatement createStatement(String sql){

        try {
            ps =  getCon().prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ps;
    }
    // ps与con销毁细节 insert,update,delete
    public  void close(){
        if(ps!=null){
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(con!=null){
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

     //select ps,con,rs
    public  void close(ResultSet rs){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        close();
    }
}
