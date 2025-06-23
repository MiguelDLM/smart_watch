package com.huawei.hms.ads;

import android.util.Log;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes10.dex */
public class fe extends ez {
    private static final String I = "HiAdLog";
    private static final int V = 60;
    private final Executor B = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.huawei.openalliance.ad.utils.i("FileLog"));
    private final fg Z;

    public fe(fg fgVar) {
        this.Z = fgVar;
    }

    @Override // com.huawei.hms.ads.fg
    public fg Code(final String str, final String str2) {
        this.B.execute(new Runnable() { // from class: com.huawei.hms.ads.fe.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    fe.this.Z.Code(str, str2);
                } catch (Throwable th) {
                    Log.w(fe.I, "init err: " + th.getClass().getSimpleName());
                }
            }
        });
        fg fgVar = this.Code;
        if (fgVar != null) {
            fgVar.Code(str, str2);
        }
        return this;
    }

    @Override // com.huawei.hms.ads.fg
    public void Code(final fi fiVar, final int i, final String str) {
        this.B.execute(new Runnable() { // from class: com.huawei.hms.ads.fe.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    fe.this.Z.Code(fiVar, i, str);
                } catch (Throwable th) {
                    Log.w(fe.I, "log err: " + th.getClass().getSimpleName());
                }
            }
        });
        fg fgVar = this.Code;
        if (fgVar != null) {
            fgVar.Code(fiVar, i, str);
        }
    }
}
