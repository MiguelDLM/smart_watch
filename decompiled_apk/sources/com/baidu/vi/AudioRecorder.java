package com.baidu.vi;

import android.annotation.SuppressLint;
import android.media.AudioRecord;
import android.os.Handler;

/* loaded from: classes8.dex */
public class AudioRecorder {

    @SuppressLint({"HandlerLeak"})
    private static Handler j = new com.baidu.vi.a();

    /* renamed from: a, reason: collision with root package name */
    private volatile AudioRecord f10211a;
    private int b;
    private int c;
    private int d;
    private boolean e;
    private int f;
    private int g;
    private volatile boolean h = false;
    private Object i = new Object();
    private Thread k = new b(this, AudioRecorder.class.getSimpleName() + "-Record");

    /* loaded from: classes8.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        AudioRecorder f10212a;
        byte[] b;
        int c;

        public a(AudioRecorder audioRecorder, byte[] bArr, int i) {
            this.f10212a = audioRecorder;
            this.b = bArr;
            this.c = i;
        }
    }

    public AudioRecorder(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.e = true;
        if (i3 == 8) {
            this.d = 3;
        } else {
            this.d = 2;
        }
        if (i4 == 2) {
            this.c = 3;
        } else {
            this.c = 2;
        }
        this.e = i7 == 1;
        this.b = i2;
        this.g = i5;
        this.f = i6;
    }

    public native void onReadData(byte[] bArr, int i);

    public native void onReadError();

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.e) {
            a aVar = new a(this, null, 0);
            Handler handler = j;
            handler.sendMessage(handler.obtainMessage(2, aVar));
        } else if (this.h) {
            onReadError();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(byte[] bArr, int i) {
        if (this.e) {
            a aVar = new a(this, bArr, i);
            Handler handler = j;
            handler.sendMessage(handler.obtainMessage(1, aVar));
        } else if (this.h) {
            onReadData(bArr, i);
        }
    }
}
