package androidx.navigation.ui;

import android.view.MenuItem;
import androidx.navigation.NavController;
import com.google.android.material.navigation.NavigationBarView;

public final /* synthetic */ class oIX0oI implements NavigationBarView.OnItemSelectedListener {

    /* renamed from: II0xO0  reason: collision with root package name */
    public final /* synthetic */ boolean f429II0xO0;

    /* renamed from: oIX0oI  reason: collision with root package name */
    public final /* synthetic */ NavController f430oIX0oI;

    public /* synthetic */ oIX0oI(NavController navController, boolean z) {
        this.f430oIX0oI = navController;
        this.f429II0xO0 = z;
    }

    public final boolean onNavigationItemSelected(MenuItem menuItem) {
        return NavigationUI.setupWithNavController$lambda$8(this.f430oIX0oI, this.f429II0xO0, menuItem);
    }
}
