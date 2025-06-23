package androidx.navigation;

import android.view.View;

public final /* synthetic */ class II0xO0 implements View.OnClickListener {

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ NavDirections f419XO;

    public /* synthetic */ II0xO0(NavDirections navDirections) {
        this.f419XO = navDirections;
    }

    public final void onClick(View view) {
        Navigation.createNavigateOnClickListener$lambda$1(this.f419XO, view);
    }
}
