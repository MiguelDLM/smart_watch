package ooOOo0oXI;

import android.graphics.Path;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.List;
import x0XOIxOo.oIX0oI;

/* loaded from: classes.dex */
public class Oxx0xo implements x0XOIxOo, oIX0oI.II0xO0 {

    /* renamed from: I0Io, reason: collision with root package name */
    public final boolean f32347I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public final String f32348II0xO0;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public final x0XOIxOo.oIX0oI<?, Path> f32350X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public boolean f32351XO;

    /* renamed from: oxoX, reason: collision with root package name */
    public final com.airbnb.lottie.xoIox f32353oxoX;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final Path f32352oIX0oI = new Path();

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public II0xO0 f32349Oxx0IOOO = new II0xO0();

    public Oxx0xo(com.airbnb.lottie.xoIox xoiox, com.airbnb.lottie.model.layer.oIX0oI oix0oi, IXxxXO.xoIox xoiox2) {
        this.f32348II0xO0 = xoiox2.II0xO0();
        this.f32347I0Io = xoiox2.oxoX();
        this.f32353oxoX = xoiox;
        x0XOIxOo.oIX0oI<IXxxXO.Oxx0IOOO, Path> oIX0oI2 = xoiox2.I0Io().oIX0oI();
        this.f32350X0o0xo = oIX0oI2;
        oix0oi.xxIXOIIO(oIX0oI2);
        oIX0oI2.oIX0oI(this);
    }

    private void II0xO0() {
        this.f32351XO = false;
        this.f32353oxoX.invalidateSelf();
    }

    @Override // ooOOo0oXI.I0Io
    public void X0o0xo(List<I0Io> list, List<I0Io> list2) {
        for (int i = 0; i < list.size(); i++) {
            I0Io i0Io = list.get(i);
            if (i0Io instanceof OxxIIOOXO) {
                OxxIIOOXO oxxIIOOXO = (OxxIIOOXO) i0Io;
                if (oxxIIOOXO.xxIXOIIO() == ShapeTrimPath.Type.SIMULTANEOUSLY) {
                    this.f32349Oxx0IOOO.oIX0oI(oxxIIOOXO);
                    oxxIIOOXO.II0xO0(this);
                }
            }
        }
    }

    @Override // ooOOo0oXI.I0Io
    public String getName() {
        return this.f32348II0xO0;
    }

    @Override // ooOOo0oXI.x0XOIxOo
    public Path getPath() {
        if (this.f32351XO) {
            return this.f32352oIX0oI;
        }
        this.f32352oIX0oI.reset();
        if (this.f32347I0Io) {
            this.f32351XO = true;
            return this.f32352oIX0oI;
        }
        this.f32352oIX0oI.set(this.f32350X0o0xo.II0XooXoX());
        this.f32352oIX0oI.setFillType(Path.FillType.EVEN_ODD);
        this.f32349Oxx0IOOO.II0xO0(this.f32352oIX0oI);
        this.f32351XO = true;
        return this.f32352oIX0oI;
    }

    @Override // x0XOIxOo.oIX0oI.II0xO0
    public void oxoX() {
        II0xO0();
    }
}
