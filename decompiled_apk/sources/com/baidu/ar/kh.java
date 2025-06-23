package com.baidu.ar;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

/* loaded from: classes7.dex */
public class kh {
    private HandlerThread Di;
    private a Dj;
    private String mTag;

    /* loaded from: classes7.dex */
    public static final class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        public void a(Runnable runnable) {
            Message obtain = Message.obtain();
            obtain.obj = runnable;
            sendMessage(obtain);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            Runnable runnable = (Runnable) message.obj;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    public kh(String str) {
        this.mTag = str;
    }

    public void execute(Runnable runnable) {
        a aVar = this.Dj;
        if (aVar != null) {
            aVar.a(runnable);
        }
    }

    public void start() {
        HandlerThread handlerThread = new HandlerThread(this.mTag);
        this.Di = handlerThread;
        handlerThread.start();
        this.Dj = new a(this.Di.getLooper());
    }
}
