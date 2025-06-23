package com.baidu.navisdk.module.longlink;

import com.baidu.navisdk.module.longlink.JNILonglinkControl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes7.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private com.baidu.navisdk.util.worker.loop.a f7193a = new com.baidu.navisdk.util.worker.loop.a("LonglinkDispatcher-DefaultMainLooper");
    private HashMap<JNILonglinkControl.c, com.baidu.navisdk.module.longlink.a> b = new HashMap<>();
    private HashMap<Integer, ArrayList<JNILonglinkControl.c>> c = new HashMap<>();

    /* loaded from: classes7.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f7194a;
        final /* synthetic */ boolean b;
        final /* synthetic */ int c;
        final /* synthetic */ boolean d;
        final /* synthetic */ String e;

        public a(int i, boolean z, int i2, boolean z2, String str) {
            this.f7194a = i;
            this.b = z;
            this.c = i2;
            this.d = z2;
            this.e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            ArrayList arrayList = (ArrayList) b.this.c.get(Integer.valueOf(this.f7194a));
            if (arrayList.isEmpty()) {
                return;
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                JNILonglinkControl.c cVar = (JNILonglinkControl.c) it.next();
                com.baidu.navisdk.module.longlink.a aVar = (com.baidu.navisdk.module.longlink.a) b.this.b.get(cVar);
                if (aVar != null) {
                    if (this.b) {
                        aVar.a(cVar.b, this.c, this.d, this.e);
                    } else {
                        aVar.b(cVar.b, this.c, this.d, this.e);
                    }
                }
            }
        }
    }

    public void a(JNILonglinkControl.c cVar, com.baidu.navisdk.module.longlink.a aVar) {
        this.b.put(cVar, aVar);
        ArrayList<JNILonglinkControl.c> arrayList = this.c.get(Integer.valueOf(cVar.f7192a));
        if (arrayList == null) {
            ArrayList<JNILonglinkControl.c> arrayList2 = new ArrayList<>();
            arrayList2.add(cVar);
            this.c.put(Integer.valueOf(cVar.f7192a), arrayList2);
            return;
        }
        arrayList.add(cVar);
    }

    public void b(JNILonglinkControl.c cVar) {
        this.b.remove(cVar);
        ArrayList<JNILonglinkControl.c> arrayList = this.c.get(Integer.valueOf(cVar.f7192a));
        if (arrayList != null) {
            arrayList.remove(cVar);
        }
    }

    public boolean a(int i) {
        return this.c.get(Integer.valueOf(i)) == null || this.c.get(Integer.valueOf(i)).isEmpty();
    }

    public boolean a(JNILonglinkControl.c cVar) {
        return this.b.containsKey(cVar);
    }

    public void a(boolean z, int i, int i2, boolean z2, String str) {
        if (this.b != null) {
            this.f7193a.post(new a(i, z, i2, z2, str));
        }
    }
}
