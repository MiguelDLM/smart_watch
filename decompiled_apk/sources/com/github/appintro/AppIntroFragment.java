package com.github.appintro;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.x0XOIxOo;
import XO0OX.xoIox;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.FontRes;
import com.github.appintro.model.SliderPage;
import com.google.android.exoplayer2.RendererCapabilities;
import com.huawei.openalliance.ad.constant.ah;
import kotlin.XX;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes9.dex */
public final class AppIntroFragment extends AppIntroBaseFragment {

    @OOXIXo
    public static final Companion Companion = new Companion(null);

    /* loaded from: classes9.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        public static /* synthetic */ AppIntroFragment createInstance$default(Companion companion, CharSequence charSequence, CharSequence charSequence2, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, Object obj) {
            if ((i8 & 1) != 0) {
                charSequence = null;
            }
            if ((i8 & 2) != 0) {
                charSequence2 = null;
            }
            if ((i8 & 4) != 0) {
                i = 0;
            }
            if ((i8 & 8) != 0) {
                i2 = 0;
            }
            if ((i8 & 16) != 0) {
                i3 = 0;
            }
            if ((i8 & 32) != 0) {
                i4 = 0;
            }
            if ((i8 & 64) != 0) {
                i5 = 0;
            }
            if ((i8 & 128) != 0) {
                i6 = 0;
            }
            if ((i8 & 256) != 0) {
                i7 = 0;
            }
            return companion.createInstance(charSequence, charSequence2, i, i2, i3, i4, i5, i6, i7);
        }

        public static /* synthetic */ AppIntroFragment newInstance$default(Companion companion, CharSequence charSequence, CharSequence charSequence2, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, Object obj) {
            if ((i8 & 1) != 0) {
                charSequence = null;
            }
            if ((i8 & 2) != 0) {
                charSequence2 = null;
            }
            if ((i8 & 4) != 0) {
                i = 0;
            }
            if ((i8 & 8) != 0) {
                i2 = 0;
            }
            if ((i8 & 16) != 0) {
                i3 = 0;
            }
            if ((i8 & 32) != 0) {
                i4 = 0;
            }
            if ((i8 & 64) != 0) {
                i5 = 0;
            }
            if ((i8 & 128) != 0) {
                i6 = 0;
            }
            if ((i8 & 256) != 0) {
                i7 = 0;
            }
            return companion.newInstance(charSequence, charSequence2, i, i2, i3, i4, i5, i6, i7);
        }

        @x0XOIxOo
        @OOXIXo
        @xoIox
        public final AppIntroFragment createInstance() {
            return createInstance$default(this, null, null, 0, 0, 0, 0, 0, 0, 0, 511, null);
        }

        @x0XOIxOo
        @OOXIXo
        @kotlin.OOXIXo(message = "`newInstance` is deprecated to support color resources instead of color int for configuration changes and dark theme support", replaceWith = @XX(expression = "createInstance(title, description, imageDrawable, backgroundColor, titleColor, descriptionColor, titleTypefaceFontRes, descriptionTypefaceFontRes, backgroundDrawable)", imports = {}))
        @xoIox
        public final AppIntroFragment newInstance() {
            return newInstance$default(this, null, null, 0, 0, 0, 0, 0, 0, 0, 511, null);
        }

        private Companion() {
        }

        @x0XOIxOo
        @OOXIXo
        @xoIox
        public final AppIntroFragment createInstance(@oOoXoXO CharSequence charSequence) {
            return createInstance$default(this, charSequence, null, 0, 0, 0, 0, 0, 0, 0, 510, null);
        }

        @x0XOIxOo
        @OOXIXo
        @kotlin.OOXIXo(message = "`newInstance` is deprecated to support color resources instead of color int for configuration changes and dark theme support", replaceWith = @XX(expression = "createInstance(title, description, imageDrawable, backgroundColor, titleColor, descriptionColor, titleTypefaceFontRes, descriptionTypefaceFontRes, backgroundDrawable)", imports = {}))
        @xoIox
        public final AppIntroFragment newInstance(@oOoXoXO CharSequence charSequence) {
            return newInstance$default(this, charSequence, null, 0, 0, 0, 0, 0, 0, 0, 510, null);
        }

        @x0XOIxOo
        @OOXIXo
        @xoIox
        public final AppIntroFragment createInstance(@oOoXoXO CharSequence charSequence, @oOoXoXO CharSequence charSequence2) {
            return createInstance$default(this, charSequence, charSequence2, 0, 0, 0, 0, 0, 0, 0, 508, null);
        }

        @x0XOIxOo
        @OOXIXo
        @kotlin.OOXIXo(message = "`newInstance` is deprecated to support color resources instead of color int for configuration changes and dark theme support", replaceWith = @XX(expression = "createInstance(title, description, imageDrawable, backgroundColor, titleColor, descriptionColor, titleTypefaceFontRes, descriptionTypefaceFontRes, backgroundDrawable)", imports = {}))
        @xoIox
        public final AppIntroFragment newInstance(@oOoXoXO CharSequence charSequence, @oOoXoXO CharSequence charSequence2) {
            return newInstance$default(this, charSequence, charSequence2, 0, 0, 0, 0, 0, 0, 0, 508, null);
        }

        @x0XOIxOo
        @OOXIXo
        @xoIox
        public final AppIntroFragment createInstance(@oOoXoXO CharSequence charSequence, @oOoXoXO CharSequence charSequence2, @DrawableRes int i) {
            return createInstance$default(this, charSequence, charSequence2, i, 0, 0, 0, 0, 0, 0, 504, null);
        }

        @x0XOIxOo
        @OOXIXo
        @kotlin.OOXIXo(message = "`newInstance` is deprecated to support color resources instead of color int for configuration changes and dark theme support", replaceWith = @XX(expression = "createInstance(title, description, imageDrawable, backgroundColor, titleColor, descriptionColor, titleTypefaceFontRes, descriptionTypefaceFontRes, backgroundDrawable)", imports = {}))
        @xoIox
        public final AppIntroFragment newInstance(@oOoXoXO CharSequence charSequence, @oOoXoXO CharSequence charSequence2, @DrawableRes int i) {
            return newInstance$default(this, charSequence, charSequence2, i, 0, 0, 0, 0, 0, 0, 504, null);
        }

        @x0XOIxOo
        @OOXIXo
        @xoIox
        public final AppIntroFragment createInstance(@oOoXoXO CharSequence charSequence, @oOoXoXO CharSequence charSequence2, @DrawableRes int i, @ColorRes int i2) {
            return createInstance$default(this, charSequence, charSequence2, i, i2, 0, 0, 0, 0, 0, ah.v, null);
        }

        @x0XOIxOo
        @OOXIXo
        @kotlin.OOXIXo(message = "`newInstance` is deprecated to support color resources instead of color int for configuration changes and dark theme support", replaceWith = @XX(expression = "createInstance(title, description, imageDrawable, backgroundColor, titleColor, descriptionColor, titleTypefaceFontRes, descriptionTypefaceFontRes, backgroundDrawable)", imports = {}))
        @xoIox
        public final AppIntroFragment newInstance(@oOoXoXO CharSequence charSequence, @oOoXoXO CharSequence charSequence2, @DrawableRes int i, @ColorInt int i2) {
            return newInstance$default(this, charSequence, charSequence2, i, i2, 0, 0, 0, 0, 0, ah.v, null);
        }

        @x0XOIxOo
        @OOXIXo
        @xoIox
        public final AppIntroFragment createInstance(@oOoXoXO CharSequence charSequence, @oOoXoXO CharSequence charSequence2, @DrawableRes int i, @ColorRes int i2, @ColorRes int i3) {
            return createInstance$default(this, charSequence, charSequence2, i, i2, i3, 0, 0, 0, 0, 480, null);
        }

        @x0XOIxOo
        @OOXIXo
        @kotlin.OOXIXo(message = "`newInstance` is deprecated to support color resources instead of color int for configuration changes and dark theme support", replaceWith = @XX(expression = "createInstance(title, description, imageDrawable, backgroundColor, titleColor, descriptionColor, titleTypefaceFontRes, descriptionTypefaceFontRes, backgroundDrawable)", imports = {}))
        @xoIox
        public final AppIntroFragment newInstance(@oOoXoXO CharSequence charSequence, @oOoXoXO CharSequence charSequence2, @DrawableRes int i, @ColorInt int i2, @ColorInt int i3) {
            return newInstance$default(this, charSequence, charSequence2, i, i2, i3, 0, 0, 0, 0, 480, null);
        }

        @x0XOIxOo
        @OOXIXo
        @xoIox
        public final AppIntroFragment createInstance(@oOoXoXO CharSequence charSequence, @oOoXoXO CharSequence charSequence2, @DrawableRes int i, @ColorRes int i2, @ColorRes int i3, @ColorRes int i4) {
            return createInstance$default(this, charSequence, charSequence2, i, i2, i3, i4, 0, 0, 0, 448, null);
        }

        @x0XOIxOo
        @OOXIXo
        @kotlin.OOXIXo(message = "`newInstance` is deprecated to support color resources instead of color int for configuration changes and dark theme support", replaceWith = @XX(expression = "createInstance(title, description, imageDrawable, backgroundColor, titleColor, descriptionColor, titleTypefaceFontRes, descriptionTypefaceFontRes, backgroundDrawable)", imports = {}))
        @xoIox
        public final AppIntroFragment newInstance(@oOoXoXO CharSequence charSequence, @oOoXoXO CharSequence charSequence2, @DrawableRes int i, @ColorInt int i2, @ColorInt int i3, @ColorInt int i4) {
            return newInstance$default(this, charSequence, charSequence2, i, i2, i3, i4, 0, 0, 0, 448, null);
        }

        @x0XOIxOo
        @OOXIXo
        @xoIox
        public final AppIntroFragment createInstance(@oOoXoXO CharSequence charSequence, @oOoXoXO CharSequence charSequence2, @DrawableRes int i, @ColorRes int i2, @ColorRes int i3, @ColorRes int i4, @FontRes int i5) {
            return createInstance$default(this, charSequence, charSequence2, i, i2, i3, i4, i5, 0, 0, RendererCapabilities.MODE_SUPPORT_MASK, null);
        }

        @x0XOIxOo
        @OOXIXo
        @kotlin.OOXIXo(message = "`newInstance` is deprecated to support color resources instead of color int for configuration changes and dark theme support", replaceWith = @XX(expression = "createInstance(title, description, imageDrawable, backgroundColor, titleColor, descriptionColor, titleTypefaceFontRes, descriptionTypefaceFontRes, backgroundDrawable)", imports = {}))
        @xoIox
        public final AppIntroFragment newInstance(@oOoXoXO CharSequence charSequence, @oOoXoXO CharSequence charSequence2, @DrawableRes int i, @ColorInt int i2, @ColorInt int i3, @ColorInt int i4, @FontRes int i5) {
            return newInstance$default(this, charSequence, charSequence2, i, i2, i3, i4, i5, 0, 0, RendererCapabilities.MODE_SUPPORT_MASK, null);
        }

        @x0XOIxOo
        @OOXIXo
        @xoIox
        public final AppIntroFragment createInstance(@oOoXoXO CharSequence charSequence, @oOoXoXO CharSequence charSequence2, @DrawableRes int i, @ColorRes int i2, @ColorRes int i3, @ColorRes int i4, @FontRes int i5, @FontRes int i6) {
            return createInstance$default(this, charSequence, charSequence2, i, i2, i3, i4, i5, i6, 0, 256, null);
        }

        @x0XOIxOo
        @OOXIXo
        @kotlin.OOXIXo(message = "`newInstance` is deprecated to support color resources instead of color int for configuration changes and dark theme support", replaceWith = @XX(expression = "createInstance(title, description, imageDrawable, backgroundColor, titleColor, descriptionColor, titleTypefaceFontRes, descriptionTypefaceFontRes, backgroundDrawable)", imports = {}))
        @xoIox
        public final AppIntroFragment newInstance(@oOoXoXO CharSequence charSequence, @oOoXoXO CharSequence charSequence2, @DrawableRes int i, @ColorInt int i2, @ColorInt int i3, @ColorInt int i4, @FontRes int i5, @FontRes int i6) {
            return newInstance$default(this, charSequence, charSequence2, i, i2, i3, i4, i5, i6, 0, 256, null);
        }

        @x0XOIxOo
        @OOXIXo
        @xoIox
        public final AppIntroFragment createInstance(@oOoXoXO CharSequence charSequence, @oOoXoXO CharSequence charSequence2, @DrawableRes int i, @ColorRes int i2, @ColorRes int i3, @ColorRes int i4, @FontRes int i5, @FontRes int i6, @DrawableRes int i7) {
            return createInstance(new SliderPage(charSequence, charSequence2, i, 0, 0, 0, i2, i3, i4, i5, i6, null, null, i7, 6200, null));
        }

        @x0XOIxOo
        @OOXIXo
        @kotlin.OOXIXo(message = "`newInstance` is deprecated to support color resources instead of color int for configuration changes and dark theme support", replaceWith = @XX(expression = "createInstance(title, description, imageDrawable, backgroundColor, titleColor, descriptionColor, titleTypefaceFontRes, descriptionTypefaceFontRes, backgroundDrawable)", imports = {}))
        @xoIox
        public final AppIntroFragment newInstance(@oOoXoXO CharSequence charSequence, @oOoXoXO CharSequence charSequence2, @DrawableRes int i, @ColorInt int i2, @ColorInt int i3, @ColorInt int i4, @FontRes int i5, @FontRes int i6, @DrawableRes int i7) {
            return createInstance(new SliderPage(charSequence, charSequence2, i, i2, i3, i4, 0, 0, 0, i5, i6, null, null, i7, 6592, null));
        }

        @x0XOIxOo
        @OOXIXo
        public final AppIntroFragment createInstance(@OOXIXo SliderPage sliderPage) {
            IIX0o.x0xO0oo(sliderPage, "sliderPage");
            AppIntroFragment appIntroFragment = new AppIntroFragment();
            appIntroFragment.setArguments(sliderPage.toBundle());
            return appIntroFragment;
        }

        @x0XOIxOo
        @kotlin.OOXIXo(message = "`newInstance` is deprecated to support color resources instead of color int for configuration changes and dark theme support", replaceWith = @XX(expression = "createInstance(sliderPage)", imports = {}))
        @OOXIXo
        public final AppIntroFragment newInstance(@OOXIXo SliderPage sliderPage) {
            IIX0o.x0xO0oo(sliderPage, "sliderPage");
            return createInstance(sliderPage);
        }
    }

    @x0XOIxOo
    @OOXIXo
    @xoIox
    public static final AppIntroFragment createInstance() {
        return Companion.createInstance();
    }

    @x0XOIxOo
    @OOXIXo
    @kotlin.OOXIXo(message = "`newInstance` is deprecated to support color resources instead of color int for configuration changes and dark theme support", replaceWith = @XX(expression = "createInstance(title, description, imageDrawable, backgroundColor, titleColor, descriptionColor, titleTypefaceFontRes, descriptionTypefaceFontRes, backgroundDrawable)", imports = {}))
    @xoIox
    public static final AppIntroFragment newInstance() {
        return Companion.newInstance();
    }

    @Override // com.github.appintro.AppIntroBaseFragment
    public int getLayoutId() {
        return R.layout.appintro_fragment_intro;
    }

    @x0XOIxOo
    @OOXIXo
    public static final AppIntroFragment createInstance(@OOXIXo SliderPage sliderPage) {
        return Companion.createInstance(sliderPage);
    }

    @x0XOIxOo
    @kotlin.OOXIXo(message = "`newInstance` is deprecated to support color resources instead of color int for configuration changes and dark theme support", replaceWith = @XX(expression = "createInstance(sliderPage)", imports = {}))
    @OOXIXo
    public static final AppIntroFragment newInstance(@OOXIXo SliderPage sliderPage) {
        return Companion.newInstance(sliderPage);
    }

    @x0XOIxOo
    @OOXIXo
    @xoIox
    public static final AppIntroFragment createInstance(@oOoXoXO CharSequence charSequence) {
        return Companion.createInstance(charSequence);
    }

    @x0XOIxOo
    @OOXIXo
    @kotlin.OOXIXo(message = "`newInstance` is deprecated to support color resources instead of color int for configuration changes and dark theme support", replaceWith = @XX(expression = "createInstance(title, description, imageDrawable, backgroundColor, titleColor, descriptionColor, titleTypefaceFontRes, descriptionTypefaceFontRes, backgroundDrawable)", imports = {}))
    @xoIox
    public static final AppIntroFragment newInstance(@oOoXoXO CharSequence charSequence) {
        return Companion.newInstance(charSequence);
    }

    @x0XOIxOo
    @OOXIXo
    @xoIox
    public static final AppIntroFragment createInstance(@oOoXoXO CharSequence charSequence, @oOoXoXO CharSequence charSequence2) {
        return Companion.createInstance(charSequence, charSequence2);
    }

    @x0XOIxOo
    @OOXIXo
    @kotlin.OOXIXo(message = "`newInstance` is deprecated to support color resources instead of color int for configuration changes and dark theme support", replaceWith = @XX(expression = "createInstance(title, description, imageDrawable, backgroundColor, titleColor, descriptionColor, titleTypefaceFontRes, descriptionTypefaceFontRes, backgroundDrawable)", imports = {}))
    @xoIox
    public static final AppIntroFragment newInstance(@oOoXoXO CharSequence charSequence, @oOoXoXO CharSequence charSequence2) {
        return Companion.newInstance(charSequence, charSequence2);
    }

    @x0XOIxOo
    @OOXIXo
    @xoIox
    public static final AppIntroFragment createInstance(@oOoXoXO CharSequence charSequence, @oOoXoXO CharSequence charSequence2, @DrawableRes int i) {
        return Companion.createInstance(charSequence, charSequence2, i);
    }

    @x0XOIxOo
    @OOXIXo
    @kotlin.OOXIXo(message = "`newInstance` is deprecated to support color resources instead of color int for configuration changes and dark theme support", replaceWith = @XX(expression = "createInstance(title, description, imageDrawable, backgroundColor, titleColor, descriptionColor, titleTypefaceFontRes, descriptionTypefaceFontRes, backgroundDrawable)", imports = {}))
    @xoIox
    public static final AppIntroFragment newInstance(@oOoXoXO CharSequence charSequence, @oOoXoXO CharSequence charSequence2, @DrawableRes int i) {
        return Companion.newInstance(charSequence, charSequence2, i);
    }

    @x0XOIxOo
    @OOXIXo
    @xoIox
    public static final AppIntroFragment createInstance(@oOoXoXO CharSequence charSequence, @oOoXoXO CharSequence charSequence2, @DrawableRes int i, @ColorRes int i2) {
        return Companion.createInstance(charSequence, charSequence2, i, i2);
    }

    @x0XOIxOo
    @OOXIXo
    @kotlin.OOXIXo(message = "`newInstance` is deprecated to support color resources instead of color int for configuration changes and dark theme support", replaceWith = @XX(expression = "createInstance(title, description, imageDrawable, backgroundColor, titleColor, descriptionColor, titleTypefaceFontRes, descriptionTypefaceFontRes, backgroundDrawable)", imports = {}))
    @xoIox
    public static final AppIntroFragment newInstance(@oOoXoXO CharSequence charSequence, @oOoXoXO CharSequence charSequence2, @DrawableRes int i, @ColorInt int i2) {
        return Companion.newInstance(charSequence, charSequence2, i, i2);
    }

    @x0XOIxOo
    @OOXIXo
    @xoIox
    public static final AppIntroFragment createInstance(@oOoXoXO CharSequence charSequence, @oOoXoXO CharSequence charSequence2, @DrawableRes int i, @ColorRes int i2, @ColorRes int i3) {
        return Companion.createInstance(charSequence, charSequence2, i, i2, i3);
    }

    @x0XOIxOo
    @OOXIXo
    @kotlin.OOXIXo(message = "`newInstance` is deprecated to support color resources instead of color int for configuration changes and dark theme support", replaceWith = @XX(expression = "createInstance(title, description, imageDrawable, backgroundColor, titleColor, descriptionColor, titleTypefaceFontRes, descriptionTypefaceFontRes, backgroundDrawable)", imports = {}))
    @xoIox
    public static final AppIntroFragment newInstance(@oOoXoXO CharSequence charSequence, @oOoXoXO CharSequence charSequence2, @DrawableRes int i, @ColorInt int i2, @ColorInt int i3) {
        return Companion.newInstance(charSequence, charSequence2, i, i2, i3);
    }

    @x0XOIxOo
    @OOXIXo
    @xoIox
    public static final AppIntroFragment createInstance(@oOoXoXO CharSequence charSequence, @oOoXoXO CharSequence charSequence2, @DrawableRes int i, @ColorRes int i2, @ColorRes int i3, @ColorRes int i4) {
        return Companion.createInstance(charSequence, charSequence2, i, i2, i3, i4);
    }

    @x0XOIxOo
    @OOXIXo
    @kotlin.OOXIXo(message = "`newInstance` is deprecated to support color resources instead of color int for configuration changes and dark theme support", replaceWith = @XX(expression = "createInstance(title, description, imageDrawable, backgroundColor, titleColor, descriptionColor, titleTypefaceFontRes, descriptionTypefaceFontRes, backgroundDrawable)", imports = {}))
    @xoIox
    public static final AppIntroFragment newInstance(@oOoXoXO CharSequence charSequence, @oOoXoXO CharSequence charSequence2, @DrawableRes int i, @ColorInt int i2, @ColorInt int i3, @ColorInt int i4) {
        return Companion.newInstance(charSequence, charSequence2, i, i2, i3, i4);
    }

    @x0XOIxOo
    @OOXIXo
    @xoIox
    public static final AppIntroFragment createInstance(@oOoXoXO CharSequence charSequence, @oOoXoXO CharSequence charSequence2, @DrawableRes int i, @ColorRes int i2, @ColorRes int i3, @ColorRes int i4, @FontRes int i5) {
        return Companion.createInstance(charSequence, charSequence2, i, i2, i3, i4, i5);
    }

    @x0XOIxOo
    @OOXIXo
    @kotlin.OOXIXo(message = "`newInstance` is deprecated to support color resources instead of color int for configuration changes and dark theme support", replaceWith = @XX(expression = "createInstance(title, description, imageDrawable, backgroundColor, titleColor, descriptionColor, titleTypefaceFontRes, descriptionTypefaceFontRes, backgroundDrawable)", imports = {}))
    @xoIox
    public static final AppIntroFragment newInstance(@oOoXoXO CharSequence charSequence, @oOoXoXO CharSequence charSequence2, @DrawableRes int i, @ColorInt int i2, @ColorInt int i3, @ColorInt int i4, @FontRes int i5) {
        return Companion.newInstance(charSequence, charSequence2, i, i2, i3, i4, i5);
    }

    @x0XOIxOo
    @OOXIXo
    @xoIox
    public static final AppIntroFragment createInstance(@oOoXoXO CharSequence charSequence, @oOoXoXO CharSequence charSequence2, @DrawableRes int i, @ColorRes int i2, @ColorRes int i3, @ColorRes int i4, @FontRes int i5, @FontRes int i6) {
        return Companion.createInstance(charSequence, charSequence2, i, i2, i3, i4, i5, i6);
    }

    @x0XOIxOo
    @OOXIXo
    @kotlin.OOXIXo(message = "`newInstance` is deprecated to support color resources instead of color int for configuration changes and dark theme support", replaceWith = @XX(expression = "createInstance(title, description, imageDrawable, backgroundColor, titleColor, descriptionColor, titleTypefaceFontRes, descriptionTypefaceFontRes, backgroundDrawable)", imports = {}))
    @xoIox
    public static final AppIntroFragment newInstance(@oOoXoXO CharSequence charSequence, @oOoXoXO CharSequence charSequence2, @DrawableRes int i, @ColorInt int i2, @ColorInt int i3, @ColorInt int i4, @FontRes int i5, @FontRes int i6) {
        return Companion.newInstance(charSequence, charSequence2, i, i2, i3, i4, i5, i6);
    }

    @x0XOIxOo
    @OOXIXo
    @xoIox
    public static final AppIntroFragment createInstance(@oOoXoXO CharSequence charSequence, @oOoXoXO CharSequence charSequence2, @DrawableRes int i, @ColorRes int i2, @ColorRes int i3, @ColorRes int i4, @FontRes int i5, @FontRes int i6, @DrawableRes int i7) {
        return Companion.createInstance(charSequence, charSequence2, i, i2, i3, i4, i5, i6, i7);
    }

    @x0XOIxOo
    @OOXIXo
    @kotlin.OOXIXo(message = "`newInstance` is deprecated to support color resources instead of color int for configuration changes and dark theme support", replaceWith = @XX(expression = "createInstance(title, description, imageDrawable, backgroundColor, titleColor, descriptionColor, titleTypefaceFontRes, descriptionTypefaceFontRes, backgroundDrawable)", imports = {}))
    @xoIox
    public static final AppIntroFragment newInstance(@oOoXoXO CharSequence charSequence, @oOoXoXO CharSequence charSequence2, @DrawableRes int i, @ColorInt int i2, @ColorInt int i3, @ColorInt int i4, @FontRes int i5, @FontRes int i6, @DrawableRes int i7) {
        return Companion.newInstance(charSequence, charSequence2, i, i2, i3, i4, i5, i6, i7);
    }
}
