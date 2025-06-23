package com.baidu.navisdk.ui.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.util.b;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes8.dex */
public class BNMapTitleBar extends FrameLayout {
    protected static final int MAP_TITLE_TEXT_COLOR = -16777216;
    protected View mLayout;
    protected ImageView mLeftImageView;
    protected TextView mMiddleTextView;
    protected ImageView mRightImageView;

    public BNMapTitleBar(Context context) {
        super(context);
    }

    private void initView(Context context) {
        this.mRightImageView = (ImageView) this.mLayout.findViewById(R.id.right_imageview);
        this.mLeftImageView = (ImageView) this.mLayout.findViewById(R.id.left_imageview);
        this.mMiddleTextView = (TextView) this.mLayout.findViewById(R.id.middle_text);
    }

    public void onUpdateStyle(boolean z) {
    }

    public void setLeftButtonBackground(Drawable drawable) {
        ImageView imageView = this.mLeftImageView;
        if (imageView != null) {
            imageView.setBackgroundDrawable(drawable);
        }
    }

    public void setLeftButtonVisible(boolean z) {
        int i;
        ImageView imageView = this.mLeftImageView;
        if (imageView != null) {
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            imageView.setVisibility(i);
        }
    }

    public void setLeftOnClickedListener(View.OnClickListener onClickListener) {
        ImageView imageView = this.mLeftImageView;
        if (imageView != null) {
            imageView.setOnClickListener(onClickListener);
        }
    }

    public void setMiddleText(String str) {
        TextView textView = this.mMiddleTextView;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setMiddleTextColor(int i) {
        TextView textView = this.mMiddleTextView;
        if (textView != null) {
            textView.setTextColor(i);
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

    public void setRightButtonBackground(Drawable drawable) {
        ImageView imageView = this.mRightImageView;
        if (imageView != null) {
            imageView.setBackgroundDrawable(drawable);
            this.mRightImageView.setVisibility(0);
        }
    }

    public void setRightButtonVisible(boolean z) {
        int i;
        ImageView imageView = this.mRightImageView;
        if (imageView != null) {
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            imageView.setVisibility(i);
        }
    }

    public void setRightOnClickedListener(View.OnClickListener onClickListener) {
        ImageView imageView = this.mRightImageView;
        if (imageView != null) {
            imageView.setOnClickListener(onClickListener);
            this.mRightImageView.setVisibility(0);
        }
    }

    public BNMapTitleBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        RelativeLayout relativeLayout = (RelativeLayout) JarUtils.inflate(context, R.layout.nsdk_com_map_title_bar, null);
        this.mLayout = relativeLayout;
        addView(relativeLayout);
        initView(context);
    }

    public void setMiddleText(int i) {
        setMiddleText(b.h(i));
    }
}
