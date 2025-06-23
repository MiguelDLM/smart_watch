package androidx.navigation.ui;

import android.view.MenuItem;
import androidx.navigation.NavController;
import com.google.android.material.navigation.NavigationBarView;

public final /* synthetic */ class X0o0xo implements NavigationBarView.OnItemSelectedListener {

    /* renamed from: oIX0oI  reason: collision with root package name */
    public final /* synthetic */ NavController f426oIX0oI;

    public /* synthetic */ X0o0xo(NavController navController) {
        this.f426oIX0oI = navController;
    }

    public final boolean onNavigationItemSelected(MenuItem menuItem) {
        return NavigationUI.setupWithNavController$lambda$6(this.f426oIX0oI, menuItem);
    }
}
