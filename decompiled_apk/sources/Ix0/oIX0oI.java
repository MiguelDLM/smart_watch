package Ix0;

import O0OOX0IIx.oxoX;
import XxXX.X0o0xo;
import android.content.Context;
import android.os.Bundle;
import com.tencent.connect.common.oIX0oI;
import com.tencent.open.utils.HttpUtils;

/* loaded from: classes13.dex */
public class oIX0oI extends com.tencent.connect.common.oIX0oI {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final String f936oIX0oI = "https://openmobile.qq.com/oauth2.0/me";

    public oIX0oI(Context context, xIxooxXX.II0xO0 iI0xO0) {
        super(iI0xO0);
    }

    public void ooOOo0oXI(o0Oo.II0xO0 iI0xO0) {
        Bundle II0xO02 = II0xO0();
        II0xO02.putString(oxoX.f1381oxoX, "1");
        HttpUtils.oOoXoXO(this.c, X0o0xo.oIX0oI(), f936oIX0oI, II0xO02, "GET", new oIX0oI.C1086oIX0oI(iI0xO0));
    }
}
