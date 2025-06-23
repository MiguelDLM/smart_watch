package com.baidu.navcore.http;

import android.os.Message;
import com.baidu.mapframework.nirvana.NirvanaFramework;
import com.baidu.mapframework.nirvana.module.Module;
import com.baidu.mapframework.nirvana.monitor.RecordType;
import com.baidu.mapframework.nirvana.schedule.DataTaskType;
import com.baidu.mapframework.nirvana.schedule.ScheduleConfig;
import com.baidu.mapframework.nirvana.schedule.ScheduleTag;

/* loaded from: classes7.dex */
public class e implements com.baidu.navisdk.util.worker.loop.e {

    /* renamed from: a, reason: collision with root package name */
    private Module f6461a = Module.NAV_MODULE;
    private ScheduleConfig b = new ScheduleConfig(DataTaskType.forUpdateData(), ScheduleTag.NULL);

    @Override // com.baidu.navisdk.util.worker.loop.e
    public void a(Runnable runnable) {
        NirvanaFramework.getLooperBuffer().run(runnable);
    }

    @Override // com.baidu.navisdk.util.worker.loop.e
    public void b(Message message) {
        NirvanaFramework.getMonitor().markSubmit(RecordType.LOOPER, message, this.f6461a, this.b);
    }

    @Override // com.baidu.navisdk.util.worker.loop.e
    public void c(Message message) {
        NirvanaFramework.getMonitor().markFinish(message);
    }

    @Override // com.baidu.navisdk.util.worker.loop.e
    public void a(Message message) {
        NirvanaFramework.getMonitor().markRunning(message);
    }
}
