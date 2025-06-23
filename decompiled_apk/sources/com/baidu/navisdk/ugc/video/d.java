package com.baidu.navisdk.ugc.video;

import com.baidu.navisdk.ugc.eventdetails.model.e;
import com.baidu.navisdk.util.common.g;

/* loaded from: classes8.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private b f8346a;

    /* loaded from: classes8.dex */
    public class a implements c {
        public a(e.b bVar) {
        }

        @Override // com.baidu.navisdk.ugc.video.d.c
        public void a() {
            g gVar = g.UGC;
            if (gVar.e()) {
                gVar.g("UgcModule_PlayVideo", "upload thumbnail failed");
            }
            if (d.this.f8346a != null) {
                d.this.f8346a.a(1);
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface b {
        void a(int i);
    }

    /* loaded from: classes8.dex */
    public interface c {
        void a();
    }

    private void b(e.b bVar) {
        c cVar;
        e eVar = new e(bVar.b, new a(bVar));
        if (!com.baidu.navisdk.framework.b.c(eVar) && (cVar = eVar.f8348a) != null) {
            cVar.a();
        }
    }

    public void a(b bVar) {
        this.f8346a = bVar;
    }

    public void a(e.b bVar) {
        b(bVar);
    }
}
