package androidx.collection.internal;

import OXOo.OOXIXo;
import Oox.oIX0oI;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.jvm.internal.xxX;

@XX({"SMAP\nLockExt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LockExt.kt\nandroidx/collection/internal/LockExtKt\n+ 2 Lock.jvm.kt\nandroidx/collection/internal/Lock\n*L\n1#1,27:1\n26#2:28\n*S KotlinDebug\n*F\n+ 1 LockExt.kt\nandroidx/collection/internal/LockExtKt\n*L\n25#1:28\n*E\n"})
/* loaded from: classes.dex */
public final class LockExtKt {
    /* renamed from: synchronized, reason: not valid java name */
    public static final <T> T m26synchronized(@OOXIXo Lock lock, @OOXIXo oIX0oI<? extends T> block) {
        T invoke;
        IIX0o.x0xO0oo(lock, "<this>");
        IIX0o.x0xO0oo(block, "block");
        synchronized (lock) {
            try {
                invoke = block.invoke();
                xxX.oxoX(1);
            } catch (Throwable th) {
                xxX.oxoX(1);
                xxX.I0Io(1);
                throw th;
            }
        }
        xxX.I0Io(1);
        return invoke;
    }
}
