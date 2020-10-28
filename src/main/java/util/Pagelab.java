package util;

import java.io.Serializable;
import java.util.List;

/**
 * @Description: 分页查询包装类
 */
public class Pagelab implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -6020963352724500631L;
    private static final int DEFAULT_PAGE_SIZE = 20;
    private static final int DEFAULT_CURRENT_PAGE = 1;

    public Pagelab(Integer currentPage, Integer pageSize) {
        currentPage = currentPage == null ? DEFAULT_CURRENT_PAGE : currentPage;
        pageSize = pageSize == null ? DEFAULT_PAGE_SIZE : pageSize;
        this.setPageSize(pageSize);
        this.setCurrentPage(currentPage);
    }

    public Pagelab() {
        this.setPageSize(DEFAULT_PAGE_SIZE);
        this.setCurrentPage(DEFAULT_CURRENT_PAGE);
    }

    /**
     * 开始索引(默认值0)
     */
    private Integer startIndex;
    /**
     * 单前页面
     */
    private Integer currentPage;
    /**
     * 分页大小(默认20条)
     * 分页查询最多只能50条数据
     */
    private Integer pageSize;
    /**
     * 总页数
     */
    private Integer countPage;
    /**
     * 总条数
     */
    private Integer totalNum;

    /**
     * 页内容
     */
    private List<? extends Object> dataList;

    public Integer getStartIndex() {
        return null == startIndex ? 0 : startIndex;
    }

    public void setStartIndex(Integer startIndex) {
        this.startIndex = startIndex;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = null == currentPage ? 1 : currentPage;
        this.setStartIndex((this.currentPage - 1) * this.getPageSize());
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
        if (totalNum != null) {
            this.setCountPage((totalNum - 1) / this.getPageSize() + 1);
        }
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        pageSize = (null == pageSize || pageSize > 50 || pageSize < 0) ? DEFAULT_PAGE_SIZE : pageSize;
        this.pageSize = pageSize;
    }

    public Integer getCountPage() {
        return countPage;
    }

    public void setCountPage(Integer countPage) {
        this.countPage = countPage;
    }

    public Integer getTotalNum() {
        return totalNum;
    }

    public List<? extends Object> getDataList() {
        return dataList;
    }

    public void setDataList(List<? extends Object> dataList) {
        this.dataList = dataList;
    }

    public static Integer buildCountPage(Integer startIndex, Integer pageSize) {
        return startIndex / pageSize + 1;
    }

    public static Pagelab buildPageLab(Integer startIndex, Integer pageSize) {
        return new Pagelab(buildCountPage(startIndex, pageSize), pageSize);
    }

}
