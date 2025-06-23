package com.baidu.ar.content;

import com.baidu.ar.bean.ARCaseBundleInfo;
import com.baidu.ar.bean.FunctionType;
import java.io.File;
import java.util.Map;

/* loaded from: classes7.dex */
public class ARResourceInfo implements IARCaseInfo {
    public String acId;
    public String arKey;
    public int arType;
    public ARCaseBundleInfo caseBundleInfo;
    public String caseDir;
    public Map<FunctionType, Boolean> features;
    public boolean hardwareSatisfied;
    public String[] multiResourceUrl;
    public String redirectUrl;
    public boolean refused;
    public String resourceUrl;
    public boolean showAudioDialog;
    public String thumbnailUrl;
    public String versionCode;
    public String zipMd5;

    @Override // com.baidu.ar.content.IARCaseInfo
    public String getARKey() {
        return this.arKey;
    }

    @Override // com.baidu.ar.content.IARCaseInfo
    public int getARType() {
        return this.arType;
    }

    @Override // com.baidu.ar.content.IARCaseInfo
    public String getAcId() {
        return this.acId;
    }

    @Override // com.baidu.ar.content.IARCaseInfo
    public String getArCasePath() {
        if (this.caseBundleInfo != null) {
            return new File(this.caseBundleInfo.caseDir).getParent();
        }
        return null;
    }

    @Override // com.baidu.ar.content.IARCaseInfo
    public ARCaseBundleInfo getCaseBundleInfo() {
        return this.caseBundleInfo;
    }

    @Override // com.baidu.ar.content.IARCaseInfo
    public Map<FunctionType, Boolean> getFeatures() {
        return this.features;
    }

    @Override // com.baidu.ar.content.IARCaseInfo
    public String[] getMultiResourceUrl() {
        return this.multiResourceUrl;
    }

    @Override // com.baidu.ar.content.IARCaseInfo
    public String getRedirectUrl() {
        return this.redirectUrl;
    }

    @Override // com.baidu.ar.content.IARCaseInfo
    public String getResourceUrl() {
        return this.resourceUrl;
    }

    @Override // com.baidu.ar.content.IARCaseInfo
    public String getThumbnailUrl() {
        return this.thumbnailUrl;
    }

    @Override // com.baidu.ar.content.IARCaseInfo
    public String getVersionCode() {
        return this.versionCode;
    }

    @Override // com.baidu.ar.content.IARCaseInfo
    public String getZipMd5() {
        return this.zipMd5;
    }

    @Override // com.baidu.ar.content.IARCaseInfo
    public boolean isHardwareSatisfied() {
        return this.hardwareSatisfied;
    }

    @Override // com.baidu.ar.content.IARCaseInfo
    public boolean isRefused() {
        return this.refused;
    }

    @Override // com.baidu.ar.content.IARCaseInfo
    public boolean isShowAudioDialog() {
        return this.showAudioDialog;
    }
}
