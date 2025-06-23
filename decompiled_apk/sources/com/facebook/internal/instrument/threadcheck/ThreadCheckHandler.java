package com.facebook.internal.instrument.threadcheck;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.x0XOIxOo;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.RestrictTo;
import com.facebook.internal.instrument.InstrumentData;
import java.util.Arrays;
import java.util.Locale;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.oxxXoxO;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes8.dex */
public final class ThreadCheckHandler {

    @OOXIXo
    public static final ThreadCheckHandler INSTANCE = new ThreadCheckHandler();

    @oOoXoXO
    private static final String TAG = ThreadCheckHandler.class.getCanonicalName();
    private static boolean enabled;

    private ThreadCheckHandler() {
    }

    @x0XOIxOo
    public static final void enable() {
        enabled = true;
    }

    private final void log(String str, Class<?> cls, String str2, String str3) {
        if (!enabled) {
            return;
        }
        oxxXoxO oxxxoxo = oxxXoxO.f29356oIX0oI;
        String format = String.format(Locale.US, "%s annotation violation detected in %s.%s%s. Current looper is %s and main looper is %s.", Arrays.copyOf(new Object[]{str, cls.getName(), str2, str3, Looper.myLooper(), Looper.getMainLooper()}, 6));
        IIX0o.oO(format, "java.lang.String.format(locale, format, *args)");
        Exception exc = new Exception();
        Log.e(TAG, format, exc);
        InstrumentData.Builder builder = InstrumentData.Builder.INSTANCE;
        InstrumentData.Builder.build(exc, InstrumentData.Type.ThreadCheck).save();
    }

    @x0XOIxOo
    public static final void uiThreadViolationDetected(@OOXIXo Class<?> clazz, @OOXIXo String methodName, @OOXIXo String methodDesc) {
        IIX0o.x0xO0oo(clazz, "clazz");
        IIX0o.x0xO0oo(methodName, "methodName");
        IIX0o.x0xO0oo(methodDesc, "methodDesc");
        INSTANCE.log("@UiThread", clazz, methodName, methodDesc);
    }

    @x0XOIxOo
    public static final void workerThreadViolationDetected(@OOXIXo Class<?> clazz, @OOXIXo String methodName, @OOXIXo String methodDesc) {
        IIX0o.x0xO0oo(clazz, "clazz");
        IIX0o.x0xO0oo(methodName, "methodName");
        IIX0o.x0xO0oo(methodDesc, "methodDesc");
        INSTANCE.log("@WorkerThread", clazz, methodName, methodDesc);
    }
}
