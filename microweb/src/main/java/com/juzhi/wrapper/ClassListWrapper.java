package com.juzhi.wrapper;

import com.juzhi.entity.Clazz;
import com.juzhi.entity.Info;

import java.util.List;

/**
 * Created by xjwan on 5/12/14.
 */
public class ClassListWrapper {
    private Number code;
    private List<Clazz> classList;

    public List<Clazz> getClassList() {
        return classList;
    }

    public void setClassList(List<Clazz> classList) {
        this.classList = classList;
    }

    public Number getCode() {
        return code;
    }

    public void setCode(Number code) {
        this.code = code;
    }


}
