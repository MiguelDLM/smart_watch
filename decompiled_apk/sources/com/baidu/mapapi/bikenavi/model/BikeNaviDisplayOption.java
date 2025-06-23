package com.baidu.mapapi.bikenavi.model;

import android.graphics.Typeface;
import android.view.View;

/* loaded from: classes7.dex */
public class BikeNaviDisplayOption implements com.baidu.mapapi.bikenavi.adapter.a {
    private int mTopGuideLayout = 0;
    private boolean useCustomTopGuideLayout = false;
    private int mSpeedLayout = 0;
    private boolean useCustomSpeedLayout = false;
    private int mBottomSettingLayout = 0;
    private boolean useCustomBottomSetting = false;
    private Typeface mBikeNaviTypeface = null;
    private boolean mShowImageToLocation = true;
    private boolean mShowTopLayout = true;
    private boolean mShowSpeedLayout = true;
    private boolean mShowBottomGuideLayout = true;
    private boolean mShowDialogEnable = true;
    private View mCustomBottomView = null;
    private int mBottomViewHeight = 0;
    private boolean mIsRunInFragment = false;

    public Typeface getBikeNaviTypeface() {
        return this.mBikeNaviTypeface;
    }

    public int getBottomSettingLayout() {
        return this.mBottomSettingLayout;
    }

    public int getBottomViewHeight() {
        return this.mBottomViewHeight;
    }

    public View getCustomBottomView() {
        return this.mCustomBottomView;
    }

    public boolean getIsShowBottomGuideLayout() {
        return this.mShowBottomGuideLayout;
    }

    public boolean getShowDialogEnable() {
        return this.mShowDialogEnable;
    }

    public boolean getShowImageToLocation() {
        return this.mShowImageToLocation;
    }

    public boolean getShowSpeedLayout() {
        return this.mShowSpeedLayout;
    }

    public boolean getShowTopLayout() {
        return this.mShowTopLayout;
    }

    public int getSpeedLayout() {
        return this.mSpeedLayout;
    }

    public int getTopGuideLayout() {
        return this.mTopGuideLayout;
    }

    public boolean isIsRunInFragment() {
        return this.mIsRunInFragment;
    }

    public boolean isUseCustomBottomSetting() {
        return this.useCustomBottomSetting;
    }

    public boolean isUseCustomSpeedLayout() {
        return this.useCustomSpeedLayout;
    }

    public boolean isUseCustomTopGuideLayout() {
        return this.useCustomTopGuideLayout;
    }

    public String toString() {
        return "BikeNaviDisplayOption{mTopGuideLayout=" + this.mTopGuideLayout + ", useCustomTopGuideLayout=" + this.useCustomTopGuideLayout + ", mSpeedLayout=" + this.mSpeedLayout + ", useCustomSpeedLayout=" + this.useCustomSpeedLayout + ", mBottomSettingLayout=" + this.mBottomSettingLayout + ", useCustomBottomSetting=" + this.useCustomBottomSetting + ", mBikeNaviTypeface=" + this.mBikeNaviTypeface + ", mShowImageToLocation=" + this.mShowImageToLocation + ", mShowTopLayout=" + this.mShowTopLayout + ", mShowSpeedLayout=" + this.mShowSpeedLayout + ", mShowBottomGuideLayout=" + this.mShowBottomGuideLayout + ", mShowDialogEnable=" + this.mShowDialogEnable + '}';
    }

    public BikeNaviDisplayOption runInFragment(boolean z) {
        this.mIsRunInFragment = z;
        return this;
    }

    public BikeNaviDisplayOption setBottomSettingLayout(int i) {
        this.mBottomSettingLayout = i;
        this.useCustomBottomSetting = true;
        return this;
    }

    public BikeNaviDisplayOption setCustomBottomView(View view) {
        this.mCustomBottomView = view;
        return this;
    }

    public BikeNaviDisplayOption setCustomBottomViewHeight(int i) {
        if (i > 70) {
            this.mBottomViewHeight = 70;
        } else {
            this.mBottomViewHeight = i;
        }
        return this;
    }

    public BikeNaviDisplayOption setNaviTextTypeface(Typeface typeface) {
        this.mBikeNaviTypeface = typeface;
        return this;
    }

    public BikeNaviDisplayOption setSpeedLayout(int i) {
        this.mSpeedLayout = i;
        this.useCustomSpeedLayout = true;
        return this;
    }

    public BikeNaviDisplayOption setTopGuideLayout(int i) {
        this.mTopGuideLayout = i;
        this.useCustomTopGuideLayout = true;
        return this;
    }

    public BikeNaviDisplayOption showBottomGuideLayout(boolean z) {
        this.mShowBottomGuideLayout = z;
        return this;
    }

    public BikeNaviDisplayOption showDialogEnable(boolean z) {
        this.mShowDialogEnable = z;
        return this;
    }

    public BikeNaviDisplayOption showLocationImage(boolean z) {
        this.mShowImageToLocation = z;
        return this;
    }

    public BikeNaviDisplayOption showSpeedLayout(boolean z) {
        this.mShowSpeedLayout = z;
        return this;
    }

    public BikeNaviDisplayOption showTopGuideLayout(boolean z) {
        this.mShowTopLayout = z;
        return this;
    }
}
