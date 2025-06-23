package com.baidu.ar;

import android.content.Context;
import android.util.Pair;
import com.baidu.ar.it;
import com.facebook.appevents.UserDataStore;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* loaded from: classes7.dex */
public class ik implements it.a {
    private WeakReference<Context> of;
    private im yO;
    private String yP;
    private String yQ;
    private String[][] yR;
    private Map<String, String> yS;
    private it yV;
    private Map<String, ij> yN = new HashMap();
    private long yT = 0;
    private long yU = 0;

    public ik(Context context, im imVar, String[][] strArr, Map<String, String> map, it itVar) {
        this.of = new WeakReference<>(context);
        this.yO = imVar;
        this.yR = strArr;
        this.yS = map == null ? new HashMap<>() : map;
        this.yV = itVar;
        itVar.a(this);
    }

    private Pair<Long, Long> a(long j, long j2) {
        long j3;
        long j4;
        long j5 = this.yT;
        if (j5 <= 0 || j > j5) {
            j3 = j2 - j;
            j4 = 0;
        } else {
            long j6 = this.yU;
            if (j6 <= 0 || j2 < j6) {
                j3 = j5 - j;
                j4 = j2 - j5;
            } else {
                j3 = (j5 - j) + (j6 - j2);
                j4 = j6 - j5;
            }
        }
        if (j3 < 0) {
            j3 = 0;
        }
        return new Pair<>(Long.valueOf(j3), Long.valueOf(j4 >= 0 ? j4 : 0L));
    }

    private void b(ij... ijVarArr) {
        synchronized (this.yO) {
            try {
                this.yO.fX();
                for (ij ijVar : ijVarArr) {
                    this.yO.k(ijVar);
                }
                this.yO.notifyAll();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private ArrayList<String> bH(String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        String[][] strArr = this.yR;
        if (strArr != null && strArr.length > 0) {
            for (String[] strArr2 : strArr) {
                if (strArr2 != null && strArr2.length >= 2 && str.equals(strArr2[0])) {
                    for (int i = 1; i < strArr2.length; i++) {
                        arrayList.add(strArr2[i]);
                    }
                }
            }
        }
        return arrayList;
    }

    private String bI(String str) {
        String[][] strArr = this.yR;
        if (strArr == null || strArr.length <= 0) {
            return null;
        }
        for (String[] strArr2 : strArr) {
            if (strArr2 != null && strArr2.length >= 2) {
                for (int i = 1; i < strArr2.length; i++) {
                    if (str.equals(strArr2[i])) {
                        return strArr2[0];
                    }
                }
            }
        }
        return null;
    }

    private void d(ij ijVar) {
        f(ijVar);
        if (ijVar.bE("event_label") || !this.yS.containsKey(ijVar.fS())) {
            return;
        }
        ijVar.a("event_label", this.yS.get(ijVar.fS()));
    }

    private void f(ij ijVar) {
        ijVar.a("request_id", this.yQ);
    }

    private String fV() {
        if (this.yP == null) {
            Context context = this.of.get();
            if (context == null) {
                return "";
            }
            UUID hg = new kk(context).hg();
            this.yP = hg != null ? hg.toString() : "";
        }
        return this.yP;
    }

    private void l(long j) {
        this.yT = j;
    }

    private void m(long j) {
        long j2 = this.yT;
        if (j < j2) {
            j = j2;
        }
        this.yU = j;
    }

    @Override // com.baidu.ar.it.a
    public void M(int i) {
        if (i > 0) {
            synchronized (this.yO) {
                this.yO.notifyAll();
            }
        }
    }

    public void c(ij ijVar) {
        d(ijVar);
        b(ijVar);
    }

    public void e(ij ijVar) {
        d(ijVar);
        synchronized (this.yO) {
            try {
                this.yO.fX();
                String fS = ijVar.fS();
                long longValue = ((Number) ijVar.bC("_db_period")).longValue();
                ArrayList arrayList = new ArrayList();
                int size = this.yO.size();
                for (int i = 0; i < size; i++) {
                    ij ijVar2 = this.yO.get(i);
                    if (fS.equals(ijVar2.fS()) && longValue == ijVar2.bD("_db_period") && ijVar.getTimestamp() - ijVar2.getTimestamp() < longValue) {
                        arrayList.add(Integer.valueOf(i));
                    }
                }
                if (!arrayList.isEmpty()) {
                    for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                        int intValue = ((Integer) arrayList.get(size2)).intValue();
                        ij ijVar3 = this.yO.get(intValue);
                        this.yO.remove(intValue);
                        ij.a(ijVar3);
                    }
                }
                this.yO.k(ijVar);
                this.yO.notifyAll();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void fW() {
        this.yV.gb();
    }

    public void g(ij ijVar) {
        String fS = ijVar.fS();
        ij ijVar2 = this.yN.get(fS);
        boolean equals = "1".equals(ijVar.bC("__stt"));
        if (ijVar2 == null) {
            if (equals) {
                this.yN.put(fS, ijVar);
                ij clone = ijVar.clone();
                clone.bA(fS);
                clone.bF("__stt");
                clone.bF("__falseev");
                c(clone);
                return;
            }
            return;
        }
        if (equals) {
            return;
        }
        String bB = ijVar.bB("__falseev");
        if (bB != null && !bB.isEmpty()) {
            ij clone2 = ijVar.clone();
            clone2.bA(bB);
            clone2.bF("__stt");
            clone2.bF("__falseev");
            c(clone2);
        }
        this.yN.remove(fS);
        ij.a(ijVar2);
    }

    public void h(ij ijVar) {
        String fS = ijVar.fS();
        ArrayList<String> bH = bH(fS);
        if (bH.isEmpty()) {
            return;
        }
        c(ijVar.clone());
        Iterator<String> it = bH.iterator();
        while (it.hasNext()) {
            String next = it.next();
            this.yN.put(fS + ":" + next, ijVar);
        }
    }

    public void i(ij ijVar) {
        String fS = ijVar.fS();
        String bI = bI(fS);
        if (bI == null || bI.isEmpty()) {
            return;
        }
        String str = bI + ":" + fS;
        ij ijVar2 = this.yN.get(str);
        if (ijVar2 != null) {
            Pair<Long, Long> a2 = a(ijVar2.getTimestamp(), ijVar.getTimestamp());
            ijVar.a(UserDataStore.STATE, String.valueOf(ijVar2.getTimestamp()));
            ijVar.a("duration", String.valueOf(((Long) a2.first).longValue()));
            ijVar.a("_pausedt", String.valueOf(((Long) a2.second).longValue()));
            c(ijVar);
            this.yN.remove(str);
            ij.a(ijVar2);
        }
    }

    public void init() {
        if (this.of.get() == null) {
            return;
        }
        this.yQ = kp.co(fV() + String.valueOf(System.currentTimeMillis()));
    }

    public void j(ij ijVar) {
        boolean n;
        f(ijVar);
        synchronized (this.yV) {
            n = this.yV.n(ijVar);
        }
        if (n) {
            return;
        }
        ij.a(ijVar);
    }

    public void n(long j) {
        l(j);
        synchronized (this.yO) {
            this.yO.flush();
        }
        fW();
    }

    public void onResume(long j) {
        m(j);
    }

    public void h(List<String> list) {
        this.yV.j(list);
    }
}
