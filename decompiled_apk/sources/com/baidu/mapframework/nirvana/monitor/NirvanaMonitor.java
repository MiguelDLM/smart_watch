package com.baidu.mapframework.nirvana.monitor;

import com.baidu.mapframework.nirvana.Utils;
import com.baidu.mapframework.nirvana.module.Module;
import com.baidu.mapframework.nirvana.schedule.ScheduleConfig;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.Executors;

/* loaded from: classes7.dex */
public class NirvanaMonitor {
    public static final String TAG = "NirvanaMonitor";

    /* renamed from: a, reason: collision with root package name */
    private boolean f6104a;
    private HashMap<Integer, Record> b = new HashMap<>();
    private HashMap<Integer, Record> c = new HashMap<>();

    public NirvanaMonitor(boolean z) {
        this.f6104a = z;
    }

    public boolean isEnable() {
        return this.f6104a;
    }

    public synchronized void markFinish(Object obj) {
        if (!this.f6104a) {
            return;
        }
        Record record = this.c.get(Integer.valueOf(obj.hashCode()));
        if (record != null) {
            this.c.remove(Integer.valueOf(obj.hashCode()));
            record.e();
            a(record);
        }
    }

    public synchronized void markRunning(Object obj) {
        if (!this.f6104a) {
            return;
        }
        Record record = this.b.get(Integer.valueOf(obj.hashCode()));
        if (record != null) {
            this.b.remove(Integer.valueOf(obj.hashCode()));
            record.d();
            this.c.put(Integer.valueOf(obj.hashCode()), record);
        }
    }

    public synchronized void markSubmit(RecordType recordType, Object obj, Module module, ScheduleConfig scheduleConfig) {
        if (!this.f6104a) {
            return;
        }
        this.b.put(Integer.valueOf(obj.hashCode()), new Record(recordType, obj, module, scheduleConfig));
    }

    public synchronized void setEnable(boolean z) {
        if (this.f6104a != z) {
            this.f6104a = z;
            this.b.clear();
            this.c.clear();
        }
    }

    private void a(Record record) {
        if (record.getType() == RecordType.LOOPER) {
            a(record, 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        String str = TAG;
        Utils.logi(str, "-----------                      -----------");
        Utils.logi(str, "----------- nirvana status begin -----------");
        Utils.logi(str, "waiting task:");
        Iterator<Record> it = this.b.values().iterator();
        while (it.hasNext()) {
            a(it.next());
        }
        Utils.logi(TAG, "running task:");
        Iterator<Record> it2 = this.c.values().iterator();
        while (it2.hasNext()) {
            a(it2.next());
        }
        String str2 = TAG;
        Utils.logi(str2, "----------- nirvana status end -----------");
        Utils.logi(str2, "-----------                    -----------");
    }

    private void a(Record record, long j) {
        if (record.a() > j) {
            String str = TAG;
            Utils.loge(str, record.getType() + ": " + record);
            Utils.loge(str, record.getType() + " module: " + record.getModule());
            Utils.loge(str, record.getType() + " cost: " + record.a());
            StringBuilder sb = new StringBuilder();
            sb.append(record.getType());
            sb.append(" trace: ");
            Utils.loge(str, sb.toString(), record.getTrace());
            return;
        }
        Utils.logi(TAG, record.getType() + ": " + record);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a() {
        Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: com.baidu.mapframework.nirvana.monitor.NirvanaMonitor.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Thread.sleep(3000L);
                } catch (InterruptedException unused) {
                }
                if (!NirvanaMonitor.this.b.isEmpty() || !NirvanaMonitor.this.c.isEmpty()) {
                    NirvanaMonitor.this.b();
                }
                NirvanaMonitor.this.a();
            }
        });
    }
}
