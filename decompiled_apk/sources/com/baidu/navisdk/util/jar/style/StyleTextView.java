package com.baidu.navisdk.util.jar.style;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.navisdk.ui.util.b;

/* loaded from: classes8.dex */
public class StyleTextView extends StyleCommonView {
    private static final String TAG = "StyleTextView";
    public StyleAttr[] mComponentDrawableAttr;
    public StyleAttr mTextColorAttr;

    public StyleTextView(View view) {
        super(view);
        this.mComponentDrawableAttr = null;
    }

    private void updateCompoundDrawable(TextView textView) {
        Drawable drawable;
        Drawable drawable2;
        Drawable drawable3;
        StyleAttr styleAttr = this.mComponentDrawableAttr[0];
        Drawable drawable4 = null;
        if (styleAttr != null) {
            drawable = b.f(styleAttr.mId);
        } else {
            drawable = null;
        }
        StyleAttr styleAttr2 = this.mComponentDrawableAttr[1];
        if (styleAttr2 != null) {
            drawable2 = b.f(styleAttr2.mId);
        } else {
            drawable2 = null;
        }
        StyleAttr styleAttr3 = this.mComponentDrawableAttr[2];
        if (styleAttr3 != null) {
            drawable3 = b.f(styleAttr3.mId);
        } else {
            drawable3 = null;
        }
        StyleAttr styleAttr4 = this.mComponentDrawableAttr[3];
        if (styleAttr4 != null) {
            drawable4 = b.f(styleAttr4.mId);
        }
        textView.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
    }

    private void updateTextColor(TextView textView) {
        try {
            ColorStateList c = b.c(this.mTextColorAttr.mId);
            if (c != null) {
                textView.setTextColor(c);
            } else {
                textView.setTextColor(b.b(this.mTextColorAttr.mId));
            }
        } catch (Exception unused) {
            textView.setTextColor(b.b(this.mTextColorAttr.mId));
        }
    }

    @Override // com.baidu.navisdk.util.jar.style.StyleCommonView
    public void updateStyle() {
        super.updateStyle();
        View view = this.mView.get();
        if (view == null) {
            return;
        }
        if (this.mTextColorAttr != null) {
            updateTextColor((TextView) view);
        }
        if (this.mComponentDrawableAttr != null) {
            updateCompoundDrawable((TextView) view);
        }
    }
}
