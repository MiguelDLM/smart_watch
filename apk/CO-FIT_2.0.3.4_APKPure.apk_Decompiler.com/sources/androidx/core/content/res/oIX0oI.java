package androidx.core.content.res;

import android.graphics.Typeface;
import androidx.core.content.res.ResourcesCompat;

public final /* synthetic */ class oIX0oI implements Runnable {

    /* renamed from: Oo  reason: collision with root package name */
    public final /* synthetic */ Typeface f308Oo;

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ ResourcesCompat.FontCallback f309XO;

    public /* synthetic */ oIX0oI(ResourcesCompat.FontCallback fontCallback, Typeface typeface) {
        this.f309XO = fontCallback;
        this.f308Oo = typeface;
    }

    public final void run() {
        this.f309XO.lambda$callbackSuccessAsync$0(this.f308Oo);
    }
}
