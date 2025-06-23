package androidx.work.impl.utils;

import Oox.oIX0oI;
import androidx.work.Data;
import java.util.UUID;

public final /* synthetic */ class OxxIIOOXO implements oIX0oI {

    /* renamed from: IXxxXO  reason: collision with root package name */
    public final /* synthetic */ Data f549IXxxXO;

    /* renamed from: Oo  reason: collision with root package name */
    public final /* synthetic */ UUID f550Oo;

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ WorkProgressUpdater f551XO;

    public /* synthetic */ OxxIIOOXO(WorkProgressUpdater workProgressUpdater, UUID uuid, Data data) {
        this.f551XO = workProgressUpdater;
        this.f550Oo = uuid;
        this.f549IXxxXO = data;
    }

    public final Object invoke() {
        return this.f551XO.lambda$updateProgress$0(this.f550Oo, this.f549IXxxXO);
    }
}
