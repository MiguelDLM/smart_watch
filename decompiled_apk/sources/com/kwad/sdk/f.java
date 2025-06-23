package com.kwad.sdk;

/* loaded from: classes11.dex */
public final class f {
    private volatile boolean alv = false;
    private com.kwad.sdk.f.a alw;

    private f(com.kwad.sdk.f.a aVar) {
        this.alw = aVar;
    }

    public static f W(final long j) {
        return d(new com.kwad.sdk.f.a() { // from class: com.kwad.sdk.f.1
            @Override // com.kwad.sdk.f.a
            public final void accept(Object obj) {
                m.ac(j);
            }
        });
    }

    public static f X(final long j) {
        return d(new com.kwad.sdk.f.a() { // from class: com.kwad.sdk.f.2
            @Override // com.kwad.sdk.f.a
            public final void accept(Object obj) {
                m.ad(j);
            }
        });
    }

    public static f Y(final long j) {
        return d(new com.kwad.sdk.f.a() { // from class: com.kwad.sdk.f.3
            @Override // com.kwad.sdk.f.a
            public final void accept(Object obj) {
                m.af(j);
            }
        });
    }

    public static f Z(final long j) {
        return d(new com.kwad.sdk.f.a() { // from class: com.kwad.sdk.f.4
            @Override // com.kwad.sdk.f.a
            public final void accept(Object obj) {
                m.ag(j);
            }
        });
    }

    private static f d(com.kwad.sdk.f.a aVar) {
        return new f(aVar);
    }

    public final synchronized void report() {
        if (this.alw != null && !this.alv) {
            this.alw.accept(null);
            this.alv = true;
        }
    }
}
