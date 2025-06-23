package androidx.work.impl;

import androidx.work.impl.model.WorkGenerationalId;

public final /* synthetic */ class oIX0oI implements Runnable {

    /* renamed from: IXxxXO  reason: collision with root package name */
    public final /* synthetic */ boolean f536IXxxXO;

    /* renamed from: Oo  reason: collision with root package name */
    public final /* synthetic */ WorkGenerationalId f537Oo;

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ Processor f538XO;

    public /* synthetic */ oIX0oI(Processor processor, WorkGenerationalId workGenerationalId, boolean z) {
        this.f538XO = processor;
        this.f537Oo = workGenerationalId;
        this.f536IXxxXO = z;
    }

    public final void run() {
        this.f538XO.lambda$runOnExecuted$2(this.f537Oo, this.f536IXxxXO);
    }
}
