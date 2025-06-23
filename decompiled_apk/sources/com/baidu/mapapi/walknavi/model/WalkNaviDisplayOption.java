package com.baidu.mapapi.walknavi.model;

import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.view.View;

/* loaded from: classes7.dex */
public class WalkNaviDisplayOption implements com.baidu.mapapi.walknavi.adapter.a {

    /* renamed from: a, reason: collision with root package name */
    private Bitmap f6039a = null;
    private Bitmap b = null;
    private Bitmap c = null;
    private Bitmap d = null;
    private boolean e = true;
    private boolean f = false;
    private boolean g = false;
    private int h = 0;
    private boolean i = false;
    private int j = 0;
    private boolean k = false;
    private int l = 0;
    private Typeface m = null;
    private boolean n = true;
    private boolean o = true;
    private boolean p = true;
    private boolean q = true;
    private boolean r = true;
    private boolean s = true;
    private boolean t = true;
    private boolean u = true;
    private View v = null;
    private int w = 0;

    public int getBottomSettingLayout() {
        return this.l;
    }

    public int getBottomViewHeight() {
        return this.w;
    }

    public int getCalorieLayout() {
        return this.j;
    }

    public boolean getCalorieLayoutEnable() {
        return this.o;
    }

    public View getCustomBottomView() {
        return this.v;
    }

    public Bitmap getImageArCloseIcon() {
        return this.c;
    }

    public Bitmap getImageNPC() {
        return this.d;
    }

    public Bitmap getImageToAR() {
        return this.f6039a;
    }

    public Bitmap getImageToNormal() {
        return this.b;
    }

    public boolean getIsCustomWNaviCalorieLayout() {
        return this.i;
    }

    public boolean getIsCustomWNaviGuideLayout() {
        return this.g;
    }

    public boolean getIsCustomWNaviRgBarLayout() {
        return this.k;
    }

    public boolean getIsShowBottomGuideLayout() {
        return this.r;
    }

    public boolean getIsShowBottomSmallMapUI() {
        return this.s;
    }

    public boolean getIsShowTopGuideLayout() {
        return this.q;
    }

    public boolean getShowDialogEnable() {
        return this.u;
    }

    public boolean getShowImageToAR() {
        return this.n;
    }

    public boolean getShowImageToLocation() {
        return this.p;
    }

    public int getTopGuideLayout() {
        return this.h;
    }

    public Typeface getWNaviTextTypeface() {
        return this.m;
    }

    public boolean isAutoChaneNaviMode() {
        return this.t;
    }

    public boolean isIsRunInFragment() {
        return this.f;
    }

    public boolean isShowDialogWithExitNavi() {
        return this.e;
    }

    public WalkNaviDisplayOption setAutoChangeNaviMode(boolean z) {
        this.t = z;
        return this;
    }

    public WalkNaviDisplayOption showBottomSmallMapUI(boolean z) {
        this.s = z;
        return this;
    }

    public WalkNaviDisplayOption imageToAr(Bitmap bitmap) {
        this.f6039a = bitmap;
        return this;
    }

    public WalkNaviDisplayOption imageToNormal(Bitmap bitmap) {
        this.b = bitmap;
        return this;
    }

    public WalkNaviDisplayOption runInFragment(boolean z) {
        this.f = z;
        return this;
    }

    public WalkNaviDisplayOption setArNaviResources(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3) {
        this.c = bitmap;
        this.d = bitmap2;
        this.b = bitmap3;
        return this;
    }

    public WalkNaviDisplayOption setBottomSettingLayout(int i) {
        this.k = true;
        this.l = i;
        return this;
    }

    public WalkNaviDisplayOption setCalorieLayout(int i) {
        this.i = true;
        this.j = i;
        return this;
    }

    public WalkNaviDisplayOption setCustomBottomView(View view) {
        this.v = view;
        return this;
    }

    public WalkNaviDisplayOption setCustomBottomViewHeight(int i) {
        if (i > 70) {
            this.w = 70;
        } else {
            this.w = i;
        }
        return this;
    }

    public WalkNaviDisplayOption setNaviTextTypeface(Typeface typeface) {
        this.m = typeface;
        return this;
    }

    public WalkNaviDisplayOption setTopGuideLayout(int i) {
        this.g = true;
        this.h = i;
        return this;
    }

    public WalkNaviDisplayOption showBottomGuideLayout(boolean z) {
        this.r = z;
        return this;
    }

    public WalkNaviDisplayOption showCalorieLayoutEnable(boolean z) {
        this.o = z;
        return this;
    }

    public WalkNaviDisplayOption showDialogEnable(boolean z) {
        this.u = z;
        return this;
    }

    public WalkNaviDisplayOption showDialogWithExitNavi(boolean z) {
        this.e = z;
        return this;
    }

    public WalkNaviDisplayOption showImageToAr(boolean z) {
        this.n = z;
        return this;
    }

    public WalkNaviDisplayOption showLocationImage(boolean z) {
        this.p = z;
        return this;
    }

    public WalkNaviDisplayOption showTopGuideLayout(boolean z) {
        this.q = z;
        return this;
    }
}
