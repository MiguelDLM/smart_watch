package com.airbnb.lottie.model.layer;

import IXxxXO.II0xO0;
import Oo.X0o0xo;
import Oo.oO;
import Oo.ooOOo0oXI;
import Oo.x0XOIxOo;
import androidx.annotation.Nullable;
import com.airbnb.lottie.Oxx0IOOO;
import com.airbnb.lottie.model.content.Mask;
import java.util.List;
import java.util.Locale;
import xoXoI.oIX0oI;

public class Layer {

    /* renamed from: I0Io  reason: collision with root package name */
    public final String f903I0Io;

    /* renamed from: II0XooXoX  reason: collision with root package name */
    public final List<Mask> f904II0XooXoX;

    /* renamed from: II0xO0  reason: collision with root package name */
    public final Oxx0IOOO f905II0xO0;

    /* renamed from: IIXOooo  reason: collision with root package name */
    public final boolean f906IIXOooo;
    @Nullable

    /* renamed from: IXxxXO  reason: collision with root package name */
    public final x0XOIxOo f907IXxxXO;

    /* renamed from: OOXIXo  reason: collision with root package name */
    public final int f908OOXIXo;
    @Nullable

    /* renamed from: Oo  reason: collision with root package name */
    public final ooOOo0oXI f909Oo;
    @Nullable

    /* renamed from: Oxx0IOOO  reason: collision with root package name */
    public final String f910Oxx0IOOO;
    @Nullable

    /* renamed from: Oxx0xo  reason: collision with root package name */
    public final X0o0xo f911Oxx0xo;

    /* renamed from: OxxIIOOXO  reason: collision with root package name */
    public final MatteType f912OxxIIOOXO;

    /* renamed from: X0o0xo  reason: collision with root package name */
    public final LayerType f913X0o0xo;

    /* renamed from: XO  reason: collision with root package name */
    public final long f914XO;

    /* renamed from: oI0IIXIo  reason: collision with root package name */
    public final List<oIX0oI<Float>> f915oI0IIXIo;

    /* renamed from: oIX0oI  reason: collision with root package name */
    public final List<II0xO0> f916oIX0oI;

    /* renamed from: oO  reason: collision with root package name */
    public final int f917oO;

    /* renamed from: oOoXoXO  reason: collision with root package name */
    public final int f918oOoXoXO;

    /* renamed from: ooOOo0oXI  reason: collision with root package name */
    public final float f919ooOOo0oXI;

    /* renamed from: oxoX  reason: collision with root package name */
    public final long f920oxoX;

    /* renamed from: x0XOIxOo  reason: collision with root package name */
    public final float f921x0XOIxOo;

    /* renamed from: x0xO0oo  reason: collision with root package name */
    public final int f922x0xO0oo;

    /* renamed from: xoIox  reason: collision with root package name */
    public final int f923xoIox;

    /* renamed from: xxIXOIIO  reason: collision with root package name */
    public final oO f924xxIXOIIO;

    public enum LayerType {
        PRE_COMP,
        SOLID,
        IMAGE,
        NULL,
        SHAPE,
        TEXT,
        UNKNOWN
    }

    public enum MatteType {
        NONE,
        ADD,
        INVERT,
        LUMA,
        LUMA_INVERTED,
        UNKNOWN
    }

    public Layer(List<II0xO0> list, Oxx0IOOO oxx0IOOO, String str, long j, LayerType layerType, long j2, @Nullable String str2, List<Mask> list2, oO oOVar, int i, int i2, int i3, float f, float f2, int i4, int i5, @Nullable ooOOo0oXI ooooo0oxi, @Nullable x0XOIxOo x0xoixoo, List<oIX0oI<Float>> list3, MatteType matteType, @Nullable X0o0xo x0o0xo, boolean z) {
        this.f916oIX0oI = list;
        this.f905II0xO0 = oxx0IOOO;
        this.f903I0Io = str;
        this.f920oxoX = j;
        this.f913X0o0xo = layerType;
        this.f914XO = j2;
        this.f910Oxx0IOOO = str2;
        this.f904II0XooXoX = list2;
        this.f924xxIXOIIO = oOVar;
        this.f923xoIox = i;
        this.f908OOXIXo = i2;
        this.f918oOoXoXO = i3;
        this.f919ooOOo0oXI = f;
        this.f921x0XOIxOo = f2;
        this.f917oO = i4;
        this.f922x0xO0oo = i5;
        this.f909Oo = ooooo0oxi;
        this.f907IXxxXO = x0xoixoo;
        this.f915oI0IIXIo = list3;
        this.f912OxxIIOOXO = matteType;
        this.f911Oxx0xo = x0o0xo;
        this.f906IIXOooo = z;
    }

    public List<oIX0oI<Float>> I0Io() {
        return this.f915oI0IIXIo;
    }

    public long II0XooXoX() {
        return this.f914XO;
    }

    public long II0xO0() {
        return this.f920oxoX;
    }

    public boolean IIXOooo() {
        return this.f906IIXOooo;
    }

    @Nullable
    public x0XOIxOo IXxxXO() {
        return this.f907IXxxXO;
    }

    @Nullable
    public String OOXIXo() {
        return this.f910Oxx0IOOO;
    }

    @Nullable
    public ooOOo0oXI Oo() {
        return this.f909Oo;
    }

    public String Oxx0IOOO() {
        return this.f903I0Io;
    }

    @Nullable
    public X0o0xo Oxx0xo() {
        return this.f911Oxx0xo;
    }

    public oO OxxIIOOXO() {
        return this.f924xxIXOIIO;
    }

    public List<Mask> X0o0xo() {
        return this.f904II0XooXoX;
    }

    public MatteType XO() {
        return this.f912OxxIIOOXO;
    }

    public float oI0IIXIo() {
        return this.f919ooOOo0oXI;
    }

    public Oxx0IOOO oIX0oI() {
        return this.f905II0xO0;
    }

    public int oO() {
        return this.f923xoIox;
    }

    public List<II0xO0> oOoXoXO() {
        return this.f916oIX0oI;
    }

    public int ooOOo0oXI() {
        return this.f918oOoXoXO;
    }

    public LayerType oxoX() {
        return this.f913X0o0xo;
    }

    public String toString() {
        return xoXoI("");
    }

    public int x0XOIxOo() {
        return this.f908OOXIXo;
    }

    public float x0xO0oo() {
        return this.f921x0XOIxOo / this.f905II0xO0.X0o0xo();
    }

    public int xoIox() {
        return this.f917oO;
    }

    public String xoXoI(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(Oxx0IOOO());
        sb.append("\n");
        Layer IIXOooo2 = this.f905II0xO0.IIXOooo(II0XooXoX());
        if (IIXOooo2 != null) {
            sb.append("\t\tParents: ");
            sb.append(IIXOooo2.Oxx0IOOO());
            Layer IIXOooo3 = this.f905II0xO0.IIXOooo(IIXOooo2.II0XooXoX());
            while (IIXOooo3 != null) {
                sb.append("->");
                sb.append(IIXOooo3.Oxx0IOOO());
                IIXOooo3 = this.f905II0xO0.IIXOooo(IIXOooo3.II0XooXoX());
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
        if (!(oO() == 0 || x0XOIxOo() == 0)) {
            sb.append(str);
            sb.append("\tBackground: ");
            sb.append(String.format(Locale.US, "%dx%d %X\n", new Object[]{Integer.valueOf(oO()), Integer.valueOf(x0XOIxOo()), Integer.valueOf(ooOOo0oXI())}));
        }
        if (!this.f916oIX0oI.isEmpty()) {
            sb.append(str);
            sb.append("\tShapes:\n");
            for (II0xO0 next : this.f916oIX0oI) {
                sb.append(str);
                sb.append("\t\t");
                sb.append(next);
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public int xxIXOIIO() {
        return this.f922x0xO0oo;
    }
}
