package androidx.core.graphics;

import android.graphics.Canvas;
import android.graphics.Picture;
import kotlin.jvm.internal.xxX;
import kotlin.oXIO0o0XI;

/* loaded from: classes.dex */
public final class PictureKt {
    @OXOo.OOXIXo
    public static final Picture record(@OXOo.OOXIXo Picture picture, int i, int i2, @OXOo.OOXIXo Oox.oOoXoXO<? super Canvas, oXIO0o0XI> oooxoxo) {
        Canvas beginRecording = picture.beginRecording(i, i2);
        try {
            oooxoxo.invoke(beginRecording);
            return picture;
        } finally {
            xxX.oxoX(1);
            picture.endRecording();
            xxX.I0Io(1);
        }
    }
}
