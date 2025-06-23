package X0o0xo;

import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.fragment.app.strictmode.Violation;

public final /* synthetic */ class oIX0oI implements Runnable {

    /* renamed from: Oo  reason: collision with root package name */
    public final /* synthetic */ Violation f230Oo;

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ FragmentStrictMode.Policy f231XO;

    public /* synthetic */ oIX0oI(FragmentStrictMode.Policy policy, Violation violation) {
        this.f231XO = policy;
        this.f230Oo = violation;
    }

    public final void run() {
        FragmentStrictMode.m25handlePolicyViolation$lambda0(this.f231XO, this.f230Oo);
    }
}
