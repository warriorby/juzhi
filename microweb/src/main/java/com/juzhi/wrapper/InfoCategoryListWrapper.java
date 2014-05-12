package com.juzhi.wrapper;

import com.juzhi.entity.Category;

import java.util.List;

/**
 * Created by xjwan on 5/12/14.
 */
public class InfoCategoryListWrapper {
    private Number code;
    private List<Category> categorylist;

    public List<Category> getCategorylist() {
        return categorylist;
    }

    public void setCategorylist(List<Category> categorylist) {
        this.categorylist = categorylist;
    }

    public Number getCode() {
        return code;
    }

    public void setCode(Number code) {
        this.code = code;
    }


}
