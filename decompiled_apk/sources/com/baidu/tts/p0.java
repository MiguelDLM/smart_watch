package com.baidu.tts;

import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.facebook.login.widget.ToolTipPopup;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes8.dex */
public class p0 extends j0 {
    public ThreadPoolExecutor e;
    public s0 f;
    public r0 g;
    public m0 h;
    public q0 i;
    public n0 j;

    /* loaded from: classes8.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public x4 f10147a;

        public a(x4 x4Var) {
            this.f10147a = x4Var;
        }

        /* JADX WARN: Removed duplicated region for block: B:45:0x00c9 A[Catch: all -> 0x001f, TryCatch #4 {all -> 0x001f, blocks: (B:5:0x0015, B:7:0x001b, B:8:0x0022, B:10:0x0026, B:12:0x0032, B:13:0x0035, B:14:0x003b, B:16:0x003f, B:17:0x0049, B:19:0x004d, B:21:0x0050, B:23:0x0058, B:25:0x0065, B:28:0x006f, B:31:0x007b, B:32:0x0086, B:34:0x008a, B:36:0x008e, B:39:0x0096, B:42:0x00a5, B:43:0x00bc, B:45:0x00c9, B:47:0x00ed, B:49:0x00fb, B:51:0x0102, B:52:0x0113, B:54:0x0121, B:55:0x0123, B:64:0x016c, B:67:0x0172, B:68:0x0177, B:77:0x0184, B:78:0x0198, B:83:0x00e3, B:86:0x00b9, B:92:0x019a, B:107:0x01a7, B:94:0x01a9, B:96:0x01af, B:98:0x01be, B:99:0x01c0, B:101:0x01ce, B:113:0x01d4, B:115:0x01d8, B:117:0x01ec, B:118:0x01ef, B:120:0x01f8, B:121:0x0203, B:123:0x01fc, B:58:0x0127, B:60:0x012e, B:62:0x014d, B:71:0x0169), top: B:3:0x0013, inners: #0 }] */
        /* JADX WARN: Removed duplicated region for block: B:49:0x00fb A[Catch: all -> 0x001f, TryCatch #4 {all -> 0x001f, blocks: (B:5:0x0015, B:7:0x001b, B:8:0x0022, B:10:0x0026, B:12:0x0032, B:13:0x0035, B:14:0x003b, B:16:0x003f, B:17:0x0049, B:19:0x004d, B:21:0x0050, B:23:0x0058, B:25:0x0065, B:28:0x006f, B:31:0x007b, B:32:0x0086, B:34:0x008a, B:36:0x008e, B:39:0x0096, B:42:0x00a5, B:43:0x00bc, B:45:0x00c9, B:47:0x00ed, B:49:0x00fb, B:51:0x0102, B:52:0x0113, B:54:0x0121, B:55:0x0123, B:64:0x016c, B:67:0x0172, B:68:0x0177, B:77:0x0184, B:78:0x0198, B:83:0x00e3, B:86:0x00b9, B:92:0x019a, B:107:0x01a7, B:94:0x01a9, B:96:0x01af, B:98:0x01be, B:99:0x01c0, B:101:0x01ce, B:113:0x01d4, B:115:0x01d8, B:117:0x01ec, B:118:0x01ef, B:120:0x01f8, B:121:0x0203, B:123:0x01fc, B:58:0x0127, B:60:0x012e, B:62:0x014d, B:71:0x0169), top: B:3:0x0013, inners: #0 }] */
        /* JADX WARN: Removed duplicated region for block: B:54:0x0121 A[Catch: all -> 0x001f, TryCatch #4 {all -> 0x001f, blocks: (B:5:0x0015, B:7:0x001b, B:8:0x0022, B:10:0x0026, B:12:0x0032, B:13:0x0035, B:14:0x003b, B:16:0x003f, B:17:0x0049, B:19:0x004d, B:21:0x0050, B:23:0x0058, B:25:0x0065, B:28:0x006f, B:31:0x007b, B:32:0x0086, B:34:0x008a, B:36:0x008e, B:39:0x0096, B:42:0x00a5, B:43:0x00bc, B:45:0x00c9, B:47:0x00ed, B:49:0x00fb, B:51:0x0102, B:52:0x0113, B:54:0x0121, B:55:0x0123, B:64:0x016c, B:67:0x0172, B:68:0x0177, B:77:0x0184, B:78:0x0198, B:83:0x00e3, B:86:0x00b9, B:92:0x019a, B:107:0x01a7, B:94:0x01a9, B:96:0x01af, B:98:0x01be, B:99:0x01c0, B:101:0x01ce, B:113:0x01d4, B:115:0x01d8, B:117:0x01ec, B:118:0x01ef, B:120:0x01f8, B:121:0x0203, B:123:0x01fc, B:58:0x0127, B:60:0x012e, B:62:0x014d, B:71:0x0169), top: B:3:0x0013, inners: #0 }] */
        /* JADX WARN: Removed duplicated region for block: B:75:0x0182 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:81:0x00da  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                Method dump skipped, instructions count: 519
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.tts.p0.a.run():void");
        }
    }

    public p0() {
        r0 r0Var = new r0(this);
        this.g = r0Var;
        this.h = new m0(this);
        this.i = new q0(this);
        this.j = new n0(this);
        this.d = r0Var;
        this.f = i0.b().a();
    }

    @Override // com.baidu.tts.h3
    public boolean c() {
        if (this.d == this.j) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.tts.h3
    public boolean d() {
        if (!Thread.currentThread().isInterrupted() && this.d != this.h) {
            return false;
        }
        return true;
    }

    public void k() {
        t0 t0Var = (t0) this.f;
        t0Var.a();
        try {
            t0Var.j = 0L;
            if (t0Var.b != null) {
                t0Var.b.release();
            }
            t0Var.b = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void l() {
        this.f.a();
        ThreadPoolExecutor threadPoolExecutor = this.e;
        if (threadPoolExecutor != null) {
            if (!threadPoolExecutor.isShutdown()) {
                this.e.shutdownNow();
            }
            try {
                LoggerProxy.d("PlayQueueMachine", "before await");
                LoggerProxy.d("PlayQueueMachine", "after await isTer=" + this.e.awaitTermination(ToolTipPopup.DEFAULT_POPUP_DISPLAY_TIME, TimeUnit.MILLISECONDS));
            } catch (InterruptedException unused) {
                LoggerProxy.d("PlayQueueMachine", "InterruptedException");
            }
            this.e = null;
        }
        this.f.a();
    }
}
