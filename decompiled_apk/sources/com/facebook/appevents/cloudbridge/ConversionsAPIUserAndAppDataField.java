package com.facebook.appevents.cloudbridge;

import OXOo.OOXIXo;
import com.android.installreferrer.api.ReferrerDetails;
import java.util.Arrays;

/* loaded from: classes8.dex */
public enum ConversionsAPIUserAndAppDataField {
    ANON_ID("anon_id"),
    FB_LOGIN_ID("fb_login_id"),
    MAD_ID("madid"),
    PAGE_ID("page_id"),
    PAGE_SCOPED_USER_ID("page_scoped_user_id"),
    USER_DATA("ud"),
    ADV_TE("advertiser_tracking_enabled"),
    APP_TE("application_tracking_enabled"),
    CONSIDER_VIEWS("consider_views"),
    DEVICE_TOKEN("device_token"),
    EXT_INFO("extInfo"),
    INCLUDE_DWELL_DATA("include_dwell_data"),
    INCLUDE_VIDEO_DATA("include_video_data"),
    INSTALL_REFERRER(ReferrerDetails.f5172II0xO0),
    INSTALLER_PACKAGE("installer_package"),
    RECEIPT_DATA("receipt_data"),
    URL_SCHEMES("url_schemes");


    @OOXIXo
    private final String rawValue;

    ConversionsAPIUserAndAppDataField(String str) {
        this.rawValue = str;
    }

    /* renamed from: values, reason: to resolve conflict with enum method */
    public static ConversionsAPIUserAndAppDataField[] valuesCustom() {
        ConversionsAPIUserAndAppDataField[] valuesCustom = values();
        return (ConversionsAPIUserAndAppDataField[]) Arrays.copyOf(valuesCustom, valuesCustom.length);
    }

    @OOXIXo
    public final String getRawValue() {
        return this.rawValue;
    }
}
