package com.baidu.navisdk.ugc.report.ui;

import android.content.Intent;
import android.content.res.Configuration;

/* loaded from: classes8.dex */
public interface b extends com.baidu.navisdk.ugc.report.b<a> {
    void a(String str, String str2);

    void a(boolean z);

    boolean d(int i);

    void onActivityResult(int i, int i2, Intent intent);

    void onConfigurationChanged(Configuration configuration);

    void onDestroy();
}
