package com.baidu.navisdk.util.drivertool.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.common.s;
import com.baidu.navisdk.util.jar.JarUtils;
import java.io.IOException;
import java.util.List;

/* loaded from: classes8.dex */
public class b extends Dialog {

    /* renamed from: a, reason: collision with root package name */
    private Spinner f9287a;
    private EditText b;
    private Spinner c;
    private Spinner d;
    private Spinner e;
    private Button f;
    private Button g;
    private Button h;
    private TextView i;
    private Button j;
    private LinearLayout k;
    private int l;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.navisdk.ui.util.g.a(1500L)) {
                return;
            }
            com.baidu.navisdk.util.drivertool.b.n().t = "1";
            com.baidu.navisdk.util.drivertool.b.n().a();
        }
    }

    /* renamed from: com.baidu.navisdk.util.drivertool.view.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0498b implements AdapterView.OnItemSelectedListener {
        public C0498b() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            com.baidu.navisdk.util.drivertool.model.a h = com.baidu.navisdk.util.drivertool.b.n().h();
            List<String> list = com.baidu.navisdk.util.drivertool.b.n().j;
            if (list != null) {
                h.d = list.get(i).trim();
                if (!com.baidu.navisdk.util.drivertool.b.n().a(h.d)) {
                    b.this.b(false);
                } else {
                    b.this.b(true);
                }
                if ("-  -  -  -  -  -  -  -  -  -  -  -  -  -  -".equals(h.d)) {
                    com.baidu.navisdk.util.drivertool.b.n().E = false;
                } else if (com.baidu.navisdk.util.drivertool.b.n().G) {
                    if (com.baidu.navisdk.util.drivertool.a.c().f9263a.size() <= 0) {
                        com.baidu.navisdk.util.drivertool.b.n().E = false;
                    } else {
                        com.baidu.navisdk.util.drivertool.b.n().E = true;
                    }
                } else {
                    com.baidu.navisdk.util.drivertool.b.n().E = true;
                }
                if (com.baidu.navisdk.util.drivertool.b.n().E) {
                    b.this.a(true);
                } else {
                    b.this.a(false);
                }
            }
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* loaded from: classes8.dex */
    public class c implements AdapterView.OnItemSelectedListener {
        public c() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            com.baidu.navisdk.util.drivertool.model.a h = com.baidu.navisdk.util.drivertool.b.n().h();
            if (com.baidu.navisdk.util.drivertool.c.g[i].equals("-  -  -  -  -  -  -  -  -  -  -  -  -  -  -")) {
                h.g = null;
                return;
            }
            int i2 = i - 1;
            h.g = String.valueOf(i2);
            com.baidu.navisdk.util.drivertool.b.n().c(i2);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* loaded from: classes8.dex */
    public class d implements AdapterView.OnItemSelectedListener {
        public d() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            com.baidu.navisdk.util.drivertool.model.a h = com.baidu.navisdk.util.drivertool.b.n().h();
            List<String> list = com.baidu.navisdk.util.drivertool.b.n().k;
            if (list != null && list.size() > 0) {
                String str = list.get(i);
                if (str != null && str.equals("-  -  -  -  -  -  -  -  -  -  -  -  -  -  -")) {
                    h.h = null;
                } else {
                    h.h = com.baidu.navisdk.util.drivertool.b.n().n.get(str);
                }
            }
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* loaded from: classes8.dex */
    public class e implements AdapterView.OnItemSelectedListener {
        public e() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            com.baidu.navisdk.util.drivertool.model.a h = com.baidu.navisdk.util.drivertool.b.n().h();
            if (com.baidu.navisdk.util.drivertool.c.h[i].equals("-  -  -  -  -  -  -  -  -  -  -  -  -  -  -")) {
                h.i = null;
            } else {
                h.i = String.valueOf(i - 1);
            }
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* loaded from: classes8.dex */
    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.navisdk.util.drivertool.a.c().b();
        }
    }

    /* loaded from: classes8.dex */
    public class g implements View.OnClickListener {

        /* loaded from: classes8.dex */
        public class a extends com.baidu.navisdk.util.worker.f<String, String> {

            /* renamed from: com.baidu.navisdk.util.drivertool.view.b$g$a$a, reason: collision with other inner class name */
            /* loaded from: classes8.dex */
            public class C0499a extends com.baidu.navisdk.util.worker.f<String, String> {
                public C0499a(String str, String str2) {
                    super(str, str2);
                }

                @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
                public String execute() {
                    b.this.dismiss();
                    com.baidu.navisdk.util.drivertool.b.n().a(true);
                    b.this.a(false);
                    return null;
                }
            }

            public a(String str, String str2) {
                super(str, str2);
            }

            @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
            public String execute() {
                if (b.this.l == 3) {
                    com.baidu.navisdk.util.drivertool.e.p = true;
                    com.baidu.navisdk.util.drivertool.e.l().d();
                }
                com.baidu.navisdk.util.drivertool.b.n().h().f = b.this.b.getText().toString().trim();
                if (!b.this.d.isEnabled()) {
                    com.baidu.navisdk.util.drivertool.model.a h = com.baidu.navisdk.util.drivertool.b.n().h();
                    h.g = null;
                    h.h = null;
                    h.i = null;
                }
                if (b.this.l == 4) {
                    com.baidu.navisdk.util.drivertool.a.c().a(b.this.l);
                } else {
                    com.baidu.navisdk.util.drivertool.b.n().b(b.this.l);
                }
                com.baidu.navisdk.util.drivertool.b.n().f();
                com.baidu.navisdk.util.drivertool.a.c().f9263a.clear();
                if (com.baidu.navisdk.util.drivertool.e.l().i != null) {
                    try {
                        s.a(com.baidu.navisdk.util.drivertool.e.l().i);
                    } catch (IOException unused) {
                    }
                }
                if (b.this.l == 3) {
                    com.baidu.navisdk.util.drivertool.e.p = false;
                    return null;
                }
                com.baidu.navisdk.util.worker.c.a().a((com.baidu.navisdk.util.worker.f) new C0499a("InitListener-" + a.class.getSimpleName(), null), new com.baidu.navisdk.util.worker.e(99, 0));
                return null;
            }
        }

        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.navisdk.util.worker.c.a().c(new a(g.class.getSimpleName(), null), new com.baidu.navisdk.util.worker.e(99, 0));
            if (b.this.l == 3) {
                b.this.dismiss();
                com.baidu.navisdk.util.drivertool.b.n().a(true);
                b.this.a(false);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h implements View.OnClickListener {
        public h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.dismiss();
        }
    }

    public b(Activity activity, int i) {
        super(activity, R.style.BNDialog);
        this.l = i;
        View inflate = JarUtils.inflate(activity, R.layout.nsdk_layout_driving_tool_issue_store, null);
        setContentView(inflate);
        this.f9287a = (Spinner) inflate.findViewById(R.id.issue_id_sp);
        this.b = (EditText) inflate.findViewById(R.id.issue_desp_et);
        this.c = (Spinner) inflate.findViewById(R.id.issue_type_sp);
        this.d = (Spinner) inflate.findViewById(R.id.responsible_pm_sp);
        this.e = (Spinner) inflate.findViewById(R.id.current_state_sp);
        this.f = (Button) inflate.findViewById(R.id.create_issue_btn);
        this.g = (Button) inflate.findViewById(R.id.store_btn);
        this.h = (Button) inflate.findViewById(R.id.add_attch_btn);
        this.i = (TextView) inflate.findViewById(R.id.select_picture_tx);
        this.j = (Button) inflate.findViewById(R.id.cancel_btn);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.add_attach_ll);
        this.k = linearLayout;
        if (this.l != 4) {
            linearLayout.setVisibility(8);
        }
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = (ScreenUtil.getInstance().getWidthPixels() / 34) * 31;
        if (i == 4) {
            attributes.height = (ScreenUtil.getInstance().getHeightPixels() / 45) * 27;
        } else {
            attributes.height = (ScreenUtil.getInstance().getHeightPixels() / 40) * 21;
        }
        attributes.gravity = 17;
        window.setAttributes(attributes);
        window.setGravity(17);
        a(false);
        e();
        d();
    }

    private void d() {
        if ("0".equals(com.baidu.navisdk.util.drivertool.b.n().s)) {
            com.baidu.navisdk.util.drivertool.b.n().t = "0";
        } else {
            com.baidu.navisdk.util.drivertool.b.n().t = "0";
            com.baidu.navisdk.util.drivertool.b.n().s = "0";
        }
        if (this.l == 4) {
            com.baidu.navisdk.util.drivertool.b.n().t = "1";
        }
        com.baidu.navisdk.util.drivertool.b.n().a();
        com.baidu.navisdk.util.drivertool.b.n().b();
        String str = com.baidu.navisdk.util.drivertool.b.n().h().l;
        if (str == null || str.length() == 0) {
            String.valueOf(System.currentTimeMillis());
        }
        Context a2 = com.baidu.navisdk.framework.a.c().a();
        if (a2 == null) {
            return;
        }
        if (this.c != null) {
            ArrayAdapter arrayAdapter = new ArrayAdapter(a2, android.R.layout.simple_spinner_item, com.baidu.navisdk.util.drivertool.c.g);
            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            this.c.setAdapter((SpinnerAdapter) arrayAdapter);
        }
        if (this.e != null) {
            ArrayAdapter arrayAdapter2 = new ArrayAdapter(a2, android.R.layout.simple_spinner_item, com.baidu.navisdk.util.drivertool.c.h);
            arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            this.e.setAdapter((SpinnerAdapter) arrayAdapter2);
        }
    }

    private void e() {
        Button button = this.f;
        if (button != null) {
            button.setOnClickListener(new a());
        }
        Spinner spinner = this.f9287a;
        if (spinner != null) {
            spinner.setOnItemSelectedListener(new C0498b());
        }
        if (this.b != null) {
            com.baidu.navisdk.util.drivertool.b.n().h().f = this.b.getText().toString().trim();
        }
        Spinner spinner2 = this.c;
        if (spinner2 != null) {
            spinner2.setOnItemSelectedListener(new c());
        }
        Spinner spinner3 = this.d;
        if (spinner3 != null) {
            spinner3.setOnItemSelectedListener(new d());
        }
        Spinner spinner4 = this.e;
        if (spinner4 != null) {
            spinner4.setOnItemSelectedListener(new e());
        }
        Button button2 = this.h;
        if (button2 != null) {
            button2.setOnClickListener(new f());
        }
        Button button3 = this.g;
        if (button3 != null) {
            button3.setOnClickListener(new g());
        }
        Button button4 = this.j;
        if (button4 != null) {
            button4.setOnClickListener(new h());
        }
    }

    public void a() {
        List<String> list;
        if (this.f9287a == null || (list = com.baidu.navisdk.util.drivertool.b.n().j) == null) {
            return;
        }
        ArrayAdapter arrayAdapter = new ArrayAdapter(com.baidu.navisdk.framework.a.c().a(), android.R.layout.simple_spinner_item, list);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.f9287a.setAdapter((SpinnerAdapter) arrayAdapter);
        if (com.baidu.navisdk.util.drivertool.b.n().j == null || com.baidu.navisdk.util.drivertool.b.n().j.size() <= 0 || !com.baidu.navisdk.util.drivertool.b.n().t.equals("1")) {
            return;
        }
        int size = com.baidu.navisdk.util.drivertool.b.n().j.size() - 1;
        this.f9287a.setSelection(size, true);
        LogUtil.e("drivingTool", "set new create issue selcetion " + com.baidu.navisdk.util.drivertool.b.n().j.get(size));
    }

    public void b(boolean z) {
        Spinner spinner = this.c;
        if (spinner != null) {
            spinner.setEnabled(z);
        }
        Spinner spinner2 = this.e;
        if (spinner2 != null) {
            spinner2.setEnabled(z);
        }
        Spinner spinner3 = this.d;
        if (spinner3 != null) {
            spinner3.setEnabled(z);
        }
    }

    public void c() {
        List<String> list;
        Context a2;
        if (this.d == null || (list = com.baidu.navisdk.util.drivertool.b.n().k) == null || (a2 = com.baidu.navisdk.framework.a.c().a()) == null) {
            return;
        }
        ArrayAdapter arrayAdapter = new ArrayAdapter(a2, android.R.layout.simple_spinner_item, list);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.d.setAdapter((SpinnerAdapter) arrayAdapter);
    }

    public void b() {
        Spinner spinner = this.e;
        if (spinner != null) {
            spinner.setSelection(1);
        }
    }

    public void a(boolean z) {
        Button button = this.g;
        if (button == null) {
            return;
        }
        if (z) {
            button.setBackgroundColor(-16711936);
        } else {
            button.setBackgroundColor(-7829368);
        }
        this.g.setClickable(z);
    }
}
