package com.univocity.parsers.common;

import com.univocity.parsers.common.XO;
import java.io.BufferedWriter;
import java.io.File;
import java.io.OutputStream;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import oO0IXx.IIX0o;
import oO0IXx.xXxxox0I;

/* loaded from: classes13.dex */
public abstract class II0xO0<S extends XO<?>> {

    /* renamed from: I0Io, reason: collision with root package name */
    public final boolean f27020I0Io;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public int[] f27021II0XooXoX;

    /* renamed from: II0xO0, reason: collision with root package name */
    public BufferedWriter f27022II0xO0;

    /* renamed from: IIXOooo, reason: collision with root package name */
    public boolean f27023IIXOooo;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public int f27024IXxxXO;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public long f27025OOXIXo;

    /* renamed from: Oo, reason: collision with root package name */
    public Map<String[], Map<String, Integer>> f27026Oo;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public Object[] f27027Oxx0IOOO;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public boolean f27028Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public boolean f27029OxxIIOOXO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public final x0oox0.xoIox f27030X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public final boolean f27031XO;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public String[] f27032oI0IIXIo;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final xXxxox0I f27033oIX0oI;

    /* renamed from: oO, reason: collision with root package name */
    public final Object[] f27034oO;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public final String f27035oOoXoXO;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public final String f27036ooOOo0oXI;

    /* renamed from: oxoX, reason: collision with root package name */
    public final char f27037oxoX;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public final x0oox0.xoIox f27038x0XOIxOo;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public int f27039x0xO0oo;

    /* renamed from: xoIox, reason: collision with root package name */
    public String[] f27040xoIox;

    /* renamed from: xoXoI, reason: collision with root package name */
    public final X0o0xo<xoIox> f27041xoXoI;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public final char[] f27042xxIXOIIO;

    /* loaded from: classes13.dex */
    public class oIX0oI extends X0o0xo<xoIox> {
        public oIX0oI() {
        }

        @Override // com.univocity.parsers.common.X0o0xo
        /* renamed from: xI, reason: merged with bridge method [inline-methods] */
        public xoIox I0Io() {
            return xoIox.f27108IIXOooo;
        }
    }

    public II0xO0(S s) {
        this((Writer) null, s);
    }

    public static int XoX(String str) {
        if (str.isEmpty()) {
            return 0;
        }
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) > ' ') {
                return i;
            }
        }
        return str.length();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void I0(Map<?, ?> map) {
        ooOx(null, map);
    }

    public final void I0Io(Object obj) {
        try {
            Object[] objArr = this.f27034oO;
            int i = this.f27039x0xO0oo;
            this.f27039x0xO0oo = i + 1;
            objArr[i] = obj;
        } catch (Throwable th) {
            throw I0X0x0oIo("Error adding value to in-memory row", new Object[]{obj}, th);
        }
    }

    public final TextWritingException I0X0x0oIo(String str, Object[] objArr, Throwable th) {
        try {
            throw new TextWritingException(str, this.f27025OOXIXo, objArr, th);
        } catch (Throwable th2) {
            try {
                xoIox();
            } catch (Throwable unused) {
            }
            throw th2;
        }
    }

    public final void I0oOIX(X0o0xo<?> x0o0xo) {
        OXIOoo0X0.xoIox Oxx0IOOO2 = x0o0xo.Oxx0IOOO();
        if (Oxx0IOOO2 != null) {
            String[] strArr = this.f27040xoIox;
            if (strArr != null && strArr.length > 0) {
                this.f27027Oxx0IOOO = new Object[strArr.length];
                this.f27021II0XooXoX = Oxx0IOOO2.II0xO0(strArr);
                return;
            }
            if (!(Oxx0IOOO2 instanceof OXIOoo0X0.xxIXOIIO) && !(Oxx0IOOO2 instanceof OXIOoo0X0.X0o0xo)) {
                int i = this.f27024IXxxXO;
                if (Oxx0IOOO2 instanceof OXIOoo0X0.II0XooXoX) {
                    boolean z = false;
                    for (Integer num : ((OXIOoo0X0.II0XooXoX) Oxx0IOOO2).XO()) {
                        if (i <= num.intValue()) {
                            i = num.intValue();
                            z = true;
                        }
                    }
                    if (z) {
                        i++;
                    }
                    int i2 = this.f27024IXxxXO;
                    if (i < i2) {
                        i = i2;
                    }
                } else {
                    i = x0o0xo.x0XOIxOo();
                }
                this.f27027Oxx0IOOO = new Object[i];
                this.f27021II0XooXoX = Oxx0IOOO2.II0xO0(new String[i]);
                return;
            }
            throw new IllegalStateException("Cannot select fields by name with no headers defined");
        }
        this.f27027Oxx0IOOO = null;
        this.f27021II0XooXoX = null;
    }

    public final String I0oOoX() {
        x0xO0oo();
        String xI2 = xI(Arrays.copyOf(this.f27034oO, this.f27039x0xO0oo));
        ooOOo0oXI();
        return xI2;
    }

    public final void II0XooXoX(char c) {
        this.f27030X0o0xo.append(c);
    }

    public final void II0xO0(int i, Object obj) {
        Object[] objArr = this.f27034oO;
        if (i < objArr.length) {
            objArr[i] = obj;
            if (this.f27039x0xO0oo <= i) {
                this.f27039x0xO0oo = i + 1;
                return;
            }
            return;
        }
        throw I0X0x0oIo("Cannot write '" + obj + "' to index '" + i + "'. Maximum number of columns (" + this.f27034oO.length + ") exceeded.", new Object[]{obj}, null);
    }

    public final <C extends Collection<Object>> void IIX0(Iterable<C> iterable) {
        Iterator<C> it = iterable.iterator();
        while (it.hasNext()) {
            IIxOXoOo0(it.next());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String IIX0o(Map<?, ?> map) {
        return ooXIXxIX(null, map);
    }

    public abstract void IIXOooo(S s);

    public final void IIxOXoOo0(Collection<Object> collection) {
        if (collection == null) {
            return;
        }
        xoO0xx0(collection.toArray());
    }

    public final <K, I extends Iterable<?>> void IO(Map<K, String> map, Map<K, I> map2) {
        try {
            IoOoX(map, map2);
        } finally {
            xoIox();
        }
    }

    public final String IO0XoXxO() {
        x0xO0oo();
        String oOo2 = oOo(Arrays.copyOf(this.f27034oO, this.f27039x0xO0oo));
        ooOOo0oXI();
        return oOo2;
    }

    public final <C extends Collection<String>> void IXO(Iterable<C> iterable) {
        Iterator<C> it = iterable.iterator();
        while (it.hasNext()) {
            xoO0xx0(it.next().toArray());
        }
    }

    public final int IXxxXO(String[] strArr, String str, boolean z) {
        if (this.f27026Oo == null) {
            this.f27026Oo = new HashMap();
        }
        Map<String, Integer> map = this.f27026Oo.get(strArr);
        if (map == null) {
            map = new HashMap<>();
            this.f27026Oo.put(strArr, map);
        }
        Integer num = map.get(str);
        if (num == null) {
            if (strArr != null) {
                int I0Io2 = I0Io.I0Io(I0Io.Oxx0xo(strArr), I0Io.Oo(str));
                Integer valueOf = Integer.valueOf(I0Io2);
                if (I0Io2 == -1 && !z) {
                    throw XX0("Header '" + str + "' could not be found. Defined headers are: " + Arrays.toString(strArr) + '.', null);
                }
                map.put(str, valueOf);
                num = valueOf;
            } else {
                throw XX0("Cannot calculate position of header '" + str + "' as no headers were defined.", null);
            }
        }
        return num.intValue();
    }

    public final List<String> Io(Object[] objArr) {
        try {
            ArrayList arrayList = new ArrayList(1000);
            for (Object obj : objArr) {
                arrayList.add(xXxxox0I(obj));
            }
            return arrayList;
        } catch (Throwable th) {
            throw I0X0x0oIo("Unable process input records", objArr, th);
        }
    }

    public final <C extends Collection<Object>> void IoIOOxIIo(Iterable<C> iterable) {
        try {
            IIX0(iterable);
        } finally {
            xoIox();
        }
    }

    public final <K, I extends Iterable<?>> void IoOoX(Map<K, String> map, Map<K, I> map2) {
        xx0X0(map, map2, null, true);
    }

    public final void IoOoo() {
        try {
            this.f27022II0xO0.write(this.f27042xxIXOIIO);
        } catch (Throwable th) {
            throw xXOx("Error writing empty row.", Arrays.toString(this.f27042xxIXOIIO), th);
        }
    }

    public final <K> void IoXIXo(Map<K, String[]> map) {
        xxOXOOoIX(null, map);
    }

    public final String Ioxxx(Collection<String> collection) {
        if (collection != null && collection.size() > 0) {
            return xxIO((String[]) collection.toArray(new String[collection.size()]));
        }
        throw xo0x("No headers defined");
    }

    public final <K> void Ix00oIoI(Map<K, String> map, Map<K, String[]> map2) {
        xx0X0(map, OO(map2), null, false);
    }

    public final <K, I extends Iterable<?>> List<String> IxIX0I(Map<K, String> map, Map<K, I> map2) {
        ArrayList arrayList = new ArrayList();
        xx0X0(map, map2, arrayList, false);
        return arrayList;
    }

    public final <K, I extends Iterable<?>> void O0(Map<K, String> map, Map<K, I> map2) {
        xx0X0(map, map2, null, false);
    }

    public final <K> void O00XxXI(Map<K, String> map, Map<K, Object[]> map2) {
        try {
            XX0xXo(map, map2);
        } finally {
            xoIox();
        }
    }

    public final void O0IxXx(Collection<String[]> collection) {
        try {
            oI(collection);
        } finally {
            xoIox();
        }
    }

    public final String O0X(String[] strArr) {
        return oOo(strArr);
    }

    public void O0Xx(String... strArr) {
        if (this.f27040xoIox != null) {
            this.f27041xoXoI.OxxIIOOXO(strArr);
            I0oOIX(this.f27041xoXoI);
            return;
        }
        throw new IllegalStateException("Cannot select fields by name. Headers not defined.");
    }

    public final <K> List<String> O0xOxO(Map<K, Object[]> map) {
        return X0IIOO(null, map);
    }

    public final <K, I extends Iterable<?>> List<String> OI0(Map<K, String> map, Map<K, I> map2) {
        ArrayList arrayList = new ArrayList();
        xx0X0(map, map2, arrayList, true);
        return arrayList;
    }

    public final <C extends Collection<Object>> List<String> OIOoIIOIx(Iterable<C> iterable) {
        try {
            ArrayList arrayList = new ArrayList(1000);
            Iterator<C> it = iterable.iterator();
            while (it.hasNext()) {
                arrayList.add(xOOOX(it.next()));
            }
            return arrayList;
        } catch (Throwable th) {
            throw XX0("Error writing input rows", th);
        }
    }

    public final <K> Map<K, Iterable<String>> OO(Map<K, String[]> map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(map.size());
        for (Map.Entry<K, String[]> entry : map.entrySet()) {
            if (entry.getValue() == null) {
                linkedHashMap.put(entry.getKey(), Collections.emptyList());
            } else {
                linkedHashMap.put(entry.getKey(), Arrays.asList(entry.getValue()));
            }
        }
        return linkedHashMap;
    }

    public final void OO0x0xX(String... strArr) {
        if (this.f27025OOXIXo <= 0) {
            if (strArr != null && strArr.length > 0) {
                this.f27028Oxx0xo = true;
                oxXx0IX(strArr);
                this.f27040xoIox = strArr;
                XI0oooXX();
                this.f27028Oxx0xo = false;
                return;
            }
            throw I0X0x0oIo("No headers defined.", strArr, null);
        }
        throw I0X0x0oIo("Cannot write headers after records have been written.", strArr, null);
    }

    public final void OOXIXo(String str) {
        OOXIxO0(this.f27037oxoX + str);
    }

    public final void OOXIxO0(String str) {
        try {
            this.f27022II0xO0.write(str);
            this.f27022II0xO0.write(this.f27042xxIXOIIO);
        } catch (Throwable th) {
            throw xXOx("Error writing row.", str, th);
        }
    }

    public final void OX00O0xII(String[] strArr) {
        xoO0xx0(strArr);
    }

    public final void Oo() {
        try {
            this.f27022II0xO0.flush();
        } catch (Throwable th) {
            throw xXOx("Error flushing output.", this.f27030X0o0xo.II0XooXoX(), th);
        }
    }

    public final void OoO(Object[][] objArr) {
        try {
            xI0oxI00(objArr);
        } finally {
            xoIox();
        }
    }

    public final <K, I extends Iterable<?>> void Ox0O(Map<K, I> map) {
        xx0X0(null, map, null, false);
    }

    public final <K> void OxI(Map<K, String> map, Map<K, Object[]> map2) {
        try {
            xoXoI(map, map2);
        } finally {
            xoIox();
        }
    }

    public final void Oxx0IOOO(Object... objArr) {
        try {
            System.arraycopy(objArr, 0, this.f27034oO, this.f27039x0xO0oo, objArr.length);
            this.f27039x0xO0oo += objArr.length;
        } catch (Throwable th) {
            throw I0X0x0oIo("Error adding values to in-memory row", objArr, th);
        }
    }

    public final long Oxx0xo() {
        return this.f27025OOXIXo;
    }

    public String OxxIIOOXO(Object obj) {
        if (obj == null && (obj = this.f27035oOoXoXO) == null) {
            return null;
        }
        String valueOf = String.valueOf(obj);
        if (valueOf.isEmpty()) {
            return this.f27036ooOOo0oXI;
        }
        return valueOf;
    }

    public final <K, I extends Iterable<?>> void X00IoxXI(Map<K, I> map) {
        IO(null, map);
    }

    public final <K> List<String> X0IIOO(Map<K, String> map, Map<K, Object[]> map2) {
        ArrayList arrayList = new ArrayList();
        xx0X0(map, xoxXI(map2), arrayList, true);
        return arrayList;
    }

    public final void X0o0xo(String[] strArr, String str, boolean z, Object obj) {
        int IXxxXO2 = IXxxXO(strArr, str, z);
        if (IXxxXO2 != -1) {
            II0xO0(IXxxXO2, obj);
        }
    }

    public final <K> void X0xII0I(Map<K, String> map, Map<K, ?> map2) {
        if (map2 != null) {
            try {
                if (!map2.isEmpty()) {
                    this.f27032oI0IIXIo = this.f27040xoIox;
                    if (this.f27023IIXOooo) {
                        String[] oxoX2 = ((IIX0o) this.f27033oIX0oI).oxoX(map, map2);
                        this.f27032oI0IIXIo = oxoX2;
                        if (oxoX2 == null) {
                            this.f27032oI0IIXIo = this.f27040xoIox;
                        }
                    }
                    if (this.f27032oI0IIXIo != null) {
                        if (map == null) {
                            for (Map.Entry<K, ?> entry : map2.entrySet()) {
                                X0o0xo(this.f27032oI0IIXIo, String.valueOf(entry.getKey()), true, entry.getValue());
                            }
                            return;
                        }
                        for (Map.Entry<K, ?> entry2 : map2.entrySet()) {
                            String str = map.get(entry2.getKey());
                            if (str != null) {
                                X0o0xo(this.f27032oI0IIXIo, str, true, entry2.getValue());
                            }
                        }
                        return;
                    }
                    if (map != null) {
                        oxxXoxO(map, false);
                        X0xII0I(map, map2);
                    } else {
                        oxxXoxO(map2, true);
                        X0xII0I(null, map2);
                    }
                }
            } catch (Throwable th) {
                throw XX0("Error processing data from input map", th);
            }
        }
    }

    public final void X0xxXX0() {
        x0xO0oo();
        xoO0xx0(Arrays.copyOf(this.f27034oO, this.f27039x0xO0oo));
        ooOOo0oXI();
    }

    public final void XI0IXoo(Object obj) {
        Object[] oOoXoXO2;
        String valueOf;
        if (this.f27033oIX0oI == null) {
            if (obj instanceof Object[]) {
                valueOf = Arrays.toString((Object[]) obj);
            } else {
                valueOf = String.valueOf(obj);
            }
            xo0x("Cannot process record '" + valueOf + "' without a writer processor. Please define a writer processor instance in the settings or use the 'writeRow' methods.");
        }
        if (this.f27023IIXOooo) {
            String[] I0Io2 = ((IIX0o) this.f27033oIX0oI).I0Io(obj);
            this.f27032oI0IIXIo = I0Io2;
            if (I0Io2 == null) {
                this.f27032oI0IIXIo = this.f27040xoIox;
            }
            oOoXoXO2 = this.f27033oIX0oI.oOoXoXO(obj, this.f27032oI0IIXIo, this.f27021II0XooXoX);
        } else {
            oOoXoXO2 = this.f27033oIX0oI.oOoXoXO(obj, oI0IIXIo(), this.f27021II0XooXoX);
        }
        if (oOoXoXO2 != null) {
            xoO0xx0(oOoXoXO2);
        }
    }

    public final void XI0oooXX() {
        try {
            if (this.f27020I0Io && this.f27030X0o0xo.length() == 0) {
                return;
            }
            this.f27030X0o0xo.x0XOIxOo();
            this.f27030X0o0xo.oI0IIXIo(this.f27022II0xO0);
            this.f27025OOXIXo++;
        } catch (Throwable th) {
            throw xXOx("Error writing row.", this.f27030X0o0xo.II0XooXoX(), th);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String XIXIX(Map<?, ?> map) {
        return oXIO0o0XI(null, map);
    }

    public final <K, I extends Iterable<?>> void XIXIxO(Map<K, String> map, Map<K, I> map2) {
        try {
            O0(map, map2);
        } finally {
            xoIox();
        }
    }

    public final String XIo0oOXIx() {
        return xxIO(this.f27040xoIox);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void XIxXXX0x0(Map<?, ?> map) {
        xxX(null, map);
    }

    public final void XO(Collection<Object> collection) {
        if (collection != null) {
            try {
                for (Object obj : collection) {
                    Object[] objArr = this.f27034oO;
                    int i = this.f27039x0xO0oo;
                    this.f27039x0xO0oo = i + 1;
                    objArr[i] = obj;
                }
            } catch (Throwable th) {
                throw I0X0x0oIo("Error adding values to in-memory row", collection.toArray(), th);
            }
        }
    }

    public final <K, I extends Iterable<?>> List<String> XOxIOxOx(Map<K, I> map) {
        return OI0(null, map);
    }

    public final void XX() {
        x0xO0oo();
        XxX0x0xxx(Arrays.copyOf(this.f27034oO, this.f27039x0xO0oo));
        ooOOo0oXI();
    }

    public final TextWritingException XX0(String str, Throwable th) {
        return I0X0x0oIo(str, null, th);
    }

    public final <K> void XX0xXo(Map<K, String> map, Map<K, Object[]> map2) {
        xx0X0(map, xoxXI(map2), null, false);
    }

    public final <K, I extends Iterable<?>> List<String> XXoOx0(Map<K, I> map) {
        return IxIX0I(null, map);
    }

    public void Xo0(String... strArr) {
        if (this.f27040xoIox != null) {
            this.f27041xoXoI.X0o0xo(strArr);
            I0oOIX(this.f27041xoXoI);
            return;
        }
        throw new IllegalStateException("Cannot de-select fields by name. Headers not defined.");
    }

    public void XoI0Ixx0(Integer... numArr) {
        this.f27041xoXoI.IIXOooo(numArr);
        I0oOIX(this.f27041xoXoI);
    }

    public final void Xx000oIo(Iterable<?> iterable) {
        try {
            oo0xXOI0I(iterable);
        } finally {
            xoIox();
        }
    }

    public final void XxX0x0xxx(Object... objArr) {
        XI0IXoo(objArr);
    }

    public abstract void o0(Object[] objArr);

    public final <K> void o00(Map<K, Object[]> map) {
        IO(null, xoxXI(map));
    }

    public final <K, I extends Iterable<?>> void o0oIxOo(Map<K, I> map) {
        XIXIxO(null, map);
    }

    public final <K> void o0xxxXXxX(Map<K, Object[]> map) {
        O00XxXI(null, map);
    }

    public final void oI(Collection<String[]> collection) {
        Iterator<String[]> it = collection.iterator();
        while (it.hasNext()) {
            OX00O0xII(it.next());
        }
    }

    public final String[] oI0IIXIo() {
        String[] strArr = this.f27040xoIox;
        if (strArr == null && this.f27021II0XooXoX == null) {
            return null;
        }
        return strArr;
    }

    public final void oIX0oI(Collection<String> collection) {
        if (collection != null) {
            try {
                for (String str : collection) {
                    Object[] objArr = this.f27034oO;
                    int i = this.f27039x0xO0oo;
                    this.f27039x0xO0oo = i + 1;
                    objArr[i] = str;
                }
            } catch (Throwable th) {
                throw I0X0x0oIo("Error adding values to in-memory row", collection.toArray(), th);
            }
        }
    }

    public final <T> void oO(T[] tArr) {
        if (tArr.length > this.f27027Oxx0IOOO.length) {
            this.f27027Oxx0IOOO = tArr;
            return;
        }
        int i = 0;
        if (tArr.length > this.f27021II0XooXoX.length) {
            while (true) {
                int[] iArr = this.f27021II0XooXoX;
                if (i < iArr.length) {
                    Object[] objArr = this.f27027Oxx0IOOO;
                    int i2 = iArr[i];
                    objArr[i2] = tArr[i2];
                    i++;
                } else {
                    return;
                }
            }
        } else {
            while (true) {
                int[] iArr2 = this.f27021II0XooXoX;
                if (i < iArr2.length && i < tArr.length) {
                    this.f27027Oxx0IOOO[iArr2[i]] = tArr[i];
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    public final void oOXoIIIo(Object[] objArr) {
        for (Object obj : objArr) {
            XI0IXoo(obj);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0012 A[Catch: all -> 0x0006, TryCatch #0 {all -> 0x0006, blocks: (B:17:0x0002, B:6:0x000e, B:8:0x0012, B:9:0x0017, B:2:0x0008), top: B:16:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String oOo(java.lang.Object... r3) {
        /*
            r2 = this;
            if (r3 == 0) goto L8
            int r0 = r3.length     // Catch: java.lang.Throwable -> L6
            if (r0 != 0) goto Le
            goto L8
        L6:
            r0 = move-exception
            goto L1f
        L8:
            boolean r0 = r2.f27020I0Io     // Catch: java.lang.Throwable -> L6
            if (r0 == 0) goto Le
            r3 = 0
            return r3
        Le:
            java.lang.Object[] r0 = r2.f27027Oxx0IOOO     // Catch: java.lang.Throwable -> L6
            if (r0 == 0) goto L17
            r2.oO(r3)     // Catch: java.lang.Throwable -> L6
            java.lang.Object[] r3 = r2.f27027Oxx0IOOO     // Catch: java.lang.Throwable -> L6
        L17:
            r2.oxXx0IX(r3)     // Catch: java.lang.Throwable -> L6
            java.lang.String r3 = r2.xX0IIXIx0()     // Catch: java.lang.Throwable -> L6
            return r3
        L1f:
            java.lang.String r1 = "Error writing row."
            com.univocity.parsers.common.TextWritingException r3 = r2.I0X0x0oIo(r1, r3, r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.univocity.parsers.common.II0xO0.oOo(java.lang.Object[]):java.lang.String");
    }

    public final List<String> oOoIIO0(Object[][] objArr) {
        try {
            ArrayList arrayList = new ArrayList(objArr.length);
            for (Object[] objArr2 : objArr) {
                String oOo2 = oOo(objArr2);
                if (oOo2 != null) {
                    arrayList.add(oOo2);
                }
            }
            return arrayList;
        } catch (Throwable th) {
            throw XX0("Error writing input rows", th);
        }
    }

    public final String oOoXoXO(String str) {
        return oOo(this.f27037oxoX + str);
    }

    public void oX(Integer... numArr) {
        this.f27041xoXoI.XO(numArr);
        I0oOIX(this.f27041xoXoI);
    }

    public final <K> String oXIO0o0XI(Map<K, String> map, Map<K, ?> map2) {
        X0xII0I(map, map2);
        return IO0XoXxO();
    }

    public final <K, I extends Iterable<?>> void oo(Map<K, I> map) {
        xx0X0(null, map, null, true);
    }

    public final void oo0xXOI0I(Iterable<?> iterable) {
        Iterator<?> it = iterable.iterator();
        while (it.hasNext()) {
            XI0IXoo(it.next());
        }
    }

    public final void ooOOo0oXI() {
        Arrays.fill(this.f27034oO, 0, this.f27039x0xO0oo, (Object) null);
        this.f27039x0xO0oo = 0;
    }

    public final <K> void ooOx(Map<K, String> map, Map<K, ?> map2) {
        X0xII0I(map, map2);
        X0xxXX0();
    }

    public final <K> String ooXIXxIX(Map<K, String> map, Map<K, ?> map2) {
        X0xII0I(map, map2);
        return I0oOoX();
    }

    public final <K> List<String> ox(Map<K, String> map, Map<K, Object[]> map2) {
        ArrayList arrayList = new ArrayList();
        xx0X0(map, xoxXI(map2), arrayList, false);
        return arrayList;
    }

    public final void oxIIX0o(Collection<Object[]> collection) {
        try {
            xOoOIoI(collection);
        } finally {
            xoIox();
        }
    }

    public final void oxXx0IX(Object[] objArr) {
        if (this.f27024IXxxXO < objArr.length) {
            this.f27024IXxxXO = objArr.length;
        }
        o0(objArr);
    }

    public final void oxoX(String str, Object obj) {
        II0xO0(IXxxXO(this.f27040xoIox, str, false), obj);
    }

    public final void oxxXoxO(Map<?, ?> map, boolean z) {
        Collection<?> values;
        this.f27040xoIox = new String[map.size()];
        if (z) {
            values = map.keySet();
        } else {
            values = map.values();
        }
        Iterator<?> it = values.iterator();
        int i = 0;
        while (it.hasNext()) {
            this.f27040xoIox[i] = String.valueOf(it.next());
            i++;
        }
    }

    public final <K> List<String> x0(Map<K, String> map, Map<K, String[]> map2) {
        ArrayList arrayList = new ArrayList();
        xx0X0(map, OO(map2), arrayList, false);
        return arrayList;
    }

    public final List<String> x0OIX00oO(Collection<Object[]> collection) {
        try {
            ArrayList arrayList = new ArrayList(collection.size());
            Iterator<Object[]> it = collection.iterator();
            while (it.hasNext()) {
                arrayList.add(oOo(it.next()));
            }
            return arrayList;
        } catch (Throwable th) {
            throw XX0("Error writing input rows", th);
        }
    }

    public final List<String> x0OxxIOxX(Collection<String[]> collection) {
        try {
            ArrayList arrayList = new ArrayList(collection.size());
            Iterator<String[]> it = collection.iterator();
            while (it.hasNext()) {
                arrayList.add(O0X(it.next()));
            }
            return arrayList;
        } catch (Throwable th) {
            throw XX0("Error writing input rows", th);
        }
    }

    public final Object[] x0XOIxOo(Object[] objArr, String[] strArr, String[] strArr2) {
        if (strArr != null && objArr.length < strArr.length) {
            return Arrays.copyOf(objArr, strArr.length);
        }
        if (strArr2 != null && objArr.length < strArr2.length) {
            return Arrays.copyOf(objArr, strArr2.length);
        }
        if (strArr == null && strArr2 == null) {
            int length = objArr.length;
            int i = this.f27024IXxxXO;
            if (length < i) {
                return Arrays.copyOf(objArr, i);
            }
            return objArr;
        }
        return objArr;
    }

    public final List<String> x0o(Iterable<?> iterable) {
        try {
            ArrayList arrayList = new ArrayList(1000);
            Iterator<?> it = iterable.iterator();
            while (it.hasNext()) {
                arrayList.add(xXxxox0I(it.next()));
            }
            return arrayList;
        } catch (Throwable th) {
            throw XX0("Unable process input records", th);
        }
    }

    public final void x0xO(Collection<String> collection) {
        if (collection != null && collection.size() > 0) {
            OO0x0xX((String[]) collection.toArray(new String[collection.size()]));
            return;
        }
        throw xo0x("No headers defined.");
    }

    public final void x0xO0oo() {
        String[] strArr = this.f27040xoIox;
        if (strArr == null || this.f27039x0xO0oo >= strArr.length) {
            return;
        }
        while (true) {
            int i = this.f27039x0xO0oo;
            if (i < this.f27040xoIox.length) {
                Object[] objArr = this.f27034oO;
                this.f27039x0xO0oo = i + 1;
                objArr[i] = null;
            } else {
                return;
            }
        }
    }

    public final String xI(Object... objArr) {
        return xXxxox0I(objArr);
    }

    public final void xI0oxI00(Object[][] objArr) {
        for (Object[] objArr2 : objArr) {
            xoO0xx0(objArr2);
        }
    }

    public final void xII(Object[] objArr) {
        try {
            oOXoIIIo(objArr);
        } finally {
            xoIox();
        }
    }

    public final String xOOOX(Collection<Object> collection) {
        if (collection == null) {
            return null;
        }
        try {
            return oOo(collection.toArray());
        } catch (Throwable th) {
            throw XX0("Error writing input row ", th);
        }
    }

    public final void xOoOIoI(Collection<Object[]> collection) {
        Iterator<Object[]> it = collection.iterator();
        while (it.hasNext()) {
            xoO0xx0(it.next());
        }
    }

    public final String xX0IIXIx0() {
        if (this.f27020I0Io && this.f27030X0o0xo.length() == 0) {
            return null;
        }
        String II0XooXoX2 = this.f27030X0o0xo.II0XooXoX();
        this.f27025OOXIXo++;
        return II0XooXoX2;
    }

    public final TextWritingException xXOx(String str, String str2, Throwable th) {
        try {
            if ((th instanceof NullPointerException) && this.f27022II0xO0 == null) {
                str = str + " No writer provided in the constructor of " + getClass().getName() + ". You can only use operations that write to Strings.";
            }
            throw new TextWritingException(str, this.f27025OOXIXo, str2, th);
        } catch (Throwable th2) {
            xoIox();
            throw th2;
        }
    }

    public final <C extends Collection<String>> List<String> xXoOI00O(Iterable<C> iterable) {
        try {
            ArrayList arrayList = new ArrayList(1000);
            Iterator<C> it = iterable.iterator();
            while (it.hasNext()) {
                String oOo2 = oOo(it.next());
                if (oOo2 != null) {
                    arrayList.add(oOo2);
                }
            }
            return arrayList;
        } catch (Throwable th) {
            throw XX0("Error writing input rows", th);
        }
    }

    public final String xXxxox0I(Object obj) {
        xXxxox0I xxxxox0i = this.f27033oIX0oI;
        if (xxxxox0i != null) {
            try {
                Object[] oOoXoXO2 = xxxxox0i.oOoXoXO(obj, oI0IIXIo(), this.f27021II0XooXoX);
                if (oOoXoXO2 != null) {
                    return oOo(oOoXoXO2);
                }
                return null;
            } catch (Throwable th) {
                throw XX0("Could not process record '" + obj + "'", th);
            }
        }
        throw xo0x("Cannot process record '" + obj + "' without a writer processor. Please define a writer processor instance in the settings or use the 'writeRow' methods.");
    }

    public final TextWritingException xo0x(String str) {
        return I0X0x0oIo(str, null, null);
    }

    public final void xoIox() {
        try {
            this.f27026Oo = null;
            BufferedWriter bufferedWriter = this.f27022II0xO0;
            if (bufferedWriter != null) {
                bufferedWriter.close();
                this.f27022II0xO0 = null;
            }
            if (this.f27039x0xO0oo == 0) {
            } else {
                throw new TextWritingException("Not all values associated with the last record have been written to the output. \n\tHint: use 'writeValuesToRow()' or 'writeValuesToString()' to flush the partially written values to a row.", this.f27025OOXIXo, Arrays.copyOf(this.f27034oO, this.f27039x0xO0oo));
            }
        } catch (Throwable th) {
            throw new IllegalStateException("Error closing the output.", th);
        }
    }

    public final void xoIxX() {
        OO0x0xX(this.f27040xoIox);
    }

    public final void xoO0xx0(Object... objArr) {
        try {
            if (this.f27025OOXIXo == 0 && this.f27031XO && this.f27040xoIox != null) {
                xoIxX();
            }
            if (objArr != null && (objArr.length != 0 || this.f27029OxxIIOOXO)) {
                if (this.f27027Oxx0IOOO != null) {
                    oO(objArr);
                    objArr = this.f27027Oxx0IOOO;
                } else if (this.f27029OxxIIOOXO) {
                    if (this.f27023IIXOooo) {
                        objArr = x0XOIxOo(objArr, this.f27032oI0IIXIo, this.f27040xoIox);
                        this.f27032oI0IIXIo = null;
                    } else {
                        objArr = x0XOIxOo(objArr, this.f27040xoIox, null);
                    }
                }
                oxXx0IX(objArr);
                XI0oooXX();
                return;
            }
            if (this.f27020I0Io) {
                return;
            }
            IoOoo();
        } catch (Throwable th) {
            throw I0X0x0oIo("Error writing row.", objArr, th);
        }
    }

    public final <K> void xoXoI(Map<K, String> map, Map<K, Object[]> map2) {
        xx0X0(map, xoxXI(map2), null, true);
    }

    public final <K> Map<K, Iterable<Object>> xoxXI(Map<K, Object[]> map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(map.size());
        for (Map.Entry<K, Object[]> entry : map.entrySet()) {
            if (entry.getValue() == null) {
                linkedHashMap.put(entry.getKey(), Collections.emptyList());
            } else {
                linkedHashMap.put(entry.getKey(), Arrays.asList(entry.getValue()));
            }
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0068 A[Catch: all -> 0x0050, TryCatch #0 {all -> 0x0050, blocks: (B:2:0x0000, B:3:0x001f, B:5:0x0026, B:9:0x003e, B:10:0x0034, B:15:0x0057, B:17:0x005b, B:21:0x0065, B:23:0x0068, B:25:0x0077, B:26:0x006e, B:34:0x0080, B:41:0x0084, B:44:0x008a, B:46:0x0092), top: B:1:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x006e A[Catch: all -> 0x0050, TryCatch #0 {all -> 0x0050, blocks: (B:2:0x0000, B:3:0x001f, B:5:0x0026, B:9:0x003e, B:10:0x0034, B:15:0x0057, B:17:0x005b, B:21:0x0065, B:23:0x0068, B:25:0x0077, B:26:0x006e, B:34:0x0080, B:41:0x0084, B:44:0x008a, B:46:0x0092), top: B:1:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final <K, I extends java.lang.Iterable<?>> void xx0X0(java.util.Map<K, java.lang.String> r11, java.util.Map<K, I> r12, java.util.List<java.lang.String> r13, boolean r14) {
        /*
            r10 = this;
            int r0 = r12.size()     // Catch: java.lang.Throwable -> L50
            java.util.Iterator[] r0 = new java.util.Iterator[r0]     // Catch: java.lang.Throwable -> L50
            int r1 = r12.size()     // Catch: java.lang.Throwable -> L50
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L50
            java.util.LinkedHashMap r2 = new java.util.LinkedHashMap     // Catch: java.lang.Throwable -> L50
            int r3 = r12.size()     // Catch: java.lang.Throwable -> L50
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L50
            java.util.Set r12 = r12.entrySet()     // Catch: java.lang.Throwable -> L50
            java.util.Iterator r12 = r12.iterator()     // Catch: java.lang.Throwable -> L50
            r3 = 0
            r4 = 0
        L1f:
            boolean r5 = r12.hasNext()     // Catch: java.lang.Throwable -> L50
            r6 = 0
            if (r5 == 0) goto L52
            java.lang.Object r5 = r12.next()     // Catch: java.lang.Throwable -> L50
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5     // Catch: java.lang.Throwable -> L50
            java.lang.Object r7 = r5.getValue()     // Catch: java.lang.Throwable -> L50
            if (r7 != 0) goto L34
            r7 = r6
            goto L3e
        L34:
            java.lang.Object r7 = r5.getValue()     // Catch: java.lang.Throwable -> L50
            java.lang.Iterable r7 = (java.lang.Iterable) r7     // Catch: java.lang.Throwable -> L50
            java.util.Iterator r7 = r7.iterator()     // Catch: java.lang.Throwable -> L50
        L3e:
            r0[r4] = r7     // Catch: java.lang.Throwable -> L50
            java.lang.Object r7 = r5.getKey()     // Catch: java.lang.Throwable -> L50
            r1[r4] = r7     // Catch: java.lang.Throwable -> L50
            java.lang.Object r5 = r5.getKey()     // Catch: java.lang.Throwable -> L50
            r2.put(r5, r6)     // Catch: java.lang.Throwable -> L50
            int r4 = r4 + 1
            goto L1f
        L50:
            r11 = move-exception
            goto L9c
        L52:
            r12 = 1
            r5 = 0
            r7 = 1
        L55:
            if (r5 >= r4) goto L7a
            r8 = r0[r5]     // Catch: java.lang.Throwable -> L50
            if (r8 == 0) goto L64
            boolean r9 = r8.hasNext()     // Catch: java.lang.Throwable -> L50
            if (r9 != 0) goto L62
            goto L64
        L62:
            r9 = 0
            goto L65
        L64:
            r9 = 1
        L65:
            r7 = r7 & r9
            if (r9 == 0) goto L6e
            r8 = r1[r5]     // Catch: java.lang.Throwable -> L50
            r2.put(r8, r6)     // Catch: java.lang.Throwable -> L50
            goto L77
        L6e:
            r9 = r1[r5]     // Catch: java.lang.Throwable -> L50
            java.lang.Object r8 = r8.next()     // Catch: java.lang.Throwable -> L50
            r2.put(r9, r8)     // Catch: java.lang.Throwable -> L50
        L77:
            int r5 = r5 + 1
            goto L55
        L7a:
            if (r7 != 0) goto L99
            if (r13 != 0) goto L88
            if (r14 == 0) goto L84
            r10.xxX(r11, r2)     // Catch: java.lang.Throwable -> L50
            goto L99
        L84:
            r10.ooOx(r11, r2)     // Catch: java.lang.Throwable -> L50
            goto L99
        L88:
            if (r14 == 0) goto L92
            java.lang.String r12 = r10.ooXIXxIX(r11, r2)     // Catch: java.lang.Throwable -> L50
            r13.add(r12)     // Catch: java.lang.Throwable -> L50
            goto L99
        L92:
            java.lang.String r12 = r10.oXIO0o0XI(r11, r2)     // Catch: java.lang.Throwable -> L50
            r13.add(r12)     // Catch: java.lang.Throwable -> L50
        L99:
            if (r7 == 0) goto L52
            return
        L9c:
            java.lang.String r12 = "Error processing input rows from map"
            com.univocity.parsers.common.TextWritingException r11 = r10.XX0(r12, r11)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.univocity.parsers.common.II0xO0.xx0X0(java.util.Map, java.util.Map, java.util.List, boolean):void");
    }

    public final String xxIO(String... strArr) {
        if (strArr != null && strArr.length > 0) {
            this.f27028Oxx0xo = true;
            oxXx0IX(strArr);
            this.f27028Oxx0xo = false;
            this.f27040xoIox = strArr;
            return xX0IIXIx0();
        }
        throw xo0x("No headers defined.");
    }

    public final void xxIXOIIO() {
        this.f27030X0o0xo.OOXIXo(this.f27038x0XOIxOo);
    }

    public final <K> void xxOXOOoIX(Map<K, String> map, Map<K, String[]> map2) {
        try {
            Ix00oIoI(map, map2);
        } finally {
            xoIox();
        }
    }

    public final <K> void xxX(Map<K, String> map, Map<K, ?> map2) {
        X0xII0I(map, map2);
        XX();
    }

    public II0xO0(File file, S s) {
        this(I0Io.xoIox(file), s);
    }

    public II0xO0(File file, String str, S s) {
        this(I0Io.OOXIXo(file, str), s);
    }

    public II0xO0(File file, Charset charset, S s) {
        this(I0Io.oOoXoXO(file, charset), s);
    }

    public II0xO0(OutputStream outputStream, S s) {
        this(I0Io.ooOOo0oXI(outputStream), s);
    }

    public II0xO0(OutputStream outputStream, String str, S s) {
        this(I0Io.x0XOIxOo(outputStream, str), s);
    }

    public II0xO0(OutputStream outputStream, Charset charset, S s) {
        this(I0Io.oO(outputStream, charset), s);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public II0xO0(Writer writer, S s) {
        this.f27025OOXIXo = 0L;
        this.f27039x0xO0oo = 0;
        this.f27024IXxxXO = -1;
        this.f27028Oxx0xo = false;
        oIX0oI oix0oi = new oIX0oI();
        this.f27041xoXoI = oix0oi;
        s.II0xO0();
        oix0oi.xxX(s.x0XOIxOo());
        this.f27035oOoXoXO = s.oO();
        this.f27036ooOOo0oXI = s.xI();
        this.f27042xxIXOIIO = s.xxIXOIIO().X0o0xo();
        this.f27037oxoX = s.xxIXOIIO().II0xO0();
        this.f27020I0Io = s.Oo();
        xXxxox0I<?> oo2 = s.oo();
        this.f27033oIX0oI = oo2;
        this.f27023IIXOooo = oo2 instanceof IIX0o;
        this.f27029OxxIIOOXO = s.oo0xXOI0I();
        this.f27038x0XOIxOo = new x0oox0.xoIox(s.ooOOo0oXI(), "", s.xxIXOIIO());
        this.f27030X0o0xo = new x0oox0.xoIox(s.ooOOo0oXI(), "", s.xxIXOIIO());
        if (writer != null) {
            if (writer instanceof BufferedWriter) {
                this.f27022II0xO0 = (BufferedWriter) writer;
            } else {
                this.f27022II0xO0 = new BufferedWriter(writer);
            }
        } else {
            this.f27022II0xO0 = null;
        }
        this.f27040xoIox = s.xoIox();
        I0oOIX(s);
        this.f27034oO = new Object[s.x0XOIxOo()];
        this.f27031XO = s.IoOoX();
        if (oo2 instanceof II0XooXoX) {
            II0XooXoX iI0XooXoX = (II0XooXoX) oo2;
            iI0XooXoX.f27015Oxx0IOOO = null;
            iI0XooXoX.f27017XO = s.x0xO0oo();
        }
        IIXOooo(s);
    }
}
