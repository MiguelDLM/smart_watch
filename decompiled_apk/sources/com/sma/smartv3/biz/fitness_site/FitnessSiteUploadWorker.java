package com.sma.smartv3.biz.fitness_site;

import OXOo.OOXIXo;
import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.sma.smartv3.db.MyDb;
import com.sma.smartv3.db.entity.WorkoutIndex;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class FitnessSiteUploadWorker extends Worker {

    @OOXIXo
    public static final oIX0oI Companion = new oIX0oI(null);

    @OOXIXo
    public static final String TAG = "FitnessSiteUploadWorker";

    @OOXIXo
    private final Context context;

    /* loaded from: classes12.dex */
    public static final class oIX0oI {
        public /* synthetic */ oIX0oI(IIXOooo iIXOooo) {
            this();
        }

        public oIX0oI() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FitnessSiteUploadWorker(@OOXIXo Context context, @OOXIXo WorkerParameters params) {
        super(context, params);
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(params, "params");
        this.context = context;
    }

    @Override // androidx.work.Worker
    @OOXIXo
    public ListenableWorker.Result doWork() {
        WorkoutIndex notSynced = MyDb.INSTANCE.getMDatabase().workoutIndexDao().getNotSynced();
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("FitnessSiteUploadWorker doWork -> " + notSynced);
        if (notSynced == null) {
            ListenableWorker.Result success = ListenableWorker.Result.success();
            IIX0o.oO(success, "success(...)");
            return success;
        }
        FunctionKt.II0XooXoX(this.context, notSynced, null, 4, null);
        ListenableWorker.Result success2 = ListenableWorker.Result.success();
        IIX0o.oO(success2, "success(...)");
        return success2;
    }

    @OOXIXo
    public final Context getContext() {
        return this.context;
    }
}
