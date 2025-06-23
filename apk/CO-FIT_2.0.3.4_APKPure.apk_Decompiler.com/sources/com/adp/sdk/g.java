package com.adp.sdk;

import com.qq.e.comm.managers.GDTAdSdk;

public class g {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static boolean f719a = false;

    public static class a implements GDTAdSdk.OnStartListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f720a;

        public a(b bVar) {
            this.f720a = bVar;
        }

        public void onStartFailed(Exception exc) {
            b bVar = this.f720a;
            if (bVar != null) {
                bVar.a();
            }
        }

        public void onStartSuccess() {
            boolean unused = g.f719a = true;
            b bVar = this.f720a;
            if (bVar != null) {
                bVar.success();
            }
        }
    }

    public interface b {
        void a();

        void success();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0032, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized boolean a(android.content.Context r5, com.adp.sdk.g.b r6) {
        /*
            java.lang.Class<com.adp.sdk.g> r0 = com.adp.sdk.g.class
            monitor-enter(r0)
            boolean r1 = f719a     // Catch:{ all -> 0x002d }
            r2 = 1
            if (r1 == 0) goto L_0x000a
            monitor-exit(r0)
            return r2
        L_0x000a:
            r1 = 0
            if (r5 != 0) goto L_0x000f
            monitor-exit(r0)
            return r1
        L_0x000f:
            com.adp.sdk.dto.AdInfo r5 = com.adp.sdk.a.b     // Catch:{ all -> 0x002d }
            if (r5 == 0) goto L_0x0031
            java.lang.String r5 = r5.getTencent()     // Catch:{ all -> 0x002d }
            boolean r5 = a((java.lang.String) r5)     // Catch:{ all -> 0x002d }
            if (r5 == 0) goto L_0x001e
            goto L_0x0031
        L_0x001e:
            r3 = 100
            java.lang.Thread.sleep(r3)     // Catch:{ Exception -> 0x002f }
            com.adp.sdk.g$a r5 = new com.adp.sdk.g$a     // Catch:{ Exception -> 0x002f }
            r5.<init>(r6)     // Catch:{ Exception -> 0x002f }
            com.qq.e.comm.managers.GDTAdSdk.start(r5)     // Catch:{ Exception -> 0x002f }
            monitor-exit(r0)
            return r2
        L_0x002d:
            r5 = move-exception
            goto L_0x0033
        L_0x002f:
            monitor-exit(r0)
            return r1
        L_0x0031:
            monitor-exit(r0)
            return r1
        L_0x0033:
            monitor-exit(r0)     // Catch:{ all -> 0x002d }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adp.sdk.g.a(android.content.Context, com.adp.sdk.g$b):boolean");
    }

    public static boolean a() {
        return f719a;
    }

    private static boolean a(String str) {
        return str == null || str.trim().length() == 0;
    }
}
