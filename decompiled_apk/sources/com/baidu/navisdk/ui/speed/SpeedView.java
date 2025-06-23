package com.baidu.navisdk.ui.speed;

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
public class SpeedView extends RelativeLayout {
    private static String g = "SpeedView";

    /* renamed from: a, reason: collision with root package name */
    private TextView f9186a;
    private TextView b;
    private View c;
    private View d;
    private View e;
    private View f;

    public SpeedView(Context context) {
        super(context);
        a(context);
    }

    private void a(Context context) {
        a(JarUtils.inflate(context, getPortraitLayoutId(), this));
    }

    private Context getCtx() {
        View view = this.f;
        if (view != null) {
            return view.getContext();
        }
        View view2 = this.e;
        if (view2 != null) {
            return view2.getContext();
        }
        return null;
    }

    public final View getContentView() {
        return this.f;
    }

    public int getPortraitLayoutId() {
        return R.layout.nsdk_layout_speed;
    }

    @Deprecated
    public void setContentVisibility(int i) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(g, "setContentVisibility,visibility:" + i);
        }
        View view = this.f;
        if (view != null) {
            view.setVisibility(i);
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (LogUtil.LOGGABLE) {
            LogUtil.e(g, "setVisibility,visibility:" + i);
        }
    }

    public SpeedView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public void a(@NonNull View view) {
        this.f = view;
        this.f9186a = (TextView) view.findViewById(R.id.bnav_rg_cp_cur_car_speed);
        this.c = view.findViewById(R.id.bnav_rg_cp_car_speed_bg);
        this.d = view.findViewById(R.id.bnav_rg_cp_cur_overspeed_anim_view);
        this.b = (TextView) view.findViewById(R.id.bnav_rg_cp_cur_car_speed_tv);
    }

    public SpeedView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }
}
