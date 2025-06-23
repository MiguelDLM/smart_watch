package oO0IXx;

import com.univocity.parsers.common.DataProcessingException;
import java.util.Arrays;
import java.util.Map;

/* loaded from: classes13.dex */
public abstract class IIX0o implements xXxxox0I<Object> {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public xXxxox0I f31877oIX0oI = null;

    /* renamed from: II0xO0, reason: collision with root package name */
    public int f31876II0xO0 = Integer.MIN_VALUE;

    public abstract String[] I0Io(Object obj);

    public abstract xXxxox0I<?> II0XooXoX(Object obj);

    public String[] II0xO0() {
        return null;
    }

    public int[] X0o0xo() {
        return null;
    }

    public final int XO() {
        if (this.f31876II0xO0 == Integer.MIN_VALUE) {
            this.f31876II0xO0 = 0;
            if (II0xO0() != null) {
                this.f31876II0xO0 = II0xO0().length;
            }
            if (X0o0xo() != null) {
                for (int i : X0o0xo()) {
                    int i2 = i + 1;
                    if (i2 > this.f31876II0xO0) {
                        this.f31876II0xO0 = i2;
                    }
                }
            }
        }
        return this.f31876II0xO0;
    }

    public abstract String oIX0oI();

    @Override // oO0IXx.xXxxox0I
    public Object[] oOoXoXO(Object obj, String[] strArr, int[] iArr) {
        xXxxox0I<?> II0XooXoX2 = II0XooXoX(obj);
        if (II0XooXoX2 != null) {
            xXxxox0I<?> xxxxox0i = this.f31877oIX0oI;
            if (II0XooXoX2 != xxxxox0i) {
                Oxx0IOOO(xxxxox0i, II0XooXoX2);
                this.f31877oIX0oI = II0XooXoX2;
            }
            String[] II0xO02 = II0xO0();
            int[] X0o0xo2 = X0o0xo();
            if (II0xO02 != null) {
                strArr = II0xO02;
            }
            if (X0o0xo2 != null) {
                iArr = X0o0xo2;
            }
            return this.f31877oIX0oI.oOoXoXO(obj, strArr, iArr);
        }
        DataProcessingException dataProcessingException = new DataProcessingException("Cannot find switch for input. Headers: " + Arrays.toString(strArr) + ", indexes to write: " + iArr + ". " + oIX0oI());
        dataProcessingException.setValue(obj);
        throw dataProcessingException;
    }

    public abstract String[] oxoX(Map map, Map map2);

    public void Oxx0IOOO(xXxxox0I<?> xxxxox0i, xXxxox0I<?> xxxxox0i2) {
    }
}
