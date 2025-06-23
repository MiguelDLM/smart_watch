package com.ss.android.downloadlib.addownload.a;

import android.app.Activity;
import android.app.Dialog;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.R;

/* loaded from: classes11.dex */
public class e extends Dialog {

    /* renamed from: a, reason: collision with root package name */
    private TextView f25957a;
    private TextView b;
    private TextView c;
    private TextView d;
    private d e;
    private c f;
    private boolean g;
    private boolean h;
    private Activity i;
    private String j;
    private String k;
    private String l;
    private String m;

    /* loaded from: classes11.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private Activity f25961a;
        private String b;
        private String c;
        private String d;
        private String e;
        private boolean f;
        private d g;
        private c h;

        public a(Activity activity) {
            this.f25961a = activity;
        }

        public a a(String str) {
            this.b = str;
            return this;
        }

        public a b(String str) {
            this.c = str;
            return this;
        }

        public a c(String str) {
            this.d = str;
            return this;
        }

        public a d(String str) {
            this.e = str;
            return this;
        }

        public a a(boolean z) {
            this.f = z;
            return this;
        }

        public a a(d dVar) {
            this.g = dVar;
            return this;
        }

        public a a(c cVar) {
            this.h = cVar;
            return this;
        }

        public e a() {
            return new e(this.f25961a, this.b, this.c, this.d, this.e, this.f, this.g, this.h);
        }
    }

    public e(@NonNull Activity activity, String str, String str2, String str3, String str4, boolean z, @NonNull d dVar, c cVar) {
        super(activity, R.style.ttdownloader_translucent_dialog);
        this.i = activity;
        this.e = dVar;
        this.j = str;
        this.k = str2;
        this.l = str3;
        this.m = str4;
        this.f = cVar;
        setCanceledOnTouchOutside(z);
        d();
    }

    private void d() {
        setContentView(LayoutInflater.from(this.i.getApplicationContext()).inflate(a(), (ViewGroup) null));
        this.f25957a = (TextView) findViewById(b());
        this.b = (TextView) findViewById(c());
        this.c = (TextView) findViewById(R.id.message_tv);
        this.d = (TextView) findViewById(R.id.delete_tv);
        if (!TextUtils.isEmpty(this.k)) {
            this.f25957a.setText(this.k);
        }
        if (!TextUtils.isEmpty(this.l)) {
            this.b.setText(this.l);
        }
        if (!TextUtils.isEmpty(this.m)) {
            this.d.setText(this.m);
        } else {
            this.d.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.j)) {
            this.c.setText(this.j);
        }
        this.f25957a.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.a.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.e();
            }
        });
        this.b.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.a.e.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.g();
            }
        });
        this.d.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.a.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.f();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.g = true;
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.h = true;
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        dismiss();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        if (!this.i.isFinishing()) {
            this.i.finish();
        }
        if (this.g) {
            this.e.a();
        } else if (this.h) {
            this.f.a();
        } else {
            this.e.b();
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchKeyEvent(@NonNull KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public int a() {
        return R.layout.ttdownloader_dialog_select_operation;
    }

    public int b() {
        return R.id.confirm_tv;
    }

    public int c() {
        return R.id.cancel_tv;
    }
}
