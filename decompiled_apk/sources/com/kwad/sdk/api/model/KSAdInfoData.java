package com.kwad.sdk.api.model;

import androidx.annotation.Keep;
import com.kwad.sdk.api.core.KsAdSdkApi;
import java.io.Serializable;
import java.util.List;

@KsAdSdkApi
@Keep
/* loaded from: classes11.dex */
public class KSAdInfoData implements Serializable {
    private static final long serialVersionUID = 689744866207726843L;
    private String adDescription;
    private String adSource;
    private String appIconUrl;
    private String appName;
    private long creativeId;
    private List<String> imageUrlArray;
    private int interactionType;
    private int materialType;
    private String productName;
    private String videoCoverImageUrl;
    private String videoUrl;

    private KSAdInfoData() {
    }

    public static KSAdInfoData obtain() {
        return new KSAdInfoData();
    }

    public String getAdDescription() {
        return this.adDescription;
    }

    public String getAdSource() {
        return this.adSource;
    }

    public String getAppIconUrl() {
        return this.appIconUrl;
    }

    public String getAppName() {
        return this.appName;
    }

    public long getCreativeId() {
        return this.creativeId;
    }

    public List<String> getImageUrlArray() {
        return this.imageUrlArray;
    }

    public int getInteractionType() {
        return this.interactionType;
    }

    public int getMaterialType() {
        return this.materialType;
    }

    public String getProductName() {
        return this.productName;
    }

    public String getVideoCoverImageUrl() {
        return this.videoCoverImageUrl;
    }

    public String getVideoUrl() {
        return this.videoUrl;
    }

    public KSAdInfoData setAdDescription(String str) {
        this.adDescription = str;
        return this;
    }

    public KSAdInfoData setAdSource(String str) {
        this.adSource = str;
        return this;
    }

    public KSAdInfoData setAppIconUrl(String str) {
        this.appIconUrl = str;
        return this;
    }

    public KSAdInfoData setAppName(String str) {
        this.appName = str;
        return this;
    }

    public KSAdInfoData setCreativeId(long j) {
        this.creativeId = j;
        return this;
    }

    public KSAdInfoData setImageList(List<String> list) {
        this.imageUrlArray = list;
        return this;
    }

    public KSAdInfoData setInteractionType(int i) {
        this.interactionType = i;
        return this;
    }

    public KSAdInfoData setMaterialType(int i) {
        this.materialType = i;
        return this;
    }

    public KSAdInfoData setProductName(String str) {
        this.productName = str;
        return this;
    }

    public KSAdInfoData setVideoCoverImageUrl(String str) {
        this.videoCoverImageUrl = str;
        return this;
    }

    public KSAdInfoData setVideoUrl(String str) {
        this.videoUrl = str;
        return this;
    }

    public String toString() {
        return "KSAdInfoData{adDescription='" + this.adDescription + "', productName='" + this.productName + "', adSource='" + this.adSource + "', imageUrlArray=" + this.imageUrlArray + ", videoUrl='" + this.videoUrl + "', videoCoverImageUrl='" + this.videoCoverImageUrl + "', materialType=" + this.materialType + ", appIconUrl='" + this.appIconUrl + "', appName='" + this.appName + "', interactionType=" + this.interactionType + ", creativeId=" + this.creativeId + '}';
    }
}
