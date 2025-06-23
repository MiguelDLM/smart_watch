package Oxx0xo;

import IXxxXO.xxIXOIIO;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.model.layer.oIX0oI;
import com.airbnb.lottie.xoIox;
import java.util.Collections;
import java.util.List;
import ooOOo0oXI.oxoX;

public class I0Io extends oIX0oI {

    /* renamed from: xxX  reason: collision with root package name */
    public final oxoX f140xxX;

    public I0Io(xoIox xoiox, Layer layer) {
        super(xoiox, layer);
        oxoX oxox = new oxoX(xoiox, this, new xxIXOIIO("__container", layer.oOoXoXO(), false));
        this.f140xxX = oxox;
        oxox.X0o0xo(Collections.emptyList(), Collections.emptyList());
    }

    public void oI0IIXIo(@NonNull Canvas canvas, Matrix matrix, int i) {
        this.f140xxX.I0Io(canvas, matrix, i);
    }

    public void oIX0oI(RectF rectF, Matrix matrix, boolean z) {
        super.oIX0oI(rectF, matrix, z);
        this.f140xxX.oIX0oI(rectF, this.f947ooOOo0oXI, z);
    }

    public void xxX(x0xO0oo.oxoX oxox, int i, List<x0xO0oo.oxoX> list, x0xO0oo.oxoX oxox2) {
        this.f140xxX.Oxx0IOOO(oxox, i, list, oxox2);
    }
}
