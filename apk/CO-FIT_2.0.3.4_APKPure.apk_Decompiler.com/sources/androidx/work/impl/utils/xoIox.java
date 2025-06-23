package androidx.work.impl.utils;

import java.util.concurrent.Callable;

public final /* synthetic */ class xoIox implements Callable {

    /* renamed from: IXxxXO  reason: collision with root package name */
    public final /* synthetic */ int f562IXxxXO;

    /* renamed from: Oo  reason: collision with root package name */
    public final /* synthetic */ int f563Oo;

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ IdGenerator f564XO;

    public /* synthetic */ xoIox(IdGenerator idGenerator, int i, int i2) {
        this.f564XO = idGenerator;
        this.f563Oo = i;
        this.f562IXxxXO = i2;
    }

    public final Object call() {
        return IdGenerator.nextJobSchedulerIdWithRange$lambda$0(this.f564XO, this.f563Oo, this.f562IXxxXO);
    }
}
