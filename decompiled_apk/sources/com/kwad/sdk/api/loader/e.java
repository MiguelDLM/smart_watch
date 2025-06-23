package com.kwad.sdk.api.loader;

import android.content.Context;
import android.util.Log;
import java.lang.Thread;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes11.dex */
public class e implements Thread.UncaughtExceptionHandler {
    private static e anv;
    private Thread.UncaughtExceptionHandler anw;
    private int anx;
    private long anz;
    private Context mContext;
    private boolean DEBUG = false;
    private final AtomicBoolean any = new AtomicBoolean();

    private e(Context context) {
        this.mContext = context;
    }

    public static e aL(Context context) {
        if (anv == null) {
            synchronized (e.class) {
                try {
                    if (anv == null) {
                        anv = new e(context);
                    }
                } finally {
                }
            }
        }
        return anv;
    }

    public final void bW(int i) {
        this.anz = System.currentTimeMillis();
        this.anx = i;
        if (this.DEBUG) {
            Log.d("test.chen", "startCheck:");
        }
    }

    public final void cancel() {
        if (this.DEBUG) {
            Log.d("test.chen", "AutoRevertHandler cancel:");
        }
        this.any.set(true);
    }

    public final void setDefaultUncaughtExceptionHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        if (uncaughtExceptionHandler != this) {
            this.anw = uncaughtExceptionHandler;
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        boolean z;
        try {
            if (this.DEBUG) {
                Log.d("test.chen", "AutoRevertHandler uncaughtException, mStartCheckTime:" + this.anz + ",mMaxDuration:" + this.anx + ",mIsCancel:" + this.any.get());
            }
            if (!this.any.get() && this.anz > 0 && System.currentTimeMillis() - this.anz <= this.anx) {
                Boolean bool = (Boolean) com.kwad.sdk.api.c.f("filterStack", th);
                if (bool != null) {
                    z = bool.booleanValue();
                } else {
                    z = true;
                }
                Context context = this.mContext;
                if (context != null && z) {
                    b.a(context, h.anF, true);
                }
            }
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.anw;
            if (uncaughtExceptionHandler != null) {
                uncaughtExceptionHandler.uncaughtException(thread, th);
            }
        } catch (Throwable th2) {
            try {
                th2.printStackTrace();
                Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = this.anw;
                if (uncaughtExceptionHandler2 != null) {
                    uncaughtExceptionHandler2.uncaughtException(thread, th);
                }
            } catch (Throwable th3) {
                if (this.anw != null) {
                    this.anw.uncaughtException(thread, th);
                }
                throw th3;
            }
        }
    }
}
