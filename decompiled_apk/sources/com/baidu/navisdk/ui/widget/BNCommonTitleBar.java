package com.baidu.navisdk.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.framework.interfaces.c;
import com.baidu.navisdk.framework.interfaces.o;
import com.baidu.navisdk.ui.util.b;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes8.dex */
public class BNCommonTitleBar extends FrameLayout {
    protected static final int DEFAULT_TITLE_HEIGHT = 60;
    protected static final int DEFAULT_TITLE_TEXT_COLOR = 16777215;
    protected static final int DEFAULT_TITLE_TEXT_SIZE = 20;
    protected static final int MIDDLE_TITLE_TEXT_SIZE = 12;
    private boolean hasSetLeftContentFromOutSide;
    private boolean hasSetMiddleContentFromOutSide;
    private boolean hasSetRightContentFromOutSide;
    private boolean isMapMode;
    protected FrameLayout mLayout;
    protected Button mLeftButton;
    protected FrameLayout mLeftContent;
    protected ImageView mLeftImageView;
    private View.OnClickListener mLeftListener;
    protected FrameLayout mMiddleContent;
    private View.OnClickListener mMiddleListern;
    protected TextView mMiddleTextView;
    protected RelativeLayout mReLayout;
    protected Button mRightButton;
    protected FrameLayout mRightContent;
    protected ImageView mRightImageView;
    private View.OnClickListener mRightListner;
    protected View mTitleBarDivideLine;

    public BNCommonTitleBar(Context context) {
        super(context);
        o m = c.p().m();
        if (m != null) {
            this.isMapMode = m.K();
        }
        initView(context);
    }

    public View getLeftContent() {
        return this.mLeftImageView;
    }

    public View getMiddleContent() {
        return this.mMiddleContent;
    }

    public View getRightContent() {
        return this.mRightContent;
    }

    public void initAttr(Context context, AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CommonTitleBar);
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.CommonTitleBar_nsdk_backGroundImage);
        if (drawable != null) {
            this.mReLayout.setBackground(drawable);
        }
        int i = R.styleable.CommonTitleBar_nsdk_rightContentVisible;
        boolean z = true;
        if (obtainStyledAttributes.peekValue(i) != null) {
            z = obtainStyledAttributes.getBoolean(i, true);
        }
        if (z) {
            this.mRightContent.setVisibility(0);
        } else {
            this.mRightContent.setVisibility(4);
        }
        this.mMiddleTextView.setText(obtainStyledAttributes.getString(R.styleable.CommonTitleBar_nsdk_middleContentText));
        Drawable drawable2 = obtainStyledAttributes.getDrawable(R.styleable.CommonTitleBar_nsdk_rightContentImage);
        if (drawable2 != null) {
            this.mRightImageView.setImageDrawable(drawable2);
            this.mRightImageView.setVisibility(0);
        } else {
            this.mRightImageView.setVisibility(8);
        }
        String string = obtainStyledAttributes.getString(R.styleable.CommonTitleBar_nsdk_rightContentText);
        if (!TextUtils.isEmpty(string)) {
            this.mRightButton.setText(string);
            this.mRightButton.setVisibility(0);
        } else if (this.mRightImageView.getVisibility() == 0) {
            this.mRightButton.setVisibility(8);
        } else {
            this.mRightButton.setVisibility(4);
        }
        Drawable drawable3 = obtainStyledAttributes.getDrawable(R.styleable.CommonTitleBar_nsdk_leftContentImage);
        if (drawable3 != null) {
            this.mLeftImageView.setImageDrawable(drawable3);
            this.mLeftImageView.setVisibility(0);
        }
        String string2 = obtainStyledAttributes.getString(R.styleable.CommonTitleBar_nsdk_leftContentText);
        if (!TextUtils.isEmpty(string2)) {
            this.mLeftButton.setText(string2);
            this.mLeftButton.setVisibility(0);
            this.mLeftImageView.setVisibility(8);
        } else {
            this.mLeftButton.setVisibility(8);
        }
        obtainStyledAttributes.recycle();
    }

    public void initView(Context context) {
        int i;
        if (this.isMapMode) {
            this.mLayout = (FrameLayout) b.a(context, R.layout.nsdk_layout_com_title_bar, this);
        } else {
            this.mLayout = (FrameLayout) b.a(context, R.layout.nsdk_layout_carmode_com_title_bar, this);
        }
        FrameLayout frameLayout = this.mLayout;
        if (frameLayout == null) {
            return;
        }
        this.mReLayout = (RelativeLayout) frameLayout.findViewById(R.id.top_layout);
        ImageView imageView = (ImageView) this.mLayout.findViewById(R.id.left_imageview);
        this.mLeftImageView = imageView;
        if (imageView.getDrawable() != null) {
            this.mLeftImageView.getDrawable().setTint(b.b(R.color.nsdk_titlebar_image_tint_color));
        }
        this.mLeftButton = (Button) this.mLayout.findViewById(R.id.left_button);
        this.mRightImageView = (ImageView) this.mLayout.findViewById(R.id.right_imageview);
        this.mRightButton = (Button) this.mLayout.findViewById(R.id.right_button);
        this.mMiddleContent = (FrameLayout) this.mLayout.findViewById(R.id.middle_content);
        this.mRightContent = (FrameLayout) this.mLayout.findViewById(R.id.right_content);
        this.mLeftContent = (FrameLayout) this.mLayout.findViewById(R.id.left_content);
        this.mTitleBarDivideLine = this.mLayout.findViewById(R.id.title_bar_divide_line);
        this.mLeftButton.setVisibility(8);
        TextView textView = (TextView) this.mLayout.findViewById(R.id.middle_text);
        this.mMiddleTextView = textView;
        Resources resources = JarUtils.getResources();
        if (this.isMapMode) {
            i = R.color.bnav_common_titlebar_middle_text;
        } else {
            i = R.color.nsdk_common_carmode_titlebar_text_bg;
        }
        textView.setTextColor(resources.getColor(i));
    }

    public void setLeftContent(View view) {
        FrameLayout frameLayout = this.mLeftContent;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
            this.mLeftContent.addView(view, new FrameLayout.LayoutParams(-1, -1));
            this.mLeftContent.setOnClickListener(this.mLeftListener);
            this.mLeftContent.setClickable(true);
        }
        this.hasSetRightContentFromOutSide = true;
    }

    public void setLeftContentBackgroud(Drawable drawable) {
        this.mLeftContent.setBackgroundDrawable(drawable);
    }

    public void setLeftContentClickable(boolean z) {
        this.mLeftContent.setClickable(z);
    }

    public void setLeftContentVisible(boolean z) {
        int i;
        FrameLayout frameLayout = this.mLeftContent;
        if (z) {
            i = 0;
        } else {
            i = 4;
        }
        frameLayout.setVisibility(i);
    }

    public void setLeftEnabled(boolean z) {
        Button button = this.mLeftButton;
        if (button != null) {
            button.setEnabled(z);
        }
        ImageView imageView = this.mLeftImageView;
        if (imageView != null) {
            imageView.setEnabled(z);
        }
    }

    public void setLeftIcon(Drawable drawable) {
        ImageView imageView = this.mLeftImageView;
        if (imageView != null) {
            imageView.setImageDrawable(drawable);
            this.mLeftImageView.setVisibility(0);
        }
        Button button = this.mLeftButton;
        if (button != null) {
            button.setVisibility(4);
        }
    }

    public void setLeftIconAlpha(float f) {
        ImageView imageView = this.mLeftImageView;
        if (imageView != null) {
            try {
                imageView.setAlpha(f);
            } catch (Exception unused) {
            }
        }
    }

    public void setLeftIconBackGround(Drawable drawable) {
        ImageView imageView = this.mLeftImageView;
        if (imageView != null) {
            imageView.setBackgroundDrawable(drawable);
            this.mLeftImageView.setVisibility(0);
        }
        Button button = this.mLeftButton;
        if (button != null) {
            button.setVisibility(8);
        }
    }

    public void setLeftIconMargin(int i, int i2, int i3, int i4) {
        ImageView imageView = this.mLeftImageView;
        if (imageView != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) imageView.getLayoutParams();
            layoutParams.topMargin = i;
            layoutParams.bottomMargin = i2;
            layoutParams.leftMargin = i3;
            layoutParams.rightMargin = i4;
            this.mLeftImageView.setLayoutParams(layoutParams);
        }
    }

    public void setLeftIconVisible(boolean z) {
        int i;
        ImageView imageView = this.mLeftImageView;
        if (imageView != null) {
            if (z) {
                i = 0;
            } else {
                i = 4;
            }
            imageView.setVisibility(i);
        }
    }

    public void setLeftImageViewSrc(Drawable drawable) {
        ImageView imageView = this.mLeftImageView;
        if (imageView != null) {
            imageView.setImageDrawable(drawable);
        }
    }

    public void setLeftOnClickedListener(View.OnClickListener onClickListener) {
        FrameLayout frameLayout = this.mLeftContent;
        if (frameLayout == null) {
            return;
        }
        this.mLeftListener = onClickListener;
        if (this.hasSetLeftContentFromOutSide) {
            frameLayout.setClickable(true);
            this.mLeftContent.setOnClickListener(onClickListener);
            return;
        }
        frameLayout.setClickable(false);
        ImageView imageView = this.mLeftImageView;
        if (imageView != null) {
            imageView.setOnClickListener(onClickListener);
        }
        Button button = this.mLeftButton;
        if (button != null) {
            button.setOnClickListener(onClickListener);
        }
    }

    public void setLeftText(String str) {
        int dip2px = ScreenUtil.getInstance().dip2px(8);
        Button button = this.mLeftButton;
        if (button != null) {
            button.setText(str);
            this.mLeftButton.setPadding(dip2px, 0, dip2px, 0);
            this.mLeftButton.setVisibility(0);
            this.mLeftContent.setVisibility(0);
        }
        ImageView imageView = this.mLeftImageView;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    public void setLeftTextBackground(Drawable drawable) {
        Button button = this.mLeftButton;
        if (button != null) {
            button.setBackgroundDrawable(drawable);
            this.mLeftButton.setVisibility(0);
        }
        ImageView imageView = this.mLeftImageView;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    public void setLeftTextColor(int i) {
        Button button = this.mLeftButton;
        if (button != null) {
            button.setTextColor(i);
            this.mLeftButton.setVisibility(0);
        }
        ImageView imageView = this.mLeftImageView;
        if (imageView != null) {
            imageView.setVisibility(4);
        }
    }

    public void setLeftTextVisible(boolean z) {
        int i;
        Button button = this.mLeftButton;
        if (button != null) {
            if (z) {
                i = 0;
            } else {
                i = 4;
            }
            button.setVisibility(i);
        }
    }

    public void setMiddleContenVisible(boolean z) {
        int i;
        FrameLayout frameLayout = this.mMiddleContent;
        if (z) {
            i = 0;
        } else {
            i = 4;
        }
        frameLayout.setVisibility(i);
    }

    public void setMiddleContent(View view) {
        FrameLayout frameLayout = this.mMiddleContent;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
            this.mMiddleContent.addView(view, new FrameLayout.LayoutParams(-1, -1));
        }
        this.hasSetMiddleContentFromOutSide = true;
        TextView textView = this.mMiddleTextView;
        if (textView != null) {
            textView.setVisibility(4);
        }
    }

    public void setMiddleContentBackgroud(Drawable drawable) {
        this.mMiddleContent.setBackgroundDrawable(drawable);
    }

    public void setMiddleContentClickable(boolean z) {
        this.mMiddleContent.setClickable(z);
    }

    public void setMiddleOnClickedListener(View.OnClickListener onClickListener) {
        this.mMiddleContent.setOnClickListener(onClickListener);
        this.mMiddleContent.setClickable(true);
    }

    public void setMiddleText(int i) {
        TextView textView = this.mMiddleTextView;
        if (textView != null) {
            textView.setText(i);
        }
    }

    public void setMiddleTextColor(int i) {
        TextView textView = this.mMiddleTextView;
        if (textView != null) {
            textView.setTextColor(i);
        }
    }

    public void setMiddleTextSize(float f) {
        TextView textView = this.mMiddleTextView;
        if (textView != null) {
            textView.setTextSize(f);
        }
    }

    public void setMiddleTextSizeDP(int i) {
        TextView textView = this.mMiddleTextView;
        if (textView != null) {
            textView.setTextSize(1, i);
        }
    }

    public void setMiddleTextSizePX(int i) {
        TextView textView = this.mMiddleTextView;
        if (textView != null) {
            textView.setTextSize(0, i);
        }
    }

    public void setMiddleTextTypeface(Typeface typeface) {
        TextView textView = this.mMiddleTextView;
        if (textView != null) {
            textView.setTypeface(typeface);
        }
    }

    public void setMiddleTextVisible(boolean z) {
        int i;
        TextView textView = this.mMiddleTextView;
        if (textView != null) {
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            textView.setVisibility(i);
        }
    }

    public void setRightContent(View view) {
        FrameLayout frameLayout = this.mRightContent;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
            this.mRightContent.addView(view, new FrameLayout.LayoutParams(-1, -1));
            this.mRightContent.setOnClickListener(this.mRightListner);
            this.mRightContent.setClickable(true);
        }
        this.hasSetRightContentFromOutSide = true;
    }

    public void setRightContentBackgroud(Drawable drawable) {
        this.mRightContent.setBackgroundDrawable(drawable);
    }

    public void setRightContentClickable(boolean z) {
        this.mRightContent.setClickable(z);
    }

    public void setRightContentVisible(boolean z) {
        int i;
        FrameLayout frameLayout = this.mRightContent;
        if (z) {
            i = 0;
        } else {
            i = 4;
        }
        frameLayout.setVisibility(i);
    }

    public void setRightEnabled(boolean z) {
        Button button = this.mRightButton;
        if (button != null) {
            button.setEnabled(z);
        }
        ImageView imageView = this.mRightImageView;
        if (imageView != null) {
            imageView.setEnabled(z);
        }
    }

    public void setRightIcon(Drawable drawable) {
        ImageView imageView = this.mRightImageView;
        if (imageView != null) {
            imageView.setImageDrawable(drawable);
            this.mRightImageView.setVisibility(0);
        }
        Button button = this.mRightButton;
        if (button != null) {
            button.setVisibility(4);
        }
    }

    public void setRightIconBackGround(Drawable drawable) {
        ImageView imageView = this.mRightImageView;
        if (imageView != null) {
            imageView.setBackgroundDrawable(drawable);
            this.mRightImageView.setVisibility(0);
        }
        Button button = this.mRightButton;
        if (button != null) {
            button.setVisibility(4);
        }
    }

    public void setRightIconVisible(boolean z) {
        int i;
        ImageView imageView = this.mRightImageView;
        if (imageView != null) {
            if (z) {
                i = 0;
            } else {
                i = 4;
            }
            imageView.setVisibility(i);
        }
    }

    public void setRightImgRightMargin(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mRightImageView.getLayoutParams();
        layoutParams.rightMargin = i;
        this.mRightImageView.setLayoutParams(layoutParams);
    }

    public void setRightOnClickedListener(View.OnClickListener onClickListener) {
        this.mRightListner = onClickListener;
        if (this.hasSetRightContentFromOutSide) {
            this.mRightContent.setClickable(true);
            this.mRightContent.setOnClickListener(onClickListener);
            return;
        }
        this.mRightContent.setClickable(false);
        ImageView imageView = this.mRightImageView;
        if (imageView != null) {
            imageView.setOnClickListener(onClickListener);
        }
        Button button = this.mRightButton;
        if (button != null) {
            button.setOnClickListener(onClickListener);
        }
    }

    public void setRightText(String str) {
        Button button = this.mRightButton;
        if (button != null) {
            button.setText(str);
            this.mRightButton.setVisibility(0);
        }
        ImageView imageView = this.mRightImageView;
        if (imageView != null) {
            imageView.setVisibility(4);
        }
    }

    public void setRightTextBackground(Drawable drawable) {
        Button button = this.mRightButton;
        if (button != null) {
            button.setBackgroundDrawable(drawable);
            this.mRightButton.setVisibility(0);
        }
        ImageView imageView = this.mRightImageView;
        if (imageView != null) {
            imageView.setVisibility(4);
        }
    }

    public void setRightTextColor(int i) {
        Button button = this.mRightButton;
        if (button != null) {
            button.setTextColor(i);
            this.mRightButton.setVisibility(0);
        }
        ImageView imageView = this.mRightImageView;
        if (imageView != null) {
            imageView.setVisibility(4);
        }
    }

    public void setRightTextMargin(int i, int i2, int i3, int i4) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mRightButton.getLayoutParams();
        layoutParams.leftMargin = i3;
        layoutParams.rightMargin = i4;
        layoutParams.topMargin = i;
        layoutParams.bottomMargin = i2;
        this.mRightButton.setLayoutParams(layoutParams);
    }

    public void setRightTextSize(float f) {
        Button button = this.mRightButton;
        if (button != null) {
            button.setTextSize(f);
        }
    }

    public void setRightTextSizeDP(float f) {
        Button button = this.mRightButton;
        if (button != null) {
            button.setTextSize(1, f);
        }
    }

    public void setRightTextVisible(boolean z) {
        int i;
        Button button = this.mRightButton;
        if (button != null) {
            if (z) {
                i = 0;
            } else {
                i = 4;
            }
            button.setVisibility(i);
        }
    }

    public void setTitleBarBackground(Drawable drawable) {
        this.mReLayout.setBackgroundDrawable(drawable);
    }

    public void setTitleBarBackgroundColor(int i) {
        this.mReLayout.setBackgroundColor(i);
    }

    public void setTitleBarDivideLineBackgroudColor(int i) {
        View view = this.mTitleBarDivideLine;
        if (view != null) {
            view.setBackgroundColor(i);
        }
    }

    public void setTitleBarDivideLineVisibility(int i) {
        View view = this.mTitleBarDivideLine;
        if (view != null) {
            view.setVisibility(i);
        }
    }

    public void updateStyle() {
        if (!this.isMapMode) {
            return;
        }
        ImageView imageView = this.mLeftImageView;
        if (imageView != null) {
            imageView.setImageDrawable(b.f(R.drawable.bnav_titlebar_ic_back_normal));
        }
        Button button = this.mLeftButton;
        if (button != null) {
            button.setBackgroundDrawable(b.f(R.drawable.bnav_titlebar_btn_transparent_bg_selector));
        }
        this.mReLayout.setBackgroundColor(b.b(R.color.bnav_common_titlebar_bg));
        ImageView imageView2 = this.mRightImageView;
        if (imageView2 != null) {
            imageView2.setBackgroundDrawable(b.f(R.drawable.bnav_titlebar_btn_transparent_bg_selector));
        }
        Button button2 = this.mRightButton;
        if (button2 != null) {
            button2.setBackgroundDrawable(b.f(R.drawable.bnav_titlebar_btn_transparent_bg_selector));
            this.mRightButton.setTextColor(b.b(R.color.bnav_common_titlebar_middle_text));
        }
        TextView textView = this.mMiddleTextView;
        if (textView != null) {
            textView.setTextColor(b.b(R.color.bnav_common_titlebar_middle_text));
        }
    }

    public void setMiddleText(CharSequence charSequence) {
        TextView textView = this.mMiddleTextView;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public BNCommonTitleBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        o m = c.p().m();
        if (m != null) {
            this.isMapMode = m.K();
        }
        initView(context);
        if (this.mLayout == null) {
            return;
        }
        initAttr(context, attributeSet);
    }

    public void setRightText(int i) {
        setRightText(b.h(i));
    }

    public void setLeftText(int i) {
        setLeftText(b.h(i));
    }
}
