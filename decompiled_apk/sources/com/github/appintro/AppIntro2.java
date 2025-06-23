package com.github.appintro;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes9.dex */
public abstract class AppIntro2 extends AppIntroBase {

    @oOoXoXO
    private Drawable backgroundDrawable;
    private ConstraintLayout backgroundFrame;

    @DrawableRes
    @oOoXoXO
    private Integer backgroundResource;
    private View bottomBar;
    private final int layoutId = R.layout.appintro_intro_layout2;
    private ImageButton skipImageButton;

    @oOoXoXO
    public final Drawable getBackgroundDrawable() {
        return this.backgroundDrawable;
    }

    @oOoXoXO
    public final Integer getBackgroundResource() {
        return this.backgroundResource;
    }

    @Override // com.github.appintro.AppIntroBase
    public int getLayoutId() {
        return this.layoutId;
    }

    @Override // com.github.appintro.AppIntroBase, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@oOoXoXO Bundle bundle) {
        super.onCreate(bundle);
        View findViewById = findViewById(R.id.background);
        IIX0o.oO(findViewById, "findViewById(R.id.background)");
        this.backgroundFrame = (ConstraintLayout) findViewById;
        View findViewById2 = findViewById(R.id.bottom);
        IIX0o.oO(findViewById2, "findViewById(R.id.bottom)");
        this.bottomBar = findViewById2;
        View findViewById3 = findViewById(R.id.skip);
        IIX0o.oO(findViewById3, "findViewById(R.id.skip)");
        this.skipImageButton = (ImageButton) findViewById3;
        if (isRtl$appintro_release()) {
            ImageButton imageButton = this.skipImageButton;
            if (imageButton == null) {
                IIX0o.XOxIOxOx("skipImageButton");
                imageButton = null;
            }
            imageButton.setScaleX(-1.0f);
        }
    }

    public final void setBackgroundDrawable(@oOoXoXO Drawable drawable) {
        this.backgroundDrawable = drawable;
        if (drawable != null) {
            ConstraintLayout constraintLayout = this.backgroundFrame;
            if (constraintLayout == null) {
                IIX0o.XOxIOxOx("backgroundFrame");
                constraintLayout = null;
            }
            constraintLayout.setBackground(this.backgroundDrawable);
        }
    }

    public final void setBackgroundResource(@oOoXoXO Integer num) {
        this.backgroundResource = num;
        if (num != null && num != null) {
            int intValue = num.intValue();
            ConstraintLayout constraintLayout = this.backgroundFrame;
            if (constraintLayout == null) {
                IIX0o.XOxIOxOx("backgroundFrame");
                constraintLayout = null;
            }
            constraintLayout.setBackgroundResource(intValue);
        }
    }

    public final void setBarColor(@ColorInt int i) {
        View view = this.bottomBar;
        if (view == null) {
            IIX0o.XOxIOxOx("bottomBar");
            view = null;
        }
        view.setBackgroundColor(i);
    }

    public final void setImageSkipButton(@OOXIXo Drawable imageSkipButton) {
        IIX0o.x0xO0oo(imageSkipButton, "imageSkipButton");
        ImageButton imageButton = this.skipImageButton;
        if (imageButton == null) {
            IIX0o.XOxIOxOx("skipImageButton");
            imageButton = null;
        }
        imageButton.setImageDrawable(imageSkipButton);
    }

    public final void setNextArrowColor(@ColorInt int i) {
        ((ImageButton) findViewById(R.id.next)).setColorFilter(i);
    }

    public final void setSkipArrowColor(@ColorInt int i) {
        ((ImageButton) findViewById(R.id.skip)).setColorFilter(i);
    }
}
