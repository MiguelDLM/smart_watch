package com.baidu.mapframework.nirvana.monitor;

import android.os.Looper;
import com.baidu.mapframework.nirvana.module.Module;
import com.baidu.mapframework.nirvana.schedule.ScheduleConfig;
import java.util.Date;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class Record {

    /* renamed from: a, reason: collision with root package name */
    private RecordType f6106a;
    private Object b;
    private Module c;
    private ScheduleConfig d;
    private long f;
    private long g;
    private String h;
    private boolean i;
    private long e = System.currentTimeMillis();
    private Throwable j = new Throwable();

    /* loaded from: classes7.dex */
    public enum State {
        WAITING,
        RUNNING,
        FINISH
    }

    public Record(RecordType recordType, Object obj, Module module, ScheduleConfig scheduleConfig) {
        this.f6106a = recordType;
        this.b = obj;
        this.c = module;
        this.d = scheduleConfig;
    }

    private boolean f() {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            return true;
        }
        return false;
    }

    public long a() {
        return this.g - this.f;
    }

    public State b() {
        if (this.f == 0) {
            return State.WAITING;
        }
        if (this.g == 0) {
            return State.RUNNING;
        }
        return State.FINISH;
    }

    public long c() {
        return this.f - this.e;
    }

    public void d() {
        this.f = System.currentTimeMillis();
        this.h = Thread.currentThread().getName();
        this.i = f();
    }

    public void e() {
        this.g = System.currentTimeMillis();
    }

    public Module getModule() {
        return this.c;
    }

    public Throwable getTrace() {
        return this.j;
    }

    public RecordType getType() {
        return this.f6106a;
    }

    public String toString() {
        return "Record{, module=" + this.c + ", type=" + this.f6106a + ", task=" + this.b.toString() + ", state=" + b() + ", cost=" + a() + ", waiting=" + c() + ", threadInfo=" + this.h + ", isUIThread=" + this.i + ", createTime=" + new Date(this.e) + ", startTime=" + new Date(this.f) + ", endTime=" + new Date(this.g) + ", config=" + this.d + '}';
    }
}
