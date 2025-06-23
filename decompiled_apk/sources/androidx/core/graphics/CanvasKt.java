package androidx.core.graphics;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import kotlin.jvm.internal.xxX;
import kotlin.oXIO0o0XI;

/* loaded from: classes.dex */
public final class CanvasKt {
    public static final void withClip(@OXOo.OOXIXo Canvas canvas, @OXOo.OOXIXo Rect rect, @OXOo.OOXIXo Oox.oOoXoXO<? super Canvas, oXIO0o0XI> oooxoxo) {
        int save = canvas.save();
        canvas.clipRect(rect);
        try {
            oooxoxo.invoke(canvas);
        } finally {
            xxX.oxoX(1);
            canvas.restoreToCount(save);
            xxX.I0Io(1);
        }
    }

    public static final void withMatrix(@OXOo.OOXIXo Canvas canvas, @OXOo.OOXIXo Matrix matrix, @OXOo.OOXIXo Oox.oOoXoXO<? super Canvas, oXIO0o0XI> oooxoxo) {
        int save = canvas.save();
        canvas.concat(matrix);
        try {
            oooxoxo.invoke(canvas);
        } finally {
            xxX.oxoX(1);
            canvas.restoreToCount(save);
            xxX.I0Io(1);
        }
    }

    public static /* synthetic */ void withMatrix$default(Canvas canvas, Matrix matrix, Oox.oOoXoXO oooxoxo, int i, Object obj) {
        if ((i & 1) != 0) {
            matrix = new Matrix();
        }
        int save = canvas.save();
        canvas.concat(matrix);
        try {
            oooxoxo.invoke(canvas);
        } finally {
            xxX.oxoX(1);
            canvas.restoreToCount(save);
            xxX.I0Io(1);
        }
    }

    public static final void withRotation(@OXOo.OOXIXo Canvas canvas, float f, float f2, float f3, @OXOo.OOXIXo Oox.oOoXoXO<? super Canvas, oXIO0o0XI> oooxoxo) {
        int save = canvas.save();
        canvas.rotate(f, f2, f3);
        try {
            oooxoxo.invoke(canvas);
        } finally {
            xxX.oxoX(1);
            canvas.restoreToCount(save);
            xxX.I0Io(1);
        }
    }

    public static /* synthetic */ void withRotation$default(Canvas canvas, float f, float f2, float f3, Oox.oOoXoXO oooxoxo, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 0.0f;
        }
        if ((i & 2) != 0) {
            f2 = 0.0f;
        }
        if ((i & 4) != 0) {
            f3 = 0.0f;
        }
        int save = canvas.save();
        canvas.rotate(f, f2, f3);
        try {
            oooxoxo.invoke(canvas);
        } finally {
            xxX.oxoX(1);
            canvas.restoreToCount(save);
            xxX.I0Io(1);
        }
    }

    public static final void withSave(@OXOo.OOXIXo Canvas canvas, @OXOo.OOXIXo Oox.oOoXoXO<? super Canvas, oXIO0o0XI> oooxoxo) {
        int save = canvas.save();
        try {
            oooxoxo.invoke(canvas);
        } finally {
            xxX.oxoX(1);
            canvas.restoreToCount(save);
            xxX.I0Io(1);
        }
    }

    public static final void withScale(@OXOo.OOXIXo Canvas canvas, float f, float f2, float f3, float f4, @OXOo.OOXIXo Oox.oOoXoXO<? super Canvas, oXIO0o0XI> oooxoxo) {
        int save = canvas.save();
        canvas.scale(f, f2, f3, f4);
        try {
            oooxoxo.invoke(canvas);
        } finally {
            xxX.oxoX(1);
            canvas.restoreToCount(save);
            xxX.I0Io(1);
        }
    }

    public static /* synthetic */ void withScale$default(Canvas canvas, float f, float f2, float f3, float f4, Oox.oOoXoXO oooxoxo, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 1.0f;
        }
        if ((i & 2) != 0) {
            f2 = 1.0f;
        }
        if ((i & 4) != 0) {
            f3 = 0.0f;
        }
        if ((i & 8) != 0) {
            f4 = 0.0f;
        }
        int save = canvas.save();
        canvas.scale(f, f2, f3, f4);
        try {
            oooxoxo.invoke(canvas);
        } finally {
            xxX.oxoX(1);
            canvas.restoreToCount(save);
            xxX.I0Io(1);
        }
    }

    public static final void withSkew(@OXOo.OOXIXo Canvas canvas, float f, float f2, @OXOo.OOXIXo Oox.oOoXoXO<? super Canvas, oXIO0o0XI> oooxoxo) {
        int save = canvas.save();
        canvas.skew(f, f2);
        try {
            oooxoxo.invoke(canvas);
        } finally {
            xxX.oxoX(1);
            canvas.restoreToCount(save);
            xxX.I0Io(1);
        }
    }

    public static /* synthetic */ void withSkew$default(Canvas canvas, float f, float f2, Oox.oOoXoXO oooxoxo, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 0.0f;
        }
        if ((i & 2) != 0) {
            f2 = 0.0f;
        }
        int save = canvas.save();
        canvas.skew(f, f2);
        try {
            oooxoxo.invoke(canvas);
        } finally {
            xxX.oxoX(1);
            canvas.restoreToCount(save);
            xxX.I0Io(1);
        }
    }

    public static final void withTranslation(@OXOo.OOXIXo Canvas canvas, float f, float f2, @OXOo.OOXIXo Oox.oOoXoXO<? super Canvas, oXIO0o0XI> oooxoxo) {
        int save = canvas.save();
        canvas.translate(f, f2);
        try {
            oooxoxo.invoke(canvas);
        } finally {
            xxX.oxoX(1);
            canvas.restoreToCount(save);
            xxX.I0Io(1);
        }
    }

    public static /* synthetic */ void withTranslation$default(Canvas canvas, float f, float f2, Oox.oOoXoXO oooxoxo, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 0.0f;
        }
        if ((i & 2) != 0) {
            f2 = 0.0f;
        }
        int save = canvas.save();
        canvas.translate(f, f2);
        try {
            oooxoxo.invoke(canvas);
        } finally {
            xxX.oxoX(1);
            canvas.restoreToCount(save);
            xxX.I0Io(1);
        }
    }

    public static final void withClip(@OXOo.OOXIXo Canvas canvas, @OXOo.OOXIXo RectF rectF, @OXOo.OOXIXo Oox.oOoXoXO<? super Canvas, oXIO0o0XI> oooxoxo) {
        int save = canvas.save();
        canvas.clipRect(rectF);
        try {
            oooxoxo.invoke(canvas);
        } finally {
            xxX.oxoX(1);
            canvas.restoreToCount(save);
            xxX.I0Io(1);
        }
    }

    public static final void withClip(@OXOo.OOXIXo Canvas canvas, int i, int i2, int i3, int i4, @OXOo.OOXIXo Oox.oOoXoXO<? super Canvas, oXIO0o0XI> oooxoxo) {
        int save = canvas.save();
        canvas.clipRect(i, i2, i3, i4);
        try {
            oooxoxo.invoke(canvas);
        } finally {
            xxX.oxoX(1);
            canvas.restoreToCount(save);
            xxX.I0Io(1);
        }
    }

    public static final void withClip(@OXOo.OOXIXo Canvas canvas, float f, float f2, float f3, float f4, @OXOo.OOXIXo Oox.oOoXoXO<? super Canvas, oXIO0o0XI> oooxoxo) {
        int save = canvas.save();
        canvas.clipRect(f, f2, f3, f4);
        try {
            oooxoxo.invoke(canvas);
        } finally {
            xxX.oxoX(1);
            canvas.restoreToCount(save);
            xxX.I0Io(1);
        }
    }

    public static final void withClip(@OXOo.OOXIXo Canvas canvas, @OXOo.OOXIXo Path path, @OXOo.OOXIXo Oox.oOoXoXO<? super Canvas, oXIO0o0XI> oooxoxo) {
        int save = canvas.save();
        canvas.clipPath(path);
        try {
            oooxoxo.invoke(canvas);
        } finally {
            xxX.oxoX(1);
            canvas.restoreToCount(save);
            xxX.I0Io(1);
        }
    }
}
