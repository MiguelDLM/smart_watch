package androidx.core.graphics;

import OXOo.OOXIXo;
import Oox.oOoXoXO;
import android.graphics.Matrix;
import android.graphics.Shader;
import kotlin.oXIO0o0XI;

public final class ShaderKt {
    public static final void transform(@OOXIXo Shader shader, @OOXIXo oOoXoXO<? super Matrix, oXIO0o0XI> oooxoxo) {
        Matrix matrix = new Matrix();
        shader.getLocalMatrix(matrix);
        oooxoxo.invoke(matrix);
        shader.setLocalMatrix(matrix);
    }
}
