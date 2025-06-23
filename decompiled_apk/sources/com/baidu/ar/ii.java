package com.baidu.ar;

import android.content.Context;
import com.baidu.ar.arplay.core.message.ARPMessage;
import com.baidu.ar.ig;
import com.baidu.ar.statistic.StatisticApi;
import com.baidu.ar.statistic.StatisticConstants;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes7.dex */
public class ii implements ft {
    private Context mContext;
    private ig.a yG;

    public ii(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public static void c(float f, float f2, float f3, float f4) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("id", 10000);
        hashMap.put("max_acc", Float.valueOf(f4));
        ARPMessage.getInstance().sendMessage(1902, hashMap);
    }

    @Override // com.baidu.ar.ft
    public void a(int i, int i2, HashMap<String, Object> hashMap) {
        if (i != 1901 || hashMap == null) {
            return;
        }
        int a2 = as.a(hashMap.get("id"), -1);
        if (a2 == 10001) {
            ih.j(this.mContext).b(this.yG);
        } else if (a2 == 10002) {
            ih.j(this.mContext).stop();
        } else {
            if (a2 != 10004) {
                return;
            }
            ih.j(this.mContext).Q(true);
        }
    }

    public void b(fs fsVar) {
        this.yG = new ig.a() { // from class: com.baidu.ar.ii.1
            @Override // com.baidu.ar.ig.a
            public void b(float f, float f2, float f3, float f4) {
                kf.cl("acc  x " + f + " , y : " + f2 + " , z " + f3);
                StatisticApi.onEvent(StatisticConstants.MODEL_PHONE_SHAKE);
                ii.c(f, f2, f3, f4);
            }

            @Override // com.baidu.ar.ig.a
            public void destroy() {
            }
        };
        fsVar.c(this);
    }

    @Override // com.baidu.ar.ft
    public List<Integer> q() {
        return Arrays.asList(1901);
    }

    public void release() {
        ih.j(this.mContext).destroy();
        this.yG = null;
        this.mContext = null;
    }

    public void reset() {
        Context context = this.mContext;
        if (context != null) {
            try {
                ih.j(context).stop();
            } catch (Throwable unused) {
            }
        }
    }
}
