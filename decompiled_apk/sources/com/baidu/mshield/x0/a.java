package com.baidu.mshield.x0;

/* loaded from: classes7.dex */
public class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6394a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ EngineImpl c;

    public a(EngineImpl engineImpl, int i, boolean z) {
        this.c = engineImpl;
        this.f6394a = i;
        this.b = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.c.doInit(this.f6394a, this.b);
    }
}
