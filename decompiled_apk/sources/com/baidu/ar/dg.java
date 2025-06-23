package com.baidu.ar;

import android.os.Looper;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes7.dex */
public class dg implements dj {
    private List<dj> ao = new CopyOnWriteArrayList();
    private List<dj> oJ = new CopyOnWriteArrayList();
    private de oK;
    private df ou;

    public dg(Looper looper) {
        this.oK = new de(looper);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h(dc dcVar) {
        de deVar = this.oK;
        return deVar != null && deVar.d(dcVar);
    }

    public boolean cR() {
        boolean z;
        List<dj> list = this.ao;
        if (list != null && list.size() > 0) {
            for (dj djVar : this.ao) {
                if (djVar == null || !(djVar instanceof di) || !((di) djVar).cR()) {
                    z = false;
                    break;
                }
            }
        }
        z = true;
        di.t(z);
        return z;
    }

    @Override // com.baidu.ar.dj
    public String getName() {
        return "DetectorGroup";
    }

    public boolean isEmpty() {
        List<dj> list;
        List<dj> list2 = this.ao;
        return (list2 == null || list2.size() <= 0) && ((list = this.oJ) == null || list.size() <= 0);
    }

    @Override // com.baidu.ar.dj
    public synchronized void release() {
        try {
            List<dj> list = this.ao;
            if (list != null) {
                Iterator<dj> it = list.iterator();
                while (it.hasNext()) {
                    it.next().release();
                }
                this.ao.clear();
                this.ao = null;
            }
            de deVar = this.oK;
            if (deVar != null) {
                deVar.release();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.baidu.ar.dj
    public void a(df dfVar) {
        this.ou = dfVar;
        this.oK.a(this.ao, new df() { // from class: com.baidu.ar.dg.1
            @Override // com.baidu.ar.df
            public void a(dc dcVar) {
                if (dg.this.ou != null) {
                    dg.this.ou.a(dcVar);
                }
            }

            @Override // com.baidu.ar.df
            public void b(dk dkVar) {
                if (dg.this.ou != null) {
                    dg.this.ou.b(dkVar);
                }
            }

            @Override // com.baidu.ar.df
            public void a(dk dkVar) {
                if (dg.this.ou != null) {
                    dg.this.ou.a(dkVar);
                }
            }
        });
    }

    public void b(dj djVar, df dfVar) {
        if (djVar != null) {
            this.oJ.add(djVar);
            a(djVar, dfVar, true);
        }
    }

    public void c(dj djVar) {
        if (djVar != null) {
            List<dj> list = this.oJ;
            if (list != null) {
                list.remove(djVar);
            }
            List<dj> list2 = this.ao;
            if (list2 != null) {
                list2.remove(djVar);
            }
            de deVar = this.oK;
            if (deVar != null) {
                deVar.d(new dk(djVar.getName(), true));
            }
        }
    }

    public void a(dj djVar) {
        List<dj> list = this.oJ;
        if (list == null || !list.contains(djVar)) {
            List<dj> list2 = this.ao;
            if (list2 == null || !list2.contains(djVar)) {
                return;
            } else {
                this.ao.remove(djVar);
            }
        } else {
            this.oJ.remove(djVar);
            kf.c("DetectorGroup", "removeDetector detector = " + djVar.getName());
        }
        djVar.release();
    }

    public boolean b(dj djVar) {
        if (djVar == null) {
            return false;
        }
        List<dj> list = this.ao;
        if (list != null && list.contains(djVar)) {
            return true;
        }
        List<dj> list2 = this.oJ;
        return list2 != null && list2.contains(djVar);
    }

    public void a(dj djVar, df dfVar) {
        if (djVar != null) {
            this.oJ.add(djVar);
            kf.c("DetectorGroup", "addDetector detector = " + djVar.getName());
            a(djVar, dfVar, false);
        }
    }

    private void a(dj djVar, final df dfVar, final boolean z) {
        kf.c("DetectorGroup", "setupDetctor detector.getName() = " + djVar.getName());
        df dfVar2 = new df() { // from class: com.baidu.ar.dg.2
            @Override // com.baidu.ar.df
            public void a(dc dcVar) {
                if (dcVar == null) {
                    kf.b("DetectorGroup", "onDetected detectResult is NULLLLLL!!!");
                    return;
                }
                if (dg.this.oJ != null && dg.this.oJ.size() > 0) {
                    dj djVar2 = null;
                    for (dj djVar3 : dg.this.oJ) {
                        if (dg.this.a(dcVar, djVar3) && dg.this.h(dcVar)) {
                            djVar2 = djVar3;
                        }
                    }
                    if (djVar2 != null && dg.this.ao != null) {
                        dg.this.ao.add(djVar2);
                        dg.this.oJ.remove(djVar2);
                        kf.c("DetectorGroup", "onDetected detector2Add = " + djVar2.getName());
                    }
                }
                if (dg.this.oK != null) {
                    dg.this.oK.c(dcVar);
                }
            }

            @Override // com.baidu.ar.df
            public void b(dk dkVar) {
                if (dg.this.oK != null) {
                    dg.this.oK.d(dkVar);
                }
                df dfVar3 = dfVar;
                if (dfVar3 != null) {
                    dfVar3.b(dkVar);
                }
            }

            @Override // com.baidu.ar.df
            public void a(dk dkVar) {
                kf.c("DetectorGroup", "setupDetctor result = " + dkVar.cN() + " * " + dkVar.isSuccess());
                if (dg.this.oJ != null && dg.this.oJ.size() > 0 && !dkVar.isSuccess()) {
                    dj djVar2 = null;
                    for (dj djVar3 : dg.this.oJ) {
                        if (dkVar.cN() != null && dkVar.cN().equals(djVar3.getName())) {
                            djVar2 = djVar3;
                        }
                    }
                    if (djVar2 != null) {
                        dg.this.oJ.remove(djVar2);
                        kf.c("DetectorGroup", "onSetup detector2Remove = " + djVar2.getName());
                    }
                }
                if (dg.this.oK != null) {
                    dg.this.oK.c(dkVar);
                }
                df dfVar3 = dfVar;
                if (dfVar3 == null || !z) {
                    return;
                }
                dfVar3.a(dkVar);
            }
        };
        if (!z) {
            djVar.a(dfVar2);
        } else if (djVar instanceof di) {
            ((di) djVar).d(dfVar2);
            dfVar2.a(new dk(djVar.getName(), true));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(dc dcVar, dj djVar) {
        return dcVar.cN() != null && dcVar.cN().equals(djVar.getName());
    }
}
