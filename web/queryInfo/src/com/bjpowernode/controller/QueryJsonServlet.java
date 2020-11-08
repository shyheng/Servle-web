package com.bjpowernode.controller;

import com.bjpowernode.dao.ProvinceDao;
import com.bjpowernode.entity.Province;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class QueryJsonServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //默认值， {} ：表示json格式的数据
        String json = "{}";

        // 获取请求参数，省份的id
        String strProid = request.getParameter("proid");
        System.out.println("strProid========="+strProid);

        //判断proid有值时，调用dao查询数据
        if( strProid != null && strProid.trim().length() > 0 ){
            ProvinceDao dao  = new ProvinceDao();
            Province p  = dao.queryProviceById(Integer.valueOf(strProid));
            //需要使用jackson 把  Provice对象转为  json
            ObjectMapper om  = new ObjectMapper();
            json =  om.writeValueAsString(p);
        }

        //把获取的数据，通过网络传给ajax中的异步对象，响应结果数据
        //指定服务器端（servlet）返回给浏览器的是json格式的数据,json数据使用utf-8编码的
        //response.setContentType("text/json;charset=utf-8");
        response.setContentType("application/json;charset=utf-8");
        PrintWriter pw  = response.getWriter();
        /**
         *  <provines>
         *      <province>
         *          <name>河北</name>
         *          <shenghui>石家庄</shenghui>
         *      </province>
         *       <province>
         *          <name>山西</name>
         *          <shenghui>太原</shenghui>
         *       </province>
         *  </provines>
         */
        pw.println(json); //输出数据---会付给ajax中 responseText属性
        pw.flush();
        pw.close();
    }
}
