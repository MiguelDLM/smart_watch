package com.baidu.navisdk.ui.routeguide.widget;

import android.app.Activity;
import android.app.Dialog;
import android.media.AudioManager;
import android.view.KeyEvent;
import android.view.Window;
import com.google.android.exoplayer2.util.MimeTypes;

/* loaded from: classes8.dex */
public abstract class f extends Dialog {

    /* renamed from: a, reason: collision with root package name */
    Activity f9177a;

    public f(Activity activity, int i) {
        super(activity, i);
        this.f9177a = activity;
        Window window = getWindow();
        if (window != null) {
            window.addFlags(8);
        }
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.f9177a == null) {
            return false;
        }
        com.baidu.navisdk.module.vmsr.c.f().onKeyDown(i, keyEvent);
        AudioManager audioManager = (AudioManager) this.f9177a.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        int streamVolume = audioManager.getStreamVolume(3);
        int streamMaxVolume = audioManager.getStreamMaxVolume(3);
        if (i != 4) {
            if (i != 24) {
                if (i != 25) {
                    return false;
                }
                if (com.baidu.navisdk.ui.routeguide.mapmode.a.o5().u0() != null) {
                    streamVolume = com.baidu.navisdk.ui.routeguide.mapmode.a.o5().u0().a(audioManager, streamMaxVolume);
                }
                com.baidu.navisdk.util.statistic.userop.b.r().c("3.kb");
                if (streamVolume == 0) {
                    com.baidu.navisdk.ui.routeguide.mapmode.a.o5().U(true);
                }
                return true;
            }
            if (com.baidu.navisdk.ui.routeguide.mapmode.a.o5().u0() != null) {
                streamVolume = com.baidu.navisdk.ui.routeguide.mapmode.a.o5().u0().b(audioManager, streamMaxVolume);
            }
            com.baidu.navisdk.util.statistic.userop.b.r().c("3.ka");
            if (streamVolume > 0) {
                com.baidu.navisdk.ui.routeguide.mapmode.a.o5().U(false);
            }
            return true;
        }
        super.onKeyDown(i, keyEvent);
        return true;
    }
}
