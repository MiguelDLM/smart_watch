package Oxx0xo;

import IXxxXO.xxIXOIIO;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.xoIox;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class I0Io extends com.airbnb.lottie.model.layer.oIX0oI {

    /* renamed from: xxX, reason: collision with root package name */
    public final ooOOo0oXI.oxoX f3037xxX;

    public I0Io(xoIox xoiox, Layer layer) {
        super(xoiox, layer);
        ooOOo0oXI.oxoX oxox = new ooOOo0oXI.oxoX(xoiox, this, new xxIXOIIO("__container", layer.oOoXoXO(), false));
        this.f3037xxX = oxox;
        oxox.X0o0xo(Collections.emptyList(), Collections.emptyList());
    }

    @Override // com.airbnb.lottie.model.layer.oIX0oI
    public void oI0IIXIo(@NonNull Canvas canvas, Matrix matrix, int i) {
        this.f3037xxX.I0Io(canvas, matrix, i);
    }

    @Override // com.airbnb.lottie.model.layer.oIX0oI, ooOOo0oXI.X0o0xo
    public void oIX0oI(RectF rectF, Matrix matrix, boolean z) {
        super.oIX0oI(rectF, matrix, z);
        this.f3037xxX.oIX0oI(rectF, this.f4941ooOOo0oXI, z);
    }

    @Override // com.airbnb.lottie.model.layer.oIX0oI
    public void xxX(x0xO0oo.oxoX oxox, int i, List<x0xO0oo.oxoX> list, x0xO0oo.oxoX oxox2) {
        this.f3037xxX.Oxx0IOOO(oxox, i, list, oxox2);
    }
}
