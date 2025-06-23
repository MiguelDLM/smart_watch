package com.baidu.tts;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTrack;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.tools.ConfigTool;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes8.dex */
public class t0 extends s0 {
    public volatile AudioTrack b;
    public a c;
    public g3 d = new g3();
    public final Lock e;
    public final Condition f;
    public boolean g;
    public int h;
    public u0 i;
    public long j;
    public int k;
    public int l;

    /* loaded from: classes8.dex */
    public static class a extends s4<a> {
        public int c = u2.HZ16K.a();
        public int d = 4;
        public int e = 2;
        public int f = 1;
        public float g = 1.0f;
        public float h = 1.0f;
        public int i = 1;
        public int j = 2;
    }

    public t0() {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.e = reentrantLock;
        this.f = reentrantLock.newCondition();
        this.g = false;
        this.j = 0L;
        this.k = 40;
        this.l = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0027 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int a(int r5, int r6, int r7) {
        /*
            r4 = this;
            int r5 = android.media.AudioTrack.getMinBufferSize(r5, r6, r7)
            r0 = 2
            int r5 = r5 * 2
            r1 = 12
            r2 = 3
            r3 = 1
            if (r6 == r1) goto L1d
            if (r6 == r3) goto L1b
            if (r6 == r0) goto L1b
            if (r6 == r2) goto L1d
            r1 = 4
            if (r6 == r1) goto L1b
            int r6 = java.lang.Integer.bitCount(r6)
            goto L1e
        L1b:
            r6 = 1
            goto L1e
        L1d:
            r6 = 2
        L1e:
            if (r7 != r2) goto L21
            r0 = 1
        L21:
            int r6 = r6 * r0
            int r6 = r5 % r6
            if (r6 != 0) goto L29
            if (r5 >= r3) goto L2b
        L29:
            r5 = 5120(0x1400, float:7.175E-42)
        L2b:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.tts.t0.a(int, int, int):int");
    }

    public final void b() {
        try {
            this.e.lock();
            this.f.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.e.unlock();
        }
    }

    @Override // com.baidu.tts.s0
    public int a(int i) {
        try {
            if (this.b == null) {
                return -2;
            }
            LoggerProxy.d("AudioTrackPlayer", "sampleRate:" + i + " mAudioTrack sampleRate:" + this.b.getSampleRate());
            if (i == this.b.getSampleRate()) {
                return 0;
            }
            this.l = i;
            a aVar = this.c;
            int i2 = aVar.f10167a;
            int i3 = aVar.d;
            int i4 = aVar.e;
            int i5 = aVar.f;
            int i6 = aVar.i;
            int i7 = aVar.j;
            int a2 = a(i, i3, i4);
            if (this.b.getState() == 1) {
                this.b.release();
            }
            int i8 = ConfigTool.sPlayStreamType;
            if (i8 != 2 && i8 == 1) {
                this.b = new AudioTrack(i2, i, i3, i4, a2, i5);
                a aVar2 = this.c;
                this.b.setStereoVolume(aVar2.g, aVar2.h);
                this.b.play();
                return 0;
            }
            this.b = new AudioTrack(new AudioAttributes.Builder().setUsage(i6).setContentType(i7).build(), new AudioFormat.Builder().setSampleRate(i).setEncoding(i4).setChannelMask(i3).build(), a2, i5, 0);
            a aVar22 = this.c;
            this.b.setStereoVolume(aVar22.g, aVar22.h);
            this.b.play();
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override // com.baidu.tts.s0
    public void a() {
        LoggerProxy.d("AudioTrackPlayer", "stop");
        try {
            this.j = 0L;
            if (this.g) {
                this.g = false;
                b();
            }
            if (this.b != null) {
                this.b.pause();
                this.b.flush();
                this.b.stop();
            }
            u0 u0Var = this.i;
            if (u0Var != null) {
                u0Var.a();
                this.i = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void a(x4 x4Var) {
        g3 g3Var = this.d;
        a aVar = this.c;
        g3Var.b = (aVar.c * 2) / aVar.b;
        g3Var.f10096a = 0;
        g3Var.c = 0;
        g3Var.d = 0;
        g3Var.e = 0;
        g3Var.f = 0;
        this.h = 0;
        h0 h0Var = this.f10164a;
        if (h0Var != null) {
            h0Var.onPlayStart(x4Var);
        }
    }
}
