package com.baidu.navisdk.ugc.video;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.navisdk.comapi.tts.TTSPlayerControl;
import com.baidu.navisdk.framework.interfaces.pronavi.i;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.common.m0;
import com.baidu.navisdk.util.common.s;

/* loaded from: classes8.dex */
public class c implements com.baidu.navisdk.ugc.video.a {
    private static boolean h = true;
    private static final String i = m0.j().b() + "/ugcVideo";

    /* renamed from: a, reason: collision with root package name */
    public String f8345a;
    public String b;
    public int c;
    private Bitmap d;
    private a e;
    private com.baidu.navisdk.ugc.listener.c f;
    private boolean g;

    /* loaded from: classes8.dex */
    public interface a {
        void a(Bitmap bitmap);

        void c();

        void d();
    }

    public c(boolean z) {
        this.g = z;
    }

    private void c() {
        g gVar = g.UGC;
        if (gVar.d()) {
            gVar.e("UgcModule_RecordVideo", "focusAudio isComeFromNavigating: " + this.g);
        }
        if (this.g) {
            TTSPlayerControl.stopVoiceTTSOutput();
            TTSPlayerControl.pauseVoiceTTSOutput();
        }
        com.baidu.navisdk.ugc.utils.e.f8333a.b(com.baidu.navisdk.framework.a.c().a());
    }

    public static boolean d() {
        return h;
    }

    private void e() {
        g gVar = g.UGC;
        if (gVar.d()) {
            gVar.e("UgcModule_RecordVideo", "releaseAudio isComeFromNavigating: " + this.g);
        }
        if (this.g) {
            TTSPlayerControl.resumeVoiceTTSOutput();
        }
        com.baidu.navisdk.ugc.utils.e.f8333a.a(com.baidu.navisdk.framework.a.c().a());
    }

    public boolean a(int i2) {
        return i2 == 4106;
    }

    public void b(int i2, Intent intent) {
        g gVar = g.UGC;
        if (gVar.d()) {
            gVar.e("UgcModule_RecordVideo", "playVideoActivityResult resultCode:" + i2);
        }
        e();
        if (i2 == 1000) {
            b();
            a aVar = this.e;
            if (aVar != null) {
                aVar.d();
            }
        }
        com.baidu.navisdk.ugc.listener.c cVar = this.f;
        if (cVar != null) {
            cVar.a(false);
        }
    }

    public void a(a aVar) {
        this.e = aVar;
    }

    public void a(com.baidu.navisdk.ugc.listener.c cVar) {
        this.f = cVar;
    }

    @Override // com.baidu.navisdk.ugc.video.a
    public void a(Activity activity, int i2) {
        if (activity == null) {
            g gVar = g.UGC;
            if (gVar.c()) {
                gVar.c("UgcModule_RecordVideo", "start recordVideo activity is null");
                return;
            }
            return;
        }
        g gVar2 = g.UGC;
        if (gVar2.e()) {
            gVar2.g("UgcModule_RecordVideo", "startRecordVideo requestCode:" + i2);
        }
        Bundle bundle = new Bundle();
        bundle.putInt("requestCode", i2);
        if (com.baidu.navisdk.module.page.a.b().a(8, bundle, activity)) {
            c();
            com.baidu.navisdk.ugc.listener.c cVar = this.f;
            if (cVar != null) {
                cVar.a(true);
            }
            if (this.g) {
                com.baidu.navisdk.framework.interfaces.pronavi.b h2 = com.baidu.navisdk.framework.interfaces.c.p().h();
                i C = h2 != null ? h2.C() : null;
                if (C != null) {
                    C.g(false);
                }
            }
        }
    }

    private void b() {
        Bitmap bitmap = this.d;
        if (bitmap != null && !bitmap.isRecycled()) {
            try {
                this.d.recycle();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (!TextUtils.isEmpty(this.b)) {
            try {
                s.a(this.b);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        if (TextUtils.isEmpty(this.f8345a)) {
            return;
        }
        try {
            s.a(this.f8345a);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.navisdk.ugc.video.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(int r9, android.content.Intent r10) {
        /*
            r8 = this;
            java.lang.String r0 = "preview.jpg"
            com.baidu.navisdk.util.common.g r1 = com.baidu.navisdk.util.common.g.UGC
            boolean r2 = r1.d()
            java.lang.String r3 = "UgcModule_RecordVideo"
            if (r2 == 0) goto L28
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "onVideoRecordActivityResult :"
            r2.append(r4)
            r2.append(r9)
            java.lang.String r4 = ", data:"
            r2.append(r4)
            r2.append(r10)
            java.lang.String r2 = r2.toString()
            r1.e(r3, r2)
        L28:
            r8.e()
            r2 = 1
            r4 = 0
            if (r9 != 0) goto Lc3
            java.lang.String r5 = "path"
            java.lang.String r5 = r10.getStringExtra(r5)
            r8.f8345a = r5
            java.lang.String r5 = "size"
            r10.getIntExtra(r5, r4)
            java.lang.String r5 = "time"
            int r10 = r10.getIntExtra(r5, r4)
            r8.c = r10
            java.lang.String r10 = r8.f8345a
            android.graphics.Bitmap r10 = android.media.ThumbnailUtils.createVideoThumbnail(r10, r2)
            r8.d = r10
            if (r10 == 0) goto Lbc
            java.lang.String r5 = com.baidu.navisdk.ugc.video.c.i     // Catch: java.io.IOException -> L70
            boolean r10 = com.baidu.navisdk.util.common.c0.a(r10, r5, r0)     // Catch: java.io.IOException -> L70
            boolean r6 = r1.d()     // Catch: java.io.IOException -> L70
            if (r6 == 0) goto L73
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.io.IOException -> L70
            r6.<init>()     // Catch: java.io.IOException -> L70
            java.lang.String r7 = "onVideoRecordActivityResult:"
            r6.append(r7)     // Catch: java.io.IOException -> L70
            r6.append(r10)     // Catch: java.io.IOException -> L70
            java.lang.String r6 = r6.toString()     // Catch: java.io.IOException -> L70
            r1.e(r3, r6)     // Catch: java.io.IOException -> L70
            goto L73
        L70:
            r10 = move-exception
            r2 = 0
            goto L98
        L73:
            if (r10 == 0) goto Lbc
            com.baidu.navisdk.ugc.video.c$a r10 = r8.e     // Catch: java.io.IOException -> L70
            if (r10 == 0) goto Lbc
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch: java.io.IOException -> L70
            r10.<init>()     // Catch: java.io.IOException -> L70
            r10.append(r5)     // Catch: java.io.IOException -> L70
            java.lang.String r1 = "/"
            r10.append(r1)     // Catch: java.io.IOException -> L70
            r10.append(r0)     // Catch: java.io.IOException -> L70
            java.lang.String r10 = r10.toString()     // Catch: java.io.IOException -> L70
            r8.b = r10     // Catch: java.io.IOException -> L70
            com.baidu.navisdk.ugc.video.c$a r10 = r8.e     // Catch: java.io.IOException -> L97
            android.graphics.Bitmap r0 = r8.d     // Catch: java.io.IOException -> L97
            r10.a(r0)     // Catch: java.io.IOException -> L97
            goto Lbd
        L97:
            r10 = move-exception
        L98:
            r10.printStackTrace()
            com.baidu.navisdk.util.common.g r0 = com.baidu.navisdk.util.common.g.UGC
            boolean r1 = r0.c()
            if (r1 == 0) goto Lbd
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r5 = "onVideoRecordActivityResult IOException:"
            r1.append(r5)
            java.lang.String r10 = r10.toString()
            r1.append(r10)
            java.lang.String r10 = r1.toString()
            r0.c(r3, r10)
            goto Lbd
        Lbc:
            r2 = 0
        Lbd:
            if (r2 != 0) goto Lcc
            r8.b()
            goto Lcc
        Lc3:
            if (r9 != r2) goto Lcc
            com.baidu.navisdk.ugc.video.c$a r10 = r8.e
            if (r10 == 0) goto Lcc
            r10.c()
        Lcc:
            com.baidu.navisdk.util.common.g r10 = com.baidu.navisdk.util.common.g.UGC
            boolean r0 = r10.d()
            if (r0 == 0) goto Le8
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "onVideoRecordActivityResult: "
            r0.append(r1)
            r0.append(r9)
            java.lang.String r9 = r0.toString()
            r10.e(r3, r9)
        Le8:
            com.baidu.navisdk.ugc.listener.c r9 = r8.f
            if (r9 == 0) goto Lef
            r9.a(r4)
        Lef:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.ugc.video.c.a(int, android.content.Intent):void");
    }

    public void a(Activity activity) {
        if (activity != null && !TextUtils.isEmpty(this.f8345a)) {
            g gVar = g.UGC;
            if (gVar.e()) {
                gVar.g("UgcModule_RecordVideo", "playLocalVideo videoPath:" + this.f8345a);
            }
            Bundle bundle = new Bundle();
            bundle.putString("path", this.f8345a);
            bundle.putBoolean("isPreview", true);
            bundle.putBoolean("enableDelete", true);
            bundle.putInt("requestCode", 4106);
            if (com.baidu.navisdk.module.page.a.b().a(9, bundle, activity)) {
                c();
                com.baidu.navisdk.ugc.listener.c cVar = this.f;
                if (cVar != null) {
                    cVar.a(true);
                    return;
                }
                return;
            }
            return;
        }
        g gVar2 = g.UGC;
        if (gVar2.c()) {
            gVar2.c("UgcModule_RecordVideo", "start playLocalVideo activity is null or video path is null");
        }
    }

    public void a() {
        e();
        this.e = null;
        this.f = null;
    }
}
