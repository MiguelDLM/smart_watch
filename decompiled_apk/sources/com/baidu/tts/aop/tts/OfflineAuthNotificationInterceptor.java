package com.baidu.tts.aop.tts;

import android.text.TextUtils;
import com.baidu.tts.aop.AInterceptor;
import com.baidu.tts.aop.AInterceptorHandler;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.d5;
import com.baidu.tts.j;
import com.baidu.tts.m;
import com.baidu.tts.w2;
import com.baidu.tts.y4;
import com.baidu.tts.z4;
import java.lang.reflect.Method;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes8.dex */
public class OfflineAuthNotificationInterceptor extends AInterceptor {
    public AtomicInteger b = new AtomicInteger(-1);

    @Override // com.baidu.tts.aop.AInterceptor
    public void a() {
        this.f10034a.add("speak");
    }

    @Override // com.baidu.tts.aop.AInterceptor
    public Object a(Object obj, Method method, Object[] objArr) {
        d5 d5Var = (d5) obj;
        if (d5Var.g == d5Var.e) {
            w2 w2Var = d5Var.e.f10043a.c;
            if (w2Var == null) {
                d5Var.b();
                return AInterceptorHandler.END;
            }
            int ordinal = w2Var.ordinal();
            if (ordinal == 1 || ordinal == 2) {
                int incrementAndGet = this.b.incrementAndGet();
                LoggerProxy.d("OfflineAuthNotificationInterceptor", "currentCount=" + incrementAndGet);
                if (incrementAndGet % 20 == 0) {
                    y4 y4Var = (y4) objArr[0];
                    z4 ttsParams = d5Var.getTtsParams();
                    if (ttsParams != null) {
                        return a(ttsParams, y4Var);
                    }
                    d5Var.b();
                    return AInterceptorHandler.END;
                }
            }
            return AInterceptorHandler.DEFAULT;
        }
        d5Var.b();
        return AInterceptorHandler.END;
    }

    public final Object a(z4 z4Var, y4 y4Var) {
        m.a a2 = j.a().a(z4Var.f10209a.b);
        int i = a2.f10133a;
        if (i >= 10000) {
            y4Var.e = String.format(Locale.US, "百度语音试用服务%d天后到期，", Integer.valueOf(i >= 10000 ? i - 10000 : 0));
        }
        int i2 = a2.f10133a;
        if (i2 == -5 || i2 == -6) {
            y4Var.e = "百度语音试用服务已经到期，请及时更新授权，";
        }
        if (!TextUtils.isEmpty(y4Var.e)) {
            y4Var.f10206a = y4Var.e + y4Var.f10206a;
        }
        return AInterceptorHandler.DEFAULT;
    }
}
