package androidx.core.provider;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import androidx.core.provider.FontProvider;

/* loaded from: classes.dex */
public final /* synthetic */ class II0xO0 {
    public static FontProvider.ContentQueryWrapper oIX0oI(Context context, Uri uri) {
        if (Build.VERSION.SDK_INT < 24) {
            return new FontProvider.ContentQueryWrapperApi16Impl(context, uri);
        }
        return new FontProvider.ContentQueryWrapperApi24Impl(context, uri);
    }
}
