package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.util.common.LogUtil;

/* loaded from: classes8.dex */
public class c0 extends com.baidu.navisdk.ui.routeguide.widget.d {
    private RelativeLayout i;
    private ImageView j;
    private TextView k;
    private RelativeLayout l;
    private ImageView m;
    private TextView n;
    private boolean o;
    private int p;
    private boolean q;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (((com.baidu.navisdk.ui.routeguide.widget.d) c0.this).c == null) {
                LogUtil.e("RGMMMainAuxiliaryBridgeView", "mRLMASwitch mSubViewListener == null");
                return;
            }
            if (com.baidu.navisdk.ui.util.g.a()) {
                LogUtil.e("RGMMMainAuxiliaryBridgeView", "mRLMASwitch isFastDoubleClick");
                return;
            }
            if (com.baidu.navisdk.ui.routeguide.control.x.b().l2()) {
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("RGMMMainAuxiliaryBridgeView", "mRLMASwitch isInterceptRecalRouteForVdrGuide");
                    return;
                }
                return;
            }
            if (c0.this.o) {
                c0 c0Var = c0.this;
                int d = c0Var.d(c0Var.p, c0.this.i.getId());
                LogUtil.e("RGMMMainAuxiliaryBridgeView", "mRLMASwitch isBothShow clickedType = " + d + ", mCurrentType = " + c0.this.p);
                if (d == 1) {
                    com.baidu.navisdk.util.statistic.userop.b.r().c("3.v.1.2");
                } else if (d == 2) {
                    com.baidu.navisdk.util.statistic.userop.b.r().c("3.v.2.2");
                }
                if (((com.baidu.navisdk.ui.routeguide.widget.d) c0.this).c != null && d != -1) {
                    ((com.baidu.navisdk.ui.routeguide.widget.d) c0.this).c.a(d);
                }
            } else {
                LogUtil.e("RGMMMainAuxiliaryBridgeView", "mRLMASwitch NotBothShow mCurrentType = " + c0.this.p);
                if (c0.this.p == 1) {
                    com.baidu.navisdk.util.statistic.userop.b.r().c("3.v.1.2");
                } else if (c0.this.p == 2) {
                    com.baidu.navisdk.util.statistic.userop.b.r().c("3.v.2.2");
                }
                if (((com.baidu.navisdk.ui.routeguide.widget.d) c0.this).c != null) {
                    ((com.baidu.navisdk.ui.routeguide.widget.d) c0.this).c.a(c0.this.p);
                }
            }
            c0.this.q = true;
            c0.this.c();
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (((com.baidu.navisdk.ui.routeguide.widget.d) c0.this).c == null) {
                LogUtil.e("RGMMMainAuxiliaryBridgeView", "mRLBridgeSwitch mSubViewListener == null");
                return;
            }
            if (com.baidu.navisdk.ui.util.g.a()) {
                LogUtil.e("RGMMMainAuxiliaryBridgeView", "mRLBridgeSwitch isFastDoubleClick");
                return;
            }
            if (com.baidu.navisdk.ui.routeguide.control.x.b().l2()) {
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("RGMMMainAuxiliaryBridgeView", "mRLBridgeSwitch isInterceptRecalRouteForVdrGuide");
                    return;
                }
                return;
            }
            if (c0.this.o) {
                c0 c0Var = c0.this;
                int d = c0Var.d(c0Var.p, c0.this.l.getId());
                LogUtil.e("RGMMMainAuxiliaryBridgeView", "mRLBridgeSwitch isBothShow clickedType = " + d + ", mCurrentType = " + c0.this.p);
                if (d == 4) {
                    com.baidu.navisdk.util.statistic.userop.b.r().c("3.v.3.2");
                } else if (d == 8) {
                    com.baidu.navisdk.util.statistic.userop.b.r().c("3.v.4.2");
                }
                if (((com.baidu.navisdk.ui.routeguide.widget.d) c0.this).c != null && d != -1) {
                    ((com.baidu.navisdk.ui.routeguide.widget.d) c0.this).c.a(d);
                }
            } else {
                LogUtil.e("RGMMMainAuxiliaryBridgeView", "mRLBridgeSwitch NotBothShow mCurrentType = " + c0.this.p);
                if (c0.this.p == 4) {
                    com.baidu.navisdk.util.statistic.userop.b.r().c("3.v.3.2");
                } else if (c0.this.p == 8) {
                    com.baidu.navisdk.util.statistic.userop.b.r().c("3.v.4.2");
                }
                if (((com.baidu.navisdk.ui.routeguide.widget.d) c0.this).c != null) {
                    ((com.baidu.navisdk.ui.routeguide.widget.d) c0.this).c.a(c0.this.p);
                }
            }
            c0.this.q = true;
            c0.this.c();
        }
    }

    public c0(Context context, ViewGroup viewGroup, com.baidu.navisdk.ui.routeguide.subview.a aVar) {
        super(context, viewGroup, aVar);
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = false;
        this.p = -1;
        p0();
        a(com.baidu.navisdk.ui.util.b.b());
        o0();
    }

    private void o0() {
        RelativeLayout relativeLayout = this.i;
        if (relativeLayout != null && this.l != null) {
            relativeLayout.setOnClickListener(new a());
            this.l.setOnClickListener(new b());
        } else {
            LogUtil.e("RGMMMainAuxiliaryBridgeView", "initListener mRLMASwitch mRLBridgeSwitch is null");
        }
    }

    private void p0() {
        if (this.b == null) {
            return;
        }
        if (1 == com.baidu.navisdk.ui.routeguide.control.x.b().d0()) {
            this.f = 1;
        } else {
            this.f = 2;
        }
        this.i = (RelativeLayout) this.b.findViewById(R.id.bnav_rg_rl_main_auxiliary_switch);
        this.j = (ImageView) this.b.findViewById(R.id.bnav_rg_iv_main_auxiliary_switch);
        this.k = (TextView) this.b.findViewById(R.id.bnav_rg_tv_main_auxiliary_switch);
        this.l = (RelativeLayout) this.b.findViewById(R.id.bnav_rg_rl_bridge_switch);
        this.m = (ImageView) this.b.findViewById(R.id.bnav_rg_iv_bridge_switch);
        this.n = (TextView) this.b.findViewById(R.id.bnav_rg_tv_bridge_switch);
    }

    private void q0() {
        TextView textView = this.k;
        if (textView != null) {
            textView.setText(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_in_auxiliary_road));
        }
        ImageView imageView = this.j;
        if (imageView != null) {
            imageView.setImageDrawable(com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_drawable_switch_auxiliary_road));
        }
        z(true);
        com.baidu.navisdk.util.statistic.userop.b.r().c("3.v.2.1");
    }

    private void r0() {
        TextView textView = this.k;
        if (textView != null) {
            textView.setText(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_in_main_road));
        }
        ImageView imageView = this.j;
        if (imageView != null) {
            imageView.setImageDrawable(com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_drawable_switch_main_road));
        }
        z(true);
        com.baidu.navisdk.util.statistic.userop.b.r().c("3.v.1.1");
    }

    private void s0() {
        TextView textView = this.n;
        if (textView != null) {
            textView.setText(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_on_bridge));
        }
        ImageView imageView = this.m;
        if (imageView != null) {
            imageView.setImageDrawable(com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_drawable_switch_on_bridge));
        }
        y(true);
        com.baidu.navisdk.util.statistic.userop.b.r().c("3.v.3.1");
    }

    private void t0() {
        TextView textView = this.n;
        if (textView != null) {
            textView.setText(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_under_bridge));
        }
        ImageView imageView = this.m;
        if (imageView != null) {
            imageView.setImageDrawable(com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_drawable_switch_under_bridge));
        }
        y(true);
        com.baidu.navisdk.util.statistic.userop.b.r().c("3.v.4.1");
    }

    private void z(boolean z) {
        int i;
        RelativeLayout relativeLayout = this.i;
        if (relativeLayout != null) {
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            relativeLayout.setVisibility(i);
        }
    }

    public void n0() {
    }

    public void v(int i) {
        LogUtil.e("RGMMMainAuxiliaryBridgeView", "peng updateMABView type = " + i);
        if (!BNSettingManager.isMainAuxiliaryOrBridgeEnable()) {
            return;
        }
        if (com.baidu.navisdk.ui.routeguide.model.a0.I().D() && i != 0) {
            LogUtil.e("RGMMMainAuxiliaryBridgeView", "updateMainAuxiliaryBridgeView , isYawing return!");
            return;
        }
        if (i != 0 && com.baidu.navisdk.ui.routeguide.asr.c.n().f()) {
            LogUtil.e("RGMMMainAuxiliaryBridgeView", "updateMainAuxiliaryBridgeView , 语音期间，除了隐藏事件，其他的显示操作全部屏蔽!");
            return;
        }
        this.p = i;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 4) {
                        if (i != 5) {
                            if (i != 6) {
                                if (i != 8) {
                                    if (i != 10) {
                                        c();
                                        this.o = false;
                                        LogUtil.e("RGMMMainAuxiliaryBridgeView", "peng enter default hide");
                                        return;
                                    } else {
                                        c();
                                        t0();
                                        q0();
                                        this.o = true;
                                        return;
                                    }
                                }
                                c();
                                t0();
                                this.o = false;
                                return;
                            }
                            c();
                            s0();
                            q0();
                            this.o = true;
                            return;
                        }
                        c();
                        s0();
                        r0();
                        this.o = true;
                        return;
                    }
                    c();
                    s0();
                    this.o = false;
                    return;
                }
                c();
                q0();
                this.o = false;
                return;
            }
            c();
            r0();
            this.o = false;
            return;
        }
        c();
        this.o = false;
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public boolean y() {
        c();
        super.y();
        z(true);
        y(true);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int d(int r6, int r7) {
        /*
            r5 = this;
            android.widget.RelativeLayout r0 = r5.i
            int r0 = r0.getId()
            r1 = 10
            r2 = 6
            r3 = 5
            if (r7 != r0) goto L17
            if (r6 == r3) goto L15
            if (r6 == r2) goto L13
            if (r6 == r1) goto L13
            goto L17
        L13:
            r0 = 2
            goto L18
        L15:
            r0 = 1
            goto L18
        L17:
            r0 = -1
        L18:
            android.widget.RelativeLayout r4 = r5.l
            int r4 = r4.getId()
            if (r7 != r4) goto L2b
            if (r6 == r3) goto L2a
            if (r6 == r2) goto L2a
            if (r6 == r1) goto L27
            goto L2b
        L27:
            r0 = 8
            goto L2b
        L2a:
            r0 = 4
        L2b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.ui.routeguide.mapmode.subview.c0.d(int, int):int");
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void c() {
        super.c();
        z(false);
        y(false);
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void i() {
        super.i();
        c();
        this.o = false;
        this.p = -1;
        n0();
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void a(ViewGroup viewGroup, int i) {
        super.a(viewGroup, i);
        p0();
        a(com.baidu.navisdk.ui.util.b.b());
        o0();
        v(this.p);
    }

    private void y(boolean z) {
        RelativeLayout relativeLayout = this.l;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void a(boolean z) {
        super.a(z);
        RelativeLayout relativeLayout = this.i;
        if (relativeLayout != null) {
            relativeLayout.setBackgroundDrawable(com.baidu.navisdk.ui.util.b.g(R.drawable.nsdk_rg_selector_common_control_btn_bg));
        }
        RelativeLayout relativeLayout2 = this.l;
        if (relativeLayout2 != null) {
            relativeLayout2.setBackgroundDrawable(com.baidu.navisdk.ui.util.b.g(R.drawable.nsdk_rg_selector_common_control_btn_bg));
        }
        TextView textView = this.n;
        if (textView != null) {
            textView.setTextColor(com.baidu.navisdk.ui.util.b.b(R.color.nsdk_cl_text_h));
        }
        TextView textView2 = this.k;
        if (textView2 != null) {
            textView2.setTextColor(com.baidu.navisdk.ui.util.b.b(R.color.nsdk_cl_text_h));
        }
        v(this.p);
    }
}
