package com.huawei.openalliance.ad.beans.metadata;

import com.huawei.openalliance.ad.annotations.DataKeep;
import com.huawei.openalliance.ad.utils.ad;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@DataKeep
/* loaded from: classes10.dex */
public class MetaData implements Serializable {
    private static final long serialVersionUID = 5884097861234973073L;
    private String adSign;
    private List<AdSource> adSources;
    private ApkInfo apkInfo;
    private String appPromotionChannel;
    private String cta;
    private String description;
    private List<ImageInfo> icon;
    private List<ImageInfo> imageInfo;

    @com.huawei.openalliance.ad.annotations.a
    private String intent;
    private String label;
    private String marketAppId;
    private MediaFile mediaFile;
    private List<MediaFile> mediaFiles;
    private String privacyUrl;
    private PromoteInfo promoteInfo;
    private Integer showAppElement;
    private List<String> subDescriptions;
    private List<TextState> textStateList;
    private String title;
    private VideoInfo videoInfo;
    private long minEffectiveShowTime = 500;
    private int minEffectiveShowRatio = 50;
    private long duration = 0;

    public String B() {
        return this.description;
    }

    public List<String> C() {
        return this.subDescriptions;
    }

    public String Code() {
        return this.cta;
    }

    public int D() {
        return this.minEffectiveShowRatio;
    }

    public long F() {
        return this.minEffectiveShowTime;
    }

    public String I() {
        return this.privacyUrl;
    }

    public String L() {
        return this.label;
    }

    public List<ImageInfo> S() {
        return this.icon;
    }

    public VideoInfo V() {
        return this.videoInfo;
    }

    public String Z() {
        return this.title;
    }

    public String a() {
        return this.appPromotionChannel;
    }

    public String b() {
        return this.marketAppId;
    }

    public String c() {
        return this.intent;
    }

    public List<ImageInfo> d() {
        return this.imageInfo;
    }

    public ApkInfo e() {
        return this.apkInfo;
    }

    public PromoteInfo f() {
        return this.promoteInfo;
    }

    public String g() {
        return this.adSign;
    }

    public MediaFile h() {
        return this.mediaFile;
    }

    public List<TextState> i() {
        return this.textStateList;
    }

    public List<MediaFile> j() {
        return this.mediaFiles;
    }

    public long k() {
        return this.duration;
    }

    public List<AdSource> l() {
        return this.adSources;
    }

    public List<String> m() {
        ArrayList arrayList = new ArrayList();
        VideoInfo videoInfo = this.videoInfo;
        if (videoInfo != null) {
            arrayList.add(videoInfo.V());
        }
        return arrayList;
    }

    public List<String> n() {
        ArrayList arrayList = new ArrayList();
        if (!ad.Code(this.imageInfo)) {
            Iterator<ImageInfo> it = this.imageInfo.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().F());
            }
        }
        return arrayList;
    }

    public boolean o() {
        Integer num = this.showAppElement;
        return num != null && num.intValue() == 1;
    }

    public void Code(PromoteInfo promoteInfo) {
        this.promoteInfo = promoteInfo;
    }

    public void V(String str) {
        this.adSign = str;
    }

    public void Code(VideoInfo videoInfo) {
        this.videoInfo = videoInfo;
    }

    public void V(List<AdSource> list) {
        this.adSources = list;
    }

    public void Code(Integer num) {
        this.showAppElement = num;
    }

    public void Code(String str) {
        this.privacyUrl = str;
    }

    public void Code(List<ImageInfo> list) {
        this.imageInfo = list;
    }
}
