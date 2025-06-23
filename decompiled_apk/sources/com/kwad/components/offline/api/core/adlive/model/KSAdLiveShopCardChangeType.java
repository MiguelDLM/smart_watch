package com.kwad.components.offline.api.core.adlive.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes11.dex */
public @interface KSAdLiveShopCardChangeType {
    public static final int BARGAIN_CHANGE = 6;
    public static final int END_RECORD = 3;
    public static final int ITEM_INFO_CHANGE = 4;
    public static final int OFFSALE = 1;
    public static final int ONSALE = 0;
    public static final int SPECIFIC_ITEM_ONSALE = 5;
    public static final int START_RECORD = 2;
}
