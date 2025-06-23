package com.huawei.hms.ads.utils;

import android.text.TextUtils;
import com.huawei.hms.ads.RequestOptions;
import com.huawei.hms.ads.k;

/* loaded from: classes10.dex */
public class c {
    public static RequestOptions Code(RequestOptions requestOptions) {
        RequestOptions I = k.Code().I();
        if (requestOptions == null) {
            return I;
        }
        RequestOptions.Builder builder = requestOptions.toBuilder();
        if (requestOptions.B() == null) {
            builder.setAdContentClassification(I.getAdContentClassification());
        }
        if (requestOptions.getTagForUnderAgeOfPromise() == null) {
            builder.setTagForUnderAgeOfPromise(I.getTagForUnderAgeOfPromise());
        }
        if (requestOptions.getTagForChildProtection() == null) {
            builder.setTagForChildProtection(I.getTagForChildProtection());
        }
        if (requestOptions.getNonPersonalizedAd() == null) {
            builder.setNonPersonalizedAd(I.getNonPersonalizedAd());
        }
        if (requestOptions.getIsQueryUseEnabled() == null) {
            builder.setIsQueryUseEnabled(I.getIsQueryUseEnabled());
        }
        if (requestOptions.Code() == null) {
            builder.setHwNonPersonalizedAd(I.Code());
        }
        if (requestOptions.V() == null) {
            builder.setThirdNonPersonalizedAd(I.V());
        }
        if (requestOptions.getAppLang() == null) {
            builder.setAppLang(I.getAppLang());
        }
        if (requestOptions.getAppCountry() == null) {
            builder.setAppCountry(I.getAppCountry());
        }
        if (requestOptions.getApp() == null) {
            builder.setApp(I.getApp());
        }
        if (TextUtils.isEmpty(requestOptions.getConsent())) {
            builder.setConsent(I.getConsent());
        }
        if (requestOptions.Z() == null) {
            builder.setRequestLocation(I.Z());
        }
        if (requestOptions.S() == null) {
            builder.setSearchInfo(I.S());
        }
        if (requestOptions.L() == null) {
            builder.setSupportFa(I.L());
        }
        return builder.build();
    }
}
