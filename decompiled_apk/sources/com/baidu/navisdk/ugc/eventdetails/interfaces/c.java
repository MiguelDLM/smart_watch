package com.baidu.navisdk.ugc.eventdetails.interfaces;

import android.content.Context;
import android.content.Intent;
import android.view.View;

/* loaded from: classes8.dex */
public interface c {
    void a(int i, String str, boolean z);

    boolean a(int i);

    void b(Context context, int i);

    View e();

    void f();

    int g();

    void onActivityResult(int i, int i2, Intent intent);

    boolean onBackPressed();

    void onDestroy();

    void onPause();

    void onResume();
}
