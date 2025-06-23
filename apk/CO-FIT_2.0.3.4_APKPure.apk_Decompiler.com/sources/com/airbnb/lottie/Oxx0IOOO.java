package com.airbnb.lottie;

import IIXOooo.XO;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import androidx.annotation.RestrictTo;
import androidx.annotation.WorkerThread;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
import x0xO0oo.I0Io;

public class Oxx0IOOO {

    /* renamed from: I0Io  reason: collision with root package name */
    public Map<String, List<Layer>> f806I0Io;

    /* renamed from: II0XooXoX  reason: collision with root package name */
    public LongSparseArray<Layer> f807II0XooXoX;

    /* renamed from: II0xO0  reason: collision with root package name */
    public final HashSet<String> f808II0xO0 = new HashSet<>();

    /* renamed from: OOXIXo  reason: collision with root package name */
    public float f809OOXIXo;

    /* renamed from: Oxx0IOOO  reason: collision with root package name */
    public SparseArrayCompat<I0Io> f810Oxx0IOOO;

    /* renamed from: X0o0xo  reason: collision with root package name */
    public Map<String, x0xO0oo.II0xO0> f811X0o0xo;

    /* renamed from: XO  reason: collision with root package name */
    public List<x0xO0oo.Oxx0IOOO> f812XO;

    /* renamed from: oIX0oI  reason: collision with root package name */
    public final oI0IIXIo f813oIX0oI = new oI0IIXIo();

    /* renamed from: oO  reason: collision with root package name */
    public int f814oO = 0;

    /* renamed from: oOoXoXO  reason: collision with root package name */
    public float f815oOoXoXO;

    /* renamed from: ooOOo0oXI  reason: collision with root package name */
    public float f816ooOOo0oXI;

    /* renamed from: oxoX  reason: collision with root package name */
    public Map<String, OOXIXo> f817oxoX;

    /* renamed from: x0XOIxOo  reason: collision with root package name */
    public boolean f818x0XOIxOo;

    /* renamed from: xoIox  reason: collision with root package name */
    public Rect f819xoIox;

    /* renamed from: xxIXOIIO  reason: collision with root package name */
    public List<Layer> f820xxIXOIIO;

    @Deprecated
    public static class II0xO0 {

        public static final class oIX0oI implements oOoXoXO<Oxx0IOOO>, II0xO0 {

            /* renamed from: II0xO0  reason: collision with root package name */
            public boolean f821II0xO0;

            /* renamed from: oIX0oI  reason: collision with root package name */
            public final Oxx0xo f822oIX0oI;

            public void cancel() {
                this.f821II0xO0 = true;
            }

            /* renamed from: oIX0oI */
            public void onResult(Oxx0IOOO oxx0IOOO) {
                if (!this.f821II0xO0) {
                    this.f822oIX0oI.oIX0oI(oxx0IOOO);
                }
            }

            public oIX0oI(Oxx0xo oxx0xo) {
                this.f821II0xO0 = false;
                this.f822oIX0oI = oxx0xo;
            }
        }

        @Deprecated
        public static II0xO0 I0Io(InputStream inputStream, Oxx0xo oxx0xo) {
            oIX0oI oix0oi = new oIX0oI(oxx0xo);
            II0XooXoX.xoIox(inputStream, (String) null).XO(oix0oi);
            return oix0oi;
        }

        @WorkerThread
        @Deprecated
        @Nullable
        public static Oxx0IOOO II0XooXoX(Resources resources, JSONObject jSONObject) {
            return II0XooXoX.IXxxXO(jSONObject, (String) null).II0xO0();
        }

        @WorkerThread
        @Deprecated
        @Nullable
        public static Oxx0IOOO II0xO0(Context context, String str) {
            return II0XooXoX.Oxx0IOOO(context, str).II0xO0();
        }

        @Deprecated
        public static II0xO0 OOXIXo(Context context, @RawRes int i, Oxx0xo oxx0xo) {
            oIX0oI oix0oi = new oIX0oI(oxx0xo);
            II0XooXoX.Oxx0xo(context, i).XO(oix0oi);
            return oix0oi;
        }

        @Deprecated
        public static II0xO0 Oxx0IOOO(String str, Oxx0xo oxx0xo) {
            oIX0oI oix0oi = new oIX0oI(oxx0xo);
            II0XooXoX.x0xO0oo(str, (String) null).XO(oix0oi);
            return oix0oi;
        }

        @WorkerThread
        @Deprecated
        @Nullable
        public static Oxx0IOOO X0o0xo(InputStream inputStream, boolean z) {
            if (z) {
                XO.X0o0xo("Lottie now auto-closes input stream!");
            }
            return II0XooXoX.OOXIXo(inputStream, (String) null).II0xO0();
        }

        @Deprecated
        public static II0xO0 XO(JsonReader jsonReader, Oxx0xo oxx0xo) {
            oIX0oI oix0oi = new oIX0oI(oxx0xo);
            II0XooXoX.ooOOo0oXI(jsonReader, (String) null).XO(oix0oi);
            return oix0oi;
        }

        @Deprecated
        public static II0xO0 oIX0oI(Context context, String str, Oxx0xo oxx0xo) {
            oIX0oI oix0oi = new oIX0oI(oxx0xo);
            II0XooXoX.X0o0xo(context, str).XO(oix0oi);
            return oix0oi;
        }

        @WorkerThread
        @Deprecated
        @Nullable
        public static Oxx0IOOO oxoX(InputStream inputStream) {
            return II0XooXoX.OOXIXo(inputStream, (String) null).II0xO0();
        }

        @WorkerThread
        @Deprecated
        @Nullable
        public static Oxx0IOOO xoIox(String str) {
            return II0XooXoX.Oo(str, (String) null).II0xO0();
        }

        @WorkerThread
        @Deprecated
        @Nullable
        public static Oxx0IOOO xxIXOIIO(JsonReader jsonReader) {
            return II0XooXoX.x0XOIxOo(jsonReader, (String) null).II0xO0();
        }
    }

    public SparseArrayCompat<I0Io> I0Io() {
        return this.f810Oxx0IOOO;
    }

    public float II0XooXoX() {
        return this.f816ooOOo0oXI;
    }

    public Rect II0xO0() {
        return this.f819xoIox;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Layer IIXOooo(long j) {
        return this.f807II0XooXoX.get(j);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean IXxxXO() {
        return this.f818x0XOIxOo;
    }

    @Nullable
    public x0xO0oo.Oxx0IOOO OOXIXo(String str) {
        int size = this.f812XO.size();
        for (int i = 0; i < size; i++) {
            x0xO0oo.Oxx0IOOO oxx0IOOO = this.f812XO.get(i);
            if (oxx0IOOO.oIX0oI(str)) {
                return oxx0IOOO;
            }
        }
        return null;
    }

    public ArrayList<String> Oo() {
        HashSet<String> hashSet = this.f808II0xO0;
        return new ArrayList<>(Arrays.asList(hashSet.toArray(new String[hashSet.size()])));
    }

    public Map<String, x0xO0oo.II0xO0> Oxx0IOOO() {
        return this.f811X0o0xo;
    }

    public boolean Oxx0xo() {
        return !this.f817oxoX.isEmpty();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void OxxIIOOXO(Rect rect, float f, float f2, float f3, List<Layer> list, LongSparseArray<Layer> longSparseArray, Map<String, List<Layer>> map, Map<String, OOXIXo> map2, SparseArrayCompat<I0Io> sparseArrayCompat, Map<String, x0xO0oo.II0xO0> map3, List<x0xO0oo.Oxx0IOOO> list2) {
        this.f819xoIox = rect;
        this.f809OOXIXo = f;
        this.f815oOoXoXO = f2;
        this.f816ooOOo0oXI = f3;
        this.f820xxIXOIIO = list;
        this.f807II0XooXoX = longSparseArray;
        this.f806I0Io = map;
        this.f817oxoX = map2;
        this.f810Oxx0IOOO = sparseArrayCompat;
        this.f811X0o0xo = map3;
        this.f812XO = list2;
    }

    public float X0o0xo() {
        return this.f815oOoXoXO - this.f809OOXIXo;
    }

    public float XO() {
        return this.f815oOoXoXO;
    }

    public void o00(boolean z) {
        this.f813oIX0oI.Oxx0IOOO(z);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void oI0IIXIo(int i) {
        this.f814oO += i;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void oIX0oI(String str) {
        XO.X0o0xo(str);
        this.f808II0xO0.add(str);
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public List<Layer> oO(String str) {
        return this.f806I0Io.get(str);
    }

    public List<x0xO0oo.Oxx0IOOO> oOoXoXO() {
        return this.f812XO;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int ooOOo0oXI() {
        return this.f814oO;
    }

    public float oxoX() {
        return (float) ((long) ((X0o0xo() / this.f816ooOOo0oXI) * 1000.0f));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LottieComposition:\n");
        for (Layer xoXoI2 : this.f820xxIXOIIO) {
            sb.append(xoXoI2.xoXoI("\t"));
        }
        return sb.toString();
    }

    public oI0IIXIo x0XOIxOo() {
        return this.f813oIX0oI;
    }

    public float x0xO0oo() {
        return this.f809OOXIXo;
    }

    public List<Layer> xoIox() {
        return this.f820xxIXOIIO;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void xoXoI(boolean z) {
        this.f818x0XOIxOo = z;
    }

    public Map<String, OOXIXo> xxIXOIIO() {
        return this.f817oxoX;
    }
}
