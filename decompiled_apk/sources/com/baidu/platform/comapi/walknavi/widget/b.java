package com.baidu.platform.comapi.walknavi.widget;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.R;

/* loaded from: classes8.dex */
public class b extends Dialog {

    /* renamed from: a, reason: collision with root package name */
    private TextView f9884a;
    private TextView b;
    private TextView c;
    private TextView d;
    private LinearLayout e;
    private LinearLayout f;
    private a g;
    private a h;
    private boolean i;
    private boolean j;

    /* loaded from: classes8.dex */
    public interface a {
        void a();
    }

    public b(Context context, int i) {
        super(context);
    }

    public b c(String str) {
        if (str == null) {
            this.i = false;
            this.c.setText("", TextView.BufferType.SPANNABLE);
        } else {
            this.i = true;
            this.c.setText(str, TextView.BufferType.SPANNABLE);
        }
        d();
        return this;
    }

    public b d(String str) {
        if (str == null) {
            this.j = false;
            this.d.setText("", TextView.BufferType.SPANNABLE);
        } else {
            this.j = true;
            this.d.setText(str, TextView.BufferType.SPANNABLE);
        }
        d();
        return this;
    }

    public b(Context context) {
        super(context);
    }

    public b a(String str) {
        if (str == null) {
            this.b.setVisibility(8);
            this.b.setText("", TextView.BufferType.SPANNABLE);
        } else {
            this.b.setVisibility(0);
            this.b.setText(str, TextView.BufferType.SPANNABLE);
        }
        return this;
    }

    public b b(String str) {
        if (str == null) {
            this.f9884a.setVisibility(8);
            this.f9884a.setText("", TextView.BufferType.SPANNABLE);
        } else {
            this.f9884a.setVisibility(0);
            this.f9884a.setText(str, TextView.BufferType.SPANNABLE);
        }
        return this;
    }

    public b(Activity activity) {
        this(activity, R.style.WNaviDialog);
        View a2 = com.baidu.platform.comapi.wnplatform.p.a.a.a(activity, R.layout.wsdk_layout_common_dialog, null);
        requestWindowFeature(1);
        if (getWindow() != null) {
            getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
        setContentView(a2);
        this.f9884a = (TextView) a2.findViewById(R.id.title_bar);
        this.b = (TextView) a2.findViewById(R.id.content_message);
        this.c = (TextView) a2.findViewById(R.id.first_btn);
        this.d = (TextView) a2.findViewById(R.id.second_btn);
        this.e = (LinearLayout) a2.findViewById(R.id.left_div);
        this.f = (LinearLayout) a2.findViewById(R.id.right_div);
        this.c.setOnClickListener(new c(this));
        this.d.setOnClickListener(new d(this));
        this.i = false;
        this.j = false;
        this.f9884a.setVisibility(8);
        this.b.setVisibility(8);
        this.c.setVisibility(8);
        this.d.setVisibility(8);
        this.e.setVisibility(8);
        this.f.setVisibility(8);
        setCanceledOnTouchOutside(false);
    }

    private void d() {
        if (!this.i) {
            this.c.setVisibility(8);
            this.d.setVisibility(8);
            this.e.setVisibility(8);
            this.f.setVisibility(8);
            return;
        }
        if (!this.j) {
            this.c.setVisibility(0);
            this.d.setVisibility(8);
            this.e.setVisibility(8);
            this.f.setVisibility(8);
            return;
        }
        this.c.setVisibility(0);
        this.d.setVisibility(0);
        this.e.setVisibility(8);
        this.f.setVisibility(8);
    }

    public b a() {
        this.c.setTextColor(-12352272);
        return this;
    }

    public b b() {
        this.d.setTextColor(-12352272);
        return this;
    }

    public TextView c() {
        return this.d;
    }

    public b a(a aVar) {
        this.g = aVar;
        return this;
    }

    public b b(a aVar) {
        this.h = aVar;
        return this;
    }

    public b a(boolean z) {
        super.setCancelable(z);
        return this;
    }
}
