package androidx.work.impl;

import java.util.ArrayList;
import java.util.concurrent.Callable;

public final /* synthetic */ class II0xO0 implements Callable {

    /* renamed from: IXxxXO  reason: collision with root package name */
    public final /* synthetic */ String f515IXxxXO;

    /* renamed from: Oo  reason: collision with root package name */
    public final /* synthetic */ ArrayList f516Oo;

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ Processor f517XO;

    public /* synthetic */ II0xO0(Processor processor, ArrayList arrayList, String str) {
        this.f517XO = processor;
        this.f516Oo = arrayList;
        this.f515IXxxXO = str;
    }

    public final Object call() {
        return this.f517XO.lambda$startWork$0(this.f516Oo, this.f515IXxxXO);
    }
}
