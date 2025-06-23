package androidx.activity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.lifecycle.LifecycleEventObserver;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.lang.reflect.Field;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

public final class ImmLeaksCleaner implements LifecycleEventObserver {
    @OOXIXo
    public static final Companion Companion = new Companion((IIXOooo) null);
    /* access modifiers changed from: private */
    @OOXIXo
    public static final X0IIOO<Cleaner> cleaner$delegate = XIxXXX0x0.oIX0oI(ImmLeaksCleaner$Companion$cleaner$2.INSTANCE);
    @OOXIXo
    private final Activity activity;

    public static abstract class Cleaner {
        public /* synthetic */ Cleaner(IIXOooo iIXOooo) {
            this();
        }

        public abstract boolean clearNextServedView(@OOXIXo InputMethodManager inputMethodManager);

        @oOoXoXO
        public abstract Object getLock(@OOXIXo InputMethodManager inputMethodManager);

        @oOoXoXO
        public abstract View getServedView(@OOXIXo InputMethodManager inputMethodManager);

        private Cleaner() {
        }
    }

    @SuppressLint({"SoonBlockedPrivateApi"})
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        @OOXIXo
        public final Cleaner getCleaner() {
            return (Cleaner) ImmLeaksCleaner.cleaner$delegate.getValue();
        }

        private Companion() {
        }
    }

    public static final class FailedInitialization extends Cleaner {
        @OOXIXo
        public static final FailedInitialization INSTANCE = new FailedInitialization();

        private FailedInitialization() {
            super((IIXOooo) null);
        }

        public boolean clearNextServedView(@OOXIXo InputMethodManager inputMethodManager) {
            IIX0o.x0xO0oo(inputMethodManager, "<this>");
            return false;
        }

        @oOoXoXO
        public Object getLock(@OOXIXo InputMethodManager inputMethodManager) {
            IIX0o.x0xO0oo(inputMethodManager, "<this>");
            return null;
        }

        @oOoXoXO
        public View getServedView(@OOXIXo InputMethodManager inputMethodManager) {
            IIX0o.x0xO0oo(inputMethodManager, "<this>");
            return null;
        }
    }

    public static final class ValidCleaner extends Cleaner {
        @OOXIXo
        private final Field hField;
        @OOXIXo
        private final Field nextServedViewField;
        @OOXIXo
        private final Field servedViewField;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ValidCleaner(@OOXIXo Field field, @OOXIXo Field field2, @OOXIXo Field field3) {
            super((IIXOooo) null);
            IIX0o.x0xO0oo(field, "hField");
            IIX0o.x0xO0oo(field2, "servedViewField");
            IIX0o.x0xO0oo(field3, "nextServedViewField");
            this.hField = field;
            this.servedViewField = field2;
            this.nextServedViewField = field3;
        }

        public boolean clearNextServedView(@OOXIXo InputMethodManager inputMethodManager) {
            IIX0o.x0xO0oo(inputMethodManager, "<this>");
            try {
                this.nextServedViewField.set(inputMethodManager, (Object) null);
                return true;
            } catch (IllegalAccessException unused) {
                return false;
            }
        }

        @oOoXoXO
        public Object getLock(@OOXIXo InputMethodManager inputMethodManager) {
            IIX0o.x0xO0oo(inputMethodManager, "<this>");
            try {
                return this.hField.get(inputMethodManager);
            } catch (IllegalAccessException unused) {
                return null;
            }
        }

        @oOoXoXO
        public View getServedView(@OOXIXo InputMethodManager inputMethodManager) {
            IIX0o.x0xO0oo(inputMethodManager, "<this>");
            try {
                return (View) this.servedViewField.get(inputMethodManager);
            } catch (ClassCastException | IllegalAccessException unused) {
                return null;
            }
        }
    }

    public ImmLeaksCleaner(@OOXIXo Activity activity2) {
        IIX0o.x0xO0oo(activity2, TTDownloadField.TT_ACTIVITY);
        this.activity = activity2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0041, code lost:
        if (r4 == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0043, code lost:
        r3.isActive();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onStateChanged(@OXOo.OOXIXo androidx.lifecycle.LifecycleOwner r3, @OXOo.OOXIXo androidx.lifecycle.Lifecycle.Event r4) {
        /*
            r2 = this;
            java.lang.String r0 = "source"
            kotlin.jvm.internal.IIX0o.x0xO0oo(r3, r0)
            java.lang.String r3 = "event"
            kotlin.jvm.internal.IIX0o.x0xO0oo(r4, r3)
            androidx.lifecycle.Lifecycle$Event r3 = androidx.lifecycle.Lifecycle.Event.ON_DESTROY
            if (r4 == r3) goto L_0x000f
            return
        L_0x000f:
            android.app.Activity r3 = r2.activity
            java.lang.String r4 = "input_method"
            java.lang.Object r3 = r3.getSystemService(r4)
            java.lang.String r4 = "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager"
            kotlin.jvm.internal.IIX0o.x0XOIxOo(r3, r4)
            android.view.inputmethod.InputMethodManager r3 = (android.view.inputmethod.InputMethodManager) r3
            androidx.activity.ImmLeaksCleaner$Companion r4 = Companion
            androidx.activity.ImmLeaksCleaner$Cleaner r4 = r4.getCleaner()
            java.lang.Object r0 = r4.getLock(r3)
            if (r0 != 0) goto L_0x002b
            return
        L_0x002b:
            monitor-enter(r0)
            android.view.View r1 = r4.getServedView(r3)     // Catch:{ all -> 0x0047 }
            if (r1 != 0) goto L_0x0034
            monitor-exit(r0)
            return
        L_0x0034:
            boolean r1 = r1.isAttachedToWindow()     // Catch:{ all -> 0x0047 }
            if (r1 == 0) goto L_0x003c
            monitor-exit(r0)
            return
        L_0x003c:
            boolean r4 = r4.clearNextServedView(r3)     // Catch:{ all -> 0x0047 }
            monitor-exit(r0)
            if (r4 == 0) goto L_0x0046
            r3.isActive()
        L_0x0046:
            return
        L_0x0047:
            r3 = move-exception
            monitor-exit(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.activity.ImmLeaksCleaner.onStateChanged(androidx.lifecycle.LifecycleOwner, androidx.lifecycle.Lifecycle$Event):void");
    }
}
