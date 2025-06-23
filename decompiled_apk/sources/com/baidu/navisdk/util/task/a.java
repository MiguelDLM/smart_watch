package com.baidu.navisdk.util.task;

import android.os.Looper;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.task.b;
import com.baidu.navisdk.util.worker.c;
import com.baidu.navisdk.util.worker.e;
import com.baidu.navisdk.util.worker.f;
import com.baidu.navisdk.util.worker.g;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes8.dex */
public class a implements b.a {

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<com.baidu.navisdk.util.task.b<String, String>> f9387a = new ArrayList<>();
    private ArrayList<com.baidu.navisdk.util.task.b<String, String>> b = new ArrayList<>();
    private int c = 0;
    private b d;

    /* renamed from: com.baidu.navisdk.util.task.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0509a extends f<String, String> {
        public C0509a(String str, String str2) {
            super(str, str2);
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            a.this.d.a();
            return null;
        }
    }

    /* loaded from: classes8.dex */
    public interface b {
        void a();
    }

    private a() {
    }

    public static a c() {
        return new a();
    }

    public a b(com.baidu.navisdk.util.task.b<String, String> bVar) {
        if (this.c != 3) {
            this.c = 1;
            int i = bVar.f9389a;
            if (i == 0) {
                bVar.a(this);
                this.f9387a.add(bVar);
            } else if (i == 1) {
                bVar.a(this);
                this.b.add(bVar);
            }
            return this;
        }
        throw new RuntimeException("current taskExecutor has end, need renew instance");
    }

    public void a() {
        this.c = 4;
        if (!this.b.isEmpty()) {
            ArrayList arrayList = new ArrayList(this.b);
            this.b.clear();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                c.a().a((g) it.next(), false);
            }
        }
        if (this.f9387a.isEmpty()) {
            return;
        }
        ArrayList arrayList2 = new ArrayList(this.f9387a);
        this.f9387a.clear();
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            c.a().a((g) it2.next(), false);
        }
    }

    public void b() {
        int i = this.c;
        if (i == 3) {
            throw new RuntimeException("current taskExecutor has end, need renew instance");
        }
        if (i == 4) {
            LogUtil.e("TaskExecutor", "start return state_cancle");
            return;
        }
        this.c = 2;
        Iterator it = new ArrayList(this.b).iterator();
        while (it.hasNext()) {
            c.a().c((com.baidu.navisdk.util.task.b) it.next(), new e(2, 0));
        }
        Iterator it2 = new ArrayList(this.f9387a).iterator();
        while (it2.hasNext()) {
            c.a().a((f) it2.next(), new e(2, 0));
        }
    }

    @Override // com.baidu.navisdk.util.task.b.a
    public void a(com.baidu.navisdk.util.task.b<?, ?> bVar) {
        if (this.f9387a.contains(bVar)) {
            this.f9387a.remove(bVar);
        }
        if (this.b.contains(bVar)) {
            this.b.remove(bVar);
        }
        if (this.f9387a.isEmpty() && this.b.isEmpty()) {
            this.c = 3;
            if (this.d == null) {
                return;
            }
            if (Looper.getMainLooper() == Looper.myLooper()) {
                this.d.a();
                return;
            }
            c.a().a((f) new C0509a("onComplete-" + a.class.getSimpleName(), null), new e(99, 0));
        }
    }
}
