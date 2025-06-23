package com.ss.android.socialbase.downloader.f;

import android.util.Log;
import com.facebook.appevents.UserDataStore;
import com.szabh.smable3.entity.Languages;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes13.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    volatile m f26291a;
    int b;
    private final long c;
    private final AtomicLong d;
    private volatile long e;
    private long f;
    private int g;
    private JSONObject h;

    public i(long j, long j2) {
        AtomicLong atomicLong = new AtomicLong();
        this.d = atomicLong;
        this.b = 0;
        this.c = j;
        atomicLong.set(j);
        this.e = j;
        if (j2 >= j) {
            this.f = j2;
        } else {
            this.f = -1L;
        }
    }

    public long a() {
        return this.d.get() - this.c;
    }

    public long b() {
        long j = this.f;
        if (j >= this.c) {
            return (j - e()) + 1;
        }
        return -1L;
    }

    public long c() {
        return this.c;
    }

    public long d() {
        long j = this.d.get();
        long j2 = this.f;
        if (j2 > 0) {
            long j3 = j2 + 1;
            if (j > j3) {
                return j3;
            }
        }
        return j;
    }

    public long e() {
        m mVar = this.f26291a;
        if (mVar != null) {
            long d = mVar.d();
            if (d > this.e) {
                return d;
            }
        }
        return this.e;
    }

    public long f() {
        return this.f;
    }

    public int g() {
        return this.g;
    }

    public void h() {
        this.b++;
    }

    public void i() {
        this.b--;
    }

    public int j() {
        return this.b;
    }

    public JSONObject k() throws JSONException {
        JSONObject jSONObject = this.h;
        if (jSONObject == null) {
            jSONObject = new JSONObject();
            this.h = jSONObject;
        }
        jSONObject.put(UserDataStore.STATE, c());
        jSONObject.put("cu", d());
        jSONObject.put(Languages.DEFAULT_LANGUAGE, f());
        return jSONObject;
    }

    public String toString() {
        return "Segment{startOffset=" + this.c + ",\t currentOffset=" + this.d + ",\t currentOffsetRead=" + e() + ",\t endOffset=" + this.f + '}';
    }

    public void a(long j) {
        long j2 = this.c;
        if (j < j2) {
            j = j2;
        }
        long j3 = this.f;
        if (j3 > 0) {
            long j4 = j3 + 1;
            if (j > j4) {
                j = j4;
            }
        }
        this.d.set(j);
    }

    public void c(long j) {
        if (j >= this.c) {
            this.f = j;
            return;
        }
        Log.w("Segment", "setEndOffset: endOffset = " + j + ", segment = " + this);
        if (j == -1) {
            this.f = j;
        }
    }

    public void b(long j) {
        this.d.addAndGet(j);
    }

    public void d(long j) {
        if (j >= this.d.get()) {
            this.e = j;
        }
    }

    public void b(int i) {
        this.b = i;
    }

    public void a(int i) {
        this.g = i;
    }

    public static String a(List<i> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        Collections.sort(list, new Comparator<i>() { // from class: com.ss.android.socialbase.downloader.f.i.1
            @Override // java.util.Comparator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(i iVar, i iVar2) {
                return (int) (iVar.c() - iVar2.c());
            }
        });
        StringBuilder sb = new StringBuilder();
        Iterator<i> it = list.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            sb.append("\r\n");
        }
        return sb.toString();
    }

    public i(i iVar) {
        AtomicLong atomicLong = new AtomicLong();
        this.d = atomicLong;
        this.b = 0;
        this.c = iVar.c;
        this.f = iVar.f;
        atomicLong.set(iVar.d.get());
        this.e = atomicLong.get();
        this.g = iVar.g;
    }

    public i(JSONObject jSONObject) {
        this.d = new AtomicLong();
        this.b = 0;
        this.c = jSONObject.optLong(UserDataStore.STATE);
        c(jSONObject.optLong(Languages.DEFAULT_LANGUAGE));
        a(jSONObject.optLong("cu"));
        d(d());
    }
}
