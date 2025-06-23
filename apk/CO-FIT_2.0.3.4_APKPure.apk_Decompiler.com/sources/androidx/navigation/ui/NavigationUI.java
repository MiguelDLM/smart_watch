package androidx.navigation.ui;

import O0IoXXOx.XO;
import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.x0XOIxOo;
import XO0OX.xoIox;
import android.os.Bundle;
import android.util.Log;
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
import androidx.navigation.ActivityNavigator;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.NavGraph;
import androidx.navigation.NavOptions;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.profileinstaller.ProfileVerifier;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nNavigationUI.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NavigationUI.kt\nandroidx/navigation/ui/NavigationUI\n+ 2 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n1#1,714:1\n1247#2,2:715\n*S KotlinDebug\n*F\n+ 1 NavigationUI.kt\nandroidx/navigation/ui/NavigationUI\n*L\n712#1:715,2\n*E\n"})
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
        IIX0o.x0xO0oo(view, ViewHierarchyConstants.VIEW_KEY);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof CoordinatorLayout.LayoutParams)) {
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                return findBottomSheetBehavior((View) parent);
            }
            return null;
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
        for (NavDestination id : NavDestination.Companion.getHierarchy(navDestination)) {
            if (id.getId() == i) {
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

    @x0XOIxOo
    public static final boolean onNavDestinationSelected(@OOXIXo MenuItem menuItem, @OOXIXo NavController navController) {
        IIX0o.x0xO0oo(menuItem, "item");
        IIX0o.x0xO0oo(navController, "navController");
        boolean z = true;
        NavOptions.Builder restoreState = new NavOptions.Builder().setLaunchSingleTop(true).setRestoreState(true);
        NavDestination currentDestination = navController.getCurrentDestination();
        IIX0o.ooOOo0oXI(currentDestination);
        NavGraph parent = currentDestination.getParent();
        IIX0o.ooOOo0oXI(parent);
        if (parent.findNode(menuItem.getItemId()) instanceof ActivityNavigator.Destination) {
            restoreState.setEnterAnim(R.anim.nav_default_enter_anim).setExitAnim(R.anim.nav_default_exit_anim).setPopEnterAnim(R.anim.nav_default_pop_enter_anim).setPopExitAnim(R.anim.nav_default_pop_exit_anim);
        } else {
            restoreState.setEnterAnim(R.animator.nav_default_enter_anim).setExitAnim(R.animator.nav_default_exit_anim).setPopEnterAnim(R.animator.nav_default_pop_enter_anim).setPopExitAnim(R.animator.nav_default_pop_exit_anim);
        }
        if ((menuItem.getOrder() & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            restoreState.setPopUpTo(NavGraph.Companion.findStartDestination(navController.getGraph()).getId(), false, true);
        }
        try {
            navController.navigate(menuItem.getItemId(), (Bundle) null, restoreState.build());
            NavDestination currentDestination2 = navController.getCurrentDestination();
            if (currentDestination2 == null || !matchDestination$navigation_ui_release(currentDestination2, menuItem.getItemId())) {
                z = false;
            }
            return z;
        } catch (IllegalArgumentException e) {
            String displayName = NavDestination.Companion.getDisplayName(navController.getContext(), menuItem.getItemId());
            Log.i(TAG, "Ignoring onNavDestinationSelected for MenuItem " + displayName + " as it cannot be found from the current destination " + navController.getCurrentDestination(), e);
            return false;
        }
    }

    @xoIox
    @x0XOIxOo
    public static final void setupActionBarWithNavController(@OOXIXo AppCompatActivity appCompatActivity, @OOXIXo NavController navController) {
        IIX0o.x0xO0oo(appCompatActivity, TTDownloadField.TT_ACTIVITY);
        IIX0o.x0xO0oo(navController, "navController");
        setupActionBarWithNavController$default(appCompatActivity, navController, (AppBarConfiguration) null, 4, (Object) null);
    }

    public static /* synthetic */ void setupActionBarWithNavController$default(AppCompatActivity appCompatActivity, NavController navController, AppBarConfiguration appBarConfiguration, int i, Object obj) {
        if ((i & 4) != 0) {
            appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        }
        setupActionBarWithNavController(appCompatActivity, navController, appBarConfiguration);
    }

    @xoIox
    @x0XOIxOo
    public static final void setupWithNavController(@OOXIXo Toolbar toolbar, @OOXIXo NavController navController) {
        IIX0o.x0xO0oo(toolbar, "toolbar");
        IIX0o.x0xO0oo(navController, "navController");
        setupWithNavController$default(toolbar, navController, (AppBarConfiguration) null, 4, (Object) null);
    }

    public static /* synthetic */ void setupWithNavController$default(Toolbar toolbar, NavController navController, AppBarConfiguration appBarConfiguration, int i, Object obj) {
        if ((i & 4) != 0) {
            appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        }
        setupWithNavController(toolbar, navController, appBarConfiguration);
    }

    /* access modifiers changed from: private */
    public static final void setupWithNavController$lambda$1(NavController navController, AppBarConfiguration appBarConfiguration, View view) {
        IIX0o.x0xO0oo(navController, "$navController");
        IIX0o.x0xO0oo(appBarConfiguration, "$configuration");
        navigateUp(navController, appBarConfiguration);
    }

    /* access modifiers changed from: private */
    public static final void setupWithNavController$lambda$2(NavController navController, AppBarConfiguration appBarConfiguration, View view) {
        IIX0o.x0xO0oo(navController, "$navController");
        IIX0o.x0xO0oo(appBarConfiguration, "$configuration");
        navigateUp(navController, appBarConfiguration);
    }

    /* access modifiers changed from: private */
    public static final boolean setupWithNavController$lambda$3(NavController navController, NavigationView navigationView, MenuItem menuItem) {
        IIX0o.x0xO0oo(navController, "$navController");
        IIX0o.x0xO0oo(navigationView, "$navigationView");
        IIX0o.x0xO0oo(menuItem, "item");
        boolean onNavDestinationSelected = onNavDestinationSelected(menuItem, navController);
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

    /* access modifiers changed from: private */
    public static final boolean setupWithNavController$lambda$5(NavController navController, boolean z, NavigationView navigationView, MenuItem menuItem) {
        IIX0o.x0xO0oo(navController, "$navController");
        IIX0o.x0xO0oo(navigationView, "$navigationView");
        IIX0o.x0xO0oo(menuItem, "item");
        boolean onNavDestinationSelected = onNavDestinationSelected(menuItem, navController, z);
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

    /* access modifiers changed from: private */
    public static final boolean setupWithNavController$lambda$6(NavController navController, MenuItem menuItem) {
        IIX0o.x0xO0oo(navController, "$navController");
        IIX0o.x0xO0oo(menuItem, "item");
        return onNavDestinationSelected(menuItem, navController);
    }

    /* access modifiers changed from: private */
    public static final boolean setupWithNavController$lambda$8(NavController navController, boolean z, MenuItem menuItem) {
        IIX0o.x0xO0oo(navController, "$navController");
        IIX0o.x0xO0oo(menuItem, "item");
        return onNavDestinationSelected(menuItem, navController, z);
    }

    @x0XOIxOo
    public static final void setupActionBarWithNavController(@OOXIXo AppCompatActivity appCompatActivity, @OOXIXo NavController navController, @oOoXoXO Openable openable) {
        IIX0o.x0xO0oo(appCompatActivity, TTDownloadField.TT_ACTIVITY);
        IIX0o.x0xO0oo(navController, "navController");
        setupActionBarWithNavController(appCompatActivity, navController, new AppBarConfiguration.Builder(navController.getGraph()).setOpenableLayout(openable).build());
    }

    @xoIox
    @x0XOIxOo
    public static final void setupWithNavController(@OOXIXo CollapsingToolbarLayout collapsingToolbarLayout, @OOXIXo Toolbar toolbar, @OOXIXo NavController navController) {
        IIX0o.x0xO0oo(collapsingToolbarLayout, "collapsingToolbarLayout");
        IIX0o.x0xO0oo(toolbar, "toolbar");
        IIX0o.x0xO0oo(navController, "navController");
        setupWithNavController$default(collapsingToolbarLayout, toolbar, navController, (AppBarConfiguration) null, 8, (Object) null);
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
    public static final boolean navigateUp(@OOXIXo NavController navController, @OOXIXo AppBarConfiguration appBarConfiguration) {
        IIX0o.x0xO0oo(navController, "navController");
        IIX0o.x0xO0oo(appBarConfiguration, XO.f15419Oxx0IOOO);
        Openable openableLayout = appBarConfiguration.getOpenableLayout();
        NavDestination currentDestination = navController.getCurrentDestination();
        if (openableLayout != null && currentDestination != null && appBarConfiguration.isTopLevelDestination(currentDestination)) {
            openableLayout.open();
            return true;
        } else if (navController.navigateUp()) {
            return true;
        } else {
            AppBarConfiguration.OnNavigateUpListener fallbackOnNavigateUpListener = appBarConfiguration.getFallbackOnNavigateUpListener();
            if (fallbackOnNavigateUpListener != null) {
                return fallbackOnNavigateUpListener.onNavigateUp();
            }
            return false;
        }
    }

    @xoIox
    @x0XOIxOo
    public static final void setupActionBarWithNavController(@OOXIXo AppCompatActivity appCompatActivity, @OOXIXo NavController navController, @OOXIXo AppBarConfiguration appBarConfiguration) {
        IIX0o.x0xO0oo(appCompatActivity, TTDownloadField.TT_ACTIVITY);
        IIX0o.x0xO0oo(navController, "navController");
        IIX0o.x0xO0oo(appBarConfiguration, XO.f15419Oxx0IOOO);
        navController.addOnDestinationChangedListener(new ActionBarOnDestinationChangedListener(appCompatActivity, appBarConfiguration));
    }

    @xoIox
    @x0XOIxOo
    public static final void setupWithNavController(@OOXIXo Toolbar toolbar, @OOXIXo NavController navController, @OOXIXo AppBarConfiguration appBarConfiguration) {
        IIX0o.x0xO0oo(toolbar, "toolbar");
        IIX0o.x0xO0oo(navController, "navController");
        IIX0o.x0xO0oo(appBarConfiguration, XO.f15419Oxx0IOOO);
        navController.addOnDestinationChangedListener(new ToolbarOnDestinationChangedListener(toolbar, appBarConfiguration));
        toolbar.setNavigationOnClickListener(new II0xO0(navController, appBarConfiguration));
    }

    @x0XOIxOo
    public static final void setupWithNavController(@OOXIXo CollapsingToolbarLayout collapsingToolbarLayout, @OOXIXo Toolbar toolbar, @OOXIXo NavController navController, @oOoXoXO Openable openable) {
        IIX0o.x0xO0oo(collapsingToolbarLayout, "collapsingToolbarLayout");
        IIX0o.x0xO0oo(toolbar, "toolbar");
        IIX0o.x0xO0oo(navController, "navController");
        setupWithNavController(collapsingToolbarLayout, toolbar, navController, new AppBarConfiguration.Builder(navController.getGraph()).setOpenableLayout(openable).build());
    }

    @xoIox
    @x0XOIxOo
    public static final void setupWithNavController(@OOXIXo CollapsingToolbarLayout collapsingToolbarLayout, @OOXIXo Toolbar toolbar, @OOXIXo NavController navController, @OOXIXo AppBarConfiguration appBarConfiguration) {
        IIX0o.x0xO0oo(collapsingToolbarLayout, "collapsingToolbarLayout");
        IIX0o.x0xO0oo(toolbar, "toolbar");
        IIX0o.x0xO0oo(navController, "navController");
        IIX0o.x0xO0oo(appBarConfiguration, XO.f15419Oxx0IOOO);
        navController.addOnDestinationChangedListener(new CollapsingToolbarOnDestinationChangedListener(collapsingToolbarLayout, toolbar, appBarConfiguration));
        toolbar.setNavigationOnClickListener(new oxoX(navController, appBarConfiguration));
    }

    @x0XOIxOo
    public static final void setupWithNavController(@OOXIXo NavigationView navigationView, @OOXIXo NavController navController) {
        IIX0o.x0xO0oo(navigationView, "navigationView");
        IIX0o.x0xO0oo(navController, "navController");
        navigationView.setNavigationItemSelectedListener(new XO(navController, navigationView));
        navController.addOnDestinationChangedListener(new NavigationUI$setupWithNavController$4(new WeakReference(navigationView), navController));
    }

    @NavigationUiSaveStateControl
    @x0XOIxOo
    public static final void setupWithNavController(@OOXIXo NavigationView navigationView, @OOXIXo NavController navController, boolean z) {
        IIX0o.x0xO0oo(navigationView, "navigationView");
        IIX0o.x0xO0oo(navController, "navController");
        if (!z) {
            navigationView.setNavigationItemSelectedListener(new I0Io(navController, z, navigationView));
            navController.addOnDestinationChangedListener(new NavigationUI$setupWithNavController$7(new WeakReference(navigationView), navController));
            return;
        }
        throw new IllegalStateException("Leave the saveState parameter out entirely to use the non-experimental version of this API, which saves the state by default");
    }

    @NavigationUiSaveStateControl
    @x0XOIxOo
    public static final boolean onNavDestinationSelected(@OOXIXo MenuItem menuItem, @OOXIXo NavController navController, boolean z) {
        IIX0o.x0xO0oo(menuItem, "item");
        IIX0o.x0xO0oo(navController, "navController");
        if (!z) {
            boolean z2 = true;
            NavOptions.Builder launchSingleTop = new NavOptions.Builder().setLaunchSingleTop(true);
            NavDestination currentDestination = navController.getCurrentDestination();
            IIX0o.ooOOo0oXI(currentDestination);
            NavGraph parent = currentDestination.getParent();
            IIX0o.ooOOo0oXI(parent);
            if (parent.findNode(menuItem.getItemId()) instanceof ActivityNavigator.Destination) {
                launchSingleTop.setEnterAnim(R.anim.nav_default_enter_anim).setExitAnim(R.anim.nav_default_exit_anim).setPopEnterAnim(R.anim.nav_default_pop_enter_anim).setPopExitAnim(R.anim.nav_default_pop_exit_anim);
            } else {
                launchSingleTop.setEnterAnim(R.animator.nav_default_enter_anim).setExitAnim(R.animator.nav_default_exit_anim).setPopEnterAnim(R.animator.nav_default_pop_enter_anim).setPopExitAnim(R.animator.nav_default_pop_exit_anim);
            }
            if ((menuItem.getOrder() & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                NavOptions.Builder.setPopUpTo$default(launchSingleTop, NavGraph.Companion.findStartDestination(navController.getGraph()).getId(), false, false, 4, (Object) null);
            }
            try {
                navController.navigate(menuItem.getItemId(), (Bundle) null, launchSingleTop.build());
                NavDestination currentDestination2 = navController.getCurrentDestination();
                if (currentDestination2 == null || !matchDestination$navigation_ui_release(currentDestination2, menuItem.getItemId())) {
                    z2 = false;
                }
                return z2;
            } catch (IllegalArgumentException e) {
                String displayName = NavDestination.Companion.getDisplayName(navController.getContext(), menuItem.getItemId());
                Log.i(TAG, "Ignoring onNavDestinationSelected for MenuItem " + displayName + " as it cannot be found from the current destination " + navController.getCurrentDestination(), e);
                return false;
            }
        } else {
            throw new IllegalStateException("Leave the saveState parameter out entirely to use the non-experimental version of this API, which saves the state by default");
        }
    }

    @x0XOIxOo
    public static final void setupWithNavController(@OOXIXo NavigationBarView navigationBarView, @OOXIXo NavController navController) {
        IIX0o.x0xO0oo(navigationBarView, "navigationBarView");
        IIX0o.x0xO0oo(navController, "navController");
        navigationBarView.setOnItemSelectedListener(new X0o0xo(navController));
        navController.addOnDestinationChangedListener(new NavigationUI$setupWithNavController$9(new WeakReference(navigationBarView), navController));
    }

    @NavigationUiSaveStateControl
    @x0XOIxOo
    public static final void setupWithNavController(@OOXIXo NavigationBarView navigationBarView, @OOXIXo NavController navController, boolean z) {
        IIX0o.x0xO0oo(navigationBarView, "navigationBarView");
        IIX0o.x0xO0oo(navController, "navController");
        if (!z) {
            navigationBarView.setOnItemSelectedListener(new oIX0oI(navController, z));
            navController.addOnDestinationChangedListener(new NavigationUI$setupWithNavController$12(new WeakReference(navigationBarView), navController));
            return;
        }
        throw new IllegalStateException("Leave the saveState parameter out entirely to use the non-experimental version of this API, which saves the state by default");
    }
}
