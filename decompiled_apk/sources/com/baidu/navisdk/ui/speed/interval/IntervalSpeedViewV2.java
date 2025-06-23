package com.baidu.navisdk.ui.speed.interval;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes8.dex */
public class IntervalSpeedViewV2 extends RelativeLayout {
    private static String n = "IntervalSpeedViewV2Holder";

    /* renamed from: a, reason: collision with root package name */
    private TextView f9188a;
    private TextView b;
    private TextView c;
    private a d;
    private View e;
    private TextView f;
    private TextView g;
    private View h;
    private View i;
    private View j;
    private View k;
    private View l;
    private View m;

    public IntervalSpeedViewV2(Context context) {
        super(context);
        JarUtils.getResources().getColor(R.color.nsdk_interval_speed_progress_bar);
        JarUtils.getResources().getColor(R.color.nsdk_cl_text_g);
        a(context);
    }

    private void setIntervalSpeedLimit(int i) {
        TextView textView = this.b;
        if (textView != null) {
            textView.setText(i + "");
        }
    }

    public void a(Context context) {
        View inflate = JarUtils.inflate(context, getPortraitLayoutId(), this);
        this.m = inflate;
        a(inflate);
    }

    public View getContentView() {
        return this.m;
    }

    @Deprecated
    public int getLandscapeLayoutId() {
        return R.layout.bnav_interval_camera_layout_land;
    }

    public int getPortraitLayoutId() {
        return R.layout.bnav_interval_camera_layout;
    }

    public void setAnimListener(@NonNull b bVar) {
    }

    public void setContentVisibility(int i) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(n, "setContentVisibility,visibility:" + i);
        }
        View view = this.m;
        if (view != null) {
            view.setVisibility(i);
        }
    }

    public void setIntervalSpeedCallback(c cVar) {
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (LogUtil.LOGGABLE) {
            LogUtil.e(n, "setVisibility,visibility:" + i);
        }
    }

    public void a(View view) {
        this.m = view;
        this.k = view.findViewById(R.id.container_bg);
        this.h = view.findViewById(R.id.bnav_remain_dis_container);
        this.j = view.findViewById(R.id.bnav_speed_limit_container);
        this.f9188a = (TextView) view.findViewById(R.id.bnav_remain_dis_tv);
        this.c = (TextView) view.findViewById(R.id.bnav_remain_dis_desc);
        this.b = (TextView) view.findViewById(R.id.bnav_interval_standard_speed_tv);
        this.l = view.findViewById(R.id.bnav_interval_divider);
        this.i = view.findViewById(R.id.bnav_ivel_container);
        this.e = view.findViewById(R.id.bnav_interval_ave_speed_bg);
        this.f = (TextView) view.findViewById(R.id.bnav_interval_ave_speed_value);
        this.g = (TextView) view.findViewById(R.id.bnav_interval_ave_speed_tag);
        a aVar = new a();
        this.d = aVar;
        aVar.a(view.getContext(), this.k, this.j, this.i, this.h, view, this.l);
    }

    public IntervalSpeedViewV2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        JarUtils.getResources().getColor(R.color.nsdk_interval_speed_progress_bar);
        JarUtils.getResources().getColor(R.color.nsdk_cl_text_g);
        a(context);
    }

    public IntervalSpeedViewV2(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        JarUtils.getResources().getColor(R.color.nsdk_interval_speed_progress_bar);
        JarUtils.getResources().getColor(R.color.nsdk_cl_text_g);
        a(context);
    }
}
