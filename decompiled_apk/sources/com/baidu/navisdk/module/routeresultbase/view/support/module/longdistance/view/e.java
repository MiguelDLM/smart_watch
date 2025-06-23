package com.baidu.navisdk.module.routeresultbase.view.support.module.longdistance.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;

/* loaded from: classes7.dex */
public class e extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    private Context f7541a;
    private TextView b;
    private TextView c;
    private TextView d;
    private RelativeLayout e;
    private RelativeLayout f;
    private TextView g;

    public e(Context context) {
        super(context);
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.f7541a = context;
        a();
    }

    private void a() {
        ((LayoutInflater) this.f7541a.getSystemService("layout_inflater")).inflate(R.layout.nsdk_rr_navi_pass_service_info, this);
        this.b = (TextView) findViewById(R.id.car_service_tx);
        this.c = (TextView) findViewById(R.id.car_remain_dis);
        this.d = (TextView) findViewById(R.id.car_remain_time);
        this.e = (RelativeLayout) findViewById(R.id.add_node_rl);
        this.g = (TextView) findViewById(R.id.car_line);
        this.f = (RelativeLayout) findViewById(R.id.car_service_rl);
    }

    private void b(String str) {
        TextView textView = this.d;
        if (textView != null && str != null) {
            textView.setText(str);
        }
    }

    private void c(String str) {
        TextView textView = this.b;
        if (textView != null && str != null) {
            textView.setText(str);
        }
    }

    public int getContentHeight() {
        RelativeLayout relativeLayout = this.e;
        if (relativeLayout != null) {
            return relativeLayout.getMeasuredHeight();
        }
        return 0;
    }

    public Bundle getContentSizeBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt("l", getLeftWidth());
        bundle.putInt("r", getLeftWidth() + getContentWidth());
        bundle.putInt("t", getContentHeight() + ScreenUtil.getInstance().dip2px(40));
        bundle.putInt("b", getContentHeight());
        LogUtil.e("getContentSizeBundle", "bundle is " + bundle.toString());
        return bundle;
    }

    public int getContentWidth() {
        RelativeLayout relativeLayout = this.e;
        if (relativeLayout != null) {
            return relativeLayout.getMeasuredWidth();
        }
        return 0;
    }

    public Bundle getLeftBundel() {
        Bundle bundle = new Bundle();
        bundle.putInt("l", 0);
        bundle.putInt("r", getLeftWidth());
        bundle.putInt("t", getContentHeight() + ScreenUtil.getInstance().dip2px(40));
        bundle.putInt("b", getContentHeight());
        return bundle;
    }

    public int getLeftWidth() {
        RelativeLayout relativeLayout = this.f;
        if (relativeLayout != null) {
            return relativeLayout.getMeasuredWidth();
        }
        return 0;
    }

    public void a(com.baidu.navisdk.module.routeresultbase.logic.longdistance.service.a aVar) {
        if (aVar != null) {
            c(com.baidu.navisdk.module.routeresultbase.logic.longdistance.c.c(aVar.f7521a));
            a(com.baidu.navisdk.module.routeresultbase.logic.longdistance.c.b(aVar.b));
            b(com.baidu.navisdk.module.routeresultbase.logic.longdistance.c.c(aVar.c));
            RelativeLayout relativeLayout = this.e;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(aVar.e ? 0 : 8);
            }
            TextView textView = this.g;
            if (textView != null) {
                textView.setVisibility(aVar.e ? 0 : 8);
            }
        }
    }

    private void a(String str) {
        TextView textView = this.c;
        if (textView == null || str == null) {
            return;
        }
        textView.setText(str);
    }
}
