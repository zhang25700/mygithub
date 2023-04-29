package com.zzy.web.servlet.old;

import com.alibaba.fastjson.JSON;
import com.zzy.pojo.Brand;
import com.zzy.service.BrandService;
import com.zzy.service.impl.BrandServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//@WebServlet("/selectAllBrandServlet")
public class SelectAllBrandServlet extends HttpServlet {
    private BrandService service = new BrandServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //得到数据库的所有数据
        List<Brand> brands = service.selectAll();

        //将数据转为JSON
        String jsonString = JSON.toJSONString(brands);

        //发送JSON数据
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
