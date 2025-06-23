package com.ss.android.socialbase.appdownloader.a;

import android.content.Context;
import android.util.Log;

/* loaded from: classes13.dex */
public abstract class a implements e {

    /* renamed from: a, reason: collision with root package name */
    protected final Context f26154a;
    protected final com.ss.android.socialbase.downloader.g.a b;
    protected final String c;

    public a(Context context, com.ss.android.socialbase.downloader.g.a aVar, String str) {
        this.f26154a = context;
        this.b = aVar;
        this.c = str;
    }

    public boolean a() {
        if (this.f26154a == null) {
            return false;
        }
        try {
        } catch (Throwable th) {
            if (com.ss.android.socialbase.downloader.c.a.a()) {
                Log.e("AbsDevicePlan", "check is valid failed!", th);
            }
        }
        if (b().resolveActivity(this.f26154a.getPackageManager()) == null) {
            return false;
        }
        return true;
    }
}
