package com.baidu.platform.comapi.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* loaded from: classes8.dex */
public abstract class i extends Handler {
    public i(Looper looper) {
        super(looper);
    }

    public abstract void a(Message message);

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        if (message == null) {
            return;
        }
        Message obtain = Message.obtain();
        obtain.copyFrom(message);
        a(obtain);
        obtain.recycle();
    }
}
