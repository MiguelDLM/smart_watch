package com.baidu.navisdk.util.listener;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.statistic.userop.b;
import com.huawei.openalliance.ad.constant.x;
import com.iflytek.sparkchain.utils.constants.ErrorCode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes8.dex */
public class UsbListener extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    private static UsbListener f9314a = new UsbListener();
    private static final List<Handler> b = new ArrayList();

    public static void a(Context context) {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(x.bk);
            context.registerReceiver(f9314a, intentFilter);
        } catch (Exception unused) {
        }
    }

    public static void b(Context context) {
        try {
            context.unregisterReceiver(f9314a);
        } catch (Exception unused) {
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(x.bk)) {
            int i = 0;
            if (intent.getExtras().getBoolean(x.bl)) {
                b.r().b("3.r.2");
                a(ErrorCode.MSP_ERROR_RES_LOAD, 1, 0);
                i = 1;
            } else {
                a(ErrorCode.MSP_ERROR_RES_LOAD, 0, 0);
            }
            LogUtil.e("UsbListener", "usb connect is changed arg1 " + i);
        }
    }

    public static void b(Handler handler) {
        if (handler != null) {
            List<Handler> list = b;
            if (list.contains(handler)) {
                list.remove(handler);
            }
        }
    }

    public static void a(Handler handler) {
        if (handler != null) {
            List<Handler> list = b;
            if (list.contains(handler)) {
                return;
            }
            list.add(handler);
        }
    }

    private static void a(int i, int i2, int i3) {
        List<Handler> list = b;
        if (list.isEmpty()) {
            return;
        }
        Iterator it = new ArrayList(list).iterator();
        while (it.hasNext()) {
            Message.obtain((Handler) it.next(), i, i2, i3, null).sendToTarget();
        }
    }
}
