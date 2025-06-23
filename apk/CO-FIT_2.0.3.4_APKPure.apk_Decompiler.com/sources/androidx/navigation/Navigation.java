package androidx.navigation;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.x0XOIxOo;
import XO0OX.xoIox;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.IdRes;
import androidx.core.app.ActivityCompat;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.IIX0o;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;

public final class Navigation {
    @OOXIXo
    public static final Navigation INSTANCE = new Navigation();

    private Navigation() {
    }

    @xoIox
    @x0XOIxOo
    @OOXIXo
    public static final View.OnClickListener createNavigateOnClickListener(@IdRes int i) {
        return createNavigateOnClickListener$default(i, (Bundle) null, 2, (Object) null);
    }

    public static /* synthetic */ View.OnClickListener createNavigateOnClickListener$default(int i, Bundle bundle, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            bundle = null;
        }
        return createNavigateOnClickListener(i, bundle);
    }

    /* access modifiers changed from: private */
    public static final void createNavigateOnClickListener$lambda$0(int i, Bundle bundle, View view) {
        IIX0o.oO(view, ViewHierarchyConstants.VIEW_KEY);
        findNavController(view).navigate(i, bundle);
    }

    /* access modifiers changed from: private */
    public static final void createNavigateOnClickListener$lambda$1(NavDirections navDirections, View view) {
        IIX0o.x0xO0oo(navDirections, "$directions");
        IIX0o.oO(view, ViewHierarchyConstants.VIEW_KEY);
        findNavController(view).navigate(navDirections);
    }

    @x0XOIxOo
    @OOXIXo
    public static final NavController findNavController(@OOXIXo Activity activity, @IdRes int i) {
        IIX0o.x0xO0oo(activity, TTDownloadField.TT_ACTIVITY);
        View requireViewById = ActivityCompat.requireViewById(activity, i);
        IIX0o.oO(requireViewById, "requireViewById<View>(activity, viewId)");
        NavController findViewNavController = INSTANCE.findViewNavController(requireViewById);
        if (findViewNavController != null) {
            return findViewNavController;
        }
        throw new IllegalStateException("Activity " + activity + " does not have a NavController set on " + i);
    }

    private final NavController findViewNavController(View view) {
        return (NavController) SequencesKt___SequencesKt.xOOOX(SequencesKt___SequencesKt.IOoo(SequencesKt__SequencesKt.x0XOIxOo(view, Navigation$findViewNavController$1.INSTANCE), Navigation$findViewNavController$2.INSTANCE));
    }

    /* access modifiers changed from: private */
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
    public static final void setViewNavController(@OOXIXo View view, @oOoXoXO NavController navController) {
        IIX0o.x0xO0oo(view, ViewHierarchyConstants.VIEW_KEY);
        view.setTag(R.id.nav_controller_view_tag, navController);
    }

    @xoIox
    @x0XOIxOo
    @OOXIXo
    public static final View.OnClickListener createNavigateOnClickListener(@IdRes int i, @oOoXoXO Bundle bundle) {
        return new I0Io(i, bundle);
    }

    @x0XOIxOo
    @OOXIXo
    public static final View.OnClickListener createNavigateOnClickListener(@OOXIXo NavDirections navDirections) {
        IIX0o.x0xO0oo(navDirections, "directions");
        return new II0xO0(navDirections);
    }

    @x0XOIxOo
    @OOXIXo
    public static final NavController findNavController(@OOXIXo View view) {
        IIX0o.x0xO0oo(view, ViewHierarchyConstants.VIEW_KEY);
        NavController findViewNavController = INSTANCE.findViewNavController(view);
        if (findViewNavController != null) {
            return findViewNavController;
        }
        throw new IllegalStateException("View " + view + " does not have a NavController set");
    }
}
