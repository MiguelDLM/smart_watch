package com.baidu.navisdk.ugc.report.ui.innavi.sub;

import OoOoXO0.xoXoI;
import android.graphics.Color;
import android.graphics.RectF;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ugc.report.ui.widget.UgcCustomLinearScrollView;
import com.baidu.navisdk.util.common.g;

/* loaded from: classes8.dex */
public class d extends com.baidu.navisdk.ugc.report.ui.innavi.sub.b {
    private View o;
    private View p;
    private View q;
    private com.baidu.navisdk.ugc.report.ui.innavi.sub.a r;
    private Button s;
    private Button t;
    private UgcCustomLinearScrollView u;
    private TextView v;
    private boolean w;
    private int x;
    private View.OnClickListener y;
    private View.OnTouchListener z;

    /* loaded from: classes8.dex */
    public class a implements UgcCustomLinearScrollView.a {
        public a() {
        }

        @Override // com.baidu.navisdk.ugc.report.ui.widget.UgcCustomLinearScrollView.a
        public void onEventCatch(MotionEvent motionEvent) {
            if (d.this.r != null) {
                d.this.r.a(motionEvent);
            }
            d.this.b(0, true);
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.this.r == null) {
                return;
            }
            int id = view.getId();
            if (id == R.id.ugc_navi_sub_upload_btn) {
                g gVar = g.UGC;
                if (gVar.e()) {
                    gVar.g("UgcModuleUgcReportNaviSubDetailV", "onClick 立即上报");
                }
                d.this.r.c(false);
                return;
            }
            if (id == R.id.ugc_navi_sub_upload_cancle_btn) {
                d.this.r.A();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements View.OnTouchListener {
        public c() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (view.getId() == R.id.ugc_navi_sub_upload_cancle_btn) {
                d.this.a("3385ff", view, motionEvent);
                return false;
            }
            return false;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public d(android.content.Context r3, int r4, int r5) {
        /*
            r2 = this;
            r0 = 4
            r1 = 0
            if (r5 != r0) goto L6
            r0 = 1
            goto L7
        L6:
            r0 = 0
        L7:
            r2.<init>(r3, r4, r0)
            r3 = 0
            r2.o = r3
            r2.p = r3
            r2.q = r3
            r2.r = r3
            r2.s = r3
            r2.t = r3
            r2.u = r3
            r2.w = r1
            com.baidu.navisdk.ugc.report.ui.innavi.sub.d$b r3 = new com.baidu.navisdk.ugc.report.ui.innavi.sub.d$b
            r3.<init>()
            r2.y = r3
            com.baidu.navisdk.ugc.report.ui.innavi.sub.d$c r3 = new com.baidu.navisdk.ugc.report.ui.innavi.sub.d$c
            r3.<init>()
            r2.z = r3
            r2.x = r5
            r2.e(r4)
            r2.k()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.ugc.report.ui.innavi.sub.d.<init>(android.content.Context, int, int):void");
    }

    private void e(int i) {
        View view;
        View view2 = this.f8270a;
        if (view2 == null) {
            return;
        }
        this.o = view2.findViewById(R.id.ugc_navi_sub_upload_spacing);
        this.p = this.f8270a.findViewById(R.id.ugc_navi_sub_upload_layout);
        this.q = this.f8270a.findViewById(R.id.ugc_navi_sub_fade_layer);
        this.v = (TextView) this.f8270a.findViewById(R.id.ugc_sub_title_position_info_tv);
        if (this.o != null && (view = this.p) != null && this.q != null) {
            view.setVisibility(0);
            this.q.setVisibility(0);
            this.o.setVisibility(8);
        }
        this.s = (Button) this.f8270a.findViewById(R.id.ugc_navi_sub_upload_btn);
        this.t = (Button) this.f8270a.findViewById(R.id.ugc_navi_sub_upload_cancle_btn);
        this.u = (UgcCustomLinearScrollView) this.f8270a.findViewById(R.id.ugc_sub_main_content_layout);
        int i2 = this.x;
        if (i2 != 3 && i2 != 2) {
            this.s.setText("立即上报");
        } else {
            this.s.setText("立即补充");
        }
    }

    private void k() {
        Button button = this.s;
        if (button != null) {
            button.setOnClickListener(this.y);
        }
        Button button2 = this.t;
        if (button2 != null) {
            button2.setOnClickListener(this.y);
            this.t.setOnTouchListener(this.z);
        }
        UgcCustomLinearScrollView ugcCustomLinearScrollView = this.u;
        if (ugcCustomLinearScrollView != null) {
            ugcCustomLinearScrollView.setOnEventCatchListener(new a());
        }
    }

    @Override // com.baidu.navisdk.ugc.report.ui.innavi.sub.b
    public void b(int i) {
        b(i, false);
    }

    @Override // com.baidu.navisdk.ugc.report.ui.d, com.baidu.navisdk.ugc.report.b
    public void g() {
        super.g();
    }

    @Override // com.baidu.navisdk.ugc.report.ui.innavi.sub.b
    public boolean j() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z) {
        g gVar = g.UGC;
        if (gVar.d()) {
            gVar.e("UgcModuleUgcReportNaviSubDetailV", "updateCountDownView: " + i + ", isStopTimer:" + z);
        }
        int i2 = this.x;
        if (i2 != 4 && i2 != 1) {
            Button button = this.t;
            if (button != null) {
                if (z) {
                    button.setText("取消");
                    return;
                }
                button.setText("取消 (" + i + "s)");
                return;
            }
            return;
        }
        Button button2 = this.s;
        if (button2 != null) {
            if (z) {
                button2.setText("立即上报");
                return;
            }
            button2.setText("立即上报 (" + i + "s)");
        }
    }

    @Override // com.baidu.navisdk.ugc.report.b
    public void a(com.baidu.navisdk.ugc.report.ui.a aVar) {
        super.a(aVar);
        this.r = (com.baidu.navisdk.ugc.report.ui.innavi.sub.a) aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, View view, MotionEvent motionEvent) {
        if (view == null) {
            return;
        }
        RectF a2 = a(view);
        if (motionEvent.getAction() == 0) {
            this.w = false;
            ((Button) view).setTextColor(Color.parseColor("#66" + str));
            return;
        }
        if (motionEvent.getAction() == 2) {
            if (a(a2, motionEvent) && !this.w) {
                ((Button) view).setTextColor(Color.parseColor("#66" + str));
                return;
            }
            this.w = true;
            ((Button) view).setTextColor(Color.parseColor(xoXoI.f2670oxoX + str));
            return;
        }
        ((Button) view).setTextColor(Color.parseColor(xoXoI.f2670oxoX + str));
    }

    private boolean a(RectF rectF, MotionEvent motionEvent) {
        if (motionEvent == null) {
            return false;
        }
        return rectF.contains(motionEvent.getRawX(), motionEvent.getRawY());
    }

    private RectF a(View view) {
        int[] iArr = new int[2];
        if (view == null) {
            return new RectF();
        }
        view.getLocationOnScreen(iArr);
        return new RectF(iArr[0], iArr[1], r2 + view.getWidth(), iArr[1] + view.getHeight());
    }

    @Override // com.baidu.navisdk.ugc.report.ui.d, com.baidu.navisdk.ugc.report.ui.b
    public void a(String str, String str2) {
        TextView textView = this.v;
        if (textView != null) {
            if (TextUtils.isEmpty(str)) {
                str = "地图上的点";
            }
            textView.setText(str);
        }
    }
}
