package androidx.core.graphics;

import OXOo.OOXIXo;
import Oox.oOoXoXO;
import android.graphics.Canvas;
import android.graphics.Picture;
import kotlin.jvm.internal.xxX;
import kotlin.oXIO0o0XI;

public final class PictureKt {
    @OOXIXo
    public static final Picture record(@OOXIXo Picture picture, int i, int i2, @OOXIXo oOoXoXO<? super Canvas, oXIO0o0XI> oooxoxo) {
        try {
            oooxoxo.invoke(picture.beginRecording(i, i2));
            return picture;
        } finally {
            xxX.oxoX(1);
            picture.endRecording();
            xxX.I0Io(1);
        }
    }
}
