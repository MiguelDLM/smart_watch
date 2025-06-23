package androidx.constraintlayout.motion.widget;

import android.view.View;

public final /* synthetic */ class oIX0oI implements Runnable {

    /* renamed from: Oo  reason: collision with root package name */
    public final /* synthetic */ View[] f291Oo;

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ ViewTransition f292XO;

    public /* synthetic */ oIX0oI(ViewTransition viewTransition, View[] viewArr) {
        this.f292XO = viewTransition;
        this.f291Oo = viewArr;
    }

    public final void run() {
        this.f292XO.lambda$applyTransition$0(this.f291Oo);
    }
}
