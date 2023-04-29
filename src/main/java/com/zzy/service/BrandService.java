package com.zzy.service;

import com.zzy.pojo.Brand;
import com.zzy.pojo.BrandInfo;
import com.zzy.pojo.PageBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BrandService {
    /**
     * 查询所有
     * @return
     */
    List<Brand> selectAll();

    /**
     * 新增品牌
     * @param brand
     */
    void addBrand(Brand brand);

    /**
     * 修改信息
     * @param brand
     */
    void updateById(Brand brand);

    /**
     * 通过id删除一个品牌
     * @param id
     */
    void deleteById(int id);

    /**
     * 批量删除
     * @param ids
     */
    void deleteByArr(int[] ids);

    /**
     * 分页查询
     * @param beginInd 开始索引
     * @param pageSize 一页的数量
     */
    PageBean<Brand> selectLimit(int beginInd, int pageSize);

    /**
     * 通过查询条件返回一页数据
     * @param brandName
     * @param CompanyName
     * @param status
     * @param beginInd
     * @param pageSize
     * @return
     */
    PageBean<Brand> selectByCondition(@Param("brandName") String brandName, @Param("companyName") String CompanyName,
                                  @Param("status") Integer status, @Param("beginInd") int beginInd, @Param("pageSize") int pageSize);

    /**
     * 升序排序
     * @param beginInd
     * @param pageSize
     * @return
     */
    PageBean<Brand> asc(@Param("beginInd") int beginInd, @Param("pageSize") int pageSize);

    /**
     * 降序排序
     * @param beginInd
     * @param pageSize
     * @return
     */
    PageBean<Brand> desc(@Param("beginInd") int beginInd, @Param("pageSize") int pageSize);
    /**
     * 查询后进行升序
     * @param brandInfo
     * @return
     */
    PageBean<Brand> limitSortAsc(BrandInfo<Brand> brandInfo, @Param("beginInd") int beginInd);

    /**
     * 查询后进行降序
     * @param brandInfo
     * @return
     */
    PageBean<Brand> limitSortDesc(BrandInfo<Brand> brandInfo, @Param("beginInd") int beginInd);
}
