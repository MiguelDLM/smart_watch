package com.baidu.navisdk.ui.speed.interval;

import android.content.Context;
import android.view.View;
import com.baidu.navisdk.util.common.LogUtil;

/* loaded from: classes8.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private View f9190a;
    private View b;
    private View c;
    private View d;
    private View e;
    private View f;

    public void a(Context context, View... viewArr) {
        if (viewArr != null && viewArr.length == 6 && context != null) {
            this.e = viewArr[0];
            this.b = viewArr[1];
            this.f9190a = viewArr[2];
            this.c = viewArr[3];
            this.d = viewArr[4];
            this.f = viewArr[5];
            return;
        }
        if (!LogUtil.LOGGABLE) {
        } else {
            throw new IllegalArgumentException("参数错误");
        }
    }
}
