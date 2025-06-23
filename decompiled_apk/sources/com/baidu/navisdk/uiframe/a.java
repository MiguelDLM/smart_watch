package com.baidu.navisdk.uiframe;

import android.util.SparseIntArray;
import com.baidu.navisdk.uiframe.framework.a;
import com.baidu.navisdk.util.worker.lite.b;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes8.dex */
public class a<C extends com.baidu.navisdk.uiframe.framework.a> {

    /* renamed from: a, reason: collision with root package name */
    public UiModule<C> f9215a;
    public boolean b;
    public boolean c;
    public b d;
    public b e;
    public a<C> g;
    private final SparseIntArray f = new SparseIntArray();
    public final Map<String, a<C>> h = new LinkedHashMap();

    public int a(int i) {
        return this.f.get(i, 0);
    }

    public void b(int i) {
        b bVar = this.d;
        if (bVar != null) {
            com.baidu.navisdk.util.worker.lite.a.a(bVar);
        }
        b bVar2 = this.e;
        if (bVar2 != null) {
            com.baidu.navisdk.util.worker.lite.a.a(bVar2);
        }
        this.d = null;
        this.e = null;
        this.f.clear();
    }

    public void a(int i, int i2) {
        this.f.put(i, i2);
    }
}
