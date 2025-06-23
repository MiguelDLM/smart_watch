package androidx.core.graphics;

import OXOo.OOXIXo;
import Oox.IXxxXO;
import android.graphics.ImageDecoder;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nImageDecoder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ImageDecoder.kt\nandroidx/core/graphics/ImageDecoderKt$decodeDrawable$1\n*L\n1#1,56:1\n*E\n"})
public final class ImageDecoderKt$decodeDrawable$1 implements ImageDecoder.OnHeaderDecodedListener {
    final /* synthetic */ IXxxXO<ImageDecoder, ImageDecoder.ImageInfo, ImageDecoder.Source, oXIO0o0XI> $action;

    public ImageDecoderKt$decodeDrawable$1(IXxxXO<? super ImageDecoder, ? super ImageDecoder.ImageInfo, ? super ImageDecoder.Source, oXIO0o0XI> iXxxXO) {
        this.$action = iXxxXO;
    }

    public final void onHeaderDecoded(@OOXIXo ImageDecoder imageDecoder, @OOXIXo ImageDecoder.ImageInfo imageInfo, @OOXIXo ImageDecoder.Source source) {
        this.$action.invoke(imageDecoder, imageInfo, source);
    }
}
