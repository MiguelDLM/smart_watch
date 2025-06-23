package androidx.navigation;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.os.Bundle;
import androidx.annotation.CallSuper;
import androidx.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.Xo0;
import kotlin.collections.XoI0Ixx0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.flow.IIXOooo;
import kotlinx.coroutines.flow.Oxx0IOOO;
import kotlinx.coroutines.flow.xoIox;
import kotlinx.coroutines.flow.xoXoI;

@XX({"SMAP\nNavigatorState.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NavigatorState.kt\nandroidx/navigation/NavigatorState\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,217:1\n1#2:218\n1747#3,3:219\n1747#3,3:222\n959#3,7:225\n1747#3,3:232\n2624#3,3:235\n533#3,6:238\n378#3,7:244\n451#3,6:251\n*S KotlinDebug\n*F\n+ 1 NavigatorState.kt\nandroidx/navigation/NavigatorState\n*L\n76#1:219,3\n77#1:222,3\n102#1:225,7\n123#1:232,3\n124#1:235,3\n130#1:238,6\n158#1:244,7\n181#1:251,6\n*E\n"})
public abstract class NavigatorState {
    @OOXIXo
    private final xoIox<List<NavBackStackEntry>> _backStack;
    @OOXIXo
    private final xoIox<Set<NavBackStackEntry>> _transitionsInProgress;
    @OOXIXo
    private final IIXOooo<List<NavBackStackEntry>> backStack;
    @OOXIXo
    private final ReentrantLock backStackLock = new ReentrantLock(true);
    private boolean isNavigating;
    @OOXIXo
    private final IIXOooo<Set<NavBackStackEntry>> transitionsInProgress;

    public NavigatorState() {
        xoIox<List<NavBackStackEntry>> oIX0oI2 = xoXoI.oIX0oI(CollectionsKt__CollectionsKt.ooXIXxIX());
        this._backStack = oIX0oI2;
        xoIox<Set<NavBackStackEntry>> oIX0oI3 = xoXoI.oIX0oI(Xo0.OOXIXo());
        this._transitionsInProgress = oIX0oI3;
        this.backStack = Oxx0IOOO.ooOOo0oXI(oIX0oI2);
        this.transitionsInProgress = Oxx0IOOO.ooOOo0oXI(oIX0oI3);
    }

    @OOXIXo
    public abstract NavBackStackEntry createBackStackEntry(@OOXIXo NavDestination navDestination, @oOoXoXO Bundle bundle);

    @OOXIXo
    public final IIXOooo<List<NavBackStackEntry>> getBackStack() {
        return this.backStack;
    }

    @OOXIXo
    public final IIXOooo<Set<NavBackStackEntry>> getTransitionsInProgress() {
        return this.transitionsInProgress;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final boolean isNavigating() {
        return this.isNavigating;
    }

    public void markTransitionComplete(@OOXIXo NavBackStackEntry navBackStackEntry) {
        IIX0o.x0xO0oo(navBackStackEntry, "entry");
        xoIox<Set<NavBackStackEntry>> xoiox = this._transitionsInProgress;
        xoiox.setValue(XoI0Ixx0.OxI(xoiox.getValue(), navBackStackEntry));
    }

    @CallSuper
    public void onLaunchSingleTop(@OOXIXo NavBackStackEntry navBackStackEntry) {
        int i;
        IIX0o.x0xO0oo(navBackStackEntry, "backStackEntry");
        ReentrantLock reentrantLock = this.backStackLock;
        reentrantLock.lock();
        try {
            List o0Xo0XII = CollectionsKt___CollectionsKt.o0Xo0XII(this.backStack.getValue());
            ListIterator listIterator = o0Xo0XII.listIterator(o0Xo0XII.size());
            while (true) {
                if (listIterator.hasPrevious()) {
                    if (IIX0o.Oxx0IOOO(((NavBackStackEntry) listIterator.previous()).getId(), navBackStackEntry.getId())) {
                        i = listIterator.nextIndex();
                        break;
                    }
                } else {
                    i = -1;
                    break;
                }
            }
            o0Xo0XII.set(i, navBackStackEntry);
            this._backStack.setValue(o0Xo0XII);
            oXIO0o0XI oxio0o0xi = oXIO0o0XI.f19155oIX0oI;
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @CallSuper
    public void onLaunchSingleTopWithTransition(@OOXIXo NavBackStackEntry navBackStackEntry) {
        IIX0o.x0xO0oo(navBackStackEntry, "backStackEntry");
        List value = this.backStack.getValue();
        ListIterator listIterator = value.listIterator(value.size());
        while (listIterator.hasPrevious()) {
            NavBackStackEntry navBackStackEntry2 = (NavBackStackEntry) listIterator.previous();
            if (IIX0o.Oxx0IOOO(navBackStackEntry2.getId(), navBackStackEntry.getId())) {
                xoIox<Set<NavBackStackEntry>> xoiox = this._transitionsInProgress;
                xoiox.setValue(XoI0Ixx0.xxX(XoI0Ixx0.xxX(xoiox.getValue(), navBackStackEntry2), navBackStackEntry));
                onLaunchSingleTop(navBackStackEntry);
                return;
            }
        }
        throw new NoSuchElementException("List contains no element matching the predicate.");
    }

    public void pop(@OOXIXo NavBackStackEntry navBackStackEntry, boolean z) {
        IIX0o.x0xO0oo(navBackStackEntry, "popUpTo");
        ReentrantLock reentrantLock = this.backStackLock;
        reentrantLock.lock();
        try {
            xoIox<List<NavBackStackEntry>> xoiox = this._backStack;
            ArrayList arrayList = new ArrayList();
            Iterator it = xoiox.getValue().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (IIX0o.Oxx0IOOO((NavBackStackEntry) next, navBackStackEntry)) {
                    break;
                }
                arrayList.add(next);
            }
            xoiox.setValue(arrayList);
            oXIO0o0XI oxio0o0xi = oXIO0o0XI.f19155oIX0oI;
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public void popWithTransition(@OOXIXo NavBackStackEntry navBackStackEntry, boolean z) {
        Object obj;
        IIX0o.x0xO0oo(navBackStackEntry, "popUpTo");
        Iterable value = this._transitionsInProgress.getValue();
        if (!(value instanceof Collection) || !((Collection) value).isEmpty()) {
            Iterator it = value.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (((NavBackStackEntry) it.next()) == navBackStackEntry) {
                    Iterable<NavBackStackEntry> value2 = this.backStack.getValue();
                    if (!(value2 instanceof Collection) || !((Collection) value2).isEmpty()) {
                        for (NavBackStackEntry navBackStackEntry2 : value2) {
                            if (navBackStackEntry2 == navBackStackEntry) {
                            }
                        }
                        return;
                    }
                    return;
                }
            }
        }
        xoIox<Set<NavBackStackEntry>> xoiox = this._transitionsInProgress;
        xoiox.setValue(XoI0Ixx0.xxX(xoiox.getValue(), navBackStackEntry));
        List value3 = this.backStack.getValue();
        ListIterator listIterator = value3.listIterator(value3.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                obj = null;
                break;
            }
            obj = listIterator.previous();
            NavBackStackEntry navBackStackEntry3 = (NavBackStackEntry) obj;
            if (!IIX0o.Oxx0IOOO(navBackStackEntry3, navBackStackEntry) && this.backStack.getValue().lastIndexOf(navBackStackEntry3) < this.backStack.getValue().lastIndexOf(navBackStackEntry)) {
                break;
            }
        }
        NavBackStackEntry navBackStackEntry4 = (NavBackStackEntry) obj;
        if (navBackStackEntry4 != null) {
            xoIox<Set<NavBackStackEntry>> xoiox2 = this._transitionsInProgress;
            xoiox2.setValue(XoI0Ixx0.xxX(xoiox2.getValue(), navBackStackEntry4));
        }
        pop(navBackStackEntry, z);
    }

    @CallSuper
    public void prepareForTransition(@OOXIXo NavBackStackEntry navBackStackEntry) {
        IIX0o.x0xO0oo(navBackStackEntry, "entry");
        xoIox<Set<NavBackStackEntry>> xoiox = this._transitionsInProgress;
        xoiox.setValue(XoI0Ixx0.xxX(xoiox.getValue(), navBackStackEntry));
    }

    public void push(@OOXIXo NavBackStackEntry navBackStackEntry) {
        IIX0o.x0xO0oo(navBackStackEntry, "backStackEntry");
        ReentrantLock reentrantLock = this.backStackLock;
        reentrantLock.lock();
        try {
            xoIox<List<NavBackStackEntry>> xoiox = this._backStack;
            xoiox.setValue(CollectionsKt___CollectionsKt.OIxOIX0II(xoiox.getValue(), navBackStackEntry));
            oXIO0o0XI oxio0o0xi = oXIO0o0XI.f19155oIX0oI;
        } finally {
            reentrantLock.unlock();
        }
    }

    public void pushWithTransition(@OOXIXo NavBackStackEntry navBackStackEntry) {
        IIX0o.x0xO0oo(navBackStackEntry, "backStackEntry");
        Iterable value = this._transitionsInProgress.getValue();
        if (!(value instanceof Collection) || !((Collection) value).isEmpty()) {
            Iterator it = value.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (((NavBackStackEntry) it.next()) == navBackStackEntry) {
                    Iterable<NavBackStackEntry> value2 = this.backStack.getValue();
                    if (!(value2 instanceof Collection) || !((Collection) value2).isEmpty()) {
                        for (NavBackStackEntry navBackStackEntry2 : value2) {
                            if (navBackStackEntry2 == navBackStackEntry) {
                                return;
                            }
                        }
                    }
                }
            }
        }
        NavBackStackEntry navBackStackEntry3 = (NavBackStackEntry) CollectionsKt___CollectionsKt.xX0ox(this.backStack.getValue());
        if (navBackStackEntry3 != null) {
            xoIox<Set<NavBackStackEntry>> xoiox = this._transitionsInProgress;
            xoiox.setValue(XoI0Ixx0.xxX(xoiox.getValue(), navBackStackEntry3));
        }
        xoIox<Set<NavBackStackEntry>> xoiox2 = this._transitionsInProgress;
        xoiox2.setValue(XoI0Ixx0.xxX(xoiox2.getValue(), navBackStackEntry));
        push(navBackStackEntry);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void setNavigating(boolean z) {
        this.isNavigating = z;
    }
}
