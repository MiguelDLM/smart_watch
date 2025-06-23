package androidx.navigation.ui;

import android.view.View;
import androidx.navigation.NavController;

public final /* synthetic */ class oxoX implements View.OnClickListener {

    /* renamed from: Oo  reason: collision with root package name */
    public final /* synthetic */ AppBarConfiguration f431Oo;

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ NavController f432XO;

    public /* synthetic */ oxoX(NavController navController, AppBarConfiguration appBarConfiguration) {
        this.f432XO = navController;
        this.f431Oo = appBarConfiguration;
    }

    public final void onClick(View view) {
        NavigationUI.setupWithNavController$lambda$2(this.f432XO, this.f431Oo, view);
    }
}
