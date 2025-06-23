package com.ss.android.downloadlib.c;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import com.ss.android.download.api.model.b;
import com.ss.android.socialbase.appdownloader.c.k;
import com.ss.android.socialbase.appdownloader.c.l;

/* loaded from: classes11.dex */
public class g extends com.ss.android.socialbase.appdownloader.c.a {

    /* renamed from: a, reason: collision with root package name */
    private static String f26086a = "g";

    /* loaded from: classes11.dex */
    public static class a implements k {

        /* renamed from: a, reason: collision with root package name */
        private Dialog f26089a;

        public a(Dialog dialog) {
            if (dialog != null) {
                this.f26089a = dialog;
                a();
            }
        }

        @Override // com.ss.android.socialbase.appdownloader.c.k
        public void a() {
            Dialog dialog = this.f26089a;
            if (dialog != null) {
                dialog.show();
            }
        }

        @Override // com.ss.android.socialbase.appdownloader.c.k
        public boolean b() {
            Dialog dialog = this.f26089a;
            if (dialog != null) {
                return dialog.isShowing();
            }
            return false;
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.c.a, com.ss.android.socialbase.appdownloader.c.c
    public boolean a() {
        return true;
    }

    @Override // com.ss.android.socialbase.appdownloader.c.a, com.ss.android.socialbase.appdownloader.c.c
    public l a(Context context) {
        return new l(context) { // from class: com.ss.android.downloadlib.c.g.1

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Context f26087a;
            private b.a c;
            private DialogInterface.OnClickListener d;
            private DialogInterface.OnClickListener e;
            private DialogInterface.OnCancelListener f;

            {
                this.f26087a = context;
                this.c = new b.a(context);
            }

            @Override // com.ss.android.socialbase.appdownloader.c.l
            public l a(int i) {
                this.c.a(this.f26087a.getResources().getString(i));
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.c.l
            public l b(int i, DialogInterface.OnClickListener onClickListener) {
                this.c.d(this.f26087a.getResources().getString(i));
                this.e = onClickListener;
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.c.l
            public l a(String str) {
                this.c.b(str);
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.c.l
            public l a(int i, DialogInterface.OnClickListener onClickListener) {
                this.c.c(this.f26087a.getResources().getString(i));
                this.d = onClickListener;
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.c.l
            public l a(DialogInterface.OnCancelListener onCancelListener) {
                this.f = onCancelListener;
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.c.l
            public l a(boolean z) {
                this.c.a(z);
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.c.l
            public k a() {
                this.c.a(new b.InterfaceC1035b() { // from class: com.ss.android.downloadlib.c.g.1.1
                    @Override // com.ss.android.download.api.model.b.InterfaceC1035b
                    public void a(DialogInterface dialogInterface) {
                        if (AnonymousClass1.this.d != null) {
                            AnonymousClass1.this.d.onClick(dialogInterface, -1);
                        }
                    }

                    @Override // com.ss.android.download.api.model.b.InterfaceC1035b
                    public void b(DialogInterface dialogInterface) {
                        if (AnonymousClass1.this.e != null) {
                            AnonymousClass1.this.e.onClick(dialogInterface, -2);
                        }
                    }

                    @Override // com.ss.android.download.api.model.b.InterfaceC1035b
                    public void c(DialogInterface dialogInterface) {
                        if (AnonymousClass1.this.f != null && dialogInterface != null) {
                            AnonymousClass1.this.f.onCancel(dialogInterface);
                        }
                    }
                });
                com.ss.android.downloadlib.g.k.a(g.f26086a, "getThemedAlertDlgBuilder", null);
                this.c.a(3);
                return new a(com.ss.android.downloadlib.addownload.k.d().b(this.c.a()));
            }
        };
    }
}
