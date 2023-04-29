package com.zzy.service.impl;

import com.zzy.mapper.BrandMapper;
import com.zzy.pojo.Brand;
import com.zzy.pojo.BrandInfo;
import com.zzy.pojo.PageBean;
import com.zzy.service.BrandService;
import com.zzy.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class BrandServiceImpl implements BrandService {
    private SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();

    /**
     * 查询所有品牌
     *
     * @return
     */
    @Override
    public List<Brand> selectAll() {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        List<Brand> brands = mapper.selectAll();

        sqlSession.close();

        return brands;
    }

    /**
     * 新增品牌
     *
     * @param brand
     */
    @Override
    public void addBrand(Brand brand) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        mapper.addBrand(brand);

        System.out.println(brand);

        sqlSession.close();
    }

    /**
     * 通过id修改品牌信息
     *
     * @param brand
     */
    @Override
    public void updateById(Brand brand) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        mapper.updateById(brand);

        sqlSession.close();
    }

    /**
     * 通过id删除一个品牌
     * @param id
     */
    @Override
    public void deleteById(int id) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        mapper.deleteById(id);

        sqlSession.close();
    }

    @Override
    public void deleteByArr(int[] ids) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        mapper.deleteByIds(ids);

        sqlSession.close();
    }

    /**
     * 分页查询
     * @param beginInd 开始索引
     * @param pageSize 一页的数量
     * @return
     */
    @Override
    public PageBean<Brand> selectLimit(int beginInd, int pageSize) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //获取品牌
        List<Brand> brands = mapper.selectLimit(beginInd, pageSize);

        System.out.println(brands);
        //获取总个数
        int totalCount = mapper.totalCount();

        System.out.println(totalCount);

        sqlSession.close();

        return new PageBean<Brand>(totalCount, brands);
    }

    /**
     * 通过条件查询并且分页
     * @param brandName
     * @param CompanyName
     * @param status
     * @param beginInd
     * @param pageSize
     * @return
     */
    @Override
    public PageBean<Brand> selectByCondition(String brandName, String CompanyName, Integer status, int beginInd, int pageSize) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //获取品牌
        List<Brand> brands = mapper.selectByCondition(brandName, CompanyName, status, beginInd, pageSize);

        System.out.println(brands);
        //获取总个数
        int conditionCount = mapper.conditionCount(brandName, CompanyName, status);

        System.out.println(conditionCount);

        sqlSession.close();

        return new PageBean<Brand>(conditionCount, brands);
    }

    /**
     * 升序
     * @param beginInd
     * @param pageSize
     * @return
     */
    @Override
    public PageBean<Brand> asc(int beginInd, int pageSize) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //获取品牌
        List<Brand> brands = mapper.asc(beginInd, pageSize);

        System.out.println(brands);
        //获取总个数
        int totalCount = mapper.totalCount();

        System.out.println(totalCount);

        sqlSession.close();

        return new PageBean<Brand>(totalCount, brands);
    }

    /**
     * 降序
     * @param beginInd
     * @param pageSize
     * @return
     */
    @Override
    public PageBean<Brand> desc(int beginInd, int pageSize) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //获取品牌
        List<Brand> brands = mapper.desc(beginInd, pageSize);

        System.out.println(brands);
        //获取总个数
        int totalCount = mapper.totalCount();

        System.out.println(totalCount);

        sqlSession.close();

        return new PageBean<Brand>(totalCount, brands);
    }

    /**
     * 查询后进行升序
     * @param brandInfo
     * @param beginInd
     * @return
     */
    @Override
    public PageBean<Brand> limitSortAsc(BrandInfo<Brand> brandInfo, int beginInd) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //获取品牌
        List<Brand> brands = mapper.limitSortAsc(brandInfo, beginInd);

        System.out.println(brands);
        //获取总个数
        int conditionCount = mapper.conditionCount(brandInfo.getBrandName(), brandInfo.getCompanyName(), brandInfo.getStatus());

        System.out.println(conditionCount);

        sqlSession.close();

        return new PageBean<Brand>(conditionCount, brands);
    }

    /**
     * 查询后进行降序
     * @param brandInfo
     * @param beginInd
     * @return
     */
    @Override
    public PageBean<Brand> limitSortDesc(BrandInfo<Brand> brandInfo, int beginInd) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //获取品牌
        List<Brand> brands = mapper.limitSortDesc(brandInfo, beginInd);

        System.out.println(brands);
        //获取总个数
        int conditionCount = mapper.conditionCount(brandInfo.getBrandName(), brandInfo.getCompanyName(), brandInfo.getStatus());

        System.out.println(conditionCount);

        sqlSession.close();

        return new PageBean<Brand>(conditionCount, brands);
    }


}
