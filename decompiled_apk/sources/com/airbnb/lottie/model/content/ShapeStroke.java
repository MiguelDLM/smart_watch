package com.airbnb.lottie.model.content;

import IXxxXO.II0xO0;
import Oo.Oxx0IOOO;
import Oo.X0o0xo;
import Oo.oxoX;
import android.graphics.Paint;
import androidx.annotation.Nullable;
import com.airbnb.lottie.xoIox;
import java.util.List;
import ooOOo0oXI.I0Io;
import ooOOo0oXI.oI0IIXIo;

/* loaded from: classes.dex */
public class ShapeStroke implements II0xO0 {

    /* renamed from: I0Io, reason: collision with root package name */
    public final List<X0o0xo> f4858I0Io;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public final LineJoinType f4859II0XooXoX;

    /* renamed from: II0xO0, reason: collision with root package name */
    @Nullable
    public final X0o0xo f4860II0xO0;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public final LineCapType f4861Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public final Oxx0IOOO f4862X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public final X0o0xo f4863XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final String f4864oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public final oxoX f4865oxoX;

    /* renamed from: xoIox, reason: collision with root package name */
    public final boolean f4866xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public final float f4867xxIXOIIO;

    /* loaded from: classes.dex */
    public enum LineCapType {
        BUTT,
        ROUND,
        UNKNOWN;

        public Paint.Cap toPaintCap() {
            int i = oIX0oI.f4869oIX0oI[ordinal()];
            if (i != 1) {
                if (i != 2) {
                    return Paint.Cap.SQUARE;
                }
                return Paint.Cap.ROUND;
            }
            return Paint.Cap.BUTT;
        }
    }

    /* loaded from: classes.dex */
    public enum LineJoinType {
        MITER,
        ROUND,
        BEVEL;

        public Paint.Join toPaintJoin() {
            int i = oIX0oI.f4868II0xO0[ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return null;
                    }
                    return Paint.Join.ROUND;
                }
                return Paint.Join.MITER;
            }
            return Paint.Join.BEVEL;
        }
    }

    /* loaded from: classes.dex */
    public static /* synthetic */ class oIX0oI {

        /* renamed from: II0xO0, reason: collision with root package name */
        public static final /* synthetic */ int[] f4868II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public static final /* synthetic */ int[] f4869oIX0oI;

        static {
            int[] iArr = new int[LineJoinType.values().length];
            f4868II0xO0 = iArr;
            try {
                iArr[LineJoinType.BEVEL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4868II0xO0[LineJoinType.MITER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4868II0xO0[LineJoinType.ROUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[LineCapType.values().length];
            f4869oIX0oI = iArr2;
            try {
                iArr2[LineCapType.BUTT.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f4869oIX0oI[LineCapType.ROUND.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f4869oIX0oI[LineCapType.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public ShapeStroke(String str, @Nullable X0o0xo x0o0xo, List<X0o0xo> list, oxoX oxox, Oxx0IOOO oxx0IOOO, X0o0xo x0o0xo2, LineCapType lineCapType, LineJoinType lineJoinType, float f, boolean z) {
        this.f4864oIX0oI = str;
        this.f4860II0xO0 = x0o0xo;
        this.f4858I0Io = list;
        this.f4865oxoX = oxox;
        this.f4862X0o0xo = oxx0IOOO;
        this.f4863XO = x0o0xo2;
        this.f4861Oxx0IOOO = lineCapType;
        this.f4859II0XooXoX = lineJoinType;
        this.f4867xxIXOIIO = f;
        this.f4866xoIox = z;
    }

    public oxoX I0Io() {
        return this.f4865oxoX;
    }

    public String II0XooXoX() {
        return this.f4864oIX0oI;
    }

    public LineCapType II0xO0() {
        return this.f4861Oxx0IOOO;
    }

    public boolean OOXIXo() {
        return this.f4866xoIox;
    }

    public float Oxx0IOOO() {
        return this.f4867xxIXOIIO;
    }

    public LineJoinType X0o0xo() {
        return this.f4859II0XooXoX;
    }

    public List<X0o0xo> XO() {
        return this.f4858I0Io;
    }

    @Override // IXxxXO.II0xO0
    public I0Io oIX0oI(xoIox xoiox, com.airbnb.lottie.model.layer.oIX0oI oix0oi) {
        return new oI0IIXIo(xoiox, oix0oi, this);
    }

    public X0o0xo oxoX() {
        return this.f4860II0xO0;
    }

    public X0o0xo xoIox() {
        return this.f4863XO;
    }

    public Oxx0IOOO xxIXOIIO() {
        return this.f4862X0o0xo;
    }
}
