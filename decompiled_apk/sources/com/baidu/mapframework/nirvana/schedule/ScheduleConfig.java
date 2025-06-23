package com.baidu.mapframework.nirvana.schedule;

import com.baidu.mapframework.nirvana.NirvanaFramework;
import com.baidu.mapframework.nirvana.schedule.LifecycleManager;

/* loaded from: classes7.dex */
public class ScheduleConfig {
    private static final ScheduleConfig d;
    private static final ScheduleConfig e;
    private static final ScheduleConfig f;

    /* renamed from: a, reason: collision with root package name */
    private final TaskType f6119a;
    private final ScheduleTag b;
    private LifecycleManager.Lifecycle c;

    static {
        DataTaskType forUpdateData = DataTaskType.forUpdateData();
        ScheduleTag scheduleTag = ScheduleTag.NULL;
        d = new ScheduleConfig(forUpdateData, scheduleTag);
        e = new ScheduleConfig(DataTaskType.forUpdateData(), ScheduleTag.SETUP);
        f = new ScheduleConfig(DataTaskType.forStatictics(), scheduleTag);
    }

    public ScheduleConfig(TaskType taskType, ScheduleTag scheduleTag) {
        this.f6119a = taskType;
        this.b = scheduleTag;
    }

    public static ScheduleConfig forData() {
        return d;
    }

    public static ScheduleConfig forSetupData() {
        return e;
    }

    public static ScheduleConfig forStatistics() {
        return f;
    }

    public static ScheduleConfig uiPage(String str) {
        return new ScheduleConfig(UITaskType.forPage(str), ScheduleTag.NULL);
    }

    public static ScheduleConfig uiScene(String str) {
        return new ScheduleConfig(UITaskType.forScene(str), ScheduleTag.NULL);
    }

    public void bindLifecycle() {
        TaskType taskType = this.f6119a;
        if (taskType instanceof UITaskType) {
            UITaskType uITaskType = (UITaskType) taskType;
            this.c = NirvanaFramework.getLifecycleManager().a(uITaskType.getType(), uITaskType.getName());
        }
    }

    public ScheduleTag getTag() {
        return this.b;
    }

    public TaskType getType() {
        return this.f6119a;
    }

    public boolean isLifecycleActive() {
        LifecycleManager.Lifecycle lifecycle = this.c;
        if (lifecycle != null) {
            return lifecycle.isActive();
        }
        return true;
    }

    public String toString() {
        return "ScheduleConfig{type=" + this.f6119a + ", tag=" + this.b + '}';
    }
}
