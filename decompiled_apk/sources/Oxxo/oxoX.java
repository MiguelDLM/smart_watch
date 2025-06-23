package Oxxo;

/* loaded from: classes6.dex */
public class oxoX implements Runnable {

    /* renamed from: Oo, reason: collision with root package name */
    public final /* synthetic */ X0o0xo f3157Oo;

    /* renamed from: XO, reason: collision with root package name */
    public final /* synthetic */ xxIXOIIO f3158XO;

    public oxoX(X0o0xo x0o0xo, xxIXOIIO xxixoiio) {
        this.f3157Oo = x0o0xo;
        this.f3158XO = xxixoiio;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f3157Oo.nodeChanged(this.f3158XO);
    }
}
