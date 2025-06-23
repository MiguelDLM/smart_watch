package com.huawei.hms.ads.data;

import com.huawei.hms.ads.annotation.AllApi;
import com.huawei.openalliance.ad.annotations.DataKeep;
import com.huawei.openalliance.ad.annotations.c;
import java.util.List;

@DataKeep
@AllApi
/* loaded from: classes10.dex */
public class SearchInfo {

    @c(Code = "chnl")
    private String channel;

    @c(Code = "kws")
    private List<Keyword> keywords;

    @c(Code = "qry")
    private String query;

    @AllApi
    public SearchInfo() {
    }

    @AllApi
    public String getChannel() {
        return this.channel;
    }

    @AllApi
    public List<Keyword> getKeywords() {
        return this.keywords;
    }

    @AllApi
    public String getQuery() {
        return this.query;
    }

    @AllApi
    public void setChannel(String str) {
        this.channel = str;
    }

    @AllApi
    public void setKeywords(List<Keyword> list) {
        this.keywords = list;
    }

    @AllApi
    public void setQuery(String str) {
        this.query = str;
    }

    @AllApi
    public SearchInfo(String str, List<Keyword> list, String str2) {
        this.query = str;
        this.keywords = list;
        this.channel = str2;
    }
}
