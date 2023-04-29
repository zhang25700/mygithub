package com.zzy.web.servlet.old;

import com.alibaba.fastjson.JSON;
import com.zzy.pojo.Brand;
import com.zzy.service.BrandService;
import com.zzy.service.impl.BrandServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

//@WebServlet("/addBrandServlet")
public class AddBrandServlet extends HttpServlet {
    private BrandService service = new BrandServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //得到新增品牌信息
        request.setCharacterEncoding("utf-8");
        BufferedReader bf = request.getReader();
        String jsonStr = bf.readLine();
        System.out.println(jsonStr);
        //将JSON转为brand
        Brand brand = JSON.parseObject(jsonStr, Brand.class);
        service.addBrand(brand);
        System.out.println(brand);
        //响应添加品牌成功
        response.getWriter().write("success");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
