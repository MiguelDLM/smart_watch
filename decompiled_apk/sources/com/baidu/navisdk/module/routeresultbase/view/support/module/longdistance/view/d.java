package com.baidu.navisdk.module.routeresultbase.view.support.module.longdistance.view;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import androidx.appcompat.widget.AppCompatTextView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.util.common.LogUtil;

/* loaded from: classes7.dex */
public class d extends AppCompatTextView {
    public d(Context context) {
        super(context);
        setTextColor(-13400577);
        setGravity(16);
    }

    public void a(com.baidu.navisdk.module.routeresultbase.logic.longdistance.service.a aVar) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("CarServiceView2", "updateBigLabel: " + aVar);
        }
        setTextSize(1, 15.0f);
        setBackgroundResource(R.drawable.bnav_long_dis_service_big_label);
        setTypeface(Typeface.defaultFromStyle(1));
        setText(com.baidu.navisdk.module.routeresultbase.logic.longdistance.c.a(aVar.b));
    }

    public void b(com.baidu.navisdk.module.routeresultbase.logic.longdistance.service.a aVar) {
        setTextSize(1, 10.0f);
        setBackgroundResource(R.drawable.bnav_long_dis_service_small_label);
        setText(com.baidu.navisdk.module.routeresultbase.logic.longdistance.c.a(aVar.b));
    }

    public Bundle getContentSizeBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt("l", 0);
        bundle.putInt("r", getMeasuredWidth());
        bundle.putInt("t", 0);
        bundle.putInt("b", getMeasuredHeight());
        if (LogUtil.LOGGABLE) {
            LogUtil.e("CarServiceView2", "getContentSizeBundle: " + bundle.toString());
        }
        return bundle;
    }
}
