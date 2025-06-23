package com.baidu.navisdk.ugc.report.ui.innavi.verifyevent;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ugc.report.ui.innavi.main.c;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes8.dex */
public class a implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    private c f8307a;
    private String b;
    private int c;
    private int d;
    private String e;
    private String f;
    private int g;

    public a(c cVar, b bVar) {
        this.f8307a = cVar;
        this.b = bVar.f8308a;
        this.c = bVar.b;
        this.d = bVar.d;
        this.e = bVar.e;
        this.f = bVar.c;
    }

    public View a(Context context) {
        View inflate = JarUtils.inflate(context, R.layout.nsdk_layout_ugc_event_passer_verify_layout, null);
        if (inflate == null) {
            return null;
        }
        inflate.findViewById(R.id.ugc_event_verify_no_exist_btn).setOnClickListener(this);
        inflate.findViewById(R.id.ugc_event_verify_exist_btn).setOnClickListener(this);
        inflate.findViewById(R.id.ugc_event_verify_add_progress_btn).setOnClickListener(this);
        if (this.d > 0) {
            ((ImageView) inflate.findViewById(R.id.ugc_sub_title_iv)).setImageResource(this.d);
        }
        if (!TextUtils.isEmpty(this.f)) {
            ((TextView) inflate.findViewById(R.id.ugc_sub_title_type_tv)).setText(this.f + "是否存在");
        }
        TextView textView = (TextView) inflate.findViewById(R.id.ugc_verify_event_address);
        if (TextUtils.isEmpty(this.e)) {
            textView.setVisibility(8);
        } else {
            textView.setText(this.e);
            textView.setVisibility(0);
        }
        return inflate;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f8307a == null) {
            return;
        }
        int id = view.getId();
        if (id == R.id.ugc_event_verify_add_progress_btn) {
            this.f8307a.a(this.b, this.c, 2);
            com.baidu.navisdk.util.statistic.userop.b.r().a("e.1.4", this.g + "", "4", null);
            return;
        }
        if (id == R.id.ugc_event_verify_no_exist_btn) {
            this.f8307a.a(this.b, this.c, 0);
            com.baidu.navisdk.util.statistic.userop.b.r().a("e.1.4", this.g + "", "2", null);
            return;
        }
        if (id == R.id.ugc_event_verify_exist_btn) {
            this.f8307a.a(this.b, this.c, 1);
            com.baidu.navisdk.util.statistic.userop.b.r().a("e.1.4", this.g + "", "3", null);
        }
    }

    public void a(int i) {
        this.g = i;
    }

    public void a() {
        this.f8307a = null;
    }
}
