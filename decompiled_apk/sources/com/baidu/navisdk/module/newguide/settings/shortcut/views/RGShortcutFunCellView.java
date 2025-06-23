package com.baidu.navisdk.module.newguide.settings.shortcut.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.util.common.g;

/* loaded from: classes7.dex */
public abstract class RGShortcutFunCellView extends ConstraintLayout {

    /* renamed from: a, reason: collision with root package name */
    protected ImageView f7287a;
    protected TextView b;
    protected ImageView c;
    protected ImageView d;

    public RGShortcutFunCellView(Context context) {
        this(context, null);
    }

    public void a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RGShortcutFunCellView);
            int i = R.styleable.RGShortcutFunCellView_nsdk_layout_id;
            r0 = obtainStyledAttributes.hasValue(i) ? obtainStyledAttributes.getResourceId(i, -1) : 0;
            obtainStyledAttributes.recycle();
        }
        if (r0 <= 0) {
            r0 = getLayoutId();
        }
        com.baidu.navisdk.ui.util.b.a(context, r0, this);
        this.f7287a = (ImageView) findViewById(R.id.bnav_v_img_text_img);
        this.b = (TextView) findViewById(R.id.bnav_v_img_text_text);
        this.c = (ImageView) findViewById(R.id.bnav_v_img_text_tip);
        this.d = (ImageView) findViewById(R.id.bnav_v_img_text_bubble);
    }

    public ImageView getBubbleView() {
        return this.d;
    }

    public abstract int getLayoutId();

    public void setTextColor(@ColorInt int i) {
        TextView textView = this.b;
        if (textView != null) {
            com.baidu.navisdk.ui.util.b.a(textView, i);
        }
    }

    public void setTextContent(CharSequence charSequence) {
        TextView textView = this.b;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void setTextSize(float f) {
        TextView textView = this.b;
        if (textView != null) {
            textView.setTextSize(f);
        }
    }

    public void setTipView(@DrawableRes int i) {
        ImageView imageView = this.c;
        if (imageView != null) {
            if (i == 0) {
                imageView.setImageResource(i);
                return;
            }
            try {
                com.baidu.navisdk.ui.util.b.a(imageView, i);
            } catch (Exception e) {
                if (g.PRO_NAV.b()) {
                    g gVar = g.PRO_NAV;
                    gVar.c("RGShortcutFunCellView", e.getMessage());
                    gVar.a("RGShortcutFunCellView", e);
                }
            }
        }
    }

    public void setTipVisibility(int i) {
        ImageView imageView = this.c;
        if (imageView != null) {
            imageView.setVisibility(i);
        }
    }

    public RGShortcutFunCellView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RGShortcutFunCellView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context, attributeSet);
    }

    public void setTextContent(@StringRes int i) {
        TextView textView = this.b;
        if (textView != null) {
            textView.setText(i);
        }
    }

    public void a(@DrawableRes int i) {
        ImageView imageView = this.f7287a;
        if (imageView != null) {
            if (i == 0) {
                imageView.setImageResource(i);
                return;
            }
            try {
                com.baidu.navisdk.ui.util.b.a(imageView, i);
            } catch (Exception e) {
                this.f7287a.setImageResource(i);
                if (g.PRO_NAV.c()) {
                    g.PRO_NAV.a("StyleTextView can not cast to StyleImageView", e);
                }
            }
        }
    }
}
