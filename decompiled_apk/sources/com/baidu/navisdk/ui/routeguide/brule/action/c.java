package com.baidu.navisdk.ui.routeguide.brule.action;

import com.baidu.navisdk.comapi.tts.TTSPlayerControl;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.routeguide.control.s;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.g0;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.i0;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.common.o0;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.worker.f;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes8.dex */
public class c implements com.baidu.navisdk.behavrules.action.b<com.baidu.navisdk.asr.sceneguide.a> {

    /* renamed from: a, reason: collision with root package name */
    private String f8511a;
    private boolean b = false;

    /* loaded from: classes8.dex */
    public class a extends com.baidu.navisdk.asr.i.a {
        final /* synthetic */ com.baidu.navisdk.asr.sceneguide.a b;

        public a(com.baidu.navisdk.asr.sceneguide.a aVar) {
            this.b = aVar;
        }

        @Override // com.baidu.navisdk.asr.i.a
        public void a(String str, boolean z) {
            super.a(str, z);
            if (z) {
                com.baidu.navisdk.module.asr.instructions.a.a().a(this.b.b);
                com.baidu.navisdk.asr.d.B().a("小度语音唤醒已打开");
                TipTool.toast("小度语音唤醒已打开");
                return;
            }
            com.baidu.navisdk.asr.d.B().c();
        }

        @Override // com.baidu.navisdk.asr.i.a
        public void b() {
            if (c.this.b) {
                s.T().e(133);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends g0.f {
        public b() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.f, com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.e
        public void b() {
            c.this.b = false;
            c.this.d();
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.f, com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.e
        public void c() {
            c.this.b = false;
            c.this.d();
        }
    }

    /* renamed from: com.baidu.navisdk.ui.routeguide.brule.action.c$c, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0433c implements i0.f {
        public C0433c() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.i0.f
        public void a() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.i0.f
        public void b() {
            com.baidu.navisdk.util.statistic.userop.b.r().d("3.c.p.3", "2");
            com.baidu.navisdk.asr.d.B().c();
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.i0.f
        public void c() {
            com.baidu.navisdk.util.statistic.userop.b.r().d("3.c.p.3", "1");
            c.this.b();
        }
    }

    /* loaded from: classes8.dex */
    public class d extends f<String, String> {
        public d(c cVar, String str, String str2) {
            super(str, str2);
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            com.baidu.navisdk.asr.d.B().c();
            return null;
        }
    }

    /* loaded from: classes8.dex */
    public class e implements o0.b {
        public e() {
        }

        @Override // com.baidu.navisdk.util.common.o0.b
        public void a(int i, boolean z, ArrayList<String> arrayList) {
            if (i == 2 && z) {
                c.this.c();
            }
        }
    }

    private i0 b(com.baidu.navisdk.asr.sceneguide.a aVar) {
        return x.b().k(133).D(100).v(10000).C(JarUtils.getResources().getDimensionPixelSize(R.dimen.navi_dimens_92dp)).d(JarUtils.getResources().getDrawable(R.drawable.bnav_xd_wakeup_notification_icon)).C(JarUtils.getResources().getDimensionPixelSize(R.dimen.navi_dimens_45dp)).a("小度语音无法唤醒，需要打开吗?").A(JarUtils.getResources().getDimensionPixelSize(R.dimen.navi_dimens_18dp)).b("打开唤醒后，可说【小度小度】进行对话").F(JarUtils.getResources().getDimensionPixelSize(R.dimen.navi_dimens_14dp)).z(2).g("授权并打开").f("取消").a(new C0433c()).a(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        com.baidu.navisdk.module.asr.instructions.a.a().a(this.f8511a);
        TTSPlayerControl.playXDTTSText("小度语音唤醒已打开", 1);
        TipTool.toast("小度语音唤醒已打开");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        com.baidu.navisdk.util.worker.c.a().a((f) new d(this, "BNBRuleXDWakeUpActionProcessoruiFinish", null), new com.baidu.navisdk.util.worker.e(2, 0));
    }

    @Override // com.baidu.navisdk.behavrules.action.b
    public /* bridge */ /* synthetic */ boolean a(com.baidu.navisdk.asr.sceneguide.a aVar, List list) {
        return a2(aVar, (List<com.baidu.navisdk.behavrules.data.c>) list);
    }

    @Override // com.baidu.navisdk.behavrules.action.b
    public List<String> a() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("xd_wakeup_confirm");
        return arrayList;
    }

    @Override // com.baidu.navisdk.behavrules.action.b
    public void a(com.baidu.navisdk.asr.sceneguide.a aVar) {
        g gVar = g.ASR;
        if (gVar.d()) {
            gVar.e("BNBRuleXDWakeUpActionProcessor", "handleActin(), data = " + aVar);
        }
        this.f8511a = aVar.b;
        i0 b2 = b(aVar);
        com.baidu.navisdk.util.statistic.userop.b.r().d("3.c.p.3", "0");
        b2.y();
        this.b = true;
        if (com.baidu.navisdk.asr.f.b() && !com.baidu.navisdk.asr.f.c()) {
            b2.e0();
            com.baidu.navisdk.asr.d.B().a(aVar.d, "xd_wakeup_confirm", new a(aVar));
        } else {
            TTSPlayerControl.playXDTTSText(aVar.d, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        com.baidu.navisdk.asr.d.B().c();
        if (com.baidu.navisdk.asr.f.b()) {
            c();
        } else {
            o0.b().a(2, new e());
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.navisdk.behavrules.action.b
    public com.baidu.navisdk.asr.sceneguide.a a(com.baidu.navisdk.behavrules.scene.c cVar) {
        return com.baidu.navisdk.asr.sceneguide.a.a(cVar.i().b(), cVar.i().a(), cVar.m(), cVar.h());
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    public boolean a2(com.baidu.navisdk.asr.sceneguide.a aVar, List<com.baidu.navisdk.behavrules.data.c> list) {
        if (aVar == null) {
            return false;
        }
        return aVar.a(new com.baidu.navisdk.behavrules.data.a(list));
    }
}
