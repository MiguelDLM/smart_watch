package com.jd.ad.sdk.jad_ly;

import com.jd.ad.sdk.dl.addata.JADMaterialData;
import java.util.Collections;
import java.util.List;

/* loaded from: classes10.dex */
public class jad_an implements JADMaterialData {
    public int jad_hu;
    public int jad_iv;
    public int jad_jw;
    public int jad_kx;
    public int jad_ly;
    public int jad_mz;
    public int jad_na;
    public int jad_ob;
    public int jad_pc;
    public String jad_an = "";
    public String jad_bo = "";
    public List<String> jad_cp = Collections.emptyList();
    public String jad_dq = "";
    public String jad_er = "";
    public String jad_fs = "";
    public String jad_jt = "";

    @Override // com.jd.ad.sdk.dl.addata.JADMaterialData
    public int getAutoPlay() {
        return this.jad_mz;
    }

    @Override // com.jd.ad.sdk.dl.addata.JADMaterialData
    public String getDescription() {
        return this.jad_bo;
    }

    @Override // com.jd.ad.sdk.dl.addata.JADMaterialData
    public String getDownloadUrl() {
        return this.jad_fs;
    }

    @Override // com.jd.ad.sdk.dl.addata.JADMaterialData
    public int getEventInteractionType() {
        return this.jad_iv;
    }

    @Override // com.jd.ad.sdk.dl.addata.JADMaterialData
    public int getImageHeight() {
        return this.jad_kx;
    }

    @Override // com.jd.ad.sdk.dl.addata.JADMaterialData
    public List<String> getImageUrls() {
        return this.jad_cp;
    }

    @Override // com.jd.ad.sdk.dl.addata.JADMaterialData
    public int getImageWidth() {
        return this.jad_jw;
    }

    @Override // com.jd.ad.sdk.dl.addata.JADMaterialData
    public int getMediaSpecSetType() {
        return this.jad_hu;
    }

    @Override // com.jd.ad.sdk.dl.addata.JADMaterialData
    public String getMediaStyle() {
        return this.jad_jt;
    }

    @Override // com.jd.ad.sdk.dl.addata.JADMaterialData
    public int getMuted() {
        return this.jad_ly;
    }

    @Override // com.jd.ad.sdk.dl.addata.JADMaterialData
    public String getResource() {
        return this.jad_dq;
    }

    @Override // com.jd.ad.sdk.dl.addata.JADMaterialData
    public String getTitle() {
        return this.jad_an;
    }

    @Override // com.jd.ad.sdk.dl.addata.JADMaterialData
    public int getVideoDuration() {
        return this.jad_na;
    }

    @Override // com.jd.ad.sdk.dl.addata.JADMaterialData
    public int getVideoResolutionHeight() {
        return this.jad_pc;
    }

    @Override // com.jd.ad.sdk.dl.addata.JADMaterialData
    public int getVideoResolutionWidth() {
        return this.jad_ob;
    }

    @Override // com.jd.ad.sdk.dl.addata.JADMaterialData
    public String getVideoUrl() {
        return this.jad_er;
    }
}
