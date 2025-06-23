package com.baidu.navisdk.ui.routeguide.model;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;

/* loaded from: classes8.dex */
public class RGLineItem {
    public boolean bRecommend;
    public boolean bVailable;
    public boolean isAdd;
    public boolean isBack;
    public boolean isBackBright;
    public boolean isBusLaneBright;
    public boolean isBusLaneTextBright;
    public boolean isBusLine;
    public boolean isFront;
    public boolean isFrontBright;
    public boolean isHov;
    public boolean isHovBright;
    public boolean isLeft;
    public boolean isLeftBright;
    public boolean isORNLane;
    public boolean isRight;
    public boolean isRightBright;
    public boolean isSub;
    public boolean isTidalAvailable;
    public boolean isTidalAvailableBright;
    public boolean isTidalFront;
    public boolean isTidalFrontBright;
    public boolean isTidalText;
    public boolean isTidalTextBright;
    public boolean isVariable;
    public boolean isVariableBright;

    public RGLineItem() {
    }

    public Drawable getDrawable(Context context) {
        if (context == null) {
            return null;
        }
        int imageIDFromItem = RGLaneInfoModel.getModel(false).getImageIDFromItem(this);
        if (imageIDFromItem == 99) {
            return new ColorDrawable(5149694);
        }
        return context.getResources().getDrawable(imageIDFromItem);
    }

    public String getResName() {
        return RGLaneInfoModel.getModel(false).getImageNameFromItem(this);
    }

    public String toString() {
        return String.format("[isORNLane=%b, isBusLine=%b, isFront=%b, isFrontBright=%b, isLeft=%b, isLeftBright=%b, isRight=%b,isRightBright=%b,isBack=%b,isBackBright=%b,isBusLaneBright=%b,isVariable=%b,isVariableBright=%b,isHov=%b,isHovBright=%b,isTidalText=%b,isTidalTextBright=%b,isTidalFront=%b,isTidalFrontBright=%b,isTidalAvailable=%b,isTidalAvailableBright=%b,bRecommend=%b,isBusLaneTextBright=%b]", Boolean.valueOf(this.isORNLane), Boolean.valueOf(this.isBusLine), Boolean.valueOf(this.isFront), Boolean.valueOf(this.isFrontBright), Boolean.valueOf(this.isLeft), Boolean.valueOf(this.isLeftBright), Boolean.valueOf(this.isRight), Boolean.valueOf(this.isRightBright), Boolean.valueOf(this.isBack), Boolean.valueOf(this.isBackBright), Boolean.valueOf(this.isBusLaneBright), Boolean.valueOf(this.isVariable), Boolean.valueOf(this.isVariableBright), Boolean.valueOf(this.isHov), Boolean.valueOf(this.isHovBright), Boolean.valueOf(this.isTidalText), Boolean.valueOf(this.isTidalTextBright), Boolean.valueOf(this.isTidalFront), Boolean.valueOf(this.isTidalFrontBright), Boolean.valueOf(this.isTidalAvailable), Boolean.valueOf(this.isTidalAvailableBright), Boolean.valueOf(this.bRecommend), Boolean.valueOf(this.isBusLaneTextBright));
    }

    public RGLineItem(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16, boolean z17, boolean z18, boolean z19, boolean z20, boolean z21, boolean z22) {
        this.isAdd = z;
        this.isSub = z2;
        this.isBusLine = z3;
        this.isFront = z4;
        this.isFrontBright = z5;
        this.isLeft = z6;
        this.isLeftBright = z7;
        this.isRight = z8;
        this.isRightBright = z9;
        this.isBack = z10;
        this.isBackBright = z11;
        this.isBusLaneTextBright = z12;
        this.isVariable = z13;
        this.isVariableBright = z14;
        this.isHov = z15;
        this.isHovBright = z16;
        this.isTidalText = z17;
        this.isTidalTextBright = z18;
        this.isTidalFront = z19;
        this.isTidalFrontBright = z20;
        this.isTidalAvailable = z21;
        this.isTidalAvailableBright = z22;
    }
}
