package androidx.navigation;

import android.os.Bundle;
import android.view.View;

public final /* synthetic */ class I0Io implements View.OnClickListener {

    /* renamed from: Oo  reason: collision with root package name */
    public final /* synthetic */ Bundle f417Oo;

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ int f418XO;

    public /* synthetic */ I0Io(int i, Bundle bundle) {
        this.f418XO = i;
        this.f417Oo = bundle;
    }

    public final void onClick(View view) {
        Navigation.createNavigateOnClickListener$lambda$0(this.f418XO, this.f417Oo, view);
    }
}
