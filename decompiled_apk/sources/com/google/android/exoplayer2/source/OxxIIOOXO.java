package com.google.android.exoplayer2.source;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.upstream.TransferListener;

/* loaded from: classes9.dex */
public final /* synthetic */ class OxxIIOOXO {
    @Deprecated
    public static void I0Io(MediaSource mediaSource, MediaSource.MediaSourceCaller mediaSourceCaller, @Nullable TransferListener transferListener) {
        mediaSource.prepareSource(mediaSourceCaller, transferListener, PlayerId.UNSET);
    }

    public static boolean II0xO0(MediaSource mediaSource) {
        return true;
    }

    @Nullable
    public static Timeline oIX0oI(MediaSource mediaSource) {
        return null;
    }
}
