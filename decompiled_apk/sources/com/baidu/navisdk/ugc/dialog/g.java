package com.baidu.navisdk.ugc.dialog;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;

/* loaded from: classes8.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    private com.baidu.navisdk.ugc.dialog.a f8030a;
    private d b;
    private com.baidu.navisdk.ugc.dialog.c c;

    /* loaded from: classes8.dex */
    public class a implements DialogInterface.OnCancelListener {
        public a() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            g.this.c();
        }
    }

    /* loaded from: classes8.dex */
    public class b implements DialogInterface.OnDismissListener {
        public b() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("UgcDialogController", "onDismiss: ");
            }
            g.this.b = null;
        }
    }

    /* loaded from: classes8.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        private static final g f8033a = new g(null);
    }

    public /* synthetic */ g(a aVar) {
        this();
    }

    public static g e() {
        return c.f8033a;
    }

    public void b() {
        com.baidu.navisdk.ugc.dialog.c cVar = this.c;
        if (cVar != null) {
            cVar.hide();
            this.c = null;
        }
    }

    public void c() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
        if (gVar.d()) {
            gVar.e("dismissPicChooseDialog ");
        }
        d dVar = this.b;
        if (dVar != null) {
            dVar.dismiss();
            this.b = null;
        }
    }

    public boolean d() {
        d dVar = this.b;
        if (dVar != null && dVar.isShowing()) {
            return true;
        }
        return false;
    }

    private g() {
        this.f8030a = null;
        this.b = null;
        this.c = null;
    }

    public void a(Activity activity, com.baidu.navisdk.ugc.dialog.b bVar) {
        com.baidu.navisdk.ugc.dialog.a aVar = new com.baidu.navisdk.ugc.dialog.a(activity, bVar);
        this.f8030a = aVar;
        aVar.show();
    }

    public void a() {
        com.baidu.navisdk.ugc.dialog.a aVar = this.f8030a;
        if (aVar != null) {
            aVar.dismiss();
            this.f8030a = null;
        }
    }

    public void a(Activity activity, int i, com.baidu.navisdk.ugc.listener.b bVar, int i2) {
        a(activity, i, bVar, null, i2);
    }

    public void a(Activity activity, int i, com.baidu.navisdk.ugc.listener.b bVar, com.baidu.navisdk.ugc.video.a aVar, int i2) {
        a(activity, i, bVar, aVar, null, i2);
    }

    public void a(Activity activity, int i, com.baidu.navisdk.ugc.listener.b bVar, com.baidu.navisdk.ugc.video.a aVar, com.baidu.navisdk.ugc.listener.c cVar, int i2) {
        if (activity == null) {
            return;
        }
        d dVar = new d(activity, i, i2);
        this.b = dVar;
        dVar.a(bVar);
        this.b.a(aVar);
        this.b.a(cVar);
        this.b.setOnCancelListener(new a());
        this.b.setOnDismissListener(new b());
        this.b.show();
    }

    public void a(int i, int i2, Intent intent) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
        if (gVar.d()) {
            gVar.e("UgcDialogController", "onPicChooseActivityResult: " + i + "," + i2);
        }
        d dVar = this.b;
        if (dVar != null) {
            dVar.a(i, i2, intent);
        }
    }

    public boolean a(int i) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("UgcDialogController", "isPicChooseActivityResult: " + i + "," + this.b);
        }
        d dVar = this.b;
        return dVar != null && dVar.a(i);
    }

    public void a(com.baidu.navisdk.ugc.listener.b bVar) {
        d dVar = this.b;
        if (dVar != null) {
            dVar.a(bVar);
        }
    }

    public void a(Activity activity, String str, View.OnClickListener onClickListener) {
        if (this.c == null) {
            this.c = new com.baidu.navisdk.ugc.dialog.c(activity);
        }
        this.c.a(onClickListener);
        this.c.a(str);
        if (this.c.isShowing()) {
            return;
        }
        this.c.show();
    }
}
