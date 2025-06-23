package com.huawei.openalliance.ad.beans.server;

import XIXIX.OOXIXo;
import com.huawei.openalliance.ad.annotations.DataKeep;
import java.util.List;

@DataKeep
/* loaded from: classes10.dex */
public class AppConfigRsp {
    private Integer adsCoreSel;
    private Integer allowAdSkipTime;
    private Integer bdinterval;
    private String configMap;
    private Integer configRefreshInterval;
    private List<String> defBrowerPkgList;
    private String globalSwitch;
    private double limitOfContainerAspectRatio;
    private Long maxBannerInterval;
    private Long minBannerInterval;
    private Integer oaidReportOnNpa;
    private String sha256;
    private List<String> singleInstanceLSModelList;
    private Integer sloganShowTime;
    private Integer splashInteractCloseEffectiveTime;
    private Integer splashmode;
    private String testCountryCode;
    private String trustAppList;
    private int splashshow = 3000;
    private int splashSkipArea = 0;
    private long sloganShowMinTimeRealMode = 300;
    private int splashUserAppDayImpFc = 0;
    private Long locationExpireTime = 1800000L;
    private Long locationRefreshInterval = 1800000L;
    private int locationSwitch = 0;
    private long preloadSplashReqTimeInterval = 600000;
    private int retcode = -1;

    private int r() {
        Integer num = this.sloganShowTime;
        if (num != null && num.intValue() >= 500 && this.sloganShowTime.intValue() <= 5000) {
            return this.sloganShowTime.intValue();
        }
        return 2000;
    }

    private int s() {
        Integer num = this.sloganShowTime;
        if (num == null) {
            return 2000;
        }
        if (num.intValue() < 0 || this.sloganShowTime.intValue() > 5000) {
            return 0;
        }
        return this.sloganShowTime.intValue();
    }

    public Integer B() {
        if (this.sloganShowTime == null) {
            return null;
        }
        Integer num = this.splashmode;
        return Integer.valueOf((num == null || 1 == num.intValue()) ? s() : (2 == this.splashmode.intValue() || 3 == this.splashmode.intValue()) ? r() : 0);
    }

    public int C() {
        int i = this.splashshow;
        if (i >= 2000) {
            return i;
        }
        return 3000;
    }

    public int Code() {
        return this.retcode;
    }

    public Integer D() {
        return this.configRefreshInterval;
    }

    public int F() {
        int i = this.splashSkipArea;
        if (i < 0 || i > 200) {
            return 0;
        }
        return i;
    }

    public int I() {
        int i = this.splashUserAppDayImpFc;
        if (i > 0) {
            return i;
        }
        return 0;
    }

    public String L() {
        return this.globalSwitch;
    }

    public Integer S() {
        Integer num = this.splashmode;
        if (num == null) {
            return null;
        }
        return Integer.valueOf((1 == num.intValue() || 2 == this.splashmode.intValue() || 3 == this.splashmode.intValue()) ? this.splashmode.intValue() : 1);
    }

    public String V() {
        return this.trustAppList;
    }

    public long Z() {
        long j = this.sloganShowMinTimeRealMode;
        if (j < 0 || j > 5000) {
            return 300L;
        }
        return j;
    }

    public List<String> a() {
        return this.defBrowerPkgList;
    }

    public long b() {
        return this.preloadSplashReqTimeInterval;
    }

    public Long c() {
        return this.minBannerInterval;
    }

    public Long d() {
        return this.maxBannerInterval;
    }

    public Long e() {
        return Long.valueOf(this.locationExpireTime.longValue() > 0 ? this.locationExpireTime.longValue() : 1800000L);
    }

    public int f() {
        return this.locationSwitch;
    }

    public Long g() {
        return Long.valueOf(this.locationRefreshInterval.longValue() > 0 ? this.locationRefreshInterval.longValue() : 1800000L);
    }

    public double h() {
        double d = this.limitOfContainerAspectRatio;
        if (d <= OOXIXo.f3760XO) {
            return 0.05000000074505806d;
        }
        return d;
    }

    public Integer i() {
        return this.adsCoreSel;
    }

    public String j() {
        return this.testCountryCode;
    }

    public String k() {
        return this.configMap;
    }

    public Integer l() {
        return this.bdinterval;
    }

    public Integer m() {
        return this.oaidReportOnNpa;
    }

    public Integer n() {
        return this.allowAdSkipTime;
    }

    public Integer o() {
        return this.splashInteractCloseEffectiveTime;
    }

    public List<String> p() {
        return this.singleInstanceLSModelList;
    }

    public String q() {
        return this.sha256;
    }

    public void B(Integer num) {
        this.splashInteractCloseEffectiveTime = num;
    }

    public void Code(double d) {
        this.limitOfContainerAspectRatio = d;
    }

    public void I(Integer num) {
        this.oaidReportOnNpa = num;
    }

    public void V(Integer num) {
        this.bdinterval = num;
    }

    public void Z(Integer num) {
        this.allowAdSkipTime = num;
    }

    public void Code(int i) {
        this.locationSwitch = i;
    }

    public void I(Long l) {
        this.locationExpireTime = l;
    }

    public void V(Long l) {
        this.maxBannerInterval = l;
    }

    public void Z(Long l) {
        this.locationRefreshInterval = l;
    }

    public void Code(Integer num) {
        this.adsCoreSel = num;
    }

    public void Code(Long l) {
        this.minBannerInterval = l;
    }

    public void Code(String str) {
        this.trustAppList = str;
    }

    public void Code(List<String> list) {
        this.singleInstanceLSModelList = list;
    }
}
