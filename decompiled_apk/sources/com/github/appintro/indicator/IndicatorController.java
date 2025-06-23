package com.github.appintro.indicator;

import OXOo.OOXIXo;
import android.content.Context;
import android.view.View;
import androidx.annotation.ColorInt;

/* loaded from: classes9.dex */
public interface IndicatorController {
    @ColorInt
    int getSelectedIndicatorColor();

    @ColorInt
    int getUnselectedIndicatorColor();

    void initialize(int i);

    @OOXIXo
    View newInstance(@OOXIXo Context context);

    void selectPosition(int i);

    void setSelectedIndicatorColor(int i);

    void setUnselectedIndicatorColor(int i);
}
