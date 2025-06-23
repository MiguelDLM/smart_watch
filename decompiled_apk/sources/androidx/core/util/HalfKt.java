package androidx.core.util;

import android.annotation.SuppressLint;
import android.util.Half;
import androidx.annotation.RequiresApi;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nHalf.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Half.kt\nandroidx/core/util/HalfKt\n*L\n1#1,60:1\n43#1:61\n*S KotlinDebug\n*F\n+ 1 Half.kt\nandroidx/core/util/HalfKt\n*L\n51#1:61\n*E\n"})
@SuppressLint({"ClassVerificationFailure"})
/* loaded from: classes.dex */
public final class HalfKt {
    @OXOo.OOXIXo
    @RequiresApi(26)
    public static final Half toHalf(short s) {
        Half valueOf;
        valueOf = Half.valueOf(s);
        return valueOf;
    }

    @OXOo.OOXIXo
    @RequiresApi(26)
    public static final Half toHalf(float f) {
        Half valueOf;
        valueOf = Half.valueOf(f);
        return valueOf;
    }

    @OXOo.OOXIXo
    @RequiresApi(26)
    public static final Half toHalf(@OXOo.OOXIXo String str) {
        Half valueOf;
        valueOf = Half.valueOf(str);
        return valueOf;
    }

    @OXOo.OOXIXo
    @RequiresApi(26)
    public static final Half toHalf(double d) {
        Half valueOf;
        valueOf = Half.valueOf((float) d);
        return valueOf;
    }
}
