package androidx.core.graphics;

import android.graphics.Matrix;
import android.graphics.Shader;
import kotlin.oXIO0o0XI;

/* loaded from: classes.dex */
public final class ShaderKt {
    public static final void transform(@OXOo.OOXIXo Shader shader, @OXOo.OOXIXo Oox.oOoXoXO<? super Matrix, oXIO0o0XI> oooxoxo) {
        Matrix matrix = new Matrix();
        shader.getLocalMatrix(matrix);
        oooxoxo.invoke(matrix);
        shader.setLocalMatrix(matrix);
    }
}
