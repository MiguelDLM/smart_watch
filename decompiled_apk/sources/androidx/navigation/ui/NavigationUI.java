package androidx.navigation.ui;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.x0XOIxOo;
import XO0OX.xoIox;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.IdRes;
import androidx.annotation.RestrictTo;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.customview.widget.Openable;
import androidx.navigation.FloatingWindow;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.ui.AppBarConfiguration;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nNavigationUI.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NavigationUI.kt\nandroidx/navigation/ui/NavigationUI\n+ 2 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n1#1,714:1\n1247#2,2:715\n*S KotlinDebug\n*F\n+ 1 NavigationUI.kt\nandroidx/navigation/ui/NavigationUI\n*L\n712#1:715,2\n*E\n"})
/* loaded from: classes.dex */
public final class NavigationUI {

    @OOXIXo
    public static final NavigationUI INSTANCE = new NavigationUI();

    @OOXIXo
    private static final String TAG = "NavigationUI";

    private NavigationUI() {
    }

    @x0XOIxOo
    @oOoXoXO
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final BottomSheetBehavior<?> findBottomSheetBehavior(@OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof CoordinatorLayout.LayoutParams)) {
            Object parent = view.getParent();
            if (!(parent instanceof View)) {
                return null;
            }
            return findBottomSheetBehavior((View) parent);
        }
        CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) layoutParams).getBehavior();
        if (!(behavior instanceof BottomSheetBehavior)) {
            return null;
        }
        return (BottomSheetBehavior) behavior;
    }

    @x0XOIxOo
    public static final boolean matchDestination$navigation_ui_release(@OOXIXo NavDestination navDestination, @IdRes int i) {
        IIX0o.x0xO0oo(navDestination, "<this>");
        Iterator<NavDestination> it = NavDestination.Companion.getHierarchy(navDestination).iterator();
        while (it.hasNext()) {
            if (it.next().getId() == i) {
                return true;
            }
        }
        return false;
    }

    @x0XOIxOo
    public static final boolean navigateUp(@OOXIXo NavController navController, @oOoXoXO Openable openable) {
        IIX0o.x0xO0oo(navController, "navController");
        return navigateUp(navController, new AppBarConfiguration.Builder(navController.getGraph()).setOpenableLayout(openable).build());
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0096, code lost:
    
        if (matchDestination$navigation_ui_release(r0, r5.getItemId()) == true) goto L18;
     */
    @XO0OX.x0XOIxOo
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final boolean onNavDestinationSelected(@OXOo.OOXIXo android.view.MenuItem r5, @OXOo.OOXIXo androidx.navigation.NavController r6) {
        /*
            java.lang.String r0 = "item"
            kotlin.jvm.internal.IIX0o.x0xO0oo(r5, r0)
            java.lang.String r0 = "navController"
            kotlin.jvm.internal.IIX0o.x0xO0oo(r6, r0)
            androidx.navigation.NavOptions$Builder r0 = new androidx.navigation.NavOptions$Builder
            r0.<init>()
            r1 = 1
            androidx.navigation.NavOptions$Builder r0 = r0.setLaunchSingleTop(r1)
            androidx.navigation.NavOptions$Builder r0 = r0.setRestoreState(r1)
            androidx.navigation.NavDestination r2 = r6.getCurrentDestination()
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(r2)
            androidx.navigation.NavGraph r2 = r2.getParent()
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(r2)
            int r3 = r5.getItemId()
            androidx.navigation.NavDestination r2 = r2.findNode(r3)
            boolean r2 = r2 instanceof androidx.navigation.ActivityNavigator.Destination
            if (r2 == 0) goto L4a
            int r2 = androidx.navigation.ui.R.anim.nav_default_enter_anim
            androidx.navigation.NavOptions$Builder r2 = r0.setEnterAnim(r2)
            int r3 = androidx.navigation.ui.R.anim.nav_default_exit_anim
            androidx.navigation.NavOptions$Builder r2 = r2.setExitAnim(r3)
            int r3 = androidx.navigation.ui.R.anim.nav_default_pop_enter_anim
            androidx.navigation.NavOptions$Builder r2 = r2.setPopEnterAnim(r3)
            int r3 = androidx.navigation.ui.R.anim.nav_default_pop_exit_anim
            r2.setPopExitAnim(r3)
            goto L61
        L4a:
            int r2 = androidx.navigation.ui.R.animator.nav_default_enter_anim
            androidx.navigation.NavOptions$Builder r2 = r0.setEnterAnim(r2)
            int r3 = androidx.navigation.ui.R.animator.nav_default_exit_anim
            androidx.navigation.NavOptions$Builder r2 = r2.setExitAnim(r3)
            int r3 = androidx.navigation.ui.R.animator.nav_default_pop_enter_anim
            androidx.navigation.NavOptions$Builder r2 = r2.setPopEnterAnim(r3)
            int r3 = androidx.navigation.ui.R.animator.nav_default_pop_exit_anim
            r2.setPopExitAnim(r3)
        L61:
            int r2 = r5.getOrder()
            r3 = 196608(0x30000, float:2.75506E-40)
            r2 = r2 & r3
            r3 = 0
            if (r2 != 0) goto L7c
            androidx.navigation.NavGraph$Companion r2 = androidx.navigation.NavGraph.Companion
            androidx.navigation.NavGraph r4 = r6.getGraph()
            androidx.navigation.NavDestination r2 = r2.findStartDestination(r4)
            int r2 = r2.getId()
            r0.setPopUpTo(r2, r3, r1)
        L7c:
            androidx.navigation.NavOptions r0 = r0.build()
            int r2 = r5.getItemId()     // Catch: java.lang.IllegalArgumentException -> L9b
            r4 = 0
            r6.navigate(r2, r4, r0)     // Catch: java.lang.IllegalArgumentException -> L9b
            androidx.navigation.NavDestination r0 = r6.getCurrentDestination()     // Catch: java.lang.IllegalArgumentException -> L9b
            if (r0 == 0) goto L99
            int r2 = r5.getItemId()     // Catch: java.lang.IllegalArgumentException -> L9b
            boolean r5 = matchDestination$navigation_ui_release(r0, r2)     // Catch: java.lang.IllegalArgumentException -> L9b
            if (r5 != r1) goto L99
            goto L9d
        L99:
            r1 = 0
            goto L9d
        L9b:
            r0 = move-exception
            goto L9f
        L9d:
            r3 = r1
            goto Lcf
        L9f:
            androidx.navigation.NavDestination$Companion r1 = androidx.navigation.NavDestination.Companion
            android.content.Context r2 = r6.getContext()
            int r5 = r5.getItemId()
            java.lang.String r5 = r1.getDisplayName(r2, r5)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Ignoring onNavDestinationSelected for MenuItem "
            r1.append(r2)
            r1.append(r5)
            java.lang.String r5 = " as it cannot be found from the current destination "
            r1.append(r5)
            androidx.navigation.NavDestination r5 = r6.getCurrentDestination()
            r1.append(r5)
            java.lang.String r5 = r1.toString()
            java.lang.String r6 = "NavigationUI"
            android.util.Log.i(r6, r5, r0)
        Lcf:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.ui.NavigationUI.onNavDestinationSelected(android.view.MenuItem, androidx.navigation.NavController):boolean");
    }

    @x0XOIxOo
    @xoIox
    public static final void setupActionBarWithNavController(@OOXIXo AppCompatActivity activity, @OOXIXo NavController navController) {
        IIX0o.x0xO0oo(activity, "activity");
        IIX0o.x0xO0oo(navController, "navController");
        setupActionBarWithNavController$default(activity, navController, null, 4, null);
    }

    public static /* synthetic */ void setupActionBarWithNavController$default(AppCompatActivity appCompatActivity, NavController navController, AppBarConfiguration appBarConfiguration, int i, Object obj) {
        if ((i & 4) != 0) {
            appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        }
        setupActionBarWithNavController(appCompatActivity, navController, appBarConfiguration);
    }

    @x0XOIxOo
    @xoIox
    public static final void setupWithNavController(@OOXIXo Toolbar toolbar, @OOXIXo NavController navController) {
        IIX0o.x0xO0oo(toolbar, "toolbar");
        IIX0o.x0xO0oo(navController, "navController");
        setupWithNavController$default(toolbar, navController, null, 4, null);
    }

    public static /* synthetic */ void setupWithNavController$default(Toolbar toolbar, NavController navController, AppBarConfiguration appBarConfiguration, int i, Object obj) {
        if ((i & 4) != 0) {
            appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        }
        setupWithNavController(toolbar, navController, appBarConfiguration);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupWithNavController$lambda$1(NavController navController, AppBarConfiguration configuration, View view) {
        IIX0o.x0xO0oo(navController, "$navController");
        IIX0o.x0xO0oo(configuration, "$configuration");
        navigateUp(navController, configuration);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupWithNavController$lambda$2(NavController navController, AppBarConfiguration configuration, View view) {
        IIX0o.x0xO0oo(navController, "$navController");
        IIX0o.x0xO0oo(configuration, "$configuration");
        navigateUp(navController, configuration);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setupWithNavController$lambda$3(NavController navController, NavigationView navigationView, MenuItem item) {
        IIX0o.x0xO0oo(navController, "$navController");
        IIX0o.x0xO0oo(navigationView, "$navigationView");
        IIX0o.x0xO0oo(item, "item");
        boolean onNavDestinationSelected = onNavDestinationSelected(item, navController);
        if (onNavDestinationSelected) {
            ViewParent parent = navigationView.getParent();
            if (parent instanceof Openable) {
                ((Openable) parent).close();
            } else {
                BottomSheetBehavior<?> findBottomSheetBehavior = findBottomSheetBehavior(navigationView);
                if (findBottomSheetBehavior != null) {
                    findBottomSheetBehavior.setState(5);
                }
            }
        }
        return onNavDestinationSelected;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setupWithNavController$lambda$5(NavController navController, boolean z, NavigationView navigationView, MenuItem item) {
        IIX0o.x0xO0oo(navController, "$navController");
        IIX0o.x0xO0oo(navigationView, "$navigationView");
        IIX0o.x0xO0oo(item, "item");
        boolean onNavDestinationSelected = onNavDestinationSelected(item, navController, z);
        if (onNavDestinationSelected) {
            ViewParent parent = navigationView.getParent();
            if (parent instanceof Openable) {
                ((Openable) parent).close();
            } else {
                BottomSheetBehavior<?> findBottomSheetBehavior = findBottomSheetBehavior(navigationView);
                if (findBottomSheetBehavior != null) {
                    findBottomSheetBehavior.setState(5);
                }
            }
        }
        return onNavDestinationSelected;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setupWithNavController$lambda$6(NavController navController, MenuItem item) {
        IIX0o.x0xO0oo(navController, "$navController");
        IIX0o.x0xO0oo(item, "item");
        return onNavDestinationSelected(item, navController);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setupWithNavController$lambda$8(NavController navController, boolean z, MenuItem item) {
        IIX0o.x0xO0oo(navController, "$navController");
        IIX0o.x0xO0oo(item, "item");
        return onNavDestinationSelected(item, navController, z);
    }

    @x0XOIxOo
    public static final void setupActionBarWithNavController(@OOXIXo AppCompatActivity activity, @OOXIXo NavController navController, @oOoXoXO Openable openable) {
        IIX0o.x0xO0oo(activity, "activity");
        IIX0o.x0xO0oo(navController, "navController");
        setupActionBarWithNavController(activity, navController, new AppBarConfiguration.Builder(navController.getGraph()).setOpenableLayout(openable).build());
    }

    @x0XOIxOo
    @xoIox
    public static final void setupWithNavController(@OOXIXo CollapsingToolbarLayout collapsingToolbarLayout, @OOXIXo Toolbar toolbar, @OOXIXo NavController navController) {
        IIX0o.x0xO0oo(collapsingToolbarLayout, "collapsingToolbarLayout");
        IIX0o.x0xO0oo(toolbar, "toolbar");
        IIX0o.x0xO0oo(navController, "navController");
        setupWithNavController$default(collapsingToolbarLayout, toolbar, navController, null, 8, null);
    }

    @x0XOIxOo
    public static final void setupWithNavController(@OOXIXo Toolbar toolbar, @OOXIXo NavController navController, @oOoXoXO Openable openable) {
        IIX0o.x0xO0oo(toolbar, "toolbar");
        IIX0o.x0xO0oo(navController, "navController");
        setupWithNavController(toolbar, navController, new AppBarConfiguration.Builder(navController.getGraph()).setOpenableLayout(openable).build());
    }

    public static /* synthetic */ void setupWithNavController$default(CollapsingToolbarLayout collapsingToolbarLayout, Toolbar toolbar, NavController navController, AppBarConfiguration appBarConfiguration, int i, Object obj) {
        if ((i & 8) != 0) {
            appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        }
        setupWithNavController(collapsingToolbarLayout, toolbar, navController, appBarConfiguration);
    }

    @x0XOIxOo
    public static final boolean navigateUp(@OOXIXo NavController navController, @OOXIXo AppBarConfiguration configuration) {
        IIX0o.x0xO0oo(navController, "navController");
        IIX0o.x0xO0oo(configuration, "configuration");
        Openable openableLayout = configuration.getOpenableLayout();
        NavDestination currentDestination = navController.getCurrentDestination();
        if (openableLayout != null && currentDestination != null && configuration.isTopLevelDestination(currentDestination)) {
            openableLayout.open();
            return true;
        }
        if (navController.navigateUp()) {
            return true;
        }
        AppBarConfiguration.OnNavigateUpListener fallbackOnNavigateUpListener = configuration.getFallbackOnNavigateUpListener();
        if (fallbackOnNavigateUpListener != null) {
            return fallbackOnNavigateUpListener.onNavigateUp();
        }
        return false;
    }

    @x0XOIxOo
    @xoIox
    public static final void setupActionBarWithNavController(@OOXIXo AppCompatActivity activity, @OOXIXo NavController navController, @OOXIXo AppBarConfiguration configuration) {
        IIX0o.x0xO0oo(activity, "activity");
        IIX0o.x0xO0oo(navController, "navController");
        IIX0o.x0xO0oo(configuration, "configuration");
        navController.addOnDestinationChangedListener(new ActionBarOnDestinationChangedListener(activity, configuration));
    }

    @x0XOIxOo
    @xoIox
    public static final void setupWithNavController(@OOXIXo Toolbar toolbar, @OOXIXo final NavController navController, @OOXIXo final AppBarConfiguration configuration) {
        IIX0o.x0xO0oo(toolbar, "toolbar");
        IIX0o.x0xO0oo(navController, "navController");
        IIX0o.x0xO0oo(configuration, "configuration");
        navController.addOnDestinationChangedListener(new ToolbarOnDestinationChangedListener(toolbar, configuration));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: androidx.navigation.ui.II0xO0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NavigationUI.setupWithNavController$lambda$1(NavController.this, configuration, view);
            }
        });
    }

    @x0XOIxOo
    public static final void setupWithNavController(@OOXIXo CollapsingToolbarLayout collapsingToolbarLayout, @OOXIXo Toolbar toolbar, @OOXIXo NavController navController, @oOoXoXO Openable openable) {
        IIX0o.x0xO0oo(collapsingToolbarLayout, "collapsingToolbarLayout");
        IIX0o.x0xO0oo(toolbar, "toolbar");
        IIX0o.x0xO0oo(navController, "navController");
        setupWithNavController(collapsingToolbarLayout, toolbar, navController, new AppBarConfiguration.Builder(navController.getGraph()).setOpenableLayout(openable).build());
    }

    @x0XOIxOo
    @xoIox
    public static final void setupWithNavController(@OOXIXo CollapsingToolbarLayout collapsingToolbarLayout, @OOXIXo Toolbar toolbar, @OOXIXo final NavController navController, @OOXIXo final AppBarConfiguration configuration) {
        IIX0o.x0xO0oo(collapsingToolbarLayout, "collapsingToolbarLayout");
        IIX0o.x0xO0oo(toolbar, "toolbar");
        IIX0o.x0xO0oo(navController, "navController");
        IIX0o.x0xO0oo(configuration, "configuration");
        navController.addOnDestinationChangedListener(new CollapsingToolbarOnDestinationChangedListener(collapsingToolbarLayout, toolbar, configuration));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: androidx.navigation.ui.oxoX
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NavigationUI.setupWithNavController$lambda$2(NavController.this, configuration, view);
            }
        });
    }

    @x0XOIxOo
    public static final void setupWithNavController(@OOXIXo final NavigationView navigationView, @OOXIXo final NavController navController) {
        IIX0o.x0xO0oo(navigationView, "navigationView");
        IIX0o.x0xO0oo(navController, "navController");
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() { // from class: androidx.navigation.ui.XO
            @Override // com.google.android.material.navigation.NavigationView.OnNavigationItemSelectedListener
            public final boolean onNavigationItemSelected(MenuItem menuItem) {
                boolean z;
                z = NavigationUI.setupWithNavController$lambda$3(NavController.this, navigationView, menuItem);
                return z;
            }
        });
        final WeakReference weakReference = new WeakReference(navigationView);
        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() { // from class: androidx.navigation.ui.NavigationUI$setupWithNavController$4
            @Override // androidx.navigation.NavController.OnDestinationChangedListener
            public void onDestinationChanged(NavController controller, NavDestination destination, Bundle bundle) {
                IIX0o.x0xO0oo(controller, "controller");
                IIX0o.x0xO0oo(destination, "destination");
                NavigationView navigationView2 = weakReference.get();
                if (navigationView2 == null) {
                    navController.removeOnDestinationChangedListener(this);
                    return;
                }
                if (destination instanceof FloatingWindow) {
                    return;
                }
                Menu menu = navigationView2.getMenu();
                IIX0o.oO(menu, "view.menu");
                int size = menu.size();
                for (int i = 0; i < size; i++) {
                    MenuItem item = menu.getItem(i);
                    IIX0o.II0XooXoX(item, "getItem(index)");
                    item.setChecked(NavigationUI.matchDestination$navigation_ui_release(destination, item.getItemId()));
                }
            }
        });
    }

    @x0XOIxOo
    @NavigationUiSaveStateControl
    public static final void setupWithNavController(@OOXIXo final NavigationView navigationView, @OOXIXo final NavController navController, final boolean z) {
        IIX0o.x0xO0oo(navigationView, "navigationView");
        IIX0o.x0xO0oo(navController, "navController");
        if (!z) {
            navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() { // from class: androidx.navigation.ui.I0Io
                @Override // com.google.android.material.navigation.NavigationView.OnNavigationItemSelectedListener
                public final boolean onNavigationItemSelected(MenuItem menuItem) {
                    boolean z2;
                    z2 = NavigationUI.setupWithNavController$lambda$5(NavController.this, z, navigationView, menuItem);
                    return z2;
                }
            });
            final WeakReference weakReference = new WeakReference(navigationView);
            navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() { // from class: androidx.navigation.ui.NavigationUI$setupWithNavController$7
                @Override // androidx.navigation.NavController.OnDestinationChangedListener
                public void onDestinationChanged(NavController controller, NavDestination destination, Bundle bundle) {
                    IIX0o.x0xO0oo(controller, "controller");
                    IIX0o.x0xO0oo(destination, "destination");
                    NavigationView navigationView2 = weakReference.get();
                    if (navigationView2 == null) {
                        navController.removeOnDestinationChangedListener(this);
                        return;
                    }
                    if (destination instanceof FloatingWindow) {
                        return;
                    }
                    Menu menu = navigationView2.getMenu();
                    IIX0o.oO(menu, "view.menu");
                    int size = menu.size();
                    for (int i = 0; i < size; i++) {
                        MenuItem item = menu.getItem(i);
                        IIX0o.II0XooXoX(item, "getItem(index)");
                        item.setChecked(NavigationUI.matchDestination$navigation_ui_release(destination, item.getItemId()));
                    }
                }
            });
            return;
        }
        throw new IllegalStateException("Leave the saveState parameter out entirely to use the non-experimental version of this API, which saves the state by default");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0099, code lost:
    
        if (matchDestination$navigation_ui_release(r9, r7.getItemId()) == true) goto L20;
     */
    @XO0OX.x0XOIxOo
    @androidx.navigation.ui.NavigationUiSaveStateControl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final boolean onNavDestinationSelected(@OXOo.OOXIXo android.view.MenuItem r7, @OXOo.OOXIXo androidx.navigation.NavController r8, boolean r9) {
        /*
            java.lang.String r0 = "item"
            kotlin.jvm.internal.IIX0o.x0xO0oo(r7, r0)
            java.lang.String r0 = "navController"
            kotlin.jvm.internal.IIX0o.x0xO0oo(r8, r0)
            if (r9 != 0) goto Ld3
            androidx.navigation.NavOptions$Builder r9 = new androidx.navigation.NavOptions$Builder
            r9.<init>()
            r0 = 1
            androidx.navigation.NavOptions$Builder r9 = r9.setLaunchSingleTop(r0)
            androidx.navigation.NavDestination r1 = r8.getCurrentDestination()
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(r1)
            androidx.navigation.NavGraph r1 = r1.getParent()
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(r1)
            int r2 = r7.getItemId()
            androidx.navigation.NavDestination r1 = r1.findNode(r2)
            boolean r1 = r1 instanceof androidx.navigation.ActivityNavigator.Destination
            if (r1 == 0) goto L48
            int r1 = androidx.navigation.ui.R.anim.nav_default_enter_anim
            androidx.navigation.NavOptions$Builder r1 = r9.setEnterAnim(r1)
            int r2 = androidx.navigation.ui.R.anim.nav_default_exit_anim
            androidx.navigation.NavOptions$Builder r1 = r1.setExitAnim(r2)
            int r2 = androidx.navigation.ui.R.anim.nav_default_pop_enter_anim
            androidx.navigation.NavOptions$Builder r1 = r1.setPopEnterAnim(r2)
            int r2 = androidx.navigation.ui.R.anim.nav_default_pop_exit_anim
            r1.setPopExitAnim(r2)
            goto L5f
        L48:
            int r1 = androidx.navigation.ui.R.animator.nav_default_enter_anim
            androidx.navigation.NavOptions$Builder r1 = r9.setEnterAnim(r1)
            int r2 = androidx.navigation.ui.R.animator.nav_default_exit_anim
            androidx.navigation.NavOptions$Builder r1 = r1.setExitAnim(r2)
            int r2 = androidx.navigation.ui.R.animator.nav_default_pop_enter_anim
            androidx.navigation.NavOptions$Builder r1 = r1.setPopEnterAnim(r2)
            int r2 = androidx.navigation.ui.R.animator.nav_default_pop_exit_anim
            r1.setPopExitAnim(r2)
        L5f:
            int r1 = r7.getOrder()
            r2 = 196608(0x30000, float:2.75506E-40)
            r1 = r1 & r2
            if (r1 != 0) goto L7e
            androidx.navigation.NavGraph$Companion r1 = androidx.navigation.NavGraph.Companion
            androidx.navigation.NavGraph r2 = r8.getGraph()
            androidx.navigation.NavDestination r1 = r1.findStartDestination(r2)
            int r2 = r1.getId()
            r5 = 4
            r6 = 0
            r3 = 0
            r4 = 0
            r1 = r9
            androidx.navigation.NavOptions.Builder.setPopUpTo$default(r1, r2, r3, r4, r5, r6)
        L7e:
            androidx.navigation.NavOptions r9 = r9.build()
            r1 = 0
            int r2 = r7.getItemId()     // Catch: java.lang.IllegalArgumentException -> L9e
            r3 = 0
            r8.navigate(r2, r3, r9)     // Catch: java.lang.IllegalArgumentException -> L9e
            androidx.navigation.NavDestination r9 = r8.getCurrentDestination()     // Catch: java.lang.IllegalArgumentException -> L9e
            if (r9 == 0) goto L9c
            int r2 = r7.getItemId()     // Catch: java.lang.IllegalArgumentException -> L9e
            boolean r7 = matchDestination$navigation_ui_release(r9, r2)     // Catch: java.lang.IllegalArgumentException -> L9e
            if (r7 != r0) goto L9c
            goto La0
        L9c:
            r0 = 0
            goto La0
        L9e:
            r9 = move-exception
            goto La2
        La0:
            r1 = r0
            goto Ld2
        La2:
            androidx.navigation.NavDestination$Companion r0 = androidx.navigation.NavDestination.Companion
            android.content.Context r2 = r8.getContext()
            int r7 = r7.getItemId()
            java.lang.String r7 = r0.getDisplayName(r2, r7)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "Ignoring onNavDestinationSelected for MenuItem "
            r0.append(r2)
            r0.append(r7)
            java.lang.String r7 = " as it cannot be found from the current destination "
            r0.append(r7)
            androidx.navigation.NavDestination r7 = r8.getCurrentDestination()
            r0.append(r7)
            java.lang.String r7 = r0.toString()
            java.lang.String r8 = "NavigationUI"
            android.util.Log.i(r8, r7, r9)
        Ld2:
            return r1
        Ld3:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "Leave the saveState parameter out entirely to use the non-experimental version of this API, which saves the state by default"
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.ui.NavigationUI.onNavDestinationSelected(android.view.MenuItem, androidx.navigation.NavController, boolean):boolean");
    }

    @x0XOIxOo
    public static final void setupWithNavController(@OOXIXo NavigationBarView navigationBarView, @OOXIXo final NavController navController) {
        IIX0o.x0xO0oo(navigationBarView, "navigationBarView");
        IIX0o.x0xO0oo(navController, "navController");
        navigationBarView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() { // from class: androidx.navigation.ui.X0o0xo
            @Override // com.google.android.material.navigation.NavigationBarView.OnItemSelectedListener
            public final boolean onNavigationItemSelected(MenuItem menuItem) {
                boolean z;
                z = NavigationUI.setupWithNavController$lambda$6(NavController.this, menuItem);
                return z;
            }
        });
        final WeakReference weakReference = new WeakReference(navigationBarView);
        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() { // from class: androidx.navigation.ui.NavigationUI$setupWithNavController$9
            @Override // androidx.navigation.NavController.OnDestinationChangedListener
            public void onDestinationChanged(NavController controller, NavDestination destination, Bundle bundle) {
                IIX0o.x0xO0oo(controller, "controller");
                IIX0o.x0xO0oo(destination, "destination");
                NavigationBarView navigationBarView2 = weakReference.get();
                if (navigationBarView2 == null) {
                    navController.removeOnDestinationChangedListener(this);
                    return;
                }
                if (destination instanceof FloatingWindow) {
                    return;
                }
                Menu menu = navigationBarView2.getMenu();
                IIX0o.oO(menu, "view.menu");
                int size = menu.size();
                for (int i = 0; i < size; i++) {
                    MenuItem item = menu.getItem(i);
                    IIX0o.II0XooXoX(item, "getItem(index)");
                    if (NavigationUI.matchDestination$navigation_ui_release(destination, item.getItemId())) {
                        item.setChecked(true);
                    }
                }
            }
        });
    }

    @x0XOIxOo
    @NavigationUiSaveStateControl
    public static final void setupWithNavController(@OOXIXo NavigationBarView navigationBarView, @OOXIXo final NavController navController, final boolean z) {
        IIX0o.x0xO0oo(navigationBarView, "navigationBarView");
        IIX0o.x0xO0oo(navController, "navController");
        if (!z) {
            navigationBarView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() { // from class: androidx.navigation.ui.oIX0oI
                @Override // com.google.android.material.navigation.NavigationBarView.OnItemSelectedListener
                public final boolean onNavigationItemSelected(MenuItem menuItem) {
                    boolean z2;
                    z2 = NavigationUI.setupWithNavController$lambda$8(NavController.this, z, menuItem);
                    return z2;
                }
            });
            final WeakReference weakReference = new WeakReference(navigationBarView);
            navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() { // from class: androidx.navigation.ui.NavigationUI$setupWithNavController$12
                @Override // androidx.navigation.NavController.OnDestinationChangedListener
                public void onDestinationChanged(NavController controller, NavDestination destination, Bundle bundle) {
                    IIX0o.x0xO0oo(controller, "controller");
                    IIX0o.x0xO0oo(destination, "destination");
                    NavigationBarView navigationBarView2 = weakReference.get();
                    if (navigationBarView2 == null) {
                        navController.removeOnDestinationChangedListener(this);
                        return;
                    }
                    if (destination instanceof FloatingWindow) {
                        return;
                    }
                    Menu menu = navigationBarView2.getMenu();
                    IIX0o.oO(menu, "view.menu");
                    int size = menu.size();
                    for (int i = 0; i < size; i++) {
                        MenuItem item = menu.getItem(i);
                        IIX0o.II0XooXoX(item, "getItem(index)");
                        if (NavigationUI.matchDestination$navigation_ui_release(destination, item.getItemId())) {
                            item.setChecked(true);
                        }
                    }
                }
            });
            return;
        }
        throw new IllegalStateException("Leave the saveState parameter out entirely to use the non-experimental version of this API, which saves the state by default");
    }
}
