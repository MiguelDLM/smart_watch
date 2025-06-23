package com.baidu.navisdk.module.routeresultbase.view.template.cell.row;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes7.dex */
public class RowButton extends RelativeLayout {
    private static final int e = ScreenUtil.getInstance().dip2px(19);
    private static final int f = ScreenUtil.getInstance().dip2px(19);
    private static final int g = ScreenUtil.getInstance().dip2px(7);
    private static final int h = ScreenUtil.getInstance().dip2px(7);

    /* renamed from: a, reason: collision with root package name */
    private ImageView f7564a;
    private TextView b;
    private LinearLayout c;
    private int d;

    public RowButton(@NonNull Context context) {
        super(context);
        a(context);
    }

    private void a(Context context) {
        View.inflate(context, R.layout.nsdk_layout_rr_dynamic_card_row_button, this);
        this.f7564a = (ImageView) findViewById(R.id.button_left_image);
        this.b = (TextView) findViewById(R.id.button_text);
        this.c = (LinearLayout) findViewById(R.id.mid_layout);
    }

    public ImageView getImage() {
        return this.f7564a;
    }

    public int getType() {
        return this.d;
    }

    public void setImageColorFilter(@ColorInt int i) {
        ImageView imageView = this.f7564a;
        if (imageView != null) {
            imageView.setColorFilter(i);
        }
    }

    public void setText(CharSequence charSequence) {
        TextView textView = this.b;
        if (textView == null) {
            return;
        }
        textView.setVisibility(0);
        this.b.setText(charSequence);
    }

    public void setTextColor(@ColorInt int i) {
        TextView textView = this.b;
        if (textView != null) {
            textView.setTextColor(i);
        }
    }

    public void setType(int i) {
        this.d = i;
        if (i == 1) {
            setPadding(e, g, f, h);
        } else {
            setPadding(0, 0, 0, 0);
        }
        if (i == 6) {
            findViewById(R.id.button_video).setVisibility(0);
            findViewById(R.id.button_panorama).setVisibility(8);
            findViewById(R.id.button_normal).setVisibility(8);
            this.f7564a = (ImageView) findViewById(R.id.video_bg_image);
            this.b = null;
            return;
        }
        if (i == 7) {
            findViewById(R.id.button_video).setVisibility(8);
            findViewById(R.id.button_panorama).setVisibility(0);
            findViewById(R.id.button_normal).setVisibility(8);
            this.f7564a = (ImageView) findViewById(R.id.panorama_bg_image);
            this.b = (TextView) findViewById(R.id.panorama_text);
            return;
        }
        findViewById(R.id.button_video).setVisibility(8);
        findViewById(R.id.button_panorama).setVisibility(8);
        findViewById(R.id.button_normal).setVisibility(0);
        this.b = (TextView) findViewById(R.id.button_text);
        if (i == 3) {
            findViewById(R.id.button_left_image).setVisibility(8);
            findViewById(R.id.button_bottom_image).setVisibility(8);
            this.f7564a = (ImageView) findViewById(R.id.button_top_image);
            this.b.setTextSize(1, 12.0f);
            this.b.setCompoundDrawables(null, null, null, null);
            return;
        }
        if (i == 5) {
            findViewById(R.id.button_left_image).setVisibility(8);
            findViewById(R.id.button_top_image).setVisibility(8);
            this.f7564a = (ImageView) findViewById(R.id.button_bottom_image);
            this.b.setTextSize(1, 15.0f);
            this.b.setCompoundDrawables(null, null, null, null);
            return;
        }
        if (i == 2) {
            findViewById(R.id.button_top_image).setVisibility(8);
            findViewById(R.id.button_bottom_image).setVisibility(8);
            this.f7564a = (ImageView) findViewById(R.id.button_left_image);
            Drawable drawable = JarUtils.getResources().getDrawable(R.drawable.nsdk_drawable_card_button_right_arrow);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(15);
            this.c.setLayoutParams(layoutParams);
            this.b.setTextColor(Color.parseColor("#999999"));
            this.b.setCompoundDrawables(null, null, drawable, null);
            this.b.setTextSize(1, 13.0f);
            return;
        }
        findViewById(R.id.button_top_image).setVisibility(8);
        findViewById(R.id.button_bottom_image).setVisibility(8);
        this.f7564a = (ImageView) findViewById(R.id.button_left_image);
        this.b.setTextSize(1, 12.0f);
        this.b.setCompoundDrawables(null, null, null, null);
    }

    public RowButton(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public RowButton(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }
}
