package androidx.core.graphics;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.graphics.drawable.Drawable;
import androidx.annotation.RequiresApi;
import kotlin.oXIO0o0XI;

@SuppressLint({"ClassVerificationFailure"})
/* loaded from: classes.dex */
public final class ImageDecoderKt {
    @OXOo.OOXIXo
    @RequiresApi(28)
    public static final Bitmap decodeBitmap(@OXOo.OOXIXo ImageDecoder.Source source, @OXOo.OOXIXo final Oox.IXxxXO<? super ImageDecoder, ? super ImageDecoder.ImageInfo, ? super ImageDecoder.Source, oXIO0o0XI> iXxxXO) {
        Bitmap decodeBitmap;
        decodeBitmap = ImageDecoder.decodeBitmap(source, IIXOooo.oIX0oI(new ImageDecoder.OnHeaderDecodedListener() { // from class: androidx.core.graphics.ImageDecoderKt$decodeBitmap$1
            @Override // android.graphics.ImageDecoder.OnHeaderDecodedListener
            public final void onHeaderDecoded(@OXOo.OOXIXo ImageDecoder imageDecoder, @OXOo.OOXIXo ImageDecoder.ImageInfo imageInfo, @OXOo.OOXIXo ImageDecoder.Source source2) {
                iXxxXO.invoke(imageDecoder, imageInfo, source2);
            }
        }));
        return decodeBitmap;
    }

    @OXOo.OOXIXo
    @RequiresApi(28)
    public static final Drawable decodeDrawable(@OXOo.OOXIXo ImageDecoder.Source source, @OXOo.OOXIXo final Oox.IXxxXO<? super ImageDecoder, ? super ImageDecoder.ImageInfo, ? super ImageDecoder.Source, oXIO0o0XI> iXxxXO) {
        Drawable decodeDrawable;
        decodeDrawable = ImageDecoder.decodeDrawable(source, IIXOooo.oIX0oI(new ImageDecoder.OnHeaderDecodedListener() { // from class: androidx.core.graphics.ImageDecoderKt$decodeDrawable$1
            @Override // android.graphics.ImageDecoder.OnHeaderDecodedListener
            public final void onHeaderDecoded(@OXOo.OOXIXo ImageDecoder imageDecoder, @OXOo.OOXIXo ImageDecoder.ImageInfo imageInfo, @OXOo.OOXIXo ImageDecoder.Source source2) {
                iXxxXO.invoke(imageDecoder, imageInfo, source2);
            }
        }));
        return decodeDrawable;
    }
}
