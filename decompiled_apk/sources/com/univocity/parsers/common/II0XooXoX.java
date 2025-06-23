package com.univocity.parsers.common;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes13.dex */
public abstract class II0XooXoX implements Oxx0IOOO {

    /* renamed from: I0Io, reason: collision with root package name */
    public boolean f27013I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public OXIOoo0X0.XO f27014II0xO0;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public oO f27015Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public boolean f27016X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public IXxxXO f27017XO = ooOOo0oXI.f27084oIX0oI;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public Map<Class<?>, xXo.Oxx0IOOO[]> f27018oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public int[] f27019oxoX;

    public final OXIOoo0X0.XO IIXOooo() {
        if (this.f27014II0xO0 == null) {
            this.f27014II0xO0 = new OXIOoo0X0.XO();
        }
        return this.f27014II0xO0;
    }

    public final boolean OxI(boolean z, Object[] objArr, String[] strArr, int[] iArr) {
        boolean[] zArr;
        boolean z2;
        int length;
        int[] iArr2;
        int i;
        if (this.f27018oIX0oI != null) {
            zArr = new boolean[objArr.length];
        } else {
            zArr = null;
        }
        OXIOoo0X0.XO xo2 = this.f27014II0xO0;
        if (xo2 != null) {
            if (!this.f27013I0Io) {
                this.f27013I0Io = true;
                if (strArr == null) {
                    strArr = new String[objArr.length];
                }
                xo2.Oxx0IOOO(true, strArr);
                this.f27019oxoX = iArr;
            }
            int[] iArr3 = this.f27019oxoX;
            if (iArr3 == null) {
                length = objArr.length;
            } else {
                length = iArr3.length;
            }
            z2 = true;
            for (int i2 = 0; i2 < length; i2++) {
                try {
                    iArr2 = this.f27019oxoX;
                } catch (Throwable th) {
                    xoXoI(th, objArr, i2);
                    z2 = false;
                }
                if (iArr2 != null && (i = iArr2[i2]) != -1) {
                    objArr[i] = this.f27014II0xO0.II0XooXoX(z, i, objArr[i], zArr);
                }
                objArr[i2] = this.f27014II0xO0.II0XooXoX(z, i2, objArr[i2], zArr);
            }
        } else {
            z2 = true;
        }
        if (z2 && zArr != null) {
            return oI0IIXIo(true, objArr, zArr);
        }
        return z2;
    }

    public final Object[] Oxx0xo(String[] strArr, oO oOVar) {
        boolean[] zArr;
        int length = strArr.length;
        Object[] objArr = new Object[length];
        if (this.f27018oIX0oI != null) {
            zArr = new boolean[strArr.length];
        } else {
            zArr = null;
        }
        System.arraycopy(strArr, 0, objArr, 0, strArr.length);
        boolean z = true;
        if (this.f27014II0xO0 != null) {
            if (!this.f27013I0Io) {
                o00(strArr, oOVar);
            }
            if (this.f27016X0o0xo || this.f27019oxoX != null) {
                length = this.f27019oxoX.length;
            }
            for (int i = 0; i < length; i++) {
                try {
                    if (!this.f27016X0o0xo) {
                        int[] iArr = this.f27019oxoX;
                        if (iArr == null) {
                            objArr[i] = this.f27014II0xO0.oIX0oI(i, strArr[i], zArr);
                        } else {
                            int i2 = iArr[i];
                            objArr[i2] = this.f27014II0xO0.oIX0oI(i2, strArr[i2], zArr);
                        }
                    } else {
                        objArr[i] = this.f27014II0xO0.oIX0oI(this.f27019oxoX[i], strArr[i], zArr);
                    }
                } catch (Throwable th) {
                    xoXoI(th, objArr, i);
                    z = false;
                }
            }
        }
        if (z && zArr != null) {
            z = oI0IIXIo(false, objArr, zArr);
        }
        if (!z) {
            return null;
        }
        return objArr;
    }

    public final Object OxxIIOOXO(boolean z, Object obj) {
        Map<Class<?>, xXo.Oxx0IOOO[]> map = this.f27018oIX0oI;
        if (map != null && obj != null) {
            xXo.Oxx0IOOO[] oxx0IOOOArr = map.get(obj.getClass());
            if (oxx0IOOOArr == null) {
                return obj;
            }
            int i = 0;
            if (z) {
                while (i < oxx0IOOOArr.length) {
                    obj = oxx0IOOOArr[i].oIX0oI(obj);
                    i++;
                }
            } else {
                while (i < oxx0IOOOArr.length) {
                    obj = oxx0IOOOArr[i].II0xO0(obj);
                    i++;
                }
            }
        }
        return obj;
    }

    @Override // com.univocity.parsers.common.Oxx0IOOO
    public final void X0o0xo(Class<?> cls, xXo.Oxx0IOOO... oxx0IOOOArr) {
        I0Io.x0xO0oo("Type to convert", cls);
        I0Io.x0xO0oo("Sequence of conversions to apply over data of type " + cls.getSimpleName(), oxx0IOOOArr);
        if (this.f27018oIX0oI == null) {
            this.f27018oIX0oI = new HashMap();
        }
        this.f27018oIX0oI.put(cls, oxx0IOOOArr);
    }

    public final void o00(String[] strArr, oO oOVar) {
        this.f27019oxoX = null;
        this.f27016X0o0xo = false;
        this.f27013I0Io = false;
        if (oOVar.X0o0xo() != null && oOVar.X0o0xo().length > 0) {
            this.f27014II0xO0.Oxx0IOOO(false, oOVar.X0o0xo());
        } else {
            this.f27014II0xO0.Oxx0IOOO(false, strArr);
        }
        this.f27019oxoX = oOVar.x0XOIxOo();
        this.f27016X0o0xo = oOVar.oOoXoXO();
    }

    public final boolean oI0IIXIo(boolean z, Object[] objArr, boolean[] zArr) {
        boolean z2 = true;
        for (int i = 0; i < objArr.length; i++) {
            if (!zArr[i]) {
                try {
                    objArr[i] = OxxIIOOXO(z, objArr[i]);
                } catch (Throwable th) {
                    xoXoI(th, objArr, i);
                    z2 = false;
                }
            }
        }
        return z2;
    }

    @Override // com.univocity.parsers.common.Oxx0IOOO
    public final OXIOoo0X0.OOXIXo<Integer> oIX0oI(xXo.Oxx0IOOO... oxx0IOOOArr) {
        return IIXOooo().oxoX(oxx0IOOOArr);
    }

    @Override // com.univocity.parsers.common.Oxx0IOOO
    public final OXIOoo0X0.OOXIXo<String> oxoX(xXo.Oxx0IOOO... oxx0IOOOArr) {
        return IIXOooo().X0o0xo(oxx0IOOOArr);
    }

    @Override // com.univocity.parsers.common.Oxx0IOOO
    public final void x0xO0oo(xXo.Oxx0IOOO... oxx0IOOOArr) {
        IIXOooo().II0xO0(oxx0IOOOArr);
    }

    public final void xoXoI(Throwable th, Object[] objArr, int i) {
        DataProcessingException dataProcessingException;
        if (th instanceof DataProcessingException) {
            dataProcessingException = (DataProcessingException) th;
            dataProcessingException.setRow(objArr);
            dataProcessingException.setColumnIndex(i);
        } else {
            dataProcessingException = new DataProcessingException("Error processing data conversions", i, objArr, th);
        }
        dataProcessingException.markAsNonFatal();
        dataProcessingException.setContext(this.f27015Oxx0IOOO);
        this.f27017XO.oIX0oI(dataProcessingException, objArr, this.f27015Oxx0IOOO);
    }
}
