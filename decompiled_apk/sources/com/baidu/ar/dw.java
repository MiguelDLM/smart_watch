package com.baidu.ar;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.net.URI;
import java.util.Locale;

/* loaded from: classes7.dex */
public class dw implements dt {
    private Handler mHandler;
    private du pQ;
    private volatile ds pR;
    private Runnable pS = new Runnable() { // from class: com.baidu.ar.dw.1
        @Override // java.lang.Runnable
        public void run() {
            dw.this.dl();
            dw.this.mHandler.postDelayed(dw.this.pS, 5000L);
        }
    };
    private HandlerThread pv;

    /* JADX INFO: Access modifiers changed from: private */
    public void dj() {
        HandlerThread handlerThread = this.pv;
        if (handlerThread == null || !handlerThread.isAlive()) {
            return;
        }
        this.mHandler.removeCallbacks(this.pS);
        this.mHandler.post(this.pS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dk() {
        an(String.format(Locale.CHINA, "{\"requestId\":\"heart%d\",\"action\":\"HEART_BEAT\"}", Long.valueOf(System.currentTimeMillis())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dl() {
        Message.obtain(this.mHandler, 5).sendToTarget();
    }

    @Override // com.baidu.ar.dt
    public void am(String str) {
        this.pR = new ds(URI.create(str));
        this.pR.a(new du() { // from class: com.baidu.ar.dw.2
            @Override // com.baidu.ar.du
            public void a(int i, String str2, boolean z) {
                if (dw.this.pQ != null) {
                    dw.this.pQ.a(i, str2, z);
                }
            }

            @Override // com.baidu.ar.du
            public void al(String str2) {
                kf.c("WebSocket", "resp: " + str2);
                if (dw.this.pQ != null) {
                    dw.this.pQ.al(str2);
                }
            }

            @Override // com.baidu.ar.du
            public void onError(int i, String str2) {
                if (dw.this.pQ != null) {
                    dw.this.pQ.onError(i, str2);
                }
            }

            @Override // com.baidu.ar.du
            public void onOpen() {
                if (dw.this.pQ != null) {
                    dw.this.pQ.onOpen();
                }
                dw.this.dj();
            }
        });
        HandlerThread handlerThread = new HandlerThread("WebSocketManager");
        this.pv = handlerThread;
        handlerThread.start();
        this.mHandler = new Handler(this.pv.getLooper(), new Handler.Callback() { // from class: com.baidu.ar.dw.3
            /* JADX WARN: Code restructure failed: missing block: B:29:0x006c, code lost:
            
                if (r5.pT.pQ != null) goto L31;
             */
            /* JADX WARN: Code restructure failed: missing block: B:37:0x009e, code lost:
            
                if (r5.pT.pQ != null) goto L31;
             */
            @Override // android.os.Handler.Callback
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public boolean handleMessage(android.os.Message r6) {
                /*
                    r5 = this;
                    com.baidu.ar.dw r0 = com.baidu.ar.dw.this
                    com.baidu.ar.ds r0 = com.baidu.ar.dw.f(r0)
                    r1 = 1
                    if (r0 != 0) goto La
                    return r1
                La:
                    int r0 = r6.what
                    if (r0 == r1) goto Lb3
                    r2 = 2
                    if (r0 == r2) goto La1
                    r2 = 3
                    java.lang.String r3 = "websocket not open"
                    r4 = 1002(0x3ea, float:1.404E-42)
                    if (r0 == r2) goto L78
                    r2 = 4
                    if (r0 == r2) goto L46
                    r6 = 5
                    if (r0 == r6) goto L21
                    goto Lbc
                L21:
                    com.baidu.ar.dw r6 = com.baidu.ar.dw.this     // Catch: java.lang.Exception -> L38
                    com.baidu.ar.ds r6 = com.baidu.ar.dw.f(r6)     // Catch: java.lang.Exception -> L38
                    boolean r6 = r6.isClosed()     // Catch: java.lang.Exception -> L38
                    if (r6 == 0) goto L3a
                    com.baidu.ar.dw r6 = com.baidu.ar.dw.this     // Catch: java.lang.Exception -> L38
                    com.baidu.ar.ds r6 = com.baidu.ar.dw.f(r6)     // Catch: java.lang.Exception -> L38
                    r6.reconnect()     // Catch: java.lang.Exception -> L38
                    goto Lbc
                L38:
                    r6 = move-exception
                    goto L41
                L3a:
                    com.baidu.ar.dw r6 = com.baidu.ar.dw.this     // Catch: java.lang.Exception -> L38
                    com.baidu.ar.dw.g(r6)     // Catch: java.lang.Exception -> L38
                    goto Lbc
                L41:
                    r6.printStackTrace()
                    goto Lbc
                L46:
                    java.lang.Object r0 = r6.obj
                    boolean r0 = r0 instanceof byte[]
                    if (r0 == 0) goto Lbc
                    com.baidu.ar.dw r0 = com.baidu.ar.dw.this
                    com.baidu.ar.ds r0 = com.baidu.ar.dw.f(r0)
                    boolean r0 = r0.isOpen()
                    if (r0 == 0) goto L66
                    com.baidu.ar.dw r0 = com.baidu.ar.dw.this
                    com.baidu.ar.ds r0 = com.baidu.ar.dw.f(r0)
                    java.lang.Object r6 = r6.obj
                    byte[] r6 = (byte[]) r6
                    r0.t(r6)
                    goto Lbc
                L66:
                    com.baidu.ar.dw r6 = com.baidu.ar.dw.this
                    com.baidu.ar.du r6 = com.baidu.ar.dw.d(r6)
                    if (r6 == 0) goto Lbc
                L6e:
                    com.baidu.ar.dw r6 = com.baidu.ar.dw.this
                    com.baidu.ar.du r6 = com.baidu.ar.dw.d(r6)
                    r6.onError(r4, r3)
                    goto Lbc
                L78:
                    java.lang.Object r0 = r6.obj
                    boolean r0 = r0 instanceof java.lang.String
                    if (r0 == 0) goto Lbc
                    com.baidu.ar.dw r0 = com.baidu.ar.dw.this
                    com.baidu.ar.ds r0 = com.baidu.ar.dw.f(r0)
                    boolean r0 = r0.isOpen()
                    if (r0 == 0) goto L98
                    com.baidu.ar.dw r0 = com.baidu.ar.dw.this
                    com.baidu.ar.ds r0 = com.baidu.ar.dw.f(r0)
                    java.lang.Object r6 = r6.obj
                    java.lang.String r6 = (java.lang.String) r6
                    r0.cB(r6)
                    goto Lbc
                L98:
                    com.baidu.ar.dw r6 = com.baidu.ar.dw.this
                    com.baidu.ar.du r6 = com.baidu.ar.dw.d(r6)
                    if (r6 == 0) goto Lbc
                    goto L6e
                La1:
                    com.baidu.ar.dw r6 = com.baidu.ar.dw.this
                    com.baidu.ar.ds r6 = com.baidu.ar.dw.f(r6)
                    if (r6 == 0) goto Lbc
                    com.baidu.ar.dw r6 = com.baidu.ar.dw.this
                    com.baidu.ar.ds r6 = com.baidu.ar.dw.f(r6)
                    r6.close()
                    goto Lbc
                Lb3:
                    com.baidu.ar.dw r6 = com.baidu.ar.dw.this     // Catch: java.lang.Exception -> L38
                    com.baidu.ar.ds r6 = com.baidu.ar.dw.f(r6)     // Catch: java.lang.Exception -> L38
                    r6.connect()     // Catch: java.lang.Exception -> L38
                Lbc:
                    return r1
                */
                throw new UnsupportedOperationException("Method not decompiled: com.baidu.ar.dw.AnonymousClass3.handleMessage(android.os.Message):boolean");
            }
        });
    }

    @Override // com.baidu.ar.dt
    public void an(String str) {
        kf.c("WebSocket", "req: " + str);
        Message.obtain(this.mHandler, 3, str).sendToTarget();
    }

    @Override // com.baidu.ar.dt
    public void di() {
        Message.obtain(this.mHandler, 1).sendToTarget();
    }

    public void dm() {
        Message.obtain(this.mHandler, 2).sendToTarget();
    }

    @Override // com.baidu.ar.dt
    public void onPause() {
        this.mHandler.removeCallbacks(this.pS);
    }

    @Override // com.baidu.ar.dt
    public void onResume() {
        dj();
    }

    @Override // com.baidu.ar.dt
    public void release() {
        dm();
        this.pv.quit();
        if (this.pR != null) {
            this.pR.release();
            this.pR = null;
        }
    }

    @Override // com.baidu.ar.dt
    public void b(du duVar) {
        this.pQ = duVar;
    }

    @Override // com.baidu.ar.dt
    public void g(byte[] bArr) {
        if (bArr != null) {
            kf.c("WebSocket", "req: byte " + bArr.length);
            Message.obtain(this.mHandler, 4, bArr).sendToTarget();
        }
    }
}
