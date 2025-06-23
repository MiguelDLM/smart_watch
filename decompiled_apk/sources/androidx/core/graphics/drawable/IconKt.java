package androidx.core.graphics.drawable;

import OXOo.OOXIXo;
import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.net.Uri;
import androidx.annotation.RequiresApi;

@SuppressLint({"ClassVerificationFailure"})
/* loaded from: classes.dex */
public final class IconKt {
    @OOXIXo
    @RequiresApi(26)
    public static final Icon toAdaptiveIcon(@OOXIXo Bitmap bitmap) {
        Icon createWithAdaptiveBitmap;
        createWithAdaptiveBitmap = Icon.createWithAdaptiveBitmap(bitmap);
        return createWithAdaptiveBitmap;
    }

    @OOXIXo
    @RequiresApi(26)
    public static final Icon toIcon(@OOXIXo Bitmap bitmap) {
        Icon createWithBitmap;
        createWithBitmap = Icon.createWithBitmap(bitmap);
        return createWithBitmap;
    }

    @OOXIXo
    @RequiresApi(26)
    public static final Icon toIcon(@OOXIXo Uri uri) {
        Icon createWithContentUri;
        createWithContentUri = Icon.createWithContentUri(uri);
        return createWithContentUri;
    }

    @OOXIXo
    @RequiresApi(26)
    public static final Icon toIcon(@OOXIXo byte[] bArr) {
        Icon createWithData;
        createWithData = Icon.createWithData(bArr, 0, bArr.length);
        return createWithData;
    }
}
