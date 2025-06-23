package xxx00;

import OXOo.OOXIXo;
import XIXIX.Oxx0IOOO;
import XIXIX.oOoXoXO;
import XIXIX.xxIXOIIO;
import android.graphics.Canvas;
import com.github.mikephil.charting.components.XAxis;
import java.util.List;
import kotlin.jvm.internal.IIX0o;
import kotlin.text.StringsKt__StringsKt;
import xX0IIXIx0.IXxxXO;

/* loaded from: classes12.dex */
public final class oxoX extends IXxxXO {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public oxoX(@OOXIXo oOoXoXO viewPortHandler, @OOXIXo XAxis xAxis, @OOXIXo xxIXOIIO trans) {
        super(viewPortHandler, xAxis, trans);
        IIX0o.x0xO0oo(viewPortHandler, "viewPortHandler");
        IIX0o.x0xO0oo(xAxis, "xAxis");
        IIX0o.x0xO0oo(trans, "trans");
    }

    @Override // xX0IIXIx0.IXxxXO
    public void ooOOo0oXI(@OOXIXo Canvas c, @OOXIXo String formattedLabel, float f, float f2, @OOXIXo Oxx0IOOO anchor, float f3) {
        IIX0o.x0xO0oo(c, "c");
        IIX0o.x0xO0oo(formattedLabel, "formattedLabel");
        IIX0o.x0xO0oo(anchor, "anchor");
        List XXoO0oX2 = StringsKt__StringsKt.XXoO0oX(formattedLabel, new String[]{"\n"}, false, 0, 6, null);
        int size = XXoO0oX2.size();
        for (int i = 0; i < size; i++) {
            XIXIX.OOXIXo.x0XOIxOo(c, (String) XXoO0oX2.get(i), f, f2 + (i * this.f34560X0o0xo.getTextSize()), this.f34560X0o0xo, anchor, f3);
        }
    }
}
