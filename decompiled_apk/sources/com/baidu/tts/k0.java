package com.baidu.tts;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTrack;
import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.t0;

/* loaded from: classes8.dex */
public abstract class k0 implements l0 {

    /* renamed from: a, reason: collision with root package name */
    public p0 f10117a;

    public k0(p0 p0Var) {
        this.f10117a = p0Var;
    }

    @Override // com.baidu.tts.l0
    public void a() {
    }

    @Override // com.baidu.tts.l0
    public abstract void a(x4 x4Var);

    @Override // com.baidu.tts.i3
    public TtsError create() {
        return null;
    }

    @Override // com.baidu.tts.i3
    public void destroy() {
    }

    @Override // com.baidu.tts.i3
    public void pause() {
    }

    @Override // com.baidu.tts.i3
    public void resume() {
    }

    @Override // com.baidu.tts.l0
    public int setAudioAttributes(int i, int i2) {
        t0 t0Var = (t0) this.f10117a.f;
        t0Var.getClass();
        LoggerProxy.d("AudioTrackPlayer", " setAudioAttributes   mUsage:" + i + " mContentType:" + i2);
        if (t0Var.b == null) {
            return -2;
        }
        synchronized (t0.class) {
            try {
                t0.a aVar = t0Var.c;
                if (i == aVar.i) {
                    if (i2 != aVar.j) {
                    }
                }
                int i3 = aVar.c;
                t0Var.l = i3;
                int i4 = aVar.d;
                int i5 = aVar.e;
                int i6 = aVar.f;
                int a2 = t0Var.a(i3, i4, i5);
                if (t0Var.b.getState() == 1) {
                    t0Var.b.release();
                }
                t0Var.b = new AudioTrack(new AudioAttributes.Builder().setUsage(i).setContentType(i2).build(), new AudioFormat.Builder().setSampleRate(i3).setEncoding(i5).setChannelMask(i4).build(), a2, i6, 0);
                t0.a aVar2 = t0Var.c;
                aVar2.i = i;
                aVar2.j = i2;
                t0Var.b.setStereoVolume(aVar2.g, aVar2.h);
                t0Var.b.play();
            } catch (Exception e) {
                e.printStackTrace();
                return -2;
            } finally {
            }
        }
        return 0;
    }

    @Override // com.baidu.tts.l0
    public int setAudioSampleRate(int i) {
        return this.f10117a.f.a(i);
    }

    @Override // com.baidu.tts.l0
    public int setAudioStreamType(int i) {
        t0 t0Var = (t0) this.f10117a.f;
        t0Var.getClass();
        LoggerProxy.d("AudioTrackPlayer", "setAudioStreamType:" + i);
        if (t0Var.b == null) {
            return -2;
        }
        synchronized (t0.class) {
            try {
                try {
                    t0.a aVar = t0Var.c;
                    if (i != aVar.f10167a) {
                        int i2 = aVar.c;
                        t0Var.l = i2;
                        int i3 = aVar.d;
                        int i4 = aVar.e;
                        int i5 = aVar.f;
                        int a2 = t0Var.a(i2, i3, i4);
                        if (t0Var.b != null && t0Var.b.getState() == 1) {
                            t0Var.b.release();
                        }
                        t0Var.b = new AudioTrack(i, i2, i3, i4, a2, i5);
                        t0.a aVar2 = t0Var.c;
                        aVar2.f10167a = i;
                        t0Var.b.setStereoVolume(aVar2.g, aVar2.h);
                        t0Var.b.play();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return 0;
    }

    @Override // com.baidu.tts.l0
    public int setStereoVolume(float f, float f2) {
        t0 t0Var = (t0) this.f10117a.f;
        int stereoVolume = t0Var.b.setStereoVolume(f, f2);
        t0.a aVar = t0Var.c;
        aVar.g = f;
        aVar.h = f2;
        return stereoVolume;
    }

    @Override // com.baidu.tts.i3
    public void start() {
    }

    @Override // com.baidu.tts.i3
    public void stop() {
    }

    @Override // com.baidu.tts.l0
    public void a(h0 h0Var) {
        this.f10117a.c = h0Var;
    }
}
