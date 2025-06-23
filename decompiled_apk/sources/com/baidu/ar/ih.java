package com.baidu.ar;

import android.content.Context;
import com.baidu.ar.ig;

/* loaded from: classes7.dex */
public class ih {
    private static ih yD;
    private ig yE;
    private boolean yF = false;

    private ih(Context context) {
        this.yE = new ig(context);
    }

    public static synchronized ih j(Context context) {
        ih ihVar;
        synchronized (ih.class) {
            try {
                if (yD == null) {
                    yD = new ih(context);
                }
                ihVar = yD;
            } catch (Throwable th) {
                throw th;
            }
        }
        return ihVar;
    }

    public void Q(boolean z) {
        ig igVar = this.yE;
        if (igVar != null) {
            igVar.Q(z);
        }
    }

    public void b(ig.a aVar) {
        ig igVar = this.yE;
        if (igVar != null) {
            igVar.a(aVar);
            if (this.yF) {
                return;
            }
            try {
                this.yE.start();
                this.yF = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void destroy() {
        try {
            stop();
        } catch (Throwable unused) {
        }
        if (this.yE != null) {
            this.yE = null;
        }
        if (yD != null) {
            yD = null;
        }
        this.yF = false;
    }

    public void stop() {
        ig igVar = this.yE;
        if (igVar != null) {
            igVar.stop();
            this.yF = false;
        }
    }
}
