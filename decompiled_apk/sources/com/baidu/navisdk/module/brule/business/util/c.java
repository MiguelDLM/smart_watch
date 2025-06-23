package com.baidu.navisdk.module.brule.business.util;

import android.os.Bundle;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.tts.TTSPlayerControl;
import com.baidu.navisdk.util.common.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes7.dex */
public class c {
    private static c d;

    /* renamed from: a, reason: collision with root package name */
    private List<com.baidu.navisdk.module.brule.condition.b> f7048a = new ArrayList();
    private List<com.baidu.navisdk.module.brule.condition.b> b = new ArrayList();
    private TTSPlayerControl.e c;

    /* loaded from: classes7.dex */
    public class a extends TTSPlayerControl.f {
        public a() {
        }

        @Override // com.baidu.navisdk.comapi.tts.TTSPlayerControl.e
        public void a(String str) {
            g.ASR.e("behavRulesBNAsrProrityStratgy", "onPlayStart()");
        }

        @Override // com.baidu.navisdk.comapi.tts.TTSPlayerControl.e
        public void onPlayEnd(String str) {
            int tTSState = TTSPlayerControl.getTTSState();
            g gVar = g.ASR;
            if (gVar.d()) {
                gVar.e("behavRulesBNAsrProrityStratgy", "onPlayEnd() TTSState = " + tTSState);
            }
            if (tTSState != 1) {
                return;
            }
            int b = c.b();
            ArrayList<com.baidu.navisdk.module.brule.condition.b> arrayList = new ArrayList(c.this.f7048a);
            c.this.f7048a.clear();
            for (com.baidu.navisdk.module.brule.condition.b bVar : arrayList) {
                if (bVar != null) {
                    bVar.s();
                }
            }
            if (b >= 10) {
                ArrayList arrayList2 = new ArrayList(c.this.b);
                c.this.b.clear();
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    ((com.baidu.navisdk.module.brule.condition.b) it.next()).s();
                }
                return;
            }
            Iterator it2 = c.this.b.iterator();
            while (it2.hasNext()) {
                com.baidu.navisdk.module.brule.condition.b bVar2 = (com.baidu.navisdk.module.brule.condition.b) it2.next();
                if (bVar2 != null && bVar2.q()) {
                    bVar2.r();
                    it2.remove();
                }
            }
        }
    }

    public c() {
        a aVar = new a();
        this.c = aVar;
        TTSPlayerControl.addTTSPlayStateListener(aVar);
    }

    public void c(com.baidu.navisdk.module.brule.condition.b bVar) {
        this.f7048a.remove(bVar);
    }

    public void d(com.baidu.navisdk.module.brule.condition.b bVar) {
        this.b.remove(bVar);
    }

    public static c a() {
        if (d == null) {
            d = new c();
        }
        return d;
    }

    public static int b() {
        Bundle bundle = new Bundle();
        BNRouteGuider.getInstance().getRouteInfoInUniform(25, bundle);
        int i = bundle.getInt("unTime");
        g gVar = g.ASR;
        if (gVar.d()) {
            gVar.e("behavRulesBNAsrProrityStratgy", "getNextActionTime(), time = " + i);
        }
        return i;
    }

    public boolean a(com.baidu.navisdk.module.brule.condition.b bVar) {
        if (bVar == null || this.b.contains(bVar)) {
            return false;
        }
        return this.b.add(bVar);
    }

    public void b(com.baidu.navisdk.module.brule.condition.b bVar) {
        if (bVar == null || this.f7048a.contains(bVar)) {
            return;
        }
        this.f7048a.add(bVar);
    }
}
