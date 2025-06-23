package com.baidu.tts;

import com.facebook.login.widget.ToolTipPopup;
import com.google.android.exoplayer2.ExoPlayer;

/* loaded from: classes8.dex */
public enum v2 {
    DEFAULT(6, ToolTipPopup.DEFAULT_POPUP_DISPLAY_TIME),
    TWO_SECOND(2, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS),
    THREE_SECOND(3, 3000),
    FOUR_SECOND(4, 4000),
    ONE_SECOND(1, 1200);


    /* renamed from: a, reason: collision with root package name */
    public final long f10181a;

    v2(long j, long j2) {
        this.f10181a = j2;
    }

    public int a() {
        return (int) this.f10181a;
    }
}
