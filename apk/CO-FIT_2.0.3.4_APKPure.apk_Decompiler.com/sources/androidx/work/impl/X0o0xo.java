package androidx.work.impl;

import androidx.work.Configuration;
import androidx.work.impl.model.WorkGenerationalId;
import java.util.List;

public final /* synthetic */ class X0o0xo implements Runnable {

    /* renamed from: IXxxXO  reason: collision with root package name */
    public final /* synthetic */ Configuration f522IXxxXO;

    /* renamed from: Oo  reason: collision with root package name */
    public final /* synthetic */ WorkGenerationalId f523Oo;

    /* renamed from: Oxx0xo  reason: collision with root package name */
    public final /* synthetic */ WorkDatabase f524Oxx0xo;

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ List f525XO;

    public /* synthetic */ X0o0xo(List list, WorkGenerationalId workGenerationalId, Configuration configuration, WorkDatabase workDatabase) {
        this.f525XO = list;
        this.f523Oo = workGenerationalId;
        this.f522IXxxXO = configuration;
        this.f524Oxx0xo = workDatabase;
    }

    public final void run() {
        Schedulers.lambda$registerRescheduling$0(this.f525XO, this.f523Oo, this.f522IXxxXO, this.f524Oxx0xo);
    }
}
