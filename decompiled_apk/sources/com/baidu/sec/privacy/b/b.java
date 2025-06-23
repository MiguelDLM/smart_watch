package com.baidu.sec.privacy.b;

import android.content.SharedPreferences;

/* loaded from: classes8.dex */
public class b implements SharedPreferences.OnSharedPreferenceChangeListener {
    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if (!d.b.equals(str)) {
            return;
        }
        new Thread(new c(this, sharedPreferences, str)).start();
    }
}
