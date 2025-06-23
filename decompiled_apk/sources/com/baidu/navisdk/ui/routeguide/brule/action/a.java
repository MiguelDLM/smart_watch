package com.baidu.navisdk.ui.routeguide.brule.action;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.text.TextUtils;
import com.baidu.navisdk.asr.f;
import com.baidu.navisdk.comapi.tts.TTSPlayerControl;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.jar.JarUtils;
import java.util.List;
import kotlin.collections.oI0IIXIo;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.text.OxI;
import kotlin.text.StringsKt__StringsKt;

/* loaded from: classes8.dex */
public final class a implements com.baidu.navisdk.behavrules.action.b<com.baidu.navisdk.asr.sceneguide.a> {

    /* renamed from: com.baidu.navisdk.ui.routeguide.brule.action.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C0430a {
        private C0430a() {
        }

        public /* synthetic */ C0430a(IIXOooo iIXOooo) {
            this();
        }
    }

    /* loaded from: classes8.dex */
    public static final class b extends TTSPlayerControl.f {

        /* renamed from: a, reason: collision with root package name */
        private boolean f8508a;
        private int b;

        /* renamed from: com.baidu.navisdk.ui.routeguide.brule.action.a$b$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class RunnableC0431a implements Runnable {
            final /* synthetic */ String b;

            public RunnableC0431a(String str) {
                this.b = str;
            }

            @Override // java.lang.Runnable
            public final void run() {
                g.ASR.e("behavRulesBNBRuleTTSAction", "onPlayEnd() isDisableByTTS = " + b.this.f8508a + " speechid =" + this.b);
                if (b.this.f8508a) {
                    b.this.f8508a = false;
                    a.this.c();
                    com.baidu.navisdk.ui.routeguide.asr.c.n().b(4, true);
                }
            }
        }

        /* renamed from: com.baidu.navisdk.ui.routeguide.brule.action.a$b$b, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class RunnableC0432b implements Runnable {
            final /* synthetic */ String b;

            public RunnableC0432b(String str) {
                this.b = str;
            }

            @Override // java.lang.Runnable
            public final void run() {
                g gVar = g.ASR;
                if (gVar.d()) {
                    gVar.e("behavRulesBNBRuleTTSAction", "onPlayStart() speechId = " + this.b);
                }
                String str = this.b;
                Boolean bool = null;
                if (str != null) {
                    bool = Boolean.valueOf(OxI.IOOoXo0Ix(str, "ASRDisable-", false, 2, null));
                }
                if (bool.booleanValue()) {
                    b.this.f8508a = true;
                    com.baidu.navisdk.ui.routeguide.asr.c.n().b(4, false);
                }
            }
        }

        public b() {
        }

        @Override // com.baidu.navisdk.comapi.tts.TTSPlayerControl.e
        public void onPlayEnd(@OOXIXo String speechId) {
            IIX0o.x0xO0oo(speechId, "speechId");
            if (this.b > 2) {
                a.this.c();
            }
            f.a(new RunnableC0431a(speechId));
        }

        @Override // com.baidu.navisdk.comapi.tts.TTSPlayerControl.e
        public void a(@OOXIXo String speechId) {
            IIX0o.x0xO0oo(speechId, "speechId");
            this.b++;
            f.a(new RunnableC0432b(speechId));
        }
    }

    static {
        new C0430a(null);
    }

    public a() {
        new b();
    }

    private final void b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c() {
    }

    @Override // com.baidu.navisdk.behavrules.action.b
    public /* bridge */ /* synthetic */ boolean a(com.baidu.navisdk.asr.sceneguide.a aVar, List list) {
        return a2(aVar, (List<com.baidu.navisdk.behavrules.data.c>) list);
    }

    @Override // com.baidu.navisdk.behavrules.action.b
    @OOXIXo
    public List<String> a() {
        return oI0IIXIo.OOXIXo("play_tts");
    }

    @Override // com.baidu.navisdk.behavrules.action.b
    public void a(@oOoXoXO com.baidu.navisdk.asr.sceneguide.a aVar) {
        com.baidu.navisdk.asr.model.b bVar;
        String str = null;
        com.baidu.navisdk.asr.model.a a2 = aVar != null ? aVar.a() : null;
        if (a2 != null && (bVar = a2.C0) != null) {
            str = bVar.f6555a;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        boolean a3 = a(str);
        b();
        TTSPlayerControl.playXDTTSTextForResult(str, 1, a3 ? "ASRDisable-" : "");
    }

    private final boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        IIX0o.ooOOo0oXI(str);
        String string = JarUtils.getResources().getString(R.string.nav_voice_disable_keyword);
        IIX0o.oO(string, "JarUtils.getResources().…av_voice_disable_keyword)");
        return StringsKt__StringsKt.o00xOoIO(str, string, false, 2, null);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.navisdk.behavrules.action.b
    @OOXIXo
    public com.baidu.navisdk.asr.sceneguide.a a(@OOXIXo com.baidu.navisdk.behavrules.scene.c scene) {
        IIX0o.x0xO0oo(scene, "scene");
        com.baidu.navisdk.behavrules.action.a i = scene.i();
        IIX0o.oO(i, "scene.actionData");
        String b2 = i.b();
        com.baidu.navisdk.behavrules.action.a i2 = scene.i();
        IIX0o.oO(i2, "scene.actionData");
        com.baidu.navisdk.asr.sceneguide.a a2 = com.baidu.navisdk.asr.sceneguide.a.a(b2, i2.a(), scene.m(), scene.h());
        IIX0o.oO(a2, "BNAsrSceneXDActinoData.p…, scene.recInfo\n        )");
        return a2;
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    public boolean a2(@oOoXoXO com.baidu.navisdk.asr.sceneguide.a aVar, @oOoXoXO List<com.baidu.navisdk.behavrules.data.c> list) {
        if (aVar != null) {
            try {
                return aVar.a(new com.baidu.navisdk.behavrules.data.a(list));
            } catch (com.baidu.navisdk.behavrules.data.b e) {
                g gVar = g.BRULE;
                if (gVar.d()) {
                    gVar.e("behavRulesBNAsrSceneAction", "parseData(), e = " + e);
                    e.printStackTrace();
                }
            }
        }
        return false;
    }
}
