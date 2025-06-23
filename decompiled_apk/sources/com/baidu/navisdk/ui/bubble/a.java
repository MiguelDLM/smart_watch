package com.baidu.navisdk.ui.bubble;

import android.content.Context;
import android.widget.FrameLayout;
import com.baidu.navisdk.ui.bubble.c;
import com.baidu.navisdk.util.common.LogUtil;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes8.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final c f8349a;

    /* renamed from: com.baidu.navisdk.ui.bubble.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0403a {

        /* renamed from: a, reason: collision with root package name */
        private final Context f8350a;
        private final FrameLayout b;
        private final c.d c;

        public C0403a(Context context, FrameLayout frameLayout) {
            this.f8350a = context;
            this.b = frameLayout;
            this.c = new c.d(context);
        }

        public C0403a a(com.baidu.navisdk.ui.bubble.b bVar) {
            if (bVar != null) {
                this.c.a(bVar);
            }
            return this;
        }

        public a b() {
            a a2 = a();
            a2.b();
            return a2;
        }

        public a a() {
            a aVar = new a(this.f8350a, this.b);
            this.c.a(aVar.f8349a);
            return aVar;
        }
    }

    /* loaded from: classes8.dex */
    public static final class b implements d {
        @Override // com.baidu.navisdk.ui.bubble.d
        public ArrayList<com.baidu.navisdk.ui.bubble.b> a(ArrayList<com.baidu.navisdk.ui.bubble.b> arrayList) {
            if (LogUtil.LOGGABLE) {
                LogUtil.printList("DefaultBubbleFilter", "filterBubble", "bubbles", arrayList);
            }
            Iterator<com.baidu.navisdk.ui.bubble.b> it = arrayList.iterator();
            com.baidu.navisdk.ui.bubble.b bVar = null;
            while (it.hasNext()) {
                com.baidu.navisdk.ui.bubble.b next = it.next();
                if (next != null && next.j() && (next.f() == null || next.f().a())) {
                    if (bVar == null || next.h() > bVar.h()) {
                        bVar = next;
                    }
                }
            }
            ArrayList<com.baidu.navisdk.ui.bubble.b> arrayList2 = new ArrayList<>();
            arrayList2.add(bVar);
            return arrayList2;
        }
    }

    public a(Context context, FrameLayout frameLayout) {
        this.f8349a = new c(context, frameLayout);
    }

    public void b() {
        c cVar = this.f8349a;
        if (cVar != null) {
            cVar.e();
        }
    }

    public void a() {
        c cVar = this.f8349a;
        if (cVar != null) {
            cVar.d();
        }
    }

    public boolean a(int i) {
        c cVar = this.f8349a;
        if (cVar != null) {
            return cVar.a(i);
        }
        return false;
    }
}
