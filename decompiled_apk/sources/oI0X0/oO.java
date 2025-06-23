package oI0X0;

import com.baidu.mobads.sdk.api.PrerollVideoResponse;
import com.facebook.AuthenticationTokenClaims;

/* loaded from: classes6.dex */
public final class oO {

    /* renamed from: II0xO0, reason: collision with root package name */
    public String f31467II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public int f31468oIX0oI;

    /* renamed from: I0Io, reason: collision with root package name */
    public static oO[] f31463I0Io = new oO[0];

    /* renamed from: oxoX, reason: collision with root package name */
    public static final oO f31466oxoX = new oO(0, PrerollVideoResponse.NORMAL);

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final oO f31464X0o0xo = new oO(1, "super");

    /* renamed from: XO, reason: collision with root package name */
    public static final oO f31465XO = new oO(2, AuthenticationTokenClaims.JSON_KEY_SUB);

    public oO(int i, String str) {
        this.f31468oIX0oI = i;
        this.f31467II0xO0 = str;
        oO[] oOVarArr = f31463I0Io;
        oO[] oOVarArr2 = new oO[oOVarArr.length + 1];
        f31463I0Io = oOVarArr2;
        System.arraycopy(oOVarArr, 0, oOVarArr2, 0, oOVarArr.length);
        f31463I0Io[oOVarArr.length] = this;
    }

    public static oO II0xO0(int i) {
        int i2 = 0;
        while (true) {
            oO[] oOVarArr = f31463I0Io;
            if (i2 < oOVarArr.length) {
                if (oOVarArr[i2].I0Io() == i) {
                    return f31463I0Io[i2];
                }
                i2++;
            } else {
                return f31466oxoX;
            }
        }
    }

    public int I0Io() {
        return this.f31468oIX0oI;
    }

    public String oIX0oI() {
        return this.f31467II0xO0;
    }
}
