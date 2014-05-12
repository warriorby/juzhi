package com.juzhi.wrapper;

import com.juzhi.entity.ClassDetail;
import com.juzhi.entity.InfoDetailed;

/**
 * Created by xjwan on 5/11/14.
 */
public class ClassDetailedWrapper {
    private int code;
    private ClassDetail classDetailed;


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public ClassDetail getClassDetailed() {
        return classDetailed;
    }

    public void setClassDetailed(ClassDetail classDetailed) {
        this.classDetailed = classDetailed;
    }
}
