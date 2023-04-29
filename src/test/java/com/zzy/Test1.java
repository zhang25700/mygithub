package com.zzy;

import com.zzy.pojo.Brand;
import com.zzy.pojo.BrandInfo;
import com.zzy.pojo.PageBean;
import com.zzy.service.impl.BrandServiceImpl;
import org.junit.Test;

public class Test1 {
    BrandServiceImpl brandService = new BrandServiceImpl();

    @Test
    public void test1() {
        BrandInfo<Brand> brandInfo = new BrandInfo<>();
        brandInfo.setPageSize(10);
        brandInfo.setStatus(1);
        PageBean<Brand> brandPageBean = brandService.limitSortDesc(brandInfo, 0);
        System.out.println(brandPageBean);
//        System.out.println(brandInfo.getBrandName());
    }
}
