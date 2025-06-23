package com.baidu.navisdk.ugc.replenishdetails;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes8.dex */
public class UgcReplenishDetailsTipsLayout extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    private ImageView f8232a;
    View b;
    private TextView c;
    private TextView d;
    private TextView e;
    private String f;
    private int g;
    private String h;
    private com.baidu.navisdk.ugc.report.data.datastatus.a i;
    private boolean j;
    private c k;
    private d l;
    int m;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (UgcReplenishDetailsTipsLayout.this.k != null) {
                UgcReplenishDetailsTipsLayout.this.k.a(UgcReplenishDetailsTipsLayout.this.f, UgcReplenishDetailsTipsLayout.this.g);
            }
            com.baidu.navisdk.util.statistic.userop.b.r().a("e.1.3", UgcReplenishDetailsTipsLayout.this.m + "", "2", null);
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (UgcReplenishDetailsTipsLayout.this.j) {
                if (UgcReplenishDetailsTipsLayout.this.k != null) {
                    UgcReplenishDetailsTipsLayout.this.k.a(UgcReplenishDetailsTipsLayout.this.f, UgcReplenishDetailsTipsLayout.this.g, UgcReplenishDetailsTipsLayout.this.h);
                }
                com.baidu.navisdk.util.statistic.userop.b.r().a("e.1.3", UgcReplenishDetailsTipsLayout.this.m + "", "1", null);
                return;
            }
            if (UgcReplenishDetailsTipsLayout.this.l != null) {
                UgcReplenishDetailsTipsLayout.this.l.a(UgcReplenishDetailsTipsLayout.this.f, UgcReplenishDetailsTipsLayout.this.i);
            }
            com.baidu.navisdk.util.statistic.userop.b.r().a("e.1.1", UgcReplenishDetailsTipsLayout.this.m + "", "2", null);
        }
    }

    /* loaded from: classes8.dex */
    public interface c {
        void a(String str, int i);

        void a(String str, int i, String str2);
    }

    /* loaded from: classes8.dex */
    public interface d {
        void a(String str, com.baidu.navisdk.ugc.report.data.datastatus.a aVar);
    }

    public UgcReplenishDetailsTipsLayout(Context context) {
        super(context);
        a(context);
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        c();
    }

    private void a(Context context) {
        setOrientation(1);
        JarUtils.inflate(context, R.layout.nsdk_ugc_replenish_details_tips_layout, this);
        c();
    }

    private void c() {
        if (this.f8232a == null) {
            this.f8232a = (ImageView) findViewById(R.id.ugc_replenish_event_icon);
            this.b = findViewById(R.id.ugc_replenish_layout);
            this.c = (TextView) findViewById(R.id.ugc_replenish_event_hints);
            this.d = (TextView) findViewById(R.id.ugc_replenish_event_verify);
            this.e = (TextView) findViewById(R.id.ugc_replenish_event_add);
        }
    }

    public void b() {
        TextView textView = this.e;
        if (textView != null) {
            textView.setVisibility(8);
            this.e.setOnClickListener(null);
        }
        TextView textView2 = this.d;
        if (textView2 != null) {
            textView2.setVisibility(8);
            this.d.setOnClickListener(null);
        }
        TextView textView3 = this.c;
        if (textView3 != null) {
            textView3.setText(R.string.nsdk_string_ugc_event_offline_hint);
        }
        this.f = null;
        this.i = null;
    }

    public UgcReplenishDetailsTipsLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public UgcReplenishDetailsTipsLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    public void a(String str, com.baidu.navisdk.ugc.report.data.datastatus.a aVar, int i, String str2, d dVar, int i2) {
        this.j = false;
        this.f = str;
        this.i = aVar;
        this.l = dVar;
        this.m = i2;
        a(i, str2, false, R.string.nsdk_string_ugc_event_replenish_details);
        com.baidu.navisdk.util.statistic.userop.b.r().a("e.1.1", i2 + "", "1", null);
    }

    public void a(String str, int i, int i2, String str2, String str3, c cVar, int i3) {
        this.j = true;
        this.f = str;
        this.g = i;
        this.h = str2;
        this.k = cVar;
        this.m = i3;
        a(i2, str3, true, R.string.nsdk_string_ugc_event_replenish_progress);
        com.baidu.navisdk.util.statistic.userop.b.r().a("e.1.3", i3 + "", "4", null);
    }

    private void a(int i, String str, boolean z, @StringRes int i2) {
        g gVar = g.UGC;
        if (gVar.d()) {
            gVar.e("UgcModule_ReplenishUI", "showReplenishDetailsTips: ");
        }
        if (TextUtils.isEmpty(str)) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        ImageView imageView = this.f8232a;
        if (imageView != null) {
            if (i <= 0) {
                imageView.setVisibility(8);
            } else {
                imageView.setImageResource(i);
            }
        }
        TextView textView = this.c;
        if (textView != null) {
            textView.setText(str);
        }
        TextView textView2 = this.d;
        if (textView2 != null) {
            textView2.setVisibility(z ? 0 : 8);
            if (z) {
                this.d.setOnClickListener(new a());
            }
        }
        TextView textView3 = this.e;
        if (textView3 != null) {
            textView3.setText(i2);
            if (!z) {
                a(this.b);
            } else {
                a(this.e);
            }
        }
    }

    private void a(View view) {
        view.setOnClickListener(new b());
    }

    public void a() {
        this.f = null;
        this.i = null;
        this.k = null;
        this.l = null;
    }
}
