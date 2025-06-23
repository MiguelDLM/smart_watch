package com.sma.smartv3.util;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTrack;
import com.blankj.utilcode.util.FileIOUtils;
import com.blankj.utilcode.util.LogUtils;

/* loaded from: classes12.dex */
public final class xoxXI {

    /* renamed from: I0Io, reason: collision with root package name */
    @OXOo.oOoXoXO
    public static AudioTrack f24730I0Io;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static boolean f24732X0o0xo;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final xoxXI f24733oIX0oI = new xoxXI();

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f24731II0xO0 = "PcmPlayer";

    /* renamed from: oxoX, reason: collision with root package name */
    public static float f24734oxoX = 1.0f;

    public static /* synthetic */ void X0o0xo(xoxXI xoxxi, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 16000;
        }
        xoxxi.I0Io(str, i);
    }

    public static /* synthetic */ void XO(xoxXI xoxxi, byte[] bArr, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 16000;
        }
        xoxxi.oxoX(bArr, i);
    }

    public final void I0Io(@OXOo.OOXIXo String path, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(path, "path");
        LogUtils.d(f24731II0xO0 + " play -> " + path);
        byte[] readFile2BytesByChannel = FileIOUtils.readFile2BytesByChannel(path);
        kotlin.jvm.internal.IIX0o.oO(readFile2BytesByChannel, "readFile2BytesByChannel(...)");
        oxoX(readFile2BytesByChannel, i);
    }

    public final void II0XooXoX() {
        if (f24730I0Io != null) {
            xxIXOIIO();
            AudioTrack audioTrack = f24730I0Io;
            if (audioTrack != null) {
                audioTrack.release();
            }
            f24730I0Io = null;
        }
    }

    public final boolean II0xO0() {
        AudioTrack audioTrack = f24730I0Io;
        if (audioTrack != null && audioTrack != null && audioTrack.getPlayState() == 3) {
            return true;
        }
        return false;
    }

    public final void Oxx0IOOO() {
        if (f24732X0o0xo) {
            f24732X0o0xo = false;
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(f24731II0xO0 + " setVolume = " + f24734oxoX);
            AudioTrack audioTrack = f24730I0Io;
            if (audioTrack != null) {
                audioTrack.setVolume(f24734oxoX);
            }
        }
    }

    public final void oIX0oI(float f) {
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(f24731II0xO0 + " curSound = " + f24734oxoX);
        f24734oxoX = f;
    }

    public final void oxoX(@OXOo.OOXIXo byte[] data, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(data, "data");
        if (data.length < 1024) {
            return;
        }
        if (f24730I0Io == null) {
            f24730I0Io = new AudioTrack(new AudioAttributes.Builder().setUsage(1).setContentType(2).build(), new AudioFormat.Builder().setSampleRate(i).setEncoding(2).setChannelMask(4).build(), data.length, 0, 0);
        }
        AudioTrack audioTrack = f24730I0Io;
        if (audioTrack != null && audioTrack.getState() == 0) {
            LogUtils.e(f24731II0xO0 + " AudioTrack 初始化失败");
            II0XooXoX();
            return;
        }
        xxIXOIIO();
        AudioTrack audioTrack2 = f24730I0Io;
        if (audioTrack2 != null) {
            audioTrack2.write(data, 0, data.length);
        }
        AudioTrack audioTrack3 = f24730I0Io;
        if (audioTrack3 != null) {
            audioTrack3.play();
        }
    }

    public final void xoIox() {
        f24732X0o0xo = true;
        AudioTrack audioTrack = f24730I0Io;
        if (audioTrack != null) {
            audioTrack.setVolume(0.0f);
        }
    }

    public final void xxIXOIIO() {
        AudioTrack audioTrack;
        if (II0xO0() && (audioTrack = f24730I0Io) != null) {
            audioTrack.stop();
        }
    }
}
