package com.baidu.ar;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes7.dex */
public class de {
    private df ak;
    private List<dj> ao;
    private Looper oB;
    private Handler oC;
    private ArrayList<dd> oE = new ArrayList<>();
    private HashMap<String, Boolean> oF = new HashMap<>();
    private HashMap<String, Boolean> oG = new HashMap<>();
    private long oH = 0;
    private int oD = 180;

    /* loaded from: classes7.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1001:
                    de.this.e((dk) message.obj);
                    return;
                case 1002:
                    de.this.e((dc) message.obj);
                    return;
                case 1003:
                    de.this.f((dk) message.obj);
                    return;
                case 1004:
                    de.this.U();
                    return;
                default:
                    return;
            }
        }
    }

    public de(Looper looper) {
        this.oB = looper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U() {
        cQ();
        this.oC.removeCallbacksAndMessages(null);
        this.oC = null;
    }

    private void a(dd ddVar) {
        ArrayList<dd> arrayList;
        List<dj> list;
        if (ddVar == null || (arrayList = this.oE) == null || arrayList.size() == 0 || (list = this.ao) == null || list.size() == 0 || this.ak == null) {
            return;
        }
        Iterator<dj> it = this.ao.iterator();
        while (it.hasNext()) {
            if (!ddVar.aa(it.next().getName())) {
                return;
            }
        }
        if (ddVar.getTimestamp() != this.oH) {
            this.ak.a(ddVar);
            this.oH = ddVar.getTimestamp();
            ArrayList<dd> arrayList2 = this.oE;
            arrayList2.subList(0, arrayList2.indexOf(ddVar)).clear();
        }
    }

    private void cQ() {
        List<dj> list = this.ao;
        if (list != null) {
            list.clear();
        }
        ArrayList<dd> arrayList = this.oE;
        if (arrayList != null) {
            arrayList.clear();
        }
        HashMap<String, Boolean> hashMap = this.oF;
        if (hashMap != null) {
            hashMap.clear();
        }
        HashMap<String, Boolean> hashMap2 = this.oG;
        if (hashMap2 != null) {
            hashMap2.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(dc dcVar) {
        HashMap<String, Boolean> hashMap;
        if (this.oE == null || (hashMap = this.oF) == null || hashMap.isEmpty()) {
            return;
        }
        dd f = f(dcVar);
        if (f == null) {
            f = g(dcVar);
        }
        a(f);
    }

    private dd f(dc dcVar) {
        Iterator<dd> it = this.oE.iterator();
        while (it.hasNext()) {
            dd next = it.next();
            if (next.getTimestamp() == dcVar.getTimestamp()) {
                next.b(dcVar);
                return next;
            }
        }
        return null;
    }

    private dd g(dc dcVar) {
        if (this.oE.size() >= this.oD) {
            kf.b("DetectResultSync", "add2NewDetectResultGroup detectResult list for sync is fulllll!!!");
            return null;
        }
        dd ddVar = new dd();
        ddVar.setTimestamp(dcVar.getTimestamp());
        ddVar.b(dcVar);
        this.oE.add(ddVar);
        return ddVar;
    }

    public synchronized void c(dc dcVar) {
        Handler handler = this.oC;
        if (handler != null) {
            handler.sendMessage(handler.obtainMessage(1002, dcVar));
        }
    }

    public synchronized void d(dk dkVar) {
        kf.c("DetectResultSync", "DetectorGroup onDetectorRelease result = " + dkVar.cN());
        Handler handler = this.oC;
        if (handler != null) {
            handler.sendMessage(handler.obtainMessage(1003, dkVar));
        }
    }

    public void release() {
        Handler handler = this.oC;
        if (handler != null) {
            handler.sendMessage(handler.obtainMessage(1004));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(dk dkVar) {
        this.oF.put(dkVar.cN(), Boolean.valueOf(dkVar.isSuccess()));
        Iterator<dj> it = this.ao.iterator();
        boolean z = true;
        boolean z2 = true;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            dj next = it.next();
            if (this.oF.get(next.getName()) == null) {
                z = false;
                break;
            } else if (!this.oF.get(next.getName()).booleanValue()) {
                z2 = false;
            }
        }
        df dfVar = this.ak;
        if (dfVar != null) {
            dfVar.a(dkVar);
            if (z) {
                this.ak.a(new dk("DetectorGroup", z2));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(dk dkVar) {
        this.oG.put(dkVar.cN(), Boolean.valueOf(dkVar.isSuccess()));
        Iterator<dj> it = this.ao.iterator();
        boolean z = true;
        boolean z2 = true;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            dj next = it.next();
            if (this.oG.get(next.getName()) == null) {
                z = false;
                break;
            } else if (!this.oG.get(next.getName()).booleanValue()) {
                z2 = false;
            }
        }
        df dfVar = this.ak;
        if (dfVar != null) {
            dfVar.b(dkVar);
            if (z) {
                this.ak.b(new dk("DetectorGroup", z2));
                cQ();
            }
        }
    }

    public synchronized void c(dk dkVar) {
        kf.c("DetectResultSync", "DetectorGroup onDetectorSetup result = " + dkVar.cN());
        Handler handler = this.oC;
        if (handler != null) {
            handler.sendMessage(handler.obtainMessage(1001, dkVar));
        }
    }

    public synchronized boolean d(dc dcVar) {
        if (this.oE.size() != 0) {
            if (this.oE.get(0).getTimestamp() < dcVar.getTimestamp()) {
                return false;
            }
        }
        return true;
    }

    public void a(List<dj> list, df dfVar) {
        this.ao = list;
        this.ak = dfVar;
        if (this.oC != null || this.oB == null) {
            return;
        }
        this.oC = new a(this.oB);
    }
}
