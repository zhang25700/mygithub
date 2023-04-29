package com.zzy.web.servlet;

import com.alibaba.fastjson.JSON;
import com.zzy.pojo.Brand;
import com.zzy.pojo.BrandInfo;
import com.zzy.pojo.PageBean;
import com.zzy.service.BrandService;
import com.zzy.service.impl.BrandServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/brand/*")
public class BrandServlet extends BaseServlet {
    private BrandService service = new BrandServiceImpl();

    /**
     * 查询所有
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void selectAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //得到数据库的所有数据
        List<Brand> brands = service.selectAll();

        //将数据转为JSON
        String jsonString = JSON.toJSONString(brands);

        //发送JSON数据
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    /**
     * 新增品牌
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void addBrand(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
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

    /**
     * 通过id修改信息
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void updateById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //得到数据
        request.setCharacterEncoding("utf-8");
        BufferedReader bf = request.getReader();
        String jsonStr = bf.readLine();
        //将JSON转为brand对象
        Brand brand = JSON.parseObject(jsonStr, Brand.class);
        service.updateById(brand);
        System.out.println(brand);
        //响应品牌修改成功
        response.getWriter().write("success");
    }

    /**
     * 删除数据
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void deleteById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //得到数据
        String id = request.getReader().readLine();
        System.out.println(id);
        service.deleteById(Integer.parseInt(id));
        //响应品牌修改成功
        response.getWriter().write("success");
    }

    /**
     * 删除多个数据
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void deleteByIds(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //得到数据
        String jsonStr = request.getReader().readLine();
        System.out.println(jsonStr);
        //将JSON转为brand
        int[] ids = JSON.parseObject(jsonStr, int[].class);
        //批量删除
        service.deleteByArr(ids);
        //响应品牌批量修改成功
        response.getWriter().write("success");
    }

    /**
     * 分页查询
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void selectLimit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //得到当前页数和一页个数
        int currentPage = Integer.parseInt(request.getParameter("currentPage"));
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));
        //计算出开始索引
        int beginInd = (currentPage - 1) * pageSize;
        //得到数据库的所有数据
        PageBean<Brand> brandPageBean = service.selectLimit(beginInd, pageSize);

        //将数据转为JSON
        String jsonString = JSON.toJSONString(brandPageBean);

        //发送JSON数据
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    public void selectByCondition(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //得到数据
        String jsonStr = request.getReader().readLine();
        BrandInfo brandInfo = JSON.parseObject(jsonStr, BrandInfo.class);
        System.out.println("品牌信息：" + brandInfo);
        //得到查询条件
        String brandName = brandInfo.getBrandName();
        //模糊查询
        if (brandName != null && brandName.length() != 0) {
            brandName = "%" + brandName + "%";
        }
        String companyName = brandInfo.getCompanyName();
        //模糊查询
        if (companyName != null && companyName.length() != 0) {
            companyName = "%" + companyName + "%";
        }
        Integer status = brandInfo.getStatus();
        System.out.println(status);
        //得到当前页数和一页个数
        int currentPage = brandInfo.getCurrentPage();
        int pageSize = brandInfo.getPageSize();
        //计算出开始索引
        int beginInd = (currentPage - 1) * pageSize;
        //得到数据库的所有数据
        PageBean<Brand> brandPageBean = service.selectByCondition(brandName, companyName, status, beginInd, pageSize);

        //将数据转为JSON
        String jsonString = JSON.toJSONString(brandPageBean);

        //发送JSON数据
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    /**
     * 升序
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void asc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //得到当前页数和一页个数
        int currentPage = Integer.parseInt(request.getParameter("currentPage"));
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));
        //计算出开始索引
        int beginInd = (currentPage - 1) * pageSize;
        //得到数据库的所有数据
        PageBean<Brand> brandPageBean = service.asc(beginInd, pageSize);

        //将数据转为JSON
        String jsonString = JSON.toJSONString(brandPageBean);

        //发送JSON数据
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    /**
     * 降序
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void desc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //得到当前页数和一页个数
        int currentPage = Integer.parseInt(request.getParameter("currentPage"));
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));
        //计算出开始索引
        int beginInd = (currentPage - 1) * pageSize;
        //得到数据库的所有数据
        PageBean<Brand> brandPageBean = service.desc(beginInd, pageSize);

        //将数据转为JSON
        String jsonString = JSON.toJSONString(brandPageBean);

        //发送JSON数据
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }
    //查询后进行升序
    public void limitSortAsc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //得到数据
        String jsonStr = request.getReader().readLine();
        BrandInfo brandInfo = JSON.parseObject(jsonStr, BrandInfo.class);
        System.out.println("品牌信息：" + brandInfo);
        //得到查询条件
        String brandName = brandInfo.getBrandName();
        //模糊查询
        if (brandName != null && brandName.length() != 0) {
            brandName = "%" + brandName + "%";
            brandInfo.setBrandName(brandName);
        }
        String companyName = brandInfo.getCompanyName();
        //模糊查询
        if (companyName != null && companyName.length() != 0) {
            companyName = "%" + companyName + "%";
            brandInfo.setCompanyName(companyName);
        }
        Integer status = brandInfo.getStatus();
        System.out.println(status);
        //得到当前页数和一页个数
        int currentPage = brandInfo.getCurrentPage();
        int pageSize = brandInfo.getPageSize();
        //计算出开始索引
        int beginInd = (currentPage - 1) * pageSize;
        //得到数据库的所有数据
        PageBean brandPageBean = service.limitSortAsc(brandInfo, beginInd);
        System.out.println(brandPageBean);
        //将数据转为JSON
        String jsonString = JSON.toJSONString(brandPageBean);

        //发送JSON数据
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }
    //查询后进行降序
    public void limitSortDesc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //得到数据
        String jsonStr = request.getReader().readLine();
        BrandInfo brandInfo = JSON.parseObject(jsonStr, BrandInfo.class);
        System.out.println("品牌信息：" + brandInfo);
        //得到查询条件
        String brandName = brandInfo.getBrandName();
        //模糊查询
        if (brandName != null && brandName.length() != 0) {
            brandName = "%" + brandName + "%";
            brandInfo.setBrandName(brandName);
        }
        String companyName = brandInfo.getCompanyName();
        //模糊查询
        if (companyName != null && companyName.length() != 0) {
            companyName = "%" + companyName + "%";
            brandInfo.setCompanyName(companyName);
        }
        Integer status = brandInfo.getStatus();
        System.out.println(status);
        //得到当前页数和一页个数
        int currentPage = brandInfo.getCurrentPage();
        int pageSize = brandInfo.getPageSize();
        //计算出开始索引
        int beginInd = (currentPage - 1) * pageSize;
        //得到数据库的所有数据
        PageBean<Brand> brandPageBean = service.limitSortDesc(brandInfo, beginInd);
        System.out.println(brandPageBean);
        //将数据转为JSON
        String jsonString = JSON.toJSONString(brandPageBean);

        //发送JSON数据
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }
}
