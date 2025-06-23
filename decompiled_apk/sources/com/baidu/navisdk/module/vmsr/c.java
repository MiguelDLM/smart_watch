package com.baidu.navisdk.module.vmsr;

import android.content.Context;
import android.os.Build;
import android.os.Message;
import android.view.KeyEvent;
import com.baidu.navisdk.framework.interfaces.pronavi.n;
import com.baidu.navisdk.framework.message.bean.l;
import com.baidu.navisdk.framework.vmsr.m;
import com.baidu.navisdk.framework.vmsr.s;
import com.baidu.navisdk.jni.nativeif.JNIGuidanceControl;
import com.baidu.navisdk.model.datastruct.g;
import com.baidu.navisdk.module.cloudconfig.f;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.statistic.LightNaviStatItem;
import com.baidu.navisdk.util.statistic.ProNaviStatItem;

/* loaded from: classes7.dex */
public class c implements m, com.baidu.navisdk.module.vmsr.a {
    public static boolean h = true;
    public static boolean i = false;
    public static boolean j = false;
    private static com.baidu.navisdk.module.vmsr.a k;
    private s c;

    /* renamed from: a, reason: collision with root package name */
    private int f7618a = 0;
    private boolean b = false;
    private int d = 0;
    private int e = 0;
    private int f = 0;
    private com.baidu.navisdk.util.worker.loop.b g = new a();

    /* loaded from: classes7.dex */
    public class a extends com.baidu.navisdk.util.worker.loop.b {
        public a() {
        }

        @Override // com.baidu.navisdk.comapi.base.d
        public void careAbout() {
            observe(4427);
        }

        @Override // com.baidu.navisdk.util.worker.loop.b
        public void onMessage(Message message) {
            String str;
            n b0;
            int i = message.what;
            if (i == 1) {
                c.this.h();
                return;
            }
            if (i == 4427) {
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("Vmsr", "MSG_NAVI_Type_HARControl :" + message.arg1 + ",arg2:" + message.arg2);
                    com.baidu.navisdk.framework.message.a a2 = com.baidu.navisdk.framework.message.a.a();
                    StringBuilder sb = new StringBuilder();
                    sb.append("引擎消息=");
                    sb.append(message.arg1);
                    a2.a(new l("Vmsr", sb.toString()));
                }
                int i2 = message.arg1;
                if (i2 == 1) {
                    c.this.d();
                    return;
                }
                if (i2 == 0) {
                    c.this.c();
                    return;
                }
                if (i2 == 2) {
                    int i3 = message.arg2;
                    if (i3 == 1) {
                        c.a(c.this);
                    } else if (i3 == 2) {
                        c.b(c.this);
                    } else if (i3 == 3) {
                        c.c(c.this);
                    }
                    if (LogUtil.LOGGABLE) {
                        int i4 = message.arg2;
                        if (i4 == 1) {
                            str = "码表非0";
                        } else if (i4 == 2) {
                            str = "车标提前";
                        } else if (i4 == 3) {
                            str = "误偏航";
                        } else {
                            str = "";
                        }
                        LogUtil.e("Vmsr", "MSG_NAVI_Type_HARControl :" + str);
                        com.baidu.navisdk.framework.message.a.a().a(new l("Vmsr", str));
                        com.baidu.navisdk.framework.interfaces.pronavi.b h = com.baidu.navisdk.framework.interfaces.c.p().h();
                        if (h != null && (b0 = h.b0()) != null) {
                            b0.a(0, 5, str);
                        }
                    }
                }
            }
        }
    }

    private c() {
    }

    public static /* synthetic */ int b(c cVar) {
        int i2 = cVar.e;
        cVar.e = i2 + 1;
        return i2;
    }

    public static /* synthetic */ int c(c cVar) {
        int i2 = cVar.f;
        cVar.f = i2 + 1;
        return i2;
    }

    private int e() {
        s sVar = this.c;
        if (sVar != null) {
            return sVar.a().r;
        }
        return -1;
    }

    public static com.baidu.navisdk.module.vmsr.a f() {
        if (k == null) {
            synchronized (c.class) {
                try {
                    if (k == null) {
                        k = new c();
                    }
                } finally {
                }
            }
        }
        return k;
    }

    private int g() {
        s sVar = this.c;
        if (sVar != null) {
            return sVar.b().r;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        j();
        if (!this.c.b().b) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("Vmsr", "cloud is close");
                return;
            }
            return;
        }
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.c.b().d0 = i;
        this.c.a().d0 = i;
        this.c.a(this);
        this.c.f();
        com.baidu.navisdk.vi.b.a(this.g);
    }

    private void i() {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        com.baidu.navisdk.vi.b.b(this.g);
        s sVar = this.c;
        if (sVar == null) {
            return;
        }
        com.baidu.navisdk.framework.vmsr.n b = sVar.b();
        com.baidu.navisdk.framework.vmsr.c a2 = this.c.a();
        if (b == null) {
            return;
        }
        com.baidu.navisdk.util.statistic.userop.b.r().a("3.z.1.9", this.d + "", this.e + "", this.f + "");
        com.baidu.navisdk.util.statistic.userop.b.r().a("3.z.1.10", g() + "", e() + "");
        com.baidu.navisdk.framework.interfaces.lightnavi.a i10 = com.baidu.navisdk.framework.interfaces.c.p().i();
        int i11 = 0;
        if (i10 != null && i10.t0()) {
            LightNaviStatItem.s().Q = b.o;
            LightNaviStatItem.s().R = b.p;
            LightNaviStatItem.s().S = b.n;
            LightNaviStatItem.s().T = b.q;
            LightNaviStatItem.s().U = b.r;
            LightNaviStatItem.s().V = b.s;
            LightNaviStatItem.s().W = b.t;
            LightNaviStatItem.s().X = b.u;
            LightNaviStatItem.s().Y = b.v;
            LightNaviStatItem.s().Z = b.w;
            LightNaviStatItem.s().a0 = b.x;
            if (a2 != null) {
                LightNaviStatItem.s().b0 = a2.r;
                LightNaviStatItem.s().c0 = a2.s;
                LightNaviStatItem.s().d0 = a2.q;
                if (a2.r > 50) {
                    LightNaviStatItem.s().i0 = ((a2.r - a2.s) * 100) / a2.r;
                }
                if (a2.r > 50 && a2.D > 0) {
                    LightNaviStatItem.s().k0 = (a2.E * 100) / a2.D;
                }
            }
            LightNaviStatItem s = LightNaviStatItem.s();
            int i12 = b.E;
            if (a2 == null) {
                i8 = 0;
            } else {
                i8 = a2.E;
            }
            s.e0 = i12 + i8;
            LightNaviStatItem s2 = LightNaviStatItem.s();
            int i13 = b.D;
            if (a2 == null) {
                i9 = 0;
            } else {
                i9 = a2.D;
            }
            s2.f0 = i13 + i9;
            LightNaviStatItem.s().g0 = b.H;
            if (b.r > 50 && b.D > 0) {
                LightNaviStatItem.s().j0 = (b.E * 100) / b.D;
            }
            if (b.r > 50) {
                LightNaviStatItem.s().h0 = ((b.r - b.s) * 100) / b.r;
            }
            LightNaviStatItem.s().l0 = this.d;
            LightNaviStatItem.s().m0 = this.e;
            LightNaviStatItem.s().n0 = this.f;
        } else {
            ProNaviStatItem.O().j0 = b.o;
            ProNaviStatItem.O().k0 = b.p;
            ProNaviStatItem.O().l0 = b.n;
            ProNaviStatItem.O().m0 = b.q;
            ProNaviStatItem.O().n0 = b.r;
            ProNaviStatItem.O().f9359o0 = b.s;
            ProNaviStatItem.O().p0 = b.t;
            ProNaviStatItem.O().q0 = b.u;
            ProNaviStatItem.O().r0 = b.v;
            ProNaviStatItem.O().s0 = b.w;
            ProNaviStatItem.O().t0 = b.x;
            if (a2 != null) {
                ProNaviStatItem.O().u0 = a2.r;
                ProNaviStatItem.O().v0 = a2.s;
                ProNaviStatItem.O().w0 = a2.q;
                if (a2.r > 50 && a2.D > 0) {
                    ProNaviStatItem.O().D0 = (a2.E * 100) / a2.D;
                }
                if (a2.r > 50) {
                    ProNaviStatItem.O().B0 = ((a2.r - a2.s) * 100) / a2.r;
                }
            }
            ProNaviStatItem O = ProNaviStatItem.O();
            int i14 = b.E;
            if (a2 == null) {
                i2 = 0;
            } else {
                i2 = a2.E;
            }
            O.f9360x0 = i14 + i2;
            ProNaviStatItem O2 = ProNaviStatItem.O();
            int i15 = b.D;
            if (a2 == null) {
                i3 = 0;
            } else {
                i3 = a2.D;
            }
            O2.y0 = i15 + i3;
            ProNaviStatItem.O().z0 = b.H;
            if (b.r > 50 && b.D > 0) {
                ProNaviStatItem.O().C0 = (b.E * 100) / b.D;
            }
            if (b.r > 50) {
                ProNaviStatItem.O().A0 = ((b.r - b.s) * 100) / b.r;
            }
            ProNaviStatItem.O().E0 = this.d;
            ProNaviStatItem.O().F0 = this.e;
            ProNaviStatItem.O().G0 = this.f;
        }
        if (LogUtil.LOGGABLE) {
            StringBuilder sb = new StringBuilder();
            sb.append("Main mStopSampleFailTimes:");
            sb.append(b.o);
            sb.append("\n");
            sb.append("Main mMoveSampleFailTimes:");
            sb.append(b.p);
            sb.append("\n");
            sb.append("Main mModelTrainTimes:");
            sb.append(b.n);
            sb.append("\n");
            sb.append("Main mTrainFailTimes:");
            sb.append(b.q);
            sb.append("\n");
            sb.append("Main mInferTimes:");
            sb.append(b.r);
            sb.append("\n");
            sb.append("Main mInferFailTimes:");
            sb.append(b.s);
            sb.append("\n");
            sb.append("Main mOpenGpsCount:");
            sb.append(b.G);
            sb.append("\n");
            sb.append("Main mRecallTimes:");
            sb.append(b.t);
            sb.append("\n");
            sb.append("Main mGpsStopTimesInInfer:");
            sb.append(b.F);
            sb.append("\n");
            sb.append("Main mStopInferTimes:");
            sb.append(b.D);
            sb.append("\n");
            sb.append("Main mStopRightTimes:");
            sb.append(b.E);
            sb.append("\n");
            sb.append("Aux mInferTimes:");
            if (a2 == null) {
                i4 = 0;
            } else {
                i4 = a2.r;
            }
            sb.append(i4);
            sb.append("\n");
            sb.append("Aux mInferFailTimes:");
            if (a2 == null) {
                i5 = 0;
            } else {
                i5 = a2.s;
            }
            sb.append(i5);
            sb.append("\n");
            sb.append("Aux mGpsStopTimesInInfer:");
            if (a2 == null) {
                i6 = 0;
            } else {
                i6 = a2.F;
            }
            sb.append(i6);
            sb.append("\n");
            sb.append("Aux mStopInferTimes:");
            if (a2 == null) {
                i7 = 0;
            } else {
                i7 = a2.D;
            }
            sb.append(i7);
            sb.append("\n");
            sb.append("Aux mStopRightTimes:");
            if (a2 != null) {
                i11 = a2.E;
            }
            sb.append(i11);
            LogUtil.e("Vmsr", "nav end vmsr result:" + sb.toString());
        }
        this.c.h();
        this.c.j();
    }

    private void j() {
        s sVar;
        if (f.c().e != null && (sVar = this.c) != null) {
            com.baidu.navisdk.framework.vmsr.n b = sVar.b();
            if (b != null) {
                b.b = f.c().e.f7142a;
                b.e = f.c().e.f;
                b.f = f.c().e.e;
                b.c = f.c().e.b;
                b.g = f.c().e.d;
                b.d = f.c().e.c;
                b.k = f.c().e.g;
            }
            com.baidu.navisdk.framework.vmsr.c a2 = this.c.a();
            if (a2 != null) {
                a2.b = f.c().e.f7142a;
                a2.e = f.c().e.f;
                a2.f = f.c().e.e;
                a2.c = f.c().e.b;
                a2.g = f.c().e.d;
                a2.d = f.c().e.c;
                a2.k = f.c().e.h;
                a2.l = f.c().e.i;
            }
        }
    }

    @Override // com.baidu.navisdk.framework.vmsr.m
    public void a(int i2, boolean z) {
    }

    @Override // com.baidu.navisdk.module.vmsr.a
    public void onBackground() {
        s sVar = this.c;
        if (sVar != null) {
            sVar.d();
        }
    }

    @Override // com.baidu.navisdk.module.vmsr.a
    public void onKeyDown(int i2, KeyEvent keyEvent) {
        s sVar = this.c;
        if (sVar != null) {
            sVar.a(i2, keyEvent);
        }
    }

    @Override // com.baidu.navisdk.module.vmsr.a
    public void onLocationChange(g gVar) {
        s sVar = this.c;
        if (sVar != null && gVar != null && gVar.k == 1) {
            if (this.b) {
                sVar.a(gVar.c, 10.0f, 10);
            } else {
                sVar.a(gVar.c, gVar.f, gVar.g);
            }
            if (j) {
                if (this.c.b().i() && Math.round(gVar.c) >= 0 && gVar.c <= 1.0f) {
                    this.f7618a++;
                } else {
                    this.f7618a = 0;
                }
                if (this.f7618a > 5) {
                    c();
                    com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.COMMON;
                    if (gVar2.e()) {
                        gVar2.g("mGPSStopTimes > 5 stop predict");
                    }
                }
            }
        }
    }

    public static /* synthetic */ int a(c cVar) {
        int i2 = cVar.d;
        cVar.d = i2 + 1;
        return i2;
    }

    @Override // com.baidu.navisdk.module.vmsr.a
    public void b() {
        this.g.removeMessages(1);
        i();
    }

    @Override // com.baidu.navisdk.module.vmsr.a
    public void c() {
        com.baidu.navisdk.util.statistic.userop.b.r().a("3.z.1.8", g() + "", e() + "");
        s sVar = this.c;
        if (sVar != null) {
            sVar.i();
        }
    }

    public void d() {
        com.baidu.navisdk.util.statistic.userop.b.r().a("3.z.1.7", g() + "", e() + "");
        s sVar = this.c;
        if (sVar != null) {
            sVar.g();
        }
    }

    @Override // com.baidu.navisdk.module.vmsr.a
    public synchronized void a(Context context) {
        if (h) {
            if (Build.VERSION.SDK_INT < 24) {
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("Vmsr", "sdk < 24");
                }
            } else {
                if (this.c == null) {
                    this.c = new s(context);
                }
                this.g.removeMessages(1);
                this.g.sendEmptyMessageDelayed(1, 10000L);
            }
        }
    }

    @Override // com.baidu.navisdk.framework.vmsr.m
    public void b(int i2) {
        String str;
        if (LogUtil.LOGGABLE) {
            switch (i2) {
                case 0:
                    str = "采集数据开始";
                    break;
                case 1:
                    str = "采集数据结束";
                    break;
                case 2:
                    str = "自动训练开启";
                    break;
                case 3:
                    str = "自动训练结束";
                    break;
                case 4:
                case 14:
                case 15:
                case 20:
                default:
                    str = "" + i2;
                    break;
                case 5:
                    str = "静态数据OK";
                    break;
                case 6:
                    str = "动态数据OK";
                    break;
                case 7:
                    str = "使用上次保存模型";
                    break;
                case 8:
                    str = "姿态变化超过阈值";
                    break;
                case 9:
                    str = "第一次校验开始";
                    break;
                case 10:
                    str = "第一次校验结束";
                    break;
                case 11:
                    str = "第一次校验失败";
                    break;
                case 12:
                    str = "第一次校验成功";
                    break;
                case 13:
                    str = "第一次校验静态成功";
                    break;
                case 16:
                    str = "周期性校验失败";
                    break;
                case 17:
                    str = "周期性校验成功";
                    break;
                case 18:
                    str = "周期性校验静态成功";
                    break;
                case 19:
                    str = "周期性校验动态成功";
                    break;
                case 21:
                    str = "复杂模型开始工作";
                    break;
                case 22:
                    str = "简单模型开始工作";
                    break;
            }
            LogUtil.e("Vmsr", "onMsg :" + i2);
            s sVar = this.c;
            if (sVar != null) {
                str = "[" + sVar.c() + "]" + str;
            }
            com.baidu.navisdk.framework.message.a.a().a(new l("Vmsr", str));
        }
    }

    @Override // com.baidu.navisdk.module.vmsr.a
    public void a(boolean z) {
        this.b = z;
    }

    @Override // com.baidu.navisdk.framework.vmsr.m
    public void a(boolean z, float f) {
        if (LogUtil.LOGGABLE) {
            StringBuilder sb = new StringBuilder();
            sb.append(z ? "训练成功" : "训练失败");
            sb.append(" 误差：");
            sb.append(f);
            com.baidu.navisdk.framework.message.a.a().a(new l("Vmsr", sb.toString()));
        }
        ProNaviStatItem.O().d(this.c.b().m);
    }

    @Override // com.baidu.navisdk.framework.vmsr.m
    public void a(int i2) {
        String str;
        if (this.c == null) {
            return;
        }
        JNIGuidanceControl.getInstance().triggerVmsrResult(i2);
        com.baidu.navisdk.framework.interfaces.pronavi.b h2 = com.baidu.navisdk.framework.interfaces.c.p().h();
        if (h2 != null && h2.x0()) {
            com.baidu.navisdk.module.vdr.a.e(i2);
        }
        if (LogUtil.LOGGABLE) {
            float c = this.c.c();
            boolean a2 = this.c.b().a();
            StringBuilder sb = new StringBuilder();
            sb.append(a2 ? "Main " : "Aux ");
            sb.append(" onPredictResult jni:");
            sb.append(i2);
            LogUtil.e("Vmsr", sb.toString());
            if (i2 == 1) {
                str = "未准备好";
            } else if (i2 == 2) {
                str = "不确定";
            } else if (i2 == 4) {
                str = "INVALID";
            } else if (i2 == 8) {
                str = "运动";
            } else if (i2 == 16) {
                str = "缓行";
            } else if (i2 == 32) {
                str = "静止";
            } else if (i2 == 64) {
                str = "AUX_未准备好";
            } else if (i2 == 128) {
                str = "AUX_不确定";
            } else if (i2 == 256) {
                str = "AUX_INVALID";
            } else if (i2 == 512) {
                str = "AUX_运动";
            } else if (i2 == 1024) {
                str = "AUX_缓行";
            } else if (i2 != 2048) {
                str = i2 + "";
            } else {
                str = "AUX_静止";
            }
            if (i2 == 32 || i2 == 2048 || i2 == 8 || i2 == 512 || i2 == 16 || i2 == 1024) {
                return;
            }
            com.baidu.navisdk.framework.message.a.a().a(new l("Vmsr", "[" + c + "]预测状态：" + str));
        }
    }

    @Override // com.baidu.navisdk.module.vmsr.a
    public void a() {
        s sVar = this.c;
        if (sVar != null) {
            sVar.e();
        }
    }

    @Override // com.baidu.navisdk.framework.vmsr.m
    public void a(int i2, int i3) {
        if (LogUtil.LOGGABLE) {
            com.baidu.navisdk.framework.message.a.a().a(new l("Vmsr", "错误：" + i3));
            TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), "错误：" + i3);
        }
    }

    @Override // com.baidu.navisdk.framework.vmsr.m
    public void a(int i2, String str) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("Vmsr", "onMsg :" + str);
            s sVar = this.c;
            if (sVar != null) {
                str = "[" + sVar.c() + "]" + str;
            }
            com.baidu.navisdk.framework.message.a.a().a(new l("Vmsr", str));
        }
    }

    @Override // com.baidu.navisdk.framework.vmsr.m
    public void a(int i2, String str, String str2, String str3) {
        if (i2 == 1) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.z.1.1", str, str2, str3);
            return;
        }
        if (i2 == 2) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.z.1.2", str, str2, str3);
            return;
        }
        if (i2 == 3) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.z.1.3", str, str2, str3);
        } else if (i2 == 5) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.z.1.5", str, str2, str3);
        } else {
            if (i2 != 6) {
                return;
            }
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.z.1.6", str, str2, str3);
        }
    }
}
