package com.github.appintro;

import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import kotlin.OOXIXo;
import kotlin.XX;

/* loaded from: classes9.dex */
public interface SlideBackgroundColorHolder {

    /* loaded from: classes9.dex */
    public static final class DefaultImpls {
        @OOXIXo(message = "`defaultBackgroundColor` has been deprecated to support configuration changes", replaceWith = @XX(expression = "defaultBackgroundColorRes", imports = {}))
        public static /* synthetic */ void getDefaultBackgroundColor$annotations() {
        }
    }

    @ColorInt
    int getDefaultBackgroundColor();

    @ColorRes
    int getDefaultBackgroundColorRes();

    void setBackgroundColor(@ColorInt int i);
}
