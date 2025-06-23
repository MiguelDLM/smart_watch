package androidx.work.impl;

import androidx.work.impl.model.WorkSpec;
import java.util.List;
import java.util.Set;

public final /* synthetic */ class x0XOIxOo implements Runnable {

    /* renamed from: IIXOooo  reason: collision with root package name */
    public final /* synthetic */ boolean f566IIXOooo;

    /* renamed from: IXxxXO  reason: collision with root package name */
    public final /* synthetic */ WorkSpec f567IXxxXO;

    /* renamed from: Oo  reason: collision with root package name */
    public final /* synthetic */ WorkSpec f568Oo;

    /* renamed from: Oxx0xo  reason: collision with root package name */
    public final /* synthetic */ List f569Oxx0xo;

    /* renamed from: OxxIIOOXO  reason: collision with root package name */
    public final /* synthetic */ Set f570OxxIIOOXO;

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ WorkDatabase f571XO;

    /* renamed from: oI0IIXIo  reason: collision with root package name */
    public final /* synthetic */ String f572oI0IIXIo;

    public /* synthetic */ x0XOIxOo(WorkDatabase workDatabase, WorkSpec workSpec, WorkSpec workSpec2, List list, String str, Set set, boolean z) {
        this.f571XO = workDatabase;
        this.f568Oo = workSpec;
        this.f567IXxxXO = workSpec2;
        this.f569Oxx0xo = list;
        this.f572oI0IIXIo = str;
        this.f570OxxIIOOXO = set;
        this.f566IIXOooo = z;
    }

    public final void run() {
        WorkerUpdater.updateWorkImpl$lambda$2(this.f571XO, this.f568Oo, this.f567IXxxXO, this.f569Oxx0xo, this.f572oI0IIXIo, this.f570OxxIIOOXO, this.f566IIXOooo);
    }
}
