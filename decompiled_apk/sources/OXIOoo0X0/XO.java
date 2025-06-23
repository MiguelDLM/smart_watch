package OXIOoo0X0;

import com.univocity.parsers.common.DataProcessingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes13.dex */
public class XO {

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final xXo.Oxx0IOOO[] f1989Oxx0IOOO = new xXo.Oxx0IOOO[0];

    /* renamed from: I0Io, reason: collision with root package name */
    public final OXIOoo0X0.oIX0oI<Integer> f1990I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public final OXIOoo0X0.oIX0oI<String> f1991II0xO0;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public final OXIOoo0X0.oIX0oI<Integer> f1992X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public Map<Integer, List<xXo.Oxx0IOOO<?, ?>>> f1993XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final List<xoIox> f1994oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public final OXIOoo0X0.oIX0oI<Enum> f1995oxoX;

    /* loaded from: classes13.dex */
    public class I0Io extends OXIOoo0X0.oIX0oI<Enum> {
        public I0Io(List list) {
            super(list);
        }

        @Override // OXIOoo0X0.oIX0oI
        public xoIox II0xO0() {
            return new Oxx0IOOO();
        }
    }

    /* loaded from: classes13.dex */
    public class II0xO0 extends OXIOoo0X0.oIX0oI<Integer> {
        public II0xO0(List list) {
            super(list);
        }

        @Override // OXIOoo0X0.oIX0oI
        public xoIox II0xO0() {
            return new II0XooXoX();
        }
    }

    /* loaded from: classes13.dex */
    public class oIX0oI extends OXIOoo0X0.oIX0oI<String> {
        public oIX0oI(List list) {
            super(list);
        }

        @Override // OXIOoo0X0.oIX0oI
        public xoIox II0xO0() {
            return new xxIXOIIO();
        }
    }

    /* loaded from: classes13.dex */
    public class oxoX extends OXIOoo0X0.oIX0oI<Integer> {
        public oxoX(List list) {
            super(list);
        }

        @Override // OXIOoo0X0.oIX0oI
        public xoIox II0xO0() {
            return new OXIOoo0X0.II0xO0();
        }
    }

    public XO() {
        ArrayList arrayList = new ArrayList();
        this.f1994oIX0oI = arrayList;
        this.f1991II0xO0 = new oIX0oI(arrayList);
        this.f1990I0Io = new II0xO0(arrayList);
        this.f1995oxoX = new I0Io(arrayList);
        this.f1992X0o0xo = new oxoX(arrayList);
        this.f1993XO = Collections.emptyMap();
    }

    public OOXIXo<Enum> I0Io(xXo.Oxx0IOOO<String, ?>... oxx0IOOOArr) {
        return this.f1995oxoX.oxoX(oxx0IOOOArr);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0073  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object II0XooXoX(boolean r3, int r4, java.lang.Object r5, boolean[] r6) {
        /*
            r2 = this;
            java.util.Map<java.lang.Integer, java.util.List<xXo.Oxx0IOOO<?, ?>>> r0 = r2.f1993XO
            java.lang.Integer r1 = java.lang.Integer.valueOf(r4)
            java.lang.Object r0 = r0.get(r1)
            java.util.List r0 = (java.util.List) r0
            if (r0 == 0) goto L97
            r1 = 1
            if (r6 == 0) goto L13
            r6[r4] = r1
        L13:
            r6 = 0
            if (r3 == 0) goto L32
            int r3 = r0.size()     // Catch: com.univocity.parsers.common.DataProcessingException -> L2e java.lang.Throwable -> L30
            int r3 = r3 - r1
        L1b:
            if (r3 < 0) goto L97
            java.lang.Object r1 = r0.get(r3)     // Catch: com.univocity.parsers.common.DataProcessingException -> L2e java.lang.Throwable -> L30
            xXo.Oxx0IOOO r1 = (xXo.Oxx0IOOO) r1     // Catch: com.univocity.parsers.common.DataProcessingException -> L2e java.lang.Throwable -> L30
            java.lang.Object r5 = r1.oIX0oI(r5)     // Catch: java.lang.Throwable -> L2b com.univocity.parsers.common.DataProcessingException -> L2e
            int r3 = r3 + (-1)
            r6 = r1
            goto L1b
        L2b:
            r3 = move-exception
            r6 = r1
            goto L4a
        L2e:
            r3 = move-exception
            goto L8d
        L30:
            r3 = move-exception
            goto L4a
        L32:
            java.util.Iterator r3 = r0.iterator()     // Catch: com.univocity.parsers.common.DataProcessingException -> L2e java.lang.Throwable -> L30
        L36:
            boolean r0 = r3.hasNext()     // Catch: com.univocity.parsers.common.DataProcessingException -> L2e java.lang.Throwable -> L30
            if (r0 == 0) goto L97
            java.lang.Object r0 = r3.next()     // Catch: com.univocity.parsers.common.DataProcessingException -> L2e java.lang.Throwable -> L30
            xXo.Oxx0IOOO r0 = (xXo.Oxx0IOOO) r0     // Catch: com.univocity.parsers.common.DataProcessingException -> L2e java.lang.Throwable -> L30
            java.lang.Object r5 = r0.oIX0oI(r5)     // Catch: com.univocity.parsers.common.DataProcessingException -> L2e java.lang.Throwable -> L48
            r6 = r0
            goto L36
        L48:
            r3 = move-exception
            r6 = r0
        L4a:
            java.lang.String r4 = "Error converting value '"
            if (r6 == 0) goto L73
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r4)
            r1.append(r5)
            java.lang.String r4 = "' using conversion "
            r1.append(r4)
            java.lang.Class r4 = r6.getClass()
            java.lang.String r4 = r4.getName()
            r1.append(r4)
            java.lang.String r4 = r1.toString()
            r0.<init>(r4, r3)
            throw r0
        L73:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r4)
            r0.append(r5)
            r4 = 39
            r0.append(r4)
            java.lang.String r4 = r0.toString()
            r6.<init>(r4, r3)
            throw r6
        L8d:
            r3.setValue(r5)
            r3.setColumnIndex(r4)
            r3.markAsNonFatal()
            throw r3
        L97:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: OXIOoo0X0.XO.II0XooXoX(boolean, int, java.lang.Object, boolean[]):java.lang.Object");
    }

    public void II0xO0(xXo.Oxx0IOOO<String, ?>... oxx0IOOOArr) {
        this.f1992X0o0xo.oxoX(oxx0IOOOArr);
    }

    public void Oxx0IOOO(boolean z, String[] strArr) {
        if ((this.f1991II0xO0.oIX0oI() && this.f1995oxoX.oIX0oI() && this.f1990I0Io.oIX0oI() && this.f1992X0o0xo.oIX0oI()) || !this.f1993XO.isEmpty()) {
            return;
        }
        this.f1993XO = new HashMap();
        for (xoIox xoiox : this.f1994oIX0oI) {
            this.f1991II0xO0.I0Io(z, xoiox, this.f1993XO, strArr);
            this.f1990I0Io.I0Io(z, xoiox, this.f1993XO, strArr);
            this.f1995oxoX.I0Io(z, xoiox, this.f1993XO, strArr);
            this.f1992X0o0xo.I0Io(z, xoiox, this.f1993XO, strArr);
        }
    }

    public OOXIXo<String> X0o0xo(xXo.Oxx0IOOO<String, ?>... oxx0IOOOArr) {
        return this.f1991II0xO0.oxoX(oxx0IOOOArr);
    }

    public xXo.Oxx0IOOO[] XO(int i, Class<?> cls) {
        List<xXo.Oxx0IOOO<?, ?>> list = this.f1993XO.get(Integer.valueOf(i));
        int i2 = 0;
        if (list != null) {
            xXo.Oxx0IOOO[] oxx0IOOOArr = new xXo.Oxx0IOOO[list.size()];
            Iterator<xXo.Oxx0IOOO<?, ?>> it = list.iterator();
            while (it.hasNext()) {
                oxx0IOOOArr[i2] = it.next();
                i2++;
            }
            return oxx0IOOOArr;
        }
        if (cls == String.class) {
            return f1989Oxx0IOOO;
        }
        xXo.Oxx0IOOO OOXIXo2 = x0OOI.oIX0oI.OOXIXo(cls, null);
        xXo.Oxx0IOOO[] oxx0IOOOArr2 = {OOXIXo2};
        if (OOXIXo2 == null) {
            return f1989Oxx0IOOO;
        }
        return oxx0IOOOArr2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v9, types: [java.lang.Object] */
    public Object oIX0oI(int i, String str, boolean[] zArr) {
        List<xXo.Oxx0IOOO<?, ?>> list = this.f1993XO.get(Integer.valueOf(i));
        if (list != null) {
            if (zArr != null) {
                zArr[i] = true;
            }
            for (xXo.Oxx0IOOO<?, ?> oxx0IOOO : list) {
                try {
                    str = oxx0IOOO.II0xO0(str);
                } catch (DataProcessingException e) {
                    e.setColumnIndex(i);
                    e.markAsNonFatal();
                    throw e;
                } catch (Throwable th) {
                    throw new IllegalStateException("Error converting value '" + str + "' using conversion " + oxx0IOOO.getClass().getName(), th);
                }
            }
        }
        return str;
    }

    public OOXIXo<Integer> oxoX(xXo.Oxx0IOOO<String, ?>... oxx0IOOOArr) {
        return this.f1990I0Io.oxoX(oxx0IOOOArr);
    }
}
