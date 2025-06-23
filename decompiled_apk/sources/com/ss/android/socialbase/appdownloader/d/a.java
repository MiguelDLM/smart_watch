package com.ss.android.socialbase.appdownloader.d;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import com.ss.android.socialbase.appdownloader.c.k;
import com.ss.android.socialbase.appdownloader.c.l;

/* loaded from: classes13.dex */
public class a extends com.ss.android.socialbase.appdownloader.c.b {

    /* renamed from: a, reason: collision with root package name */
    private AlertDialog.Builder f26170a;

    /* renamed from: com.ss.android.socialbase.appdownloader.d.a$a, reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public static class C1051a implements k {

        /* renamed from: a, reason: collision with root package name */
        private AlertDialog f26171a;

        public C1051a(AlertDialog.Builder builder) {
            if (builder != null) {
                this.f26171a = builder.show();
            }
        }

        @Override // com.ss.android.socialbase.appdownloader.c.k
        public void a() {
            AlertDialog alertDialog = this.f26171a;
            if (alertDialog != null) {
                alertDialog.show();
            }
        }

        @Override // com.ss.android.socialbase.appdownloader.c.k
        public boolean b() {
            AlertDialog alertDialog = this.f26171a;
            if (alertDialog != null) {
                return alertDialog.isShowing();
            }
            return false;
        }
    }

    public a(Context context) {
        this.f26170a = new AlertDialog.Builder(context);
    }

    @Override // com.ss.android.socialbase.appdownloader.c.l
    public l a(int i) {
        AlertDialog.Builder builder = this.f26170a;
        if (builder != null) {
            builder.setTitle(i);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.c.l
    public l b(int i, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = this.f26170a;
        if (builder != null) {
            builder.setNegativeButton(i, onClickListener);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.c.l
    public l a(String str) {
        AlertDialog.Builder builder = this.f26170a;
        if (builder != null) {
            builder.setMessage(str);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.c.l
    public l a(int i, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = this.f26170a;
        if (builder != null) {
            builder.setPositiveButton(i, onClickListener);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.c.l
    public l a(DialogInterface.OnCancelListener onCancelListener) {
        AlertDialog.Builder builder = this.f26170a;
        if (builder != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.c.l
    public k a() {
        return new C1051a(this.f26170a);
    }
}
