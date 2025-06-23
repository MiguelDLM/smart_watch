package com.github.appintro.model;

import OXOo.oOoXoXO;
import XO0OX.xoIox;
import android.os.Bundle;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.FontRes;
import com.garmin.fit.OOxOOxIO;
import com.github.appintro.AppIntroBaseFragmentKt;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.OOXIXo;
import kotlin.XX;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes9.dex */
public final class SliderPage {
    private int backgroundColor;
    private int backgroundColorRes;
    private int backgroundDrawable;

    @oOoXoXO
    private CharSequence description;
    private int descriptionColor;
    private int descriptionColorRes;

    @oOoXoXO
    private String descriptionTypeface;
    private int descriptionTypefaceFontRes;
    private int imageDrawable;

    @oOoXoXO
    private CharSequence title;
    private int titleColor;
    private int titleColorRes;

    @oOoXoXO
    private String titleTypeface;
    private int titleTypefaceFontRes;

    @xoIox
    public SliderPage() {
        this(null, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, 0, OOxOOxIO.f12624oIX0oI, null);
    }

    @OOXIXo(message = "`backgroundColor` has been deprecated to support configuration changes", replaceWith = @XX(expression = "backgroundColorRes", imports = {}))
    public static /* synthetic */ void getBackgroundColor$annotations() {
    }

    @OOXIXo(message = "`descriptionColor` has been deprecated to support configuration changes", replaceWith = @XX(expression = "descriptionColorRes", imports = {}))
    public static /* synthetic */ void getDescriptionColor$annotations() {
    }

    @OOXIXo(message = "`titleColor` has been deprecated to support configuration changes", replaceWith = @XX(expression = "titleColorRes", imports = {}))
    public static /* synthetic */ void getTitleColor$annotations() {
    }

    @oOoXoXO
    public final CharSequence component1() {
        return this.title;
    }

    public final int component10() {
        return this.titleTypefaceFontRes;
    }

    public final int component11() {
        return this.descriptionTypefaceFontRes;
    }

    @oOoXoXO
    public final String component12() {
        return this.titleTypeface;
    }

    @oOoXoXO
    public final String component13() {
        return this.descriptionTypeface;
    }

    public final int component14() {
        return this.backgroundDrawable;
    }

    @oOoXoXO
    public final CharSequence component2() {
        return this.description;
    }

    public final int component3() {
        return this.imageDrawable;
    }

    public final int component4() {
        return this.backgroundColor;
    }

    public final int component5() {
        return this.titleColor;
    }

    public final int component6() {
        return this.descriptionColor;
    }

    public final int component7() {
        return this.backgroundColorRes;
    }

    public final int component8() {
        return this.titleColorRes;
    }

    public final int component9() {
        return this.descriptionColorRes;
    }

    @OXOo.OOXIXo
    public final SliderPage copy(@oOoXoXO CharSequence charSequence, @oOoXoXO CharSequence charSequence2, @DrawableRes int i, @ColorInt int i2, @ColorInt int i3, @ColorInt int i4, @ColorRes int i5, @ColorRes int i6, @ColorRes int i7, @FontRes int i8, @FontRes int i9, @oOoXoXO String str, @oOoXoXO String str2, @DrawableRes int i10) {
        return new SliderPage(charSequence, charSequence2, i, i2, i3, i4, i5, i6, i7, i8, i9, str, str2, i10);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SliderPage)) {
            return false;
        }
        SliderPage sliderPage = (SliderPage) obj;
        return IIX0o.Oxx0IOOO(this.title, sliderPage.title) && IIX0o.Oxx0IOOO(this.description, sliderPage.description) && this.imageDrawable == sliderPage.imageDrawable && this.backgroundColor == sliderPage.backgroundColor && this.titleColor == sliderPage.titleColor && this.descriptionColor == sliderPage.descriptionColor && this.backgroundColorRes == sliderPage.backgroundColorRes && this.titleColorRes == sliderPage.titleColorRes && this.descriptionColorRes == sliderPage.descriptionColorRes && this.titleTypefaceFontRes == sliderPage.titleTypefaceFontRes && this.descriptionTypefaceFontRes == sliderPage.descriptionTypefaceFontRes && IIX0o.Oxx0IOOO(this.titleTypeface, sliderPage.titleTypeface) && IIX0o.Oxx0IOOO(this.descriptionTypeface, sliderPage.descriptionTypeface) && this.backgroundDrawable == sliderPage.backgroundDrawable;
    }

    public final int getBackgroundColor() {
        return this.backgroundColor;
    }

    public final int getBackgroundColorRes() {
        return this.backgroundColorRes;
    }

    public final int getBackgroundDrawable() {
        return this.backgroundDrawable;
    }

    @oOoXoXO
    public final CharSequence getDescription() {
        return this.description;
    }

    public final int getDescriptionColor() {
        return this.descriptionColor;
    }

    public final int getDescriptionColorRes() {
        return this.descriptionColorRes;
    }

    @oOoXoXO
    public final String getDescriptionString() {
        CharSequence charSequence = this.description;
        if (charSequence == null) {
            return null;
        }
        return charSequence.toString();
    }

    @oOoXoXO
    public final String getDescriptionTypeface() {
        return this.descriptionTypeface;
    }

    public final int getDescriptionTypefaceFontRes() {
        return this.descriptionTypefaceFontRes;
    }

    public final int getImageDrawable() {
        return this.imageDrawable;
    }

    @oOoXoXO
    public final CharSequence getTitle() {
        return this.title;
    }

    public final int getTitleColor() {
        return this.titleColor;
    }

    public final int getTitleColorRes() {
        return this.titleColorRes;
    }

    @oOoXoXO
    public final String getTitleString() {
        CharSequence charSequence = this.title;
        if (charSequence == null) {
            return null;
        }
        return charSequence.toString();
    }

    @oOoXoXO
    public final String getTitleTypeface() {
        return this.titleTypeface;
    }

    public final int getTitleTypefaceFontRes() {
        return this.titleTypefaceFontRes;
    }

    public int hashCode() {
        CharSequence charSequence = this.title;
        int hashCode = (charSequence == null ? 0 : charSequence.hashCode()) * 31;
        CharSequence charSequence2 = this.description;
        int hashCode2 = (((((((((((((((((((hashCode + (charSequence2 == null ? 0 : charSequence2.hashCode())) * 31) + this.imageDrawable) * 31) + this.backgroundColor) * 31) + this.titleColor) * 31) + this.descriptionColor) * 31) + this.backgroundColorRes) * 31) + this.titleColorRes) * 31) + this.descriptionColorRes) * 31) + this.titleTypefaceFontRes) * 31) + this.descriptionTypefaceFontRes) * 31;
        String str = this.titleTypeface;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.descriptionTypeface;
        return ((hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.backgroundDrawable;
    }

    public final void setBackgroundColor(int i) {
        this.backgroundColor = i;
    }

    public final void setBackgroundColorRes(int i) {
        this.backgroundColorRes = i;
    }

    public final void setBackgroundDrawable(int i) {
        this.backgroundDrawable = i;
    }

    public final void setDescription(@oOoXoXO CharSequence charSequence) {
        this.description = charSequence;
    }

    public final void setDescriptionColor(int i) {
        this.descriptionColor = i;
    }

    public final void setDescriptionColorRes(int i) {
        this.descriptionColorRes = i;
    }

    public final void setDescriptionTypeface(@oOoXoXO String str) {
        this.descriptionTypeface = str;
    }

    public final void setDescriptionTypefaceFontRes(int i) {
        this.descriptionTypefaceFontRes = i;
    }

    public final void setImageDrawable(int i) {
        this.imageDrawable = i;
    }

    public final void setTitle(@oOoXoXO CharSequence charSequence) {
        this.title = charSequence;
    }

    public final void setTitleColor(int i) {
        this.titleColor = i;
    }

    public final void setTitleColorRes(int i) {
        this.titleColorRes = i;
    }

    public final void setTitleTypeface(@oOoXoXO String str) {
        this.titleTypeface = str;
    }

    public final void setTitleTypefaceFontRes(int i) {
        this.titleTypefaceFontRes = i;
    }

    @OXOo.OOXIXo
    public final Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putString("title", getTitleString());
        bundle.putString(AppIntroBaseFragmentKt.ARG_TITLE_TYPEFACE, this.titleTypeface);
        bundle.putInt(AppIntroBaseFragmentKt.ARG_TITLE_TYPEFACE_RES, this.titleTypefaceFontRes);
        bundle.putInt(AppIntroBaseFragmentKt.ARG_TITLE_COLOR, this.titleColor);
        bundle.putInt(AppIntroBaseFragmentKt.ARG_TITLE_COLOR_RES, this.titleColorRes);
        bundle.putString("desc", getDescriptionString());
        bundle.putString(AppIntroBaseFragmentKt.ARG_DESC_TYPEFACE, this.descriptionTypeface);
        bundle.putInt(AppIntroBaseFragmentKt.ARG_DESC_TYPEFACE_RES, this.descriptionTypefaceFontRes);
        bundle.putInt(AppIntroBaseFragmentKt.ARG_DESC_COLOR, this.descriptionColor);
        bundle.putInt(AppIntroBaseFragmentKt.ARG_DESC_COLOR_RES, this.descriptionColorRes);
        bundle.putInt("drawable", this.imageDrawable);
        bundle.putInt(AppIntroBaseFragmentKt.ARG_BG_COLOR, this.backgroundColor);
        bundle.putInt(AppIntroBaseFragmentKt.ARG_BG_COLOR_RES, this.backgroundColorRes);
        bundle.putInt(AppIntroBaseFragmentKt.ARG_BG_DRAWABLE, this.backgroundDrawable);
        return bundle;
    }

    @OXOo.OOXIXo
    public String toString() {
        return "SliderPage(title=" + ((Object) this.title) + ", description=" + ((Object) this.description) + ", imageDrawable=" + this.imageDrawable + ", backgroundColor=" + this.backgroundColor + ", titleColor=" + this.titleColor + ", descriptionColor=" + this.descriptionColor + ", backgroundColorRes=" + this.backgroundColorRes + ", titleColorRes=" + this.titleColorRes + ", descriptionColorRes=" + this.descriptionColorRes + ", titleTypefaceFontRes=" + this.titleTypefaceFontRes + ", descriptionTypefaceFontRes=" + this.descriptionTypefaceFontRes + ", titleTypeface=" + ((Object) this.titleTypeface) + ", descriptionTypeface=" + ((Object) this.descriptionTypeface) + ", backgroundDrawable=" + this.backgroundDrawable + HexStringBuilder.COMMENT_END_CHAR;
    }

    @xoIox
    public SliderPage(@oOoXoXO CharSequence charSequence) {
        this(charSequence, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, 0, 16382, null);
    }

    @xoIox
    public SliderPage(@oOoXoXO CharSequence charSequence, @oOoXoXO CharSequence charSequence2) {
        this(charSequence, charSequence2, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, 0, 16380, null);
    }

    @xoIox
    public SliderPage(@oOoXoXO CharSequence charSequence, @oOoXoXO CharSequence charSequence2, @DrawableRes int i) {
        this(charSequence, charSequence2, i, 0, 0, 0, 0, 0, 0, 0, 0, null, null, 0, 16376, null);
    }

    @xoIox
    public SliderPage(@oOoXoXO CharSequence charSequence, @oOoXoXO CharSequence charSequence2, @DrawableRes int i, @ColorInt int i2) {
        this(charSequence, charSequence2, i, i2, 0, 0, 0, 0, 0, 0, 0, null, null, 0, 16368, null);
    }

    @xoIox
    public SliderPage(@oOoXoXO CharSequence charSequence, @oOoXoXO CharSequence charSequence2, @DrawableRes int i, @ColorInt int i2, @ColorInt int i3) {
        this(charSequence, charSequence2, i, i2, i3, 0, 0, 0, 0, 0, 0, null, null, 0, 16352, null);
    }

    @xoIox
    public SliderPage(@oOoXoXO CharSequence charSequence, @oOoXoXO CharSequence charSequence2, @DrawableRes int i, @ColorInt int i2, @ColorInt int i3, @ColorInt int i4) {
        this(charSequence, charSequence2, i, i2, i3, i4, 0, 0, 0, 0, 0, null, null, 0, 16320, null);
    }

    @xoIox
    public SliderPage(@oOoXoXO CharSequence charSequence, @oOoXoXO CharSequence charSequence2, @DrawableRes int i, @ColorInt int i2, @ColorInt int i3, @ColorInt int i4, @ColorRes int i5) {
        this(charSequence, charSequence2, i, i2, i3, i4, i5, 0, 0, 0, 0, null, null, 0, 16256, null);
    }

    @xoIox
    public SliderPage(@oOoXoXO CharSequence charSequence, @oOoXoXO CharSequence charSequence2, @DrawableRes int i, @ColorInt int i2, @ColorInt int i3, @ColorInt int i4, @ColorRes int i5, @ColorRes int i6) {
        this(charSequence, charSequence2, i, i2, i3, i4, i5, i6, 0, 0, 0, null, null, 0, 16128, null);
    }

    @xoIox
    public SliderPage(@oOoXoXO CharSequence charSequence, @oOoXoXO CharSequence charSequence2, @DrawableRes int i, @ColorInt int i2, @ColorInt int i3, @ColorInt int i4, @ColorRes int i5, @ColorRes int i6, @ColorRes int i7) {
        this(charSequence, charSequence2, i, i2, i3, i4, i5, i6, i7, 0, 0, null, null, 0, 15872, null);
    }

    @xoIox
    public SliderPage(@oOoXoXO CharSequence charSequence, @oOoXoXO CharSequence charSequence2, @DrawableRes int i, @ColorInt int i2, @ColorInt int i3, @ColorInt int i4, @ColorRes int i5, @ColorRes int i6, @ColorRes int i7, @FontRes int i8) {
        this(charSequence, charSequence2, i, i2, i3, i4, i5, i6, i7, i8, 0, null, null, 0, 15360, null);
    }

    @xoIox
    public SliderPage(@oOoXoXO CharSequence charSequence, @oOoXoXO CharSequence charSequence2, @DrawableRes int i, @ColorInt int i2, @ColorInt int i3, @ColorInt int i4, @ColorRes int i5, @ColorRes int i6, @ColorRes int i7, @FontRes int i8, @FontRes int i9) {
        this(charSequence, charSequence2, i, i2, i3, i4, i5, i6, i7, i8, i9, null, null, 0, 14336, null);
    }

    @xoIox
    public SliderPage(@oOoXoXO CharSequence charSequence, @oOoXoXO CharSequence charSequence2, @DrawableRes int i, @ColorInt int i2, @ColorInt int i3, @ColorInt int i4, @ColorRes int i5, @ColorRes int i6, @ColorRes int i7, @FontRes int i8, @FontRes int i9, @oOoXoXO String str) {
        this(charSequence, charSequence2, i, i2, i3, i4, i5, i6, i7, i8, i9, str, null, 0, 12288, null);
    }

    @xoIox
    public SliderPage(@oOoXoXO CharSequence charSequence, @oOoXoXO CharSequence charSequence2, @DrawableRes int i, @ColorInt int i2, @ColorInt int i3, @ColorInt int i4, @ColorRes int i5, @ColorRes int i6, @ColorRes int i7, @FontRes int i8, @FontRes int i9, @oOoXoXO String str, @oOoXoXO String str2) {
        this(charSequence, charSequence2, i, i2, i3, i4, i5, i6, i7, i8, i9, str, str2, 0, 8192, null);
    }

    @xoIox
    public SliderPage(@oOoXoXO CharSequence charSequence, @oOoXoXO CharSequence charSequence2, @DrawableRes int i, @ColorInt int i2, @ColorInt int i3, @ColorInt int i4, @ColorRes int i5, @ColorRes int i6, @ColorRes int i7, @FontRes int i8, @FontRes int i9, @oOoXoXO String str, @oOoXoXO String str2, @DrawableRes int i10) {
        this.title = charSequence;
        this.description = charSequence2;
        this.imageDrawable = i;
        this.backgroundColor = i2;
        this.titleColor = i3;
        this.descriptionColor = i4;
        this.backgroundColorRes = i5;
        this.titleColorRes = i6;
        this.descriptionColorRes = i7;
        this.titleTypefaceFontRes = i8;
        this.descriptionTypefaceFontRes = i9;
        this.titleTypeface = str;
        this.descriptionTypeface = str2;
        this.backgroundDrawable = i10;
    }

    public /* synthetic */ SliderPage(CharSequence charSequence, CharSequence charSequence2, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, String str, String str2, int i10, int i11, IIXOooo iIXOooo) {
        this((i11 & 1) != 0 ? null : charSequence, (i11 & 2) != 0 ? null : charSequence2, (i11 & 4) != 0 ? 0 : i, (i11 & 8) != 0 ? 0 : i2, (i11 & 16) != 0 ? 0 : i3, (i11 & 32) != 0 ? 0 : i4, (i11 & 64) != 0 ? 0 : i5, (i11 & 128) != 0 ? 0 : i6, (i11 & 256) != 0 ? 0 : i7, (i11 & 512) != 0 ? 0 : i8, (i11 & 1024) != 0 ? 0 : i9, (i11 & 2048) != 0 ? null : str, (i11 & 4096) == 0 ? str2 : null, (i11 & 8192) == 0 ? i10 : 0);
    }
}
