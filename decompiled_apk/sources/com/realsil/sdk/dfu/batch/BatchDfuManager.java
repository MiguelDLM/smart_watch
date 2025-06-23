package com.realsil.sdk.dfu.batch;

import android.content.Context;
import com.realsil.sdk.core.logger.ZLogger;
import com.realsil.sdk.dfu.RtkDfu;
import com.realsil.sdk.dfu.internal.base.BaseDfuTask;
import com.realsil.sdk.dfu.internal.base.DfuThreadCallback;
import com.realsil.sdk.dfu.model.DfuConfig;
import com.realsil.sdk.dfu.model.DfuProgressInfo;
import com.realsil.sdk.dfu.model.Throughput;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes11.dex */
public final class BatchDfuManager {
    public static volatile BatchDfuManager f;

    /* renamed from: a, reason: collision with root package name */
    public boolean f19535a = RtkDfu.DEBUG_ENABLE;
    public boolean b = RtkDfu.VDBG;
    public Context c;
    public BatchDfuCallback d;
    public List<BaseDfuTask> e;

    /* loaded from: classes11.dex */
    public class a extends DfuThreadCallback {

        /* renamed from: a, reason: collision with root package name */
        public String f19536a;

        public a(String str) {
            this.f19536a = str;
        }

        @Override // com.realsil.sdk.dfu.internal.base.DfuThreadCallback
        public void onError(int i) {
            super.onError(i);
            if (BatchDfuManager.this.d != null) {
                BatchDfuManager.this.d.onError(this.f19536a, i);
            }
        }

        @Override // com.realsil.sdk.dfu.internal.base.DfuThreadCallback
        public void onProgressChanged(DfuProgressInfo dfuProgressInfo) {
            super.onProgressChanged(dfuProgressInfo);
            if (BatchDfuManager.this.d != null) {
                BatchDfuManager.this.d.onProgressChanged(this.f19536a, dfuProgressInfo);
            }
        }

        @Override // com.realsil.sdk.dfu.internal.base.DfuThreadCallback
        public void onStateChanged(int i, Throughput throughput) {
            super.onStateChanged(i, throughput);
            if (BatchDfuManager.this.d != null) {
                BatchDfuManager.this.d.onStateChanged(this.f19536a, i, throughput);
            }
        }
    }

    public BatchDfuManager(Context context) {
        this.c = context;
    }

    public static BatchDfuManager getInstance(Context context) {
        if (f == null) {
            synchronized (BatchDfuManager.class) {
                try {
                    if (f == null) {
                        f = new BatchDfuManager(context.getApplicationContext());
                    }
                } finally {
                }
            }
        }
        return f;
    }

    public boolean abort() {
        List<BaseDfuTask> list = this.e;
        if (list != null && list.size() > 0) {
            Iterator<BaseDfuTask> it = this.e.iterator();
            while (it.hasNext()) {
                it.next().abort();
            }
            return true;
        }
        return false;
    }

    public boolean destroy() {
        List<BaseDfuTask> list = this.e;
        if (list != null && list.size() > 0) {
            for (BaseDfuTask baseDfuTask : this.e) {
                baseDfuTask.abort();
                baseDfuTask.onDestroy();
            }
            return true;
        }
        return false;
    }

    public boolean start(List<DfuConfig> list, BatchDfuCallback batchDfuCallback) {
        if (list != null && list.size() > 0) {
            this.d = batchDfuCallback;
            List<BaseDfuTask> list2 = this.e;
            if (list2 == null) {
                this.e = new CopyOnWriteArrayList();
            } else {
                list2.clear();
            }
            for (DfuConfig dfuConfig : list) {
                BaseDfuTask a2 = com.realsil.sdk.dfu.i.a.a(this.c, dfuConfig, null, new a(dfuConfig.getAddress()));
                if (a2 != null) {
                    this.e.add(a2);
                    a2.start();
                }
            }
            return true;
        }
        ZLogger.w("dfuConfigs cannot be null or empty");
        return false;
    }
}
