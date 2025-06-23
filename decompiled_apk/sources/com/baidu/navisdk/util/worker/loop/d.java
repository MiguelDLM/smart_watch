package com.baidu.navisdk.util.worker.loop;

import android.os.Message;
import com.baidu.navisdk.util.common.r0;

/* loaded from: classes8.dex */
public abstract class d extends com.baidu.navisdk.comapi.base.d {
    public d() {
        super(r0.d().b());
    }

    @Override // android.os.Handler
    public final void dispatchMessage(Message message) {
        super.dispatchMessage(message);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        if (message == null) {
            return;
        }
        onMessage(message);
    }

    public abstract void onMessage(Message message);

    @Override // android.os.Handler
    public final boolean sendMessageAtTime(Message message, long j) {
        return super.sendMessageAtTime(message, j);
    }
}
