package androidx.core.graphics;

import OXOo.OOXIXo;
import android.annotation.SuppressLint;
import android.graphics.Path;
import androidx.annotation.RequiresApi;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nPath.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Path.kt\nandroidx/core/graphics/PathKt\n*L\n1#1,80:1\n43#1,3:81\n*S KotlinDebug\n*F\n+ 1 Path.kt\nandroidx/core/graphics/PathKt\n*L\n60#1:81,3\n*E\n"})
@SuppressLint({"ClassVerificationFailure"})
public final class PathKt {
    @OOXIXo
    public static final Path and(@OOXIXo Path path, @OOXIXo Path path2) {
        Path path3 = new Path();
        path3.op(path, path2, Path.Op.INTERSECT);
        return path3;
    }

    @RequiresApi(26)
    @OOXIXo
    public static final Iterable<PathSegment> flatten(@OOXIXo Path path, float f) {
        return PathUtils.flatten(path, f);
    }

    public static /* synthetic */ Iterable flatten$default(Path path, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 0.5f;
        }
        return flatten(path, f);
    }

    @OOXIXo
    public static final Path minus(@OOXIXo Path path, @OOXIXo Path path2) {
        Path path3 = new Path(path);
        path3.op(path2, Path.Op.DIFFERENCE);
        return path3;
    }

    @OOXIXo
    public static final Path or(@OOXIXo Path path, @OOXIXo Path path2) {
        Path path3 = new Path(path);
        path3.op(path2, Path.Op.UNION);
        return path3;
    }

    @OOXIXo
    public static final Path plus(@OOXIXo Path path, @OOXIXo Path path2) {
        Path path3 = new Path(path);
        path3.op(path2, Path.Op.UNION);
        return path3;
    }

    @OOXIXo
    public static final Path xor(@OOXIXo Path path, @OOXIXo Path path2) {
        Path path3 = new Path(path);
        path3.op(path2, Path.Op.XOR);
        return path3;
    }
}
