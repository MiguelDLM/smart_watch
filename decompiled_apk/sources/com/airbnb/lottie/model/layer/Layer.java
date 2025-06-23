package com.airbnb.lottie.model.layer;

import Oo.X0o0xo;
import Oo.oO;
import Oo.ooOOo0oXI;
import Oo.x0XOIxOo;
import androidx.annotation.Nullable;
import com.airbnb.lottie.Oxx0IOOO;
import com.airbnb.lottie.model.content.Mask;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public class Layer {

    /* renamed from: I0Io, reason: collision with root package name */
    public final String f4897I0Io;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public final List<Mask> f4898II0XooXoX;

    /* renamed from: II0xO0, reason: collision with root package name */
    public final Oxx0IOOO f4899II0xO0;

    /* renamed from: IIXOooo, reason: collision with root package name */
    public final boolean f4900IIXOooo;

    /* renamed from: IXxxXO, reason: collision with root package name */
    @Nullable
    public final x0XOIxOo f4901IXxxXO;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public final int f4902OOXIXo;

    /* renamed from: Oo, reason: collision with root package name */
    @Nullable
    public final ooOOo0oXI f4903Oo;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    @Nullable
    public final String f4904Oxx0IOOO;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    @Nullable
    public final X0o0xo f4905Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public final MatteType f4906OxxIIOOXO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public final LayerType f4907X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public final long f4908XO;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public final List<xoXoI.oIX0oI<Float>> f4909oI0IIXIo;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final List<IXxxXO.II0xO0> f4910oIX0oI;

    /* renamed from: oO, reason: collision with root package name */
    public final int f4911oO;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public final int f4912oOoXoXO;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public final float f4913ooOOo0oXI;

    /* renamed from: oxoX, reason: collision with root package name */
    public final long f4914oxoX;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public final float f4915x0XOIxOo;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public final int f4916x0xO0oo;

    /* renamed from: xoIox, reason: collision with root package name */
    public final int f4917xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public final oO f4918xxIXOIIO;

    /* loaded from: classes.dex */
    public enum LayerType {
        PRE_COMP,
        SOLID,
        IMAGE,
        NULL,
        SHAPE,
        TEXT,
        UNKNOWN
    }

    /* loaded from: classes.dex */
    public enum MatteType {
        NONE,
        ADD,
        INVERT,
        LUMA,
        LUMA_INVERTED,
        UNKNOWN
    }

    public Layer(List<IXxxXO.II0xO0> list, Oxx0IOOO oxx0IOOO, String str, long j, LayerType layerType, long j2, @Nullable String str2, List<Mask> list2, oO oOVar, int i, int i2, int i3, float f, float f2, int i4, int i5, @Nullable ooOOo0oXI ooooo0oxi, @Nullable x0XOIxOo x0xoixoo, List<xoXoI.oIX0oI<Float>> list3, MatteType matteType, @Nullable X0o0xo x0o0xo, boolean z) {
        this.f4910oIX0oI = list;
        this.f4899II0xO0 = oxx0IOOO;
        this.f4897I0Io = str;
        this.f4914oxoX = j;
        this.f4907X0o0xo = layerType;
        this.f4908XO = j2;
        this.f4904Oxx0IOOO = str2;
        this.f4898II0XooXoX = list2;
        this.f4918xxIXOIIO = oOVar;
        this.f4917xoIox = i;
        this.f4902OOXIXo = i2;
        this.f4912oOoXoXO = i3;
        this.f4913ooOOo0oXI = f;
        this.f4915x0XOIxOo = f2;
        this.f4911oO = i4;
        this.f4916x0xO0oo = i5;
        this.f4903Oo = ooooo0oxi;
        this.f4901IXxxXO = x0xoixoo;
        this.f4909oI0IIXIo = list3;
        this.f4906OxxIIOOXO = matteType;
        this.f4905Oxx0xo = x0o0xo;
        this.f4900IIXOooo = z;
    }

    public List<xoXoI.oIX0oI<Float>> I0Io() {
        return this.f4909oI0IIXIo;
    }

    public long II0XooXoX() {
        return this.f4908XO;
    }

    public long II0xO0() {
        return this.f4914oxoX;
    }

    public boolean IIXOooo() {
        return this.f4900IIXOooo;
    }

    @Nullable
    public x0XOIxOo IXxxXO() {
        return this.f4901IXxxXO;
    }

    @Nullable
    public String OOXIXo() {
        return this.f4904Oxx0IOOO;
    }

    @Nullable
    public ooOOo0oXI Oo() {
        return this.f4903Oo;
    }

    public String Oxx0IOOO() {
        return this.f4897I0Io;
    }

    @Nullable
    public X0o0xo Oxx0xo() {
        return this.f4905Oxx0xo;
    }

    public oO OxxIIOOXO() {
        return this.f4918xxIXOIIO;
    }

    public List<Mask> X0o0xo() {
        return this.f4898II0XooXoX;
    }

    public MatteType XO() {
        return this.f4906OxxIIOOXO;
    }

    public float oI0IIXIo() {
        return this.f4913ooOOo0oXI;
    }

    public Oxx0IOOO oIX0oI() {
        return this.f4899II0xO0;
    }

    public int oO() {
        return this.f4917xoIox;
    }

    public List<IXxxXO.II0xO0> oOoXoXO() {
        return this.f4910oIX0oI;
    }

    public int ooOOo0oXI() {
        return this.f4912oOoXoXO;
    }

    public LayerType oxoX() {
        return this.f4907X0o0xo;
    }

    public String toString() {
        return xoXoI("");
    }

    public int x0XOIxOo() {
        return this.f4902OOXIXo;
    }

    public float x0xO0oo() {
        return this.f4915x0XOIxOo / this.f4899II0xO0.X0o0xo();
    }

    public int xoIox() {
        return this.f4911oO;
    }

    public String xoXoI(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(Oxx0IOOO());
        sb.append("\n");
        Layer IIXOooo2 = this.f4899II0xO0.IIXOooo(II0XooXoX());
        if (IIXOooo2 != null) {
            sb.append("\t\tParents: ");
            sb.append(IIXOooo2.Oxx0IOOO());
            Layer IIXOooo3 = this.f4899II0xO0.IIXOooo(IIXOooo2.II0XooXoX());
            while (IIXOooo3 != null) {
                sb.append("->");
                sb.append(IIXOooo3.Oxx0IOOO());
                IIXOooo3 = this.f4899II0xO0.IIXOooo(IIXOooo3.II0XooXoX());
            }
            sb.append(str);
            sb.append("\n");
        }
        if (!X0o0xo().isEmpty()) {
            sb.append(str);
            sb.append("\tMasks: ");
            sb.append(X0o0xo().size());
            sb.append("\n");
        }
        if (oO() != 0 && x0XOIxOo() != 0) {
            sb.append(str);
            sb.append("\tBackground: ");
            sb.append(String.format(Locale.US, "%dx%d %X\n", Integer.valueOf(oO()), Integer.valueOf(x0XOIxOo()), Integer.valueOf(ooOOo0oXI())));
        }
        if (!this.f4910oIX0oI.isEmpty()) {
            sb.append(str);
            sb.append("\tShapes:\n");
            for (IXxxXO.II0xO0 iI0xO0 : this.f4910oIX0oI) {
                sb.append(str);
                sb.append("\t\t");
                sb.append(iI0xO0);
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public int xxIXOIIO() {
        return this.f4916x0xO0oo;
    }
}
