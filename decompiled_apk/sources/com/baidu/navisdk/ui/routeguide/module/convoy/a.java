package com.baidu.navisdk.ui.routeguide.module.convoy;

import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.routeguide.control.s;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.worker.loop.b;

/* loaded from: classes8.dex */
public class a {
    private static volatile a b = null;
    public static boolean c = false;

    /* renamed from: a, reason: collision with root package name */
    private b f8988a = new HandlerC0466a("Convoy");

    /* renamed from: com.baidu.navisdk.ui.routeguide.module.convoy.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class HandlerC0466a extends b {
        public HandlerC0466a(String str) {
            super(str);
        }

        @Override // com.baidu.navisdk.comapi.base.d
        public void careAbout() {
            observe(4444);
        }

        @Override // com.baidu.navisdk.util.worker.loop.b
        public void onMessage(Message message) {
            if (message.what == 4444) {
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("RoutePlan", "handleMessage: Message_Type_AmbulanceEvent:" + message);
                }
                a.this.a(message);
            }
        }
    }

    private void c() {
        com.baidu.navisdk.vi.b.b(this.f8988a);
    }

    public static a d() {
        if (b == null) {
            synchronized (a.class) {
                try {
                    if (b == null) {
                        b = new a();
                    }
                } finally {
                }
            }
        }
        return b;
    }

    public void b() {
        com.baidu.navisdk.vi.b.a(this.f8988a);
    }

    public void a() {
        if (b != null) {
            synchronized (a.class) {
                try {
                    if (b != null) {
                        b.c();
                    }
                } finally {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Message message) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RoutePlan", "onAmbulanceEvent: userType" + message.arg1 + ", convoyStatus" + message.arg2);
        }
        if (message.arg1 == 0) {
            c = message.arg2 == 0;
            com.baidu.navisdk.ui.routeguide.mapmode.a.o5().F3();
            return;
        }
        Bundle bundle = new Bundle();
        BNRouteGuider.getInstance().getRouteInfoInUniform(22, bundle);
        int i = bundle.getInt("convoyCarType");
        String a2 = a(bundle.getString("convoyCarValue"));
        LogUtil.e("RoutePlan", "onAmbulanceEvent: carType" + i + ", title" + a2);
        if (i > 3 || i < 0 || TextUtils.isEmpty(a2)) {
            return;
        }
        int i2 = R.drawable.nsdk_notification_others;
        if (i == 0) {
            i2 = R.drawable.nsdk_notification_ambulance;
        } else if (i == 1) {
            i2 = R.drawable.nsdk_notification_fire;
        } else if (i == 2) {
            i2 = R.drawable.nsdk_notification_emergency;
        }
        s.T().a(a2, i2);
    }

    private String a(String str) {
        if (str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        int i = 0;
        while (i < length) {
            if (str.charAt(i) == '\\') {
                if (i < length - 5) {
                    int i2 = i + 1;
                    if (str.charAt(i2) == 'u' || str.charAt(i2) == 'U') {
                        try {
                            sb.append((char) Integer.parseInt(str.substring(i + 2, i + 6), 16));
                            i += 5;
                        } catch (NumberFormatException unused) {
                            sb.append(str.charAt(i));
                        }
                    }
                }
                sb.append(str.charAt(i));
            } else {
                sb.append(str.charAt(i));
            }
            i++;
        }
        return sb.toString();
    }
}
