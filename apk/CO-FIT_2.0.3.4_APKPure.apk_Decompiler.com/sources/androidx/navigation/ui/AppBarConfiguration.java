package androidx.navigation.ui;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.view.Menu;
import androidx.customview.widget.Openable;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavDestination;
import androidx.navigation.NavGraph;
import java.util.HashSet;
import java.util.Set;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nAppBarConfiguration.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AppBarConfiguration.kt\nandroidx/navigation/ui/AppBarConfiguration\n+ 2 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n1#1,306:1\n1247#2,2:307\n*S KotlinDebug\n*F\n+ 1 AppBarConfiguration.kt\nandroidx/navigation/ui/AppBarConfiguration\n*L\n103#1:307,2\n*E\n"})
public final class AppBarConfiguration {
    @oOoXoXO
    private final OnNavigateUpListener fallbackOnNavigateUpListener;
    @oOoXoXO
    private final Openable openableLayout;
    @OOXIXo
    private final Set<Integer> topLevelDestinations;

    public interface OnNavigateUpListener {
        boolean onNavigateUp();
    }

    public /* synthetic */ AppBarConfiguration(Set set, Openable openable, OnNavigateUpListener onNavigateUpListener, IIXOooo iIXOooo) {
        this(set, openable, onNavigateUpListener);
    }

    @kotlin.OOXIXo(message = "Use {@link #getOpenableLayout()}.")
    @oOoXoXO
    public final DrawerLayout getDrawerLayout() {
        Openable openable = this.openableLayout;
        if (openable instanceof DrawerLayout) {
            return (DrawerLayout) openable;
        }
        return null;
    }

    @oOoXoXO
    public final OnNavigateUpListener getFallbackOnNavigateUpListener() {
        return this.fallbackOnNavigateUpListener;
    }

    @oOoXoXO
    public final Openable getOpenableLayout() {
        return this.openableLayout;
    }

    @OOXIXo
    public final Set<Integer> getTopLevelDestinations() {
        return this.topLevelDestinations;
    }

    public final boolean isTopLevelDestination(@OOXIXo NavDestination navDestination) {
        IIX0o.x0xO0oo(navDestination, "destination");
        for (NavDestination next : NavDestination.Companion.getHierarchy(navDestination)) {
            if (this.topLevelDestinations.contains(Integer.valueOf(next.getId())) && (!(next instanceof NavGraph) || navDestination.getId() == NavGraph.Companion.findStartDestination((NavGraph) next).getId())) {
                return true;
            }
        }
        return false;
    }

    private AppBarConfiguration(Set<Integer> set, Openable openable, OnNavigateUpListener onNavigateUpListener) {
        this.topLevelDestinations = set;
        this.openableLayout = openable;
        this.fallbackOnNavigateUpListener = onNavigateUpListener;
    }

    public static final class Builder {
        @oOoXoXO
        private OnNavigateUpListener fallbackOnNavigateUpListener;
        @oOoXoXO
        private Openable openableLayout;
        @OOXIXo
        private final Set<Integer> topLevelDestinations;

        public Builder(@OOXIXo NavGraph navGraph) {
            IIX0o.x0xO0oo(navGraph, "navGraph");
            HashSet hashSet = new HashSet();
            this.topLevelDestinations = hashSet;
            hashSet.add(Integer.valueOf(NavGraph.Companion.findStartDestination(navGraph).getId()));
        }

        @OOXIXo
        public final AppBarConfiguration build() {
            return new AppBarConfiguration(this.topLevelDestinations, this.openableLayout, this.fallbackOnNavigateUpListener, (IIXOooo) null);
        }

        @kotlin.OOXIXo(message = "Use {@link #setOpenableLayout(Openable)}.")
        @OOXIXo
        public final Builder setDrawerLayout(@oOoXoXO DrawerLayout drawerLayout) {
            this.openableLayout = drawerLayout;
            return this;
        }

        @OOXIXo
        public final Builder setFallbackOnNavigateUpListener(@oOoXoXO OnNavigateUpListener onNavigateUpListener) {
            this.fallbackOnNavigateUpListener = onNavigateUpListener;
            return this;
        }

        @OOXIXo
        public final Builder setOpenableLayout(@oOoXoXO Openable openable) {
            this.openableLayout = openable;
            return this;
        }

        public Builder(@OOXIXo Menu menu) {
            IIX0o.x0xO0oo(menu, "topLevelMenu");
            this.topLevelDestinations = new HashSet();
            int size = menu.size();
            for (int i = 0; i < size; i++) {
                this.topLevelDestinations.add(Integer.valueOf(menu.getItem(i).getItemId()));
            }
        }

        public Builder(@OOXIXo int... iArr) {
            IIX0o.x0xO0oo(iArr, "topLevelDestinationIds");
            this.topLevelDestinations = new HashSet();
            for (int valueOf : iArr) {
                this.topLevelDestinations.add(Integer.valueOf(valueOf));
            }
        }

        public Builder(@OOXIXo Set<Integer> set) {
            IIX0o.x0xO0oo(set, "topLevelDestinationIds");
            HashSet hashSet = new HashSet();
            this.topLevelDestinations = hashSet;
            hashSet.addAll(set);
        }
    }
}
