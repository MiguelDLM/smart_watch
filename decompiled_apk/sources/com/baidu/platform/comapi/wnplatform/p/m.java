package com.baidu.platform.comapi.wnplatform.p;

import android.media.MediaPlayer;
import android.text.TextUtils;

/* loaded from: classes8.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    private static m f9962a;
    private MediaPlayer b = null;
    private boolean c = false;

    private m() {
    }

    private void c() {
        if (this.b == null) {
            this.b = new MediaPlayer();
        }
    }

    private void d() {
        MediaPlayer mediaPlayer = this.b;
        if (mediaPlayer != null) {
            mediaPlayer.release();
            this.b = null;
        }
    }

    public boolean b() {
        return this.c;
    }

    public static synchronized m a() {
        m mVar;
        synchronized (m.class) {
            try {
                if (f9962a == null) {
                    f9962a = new m();
                }
                mVar = f9962a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return mVar;
    }

    public void b(String str) {
        com.baidu.platform.comapi.wnplatform.d.a.a("yang12", "WN player playStart-->" + str);
        d();
        c();
        try {
            this.c = true;
            if (com.baidu.platform.comapi.walknavi.b.a().g() != null) {
                this.b.setDataSource(str);
                this.b.prepare();
                this.b.start();
                this.b.setOnCompletionListener(new o(this));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void c(String str) {
        com.baidu.platform.comapi.wnplatform.d.a.a("yang12", "WN player playEnd-->" + str);
        d();
        c();
        try {
            this.c = true;
            if (com.baidu.platform.comapi.walknavi.b.a().g() != null) {
                this.b.setDataSource(str);
                this.b.prepare();
                this.b.start();
                this.b.setOnCompletionListener(new p(this));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean a(String str) {
        com.baidu.platform.comapi.wnplatform.d.a.b("WN player play-->" + str);
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        d();
        c();
        try {
            com.baidu.platform.comapi.wnplatform.tts.d.a().a(true);
            if (com.baidu.platform.comapi.walknavi.b.a().g() == null) {
                return false;
            }
            this.b.setDataSource(str);
            this.b.prepare();
            this.b.start();
            this.b.setOnCompletionListener(new n(this));
            return true;
        } catch (Exception unused) {
            com.baidu.platform.comapi.wnplatform.tts.d.a().a(false);
            return false;
        }
    }
}
