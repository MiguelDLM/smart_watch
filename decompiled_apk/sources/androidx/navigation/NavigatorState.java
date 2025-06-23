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
/* loaded from: classes.dex */
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

    public void markTransitionComplete(@OOXIXo NavBackStackEntry entry) {
        IIX0o.x0xO0oo(entry, "entry");
        xoIox<Set<NavBackStackEntry>> xoiox = this._transitionsInProgress;
        xoiox.setValue(XoI0Ixx0.OxI(xoiox.getValue(), entry));
    }

    @CallSuper
    public void onLaunchSingleTop(@OOXIXo NavBackStackEntry backStackEntry) {
        int i;
        IIX0o.x0xO0oo(backStackEntry, "backStackEntry");
        ReentrantLock reentrantLock = this.backStackLock;
        reentrantLock.lock();
        try {
            List<NavBackStackEntry> o0Xo0XII = CollectionsKt___CollectionsKt.o0Xo0XII(this.backStack.getValue());
            ListIterator<NavBackStackEntry> listIterator = o0Xo0XII.listIterator(o0Xo0XII.size());
            while (true) {
                if (listIterator.hasPrevious()) {
                    if (IIX0o.Oxx0IOOO(listIterator.previous().getId(), backStackEntry.getId())) {
                        i = listIterator.nextIndex();
                        break;
                    }
                } else {
                    i = -1;
                    break;
                }
            }
            o0Xo0XII.set(i, backStackEntry);
            this._backStack.setValue(o0Xo0XII);
            oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @CallSuper
    public void onLaunchSingleTopWithTransition(@OOXIXo NavBackStackEntry backStackEntry) {
        IIX0o.x0xO0oo(backStackEntry, "backStackEntry");
        List<NavBackStackEntry> value = this.backStack.getValue();
        ListIterator<NavBackStackEntry> listIterator = value.listIterator(value.size());
        while (listIterator.hasPrevious()) {
            NavBackStackEntry previous = listIterator.previous();
            if (IIX0o.Oxx0IOOO(previous.getId(), backStackEntry.getId())) {
                xoIox<Set<NavBackStackEntry>> xoiox = this._transitionsInProgress;
                xoiox.setValue(XoI0Ixx0.xxX(XoI0Ixx0.xxX(xoiox.getValue(), previous), backStackEntry));
                onLaunchSingleTop(backStackEntry);
                return;
            }
        }
        throw new NoSuchElementException("List contains no element matching the predicate.");
    }

    public void pop(@OOXIXo NavBackStackEntry popUpTo, boolean z) {
        IIX0o.x0xO0oo(popUpTo, "popUpTo");
        ReentrantLock reentrantLock = this.backStackLock;
        reentrantLock.lock();
        try {
            xoIox<List<NavBackStackEntry>> xoiox = this._backStack;
            List<NavBackStackEntry> value = xoiox.getValue();
            ArrayList arrayList = new ArrayList();
            for (Object obj : value) {
                if (IIX0o.Oxx0IOOO((NavBackStackEntry) obj, popUpTo)) {
                    break;
                } else {
                    arrayList.add(obj);
                }
            }
            xoiox.setValue(arrayList);
            oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public void popWithTransition(@OOXIXo NavBackStackEntry popUpTo, boolean z) {
        NavBackStackEntry navBackStackEntry;
        IIX0o.x0xO0oo(popUpTo, "popUpTo");
        Set<NavBackStackEntry> value = this._transitionsInProgress.getValue();
        if (!(value instanceof Collection) || !value.isEmpty()) {
            Iterator<T> it = value.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (((NavBackStackEntry) it.next()) == popUpTo) {
                    List<NavBackStackEntry> value2 = this.backStack.getValue();
                    if (!(value2 instanceof Collection) || !value2.isEmpty()) {
                        Iterator<T> it2 = value2.iterator();
                        while (it2.hasNext()) {
                            if (((NavBackStackEntry) it2.next()) == popUpTo) {
                            }
                        }
                        return;
                    }
                    return;
                }
            }
        }
        xoIox<Set<NavBackStackEntry>> xoiox = this._transitionsInProgress;
        xoiox.setValue(XoI0Ixx0.xxX(xoiox.getValue(), popUpTo));
        List<NavBackStackEntry> value3 = this.backStack.getValue();
        ListIterator<NavBackStackEntry> listIterator = value3.listIterator(value3.size());
        while (true) {
            if (listIterator.hasPrevious()) {
                navBackStackEntry = listIterator.previous();
                NavBackStackEntry navBackStackEntry2 = navBackStackEntry;
                if (!IIX0o.Oxx0IOOO(navBackStackEntry2, popUpTo) && this.backStack.getValue().lastIndexOf(navBackStackEntry2) < this.backStack.getValue().lastIndexOf(popUpTo)) {
                    break;
                }
            } else {
                navBackStackEntry = null;
                break;
            }
        }
        NavBackStackEntry navBackStackEntry3 = navBackStackEntry;
        if (navBackStackEntry3 != null) {
            xoIox<Set<NavBackStackEntry>> xoiox2 = this._transitionsInProgress;
            xoiox2.setValue(XoI0Ixx0.xxX(xoiox2.getValue(), navBackStackEntry3));
        }
        pop(popUpTo, z);
    }

    @CallSuper
    public void prepareForTransition(@OOXIXo NavBackStackEntry entry) {
        IIX0o.x0xO0oo(entry, "entry");
        xoIox<Set<NavBackStackEntry>> xoiox = this._transitionsInProgress;
        xoiox.setValue(XoI0Ixx0.xxX(xoiox.getValue(), entry));
    }

    public void push(@OOXIXo NavBackStackEntry backStackEntry) {
        IIX0o.x0xO0oo(backStackEntry, "backStackEntry");
        ReentrantLock reentrantLock = this.backStackLock;
        reentrantLock.lock();
        try {
            xoIox<List<NavBackStackEntry>> xoiox = this._backStack;
            xoiox.setValue(CollectionsKt___CollectionsKt.OIxOIX0II(xoiox.getValue(), backStackEntry));
            oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
        } finally {
            reentrantLock.unlock();
        }
    }

    public void pushWithTransition(@OOXIXo NavBackStackEntry backStackEntry) {
        IIX0o.x0xO0oo(backStackEntry, "backStackEntry");
        Set<NavBackStackEntry> value = this._transitionsInProgress.getValue();
        if (!(value instanceof Collection) || !value.isEmpty()) {
            Iterator<T> it = value.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (((NavBackStackEntry) it.next()) == backStackEntry) {
                    List<NavBackStackEntry> value2 = this.backStack.getValue();
                    if (!(value2 instanceof Collection) || !value2.isEmpty()) {
                        Iterator<T> it2 = value2.iterator();
                        while (it2.hasNext()) {
                            if (((NavBackStackEntry) it2.next()) == backStackEntry) {
                                return;
                            }
                        }
                    }
                }
            }
        }
        NavBackStackEntry navBackStackEntry = (NavBackStackEntry) CollectionsKt___CollectionsKt.xX0ox(this.backStack.getValue());
        if (navBackStackEntry != null) {
            xoIox<Set<NavBackStackEntry>> xoiox = this._transitionsInProgress;
            xoiox.setValue(XoI0Ixx0.xxX(xoiox.getValue(), navBackStackEntry));
        }
        xoIox<Set<NavBackStackEntry>> xoiox2 = this._transitionsInProgress;
        xoiox2.setValue(XoI0Ixx0.xxX(xoiox2.getValue(), backStackEntry));
        push(backStackEntry);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void setNavigating(boolean z) {
        this.isNavigating = z;
    }
}
