package xX0IIXIx0;

import android.graphics.Canvas;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.components.XAxis;

/* loaded from: classes9.dex */
public class oI0IIXIo extends IXxxXO {

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public RadarChart f34556x0xO0oo;

    public oI0IIXIo(XIXIX.oOoXoXO oooxoxo, XAxis xAxis, RadarChart radarChart) {
        super(oooxoxo, xAxis, null);
        this.f34556x0xO0oo = radarChart;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // xX0IIXIx0.IXxxXO, xX0IIXIx0.oIX0oI
    public void Oxx0IOOO(Canvas canvas) {
        if (this.f34521II0XooXoX.XO() && this.f34521II0XooXoX.IO()) {
            float O00XxXI2 = this.f34521II0XooXoX.O00XxXI();
            XIXIX.Oxx0IOOO I0Io2 = XIXIX.Oxx0IOOO.I0Io(0.5f, 0.25f);
            this.f34560X0o0xo.setTypeface(this.f34521II0XooXoX.I0Io());
            this.f34560X0o0xo.setTextSize(this.f34521II0XooXoX.II0xO0());
            this.f34560X0o0xo.setColor(this.f34521II0XooXoX.oIX0oI());
            float sliceAngle = this.f34556x0xO0oo.getSliceAngle();
            float factor = this.f34556x0xO0oo.getFactor();
            XIXIX.Oxx0IOOO centerOffsets = this.f34556x0xO0oo.getCenterOffsets();
            XIXIX.Oxx0IOOO I0Io3 = XIXIX.Oxx0IOOO.I0Io(0.0f, 0.0f);
            for (int i = 0; i < ((o0xxxXXxX.IXxxXO) this.f34556x0xO0oo.getData()).xoXoI().X0xxXX0(); i++) {
                float f = i;
                String I0Io4 = this.f34521II0XooXoX.ooXIXxIX().I0Io(f, this.f34521II0XooXoX);
                XIXIX.OOXIXo.XI0IXoo(centerOffsets, (this.f34556x0xO0oo.getYRange() * factor) + (this.f34521II0XooXoX.f15974IoOoX / 2.0f), ((f * sliceAngle) + this.f34556x0xO0oo.getRotationAngle()) % 360.0f, I0Io3);
                ooOOo0oXI(canvas, I0Io4, I0Io3.f3771IXxxXO, I0Io3.f3772Oxx0xo - (this.f34521II0XooXoX.f15977oOXoIIIo / 2.0f), I0Io2, O00XxXI2);
            }
            XIXIX.Oxx0IOOO.II0XooXoX(centerOffsets);
            XIXIX.Oxx0IOOO.II0XooXoX(I0Io3);
            XIXIX.Oxx0IOOO.II0XooXoX(I0Io2);
        }
    }

    @Override // xX0IIXIx0.IXxxXO, xX0IIXIx0.oIX0oI
    public void xoIox(Canvas canvas) {
    }
}
