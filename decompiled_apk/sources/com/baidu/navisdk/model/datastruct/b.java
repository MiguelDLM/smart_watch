package com.baidu.navisdk.model.datastruct;

import android.os.Bundle;
import com.baidu.nplatform.comapi.MapItem;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/* loaded from: classes7.dex */
public class b {
    private int c;
    private String[] e;
    private int f;
    private final ArrayList<com.baidu.nplatform.comapi.basestruct.c> d = new ArrayList<>();
    private final List<String> g = new ArrayList();

    /* renamed from: a, reason: collision with root package name */
    public int f6903a = Math.abs(new Random().nextInt());
    public String b = this.f6903a + "";

    @Deprecated
    public b a(int i) {
        this.f6903a = i;
        return this;
    }

    public void b(String[] strArr) {
    }

    public void c(String[] strArr) {
    }

    public String toString() {
        return "BNMapGData{id=" + this.f6903a + ", sid=" + this.b + ", priority=" + this.c + ", points=" + this.d + ", contents=" + Arrays.toString(this.e) + ", patternId=" + this.f + '}';
    }

    public b a(String str) {
        this.b = str;
        return this;
    }

    public b b(int i) {
        this.f = i;
        return this;
    }

    public b a(com.baidu.nplatform.comapi.basestruct.c cVar) {
        this.d.add(cVar);
        return this;
    }

    public b a(String... strArr) {
        this.e = strArr;
        return this;
    }

    public b a(List<String> list) {
        this.g.addAll(list);
        return this;
    }

    public Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putLong("id", this.f6903a);
        bundle.putString(MapItem.KEY_ITEM_SID, this.b);
        bundle.putInt("priority", this.c);
        bundle.putInt("patternId", this.f);
        Bundle[] bundleArr = new Bundle[this.d.size()];
        for (int i = 0; i < this.d.size(); i++) {
            Bundle bundle2 = new Bundle();
            bundle2.putDouble("latitude", this.d.get(i).b());
            bundle2.putDouble("longitude", this.d.get(i).a());
            bundleArr[i] = bundle2;
        }
        bundle.putParcelableArray("pointsArray", bundleArr);
        String[] strArr = this.e;
        if (strArr != null) {
            bundle.putStringArray("contents", strArr);
        }
        return bundle;
    }
}
