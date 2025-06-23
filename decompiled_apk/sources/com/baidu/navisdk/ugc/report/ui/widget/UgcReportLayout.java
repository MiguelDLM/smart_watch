package com.baidu.navisdk.ugc.report.ui.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.baidu.navisdk.util.common.ScreenUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;

/* loaded from: classes8.dex */
public class UgcReportLayout extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    private Context f8310a;
    private LinkedHashMap<Integer, a> b;
    private ArrayList<a> c;

    public UgcReportLayout(Context context) {
        super(context);
        a(context);
    }

    private void a(Context context) {
        setOrientation(1);
        this.f8310a = context;
        this.c = new ArrayList<>();
        this.b = new LinkedHashMap<>();
    }

    private int getScreenOrientation() {
        Activity b = com.baidu.navisdk.framework.a.c().b();
        if (b != null) {
            return b.getResources().getConfiguration().orientation;
        }
        Context context = this.f8310a;
        if (context != null) {
            return context.getResources().getConfiguration().orientation;
        }
        return 1;
    }

    public void b() {
        ArrayList<a> arrayList = this.c;
        if (arrayList != null) {
            Iterator<a> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().b();
            }
        }
    }

    public void c() {
        ArrayList<a> arrayList = this.c;
        if (arrayList != null) {
            Iterator<a> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().e();
            }
        }
    }

    public void d() {
        removeAllViews();
        ArrayList<a> arrayList = this.c;
        if (arrayList != null && arrayList.size() != 0) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            int i = 20;
            if (getScreenOrientation() == 2) {
                layoutParams.topMargin = ScreenUtil.getInstance().dip2px(12);
                if (this.c.size() >= 3) {
                    i = 8;
                } else if (this.c.size() >= 2) {
                    i = 14;
                }
                layoutParams.bottomMargin = ScreenUtil.getInstance().dip2px(i);
            } else {
                layoutParams.topMargin = ScreenUtil.getInstance().dip2px(17);
                layoutParams.bottomMargin = ScreenUtil.getInstance().dip2px(20);
            }
            setLayoutParams(layoutParams);
            Iterator<a> it = this.c.iterator();
            while (it.hasNext()) {
                addView(it.next().a(this.f8310a));
            }
        }
    }

    public ArrayList<a> getCardViewList() {
        return this.c;
    }

    public LinkedHashMap<Integer, a> getCardViewMap() {
        return this.b;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        ArrayList<a> arrayList = this.c;
        if (arrayList != null) {
            Iterator<a> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().a(configuration);
            }
        }
    }

    public void setLayoutWidth(int i) {
        ArrayList<a> arrayList = this.c;
        if (arrayList != null) {
            Iterator<a> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().b(i);
            }
        }
    }

    public void setTipsMayi(boolean z) {
    }

    public UgcReportLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public UgcReportLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    public void a(a aVar, int i) {
        a(aVar, false, i);
    }

    public void a(a aVar, boolean z, int i) {
        LinkedHashMap<Integer, a> linkedHashMap = this.b;
        if (linkedHashMap == null || this.c == null || linkedHashMap.containsKey(Integer.valueOf(i))) {
            return;
        }
        aVar.f8311a = i;
        this.c.add(aVar);
        this.b.put(Integer.valueOf(i), aVar);
        if (z) {
            d();
        }
    }

    public void a() {
        this.c = new ArrayList<>();
        this.b = new LinkedHashMap<>();
        d();
    }

    public void a(int i, int i2, Intent intent) {
        ArrayList<a> arrayList = this.c;
        if (arrayList != null) {
            Iterator<a> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().a(i, i2, intent);
            }
        }
    }

    public boolean a(int i) {
        ArrayList<a> arrayList = this.c;
        if (arrayList != null) {
            Iterator<a> it = arrayList.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null && next.a(i)) {
                    return true;
                }
            }
        }
        return false;
    }
}
