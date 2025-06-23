package com.baidu.ar;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.ar.bean.ARConfig;
import com.baidu.ar.constants.ARConfigKey;
import com.baidu.ar.statistic.StatisticApiImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes7.dex */
public class il extends Handler {
    private ik yW;
    private Map<String, String> yX;

    public il(Looper looper, ik ikVar) {
        super(looper);
        this.yW = ikVar;
        this.yX = new HashMap();
    }

    public void b(int i, Object obj) {
        if (obj instanceof ij) {
            ij ijVar = (ij) obj;
            if (!TextUtils.isEmpty(ARConfig.getARKey())) {
                ijVar.a("ar_key", ARConfig.getARKey());
            }
            ijVar.a(ARConfigKey.AR_ID, ARConfig.getARId());
            ijVar.a(ARConfigKey.AR_FROM, ARConfig.getArFrom());
            ijVar.a("ar_type", String.valueOf(ARConfig.getARType()));
            if (!this.yX.isEmpty()) {
                ijVar.c(this.yX);
            }
        }
        Message obtainMessage = obtainMessage();
        obtainMessage.what = i;
        obtainMessage.obj = obj;
        sendMessage(obtainMessage);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        int i = message.what;
        if (i == 20) {
            this.yW.j((ij) message.obj);
            return;
        }
        if (i == 21) {
            this.yW.h((List<String>) message.obj);
            return;
        }
        switch (i) {
            case 1:
                this.yW.init();
                return;
            case 2:
                this.yW.c((ij) message.obj);
                return;
            case 3:
                this.yW.g((ij) message.obj);
                return;
            case 4:
                this.yW.h((ij) message.obj);
                return;
            case 5:
                this.yW.i((ij) message.obj);
                return;
            case 6:
                this.yW.e((ij) message.obj);
                return;
            default:
                switch (i) {
                    case 97:
                        this.yW.n(((Long) message.obj).longValue());
                        return;
                    case 98:
                        this.yW.onResume(((Long) message.obj).longValue());
                        return;
                    case 99:
                        this.yW.fW();
                        StatisticApiImpl statisticApiImpl = (StatisticApiImpl) message.obj;
                        if (statisticApiImpl != null) {
                            statisticApiImpl.doRelease();
                        }
                        message.obj = null;
                        return;
                    default:
                        return;
                }
        }
    }

    public void setPubParam(String str, String str2) {
        this.yX.put(str, str2);
    }

    public void setPubParams(Map<String, String> map) {
        if (map != null) {
            this.yX.putAll(map);
        }
    }
}
