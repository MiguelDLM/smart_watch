package androidx.navigation;

import OXOo.OOXIXo;
import Oox.oOoXoXO;
import XO0OX.x0XOIxOo;
import XO0OX.xoIox;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.IdRes;
import androidx.core.app.ActivityCompat;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.IIX0o;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;

/* loaded from: classes.dex */
public final class Navigation {

    @OOXIXo
    public static final Navigation INSTANCE = new Navigation();

    private Navigation() {
    }

    @x0XOIxOo
    @OOXIXo
    @xoIox
    public static final View.OnClickListener createNavigateOnClickListener(@IdRes int i) {
        return createNavigateOnClickListener$default(i, null, 2, null);
    }

    public static /* synthetic */ View.OnClickListener createNavigateOnClickListener$default(int i, Bundle bundle, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            bundle = null;
        }
        return createNavigateOnClickListener(i, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createNavigateOnClickListener$lambda$0(int i, Bundle bundle, View view) {
        IIX0o.oO(view, "view");
        findNavController(view).navigate(i, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createNavigateOnClickListener$lambda$1(NavDirections directions, View view) {
        IIX0o.x0xO0oo(directions, "$directions");
        IIX0o.oO(view, "view");
        findNavController(view).navigate(directions);
    }

    @x0XOIxOo
    @OOXIXo
    public static final NavController findNavController(@OOXIXo Activity activity, @IdRes int i) {
        IIX0o.x0xO0oo(activity, "activity");
        View requireViewById = ActivityCompat.requireViewById(activity, i);
        IIX0o.oO(requireViewById, "requireViewById<View>(activity, viewId)");
        NavController findViewNavController = INSTANCE.findViewNavController(requireViewById);
        if (findViewNavController != null) {
            return findViewNavController;
        }
        throw new IllegalStateException("Activity " + activity + " does not have a NavController set on " + i);
    }

    private final NavController findViewNavController(View view) {
        return (NavController) SequencesKt___SequencesKt.xOOOX(SequencesKt___SequencesKt.IOoo(SequencesKt__SequencesKt.x0XOIxOo(view, new oOoXoXO<View, View>() { // from class: androidx.navigation.Navigation$findViewNavController$1
            @Override // Oox.oOoXoXO
            public final View invoke(View it) {
                IIX0o.x0xO0oo(it, "it");
                Object parent = it.getParent();
                if (parent instanceof View) {
                    return (View) parent;
                }
                return null;
            }
        }), new oOoXoXO<View, NavController>() { // from class: androidx.navigation.Navigation$findViewNavController$2
            @Override // Oox.oOoXoXO
            public final NavController invoke(View it) {
                NavController viewNavController;
                IIX0o.x0xO0oo(it, "it");
                viewNavController = Navigation.INSTANCE.getViewNavController(it);
                return viewNavController;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final NavController getViewNavController(View view) {
        Object tag = view.getTag(R.id.nav_controller_view_tag);
        if (tag instanceof WeakReference) {
            return (NavController) ((WeakReference) tag).get();
        }
        if (tag instanceof NavController) {
            return (NavController) tag;
        }
        return null;
    }

    @x0XOIxOo
    public static final void setViewNavController(@OOXIXo View view, @OXOo.oOoXoXO NavController navController) {
        IIX0o.x0xO0oo(view, "view");
        view.setTag(R.id.nav_controller_view_tag, navController);
    }

    @x0XOIxOo
    @OOXIXo
    @xoIox
    public static final View.OnClickListener createNavigateOnClickListener(@IdRes final int i, @OXOo.oOoXoXO final Bundle bundle) {
        return new View.OnClickListener() { // from class: androidx.navigation.I0Io
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Navigation.createNavigateOnClickListener$lambda$0(i, bundle, view);
            }
        };
    }

    @x0XOIxOo
    @OOXIXo
    public static final View.OnClickListener createNavigateOnClickListener(@OOXIXo final NavDirections directions) {
        IIX0o.x0xO0oo(directions, "directions");
        return new View.OnClickListener() { // from class: androidx.navigation.II0xO0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Navigation.createNavigateOnClickListener$lambda$1(NavDirections.this, view);
            }
        };
    }

    @x0XOIxOo
    @OOXIXo
    public static final NavController findNavController(@OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        NavController findViewNavController = INSTANCE.findViewNavController(view);
        if (findViewNavController != null) {
            return findViewNavController;
        }
        throw new IllegalStateException("View " + view + " does not have a NavController set");
    }
}
