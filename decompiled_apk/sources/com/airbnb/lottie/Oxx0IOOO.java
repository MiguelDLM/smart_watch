package com.airbnb.lottie;

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
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class Oxx0IOOO {

    /* renamed from: I0Io, reason: collision with root package name */
    public Map<String, List<Layer>> f4800I0Io;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public LongSparseArray<Layer> f4801II0XooXoX;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public float f4803OOXIXo;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public SparseArrayCompat<x0xO0oo.I0Io> f4804Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public Map<String, x0xO0oo.II0xO0> f4805X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public List<x0xO0oo.Oxx0IOOO> f4806XO;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public float f4809oOoXoXO;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public float f4810ooOOo0oXI;

    /* renamed from: oxoX, reason: collision with root package name */
    public Map<String, OOXIXo> f4811oxoX;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public boolean f4812x0XOIxOo;

    /* renamed from: xoIox, reason: collision with root package name */
    public Rect f4813xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public List<Layer> f4814xxIXOIIO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final oI0IIXIo f4807oIX0oI = new oI0IIXIo();

    /* renamed from: II0xO0, reason: collision with root package name */
    public final HashSet<String> f4802II0xO0 = new HashSet<>();

    /* renamed from: oO, reason: collision with root package name */
    public int f4808oO = 0;

    @Deprecated
    /* loaded from: classes.dex */
    public static class II0xO0 {

        /* loaded from: classes.dex */
        public static final class oIX0oI implements oOoXoXO<Oxx0IOOO>, com.airbnb.lottie.II0xO0 {

            /* renamed from: II0xO0, reason: collision with root package name */
            public boolean f4815II0xO0;

            /* renamed from: oIX0oI, reason: collision with root package name */
            public final Oxx0xo f4816oIX0oI;

            @Override // com.airbnb.lottie.II0xO0
            public void cancel() {
                this.f4815II0xO0 = true;
            }

            @Override // com.airbnb.lottie.oOoXoXO
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void onResult(Oxx0IOOO oxx0IOOO) {
                if (this.f4815II0xO0) {
                    return;
                }
                this.f4816oIX0oI.oIX0oI(oxx0IOOO);
            }

            public oIX0oI(Oxx0xo oxx0xo) {
                this.f4815II0xO0 = false;
                this.f4816oIX0oI = oxx0xo;
            }
        }

        @Deprecated
        public static com.airbnb.lottie.II0xO0 I0Io(InputStream inputStream, Oxx0xo oxx0xo) {
            oIX0oI oix0oi = new oIX0oI(oxx0xo);
            II0XooXoX.xoIox(inputStream, null).XO(oix0oi);
            return oix0oi;
        }

        @Nullable
        @WorkerThread
        @Deprecated
        public static Oxx0IOOO II0XooXoX(Resources resources, JSONObject jSONObject) {
            return II0XooXoX.IXxxXO(jSONObject, null).II0xO0();
        }

        @Nullable
        @WorkerThread
        @Deprecated
        public static Oxx0IOOO II0xO0(Context context, String str) {
            return II0XooXoX.Oxx0IOOO(context, str).II0xO0();
        }

        @Deprecated
        public static com.airbnb.lottie.II0xO0 OOXIXo(Context context, @RawRes int i, Oxx0xo oxx0xo) {
            oIX0oI oix0oi = new oIX0oI(oxx0xo);
            II0XooXoX.Oxx0xo(context, i).XO(oix0oi);
            return oix0oi;
        }

        @Deprecated
        public static com.airbnb.lottie.II0xO0 Oxx0IOOO(String str, Oxx0xo oxx0xo) {
            oIX0oI oix0oi = new oIX0oI(oxx0xo);
            II0XooXoX.x0xO0oo(str, null).XO(oix0oi);
            return oix0oi;
        }

        @Nullable
        @WorkerThread
        @Deprecated
        public static Oxx0IOOO X0o0xo(InputStream inputStream, boolean z) {
            if (z) {
                IIXOooo.XO.X0o0xo("Lottie now auto-closes input stream!");
            }
            return II0XooXoX.OOXIXo(inputStream, null).II0xO0();
        }

        @Deprecated
        public static com.airbnb.lottie.II0xO0 XO(JsonReader jsonReader, Oxx0xo oxx0xo) {
            oIX0oI oix0oi = new oIX0oI(oxx0xo);
            II0XooXoX.ooOOo0oXI(jsonReader, null).XO(oix0oi);
            return oix0oi;
        }

        @Deprecated
        public static com.airbnb.lottie.II0xO0 oIX0oI(Context context, String str, Oxx0xo oxx0xo) {
            oIX0oI oix0oi = new oIX0oI(oxx0xo);
            II0XooXoX.X0o0xo(context, str).XO(oix0oi);
            return oix0oi;
        }

        @Nullable
        @WorkerThread
        @Deprecated
        public static Oxx0IOOO oxoX(InputStream inputStream) {
            return II0XooXoX.OOXIXo(inputStream, null).II0xO0();
        }

        @Nullable
        @WorkerThread
        @Deprecated
        public static Oxx0IOOO xoIox(String str) {
            return II0XooXoX.Oo(str, null).II0xO0();
        }

        @Nullable
        @WorkerThread
        @Deprecated
        public static Oxx0IOOO xxIXOIIO(JsonReader jsonReader) {
            return II0XooXoX.x0XOIxOo(jsonReader, null).II0xO0();
        }
    }

    public SparseArrayCompat<x0xO0oo.I0Io> I0Io() {
        return this.f4804Oxx0IOOO;
    }

    public float II0XooXoX() {
        return this.f4810ooOOo0oXI;
    }

    public Rect II0xO0() {
        return this.f4813xoIox;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Layer IIXOooo(long j) {
        return this.f4801II0XooXoX.get(j);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean IXxxXO() {
        return this.f4812x0XOIxOo;
    }

    @Nullable
    public x0xO0oo.Oxx0IOOO OOXIXo(String str) {
        int size = this.f4806XO.size();
        for (int i = 0; i < size; i++) {
            x0xO0oo.Oxx0IOOO oxx0IOOO = this.f4806XO.get(i);
            if (oxx0IOOO.oIX0oI(str)) {
                return oxx0IOOO;
            }
        }
        return null;
    }

    public ArrayList<String> Oo() {
        HashSet<String> hashSet = this.f4802II0xO0;
        return new ArrayList<>(Arrays.asList(hashSet.toArray(new String[hashSet.size()])));
    }

    public Map<String, x0xO0oo.II0xO0> Oxx0IOOO() {
        return this.f4805X0o0xo;
    }

    public boolean Oxx0xo() {
        return !this.f4811oxoX.isEmpty();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void OxxIIOOXO(Rect rect, float f, float f2, float f3, List<Layer> list, LongSparseArray<Layer> longSparseArray, Map<String, List<Layer>> map, Map<String, OOXIXo> map2, SparseArrayCompat<x0xO0oo.I0Io> sparseArrayCompat, Map<String, x0xO0oo.II0xO0> map3, List<x0xO0oo.Oxx0IOOO> list2) {
        this.f4813xoIox = rect;
        this.f4803OOXIXo = f;
        this.f4809oOoXoXO = f2;
        this.f4810ooOOo0oXI = f3;
        this.f4814xxIXOIIO = list;
        this.f4801II0XooXoX = longSparseArray;
        this.f4800I0Io = map;
        this.f4811oxoX = map2;
        this.f4804Oxx0IOOO = sparseArrayCompat;
        this.f4805X0o0xo = map3;
        this.f4806XO = list2;
    }

    public float X0o0xo() {
        return this.f4809oOoXoXO - this.f4803OOXIXo;
    }

    public float XO() {
        return this.f4809oOoXoXO;
    }

    public void o00(boolean z) {
        this.f4807oIX0oI.Oxx0IOOO(z);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void oI0IIXIo(int i) {
        this.f4808oO += i;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void oIX0oI(String str) {
        IIXOooo.XO.X0o0xo(str);
        this.f4802II0xO0.add(str);
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public List<Layer> oO(String str) {
        return this.f4800I0Io.get(str);
    }

    public List<x0xO0oo.Oxx0IOOO> oOoXoXO() {
        return this.f4806XO;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int ooOOo0oXI() {
        return this.f4808oO;
    }

    public float oxoX() {
        return (X0o0xo() / this.f4810ooOOo0oXI) * 1000.0f;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LottieComposition:\n");
        Iterator<Layer> it = this.f4814xxIXOIIO.iterator();
        while (it.hasNext()) {
            sb.append(it.next().xoXoI("\t"));
        }
        return sb.toString();
    }

    public oI0IIXIo x0XOIxOo() {
        return this.f4807oIX0oI;
    }

    public float x0xO0oo() {
        return this.f4803OOXIXo;
    }

    public List<Layer> xoIox() {
        return this.f4814xxIXOIIO;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void xoXoI(boolean z) {
        this.f4812x0XOIxOo = z;
    }

    public Map<String, OOXIXo> xxIXOIIO() {
        return this.f4811oxoX;
    }
}
