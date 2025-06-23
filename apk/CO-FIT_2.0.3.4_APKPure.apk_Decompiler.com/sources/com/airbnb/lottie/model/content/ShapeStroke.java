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

public class ShapeStroke implements II0xO0 {

    /* renamed from: I0Io  reason: collision with root package name */
    public final List<X0o0xo> f864I0Io;

    /* renamed from: II0XooXoX  reason: collision with root package name */
    public final LineJoinType f865II0XooXoX;
    @Nullable

    /* renamed from: II0xO0  reason: collision with root package name */
    public final X0o0xo f866II0xO0;

    /* renamed from: Oxx0IOOO  reason: collision with root package name */
    public final LineCapType f867Oxx0IOOO;

    /* renamed from: X0o0xo  reason: collision with root package name */
    public final Oxx0IOOO f868X0o0xo;

    /* renamed from: XO  reason: collision with root package name */
    public final X0o0xo f869XO;

    /* renamed from: oIX0oI  reason: collision with root package name */
    public final String f870oIX0oI;

    /* renamed from: oxoX  reason: collision with root package name */
    public final oxoX f871oxoX;

    /* renamed from: xoIox  reason: collision with root package name */
    public final boolean f872xoIox;

    /* renamed from: xxIXOIIO  reason: collision with root package name */
    public final float f873xxIXOIIO;

    public enum LineCapType {
        BUTT,
        ROUND,
        UNKNOWN;

        public Paint.Cap toPaintCap() {
            int i = oIX0oI.f875oIX0oI[ordinal()];
            if (i == 1) {
                return Paint.Cap.BUTT;
            }
            if (i != 2) {
                return Paint.Cap.SQUARE;
            }
            return Paint.Cap.ROUND;
        }
    }

    public enum LineJoinType {
        MITER,
        ROUND,
        BEVEL;

        public Paint.Join toPaintJoin() {
            int i = oIX0oI.f874II0xO0[ordinal()];
            if (i == 1) {
                return Paint.Join.BEVEL;
            }
            if (i == 2) {
                return Paint.Join.MITER;
            }
            if (i != 3) {
                return null;
            }
            return Paint.Join.ROUND;
        }
    }

    public static /* synthetic */ class oIX0oI {

        /* renamed from: II0xO0  reason: collision with root package name */
        public static final /* synthetic */ int[] f874II0xO0;

        /* renamed from: oIX0oI  reason: collision with root package name */
        public static final /* synthetic */ int[] f875oIX0oI;

        /* JADX WARNING: Can't wrap try/catch for region: R(15:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|20) */
        /* JADX WARNING: Can't wrap try/catch for region: R(17:0|1|2|3|5|6|7|9|10|11|13|14|15|16|17|18|20) */
        /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0039 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0043 */
        static {
            /*
                com.airbnb.lottie.model.content.ShapeStroke$LineJoinType[] r0 = com.airbnb.lottie.model.content.ShapeStroke.LineJoinType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f874II0xO0 = r0
                r1 = 1
                com.airbnb.lottie.model.content.ShapeStroke$LineJoinType r2 = com.airbnb.lottie.model.content.ShapeStroke.LineJoinType.BEVEL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f874II0xO0     // Catch:{ NoSuchFieldError -> 0x001d }
                com.airbnb.lottie.model.content.ShapeStroke$LineJoinType r3 = com.airbnb.lottie.model.content.ShapeStroke.LineJoinType.MITER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f874II0xO0     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.airbnb.lottie.model.content.ShapeStroke$LineJoinType r4 = com.airbnb.lottie.model.content.ShapeStroke.LineJoinType.ROUND     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                com.airbnb.lottie.model.content.ShapeStroke$LineCapType[] r3 = com.airbnb.lottie.model.content.ShapeStroke.LineCapType.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                f875oIX0oI = r3
                com.airbnb.lottie.model.content.ShapeStroke$LineCapType r4 = com.airbnb.lottie.model.content.ShapeStroke.LineCapType.BUTT     // Catch:{ NoSuchFieldError -> 0x0039 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0039 }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0039 }
            L_0x0039:
                int[] r1 = f875oIX0oI     // Catch:{ NoSuchFieldError -> 0x0043 }
                com.airbnb.lottie.model.content.ShapeStroke$LineCapType r3 = com.airbnb.lottie.model.content.ShapeStroke.LineCapType.ROUND     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r1[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                int[] r0 = f875oIX0oI     // Catch:{ NoSuchFieldError -> 0x004d }
                com.airbnb.lottie.model.content.ShapeStroke$LineCapType r1 = com.airbnb.lottie.model.content.ShapeStroke.LineCapType.UNKNOWN     // Catch:{ NoSuchFieldError -> 0x004d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004d }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004d }
            L_0x004d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.model.content.ShapeStroke.oIX0oI.<clinit>():void");
        }
    }

    public ShapeStroke(String str, @Nullable X0o0xo x0o0xo, List<X0o0xo> list, oxoX oxox, Oxx0IOOO oxx0IOOO, X0o0xo x0o0xo2, LineCapType lineCapType, LineJoinType lineJoinType, float f, boolean z) {
        this.f870oIX0oI = str;
        this.f866II0xO0 = x0o0xo;
        this.f864I0Io = list;
        this.f871oxoX = oxox;
        this.f868X0o0xo = oxx0IOOO;
        this.f869XO = x0o0xo2;
        this.f867Oxx0IOOO = lineCapType;
        this.f865II0XooXoX = lineJoinType;
        this.f873xxIXOIIO = f;
        this.f872xoIox = z;
    }

    public oxoX I0Io() {
        return this.f871oxoX;
    }

    public String II0XooXoX() {
        return this.f870oIX0oI;
    }

    public LineCapType II0xO0() {
        return this.f867Oxx0IOOO;
    }

    public boolean OOXIXo() {
        return this.f872xoIox;
    }

    public float Oxx0IOOO() {
        return this.f873xxIXOIIO;
    }

    public LineJoinType X0o0xo() {
        return this.f865II0XooXoX;
    }

    public List<X0o0xo> XO() {
        return this.f864I0Io;
    }

    public I0Io oIX0oI(xoIox xoiox, com.airbnb.lottie.model.layer.oIX0oI oix0oi) {
        return new oI0IIXIo(xoiox, oix0oi, this);
    }

    public X0o0xo oxoX() {
        return this.f866II0xO0;
    }

    public X0o0xo xoIox() {
        return this.f869XO;
    }

    public Oxx0IOOO xxIXOIIO() {
        return this.f868X0o0xo;
    }
}
