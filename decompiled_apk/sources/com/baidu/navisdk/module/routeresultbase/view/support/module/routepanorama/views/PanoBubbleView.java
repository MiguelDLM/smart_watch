package com.baidu.navisdk.module.routeresultbase.view.support.module.routepanorama.views;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.navisdk.embed.R;

/* loaded from: classes7.dex */
public final class PanoBubbleView extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    private TextView f7543a;
    private View b;

    public PanoBubbleView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a(Context context) {
        setBackgroundResource(R.drawable.nsdk_rr_oval_big_bubble);
        setOrientation(0);
        setGravity(16);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.navi_dimens_20dp);
        setPadding(dimensionPixelSize, getPaddingTop(), dimensionPixelSize, getPaddingBottom());
        LayoutInflater.from(context).inflate(R.layout.nsdk_layout_route_panorama_bubble_view, (ViewGroup) this, true);
        this.f7543a = (TextView) findViewById(R.id.route_pano_desc_txt);
        this.b = findViewById(R.id.route_pano_show_full_img_txt);
    }

    public Bundle getRightContentSizeBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt("l", this.b.getLeft());
        bundle.putInt("r", getMeasuredWidth());
        bundle.putInt("t", getMeasuredHeight());
        bundle.putInt("b", 0);
        return bundle;
    }

    public void setDesc(String str) {
        TextView textView = this.f7543a;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public PanoBubbleView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }
}
