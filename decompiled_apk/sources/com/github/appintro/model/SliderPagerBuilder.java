package com.github.appintro.model;

import OXOo.oOoXoXO;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.FontRes;
import kotlin.OOXIXo;
import kotlin.XX;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes9.dex */
public final class SliderPagerBuilder {

    @ColorInt
    private int backgroundColor;

    @ColorRes
    private int backgroundColorRes;

    @DrawableRes
    private int backgroundDrawable;

    @oOoXoXO
    private CharSequence description;

    @ColorInt
    private int descriptionColor;

    @ColorRes
    private int descriptionColorRes;

    @oOoXoXO
    private String descriptionTypeface;

    @FontRes
    private int descriptionTypefaceFontRes;

    @DrawableRes
    private int imageDrawable;

    @oOoXoXO
    private CharSequence title;

    @ColorInt
    private int titleColor;

    @ColorRes
    private int titleColorRes;

    @oOoXoXO
    private String titleTypeface;

    @FontRes
    private int titleTypefaceFontRes;

    @OOXIXo(message = "`backgroundColor(...)` has been deprecated to support configuration changes", replaceWith = @XX(expression = "backgroundColorRes(backgroundColor)", imports = {}))
    @OXOo.OOXIXo
    public final SliderPagerBuilder backgroundColor(@ColorInt int i) {
        this.backgroundColor = i;
        return this;
    }

    @OXOo.OOXIXo
    public final SliderPagerBuilder backgroundColorRes(@ColorRes int i) {
        this.backgroundColorRes = i;
        return this;
    }

    @OXOo.OOXIXo
    public final SliderPagerBuilder backgroundDrawable(@DrawableRes int i) {
        this.backgroundDrawable = i;
        return this;
    }

    @OXOo.OOXIXo
    public final SliderPage build() {
        CharSequence charSequence = this.title;
        CharSequence charSequence2 = this.description;
        int i = this.imageDrawable;
        int i2 = this.backgroundColor;
        int i3 = this.backgroundColorRes;
        int i4 = this.titleColor;
        int i5 = this.titleColorRes;
        int i6 = this.descriptionColor;
        int i7 = this.descriptionColorRes;
        int i8 = this.titleTypefaceFontRes;
        String str = this.descriptionTypeface;
        return new SliderPage(charSequence, charSequence2, i, i2, i4, i6, i3, i5, i7, i8, this.descriptionTypefaceFontRes, this.titleTypeface, str, this.backgroundDrawable);
    }

    @OXOo.OOXIXo
    public final SliderPagerBuilder description(@OXOo.OOXIXo CharSequence description) {
        IIX0o.x0xO0oo(description, "description");
        this.description = description;
        return this;
    }

    @OOXIXo(message = "`descriptionColor(...)` has been deprecated to support configuration changes", replaceWith = @XX(expression = "descriptionColorRes(descriptionColor)", imports = {}))
    @OXOo.OOXIXo
    public final SliderPagerBuilder descriptionColor(@ColorInt int i) {
        this.descriptionColor = i;
        return this;
    }

    @OXOo.OOXIXo
    public final SliderPagerBuilder descriptionColorRes(@ColorRes int i) {
        this.descriptionColorRes = i;
        return this;
    }

    @OXOo.OOXIXo
    public final SliderPagerBuilder descriptionTypeface(@OXOo.OOXIXo String descriptionTypeface) {
        IIX0o.x0xO0oo(descriptionTypeface, "descriptionTypeface");
        this.descriptionTypeface = descriptionTypeface;
        return this;
    }

    @OXOo.OOXIXo
    public final SliderPagerBuilder descriptionTypefaceFontRes(@FontRes int i) {
        this.descriptionTypefaceFontRes = i;
        return this;
    }

    @OXOo.OOXIXo
    public final SliderPagerBuilder imageDrawable(@DrawableRes int i) {
        this.imageDrawable = i;
        return this;
    }

    @OXOo.OOXIXo
    public final SliderPagerBuilder title(@OXOo.OOXIXo CharSequence title) {
        IIX0o.x0xO0oo(title, "title");
        this.title = title;
        return this;
    }

    @OOXIXo(message = "`titleColor(...)` has been deprecated to support configuration changes", replaceWith = @XX(expression = "titleColorRes(titleColor)", imports = {}))
    @OXOo.OOXIXo
    public final SliderPagerBuilder titleColor(@ColorInt int i) {
        this.titleColor = i;
        return this;
    }

    @OXOo.OOXIXo
    public final SliderPagerBuilder titleColorRes(@ColorRes int i) {
        this.titleColorRes = i;
        return this;
    }

    @OXOo.OOXIXo
    public final SliderPagerBuilder titleTypeface(@OXOo.OOXIXo String titleTypeface) {
        IIX0o.x0xO0oo(titleTypeface, "titleTypeface");
        this.titleTypeface = titleTypeface;
        return this;
    }

    @OXOo.OOXIXo
    public final SliderPagerBuilder titleTypefaceFontRes(@FontRes int i) {
        this.titleTypefaceFontRes = i;
        return this;
    }
}
