package com.cn.ssm.dao;

public class SysStudentQuery extends SysStudent {
    private Integer page;
    private Integer rows; //每页数量

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
    public SysStudentQuery(){
        this.page = 1;
        this.rows = 10;
    }
}
