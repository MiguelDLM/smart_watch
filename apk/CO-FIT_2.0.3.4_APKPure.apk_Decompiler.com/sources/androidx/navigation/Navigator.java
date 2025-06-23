package androidx.navigation;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XxI.I0Io;
import XxI.oxoX;
import android.os.Bundle;
import androidx.annotation.CallSuper;
import androidx.navigation.NavDestination;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;
import java.util.ListIterator;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.sequences.SequencesKt___SequencesKt;

@XX({"SMAP\nNavigator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Navigator.kt\nandroidx/navigation/Navigator\n+ 2 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n1#1,242:1\n1313#2,2:243\n*S KotlinDebug\n*F\n+ 1 Navigator.kt\nandroidx/navigation/Navigator\n*L\n136#1:243,2\n*E\n"})
public abstract class Navigator<D extends NavDestination> {
    @oOoXoXO
    private NavigatorState _state;
    private boolean isAttached;

    public interface Extras {
    }

    @Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
    @I0Io(AnnotationRetention.RUNTIME)
    @oxoX(allowedTargets = {AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.CLASS})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Name {
        String value();
    }

    @OOXIXo
    public abstract D createDestination();

    @OOXIXo
    public final NavigatorState getState() {
        NavigatorState navigatorState = this._state;
        if (navigatorState != null) {
            return navigatorState;
        }
        throw new IllegalStateException("You cannot access the Navigator's state until the Navigator is attached");
    }

    public final boolean isAttached() {
        return this.isAttached;
    }

    @oOoXoXO
    public NavDestination navigate(@OOXIXo D d, @oOoXoXO Bundle bundle, @oOoXoXO NavOptions navOptions, @oOoXoXO Extras extras) {
        IIX0o.x0xO0oo(d, "destination");
        return d;
    }

    @CallSuper
    public void onAttach(@OOXIXo NavigatorState navigatorState) {
        IIX0o.x0xO0oo(navigatorState, "state");
        this._state = navigatorState;
        this.isAttached = true;
    }

    public void onLaunchSingleTop(@OOXIXo NavBackStackEntry navBackStackEntry) {
        IIX0o.x0xO0oo(navBackStackEntry, "backStackEntry");
        NavDestination destination = navBackStackEntry.getDestination();
        if (!(destination instanceof NavDestination)) {
            destination = null;
        }
        if (destination != null) {
            navigate(destination, (Bundle) null, NavOptionsBuilderKt.navOptions(Navigator$onLaunchSingleTop$1.INSTANCE), (Extras) null);
            getState().onLaunchSingleTop(navBackStackEntry);
        }
    }

    public void onRestoreState(@OOXIXo Bundle bundle) {
        IIX0o.x0xO0oo(bundle, "savedState");
    }

    @oOoXoXO
    public Bundle onSaveState() {
        return null;
    }

    public boolean popBackStack() {
        return true;
    }

    public void navigate(@OOXIXo List<NavBackStackEntry> list, @oOoXoXO NavOptions navOptions, @oOoXoXO Extras extras) {
        IIX0o.x0xO0oo(list, "entries");
        for (NavBackStackEntry push : SequencesKt___SequencesKt.O00XxXI(SequencesKt___SequencesKt.X0xxXX0(CollectionsKt___CollectionsKt.OooI(list), new Navigator$navigate$1(this, navOptions, extras)))) {
            getState().push(push);
        }
    }

    public void popBackStack(@OOXIXo NavBackStackEntry navBackStackEntry, boolean z) {
        IIX0o.x0xO0oo(navBackStackEntry, "popUpTo");
        List value = getState().getBackStack().getValue();
        if (value.contains(navBackStackEntry)) {
            ListIterator listIterator = value.listIterator(value.size());
            NavBackStackEntry navBackStackEntry2 = null;
            while (popBackStack()) {
                navBackStackEntry2 = (NavBackStackEntry) listIterator.previous();
                if (IIX0o.Oxx0IOOO(navBackStackEntry2, navBackStackEntry)) {
                    break;
                }
            }
            if (navBackStackEntry2 != null) {
                getState().pop(navBackStackEntry2, z);
                return;
            }
            return;
        }
        throw new IllegalStateException(("popBackStack was called with " + navBackStackEntry + " which does not exist in back stack " + value).toString());
    }
}
