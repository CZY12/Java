package entity;

import java.util.List;

/**
 * @ClassName Page
 * @Description TODO
 * @Author czy61
 * @Date 2019/8/13 14:01
 * @Version 1.0
 */
public class Page {

    private int currentPage = 1;
    private int pageSize = 4;
    private int totalCount;
    private int totalPage;
    private List<?> list;
    private String url;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pagSize) {
        this.pageSize = pagSize;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<?> getList() {
        return list;
    }

    public void setList(List<?> list) {
        this.list = list;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
