package com.baidu.mobads.sdk.api;

/* loaded from: classes7.dex */
public enum ActionBarColorTheme {
    ACTION_BAR_WHITE_THEME(-5987164, -6842473, -11113262, -328966),
    ACTION_BAR_RED_THEME(-1, -1, -12510, -1294276),
    ACTION_BAR_GREEN_THEME(-1, -1, -11113262, -14303071),
    ACTION_BAR_NAVYBLUE_THEME(-1, -1, 16764706, -14210226),
    ACTION_BAR_BLUE_THEME(-1, -1, -12510, -13870424),
    ACTION_BAR_COFFEE_THEME(-1, -1, -12510, -11255230),
    ACTION_BAR_BLACK_THEME(-1, -1, -12510, -13749450);

    public int mBackgroundColor;
    public int mCloseColor;
    public int mProgressColor;
    public int mTitleColor;

    ActionBarColorTheme(int i, int i2, int i3, int i4) {
        this.mCloseColor = i;
        this.mTitleColor = i2;
        this.mProgressColor = i3;
        this.mBackgroundColor = i4;
    }
}
