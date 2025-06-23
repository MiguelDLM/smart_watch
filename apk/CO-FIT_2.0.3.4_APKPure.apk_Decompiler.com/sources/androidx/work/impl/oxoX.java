package androidx.work.impl;

import androidx.work.Configuration;
import androidx.work.impl.model.WorkGenerationalId;
import java.util.List;
import java.util.concurrent.Executor;

public final /* synthetic */ class oxoX implements ExecutionListener {

    /* renamed from: IXxxXO  reason: collision with root package name */
    public final /* synthetic */ Configuration f541IXxxXO;

    /* renamed from: Oo  reason: collision with root package name */
    public final /* synthetic */ List f542Oo;

    /* renamed from: Oxx0xo  reason: collision with root package name */
    public final /* synthetic */ WorkDatabase f543Oxx0xo;

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ Executor f544XO;

    public /* synthetic */ oxoX(Executor executor, List list, Configuration configuration, WorkDatabase workDatabase) {
        this.f544XO = executor;
        this.f542Oo = list;
        this.f541IXxxXO = configuration;
        this.f543Oxx0xo = workDatabase;
    }

    public final void onExecuted(WorkGenerationalId workGenerationalId, boolean z) {
        this.f544XO.execute(new X0o0xo(this.f542Oo, workGenerationalId, this.f541IXxxXO, this.f543Oxx0xo));
    }
}
