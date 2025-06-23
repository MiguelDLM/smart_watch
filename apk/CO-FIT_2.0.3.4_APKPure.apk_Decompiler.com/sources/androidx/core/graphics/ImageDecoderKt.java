package androidx.core.graphics;

import OXOo.OOXIXo;
import Oox.IXxxXO;
import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.graphics.drawable.Drawable;
import androidx.annotation.RequiresApi;
import kotlin.oXIO0o0XI;

@SuppressLint({"ClassVerificationFailure"})
public final class ImageDecoderKt {
    @RequiresApi(28)
    @OOXIXo
    public static final Bitmap decodeBitmap(@OOXIXo ImageDecoder.Source source, @OOXIXo IXxxXO<? super ImageDecoder, ? super ImageDecoder.ImageInfo, ? super ImageDecoder.Source, oXIO0o0XI> iXxxXO) {
        return ImageDecoder.decodeBitmap(source, IIXOooo.oIX0oI(new ImageDecoderKt$decodeBitmap$1(iXxxXO)));
    }

    @RequiresApi(28)
    @OOXIXo
    public static final Drawable decodeDrawable(@OOXIXo ImageDecoder.Source source, @OOXIXo IXxxXO<? super ImageDecoder, ? super ImageDecoder.ImageInfo, ? super ImageDecoder.Source, oXIO0o0XI> iXxxXO) {
        return ImageDecoder.decodeDrawable(source, IIXOooo.oIX0oI(new ImageDecoderKt$decodeDrawable$1(iXxxXO)));
    }
}
