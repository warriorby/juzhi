package com.juzhi.wrapper;

import com.juzhi.entity.Category;
import com.juzhi.entity.Info;

import java.util.List;

/**
 * Created by xjwan on 5/12/14.
 */
public class InfoListWrapper {
    private Number code;
    private List<Info> infoList;

    public List<Info> getInfoList() {
        return infoList;
    }

    public void setInfoList(List<Info> infoList) {
        this.infoList = infoList;
    }

    public Number getCode() {
        return code;
    }

    public void setCode(Number code) {
        this.code = code;
    }


}
