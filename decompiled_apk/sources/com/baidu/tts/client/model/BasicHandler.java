package com.baidu.tts.client.model;

import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.facebook.login.widget.ToolTipPopup;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes8.dex */
public class BasicHandler<T> {

    /* renamed from: a, reason: collision with root package name */
    public FutureTask<T> f10055a;

    public BasicHandler(FutureTask<T> futureTask) {
        this.f10055a = futureTask;
    }

    public boolean cancel() {
        return this.f10055a.cancel(true);
    }

    public T get() {
        try {
            LoggerProxy.d("BasicHandler", "before get");
            return this.f10055a.get(ToolTipPopup.DEFAULT_POPUP_DISPLAY_TIME, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            LoggerProxy.d("BasicHandler", e.toString());
            return null;
        } catch (ExecutionException e2) {
            LoggerProxy.d("BasicHandler", e2.getCause().toString());
            return null;
        } catch (TimeoutException e3) {
            LoggerProxy.d("BasicHandler", e3.toString());
            return null;
        }
    }

    public void start() {
        Thread thread = new Thread(this.f10055a);
        thread.setName("bdtts-BasicHandler");
        thread.start();
    }
}
