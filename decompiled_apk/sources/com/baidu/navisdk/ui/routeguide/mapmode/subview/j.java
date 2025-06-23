package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.os.Message;

/* loaded from: classes8.dex */
public abstract class j extends k {
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
                    gVar.e("RGMMBaseAutoHideCardView", "onMessage: receive MSG_TYPE_AUTO_HIDE_CARD");
                }
                j.this.d = false;
                j.this.p();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMMBaseAutoHideCardView", "onAutoHideCard!");
        }
        com.baidu.navisdk.ui.routeguide.control.i.g().b(this.f8808a);
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.k
    public void j() {
        com.baidu.navisdk.util.worker.loop.a aVar = this.c;
        if (aVar != null) {
            aVar.removeCallbacksAndMessages(null);
            this.c = null;
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.k
    public void k() {
        if (this.c == null) {
            this.c = new a("RGMMBaseAutoHideCardView");
        }
        if (!this.d) {
            n();
        }
    }

    public int l() {
        return 10000;
    }

    public void m() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMMBaseAutoHideCardView", "restartAutoHide!");
        }
        n();
    }

    public void n() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMMBaseAutoHideCardView", "startAutoHide!");
        }
        com.baidu.navisdk.util.worker.loop.a aVar = this.c;
        if (aVar != null) {
            aVar.removeMessages(1000);
            this.d = true;
            this.c.sendEmptyMessageDelayed(1000, l());
        }
    }

    public void o() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMMBaseAutoHideCardView", "stopAutoHide!");
        }
        com.baidu.navisdk.util.worker.loop.a aVar = this.c;
        if (aVar != null) {
            aVar.removeMessages(1000);
            this.d = false;
        }
    }
}
