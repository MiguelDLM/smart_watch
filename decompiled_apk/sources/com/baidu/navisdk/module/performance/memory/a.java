package com.baidu.navisdk.module.performance.memory;

import android.os.Handler;
import android.os.Message;
import com.baidu.navisdk.comapi.trajectory.i;
import com.baidu.navisdk.comapi.trajectory.j;
import com.baidu.navisdk.framework.b;
import com.baidu.navisdk.module.cloudconfig.f;
import com.baidu.navisdk.util.common.LogUtil;
import com.huawei.openalliance.ad.constant.ah;

/* loaded from: classes7.dex */
public class a {
    private static a g;
    private boolean c;
    private final Handler f;

    /* renamed from: a, reason: collision with root package name */
    private boolean f7378a = false;
    private int b = -1;
    public boolean d = f.c().c.P;
    public boolean e = f.c().c.Q;

    /* renamed from: com.baidu.navisdk.module.performance.memory.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class HandlerC0272a extends com.baidu.navisdk.util.worker.loop.a {
        public HandlerC0272a(String str) {
            super(str);
        }

        @Override // com.baidu.navisdk.util.worker.loop.a
        public void onMessage(Message message) {
            switch (message.what) {
                case 701:
                    if (a.this.f7378a) {
                        if (LogUtil.LOGGABLE) {
                            LogUtil.e("BNMemoryManager", "handle MSG_RELEASE_GRAPHIC_MEMORY-> mRecyclerMapMemory:" + a.this.e);
                        }
                        a.this.c();
                        a.this.e();
                        return;
                    }
                    return;
                case 702:
                    if (a.this.f7378a) {
                        if (LogUtil.LOGGABLE) {
                            LogUtil.e("BNMemoryManager", "handle MSG_RELEASE_ROUTE_RESULT_PAGE_MEMORY-> mRecyclerMapMemory:" + a.this.e);
                        }
                        a.this.a(1);
                        return;
                    }
                    return;
                case ah.P /* 703 */:
                    if (a.this.f7378a && a.this.d) {
                        boolean a2 = com.baidu.navisdk.naviresult.a.d().a(j.TRAJECTORY_FROM_NAVI, i.END_RECORD_REASON_OTHER);
                        if (LogUtil.LOGGABLE) {
                            LogUtil.e("BNMemoryManager", "handle MSG_CALC_ENTER_NAVI_RESULT_PAGE-> ret=" + a2);
                        }
                        if (!a2) {
                            a.this.d();
                            return;
                        } else {
                            a.this.a(2);
                            return;
                        }
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public a() {
        boolean z = f.c().c.R;
        this.f = new HandlerC0272a("BNMemoryManager");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BNMemoryManager", "sendReleaseGraphicMemoryMsg-> mRecyclerMapMemory:" + this.e);
        }
        if (this.e) {
            this.f.sendEmptyMessageDelayed(701, 300000L);
        }
    }

    public static a b() {
        if (g == null) {
            synchronized (a.class) {
                try {
                    if (g == null) {
                        g = new a();
                    }
                } finally {
                }
            }
        }
        return g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BNMemoryManager", "releaseGraphicMemory-> mRecyclerMapMemory:" + this.e);
        }
        if (this.e) {
            b.Y();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BNMemoryManager", "sendCalcEnterNaviResultPageMsg-> mReleaseCarRoutePageSwitch:" + this.d);
        }
        if (this.d) {
            this.f.sendEmptyMessageDelayed(ah.P, 60000L);
        }
    }

    public void a(int i, boolean z) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BNMemoryManager", "onNaviBegin->vehicle=" + i);
        }
        this.b = i;
        this.f7378a = true;
        this.c = z;
        e();
        d();
    }

    public void a() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BNMemoryManager", "onNaviEnd->");
        }
        this.f7378a = false;
        this.b = -1;
        this.c = false;
        this.f.removeMessages(701);
        this.f.removeMessages(ah.P);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BNMemoryManager", "releaseRouteResultPageMemory-> releaseLevel=" + i + ", mVehicleType=" + this.b + ", isHicar=" + this.c);
        }
    }
}
