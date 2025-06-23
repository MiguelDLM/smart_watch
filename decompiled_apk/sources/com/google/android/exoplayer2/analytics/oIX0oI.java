package com.google.android.exoplayer2.analytics;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.DeviceInfo;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.MediaMetadata;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Tracks;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.text.CueGroup;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters;
import com.google.android.exoplayer2.video.VideoSize;
import java.io.IOException;
import java.util.List;

/* loaded from: classes9.dex */
public final /* synthetic */ class oIX0oI {
    @Deprecated
    public static void O0Xx(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime) {
    }

    public static void O0xOxO(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime) {
    }

    public static void OxI(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime) {
    }

    public static void X0IIOO(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime) {
    }

    @Deprecated
    public static void XI0IXoo(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime) {
    }

    @Deprecated
    public static void XoI0Ixx0(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime) {
    }

    public static void XxX0x0xxx(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime) {
    }

    public static void oxxXoxO(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime) {
    }

    public static void I0(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, VideoSize videoSize) {
    }

    public static void I0X0x0oIo(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, int i) {
    }

    public static void I0oOIX(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, boolean z) {
    }

    public static void I0oOoX(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, @Nullable PlaybackException playbackException) {
    }

    @Deprecated
    public static void II0XooXoX(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, Format format) {
    }

    public static void II0xO0(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, Exception exc) {
    }

    public static void IIX0o(AnalyticsListener analyticsListener, Player player, AnalyticsListener.Events events) {
    }

    public static void IIXOooo(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, DeviceInfo deviceInfo) {
    }

    public static void Io(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, int i) {
    }

    public static void IoOoo(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, int i) {
    }

    public static void O00XxXI(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
    }

    public static void OI0(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, PlaybackParameters playbackParameters) {
    }

    public static void OO0x0xX(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, MediaLoadData mediaLoadData) {
    }

    public static void OOXIXo(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, int i) {
    }

    @Deprecated
    public static void Oo(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, List list) {
    }

    public static void Oxx0IOOO(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
    }

    public static void X00IoxXI(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, long j) {
    }

    public static void X0o0xo(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, String str) {
    }

    @Deprecated
    public static void XI0oooXX(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, Format format) {
    }

    public static void XIo0oOXIx(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, Exception exc) {
    }

    public static void XIxXXX0x0(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, int i) {
    }

    public static void XO(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
    }

    public static void XX(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, PlaybackException playbackException) {
    }

    public static void XX0xXo(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, String str) {
    }

    public static void Xo0(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, long j) {
    }

    @Deprecated
    public static void Xx000oIo(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, boolean z) {
    }

    public static void o0(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, int i) {
    }

    public static void o00(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, MediaLoadData mediaLoadData) {
    }

    public static void o0xxxXXxX(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
    }

    public static void oIX0oI(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, AudioAttributes audioAttributes) {
    }

    public static void oOoXoXO(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, Exception exc) {
    }

    public static void oX(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, long j) {
    }

    public static void ooOx(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, float f) {
    }

    public static void ooXIXxIX(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, boolean z) {
    }

    public static void oxXx0IX(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, MediaMetadata mediaMetadata) {
    }

    public static void x0XOIxOo(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, Player.Commands commands) {
    }

    public static void x0o(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, Metadata metadata) {
    }

    public static void x0xO(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, Tracks tracks) {
    }

    public static void x0xO0oo(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, CueGroup cueGroup) {
    }

    public static void xI(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, boolean z) {
    }

    public static void xII(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, MediaMetadata mediaMetadata) {
    }

    @Deprecated
    public static void xo0x(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, int i) {
    }

    public static void xoIox(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, long j) {
    }

    public static void xoIxX(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, TrackSelectionParameters trackSelectionParameters) {
    }

    public static void xoxXI(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, boolean z) {
    }

    public static void xxX(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, Exception exc) {
    }

    @Deprecated
    public static void I0Io(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, String str, long j) {
    }

    public static void IO(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, @Nullable MediaItem mediaItem, int i) {
    }

    @Deprecated
    public static void IXxxXO(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, int i, DecoderCounters decoderCounters) {
    }

    @Deprecated
    public static void Ioxxx(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, String str, long j) {
    }

    public static void OO(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, int i, int i2) {
    }

    public static void OOXIxO0(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, Format format, @Nullable DecoderReuseEvaluation decoderReuseEvaluation) {
    }

    @Deprecated
    public static void Oxx0xo(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, int i, DecoderCounters decoderCounters) {
    }

    @Deprecated
    public static void OxxIIOOXO(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, int i, Format format) {
    }

    public static void XOxIOxOx(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, boolean z, int i) {
    }

    public static void XX0(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, Object obj, long j) {
    }

    @Deprecated
    public static void XoX(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, boolean z, int i) {
    }

    public static void oOXoIIIo(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
    }

    public static void oo(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
    }

    public static void oo0xXOI0I(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
    }

    public static void ox(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, long j, int i) {
    }

    public static void xXxxox0I(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, int i, long j) {
    }

    public static void xoXoI(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, int i, boolean z) {
    }

    public static void xxIXOIIO(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, Format format, @Nullable DecoderReuseEvaluation decoderReuseEvaluation) {
    }

    @Deprecated
    public static void IIxOXoOo0(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, int i, int i2, int i3, float f) {
    }

    public static void IoOoX(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z) {
    }

    @Deprecated
    public static void oI0IIXIo(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, int i, String str, long j) {
    }

    public static void oO(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, int i, long j, long j2) {
    }

    public static void ooOOo0oXI(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, int i, long j, long j2) {
    }

    public static void oxoX(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, String str, long j, long j2) {
    }

    public static void xXOx(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i) {
    }

    public static void xxIO(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, String str, long j, long j2) {
    }
}
