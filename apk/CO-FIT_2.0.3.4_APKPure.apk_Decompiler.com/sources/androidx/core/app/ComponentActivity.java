package androidx.core.app;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.RestrictTo;
import androidx.collection.SimpleArrayMap;
import androidx.core.view.KeyEventDispatcher;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ReportFragment;
import kotlin.jvm.internal.IIX0o;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ComponentActivity extends Activity implements LifecycleOwner, KeyEventDispatcher.Component {
    @OOXIXo
    private final SimpleArrayMap<Class<? extends ExtraData>, ExtraData> extraDataMap = new SimpleArrayMap<>();
    @OOXIXo
    private final LifecycleRegistry lifecycleRegistry = new LifecycleRegistry(this);

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @kotlin.OOXIXo(message = "Store the object you want to save directly by using\n      {@link View#setTag(int, Object)} with the window's decor view.")
    public static class ExtraData {
    }

    private static /* synthetic */ void getExtraDataMap$annotations() {
    }

    private static /* synthetic */ void getLifecycleRegistry$annotations() {
    }

    private final boolean shouldSkipDump(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return false;
        }
        String str = strArr[0];
        switch (str.hashCode()) {
            case -645125871:
                if (str.equals("--translation") && Build.VERSION.SDK_INT >= 31) {
                    return true;
                }
                return false;
            case 100470631:
                if (!str.equals("--dump-dumpable")) {
                    return false;
                }
                break;
            case 472614934:
                if (!str.equals("--list-dumpables")) {
                    return false;
                }
                break;
            case 1159329357:
                if (str.equals("--contentcapture") && Build.VERSION.SDK_INT >= 29) {
                    return true;
                }
                return false;
            case 1455016274:
                if (str.equals("--autofill") && Build.VERSION.SDK_INT >= 26) {
                    return true;
                }
                return false;
            default:
                return false;
        }
        if (Build.VERSION.SDK_INT >= 33) {
            return true;
        }
        return false;
    }

    public boolean dispatchKeyEvent(@OOXIXo KeyEvent keyEvent) {
        IIX0o.x0xO0oo(keyEvent, NotificationCompat.CATEGORY_EVENT);
        View decorView = getWindow().getDecorView();
        IIX0o.oO(decorView, "window.decorView");
        if (KeyEventDispatcher.dispatchBeforeHierarchy(decorView, keyEvent)) {
            return true;
        }
        return KeyEventDispatcher.dispatchKeyEvent(this, decorView, this, keyEvent);
    }

    public boolean dispatchKeyShortcutEvent(@OOXIXo KeyEvent keyEvent) {
        IIX0o.x0xO0oo(keyEvent, NotificationCompat.CATEGORY_EVENT);
        View decorView = getWindow().getDecorView();
        IIX0o.oO(decorView, "window.decorView");
        if (KeyEventDispatcher.dispatchBeforeHierarchy(decorView, keyEvent)) {
            return true;
        }
        return super.dispatchKeyShortcutEvent(keyEvent);
    }

    @oOoXoXO
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @kotlin.OOXIXo(message = "Use {@link View#getTag(int)} with the window's decor view.")
    public <T extends ExtraData> T getExtraData(@OOXIXo Class<T> cls) {
        IIX0o.x0xO0oo(cls, "extraDataClass");
        return (ExtraData) this.extraDataMap.get(cls);
    }

    @OOXIXo
    public Lifecycle getLifecycle() {
        return this.lifecycleRegistry;
    }

    public void onCreate(@oOoXoXO Bundle bundle) {
        super.onCreate(bundle);
        ReportFragment.Companion.injectIfNeededIn(this);
    }

    @CallSuper
    public void onSaveInstanceState(@OOXIXo Bundle bundle) {
        IIX0o.x0xO0oo(bundle, "outState");
        this.lifecycleRegistry.setCurrentState(Lifecycle.State.CREATED);
        super.onSaveInstanceState(bundle);
    }

    @kotlin.OOXIXo(message = "Use {@link View#setTag(int, Object)} with the window's decor view.")
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void putExtraData(@OOXIXo ExtraData extraData) {
        IIX0o.x0xO0oo(extraData, "extraData");
        this.extraDataMap.put(extraData.getClass(), extraData);
    }

    public final boolean shouldDumpInternalState(@oOoXoXO String[] strArr) {
        return !shouldSkipDump(strArr);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean superDispatchKeyEvent(@OOXIXo KeyEvent keyEvent) {
        IIX0o.x0xO0oo(keyEvent, NotificationCompat.CATEGORY_EVENT);
        return super.dispatchKeyEvent(keyEvent);
    }
}
