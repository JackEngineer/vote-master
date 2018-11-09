package com.cn.ssm.dao;

/**
 * Created by admin on 2018/9/15.
 */
public class SysImgQuery extends SysImg {
    private Integer page;
    private Integer rows; //每页数量
    private String activeName;

    public String getActiveName() {
        return activeName;
    }

    public void setActiveName(String activeName) {
        this.activeName = activeName;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }
    public SysImgQuery(){
        this.page = 1;
        this.rows = 10;
    }
}
