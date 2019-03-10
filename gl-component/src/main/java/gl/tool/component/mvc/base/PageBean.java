package gl.tool.component.mvc.base;

/**
 * @author gl
 * @version 1.0
 * @date 2019/01/30
 * @description: 类描述: 分页类,若需要分页的对象(model 包内的 XxxDO 对象)可继承此类
 **/
public class PageBean {
    /**
     * 默认页码
     */
    public static final int DEFAULT_PAGE = 1;
    /**
     * 默认每页条数
     */
    public static final int DEFAULT_PAGE_SIZE = 10;

    /**
     * 第几页
     */
    private int page;
    /**
     * 每页记录数
     */
    private int pageSize;

    public PageBean() {
    }

    public PageBean(int page, int pageSize) {
        this.page = page;
        this.pageSize = pageSize;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getStart() {
        return (page - 1) * pageSize;
    }

    /**
     * 设置默认 pageBean
     * @param page 页码
     * @param pageSize 行数
     */
    public void setPageBean(int page, int pageSize) {
        if (page < PageBean.DEFAULT_PAGE) {
            /** 默认第一页 */
            page = PageBean.DEFAULT_PAGE;
        }
        if (pageSize < PageBean.DEFAULT_PAGE_SIZE) {
            /** 默认每页10条数据 */
            pageSize = PageBean.DEFAULT_PAGE_SIZE;
        }
        this.page = page;
        this.pageSize = pageSize;
    }
}
