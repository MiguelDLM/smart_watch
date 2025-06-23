package com.baidu.navisdk.poisearch.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.util.common.ScreenUtil;

/* loaded from: classes7.dex */
public class RouteCarPopup extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    private final Context f7638a;
    private TextView b;
    private TextView c;
    private TextView d;
    private TextView e;
    private ImageView f;
    private RelativeLayout g;
    private RelativeLayout h;
    private View i;

    public RouteCarPopup(Context context) {
        this(context, null);
    }

    private void a() {
        ((LayoutInflater) this.f7638a.getSystemService("layout_inflater")).inflate(R.layout.nsdk_layout_route_result_pop, this);
        this.b = (TextView) findViewById(R.id.poi_name);
        this.c = (TextView) findViewById(R.id.route_cost);
        this.d = (TextView) findViewById(R.id.shop_open_time);
        this.e = (TextView) findViewById(R.id.set_waypoint_txt);
        this.f = (ImageView) findViewById(R.id.set_waypoint_img);
        this.g = (RelativeLayout) findViewById(R.id.left_content);
        this.h = (RelativeLayout) findViewById(R.id.right_content);
        this.i = findViewById(R.id.pin_placeholder);
    }

    public int getLeftContentHeight() {
        return this.g.getMeasuredHeight();
    }

    public Bundle getLeftContentSizeBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt("l", 0);
        bundle.putInt("r", getLeftContentWidth());
        bundle.putInt("t", getLeftContentHeight() + getPinPlaceHolderHeight());
        bundle.putInt("b", getPinPlaceHolderHeight());
        return bundle;
    }

    public int getLeftContentWidth() {
        return this.g.getMeasuredWidth();
    }

    public int getPinPlaceHolderHeight() {
        return this.i.getMeasuredHeight();
    }

    public int getRightContentHeight() {
        return this.h.getMeasuredHeight();
    }

    public Bundle getRightContentSizeBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt("l", getLeftContentWidth());
        bundle.putInt("r", getLeftContentWidth() + getRightContentWidth());
        bundle.putInt("t", getRightContentHeight() + getPinPlaceHolderHeight());
        bundle.putInt("b", getPinPlaceHolderHeight());
        return bundle;
    }

    public int getRightContentWidth() {
        return this.h.getMeasuredWidth();
    }

    public void setPinPlaceholderHeight(int i) {
        ViewGroup.LayoutParams layoutParams = this.i.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, i);
        }
        layoutParams.height = i;
        this.i.setLayoutParams(layoutParams);
    }

    public void setPoiInfo(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.c.setText(str);
            this.c.setVisibility(0);
        } else {
            this.c.setVisibility(8);
        }
    }

    public void setPoiName(String str) {
        this.b.setText(str);
    }

    public void setRightBtnBackgroundDrawable(@DrawableRes int i) {
        this.h.setBackgroundDrawable(getResources().getDrawable(i));
    }

    public void setRightBtnDrawable(@DrawableRes int i) {
        this.f.setImageDrawable(getResources().getDrawable(i));
    }

    public void setShopOpenTime(String str) {
        int i;
        if (!TextUtils.isEmpty(str)) {
            this.d.setText(Html.fromHtml(str));
            this.d.setVisibility(0);
            i = 74;
        } else {
            this.d.setVisibility(8);
            i = 56;
        }
        RelativeLayout relativeLayout = this.g;
        if (relativeLayout != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
            layoutParams.height = ScreenUtil.getInstance().dip2px(i);
            this.g.setLayoutParams(layoutParams);
        }
    }

    public RouteCarPopup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @SuppressLint({"NewApi"})
    public RouteCarPopup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f7638a = context;
        a();
    }

    public void a(String str, int i) {
        this.e.setText(str);
        this.e.setTextColor(i);
    }
}
