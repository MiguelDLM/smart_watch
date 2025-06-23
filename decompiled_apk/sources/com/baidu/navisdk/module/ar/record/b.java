package com.baidu.navisdk.module.ar.record;

import android.media.MediaFormat;
import android.media.MediaMuxer;
import java.io.IOException;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/* loaded from: classes7.dex */
public class b extends Thread implements Runnable {
    private String b;
    private int c;
    private d e;
    private MediaMuxer f;

    /* renamed from: a, reason: collision with root package name */
    private boolean f6993a = false;
    private boolean d = false;
    private Queue<c> g = new ArrayBlockingQueue(100);

    public b(String str) {
        this.b = str;
    }

    private void c() {
        MediaMuxer mediaMuxer = this.f;
        if (mediaMuxer != null && this.d) {
            mediaMuxer.stop();
            this.f.release();
            this.f = null;
        }
    }

    private void d() {
        if (!this.d && b()) {
            this.f.start();
            this.d = true;
            start();
        }
    }

    public void a(MediaFormat mediaFormat) {
        MediaMuxer mediaMuxer = this.f;
        if (mediaMuxer == null) {
            return;
        }
        this.c = mediaMuxer.addTrack(mediaFormat);
        d();
    }

    public void b(int i, int i2, int i3) {
        try {
            this.c = -1;
            this.f = new MediaMuxer(this.b, 0);
            d dVar = new d(this, i, i2, i3);
            this.e = dVar;
            dVar.c();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        while (true) {
            if (!this.g.isEmpty()) {
                c poll = this.g.poll();
                this.f.writeSampleData(this.c, poll.b(), poll.a());
            } else {
                try {
                    Thread.sleep(30L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (!this.f6993a && this.g.isEmpty()) {
                    c();
                    return;
                }
            }
        }
    }

    public void a(int i, int i2, int i3) {
        b(i, i2, i3);
        this.f6993a = true;
        this.d = false;
        this.e.a();
    }

    public boolean b() {
        return this.c >= 0;
    }

    public void a(byte[] bArr, int i, int i2, int i3) {
        if (this.f6993a) {
            this.e.a(bArr);
        }
    }

    public void a() {
        try {
            this.f6993a = false;
            this.e.b();
            this.e.join();
            this.e = null;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void a(c cVar) {
        this.g.offer(cVar);
    }
}
