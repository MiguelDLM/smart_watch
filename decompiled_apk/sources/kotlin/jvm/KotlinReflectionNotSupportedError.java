package kotlin.jvm;

import OXOo.oOoXoXO;

/* loaded from: classes6.dex */
public class KotlinReflectionNotSupportedError extends Error {
    public KotlinReflectionNotSupportedError() {
        super("Kotlin reflection implementation is not found at runtime. Make sure you have kotlin-reflect.jar in the classpath");
    }

    public KotlinReflectionNotSupportedError(@oOoXoXO String str) {
        super(str);
    }

    public KotlinReflectionNotSupportedError(@oOoXoXO String str, @oOoXoXO Throwable th) {
        super(str, th);
    }

    public KotlinReflectionNotSupportedError(@oOoXoXO Throwable th) {
        super(th);
    }
}
