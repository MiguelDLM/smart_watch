package androidx.navigation;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XxI.oxoX;
import android.os.Bundle;
import androidx.annotation.CallSuper;
import androidx.navigation.NavDestination;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;
import kotlin.sequences.SequencesKt___SequencesKt;

@XX({"SMAP\nNavigator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Navigator.kt\nandroidx/navigation/Navigator\n+ 2 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n1#1,242:1\n1313#2,2:243\n*S KotlinDebug\n*F\n+ 1 Navigator.kt\nandroidx/navigation/Navigator\n*L\n136#1:243,2\n*E\n"})
/* loaded from: classes.dex */
public abstract class Navigator<D extends NavDestination> {

    @oOoXoXO
    private NavigatorState _state;
    private boolean isAttached;

    /* loaded from: classes.dex */
    public interface Extras {
    }

    @oxoX(allowedTargets = {AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.CLASS})
    @Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
    @XxI.I0Io(AnnotationRetention.RUNTIME)
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: classes.dex */
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
    public NavDestination navigate(@OOXIXo D destination, @oOoXoXO Bundle bundle, @oOoXoXO NavOptions navOptions, @oOoXoXO Extras extras) {
        IIX0o.x0xO0oo(destination, "destination");
        return destination;
    }

    @CallSuper
    public void onAttach(@OOXIXo NavigatorState state) {
        IIX0o.x0xO0oo(state, "state");
        this._state = state;
        this.isAttached = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onLaunchSingleTop(@OOXIXo NavBackStackEntry backStackEntry) {
        IIX0o.x0xO0oo(backStackEntry, "backStackEntry");
        NavDestination destination = backStackEntry.getDestination();
        if (!(destination instanceof NavDestination)) {
            destination = null;
        }
        if (destination == null) {
            return;
        }
        navigate(destination, null, NavOptionsBuilderKt.navOptions(new Oox.oOoXoXO<NavOptionsBuilder, oXIO0o0XI>() { // from class: androidx.navigation.Navigator$onLaunchSingleTop$1
            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(NavOptionsBuilder navOptionsBuilder) {
                invoke2(navOptionsBuilder);
                return oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(NavOptionsBuilder navOptions) {
                IIX0o.x0xO0oo(navOptions, "$this$navOptions");
                navOptions.setLaunchSingleTop(true);
            }
        }), null);
        getState().onLaunchSingleTop(backStackEntry);
    }

    public void onRestoreState(@OOXIXo Bundle savedState) {
        IIX0o.x0xO0oo(savedState, "savedState");
    }

    @oOoXoXO
    public Bundle onSaveState() {
        return null;
    }

    public boolean popBackStack() {
        return true;
    }

    public void navigate(@OOXIXo List<NavBackStackEntry> entries, @oOoXoXO final NavOptions navOptions, @oOoXoXO final Extras extras) {
        IIX0o.x0xO0oo(entries, "entries");
        Iterator it = SequencesKt___SequencesKt.O00XxXI(SequencesKt___SequencesKt.X0xxXX0(CollectionsKt___CollectionsKt.OooI(entries), new Oox.oOoXoXO<NavBackStackEntry, NavBackStackEntry>(this) { // from class: androidx.navigation.Navigator$navigate$1
            final /* synthetic */ Navigator<D> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            @Override // Oox.oOoXoXO
            public final NavBackStackEntry invoke(NavBackStackEntry backStackEntry) {
                NavDestination navigate;
                IIX0o.x0xO0oo(backStackEntry, "backStackEntry");
                NavDestination destination = backStackEntry.getDestination();
                if (!(destination instanceof NavDestination)) {
                    destination = null;
                }
                if (destination != null && (navigate = this.this$0.navigate(destination, backStackEntry.getArguments(), navOptions, extras)) != null) {
                    return IIX0o.Oxx0IOOO(navigate, destination) ? backStackEntry : this.this$0.getState().createBackStackEntry(navigate, navigate.addInDefaultArgs(backStackEntry.getArguments()));
                }
                return null;
            }
        })).iterator();
        while (it.hasNext()) {
            getState().push((NavBackStackEntry) it.next());
        }
    }

    public void popBackStack(@OOXIXo NavBackStackEntry popUpTo, boolean z) {
        IIX0o.x0xO0oo(popUpTo, "popUpTo");
        List<NavBackStackEntry> value = getState().getBackStack().getValue();
        if (value.contains(popUpTo)) {
            ListIterator<NavBackStackEntry> listIterator = value.listIterator(value.size());
            NavBackStackEntry navBackStackEntry = null;
            while (popBackStack()) {
                navBackStackEntry = listIterator.previous();
                if (IIX0o.Oxx0IOOO(navBackStackEntry, popUpTo)) {
                    break;
                }
            }
            if (navBackStackEntry != null) {
                getState().pop(navBackStackEntry, z);
                return;
            }
            return;
        }
        throw new IllegalStateException(("popBackStack was called with " + popUpTo + " which does not exist in back stack " + value).toString());
    }
}
