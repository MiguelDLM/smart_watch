package com.baidu.navisdk.ui.widget.likebutton;

import androidx.annotation.DrawableRes;

/* loaded from: classes8.dex */
public class Icon {
    private int offIconResourceId;
    private int onIconResourceId;

    public Icon(@DrawableRes int i, @DrawableRes int i2) {
        this.onIconResourceId = i;
        this.offIconResourceId = i2;
    }

    public int getOffIconResourceId() {
        return this.offIconResourceId;
    }

    public int getOnIconResourceId() {
        return this.onIconResourceId;
    }

    public void setOffIconResourceId(@DrawableRes int i) {
        this.offIconResourceId = i;
    }

    public void setOnIconResourceId(@DrawableRes int i) {
        this.onIconResourceId = i;
    }
}
