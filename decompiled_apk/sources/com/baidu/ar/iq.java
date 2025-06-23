package com.baidu.ar;

import android.content.Context;
import java.lang.ref.WeakReference;

/* loaded from: classes7.dex */
public class iq implements Runnable {
    private Object mLock;
    private WeakReference<Context> of;
    private int zb;
    private volatile boolean zc;
    private ir[] zd;

    public iq(Context context, Object obj, ir[] irVarArr) {
        irVarArr.getClass();
        this.of = new WeakReference<>(context);
        this.zb = 0;
        this.zc = false;
        this.mLock = obj;
        this.zd = irVarArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:65:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0086 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x000b A[SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void run() {
        /*
            Method dump skipped, instructions count: 227
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.ar.iq.run():void");
    }

    public void shutdown() {
        this.zc = true;
    }
}
