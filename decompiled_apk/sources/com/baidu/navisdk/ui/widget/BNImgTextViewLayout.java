package com.baidu.navisdk.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.StringRes;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.util.b;
import com.baidu.navisdk.ui.util.j;
import com.baidu.navisdk.util.common.LogUtil;

/* loaded from: classes8.dex */
public class BNImgTextViewLayout extends LinearLayout {
    private static final String TAG = "BNImgTextViewLayout";
    private ImageView mImageView;
    private TextView mTextView;

    public BNImgTextViewLayout(Context context) {
        this(context, null);
    }

    private void init(Context context, AttributeSet attributeSet) {
        int dimensionPixelSize;
        ViewGroup.MarginLayoutParams marginLayoutParams;
        int dimensionPixelSize2;
        int color;
        ViewGroup.LayoutParams layoutParams;
        int resourceId;
        if (context == null) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e(TAG, "init context == null");
                return;
            }
            return;
        }
        setOrientation(1);
        setGravity(17);
        b.a(context, R.layout.nsdk_layout_img_text_view_btn, this, true);
        this.mImageView = (ImageView) findViewById(R.id.nsdk_img_text_img);
        this.mTextView = (TextView) findViewById(R.id.nsdk_img_text_text);
        if (attributeSet == null) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e(TAG, "init attrs == null");
                return;
            }
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BNImgTextViewLayout);
        int i = R.styleable.BNImgTextViewLayout_nsdk_bn_imgtext_img_src;
        if (obtainStyledAttributes.hasValue(i) && (resourceId = obtainStyledAttributes.getResourceId(i, -1)) > 0) {
            this.mImageView.setImageResource(resourceId);
        }
        int i2 = R.styleable.BNImgTextViewLayout_nsdk_bn_imgtext_img_src_width;
        if (obtainStyledAttributes.hasValue(i2)) {
            int i3 = R.styleable.BNImgTextViewLayout_nsdk_bn_imgtext_img_src_height;
            if (obtainStyledAttributes.hasValue(i3)) {
                int resourceId2 = obtainStyledAttributes.getResourceId(i2, Integer.MAX_VALUE);
                int resourceId3 = obtainStyledAttributes.getResourceId(i3, Integer.MAX_VALUE);
                if (resourceId2 != Integer.MAX_VALUE && resourceId3 != Integer.MAX_VALUE && (layoutParams = this.mImageView.getLayoutParams()) != null) {
                    layoutParams.width = resourceId2;
                    layoutParams.height = resourceId3;
                }
            }
        }
        int i4 = R.styleable.BNImgTextViewLayout_nsdk_bn_imgtext_text;
        if (obtainStyledAttributes.hasValue(i4)) {
            this.mTextView.setText(obtainStyledAttributes.getString(i4));
        }
        int i5 = R.styleable.BNImgTextViewLayout_nsdk_bn_imgtext_text_color;
        if (obtainStyledAttributes.hasValue(i5) && (color = obtainStyledAttributes.getColor(i5, -1)) > 0) {
            this.mTextView.setTextColor(color);
        }
        int i6 = R.styleable.BNImgTextViewLayout_nsdk_bn_imgtext_text_size;
        if (obtainStyledAttributes.hasValue(i6) && (dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(i6, 0)) > 0) {
            this.mTextView.setTextSize(0, dimensionPixelSize2);
        }
        int i7 = R.styleable.BNImgTextViewLayout_nsdk_bn_imgtext_text_margin_top;
        if (obtainStyledAttributes.hasValue(i7) && (dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(i7, Integer.MAX_VALUE)) != Integer.MAX_VALUE && (marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mTextView.getLayoutParams()) != null) {
            marginLayoutParams.topMargin = dimensionPixelSize;
        }
        int i8 = R.styleable.BNImgTextViewLayout_nsdk_bn_imgtext_text_style;
        if (obtainStyledAttributes.hasValue(i8)) {
            if (obtainStyledAttributes.getDimensionPixelSize(i8, 0) == 1) {
                TextView textView = this.mTextView;
                textView.setTypeface(textView.getTypeface(), 1);
            } else {
                TextView textView2 = this.mTextView;
                textView2.setTypeface(textView2.getTypeface(), 0);
            }
        }
        obtainStyledAttributes.recycle();
    }

    public void changeImage(@DrawableRes int i) {
        ImageView imageView = this.mImageView;
        if (imageView != null) {
            imageView.setImageDrawable(b.f(i));
        }
    }

    public void changeImgText(@DrawableRes int i, @StringRes int i2) {
        TextView textView = this.mTextView;
        if (textView != null) {
            textView.setText(i2);
        }
        ImageView imageView = this.mImageView;
        if (imageView != null) {
            imageView.setImageResource(i);
        }
    }

    public void changeText(String str) {
        TextView textView = this.mTextView;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void changeTextAndColor(String str, @ColorInt int i) {
        TextView textView = this.mTextView;
        if (textView != null) {
            textView.setText(str);
            this.mTextView.setTextColor(i);
        }
    }

    public void changeTextColor(@ColorInt int i) {
        TextView textView = this.mTextView;
        if (textView != null) {
            textView.setTextColor(i);
        }
    }

    public void onDestroy() {
        j.b(this.mImageView);
    }

    public BNImgTextViewLayout(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BNImgTextViewLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet);
    }

    public void changeImage(Drawable drawable) {
        ImageView imageView = this.mImageView;
        if (imageView != null) {
            imageView.setImageDrawable(drawable);
        }
    }

    public void changeText(@StringRes int i) {
        TextView textView = this.mTextView;
        if (textView != null) {
            textView.setText(i);
        }
    }

    @RequiresApi(api = 21)
    public BNImgTextViewLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        init(context, attributeSet);
    }

    public void changeImgText(Drawable drawable, @StringRes int i) {
        TextView textView = this.mTextView;
        if (textView != null) {
            textView.setText(i);
        }
        ImageView imageView = this.mImageView;
        if (imageView != null) {
            imageView.setImageDrawable(drawable);
        }
    }
}
