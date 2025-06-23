package com.baidu.navisdk.ui.widget;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.xoIox;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.ColorRes;
import androidx.core.content.ContextCompat;
import com.baidu.navisdk.embed.R;
import com.huawei.openalliance.ad.constant.x;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes8.dex */
public class BNImageTextBtn extends RelativeLayout {
    private int bgResId;
    public ImageView icon;
    public TextView text;

    @ColorRes
    private int textColorResId;

    /* loaded from: classes8.dex */
    public enum TipPointLocation {
        LEFT_TOP,
        RIGHT_TOP
    }

    @xoIox
    public BNImageTextBtn(int i, @OOXIXo Context context) {
        this(i, context, (AttributeSet) null, 0, 12, (IIXOooo) null);
    }

    private final void init(Context context, AttributeSet attributeSet) {
        int dimensionPixelSize;
        int dimensionPixelSize2;
        int resourceId;
        inflateAndInitView(context);
        if (attributeSet == null) {
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BNImageTextBtn);
        IIX0o.oO(obtainStyledAttributes, "context.obtainStyledAttr…styleable.BNImageTextBtn)");
        int i = R.styleable.BNImageTextBtn_nsdk_icon_src;
        if (obtainStyledAttributes.hasValue(i) && (resourceId = obtainStyledAttributes.getResourceId(i, -1)) > 0) {
            setIcon(resourceId);
        }
        int i2 = R.styleable.BNImageTextBtn_nsdk_icon_width;
        if (obtainStyledAttributes.hasValue(i2)) {
            int i3 = R.styleable.BNImageTextBtn_nsdk_icon_height;
            if (obtainStyledAttributes.hasValue(i3)) {
                int dimensionPixelSize3 = obtainStyledAttributes.getDimensionPixelSize(i2, Integer.MAX_VALUE);
                int dimensionPixelSize4 = obtainStyledAttributes.getDimensionPixelSize(i3, Integer.MAX_VALUE);
                if (dimensionPixelSize3 != Integer.MAX_VALUE && dimensionPixelSize4 != Integer.MAX_VALUE) {
                    ImageView imageView = this.icon;
                    if (imageView == null) {
                        IIX0o.XOxIOxOx(x.cD);
                    }
                    ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.width = dimensionPixelSize3;
                    }
                    ImageView imageView2 = this.icon;
                    if (imageView2 == null) {
                        IIX0o.XOxIOxOx(x.cD);
                    }
                    ViewGroup.LayoutParams layoutParams2 = imageView2.getLayoutParams();
                    if (layoutParams2 != null) {
                        layoutParams2.height = dimensionPixelSize4;
                    }
                }
            }
        }
        int i4 = R.styleable.BNImageTextBtn_nsdk_txt_content;
        if (obtainStyledAttributes.hasValue(i4)) {
            String string = obtainStyledAttributes.getString(i4);
            TextView textView = this.text;
            if (textView == null) {
                IIX0o.XOxIOxOx("text");
            }
            textView.setText(string);
        }
        int i5 = R.styleable.BNImageTextBtn_nsdk_txt_color;
        if (obtainStyledAttributes.hasValue(i5)) {
            int resourceId2 = obtainStyledAttributes.getResourceId(i5, 0);
            if (resourceId2 != 0) {
                this.textColorResId = resourceId2;
                TextView textView2 = this.text;
                if (textView2 == null) {
                    IIX0o.XOxIOxOx("text");
                }
                textView2.setTextColor(ContextCompat.getColor(context, resourceId2));
            } else {
                int color = obtainStyledAttributes.getColor(i5, -1);
                TextView textView3 = this.text;
                if (textView3 == null) {
                    IIX0o.XOxIOxOx("text");
                }
                textView3.setTextColor(color);
            }
        }
        int i6 = R.styleable.BNImageTextBtn_nsdk_txt_size;
        if (obtainStyledAttributes.hasValue(i6) && (dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(i6, 0)) > 0) {
            TextView textView4 = this.text;
            if (textView4 == null) {
                IIX0o.XOxIOxOx("text");
            }
            textView4.setTextSize(0, dimensionPixelSize2);
        }
        int i7 = R.styleable.BNImageTextBtn_nsdk_txt_margin_top;
        if (obtainStyledAttributes.hasValue(i7) && (dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(i7, Integer.MAX_VALUE)) != Integer.MAX_VALUE) {
            TextView textView5 = this.text;
            if (textView5 == null) {
                IIX0o.XOxIOxOx("text");
            }
            ViewGroup.LayoutParams layoutParams3 = textView5.getLayoutParams();
            if (layoutParams3 instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams3).topMargin = dimensionPixelSize;
            }
        }
        obtainStyledAttributes.recycle();
        inflateDone();
    }

    public final void addTipPoint(@OOXIXo Drawable point, @OOXIXo TipPointLocation location) {
        IIX0o.x0xO0oo(point, "point");
        IIX0o.x0xO0oo(location, "location");
    }

    public final int getBgResId() {
        return this.bgResId;
    }

    @OOXIXo
    public final ImageView getIcon() {
        ImageView imageView = this.icon;
        if (imageView == null) {
            IIX0o.XOxIOxOx(x.cD);
        }
        return imageView;
    }

    @OOXIXo
    public final TextView getText() {
        TextView textView = this.text;
        if (textView == null) {
            IIX0o.XOxIOxOx("text");
        }
        return textView;
    }

    public final int getTextColorResId() {
        return this.textColorResId;
    }

    public void inflateAndInitView(@OOXIXo Context context) {
        IIX0o.x0xO0oo(context, "context");
        LayoutInflater.from(context).inflate(R.layout.nsdk_layout_image_text_btn, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.bn_img_txt_btn_icon);
        IIX0o.oO(findViewById, "findViewById(R.id.bn_img_txt_btn_icon)");
        this.icon = (ImageView) findViewById;
        View findViewById2 = findViewById(R.id.bn_img_txt_btn_text);
        IIX0o.oO(findViewById2, "findViewById(R.id.bn_img_txt_btn_text)");
        this.text = (TextView) findViewById2;
    }

    public void inflateDone() {
    }

    public final void setBgResId(int i) {
        this.bgResId = i;
    }

    public final void setIcon(@OOXIXo ImageView imageView) {
        IIX0o.x0xO0oo(imageView, "<set-?>");
        this.icon = imageView;
    }

    public final void setText(@OOXIXo TextView textView) {
        IIX0o.x0xO0oo(textView, "<set-?>");
        this.text = textView;
    }

    public final void setTextColorResId(int i) {
        this.textColorResId = i;
    }

    @xoIox
    public BNImageTextBtn(int i, @OOXIXo Context context, @oOoXoXO AttributeSet attributeSet) {
        this(i, context, attributeSet, 0, 8, (IIXOooo) null);
    }

    public void setIcon(int i) {
        ImageView imageView = this.icon;
        if (imageView == null) {
            IIX0o.XOxIOxOx(x.cD);
        }
        imageView.setImageResource(i);
    }

    @xoIox
    public BNImageTextBtn(@OOXIXo Context context) {
        this(0, context, (AttributeSet) null, 0, 13, (IIXOooo) null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @xoIox
    public BNImageTextBtn(int i, @OOXIXo Context context, @oOoXoXO AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        IIX0o.x0xO0oo(context, "context");
        this.bgResId = i;
        init(context, attributeSet);
    }

    public /* synthetic */ BNImageTextBtn(int i, Context context, AttributeSet attributeSet, int i2, int i3, IIXOooo iIXOooo) {
        this((i3 & 1) != 0 ? 0 : i, context, (i3 & 4) != 0 ? null : attributeSet, (i3 & 8) != 0 ? 0 : i2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @TargetApi(21)
    public BNImageTextBtn(@OOXIXo Context context, @oOoXoXO AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        IIX0o.x0xO0oo(context, "context");
        init(context, attributeSet);
    }

    public /* synthetic */ BNImageTextBtn(Context context, AttributeSet attributeSet, int i, int i2, int i3, IIXOooo iIXOooo) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, i2);
    }
}
