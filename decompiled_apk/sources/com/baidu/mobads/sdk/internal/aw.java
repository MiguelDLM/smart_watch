package com.baidu.mobads.sdk.internal;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.mobads.sdk.internal.az;

/* loaded from: classes7.dex */
public class aw extends az.a {

    /* renamed from: a, reason: collision with root package name */
    public static final String f6237a = "debug";

    @Override // com.baidu.mobads.sdk.internal.az.a
    @NonNull
    public String a() {
        return "debug";
    }

    @Override // com.baidu.mobads.sdk.internal.az.a
    public boolean a(String str, int i) {
        return az.f6239a.equals(str);
    }

    @Override // com.baidu.mobads.sdk.internal.az.a
    public void a(int i, String str, String str2, Throwable th) {
        a(i, str, str2);
    }

    private static void a(int i, String str, String str2) {
        try {
            if (i == 7) {
                Log.wtf(str, str2);
            } else {
                Log.println(i, str, str2);
            }
        } catch (Throwable unused) {
        }
    }
}
