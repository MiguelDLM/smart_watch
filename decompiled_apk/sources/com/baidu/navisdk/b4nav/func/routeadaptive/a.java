package com.baidu.navisdk.b4nav.func.routeadaptive;

import android.graphics.Rect;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes7.dex */
public class a extends com.baidu.navisdk.b4nav.framework.repository.a {
    public void a(boolean z) {
        b("is_really_start", Boolean.valueOf(z));
    }

    public List<Rect> b() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Rect(0, 0, 10, 10));
        return arrayList;
    }

    public List<Rect> c() {
        return (List) a("avoid_rects", b());
    }

    public boolean d() {
        return ((Boolean) a("is_really_start", Boolean.FALSE)).booleanValue();
    }
}
