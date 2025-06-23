package androidx.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.activity.ImmLeaksCleaner;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import java.lang.reflect.Field;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes.dex */
public final class ImmLeaksCleaner implements LifecycleEventObserver {

    @OXOo.OOXIXo
    public static final Companion Companion = new Companion(null);

    @OXOo.OOXIXo
    private static final X0IIOO<Cleaner> cleaner$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<Cleaner>() { // from class: androidx.activity.ImmLeaksCleaner$Companion$cleaner$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImmLeaksCleaner.Cleaner invoke() {
            try {
                Field servedViewField = InputMethodManager.class.getDeclaredField("mServedView");
                servedViewField.setAccessible(true);
                Field nextServedViewField = InputMethodManager.class.getDeclaredField("mNextServedView");
                nextServedViewField.setAccessible(true);
                Field hField = InputMethodManager.class.getDeclaredField("mH");
                hField.setAccessible(true);
                IIX0o.oO(hField, "hField");
                IIX0o.oO(servedViewField, "servedViewField");
                IIX0o.oO(nextServedViewField, "nextServedViewField");
                return new ImmLeaksCleaner.ValidCleaner(hField, servedViewField, nextServedViewField);
            } catch (NoSuchFieldException unused) {
                return ImmLeaksCleaner.FailedInitialization.INSTANCE;
            }
        }
    });

    @OXOo.OOXIXo
    private final Activity activity;

    /* loaded from: classes.dex */
    public static abstract class Cleaner {
        public /* synthetic */ Cleaner(IIXOooo iIXOooo) {
            this();
        }

        public abstract boolean clearNextServedView(@OXOo.OOXIXo InputMethodManager inputMethodManager);

        @OXOo.oOoXoXO
        public abstract Object getLock(@OXOo.OOXIXo InputMethodManager inputMethodManager);

        @OXOo.oOoXoXO
        public abstract View getServedView(@OXOo.OOXIXo InputMethodManager inputMethodManager);

        private Cleaner() {
        }
    }

    @SuppressLint({"SoonBlockedPrivateApi"})
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        @OXOo.OOXIXo
        public final Cleaner getCleaner() {
            return (Cleaner) ImmLeaksCleaner.cleaner$delegate.getValue();
        }

        private Companion() {
        }
    }

    /* loaded from: classes.dex */
    public static final class FailedInitialization extends Cleaner {

        @OXOo.OOXIXo
        public static final FailedInitialization INSTANCE = new FailedInitialization();

        private FailedInitialization() {
            super(null);
        }

        @Override // androidx.activity.ImmLeaksCleaner.Cleaner
        public boolean clearNextServedView(@OXOo.OOXIXo InputMethodManager inputMethodManager) {
            IIX0o.x0xO0oo(inputMethodManager, "<this>");
            return false;
        }

        @Override // androidx.activity.ImmLeaksCleaner.Cleaner
        @OXOo.oOoXoXO
        public Object getLock(@OXOo.OOXIXo InputMethodManager inputMethodManager) {
            IIX0o.x0xO0oo(inputMethodManager, "<this>");
            return null;
        }

        @Override // androidx.activity.ImmLeaksCleaner.Cleaner
        @OXOo.oOoXoXO
        public View getServedView(@OXOo.OOXIXo InputMethodManager inputMethodManager) {
            IIX0o.x0xO0oo(inputMethodManager, "<this>");
            return null;
        }
    }

    /* loaded from: classes.dex */
    public static final class ValidCleaner extends Cleaner {

        @OXOo.OOXIXo
        private final Field hField;

        @OXOo.OOXIXo
        private final Field nextServedViewField;

        @OXOo.OOXIXo
        private final Field servedViewField;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ValidCleaner(@OXOo.OOXIXo Field hField, @OXOo.OOXIXo Field servedViewField, @OXOo.OOXIXo Field nextServedViewField) {
            super(null);
            IIX0o.x0xO0oo(hField, "hField");
            IIX0o.x0xO0oo(servedViewField, "servedViewField");
            IIX0o.x0xO0oo(nextServedViewField, "nextServedViewField");
            this.hField = hField;
            this.servedViewField = servedViewField;
            this.nextServedViewField = nextServedViewField;
        }

        @Override // androidx.activity.ImmLeaksCleaner.Cleaner
        public boolean clearNextServedView(@OXOo.OOXIXo InputMethodManager inputMethodManager) {
            IIX0o.x0xO0oo(inputMethodManager, "<this>");
            try {
                this.nextServedViewField.set(inputMethodManager, null);
                return true;
            } catch (IllegalAccessException unused) {
                return false;
            }
        }

        @Override // androidx.activity.ImmLeaksCleaner.Cleaner
        @OXOo.oOoXoXO
        public Object getLock(@OXOo.OOXIXo InputMethodManager inputMethodManager) {
            IIX0o.x0xO0oo(inputMethodManager, "<this>");
            try {
                return this.hField.get(inputMethodManager);
            } catch (IllegalAccessException unused) {
                return null;
            }
        }

        @Override // androidx.activity.ImmLeaksCleaner.Cleaner
        @OXOo.oOoXoXO
        public View getServedView(@OXOo.OOXIXo InputMethodManager inputMethodManager) {
            IIX0o.x0xO0oo(inputMethodManager, "<this>");
            try {
                return (View) this.servedViewField.get(inputMethodManager);
            } catch (ClassCastException | IllegalAccessException unused) {
                return null;
            }
        }
    }

    public ImmLeaksCleaner(@OXOo.OOXIXo Activity activity) {
        IIX0o.x0xO0oo(activity, "activity");
        this.activity = activity;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(@OXOo.OOXIXo LifecycleOwner source, @OXOo.OOXIXo Lifecycle.Event event) {
        IIX0o.x0xO0oo(source, "source");
        IIX0o.x0xO0oo(event, "event");
        if (event != Lifecycle.Event.ON_DESTROY) {
            return;
        }
        Object systemService = this.activity.getSystemService("input_method");
        IIX0o.x0XOIxOo(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        InputMethodManager inputMethodManager = (InputMethodManager) systemService;
        Cleaner cleaner = Companion.getCleaner();
        Object lock = cleaner.getLock(inputMethodManager);
        if (lock == null) {
            return;
        }
        synchronized (lock) {
            View servedView = cleaner.getServedView(inputMethodManager);
            if (servedView == null) {
                return;
            }
            if (servedView.isAttachedToWindow()) {
                return;
            }
            boolean clearNextServedView = cleaner.clearNextServedView(inputMethodManager);
            if (clearNextServedView) {
                inputMethodManager.isActive();
            }
        }
    }
}
