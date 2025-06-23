package com.sma.smartv3.work;

import OXOo.OOXIXo;
import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class DataWorker extends Worker {

    @OOXIXo
    private Context context;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataWorker(@OOXIXo Context appContext, @OOXIXo WorkerParameters workerParams) {
        super(appContext, workerParams);
        IIX0o.x0xO0oo(appContext, "appContext");
        IIX0o.x0xO0oo(workerParams, "workerParams");
        this.context = appContext;
    }

    @Override // androidx.work.Worker
    @OOXIXo
    public ListenableWorker.Result doWork() {
        Upload.f25780oIX0oI.Oxx0IOOO(this.context);
        ListenableWorker.Result success = ListenableWorker.Result.success();
        IIX0o.oO(success, "success(...)");
        return success;
    }

    @OOXIXo
    public final Context getContext() {
        return this.context;
    }

    public final void setContext(@OOXIXo Context context) {
        IIX0o.x0xO0oo(context, "<set-?>");
        this.context = context;
    }
}
