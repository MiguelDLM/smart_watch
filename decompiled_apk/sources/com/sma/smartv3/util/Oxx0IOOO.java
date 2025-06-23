package com.sma.smartv3.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;
import androidx.core.widget.NestedScrollView;
import com.blankj.utilcode.util.ImageUtils;
import com.blankj.utilcode.util.IntentUtils;

/* loaded from: classes12.dex */
public final class Oxx0IOOO {

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final Oxx0IOOO f24316oIX0oI = new Oxx0IOOO();

    @OXOo.OOXIXo
    public final Bitmap I0Io(@OXOo.OOXIXo NestedScrollView scrollView) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(scrollView, "scrollView");
        int childCount = scrollView.getChildCount();
        int i = 0;
        for (int i2 = 0; i2 < childCount; i2++) {
            i += scrollView.getChildAt(i2).getHeight();
        }
        return oIX0oI(scrollView, i);
    }

    @OXOo.OOXIXo
    public final Bitmap II0xO0(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        return oIX0oI(view, view.getHeight());
    }

    public final Bitmap oIX0oI(View view, int i) {
        Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), i, Bitmap.Config.ARGB_8888);
        view.draw(new Canvas(createBitmap));
        return createBitmap;
    }

    public final void oxoX(@OXOo.OOXIXo Context context, @OXOo.OOXIXo Bitmap finalBitmap) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(context, "context");
        kotlin.jvm.internal.IIX0o.x0xO0oo(finalBitmap, "finalBitmap");
        X00IoxXI.oIX0oI oix0oi = X00IoxXI.oIX0oI.f3233oIX0oI;
        ImageUtils.save(finalBitmap, com.sma.smartv3.initializer.IXxxXO.oxXx0IX(oix0oi), Bitmap.CompressFormat.JPEG);
        context.startActivity(IntentUtils.getShareImageIntent(com.sma.smartv3.initializer.IXxxXO.oxXx0IX(oix0oi)));
    }
}
