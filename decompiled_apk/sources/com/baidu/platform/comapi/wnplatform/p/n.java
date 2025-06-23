package com.baidu.platform.comapi.wnplatform.p;

import android.media.MediaPlayer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class n implements MediaPlayer.OnCompletionListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ m f9963a;

    public n(m mVar) {
        this.f9963a = mVar;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        com.baidu.platform.comapi.wnplatform.tts.d.a().a(false);
    }
}
