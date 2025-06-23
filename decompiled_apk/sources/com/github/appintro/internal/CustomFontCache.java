package com.github.appintro.internal;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.content.Context;
import android.graphics.Typeface;
import androidx.core.content.res.ResourcesCompat;
import java.util.HashMap;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IO;
import kotlin.oXIO0o0XI;

/* loaded from: classes9.dex */
public final class CustomFontCache {

    @OOXIXo
    public static final CustomFontCache INSTANCE = new CustomFontCache();

    @OOXIXo
    private static final String TAG = LogHelper.INSTANCE.makeLogTag(IO.oxoX(CustomFontCache.class));

    @OOXIXo
    private static final HashMap<String, Typeface> cache = new HashMap<>();

    private CustomFontCache() {
    }

    public final void getFont(@OOXIXo Context ctx, @oOoXoXO String str, @OOXIXo ResourcesCompat.FontCallback fontCallback) {
        IIX0o.x0xO0oo(ctx, "ctx");
        IIX0o.x0xO0oo(fontCallback, "fontCallback");
        oXIO0o0XI oxio0o0xi = null;
        if (str != null && str.length() != 0) {
            HashMap<String, Typeface> hashMap = cache;
            Typeface typeface = hashMap.get(str);
            if (typeface != null) {
                fontCallback.lambda$callbackSuccessAsync$0(typeface);
                oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
            }
            if (oxio0o0xi == null) {
                Typeface newTypeface = Typeface.createFromAsset(ctx.getAssets(), str);
                IIX0o.oO(newTypeface, "newTypeface");
                hashMap.put(str, newTypeface);
                fontCallback.lambda$callbackSuccessAsync$0(newTypeface);
                return;
            }
            return;
        }
        LogHelper.w$default(TAG, "Empty typeface path provided!", null, 4, null);
    }
}
