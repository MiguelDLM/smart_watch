package com.baidu.mapframework.nirvana.looper;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import com.baidu.mapframework.nirvana.ExceptionCallback;
import com.baidu.mapframework.nirvana.NirvanaFramework;
import com.baidu.mapframework.nirvana.Utils;
import com.baidu.mapframework.nirvana.module.Module;
import com.baidu.mapframework.nirvana.monitor.RecordType;
import com.baidu.mapframework.nirvana.schedule.ScheduleConfig;

/* loaded from: classes7.dex */
public abstract class MainLooperHandler extends Handler {

    /* renamed from: a, reason: collision with root package name */
    private final Module f6100a;
    private final ScheduleConfig b;
    private ExceptionCallback c;

    public MainLooperHandler(@NonNull Module module, @NonNull ScheduleConfig scheduleConfig) {
        super(Looper.getMainLooper());
        this.f6100a = module;
        this.b = scheduleConfig;
    }

    @Override // android.os.Handler
    public final void dispatchMessage(Message message) {
        super.dispatchMessage(message);
    }

    public ExceptionCallback getExceptionCallback() {
        return this.c;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        if (message == null) {
            return;
        }
        final Message obtain = Message.obtain();
        obtain.copyFrom(message);
        NirvanaFramework.getLooperBuffer().run(new Runnable() { // from class: com.baidu.mapframework.nirvana.looper.MainLooperHandler.1
            @Override // java.lang.Runnable
            public void run() {
                NirvanaFramework.getMonitor().markRunning(obtain);
                try {
                    MainLooperHandler.this.onMessage(obtain);
                } catch (Exception e) {
                    Utils.loge("MainLooperHandler handleMessage exception", e);
                    if (MainLooperHandler.this.c != null) {
                        MainLooperHandler.this.c.onException(e);
                    }
                }
                NirvanaFramework.getMonitor().markFinish(obtain);
                obtain.recycle();
            }
        });
    }

    public abstract void onMessage(Message message);

    @Override // android.os.Handler
    public final boolean sendMessageAtTime(Message message, long j) {
        NirvanaFramework.getMonitor().markSubmit(RecordType.LOOPER, message, this.f6100a, this.b);
        return super.sendMessageAtTime(message, j);
    }

    public void setExceptionCallback(ExceptionCallback exceptionCallback) {
        this.c = exceptionCallback;
    }
}
