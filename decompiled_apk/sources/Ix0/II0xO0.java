package Ix0;

import XxXX.X0o0xo;
import android.content.Context;
import com.tencent.connect.common.oIX0oI;
import com.tencent.open.utils.HttpUtils;

/* loaded from: classes13.dex */
public class II0xO0 extends com.tencent.connect.common.oIX0oI {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final String f935oIX0oI = "oauth2.0/m_me";

    public II0xO0(Context context, xIxooxXX.II0xO0 iI0xO0) {
        super(iI0xO0);
    }

    public void ooOOo0oXI(o0Oo.II0xO0 iI0xO0) {
        HttpUtils.oOoXoXO(this.c, X0o0xo.oIX0oI(), f935oIX0oI, II0xO0(), "GET", new oIX0oI.C1086oIX0oI(iI0xO0));
    }

    public void x0XOIxOo(o0Oo.II0xO0 iI0xO0) {
        HttpUtils.oOoXoXO(this.c, X0o0xo.oIX0oI(), "user/get_simple_userinfo", II0xO0(), "GET", new oIX0oI.C1086oIX0oI(iI0xO0));
    }

    public II0xO0(Context context, xIxooxXX.X0o0xo x0o0xo, xIxooxXX.II0xO0 iI0xO0) {
        super(x0o0xo, iI0xO0);
    }
}
