package com.baidu.ar;

import android.os.Looper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes7.dex */
public class cd {
    ce mb;
    private Looper mc;
    private final Map<Class<?>, CopyOnWriteArrayList<cj>> lY = new HashMap();
    private final Map<Object, List<Class<?>>> lX = new HashMap();
    ci lZ = new ci();
    ce ma = new ce(this, Looper.getMainLooper(), 10);

    public void a(cf cfVar) {
        Object obj = cfVar.mj;
        cj cjVar = cfVar.mk;
        cf.b(cfVar);
        if (cjVar.mz) {
            a(cjVar, obj);
        }
    }

    public void b(Looper looper) {
        ce ceVar = this.mb;
        if (ceVar != null) {
            ceVar.release();
        }
        this.mc = looper;
        this.mb = new ce(this, looper, 10);
    }

    public void a(cj cjVar, Object obj) {
        try {
            cjVar.my.mo.invoke(cjVar.mx, obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
