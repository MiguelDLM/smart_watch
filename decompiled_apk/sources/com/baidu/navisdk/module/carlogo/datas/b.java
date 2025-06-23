package com.baidu.navisdk.module.carlogo.datas;

/* loaded from: classes7.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public boolean f7076a;
    public com.baidu.navisdk.module.carlogo.listeners.c b;
    public int c;
    public String d;

    public b() {
        this.f7076a = true;
        this.c = 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        if (!this.b.equals(bVar.b)) {
            return false;
        }
        return this.d.equals(bVar.d);
    }

    public int hashCode() {
        return (this.b.hashCode() * 31) + this.d.hashCode();
    }

    public String toString() {
        return "ThreeDDownloadRequest{isNeedProgress=" + this.f7076a + ", downloadZipFileListener=" + this.b + ", currentProgress=" + this.c + ", url='" + this.d + "'}";
    }

    public b(boolean z, int i, com.baidu.navisdk.module.carlogo.listeners.c cVar, String str) {
        this.f7076a = z;
        this.b = cVar;
        this.d = str;
        this.c = 0;
    }
}
