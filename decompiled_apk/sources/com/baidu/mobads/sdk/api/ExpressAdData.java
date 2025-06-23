package com.baidu.mobads.sdk.api;

import com.baidu.mobads.sdk.internal.a;
import java.util.List;

/* loaded from: classes7.dex */
public class ExpressAdData {
    private String adPlaceId;
    private String desc;
    private String iconUrl;
    private String imageUrl;
    private List<String> multiPicUrls;
    private String pk;
    private String title;
    private String videoUrl;

    public ExpressAdData(a aVar, String str) {
        this.title = "";
        this.desc = "";
        this.iconUrl = "";
        this.pk = "";
        this.imageUrl = "";
        this.videoUrl = "";
        this.multiPicUrls = null;
        this.adPlaceId = str;
        this.title = aVar.a();
        this.desc = aVar.b();
        this.iconUrl = aVar.c();
        this.pk = aVar.m();
        this.imageUrl = aVar.d();
        this.videoUrl = aVar.n();
        this.multiPicUrls = aVar.G();
    }

    public String getAdPlaceId() {
        return this.adPlaceId;
    }

    public String getAppPackage() {
        return this.pk;
    }

    public String getDesc() {
        return this.desc;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public List<String> getMultiPicUrls() {
        return this.multiPicUrls;
    }

    public String getTitle() {
        return this.title;
    }

    public String getVideoUrl() {
        return this.videoUrl;
    }
}
