package com.google.android.exoplayer2;

import android.os.SystemClock;
import com.google.android.exoplayer2.SimpleBasePlayer;

/* loaded from: classes9.dex */
public final /* synthetic */ class oxIO0IIo {
    static {
        SimpleBasePlayer.PositionSupplier positionSupplier = SimpleBasePlayer.PositionSupplier.ZERO;
    }

    public static SimpleBasePlayer.PositionSupplier II0xO0(final long j, final float f) {
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        return new SimpleBasePlayer.PositionSupplier() { // from class: com.google.android.exoplayer2.Ix0
            @Override // com.google.android.exoplayer2.SimpleBasePlayer.PositionSupplier
            public final long get() {
                return oxIO0IIo.oxoX(j, elapsedRealtime, f);
            }
        };
    }

    public static SimpleBasePlayer.PositionSupplier oIX0oI(final long j) {
        return new SimpleBasePlayer.PositionSupplier() { // from class: com.google.android.exoplayer2.xIxooxXX
            @Override // com.google.android.exoplayer2.SimpleBasePlayer.PositionSupplier
            public final long get() {
                return oxIO0IIo.I0Io(j);
            }
        };
    }

    public static /* synthetic */ long oxoX(long j, long j2, float f) {
        return j + (((float) (SystemClock.elapsedRealtime() - j2)) * f);
    }

    public static /* synthetic */ long I0Io(long j) {
        return j;
    }
}
