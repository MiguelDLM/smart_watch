package androidx.core.os;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.x0XOIxOo;
import android.os.Bundle;
import android.util.Size;
import android.util.SizeF;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

@RequiresApi(21)
final class BundleApi21ImplKt {
    @OOXIXo
    public static final BundleApi21ImplKt INSTANCE = new BundleApi21ImplKt();

    private BundleApi21ImplKt() {
    }

    @DoNotInline
    @x0XOIxOo
    public static final void putSize(@OOXIXo Bundle bundle, @OOXIXo String str, @oOoXoXO Size size) {
        bundle.putSize(str, size);
    }

    @DoNotInline
    @x0XOIxOo
    public static final void putSizeF(@OOXIXo Bundle bundle, @OOXIXo String str, @oOoXoXO SizeF sizeF) {
        bundle.putSizeF(str, sizeF);
    }
}
