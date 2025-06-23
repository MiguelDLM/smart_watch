package com.baidu.navisdk.vi;

import android.os.Message;
import com.baidu.navisdk.comapi.base.d;
import com.baidu.navisdk.util.common.LogUtil;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes8.dex */
public class VMsg {
    public static final int VM_USER_ID = 4096;
    private static final List<d> outboxHandlers = new ArrayList();

    public static void dispatchMessage(int i, int i2, int i3) {
        List<d> list;
        if (i > 4096 && (list = outboxHandlers) != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(list);
            for (int i4 = 0; i4 < arrayList.size(); i4++) {
                d dVar = (d) arrayList.get(i4);
                if (dVar != null && dVar.isObserved(i)) {
                    Message.obtain(dVar, i, i2, i3, null).sendToTarget();
                }
            }
        }
    }

    public static void dumpList() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(outboxHandlers);
        LogUtil.e("VMsg", "dumpList()  handlers count=" + arrayList.size());
        for (int i = 0; i < arrayList.size(); i++) {
            LogUtil.e("VMsg", i + "handler.class=" + ((d) arrayList.get(i)).getClass() + ", name=" + ((d) arrayList.get(i)).getClass().getSimpleName());
        }
    }

    private static void postMessage(int i, int i2, int i3) {
        b.a(i, i2, i3);
    }

    public static void registerMessageHandler(d dVar) {
        if (dVar != null) {
            List<d> list = outboxHandlers;
            if (!list.contains(dVar)) {
                list.add(dVar);
            }
        }
    }

    public static void unRegisterMessageHandler(d dVar) {
        if (dVar != null) {
            List<d> list = outboxHandlers;
            if (list.contains(dVar)) {
                list.remove(dVar);
            }
        }
    }
}
