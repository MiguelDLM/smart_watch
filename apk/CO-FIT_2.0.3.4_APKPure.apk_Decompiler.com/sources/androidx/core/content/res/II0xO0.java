package androidx.core.content.res;

import androidx.core.content.res.ResourcesCompat;

public final /* synthetic */ class II0xO0 implements Runnable {

    /* renamed from: Oo  reason: collision with root package name */
    public final /* synthetic */ int f306Oo;

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ ResourcesCompat.FontCallback f307XO;

    public /* synthetic */ II0xO0(ResourcesCompat.FontCallback fontCallback, int i) {
        this.f307XO = fontCallback;
        this.f306Oo = i;
    }

    public final void run() {
        this.f307XO.lambda$callbackFailAsync$1(this.f306Oo);
    }
}
