package com.baidu.navisdk.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* loaded from: classes8.dex */
public final class BNHorizontalBtnMenuLayout extends LinearLayout {
    private CharSequence[] mContents;
    private int mDefaultTxtColor;
    private int[] mSelectedDrawableId;
    private int mSelectedTxtColor;
    private int mTextSize;
    private int[] mUnselectedDrawableId;

    /* loaded from: classes8.dex */
    public interface OnClickButtonListener {
        void onClickButton(int i, View view);
    }

    public BNHorizontalBtnMenuLayout(Context context) {
        super(context);
        this.mDefaultTxtColor = -1;
        this.mSelectedTxtColor = -1;
        this.mTextSize = -1;
    }

    public BNHorizontalBtnMenuLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mDefaultTxtColor = -1;
        this.mSelectedTxtColor = -1;
        this.mTextSize = -1;
    }

    public BNHorizontalBtnMenuLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mDefaultTxtColor = -1;
        this.mSelectedTxtColor = -1;
        this.mTextSize = -1;
    }

    @RequiresApi(api = 21)
    public BNHorizontalBtnMenuLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mDefaultTxtColor = -1;
        this.mSelectedTxtColor = -1;
        this.mTextSize = -1;
    }
}
