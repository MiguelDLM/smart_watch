package com.baidu.navisdk.module.asr;

import com.baidu.navisdk.comapi.tts.TTSPlayerControl;

@Deprecated
/* loaded from: classes7.dex */
public class i {

    /* loaded from: classes7.dex */
    public class a extends com.baidu.navisdk.util.worker.f<String, String> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Runnable f7036a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, String str2, Runnable runnable) {
            super(str, str2);
            this.f7036a = runnable;
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            this.f7036a.run();
            return null;
        }
    }

    /* loaded from: classes7.dex */
    public class b extends com.baidu.navisdk.util.worker.f<String, String> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Runnable f7037a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, String str2, Runnable runnable) {
            super(str, str2);
            this.f7037a = runnable;
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            this.f7037a.run();
            return null;
        }
    }

    public static void a(String str) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.ASR;
        if (gVar.d()) {
            gVar.e("XDVoice", str);
        }
    }

    public static void b(String str) {
        TTSPlayerControl.playXDTTSText(str, 1);
    }

    public static void c(String str) {
        com.baidu.navisdk.asr.d.B().b();
        b(str);
    }

    public static void b(String str, Runnable runnable) {
        com.baidu.navisdk.util.worker.c.a().a((com.baidu.navisdk.util.worker.f) new b("XDVoice-" + str, null, runnable), new com.baidu.navisdk.util.worker.e(2, 0));
    }

    public static void a(String str, Runnable runnable) {
        com.baidu.navisdk.util.worker.c.a().c(new a("XDVoice-" + str, null, runnable), new com.baidu.navisdk.util.worker.e(2, 0));
    }
}
