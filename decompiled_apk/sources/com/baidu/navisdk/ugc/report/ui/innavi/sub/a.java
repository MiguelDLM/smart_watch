package com.baidu.navisdk.ugc.report.ui.innavi.sub;

import android.content.Context;
import android.os.Handler;
import android.view.MotionEvent;
import com.baidu.navisdk.ugc.report.data.datarepository.e;

/* loaded from: classes8.dex */
public abstract class a extends com.baidu.navisdk.ugc.report.ui.c {
    public a(Context context, com.baidu.navisdk.ugc.report.ui.b bVar, e eVar, Handler handler, int i, boolean z) {
        super(context, bVar, eVar, handler, i, z);
    }

    public abstract void A();

    public abstract void a(MotionEvent motionEvent);

    public abstract void c(boolean z);
}
