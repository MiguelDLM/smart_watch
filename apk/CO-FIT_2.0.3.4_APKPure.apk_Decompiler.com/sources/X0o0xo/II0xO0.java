package X0o0xo;

import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.fragment.app.strictmode.Violation;

public final /* synthetic */ class II0xO0 implements Runnable {

    /* renamed from: Oo  reason: collision with root package name */
    public final /* synthetic */ Violation f228Oo;

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ String f229XO;

    public /* synthetic */ II0xO0(String str, Violation violation) {
        this.f229XO = str;
        this.f228Oo = violation;
    }

    public final void run() {
        FragmentStrictMode.m26handlePolicyViolation$lambda1(this.f229XO, this.f228Oo);
    }
}
