package com.baidu.ar;

import android.content.Context;
import com.baidu.ar.arplay.core.message.ARPMessage;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes7.dex */
public class fs extends ap {
    private boolean bi;
    private fu kp;
    private List<WeakReference<ft>> tI;

    public fs(Context context) {
        super(context);
        this.tI = Collections.synchronizedList(new ArrayList());
        this.bi = false;
        bd();
        fu fuVar = new fu();
        this.kp = fuVar;
        fuVar.setContext(context);
        c(this.kp);
    }

    public void aK(String str) {
        ARPMessage.getInstance().sendLuaScriptToEngine(str);
    }

    public void b(int i, HashMap<String, Object> hashMap) {
        ARPMessage.getInstance().sendMessage(i, hashMap);
    }

    public synchronized boolean c(ft ftVar) {
        List<WeakReference<ft>> list = this.tI;
        if (list == null) {
            return false;
        }
        for (WeakReference<ft> weakReference : list) {
            if (weakReference.get() != null && weakReference.get().equals(ftVar)) {
                return false;
            }
        }
        kf.c("EngineMsgBridge", "addEngineMsgListener engineMsgListener = " + ftVar.hashCode());
        return this.tI.add(new WeakReference<>(ftVar));
    }

    public synchronized boolean d(ft ftVar) {
        List<WeakReference<ft>> list = this.tI;
        if (list == null) {
            return false;
        }
        for (WeakReference<ft> weakReference : list) {
            if (weakReference.get() != null && weakReference.get().equals(ftVar)) {
                kf.c("EngineMsgBridge", "removeEngineMsgListener engineMsgListener = " + ftVar.hashCode());
                boolean remove = this.tI.remove(weakReference);
                weakReference.clear();
                return remove;
            }
        }
        return false;
    }

    public synchronized void destroy() {
        try {
            fu fuVar = this.kp;
            if (fuVar != null) {
                fuVar.destroy();
                this.kp = null;
            }
            List<WeakReference<ft>> list = this.tI;
            if (list != null) {
                Iterator<WeakReference<ft>> it = list.iterator();
                while (it.hasNext()) {
                    it.next().clear();
                }
                this.tI.clear();
                this.tI = null;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public fu ei() {
        return this.kp;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x003a A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003c  */
    @Override // com.baidu.ar.ap, com.baidu.ar.arplay.core.message.ARPMessage.MessageHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void handleMessage(int r5, int r6, java.util.HashMap<java.lang.String, java.lang.Object> r7) {
        /*
            r4 = this;
            monitor-enter(r4)
            java.lang.String r0 = "EngineMsgBridge"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L2d
            r1.<init>()     // Catch: java.lang.Throwable -> L2d
            java.lang.String r2 = "handleMessage aMessageType = "
            r1.append(r2)     // Catch: java.lang.Throwable -> L2d
            r1.append(r5)     // Catch: java.lang.Throwable -> L2d
            java.lang.String r2 = " && aMessageID = "
            r1.append(r2)     // Catch: java.lang.Throwable -> L2d
            r1.append(r6)     // Catch: java.lang.Throwable -> L2d
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L2d
            com.baidu.ar.kf.c(r0, r1)     // Catch: java.lang.Throwable -> L2d
            boolean r0 = r4.bi     // Catch: java.lang.Throwable -> L2d
            if (r0 == 0) goto L2f
            boolean r0 = r4.b(r5, r6, r7)     // Catch: java.lang.Throwable -> L2d
            if (r0 != 0) goto L2a
            goto L2f
        L2a:
            r5 = 1901(0x76d, float:2.664E-42)
            goto L36
        L2d:
            r5 = move-exception
            goto L82
        L2f:
            r0 = 8200(0x2008, float:1.149E-41)
            if (r5 == r0) goto L36
            super.handleMessage(r5, r6, r7)     // Catch: java.lang.Throwable -> L2d
        L36:
            java.util.List<java.lang.ref.WeakReference<com.baidu.ar.ft>> r0 = r4.tI     // Catch: java.lang.Throwable -> L2d
            if (r0 != 0) goto L3c
            monitor-exit(r4)
            return
        L3c:
            r0 = 0
        L3d:
            java.util.List<java.lang.ref.WeakReference<com.baidu.ar.ft>> r1 = r4.tI     // Catch: java.lang.Throwable -> L2d
            int r1 = r1.size()     // Catch: java.lang.Throwable -> L2d
            if (r0 >= r1) goto L80
            java.util.List<java.lang.ref.WeakReference<com.baidu.ar.ft>> r1 = r4.tI     // Catch: java.lang.Throwable -> L2d
            java.lang.Object r1 = r1.get(r0)     // Catch: java.lang.Throwable -> L2d
            java.lang.ref.WeakReference r1 = (java.lang.ref.WeakReference) r1     // Catch: java.lang.Throwable -> L2d
            if (r1 != 0) goto L50
            goto L7d
        L50:
            java.lang.Object r1 = r1.get()     // Catch: java.lang.Throwable -> L2d
            com.baidu.ar.ft r1 = (com.baidu.ar.ft) r1     // Catch: java.lang.Throwable -> L2d
            if (r1 == 0) goto L7d
            java.util.List r2 = r1.q()     // Catch: java.lang.Throwable -> L2d
            if (r2 != 0) goto L5f
            goto L7d
        L5f:
            java.util.List r2 = r1.q()     // Catch: java.lang.Throwable -> L2d
            java.util.Iterator r2 = r2.iterator()     // Catch: java.lang.Throwable -> L2d
        L67:
            boolean r3 = r2.hasNext()     // Catch: java.lang.Throwable -> L2d
            if (r3 == 0) goto L7d
            java.lang.Object r3 = r2.next()     // Catch: java.lang.Throwable -> L2d
            java.lang.Integer r3 = (java.lang.Integer) r3     // Catch: java.lang.Throwable -> L2d
            int r3 = r3.intValue()     // Catch: java.lang.Throwable -> L2d
            if (r5 != r3) goto L67
            r1.a(r5, r6, r7)     // Catch: java.lang.Throwable -> L2d
            goto L67
        L7d:
            int r0 = r0 + 1
            goto L3d
        L80:
            monitor-exit(r4)
            return
        L82:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L2d
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.ar.fs.handleMessage(int, int, java.util.HashMap):void");
    }

    public void setUserPlayAudio(boolean z) {
        this.bi = z;
    }

    private synchronized boolean b(int i, int i2, HashMap<String, Object> hashMap) {
        if (i == 1001) {
            hashMap.put("audio_status", "audio_play");
            return true;
        }
        if (i == 1003) {
            hashMap.put("audio_status", "audio_pause");
            return true;
        }
        if (i == 1005) {
            hashMap.put("audio_status", "audio_resume");
            return true;
        }
        if (i == 1007) {
            hashMap.put("audio_status", "audio_stop");
            return true;
        }
        if (i != 1012) {
            return false;
        }
        hashMap.put("audio_status", "audio_reset");
        return true;
    }
}
