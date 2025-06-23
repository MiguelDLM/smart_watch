package androidx.navigation.ui;

import android.view.MenuItem;
import androidx.navigation.NavController;
import com.google.android.material.navigation.NavigationView;

public final /* synthetic */ class I0Io implements NavigationView.OnNavigationItemSelectedListener {

    /* renamed from: I0Io  reason: collision with root package name */
    public final /* synthetic */ NavigationView f421I0Io;

    /* renamed from: II0xO0  reason: collision with root package name */
    public final /* synthetic */ boolean f422II0xO0;

    /* renamed from: oIX0oI  reason: collision with root package name */
    public final /* synthetic */ NavController f423oIX0oI;

    public /* synthetic */ I0Io(NavController navController, boolean z, NavigationView navigationView) {
        this.f423oIX0oI = navController;
        this.f422II0xO0 = z;
        this.f421I0Io = navigationView;
    }

    public final boolean onNavigationItemSelected(MenuItem menuItem) {
        return NavigationUI.setupWithNavController$lambda$5(this.f423oIX0oI, this.f422II0xO0, this.f421I0Io, menuItem);
    }
}
