package androidx.navigation.ui;

import android.view.MenuItem;
import androidx.navigation.NavController;
import com.google.android.material.navigation.NavigationView;

public final /* synthetic */ class XO implements NavigationView.OnNavigationItemSelectedListener {

    /* renamed from: II0xO0  reason: collision with root package name */
    public final /* synthetic */ NavigationView f427II0xO0;

    /* renamed from: oIX0oI  reason: collision with root package name */
    public final /* synthetic */ NavController f428oIX0oI;

    public /* synthetic */ XO(NavController navController, NavigationView navigationView) {
        this.f428oIX0oI = navController;
        this.f427II0xO0 = navigationView;
    }

    public final boolean onNavigationItemSelected(MenuItem menuItem) {
        return NavigationUI.setupWithNavController$lambda$3(this.f428oIX0oI, this.f427II0xO0, menuItem);
    }
}
