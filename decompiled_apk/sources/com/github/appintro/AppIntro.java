package com.github.appintro;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.FontRes;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.core.widget.TextViewCompat;
import com.github.appintro.internal.TypefaceContainer;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes9.dex */
public abstract class AppIntro extends AppIntroBase {
    private final int layoutId = R.layout.appintro_intro_layout;

    @Override // com.github.appintro.AppIntroBase
    public int getLayoutId() {
        return this.layoutId;
    }

    public final void setBackArrowColor(@ColorInt int i) {
        ((ImageButton) findViewById(R.id.back)).setColorFilter(i);
    }

    public final void setBarColor(@ColorInt int i) {
        findViewById(R.id.bottom).setBackgroundColor(i);
    }

    public final void setColorDoneText(@ColorInt int i) {
        ((TextView) findViewById(R.id.done)).setTextColor(i);
    }

    public final void setColorSkipButton(@ColorInt int i) {
        ((TextView) findViewById(R.id.skip)).setTextColor(i);
    }

    public final void setDoneText(@oOoXoXO CharSequence charSequence) {
        ((TextView) findViewById(R.id.done)).setText(charSequence);
    }

    public final void setDoneTextAppearance(@StyleRes int i) {
        TextViewCompat.setTextAppearance((TextView) findViewById(R.id.done), i);
    }

    public final void setDoneTextTypeface(@oOoXoXO String str) {
        new TypefaceContainer(str, 0).applyTo((TextView) findViewById(R.id.done));
    }

    public final void setImageNextButton(@OOXIXo Drawable imageNextButton) {
        IIX0o.x0xO0oo(imageNextButton, "imageNextButton");
        ((ImageView) findViewById(R.id.next)).setImageDrawable(imageNextButton);
    }

    public final void setNextArrowColor(@ColorInt int i) {
        ((ImageButton) findViewById(R.id.next)).setColorFilter(i);
    }

    public final void setSeparatorColor(@ColorInt int i) {
        findViewById(R.id.bottom_separator).setBackgroundColor(i);
    }

    public final void setSkipText(@oOoXoXO CharSequence charSequence) {
        ((TextView) findViewById(R.id.skip)).setText(charSequence);
    }

    public final void setSkipTextAppearance(@StyleRes int i) {
        TextViewCompat.setTextAppearance((TextView) findViewById(R.id.skip), i);
    }

    public final void setSkipTextTypeface(@FontRes int i) {
        new TypefaceContainer(null, i).applyTo((TextView) findViewById(R.id.skip));
    }

    public final void showSeparator(boolean z) {
        View findViewById = findViewById(R.id.bottom_separator);
        if (z) {
            findViewById.setVisibility(0);
        } else {
            findViewById.setVisibility(4);
        }
    }

    public final void setDoneText(@StringRes int i) {
        ((TextView) findViewById(R.id.done)).setText(i);
    }

    public final void setDoneTextTypeface(@FontRes int i) {
        new TypefaceContainer(null, i).applyTo((TextView) findViewById(R.id.done));
    }

    public final void setSkipText(@StringRes int i) {
        ((TextView) findViewById(R.id.skip)).setText(i);
    }

    public final void setSkipTextTypeface(@oOoXoXO String str) {
        new TypefaceContainer(str, 0).applyTo((TextView) findViewById(R.id.skip));
    }
}
