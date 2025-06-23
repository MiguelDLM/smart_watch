package com.kwad.components.core.e.b;

/* loaded from: classes11.dex */
public final class a {

    /* renamed from: com.kwad.components.core.e.b.a$a, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0785a {
        private static final c KC = c.a(new int[]{7, 8, 4, 2, 0, 3, 6, 9, 1, 8});
    }

    public static long ad(String str) {
        return nM().ae(str);
    }

    private static c nM() {
        return C0785a.KC;
    }

    public static String t(long j) {
        String u = nM().u(j);
        if (u.endsWith("=")) {
            return u.replace("=", "");
        }
        return u;
    }
}
