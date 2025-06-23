package com.huawei.hms.ads;

import com.huawei.hms.ads.annotation.AllApi;
import com.huawei.openalliance.ad.annotations.DataKeep;
import java.io.Serializable;

@DataKeep
@AllApi
/* loaded from: classes10.dex */
public class App implements Serializable {
    private static final long serialVersionUID = 30421300;
    private Integer brand;
    private String name;
    private String pkgname;
    private String version;

    @AllApi
    public App() {
    }

    @AllApi
    public Integer getBrand() {
        return this.brand;
    }

    @AllApi
    public String getName__() {
        return this.name;
    }

    @AllApi
    public String getPkgname__() {
        return this.pkgname;
    }

    @AllApi
    public String getVersion__() {
        return this.version;
    }

    @AllApi
    public void setBrand(Integer num) {
        this.brand = num;
    }

    @AllApi
    public void setName__(String str) {
        this.name = str;
    }

    @AllApi
    public void setPkgname__(String str) {
        this.pkgname = str;
    }

    @AllApi
    public void setVersion__(String str) {
        this.version = str;
    }

    @AllApi
    public App(String str, String str2, String str3) {
        this.name = str2;
        this.pkgname = str;
        this.version = str3;
    }

    @AllApi
    public App(String str, String str2, String str3, Integer num) {
        this.version = str;
        this.name = str2;
        this.pkgname = str3;
        this.brand = num;
    }
}
