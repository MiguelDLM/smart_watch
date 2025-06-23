package androidx.core.graphics.drawable;

import OXOo.OOXIXo;
import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.net.Uri;
import androidx.annotation.RequiresApi;

@SuppressLint({"ClassVerificationFailure"})
public final class IconKt {
    @RequiresApi(26)
    @OOXIXo
    public static final Icon toAdaptiveIcon(@OOXIXo Bitmap bitmap) {
        return Icon.createWithAdaptiveBitmap(bitmap);
    }

    @RequiresApi(26)
    @OOXIXo
    public static final Icon toIcon(@OOXIXo Bitmap bitmap) {
        return Icon.createWithBitmap(bitmap);
    }

    @RequiresApi(26)
    @OOXIXo
    public static final Icon toIcon(@OOXIXo Uri uri) {
        return Icon.createWithContentUri(uri);
    }

    @RequiresApi(26)
    @OOXIXo
    public static final Icon toIcon(@OOXIXo byte[] bArr) {
        return Icon.createWithData(bArr, 0, bArr.length);
    }
}
