package com.huawei.hms.ads.data;

import com.huawei.hms.ads.annotation.AllApi;
import com.huawei.openalliance.ad.annotations.DataKeep;
import com.huawei.openalliance.ad.annotations.c;

@DataKeep
@AllApi
/* loaded from: classes10.dex */
public class Keyword {

    @c(Code = "kw")
    private String keyword;
    private Integer type;

    @AllApi
    public Keyword() {
    }

    @AllApi
    public String getKeyword() {
        return this.keyword;
    }

    @AllApi
    public Integer getType() {
        return this.type;
    }

    @AllApi
    public void setKeyword(String str) {
        this.keyword = str;
    }

    @AllApi
    public void setType(Integer num) {
        this.type = num;
    }

    @AllApi
    public Keyword(Integer num, String str) {
        this.type = num;
        this.keyword = str;
    }
}
