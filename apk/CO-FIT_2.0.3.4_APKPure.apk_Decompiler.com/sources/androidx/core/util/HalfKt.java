package androidx.core.util;

import OXOo.OOXIXo;
import android.annotation.SuppressLint;
import android.util.Half;
import androidx.annotation.RequiresApi;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nHalf.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Half.kt\nandroidx/core/util/HalfKt\n*L\n1#1,60:1\n43#1:61\n*S KotlinDebug\n*F\n+ 1 Half.kt\nandroidx/core/util/HalfKt\n*L\n51#1:61\n*E\n"})
@SuppressLint({"ClassVerificationFailure"})
public final class HalfKt {
    @RequiresApi(26)
    @OOXIXo
    public static final Half toHalf(short s) {
        return Half.valueOf(s);
    }

    @RequiresApi(26)
    @OOXIXo
    public static final Half toHalf(float f) {
        return Half.valueOf(f);
    }

    @RequiresApi(26)
    @OOXIXo
    public static final Half toHalf(@OOXIXo String str) {
        return Half.valueOf(str);
    }

    @RequiresApi(26)
    @OOXIXo
    public static final Half toHalf(double d) {
        return Half.valueOf((float) d);
    }
}
