package com.baidu.mapframework.nirvana.looper;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.baidu.mapframework.nirvana.ExceptionCallback;
import com.baidu.mapframework.nirvana.NirvanaFramework;
import com.baidu.mapframework.nirvana.Utils;
import com.baidu.mapframework.nirvana.module.Module;
import com.baidu.mapframework.nirvana.monitor.RecordType;
import com.baidu.mapframework.nirvana.schedule.ScheduleConfig;

/* loaded from: classes7.dex */
public class LooperManager {

    /* renamed from: a, reason: collision with root package name */
    private static final Handler f6095a;
    private static final IdleRunner b;

    static {
        Handler handler = new Handler(Looper.getMainLooper());
        f6095a = handler;
        b = new IdleRunner(handler);
    }

    public static DiscreteQueueToken createDiscreteQueue(Module module) {
        return new DiscreteQueueToken(new DiscreteRunner(f6095a));
    }

    public static void destroyDiscreteQueue(DiscreteQueueToken discreteQueueToken) {
        discreteQueueToken.a().a();
    }

    public static void executeTask(@NonNull Module module, @NonNull LooperTask looperTask, @NonNull ScheduleConfig scheduleConfig) {
        if (Utils.executeParamCheck(module, looperTask, scheduleConfig)) {
            NirvanaFramework.getMonitor().markSubmit(RecordType.LOOPER, looperTask, module, scheduleConfig);
            final Runnable a2 = a(looperTask, scheduleConfig);
            looperTask.a(new Runnable() { // from class: com.baidu.mapframework.nirvana.looper.LooperManager.1
                @Override // java.lang.Runnable
                public void run() {
                    LooperManager.f6095a.removeCallbacks(a2);
                }
            });
            f6095a.postDelayed(a2, looperTask.getDelay());
        }
    }

    public static void executeTaskDiscreted(@NonNull Module module, @NonNull DiscreteQueueToken discreteQueueToken, @NonNull DiscreteLooperTask discreteLooperTask, @NonNull ScheduleConfig scheduleConfig) {
        if (Utils.executeParamCheck(module, discreteLooperTask, scheduleConfig) && discreteQueueToken != null) {
            discreteLooperTask.appendDescription("executeTaskDiscreted");
            discreteLooperTask.appendDescription("DiscreteQueueToken " + discreteQueueToken.hashCode());
            NirvanaFramework.getMonitor().markSubmit(RecordType.LOOPER, discreteLooperTask, module, scheduleConfig);
            discreteQueueToken.a().a(a(discreteLooperTask, scheduleConfig));
        }
    }

    public static void executeTaskWhenIdle(@NonNull Module module, @NonNull DiscreteLooperTask discreteLooperTask, @NonNull ScheduleConfig scheduleConfig) {
        if (!Utils.executeParamCheck(module, discreteLooperTask, scheduleConfig)) {
            return;
        }
        discreteLooperTask.appendDescription("executeTaskWhenIdle");
        NirvanaFramework.getMonitor().markSubmit(RecordType.LOOPER, discreteLooperTask, module, scheduleConfig);
        b.a(a(discreteLooperTask, scheduleConfig));
    }

    private static Runnable a(final BaseLooperTask baseLooperTask, final ScheduleConfig scheduleConfig) {
        return new Runnable() { // from class: com.baidu.mapframework.nirvana.looper.LooperManager.3
            @Override // java.lang.Runnable
            public void run() {
                NirvanaFramework.getLooperBuffer().run(new Runnable() { // from class: com.baidu.mapframework.nirvana.looper.LooperManager.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        NirvanaFramework.getMonitor().markRunning(BaseLooperTask.this);
                        try {
                            if (!BaseLooperTask.this.isCancel() && scheduleConfig.isLifecycleActive()) {
                                BaseLooperTask.this.run();
                            }
                        } catch (Exception e) {
                            ExceptionCallback exceptionCallback = BaseLooperTask.this.getExceptionCallback();
                            if (exceptionCallback != null) {
                                exceptionCallback.onException(e);
                            } else {
                                NirvanaFramework.onUncaughtException("LooperManager", e);
                            }
                        }
                        NirvanaFramework.getMonitor().markFinish(BaseLooperTask.this);
                    }
                });
            }
        };
    }

    public static void executeTask(@NonNull Module module, @NonNull LooperTask looperTask, int i, @NonNull ScheduleConfig scheduleConfig) {
        if (Utils.executeParamCheck(module, looperTask, scheduleConfig)) {
            NirvanaFramework.getMonitor().markSubmit(RecordType.LOOPER, looperTask, module, scheduleConfig);
            final Runnable a2 = a(looperTask, scheduleConfig);
            looperTask.a(new Runnable() { // from class: com.baidu.mapframework.nirvana.looper.LooperManager.2
                @Override // java.lang.Runnable
                public void run() {
                    LooperManager.f6095a.removeCallbacks(a2);
                }
            });
            f6095a.postDelayed(a2, i);
        }
    }
}
