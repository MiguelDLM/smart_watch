package com.tencent.bugly.proguard;

/* loaded from: classes13.dex */
public final class ar implements Comparable<ar> {

    /* renamed from: a, reason: collision with root package name */
    public long f26560a = -1;
    public long b = -1;
    public String c = null;
    public boolean d = false;
    public boolean e = false;
    public int f = 0;

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(ar arVar) {
        ar arVar2 = arVar;
        if (arVar2 != null) {
            long j = this.b - arVar2.b;
            if (j <= 0) {
                if (j < 0) {
                    return -1;
                }
                return 0;
            }
            return 1;
        }
        return 1;
    }
}
