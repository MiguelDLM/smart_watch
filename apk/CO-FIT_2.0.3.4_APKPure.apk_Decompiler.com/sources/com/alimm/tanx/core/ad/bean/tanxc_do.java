package com.alimm.tanx.core.ad.bean;

import com.alimm.tanx.core.ad.listener.bean.IClickBean;
import java.util.Arrays;

public class tanxc_do implements IClickBean {
    private String tanxc_do;
    private int tanxc_for;
    private String tanxc_if;
    private Integer[] tanxc_int;

    public String getClickThroughUrl() {
        return this.tanxc_do;
    }

    public String getDeepLinkUrl() {
        return this.tanxc_if;
    }

    public Integer[] getInteractType() {
        return this.tanxc_int;
    }

    public int getInteractType2Int() {
        Integer[] numArr = this.tanxc_int;
        if (numArr == null || numArr.length <= 0) {
            return -1;
        }
        return numArr[0].intValue();
    }

    public int getOpenType() {
        return this.tanxc_for;
    }

    public void tanxc_do(String str) {
        this.tanxc_do = str;
    }

    public void tanxc_if(String str) {
        this.tanxc_if = str;
    }

    public boolean getInteractType(int i) {
        return getInteractType() != null && getInteractType().length > 0 && Arrays.binarySearch(getInteractType(), Integer.valueOf(i)) >= 0;
    }

    public void tanxc_do(int i) {
        this.tanxc_for = i;
    }

    public void tanxc_do(Integer[] numArr) {
        this.tanxc_int = numArr;
    }
}
