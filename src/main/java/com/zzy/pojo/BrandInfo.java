package com.zzy.pojo;

/**
 * 查询时传入当前页数和查询条件
 * @param <T>
 */
public class BrandInfo<T> {
    //传入的页数
    private Integer currentPage;
    private Integer pageSize;
    //传入的查询条件
    private String brandName;
    private String companyName;
    private Integer status;

    public BrandInfo() {
    }

    public BrandInfo(Integer currentPage, Integer pageSize, String brandName, String companyName, Integer status) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.brandName = brandName;
        this.companyName = companyName;
        this.status = status;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "BrandInfo{" +
                "currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                ", brandName='" + brandName + '\'' +
                ", companyName='" + companyName + '\'' +
                ", status=" + status +
                '}';
    }
}
