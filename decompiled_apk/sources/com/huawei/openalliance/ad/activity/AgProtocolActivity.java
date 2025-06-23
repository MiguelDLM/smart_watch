package com.huawei.openalliance.ad.activity;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import com.huawei.appmarket.service.externalservice.activityresult.IActivityResult;
import com.huawei.hms.ads.cy;
import com.huawei.hms.ads.fb;
import com.huawei.openalliance.ad.constant.x;
import com.huawei.openalliance.ad.utils.bf;
import com.huawei.openalliance.ad.utils.h;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes10.dex */
public class AgProtocolActivity extends d {
    public static final int B = 1005;
    public static final String C = "agd.extra.autofinish";
    public static final int Code = 1001;
    public static final String D = "agd.extra.bundle.binder";
    public static final String F = "agd.extra.bundle.requestcode";
    public static final int I = 1003;
    public static final int L = 1;
    public static final String S = "agd.extra.bundle";
    public static final int V = 1002;
    public static final int Z = 1004;
    private static final int d = 100;
    private static final int e = 101;
    private static final int f = 102;
    private static final String g = "resolution";
    private static final List<String> h;

    /* renamed from: a, reason: collision with root package name */
    String f17368a;
    int b;
    String c;
    private final IActivityResult i = new a(this);

    /* loaded from: classes10.dex */
    public static class a extends IActivityResult.II0xO0 {
        private WeakReference<AgProtocolActivity> V;

        public a(AgProtocolActivity agProtocolActivity) {
            this.V = new WeakReference<>(agProtocolActivity);
        }

        @Override // com.huawei.appmarket.service.externalservice.activityresult.IActivityResult
        public void onActivityCancel(final int i) {
            fb.V("resolution", "onActivityCancel requestCode=" + i);
            bf.Code(new Runnable() { // from class: com.huawei.openalliance.ad.activity.AgProtocolActivity.a.1
                @Override // java.lang.Runnable
                public void run() {
                    AgProtocolActivity agProtocolActivity = a.this.V == null ? null : (AgProtocolActivity) a.this.V.get();
                    if (agProtocolActivity != null) {
                        agProtocolActivity.onActivityResult(i, 0, null);
                    }
                }
            });
        }
    }

    static {
        ArrayList arrayList = new ArrayList();
        h = arrayList;
        arrayList.add(x.cu);
    }

    @Override // com.huawei.openalliance.ad.activity.d, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        String str;
        String str2;
        int i3;
        super.onActivityResult(i, i2, intent);
        fb.V("resolution", "requestCode=" + i + "resultCode=" + i2 + " appPackageName=" + this.f17368a);
        if (100 != i) {
            if (101 == i) {
                fb.V("resolution", "syncAgResolutionStatus:101");
                str = this.f17368a;
                str2 = this.c;
                i3 = 1003;
            } else if (102 == i) {
                if (i2 == -1) {
                    fb.V("resolution", "install hiapp");
                    str = this.f17368a;
                    str2 = this.c;
                    i3 = 1004;
                } else {
                    fb.V("resolution", "install hiapp, user cancel");
                    str = this.f17368a;
                    str2 = this.c;
                    i3 = 1005;
                }
            }
            com.huawei.openalliance.ad.download.app.c.Code(this, i3, str, str2, (Class) null);
        } else if (1001 == i2) {
            fb.V("resolution", "AG agree protocol");
            com.huawei.openalliance.ad.download.app.c.Code(this, 1001, this.f17368a, this.c, (Class) null);
        } else {
            fb.V("resolution", "AG disagree protocol");
            str = this.f17368a;
            str2 = this.c;
            i3 = 1002;
            com.huawei.openalliance.ad.download.app.c.Code(this, i3, str, str2, (Class) null);
        }
        finish();
    }

    @Override // com.huawei.openalliance.ad.activity.d, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        h.I(new Runnable() { // from class: com.huawei.openalliance.ad.activity.AgProtocolActivity.1
            @Override // java.lang.Runnable
            public void run() {
                Intent intent = AgProtocolActivity.this.getIntent();
                if (intent != null) {
                    try {
                        PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra("pendingIntent");
                        AgProtocolActivity.this.b = intent.getIntExtra(com.huawei.openalliance.ad.download.app.d.f, 6);
                        AgProtocolActivity.this.f17368a = intent.getStringExtra(com.huawei.openalliance.ad.download.app.d.g);
                        AgProtocolActivity.this.c = intent.getStringExtra("ag_action_name");
                        AgProtocolActivity.this.V();
                        int i = AgProtocolActivity.this.b;
                        int i2 = i == 6 ? 101 : i == 8888 ? 102 : 100;
                        Intent intent2 = new Intent();
                        Bundle bundle2 = new Bundle();
                        bundle2.putBinder(AgProtocolActivity.D, AgProtocolActivity.this.i.asBinder());
                        bundle2.putInt(AgProtocolActivity.F, i2);
                        intent2.putExtra(AgProtocolActivity.S, bundle2);
                        if (AgProtocolActivity.h.contains(AgProtocolActivity.this.getPackageName())) {
                            intent2.putExtra(AgProtocolActivity.C, 1);
                        }
                        fb.V("resolution", "resolution type=" + AgProtocolActivity.this.b);
                        AgProtocolActivity.this.startIntentSenderForResult(pendingIntent.getIntentSender(), i2, intent2, 0, 0, 0);
                    } catch (Throwable th) {
                        fb.V("resolution", "startIntentSenderForResult error:e=" + th.getClass().getName());
                        AgProtocolActivity.this.finish();
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V() {
        cy.Code(getApplicationContext(), this.b, this.f17368a, this.c, com.huawei.openalliance.ad.download.app.a.V);
    }
}
