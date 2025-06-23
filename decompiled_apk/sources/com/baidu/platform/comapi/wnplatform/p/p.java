package com.baidu.platform.comapi.wnplatform.p;

import android.media.MediaPlayer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class p implements MediaPlayer.OnCompletionListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ m f9965a;

    public p(m mVar) {
        this.f9965a = mVar;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        this.f9965a.c = false;
    }
}
