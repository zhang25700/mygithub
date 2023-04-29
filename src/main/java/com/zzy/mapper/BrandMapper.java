package com.zzy.mapper;

import com.zzy.pojo.Brand;
import com.zzy.pojo.BrandInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface BrandMapper {
    /**
     * 查询所有品牌信息
     *
     * @return
     */
    @Select("select * from tb_brand;")
    @ResultMap("resultMap")
    List<Brand> selectAll();

    /**
     * 新增品牌
     *
     * @param brand
     */
    void addBrand(Brand brand);

    /**
     * 通过id修改信息
     * @param brand
     */
    @Update("update tb_brand set brand_name = #{brandName}, " +
            "company_name = #{companyName}, " +
            "ordered = #{ordered}, " +
            "description = #{description}," +
            "status = #{status} " +
            "where id = #{id};")
    void updateById(Brand brand);

    /**
     * 通过id输出一个品牌
     * @param id
     */
    @Delete("delete from tb_brand where id = #{id};")
    void deleteById(int id);

    /**
     * 删除多个品牌
     * @param ids
     */
    void deleteByIds(@Param("ids") int[] ids);

    /**
     * 分页查询
     * @param beginInd 开始索引
     * @param pageSize 一页的数量
     */
    @Select("select * from tb_brand limit #{beginInd}, #{pageSize};")
    @ResultMap("resultMap")
    List<Brand> selectLimit(@Param("beginInd") int beginInd, @Param("pageSize") int pageSize);

    /**
     * 查询所有品牌个数
     * @return
     */
    @Select("select count(*) from tb_brand")
    int totalCount();

    /**
     * 通过查询条件返回一页数据
     * @param brandName
     * @param CompanyName
     * @param status
     * @param beginInd
     * @param pageSize
     * @return
     */
    List<Brand> selectByCondition(@Param("brandName") String brandName, @Param("companyName") String CompanyName,
                                  @Param("status") Integer status, @Param("beginInd") int beginInd, @Param("pageSize") int pageSize);

    /**
     * 通过条件查询查找到的总数
     * @return
     */
    int conditionCount(@Param("brandName") String brandName, @Param("companyName") String CompanyName,
                       @Param("status") Integer status);

    /**
     * 升序排序
     * @param beginInd
     * @param pageSize
     * @return
     */
    List<Brand> asc(@Param("beginInd") int beginInd, @Param("pageSize") int pageSize);

    /**
     * 降序排序
     * @param beginInd
     * @param pageSize
     * @return
     */
    List<Brand> desc(@Param("beginInd") int beginInd, @Param("pageSize") int pageSize);

    /**
     * 查询后进行升序
     * @param brandInfo
     * @return
     */
    List<Brand> limitSortAsc(BrandInfo<Brand> brandInfo, @Param("beginInd") int beginInd);

    /**
     * 查询后进行降序
     * @param brandInfo
     * @return
     */
    List<Brand> limitSortDesc(BrandInfo<Brand> brandInfo, @Param("beginInd") int beginInd);
}
