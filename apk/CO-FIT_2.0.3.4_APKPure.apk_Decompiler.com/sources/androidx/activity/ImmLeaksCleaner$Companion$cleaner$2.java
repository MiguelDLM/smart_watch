package androidx.activity;

import Oox.oIX0oI;
import android.view.inputmethod.InputMethodManager;
import androidx.activity.ImmLeaksCleaner;
import java.lang.reflect.Field;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nImmLeaksCleaner.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ImmLeaksCleaner.kt\nandroidx/activity/ImmLeaksCleaner$Companion$cleaner$2\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,127:1\n1#2:128\n*E\n"})
public final class ImmLeaksCleaner$Companion$cleaner$2 extends Lambda implements oIX0oI<ImmLeaksCleaner.Cleaner> {
    public static final ImmLeaksCleaner$Companion$cleaner$2 INSTANCE = new ImmLeaksCleaner$Companion$cleaner$2();

    public ImmLeaksCleaner$Companion$cleaner$2() {
        super(0);
    }

    public final ImmLeaksCleaner.Cleaner invoke() {
        Class<InputMethodManager> cls = InputMethodManager.class;
        try {
            Field declaredField = cls.getDeclaredField("mServedView");
            declaredField.setAccessible(true);
            Field declaredField2 = cls.getDeclaredField("mNextServedView");
            declaredField2.setAccessible(true);
            Field declaredField3 = cls.getDeclaredField("mH");
            declaredField3.setAccessible(true);
            IIX0o.oO(declaredField3, "hField");
            IIX0o.oO(declaredField, "servedViewField");
            IIX0o.oO(declaredField2, "nextServedViewField");
            return new ImmLeaksCleaner.ValidCleaner(declaredField3, declaredField, declaredField2);
        } catch (NoSuchFieldException unused) {
            return ImmLeaksCleaner.FailedInitialization.INSTANCE;
        }
    }
}
