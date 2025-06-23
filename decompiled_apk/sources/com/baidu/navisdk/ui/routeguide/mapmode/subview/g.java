package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.os.Message;

/* loaded from: classes8.dex */
public abstract class g extends k {
    protected com.baidu.navisdk.util.worker.loop.a c;
    private boolean d = false;

    /* loaded from: classes8.dex */
    public class a extends com.baidu.navisdk.util.worker.loop.a {
        public a(String str) {
            super(str);
        }

        @Override // com.baidu.navisdk.util.worker.loop.a
        public void onMessage(Message message) {
            if (message.what == 1000) {
                com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
                if (gVar.d()) {
                    gVar.e("RGMMArriveRemindBaseCard - DestRemind", "receive MSG_TYPE_AUTO_HIDE_CARD");
                }
                g.this.d = false;
                g.this.n();
            }
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.k
    public void j() {
        p();
        com.baidu.navisdk.util.worker.loop.a aVar = this.c;
        if (aVar != null) {
            aVar.removeCallbacksAndMessages(null);
            this.c = null;
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.k
    public void k() {
        if (this.c == null) {
            this.c = new a("RGMMArriveRemindBaseCard");
        }
        if (q() && !this.d) {
            o();
        }
        com.baidu.navisdk.asr.d.B().a(m());
    }

    public int l() {
        return 20000;
    }

    public int m() {
        return 1;
    }

    public void n() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMMArriveRemindBaseCard - DestRemind", "onAutoHideCard!");
        }
        com.baidu.navisdk.ui.routeguide.control.i.g().b(this.f8808a);
    }

    public void o() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMMArriveRemindBaseCard - DestRemind", "startCounting!");
        }
        com.baidu.navisdk.util.worker.loop.a aVar = this.c;
        if (aVar != null) {
            aVar.removeMessages(1000);
            this.c.sendEmptyMessageDelayed(1000, l());
            this.d = true;
        }
    }

    public void p() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMMArriveRemindBaseCard - DestRemind", "stopAutoHideTimer!");
        }
        com.baidu.navisdk.util.worker.loop.a aVar = this.c;
        if (aVar != null) {
            aVar.removeMessages(1000);
            this.d = false;
        }
    }

    public abstract boolean q();
}
