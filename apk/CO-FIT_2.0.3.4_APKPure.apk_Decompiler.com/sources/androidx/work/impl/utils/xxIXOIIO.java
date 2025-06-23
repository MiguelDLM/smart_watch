package androidx.work.impl.utils;

import java.util.concurrent.Callable;

public final /* synthetic */ class xxIXOIIO implements Callable {

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ IdGenerator f565XO;

    public /* synthetic */ xxIXOIIO(IdGenerator idGenerator) {
        this.f565XO = idGenerator;
    }

    public final Object call() {
        return IdGenerator.nextAlarmManagerId$lambda$1(this.f565XO);
    }
}
