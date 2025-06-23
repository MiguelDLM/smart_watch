package com.alibaba.sdk.android.oss.common.utils;

import XXO0.oIX0oI;
import android.os.Build;
import com.alibaba.sdk.android.oss.common.OSSLog;
import com.huawei.openalliance.ad.constant.x;
import org.apache.log4j.spi.LocationInfo;

/* loaded from: classes.dex */
public class VersionInfoUtils {
    private static String userAgent;

    private static String getSystemInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(oIX0oI.I0Io.f4096II0xO0);
        sb.append(System.getProperty("os.name"));
        sb.append("/Android " + Build.VERSION.RELEASE);
        sb.append("/");
        sb.append(HttpUtil.urlEncode(Build.MODEL, "utf-8") + x.aL + HttpUtil.urlEncode(Build.ID, "utf-8"));
        sb.append(oIX0oI.I0Io.f4095I0Io);
        String sb2 = sb.toString();
        OSSLog.logDebug("user agent : " + sb2);
        if (OSSUtils.isEmptyString(sb2)) {
            return System.getProperty("http.agent").replaceAll("[^\\p{ASCII}]", LocationInfo.NA);
        }
        return sb2;
    }

    public static String getUserAgent(String str) {
        if (OSSUtils.isEmptyString(userAgent)) {
            userAgent = "aliyun-sdk-android/" + getVersion() + getSystemInfo();
        }
        if (OSSUtils.isEmptyString(str)) {
            return userAgent;
        }
        return userAgent + "/" + str;
    }

    public static String getVersion() {
        return "2.9.19";
    }
}
