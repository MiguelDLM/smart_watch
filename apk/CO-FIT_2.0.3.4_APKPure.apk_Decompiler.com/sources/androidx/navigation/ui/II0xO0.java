package androidx.navigation.ui;

import android.view.View;
import androidx.navigation.NavController;

public final /* synthetic */ class II0xO0 implements View.OnClickListener {

    /* renamed from: Oo  reason: collision with root package name */
    public final /* synthetic */ AppBarConfiguration f424Oo;

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ NavController f425XO;

    public /* synthetic */ II0xO0(NavController navController, AppBarConfiguration appBarConfiguration) {
        this.f425XO = navController;
        this.f424Oo = appBarConfiguration;
    }

    public final void onClick(View view) {
        NavigationUI.setupWithNavController$lambda$1(this.f425XO, this.f424Oo, view);
    }
}
