package com.baidu.ar;

import android.content.Context;
import com.baidu.ar.lua.LuaMsgListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: classes7.dex */
public class fu implements ft {
    private Context mContext;
    private List<LuaMsgListener> tJ = Collections.synchronizedList(new ArrayList());

    /* JADX WARN: Removed duplicated region for block: B:15:0x004a A[Catch: all -> 0x0025, TryCatch #1 {, blocks: (B:48:0x0004, B:50:0x000e, B:52:0x0016, B:7:0x0030, B:8:0x003a, B:13:0x0042, B:15:0x004a, B:20:0x0055, B:25:0x005d, B:27:0x0063, B:29:0x006f, B:31:0x0075, B:55:0x0028), top: B:47:0x0004, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0030 A[Catch: all -> 0x0025, TryCatch #1 {, blocks: (B:48:0x0004, B:50:0x000e, B:52:0x0016, B:7:0x0030, B:8:0x003a, B:13:0x0042, B:15:0x004a, B:20:0x0055, B:25:0x005d, B:27:0x0063, B:29:0x006f, B:31:0x0075, B:55:0x0028), top: B:47:0x0004, inners: #0 }] */
    @Override // com.baidu.ar.ft
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void a(int r6, int r7, java.util.HashMap<java.lang.String, java.lang.Object> r8) {
        /*
            r5 = this;
            monitor-enter(r5)
            r6 = 0
            if (r8 == 0) goto L2b
            java.util.Set r7 = r8.entrySet()     // Catch: java.lang.Throwable -> L25 java.lang.NumberFormatException -> L27
            int r7 = r7.size()     // Catch: java.lang.Throwable -> L25 java.lang.NumberFormatException -> L27
            if (r7 <= 0) goto L2b
            java.lang.String r7 = "id"
            boolean r7 = r8.containsKey(r7)     // Catch: java.lang.Throwable -> L25 java.lang.NumberFormatException -> L27
            if (r7 == 0) goto L2b
            java.lang.String r7 = "id"
            java.lang.Object r7 = r8.get(r7)     // Catch: java.lang.Throwable -> L25 java.lang.NumberFormatException -> L27
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Throwable -> L25 java.lang.NumberFormatException -> L27
            int r7 = java.lang.Integer.parseInt(r7)     // Catch: java.lang.Throwable -> L25 java.lang.NumberFormatException -> L27
            goto L2c
        L25:
            r6 = move-exception
            goto L82
        L27:
            r7 = move-exception
            r7.printStackTrace()     // Catch: java.lang.Throwable -> L25
        L2b:
            r7 = 0
        L2c:
            r0 = 9001(0x2329, float:1.2613E-41)
            if (r7 != r0) goto L3a
            com.baidu.ar.fw r7 = new com.baidu.ar.fw     // Catch: java.lang.Throwable -> L25
            android.content.Context r0 = r5.mContext     // Catch: java.lang.Throwable -> L25
            r7.<init>(r0)     // Catch: java.lang.Throwable -> L25
            r7.l(r8)     // Catch: java.lang.Throwable -> L25
        L3a:
            java.util.List<com.baidu.ar.lua.LuaMsgListener> r7 = r5.tJ     // Catch: java.lang.Throwable -> L25
            if (r7 == 0) goto L80
            if (r8 != 0) goto L41
            goto L80
        L41:
            r7 = 0
        L42:
            java.util.List<com.baidu.ar.lua.LuaMsgListener> r0 = r5.tJ     // Catch: java.lang.Throwable -> L25
            int r0 = r0.size()     // Catch: java.lang.Throwable -> L25
            if (r7 >= r0) goto L7e
            java.util.List<com.baidu.ar.lua.LuaMsgListener> r0 = r5.tJ     // Catch: java.lang.Throwable -> L25
            java.lang.Object r0 = r0.get(r7)     // Catch: java.lang.Throwable -> L25
            com.baidu.ar.lua.LuaMsgListener r0 = (com.baidu.ar.lua.LuaMsgListener) r0     // Catch: java.lang.Throwable -> L25
            if (r0 != 0) goto L55
            goto L7b
        L55:
            java.util.List r1 = r0.getMsgKeyListened()     // Catch: java.lang.Throwable -> L25
            if (r1 != 0) goto L5c
            goto L7b
        L5c:
            r2 = 0
        L5d:
            int r3 = r1.size()     // Catch: java.lang.Throwable -> L25
            if (r2 >= r3) goto L7b
            java.lang.Object r3 = r1.get(r2)     // Catch: java.lang.Throwable -> L25
            java.lang.String r3 = (java.lang.String) r3     // Catch: java.lang.Throwable -> L25
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Throwable -> L25
            if (r4 != 0) goto L78
            java.lang.Object r3 = r8.get(r3)     // Catch: java.lang.Throwable -> L25
            if (r3 == 0) goto L78
            r0.onLuaMessage(r8)     // Catch: java.lang.Throwable -> L25
        L78:
            int r2 = r2 + 1
            goto L5d
        L7b:
            int r7 = r7 + 1
            goto L42
        L7e:
            monitor-exit(r5)
            return
        L80:
            monitor-exit(r5)
            return
        L82:
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L25
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.ar.fu.a(int, int, java.util.HashMap):void");
    }

    public synchronized boolean addLuaMsgListener(LuaMsgListener luaMsgListener) {
        List<LuaMsgListener> list = this.tJ;
        if (list == null) {
            return false;
        }
        for (LuaMsgListener luaMsgListener2 : list) {
            if (luaMsgListener2 != null && luaMsgListener2.equals(luaMsgListener)) {
                return false;
            }
        }
        kf.c("LuaMsgBridge", "addLuaMsgListener luaMsgListener = " + luaMsgListener.hashCode());
        return this.tJ.add(luaMsgListener);
    }

    public synchronized void destroy() {
        List<LuaMsgListener> list = this.tJ;
        if (list != null) {
            list.clear();
            this.tJ = null;
        }
    }

    @Override // com.baidu.ar.ft
    public List<Integer> q() {
        return Arrays.asList(1901);
    }

    public synchronized boolean removeLuaMsgListener(LuaMsgListener luaMsgListener) {
        List<LuaMsgListener> list = this.tJ;
        if (list == null) {
            return false;
        }
        for (LuaMsgListener luaMsgListener2 : list) {
            if (luaMsgListener2 != null && luaMsgListener2.equals(luaMsgListener)) {
                kf.c("LuaMsgBridge", "removeLuaMsgListener luaMsgListener = " + luaMsgListener.hashCode());
                return this.tJ.remove(luaMsgListener2);
            }
        }
        return false;
    }

    public void setContext(Context context) {
        this.mContext = context;
    }
}
