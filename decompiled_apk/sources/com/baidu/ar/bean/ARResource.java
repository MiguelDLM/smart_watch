package com.baidu.ar.bean;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.animation.LinearInterpolator;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes7.dex */
public class ARResource {
    public static final int DOWNLOAD_STATUS_DOWNLOADED = -2;
    public static final int DOWNLOAD_STATUS_FAILED = -3;
    public static final int DOWNLOAD_STATUS_NONE = -1;
    public static final int DOWNLOAD_STATUS_WAIT = -4;
    private String mARCseName;
    private String mARKey;
    private int mARType;
    private String mAcId;
    private ValueAnimator mAnimator;
    private String mCaseConfigJsonInfo;
    private String mCodeDownloadUrl;
    private String mErrMsg;
    private Map<FunctionType, Boolean> mFunctionMap;
    public double[] mGPSInfo;
    private String[] mMultiResourceUrl;
    private String mRedirectUrl;
    private String mResFilePath;
    private String mResourceUrl;
    private boolean mShowAudioDialog;
    private int mSize;
    private String mThumbnailUrl;
    private String mVPSARkey;
    private String mVersionCode;
    private String mZipFilePath;
    private String mZipMd5;
    private int mErrCode = Integer.MIN_VALUE;
    private boolean mRefused = false;
    private boolean mHardwareSatisfied = true;
    private List<ARResource> mRelativeList = new ArrayList();
    private int mDownloadStatus = -1;

    public static boolean isDownloading(int i) {
        return i >= 0 && i <= 100;
    }

    public void createAnimator() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mAnimator = ofFloat;
        ofFloat.setDuration(200L);
        this.mAnimator.setInterpolator(new LinearInterpolator());
        this.mAnimator.addListener(new Animator.AnimatorListener() { // from class: com.baidu.ar.bean.ARResource.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                ARResource.this.mAnimator = null;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ARResource.this.mAnimator = null;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        this.mAnimator.start();
    }

    public String getARCseName() {
        return this.mARCseName;
    }

    public String getAcId() {
        return this.mAcId;
    }

    public ValueAnimator getAnimator() {
        return this.mAnimator;
    }

    public String getCaseConfigJsonInfo() {
        return this.mCaseConfigJsonInfo;
    }

    public String getCodeDownloadUrl() {
        return this.mCodeDownloadUrl;
    }

    public int getDownloadStatus() {
        return this.mDownloadStatus;
    }

    public int getErrCode() {
        return this.mErrCode;
    }

    public String getErrMsg() {
        return this.mErrMsg;
    }

    public Map<FunctionType, Boolean> getFunctionMap() {
        return this.mFunctionMap;
    }

    public double[] getGPSInfo() {
        return this.mGPSInfo;
    }

    public String getKey() {
        return this.mARKey;
    }

    public String[] getMultiResourceUrl() {
        return this.mMultiResourceUrl;
    }

    public String getRedirectUrl() {
        return this.mRedirectUrl;
    }

    public List<ARResource> getRelativeList() {
        return this.mRelativeList;
    }

    public String getResFilePath() {
        return this.mResFilePath;
    }

    public String getResourceUrl() {
        return this.mResourceUrl;
    }

    public int getSize() {
        return this.mSize;
    }

    public String getThumbnailUrl() {
        return this.mThumbnailUrl;
    }

    public int getType() {
        return this.mARType;
    }

    public String getVersionCode() {
        return this.mVersionCode;
    }

    public String getZipFilePath() {
        return this.mZipFilePath;
    }

    public String getZipMD5() {
        return this.mZipMd5;
    }

    public boolean isHardwareSatisfied() {
        return this.mHardwareSatisfied;
    }

    public boolean isRefused() {
        return this.mRefused;
    }

    public boolean isShowAudioDialog() {
        return this.mShowAudioDialog;
    }

    public void setARCseName(String str) {
        this.mARCseName = str;
    }

    public void setAcId(String str) {
        this.mAcId = str;
    }

    public void setCaseConfigJsonInfo(String str) {
        this.mCaseConfigJsonInfo = str;
    }

    public void setCodeDownloadUrl(String str) {
        this.mCodeDownloadUrl = str;
    }

    public void setDownloadStatus(int i) {
        this.mDownloadStatus = i;
    }

    public void setErrCode(int i) {
        this.mErrCode = i;
    }

    public void setErrMsg(String str) {
        this.mErrMsg = str;
    }

    public void setFunctionMap(Map<FunctionType, Boolean> map) {
        this.mFunctionMap = map;
    }

    public void setGPSInfo(double[] dArr) {
        this.mGPSInfo = dArr;
    }

    public void setHardwareSatisfied(boolean z) {
        this.mHardwareSatisfied = z;
    }

    public void setKey(String str) {
        this.mARKey = str;
    }

    public void setMultiResourceUrl(String[] strArr) {
        this.mMultiResourceUrl = strArr;
    }

    public void setRedirectUrl(String str) {
        this.mRedirectUrl = str;
    }

    public void setRefused(boolean z) {
        this.mRefused = z;
    }

    public void setRelativeList(List<ARResource> list) {
        this.mRelativeList = list;
    }

    public void setResFilePath(String str) {
        this.mResFilePath = str;
    }

    public void setResourceUrl(String str) {
        this.mResourceUrl = str;
    }

    public void setShowAudioDialog(boolean z) {
        this.mShowAudioDialog = z;
    }

    public void setSize(int i) {
        this.mSize = i;
    }

    public void setThumbnailUrl(String str) {
        this.mThumbnailUrl = str;
    }

    public void setType(int i) {
        this.mARType = i;
    }

    public void setVersionCode(String str) {
        this.mVersionCode = str;
    }

    public void setZipFilePath(String str) {
        this.mZipFilePath = str;
    }

    public void setZipMD5(String str) {
        this.mZipMd5 = str;
    }
}
