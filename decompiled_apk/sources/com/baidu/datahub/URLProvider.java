package com.baidu.datahub;

/* loaded from: classes7.dex */
public class URLProvider {
    public String getPullSpecificRouteDomain() {
        return "https://api.map.baidu.com/sdkproxy/lbs_navsdk_mini/tripshare/v1/driver/pullroute";
    }

    public String getRegisterOrderDomain() {
        return "https://api.map.baidu.com/sdkproxy/lbs_navsdk_mini/tripshare/v1/driver/regorder";
    }

    public String getUpdateDriverStatusDomain() {
        return "https://api.map.baidu.com/sdkproxy/lbs_navsdk_mini/tripshare/v1/driver/modifypathstatus";
    }

    public String getUpdateOrderInfoDomain() {
        return "https://api.map.baidu.com/sdkproxy/lbs_navsdk_mini/tripshare/v1/driver/updatestatus";
    }

    public String getUpdateRouteDomain() {
        return "https://api.map.baidu.com/sdkproxy/lbs_navsdk_mini/tripshare/v1/driver/updatepath";
    }

    public String getUploadLocationETA() {
        return "https://api.map.baidu.com/sdkproxy/lbs_navsdk_mini/tripshare/v1/driver/uploadloc";
    }

    public String getUploadSpecificRouteDomain() {
        return "https://api.map.baidu.com/sdkproxy/lbs_navsdk_mini/tripshare/v1/passenger/setroute";
    }
}
