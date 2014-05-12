package com.juzhi.wrapper;

import com.juzhi.entity.InfoDetailed;

import java.util.List;

/**
 * Created by xjwan on 5/11/14.
 */
public class InfoDetailedWrapper {
    private int code;
    private InfoDetailed infoDetailed;


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public InfoDetailed getInfoDetailed() {
        return infoDetailed;
    }

    public void setInfoDetailed(InfoDetailed infoDetailed) {
        this.infoDetailed = infoDetailed;
    }
}
