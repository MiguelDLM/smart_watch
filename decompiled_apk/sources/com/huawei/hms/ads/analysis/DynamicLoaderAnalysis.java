package com.huawei.hms.ads.analysis;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes10.dex */
public class DynamicLoaderAnalysis {

    /* renamed from: a, reason: collision with root package name */
    private static final byte[] f17254a = new byte[0];
    private static DynamicLoaderAnalysis b;
    private HashMap<String, IDynamicLoaderAnalysis> c;

    private DynamicLoaderAnalysis() {
    }

    public static DynamicLoaderAnalysis getInstance() {
        DynamicLoaderAnalysis dynamicLoaderAnalysis;
        synchronized (f17254a) {
            try {
                if (b == null) {
                    b = new DynamicLoaderAnalysis();
                }
                dynamicLoaderAnalysis = b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return dynamicLoaderAnalysis;
    }

    public void onLoaderException(String str, int i, String str2) {
        HashMap<String, IDynamicLoaderAnalysis> hashMap = this.c;
        if (hashMap == null) {
            return;
        }
        for (Map.Entry<String, IDynamicLoaderAnalysis> entry : hashMap.entrySet()) {
            IDynamicLoaderAnalysis value = entry.getValue();
            if (value != null) {
                value.onLoaderException(entry.getKey(), str, i, str2);
            }
        }
    }

    public void onLoaderSuccess(String str, long j) {
        HashMap<String, IDynamicLoaderAnalysis> hashMap = this.c;
        if (hashMap == null) {
            return;
        }
        for (Map.Entry<String, IDynamicLoaderAnalysis> entry : hashMap.entrySet()) {
            IDynamicLoaderAnalysis value = entry.getValue();
            if (value != null) {
                value.onLoaderSuccess(entry.getKey(), str, j);
            }
        }
    }

    public void registerDynamicLoaderAnalysis(String str, IDynamicLoaderAnalysis iDynamicLoaderAnalysis) {
        if (TextUtils.isEmpty(str) || iDynamicLoaderAnalysis == null) {
            return;
        }
        if (this.c == null) {
            this.c = new HashMap<>();
        }
        if (this.c.containsKey(str)) {
            return;
        }
        this.c.put(str, iDynamicLoaderAnalysis);
    }
}
