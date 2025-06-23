package x0OxxIOxX;

import O0IxXx.II0XooXoX;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import com.baidu.ar.camera.CameraManager;
import com.baidu.navisdk.ui.widget.BNWebViewClient;
import com.huawei.hms.ads.dynamicloader.b;
import com.octopus.ad.NativeAdResponse;
import com.octopus.ad.R;
import com.octopus.ad.internal.Oxx0IOOO;
import com.octopus.ad.internal.i;
import com.octopus.ad.internal.l;
import com.octopus.ad.internal.xoIox;
import com.octopus.ad.model.II0xO0;
import com.octopus.ad.model.e;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import oOoIIO0.xoXoI;
import org.json.JSONException;
import org.json.JSONObject;
import x0.I0oOoX;
import x0.IO;
import x0.OI0;
import x0.ooXIXxIX;
import x0.x0o;
import x0.xI;
import xXoOI00O.X0o0xo;

@SuppressLint({"NewApi"})
/* loaded from: classes11.dex */
public class oIX0oI {

    /* renamed from: Ioxxx, reason: collision with root package name */
    public static final String f33872Ioxxx = "REWARD_ITEM";

    /* renamed from: OO0x0xX, reason: collision with root package name */
    public static final String f33873OO0x0xX = "ORIENTATION";

    /* renamed from: XIo0oOXIx, reason: collision with root package name */
    public static final String f33874XIo0oOXIx = "SCALE";

    /* renamed from: x0xO, reason: collision with root package name */
    public static final String f33875x0xO = "MRAID";

    /* renamed from: I0Io, reason: collision with root package name */
    public int f33876I0Io;

    /* renamed from: I0X0x0oIo, reason: collision with root package name */
    public String f33877I0X0x0oIo;

    /* renamed from: I0oOIX, reason: collision with root package name */
    public boolean f33878I0oOIX;

    /* renamed from: I0oOoX, reason: collision with root package name */
    public List<II0xO0.xxIXOIIO> f33879I0oOoX;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public boolean f33880II0XooXoX;

    /* renamed from: II0xO0, reason: collision with root package name */
    public int f33881II0xO0;

    /* renamed from: IIX0o, reason: collision with root package name */
    public String f33882IIX0o;

    /* renamed from: IIXOooo, reason: collision with root package name */
    public boolean f33883IIXOooo;

    /* renamed from: IO, reason: collision with root package name */
    public String f33884IO;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public boolean f33885IXxxXO;

    /* renamed from: Io, reason: collision with root package name */
    public II0xO0.C0895II0xO0 f33886Io;

    /* renamed from: IoOoX, reason: collision with root package name */
    public com.octopus.ad.internal.view.II0xO0 f33887IoOoX;

    /* renamed from: IoOoo, reason: collision with root package name */
    public boolean f33888IoOoo;

    /* renamed from: O0Xx, reason: collision with root package name */
    public String f33889O0Xx;

    /* renamed from: O0xOxO, reason: collision with root package name */
    public int f33890O0xOxO;

    /* renamed from: OI0, reason: collision with root package name */
    public X0xII0I.oIX0oI f33891OI0;

    /* renamed from: OO, reason: collision with root package name */
    public HashMap<String, Object> f33892OO;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public boolean f33893OOXIXo;

    /* renamed from: Oo, reason: collision with root package name */
    public int f33894Oo;

    /* renamed from: OxI, reason: collision with root package name */
    public boolean f33895OxI;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public int f33896Oxx0IOOO;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public int f33897Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public oxoX f33898OxxIIOOXO;

    /* renamed from: X00IoxXI, reason: collision with root package name */
    public int f33899X00IoxXI;

    /* renamed from: X0IIOO, reason: collision with root package name */
    public int f33900X0IIOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public int f33901X0o0xo;

    /* renamed from: XI0IXoo, reason: collision with root package name */
    public String f33902XI0IXoo;

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    public int f33903XIxXXX0x0;

    /* renamed from: XO, reason: collision with root package name */
    public int f33904XO;

    /* renamed from: XOxIOxOx, reason: collision with root package name */
    public String f33905XOxIOxOx;

    /* renamed from: XX, reason: collision with root package name */
    public II0xO0.IIXOooo f33906XX;

    /* renamed from: XX0, reason: collision with root package name */
    public String f33907XX0;

    /* renamed from: Xo0, reason: collision with root package name */
    public String f33908Xo0;

    /* renamed from: XoI0Ixx0, reason: collision with root package name */
    public String f33909XoI0Ixx0;

    /* renamed from: XoX, reason: collision with root package name */
    public String f33910XoX;

    /* renamed from: Xx000oIo, reason: collision with root package name */
    public II0xO0.C0895II0xO0.oIX0oI f33911Xx000oIo;

    /* renamed from: XxX0x0xxx, reason: collision with root package name */
    public boolean f33912XxX0x0xxx;

    /* renamed from: o0, reason: collision with root package name */
    public II0xO0.ooOOo0oXI f33913o0;

    /* renamed from: o00, reason: collision with root package name */
    public boolean f33914o00;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public oxoX f33915oI0IIXIo;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public e.a f33916oIX0oI;

    /* renamed from: oO, reason: collision with root package name */
    public boolean f33917oO;

    /* renamed from: oOXoIIIo, reason: collision with root package name */
    public II0xO0.C0895II0xO0.C0896II0xO0 f33918oOXoIIIo;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public boolean f33919oOoXoXO;

    /* renamed from: oX, reason: collision with root package name */
    public String f33920oX;

    /* renamed from: oo, reason: collision with root package name */
    public X0o0xo f33921oo;

    /* renamed from: oo0xXOI0I, reason: collision with root package name */
    public IXO.oIX0oI f33922oo0xXOI0I;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public boolean f33923ooOOo0oXI;

    /* renamed from: ooXIXxIX, reason: collision with root package name */
    public String f33924ooXIXxIX;

    /* renamed from: oxXx0IX, reason: collision with root package name */
    public long f33925oxXx0IX;

    /* renamed from: oxoX, reason: collision with root package name */
    public int f33926oxoX;

    /* renamed from: oxxXoxO, reason: collision with root package name */
    public String f33927oxxXoxO;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public boolean f33928x0XOIxOo;

    /* renamed from: x0o, reason: collision with root package name */
    public String f33929x0o;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public int f33930x0xO0oo;

    /* renamed from: xI, reason: collision with root package name */
    public String f33931xI;

    /* renamed from: xII, reason: collision with root package name */
    public String f33932xII;

    /* renamed from: xXOx, reason: collision with root package name */
    public List<Pair<i, String>> f33933xXOx;

    /* renamed from: xXxxox0I, reason: collision with root package name */
    public boolean f33934xXxxox0I;

    /* renamed from: xo0x, reason: collision with root package name */
    public l f33935xo0x;

    /* renamed from: xoIox, reason: collision with root package name */
    public boolean f33936xoIox;

    /* renamed from: xoIxX, reason: collision with root package name */
    public boolean f33937xoIxX;

    /* renamed from: xoXoI, reason: collision with root package name */
    public boolean f33938xoXoI;

    /* renamed from: xoxXI, reason: collision with root package name */
    public LinkedList<String> f33939xoxXI;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public boolean f33940xxIXOIIO;

    /* renamed from: xxX, reason: collision with root package name */
    public boolean f33941xxX;

    /* loaded from: classes11.dex */
    public class I0Io implements ooXIXxIX.II0xO0 {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final /* synthetic */ xoXoI f33943oIX0oI;

        public I0Io(xoXoI xoxoi) {
            this.f33943oIX0oI = xoxoi;
        }

        @Override // x0.ooXIXxIX.II0xO0
        public void oIX0oI(boolean z, String str) {
            xoXoI xoxoi = this.f33943oIX0oI;
            if (xoxoi != null) {
                xoxoi.a(z);
            }
        }
    }

    /* loaded from: classes11.dex */
    public class II0xO0 implements Runnable {
        public II0xO0() {
        }

        @Override // java.lang.Runnable
        public void run() {
            II0XooXoX II0XooXoX2 = xoIox.oIX0oI().II0XooXoX();
            Iterator it = oIX0oI.this.f33939xoxXI.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                if (II0XooXoX2 != null && !II0XooXoX2.ooOOo0oXI(str)) {
                    InputStream inputStream = null;
                    try {
                        try {
                            inputStream = new URL(II0XooXoX2.oIX0oI(str)).openStream();
                            do {
                            } while (inputStream.read(new byte[1024]) != -1);
                            inputStream.close();
                            inputStream.close();
                        } catch (Throwable th) {
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    } catch (IOException unused) {
                        if (oIX0oI.this.f33887IoOoX != null) {
                            oIX0oI.this.f33887IoOoX.a();
                        }
                        com.octopus.ad.internal.utilities.oIX0oI.ooXIXxIX(com.octopus.ad.internal.utilities.oIX0oI.f18685II0xO0, "preload fail:" + str);
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
    }

    /* renamed from: x0OxxIOxX.oIX0oI$oIX0oI, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class C1146oIX0oI implements ooXIXxIX.II0xO0 {
        public C1146oIX0oI() {
        }

        @Override // x0.ooXIXxIX.II0xO0
        public void oIX0oI(boolean z, String str) {
            if (z && !TextUtils.isEmpty(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    oIX0oI.this.f33931xI = jSONObject.optString("data");
                    oIX0oI.this.oOoXoXO();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    public static class oxoX {

        /* renamed from: I0Io, reason: collision with root package name */
        public static int f33946I0Io = 0;

        /* renamed from: oxoX, reason: collision with root package name */
        public static int f33947oxoX = 1;

        /* renamed from: II0xO0, reason: collision with root package name */
        public int f33948II0xO0 = 0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public String f33949oIX0oI;

        public String I0Io() {
            return this.f33949oIX0oI;
        }

        public final void X0o0xo(String str) {
            this.f33949oIX0oI = str;
        }

        public final void XO(int i) {
            this.f33948II0xO0 = i;
        }

        public int oxoX() {
            return this.f33948II0xO0;
        }
    }

    public oIX0oI(xI xIVar, l lVar) {
        this.f33881II0xO0 = 0;
        this.f33876I0Io = 1;
        this.f33926oxoX = 0;
        this.f33901X0o0xo = 0;
        this.f33904XO = 0;
        this.f33896Oxx0IOOO = 0;
        this.f33880II0XooXoX = false;
        this.f33940xxIXOIIO = false;
        this.f33936xoIox = false;
        this.f33893OOXIXo = true;
        this.f33919oOoXoXO = false;
        this.f33923ooOOo0oXI = false;
        this.f33928x0XOIxOo = false;
        this.f33917oO = false;
        this.f33930x0xO0oo = 0;
        this.f33894Oo = 0;
        this.f33885IXxxXO = false;
        this.f33897Oxx0xo = 0;
        this.f33915oI0IIXIo = new oxoX();
        this.f33898OxxIIOOXO = new oxoX();
        this.f33883IIXOooo = false;
        this.f33941xxX = false;
        this.f33912XxX0x0xxx = false;
        this.f33934xXxxox0I = true;
        this.f33933xXOx = new LinkedList();
        this.f33939xoxXI = new LinkedList<>();
        this.f33892OO = new HashMap<>();
        this.f33888IoOoo = false;
        this.f33937xoIxX = false;
        this.f33935xo0x = lVar;
        Oxx0IOOO(xIVar.II0xO0());
        try {
            XO(II0xO0.Oxx0xo.I0Io(xIVar.I0Io().toByteArray()));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public final void I0Io(int i, boolean z, boolean z2) {
        List<II0xO0.xxIXOIIO> XI0IXoo2;
        II0xO0.C0895II0xO0 c0895II0xO0 = this.f33886Io;
        if (c0895II0xO0 != null && (XI0IXoo2 = c0895II0xO0.XI0IXoo()) != null) {
            for (int i2 = 0; i2 < XI0IXoo2.size(); i2++) {
                II0xO0.xxIXOIIO xxixoiio = XI0IXoo2.get(i2);
                if (xxixoiio != null && !TextUtils.isEmpty(xxixoiio.Oxx0IOOO())) {
                    String Oxx0IOOO2 = xxixoiio.Oxx0IOOO();
                    if (Oxx0IOOO2.startsWith("http://v.adintl.cn/deepLink")) {
                        if (z) {
                            Oxx0IOOO2 = Oxx0IOOO2 + "&opt=10";
                        } else if (z2) {
                            Oxx0IOOO2 = Oxx0IOOO2 + "&opt=1";
                        } else if (i != 0) {
                            Oxx0IOOO2 = Oxx0IOOO2 + "&opt=" + i;
                        } else if (!this.f33934xXxxox0I) {
                            Oxx0IOOO2 = Oxx0IOOO2 + "&opt=11";
                        }
                    }
                    new Oxx0IOOO(Oxx0IOOO2).XO();
                }
            }
        }
    }

    public boolean I0X0x0oIo() {
        return this.f33928x0XOIxOo;
    }

    public boolean I0oOIX() {
        return this.f33917oO;
    }

    public II0xO0.C0895II0xO0.C0896II0xO0 I0oOoX() {
        return this.f33918oOXoIIIo;
    }

    public int IIX0o() {
        return this.f33900X0IIOO;
    }

    public final boolean IIXOooo(II0xO0.Oxx0xo oxx0xo) {
        int i;
        if (oxx0xo.oIX0oI() > 0) {
            II0xO0.OxxIIOOXO oxxIIOOXO = oxx0xo.IXxxXO().get(0);
            List<II0xO0.oxoX> oxxXoxO2 = oxxIIOOXO.oxxXoxO();
            if (oxxXoxO2 != null && oxxXoxO2.size() > 0) {
                II0xO0.oxoX oxox = oxxXoxO2.get(0);
                if (oxox.oOoXoXO() != null) {
                    II0xO0.C0895II0xO0 oOoXoXO2 = oxox.oOoXoXO();
                    X0o0xo(oOoXoXO2);
                    this.f33908Xo0 = oOoXoXO2.oIX0oI();
                    this.f33889O0Xx = oOoXoXO2.xoXoI();
                    II0xO0.xxIXOIIO o002 = oOoXoXO2.o00();
                    if (o002 != null && !TextUtils.isEmpty(o002.oIX0oI())) {
                        this.f33907XX0 = o002.oIX0oI();
                    }
                    if (o002 != null && !TextUtils.isEmpty(o002.I0Io())) {
                        this.f33877I0X0x0oIo = o002.I0Io();
                    }
                    if (o002 != null && !TextUtils.isEmpty(o002.oO())) {
                        this.f33920oX = o002.oO();
                    }
                }
            }
            this.f33916oIX0oI = oxxIIOOXO.OOXIXo();
            this.f33881II0xO0 = oxxIIOOXO.oO();
            this.f33931xI = oxxIIOOXO.Oxx0xo();
            if (oxxIIOOXO.xoXoI() == e.h.PORTRAIT) {
                i = 1;
            } else {
                i = 2;
            }
            this.f33876I0Io = i;
            this.f33904XO = Integer.parseInt(oxxIIOOXO.XxX0x0xxx());
            this.f33896Oxx0IOOO = Integer.parseInt(oxxIIOOXO.ooXIXxIX());
            this.f33900X0IIOO = oxxIIOOXO.X0IIOO();
            List<II0xO0.oxoX> oxxXoxO3 = oxxIIOOXO.oxxXoxO();
            if (oxxXoxO3 != null && oxxXoxO3.size() > 0) {
                this.f33890O0xOxO = oxxXoxO3.get(0).IXxxXO();
                this.f33902XI0IXoo = oxxXoxO3.get(0).Oxx0xo();
                this.f33925oxXx0IX = oxxXoxO3.get(0).xoIox();
            }
            this.f33926oxoX = 0;
            this.f33901X0o0xo = 0;
            if (oxxIIOOXO.oo0xXOI0I() != null && XIxXXX0x0() == e.a.ADP_TABLE) {
                II0xO0.XO oo0xXOI0I2 = oxxIIOOXO.oo0xXOI0I();
                this.f33926oxoX = Integer.parseInt(oo0xXOI0I2.oIX0oI());
                this.f33901X0o0xo = Integer.parseInt(oo0xXOI0I2.I0Io());
            }
        }
        return false;
    }

    public LinkedList<String> IO() {
        return this.f33939xoxXI;
    }

    public boolean IXxxXO() {
        return this.f33888IoOoo;
    }

    public oxoX Io() {
        return this.f33915oI0IIXIo;
    }

    public oxoX IoOoX() {
        return this.f33898OxxIIOOXO;
    }

    public boolean IoOoo() {
        return this.f33919oOoXoXO;
    }

    public void Ioxxx(int i) {
        this.f33876I0Io = i;
    }

    public void O00XxXI(boolean z) {
        this.f33941xxX = z;
    }

    public boolean O0Xx() {
        return this.f33934xXxxox0I;
    }

    public String O0xOxO() {
        return this.f33910XoX;
    }

    public String OI0() {
        return this.f33902XI0IXoo;
    }

    public boolean OO() {
        II0xO0.IIXOooo iIXOooo = this.f33906XX;
        if (iIXOooo != null && iIXOooo.ooOOo0oXI() != null && this.f33906XX.ooOOo0oXI().oIX0oI() == 1) {
            return true;
        }
        return false;
    }

    public void OO0x0xX(int i, String str, String str2) {
        List<II0xO0.xxIXOIIO> XI0IXoo2;
        II0xO0.C0895II0xO0 c0895II0xO0 = this.f33886Io;
        if (c0895II0xO0 != null && (XI0IXoo2 = c0895II0xO0.XI0IXoo()) != null) {
            for (int i2 = 0; i2 < XI0IXoo2.size(); i2++) {
                II0xO0.xxIXOIIO xxixoiio = XI0IXoo2.get(i2);
                if (xxixoiio != null && !TextUtils.isEmpty(xxixoiio.ooOOo0oXI())) {
                    new Oxx0IOOO(OI0.I0Io(xxixoiio.ooOOo0oXI(), i, str, str2)).XO();
                }
            }
        }
    }

    public final boolean Oo(II0xO0.Oxx0xo oxx0xo) {
        int i;
        if (oxx0xo.oIX0oI() > 0) {
            II0xO0.OxxIIOOXO oxxIIOOXO = oxx0xo.IXxxXO().get(0);
            this.f33916oIX0oI = oxxIIOOXO.OOXIXo();
            this.f33881II0xO0 = oxxIIOOXO.oO();
            this.f33931xI = oxxIIOOXO.Oxx0xo();
            if (oxxIIOOXO.xoXoI() == e.h.PORTRAIT) {
                i = 1;
            } else {
                i = 2;
            }
            this.f33876I0Io = i;
            this.f33896Oxx0IOOO = Integer.parseInt(oxxIIOOXO.XxX0x0xxx());
            this.f33904XO = Integer.parseInt(oxxIIOOXO.ooXIXxIX());
            if (oxxIIOOXO.oo0xXOI0I() != null && (XIxXXX0x0() == e.a.ADP_TABLE || XIxXXX0x0() == e.a.ADP_CUSTOMER)) {
                II0xO0.XO oo0xXOI0I2 = oxxIIOOXO.oo0xXOI0I();
                this.f33926oxoX = Integer.parseInt(oo0xXOI0I2.oIX0oI());
                this.f33901X0o0xo = Integer.parseInt(oo0xXOI0I2.I0Io());
            } else if (!x0o.II0XooXoX(oxxIIOOXO.oIX0oI()) && XIxXXX0x0() == e.a.ADP_IVIDEO) {
                xoIox(f33872Ioxxx, oxxIIOOXO.oIX0oI());
            }
            this.f33880II0XooXoX = oxxIIOOXO.XOxIOxOx();
            this.f33940xxIXOIIO = oxxIIOOXO.OI0();
            this.f33936xoIox = oxxIIOOXO.Io();
            this.f33893OOXIXo = oxxIIOOXO.xII();
            this.f33919oOoXoXO = oxxIIOOXO.XX();
            this.f33923ooOOo0oXI = oxxIIOOXO.x0o();
            this.f33928x0XOIxOo = oxxIIOOXO.oOXoIIIo();
            this.f33917oO = oxxIIOOXO.X00IoxXI();
            this.f33930x0xO0oo = oxxIIOOXO.IO();
            this.f33894Oo = oxxIIOOXO.Xx000oIo();
            this.f33885IXxxXO = oxxIIOOXO.o0();
            this.f33913o0 = oxxIIOOXO.oo();
            this.f33906XX = oxxIIOOXO.IoOoX();
            this.f33903XIxXXX0x0 = oxxIIOOXO.I0oOoX();
            this.f33900X0IIOO = oxxIIOOXO.X0IIOO();
            List<II0xO0.oxoX> oxxXoxO2 = oxxIIOOXO.oxxXoxO();
            if (oxxXoxO2 != null && oxxXoxO2.size() > 0) {
                this.f33890O0xOxO = oxxXoxO2.get(0).IXxxXO();
                this.f33902XI0IXoo = oxxXoxO2.get(0).Oxx0xo();
                this.f33925oxXx0IX = oxxXoxO2.get(0).xoIox();
            }
            if (this.f33880II0XooXoX && this.f33896Oxx0IOOO == 0 && this.f33904XO == 0) {
                this.f33896Oxx0IOOO = CameraManager.DEFAULTHEIGHT;
                this.f33904XO = 1280;
            }
            if (oxxIIOOXO.XoX() > 0) {
                int i2 = 0;
                for (II0xO0.oxoX oxox : oxxIIOOXO.oxxXoxO()) {
                    if (i2 == 0) {
                        this.f33910XoX = oxox.II0XooXoX();
                        o0IXXIx.II0XooXoX.oIX0oI("OctopusAd", "mAdid = " + this.f33910XoX);
                    }
                    if (oxox.Oo() <= 0 || oxox.x0xO0oo().get(0) == null) {
                        this.f33927oxxXoxO = oxox.oIX0oI();
                        II0xO0.I0Io x0XOIxOo2 = oxox.x0XOIxOo();
                        if (x0XOIxOo2 != null) {
                            if (!TextUtils.isEmpty(x0XOIxOo2.oIX0oI())) {
                                this.f33915oI0IIXIo.X0o0xo(x0XOIxOo2.oIX0oI());
                                this.f33915oI0IIXIo.XO(oxoX.f33946I0Io);
                            } else {
                                this.f33915oI0IIXIo.X0o0xo(x0XOIxOo2.I0Io());
                                this.f33915oI0IIXIo.XO(oxoX.f33947oxoX);
                            }
                            if (!TextUtils.isEmpty(x0XOIxOo2.X0o0xo())) {
                                this.f33898OxxIIOOXO.X0o0xo(x0XOIxOo2.X0o0xo());
                                this.f33898OxxIIOOXO.XO(oxoX.f33946I0Io);
                            } else {
                                this.f33898OxxIIOOXO.X0o0xo(x0XOIxOo2.Oxx0IOOO());
                                this.f33898OxxIIOOXO.XO(oxoX.f33947oxoX);
                            }
                        }
                        if (oxox.ooOOo0oXI() > 0) {
                            for (II0xO0.oIX0oI oix0oi : oxox.oO()) {
                                if (this.f33893OOXIXo) {
                                    for (int i3 = 0; i3 < oix0oi.Oxx0IOOO(); i3++) {
                                        if (!x0o.II0XooXoX(oix0oi.XO().get(i3).oIX0oI())) {
                                            this.f33939xoxXI.add(oix0oi.XO().get(i3).I0Io());
                                        }
                                    }
                                }
                                if ((oix0oi.oIX0oI() == e.f.RENDER_VIDEO || oix0oi.oIX0oI() == e.f.RENDER_VAST_VIDEO) && oix0oi.Oxx0IOOO() > 0) {
                                    this.f33933xXOx.add(Pair.create(i.VIDEO, oix0oi.XO().get(0).I0Io()));
                                } else {
                                    String oIX0oI2 = oIX0oI(oix0oi);
                                    this.f33933xXOx.add(Pair.create(i.HTML, oIX0oI2));
                                    if (oIX0oI2.contains("mraid.js")) {
                                        xoIox(f33875x0xO, Boolean.TRUE);
                                    }
                                }
                            }
                        }
                        if (oxox.oOoXoXO() != null) {
                            II0xO0.C0895II0xO0 oOoXoXO2 = oxox.oOoXoXO();
                            X0o0xo(oOoXoXO2);
                            this.f33908Xo0 = oOoXoXO2.oIX0oI();
                            this.f33889O0Xx = oOoXoXO2.xoXoI();
                            this.f33878I0oOIX = oOoXoXO2.OxI();
                            this.f33909XoI0Ixx0 = oOoXoXO2.xxIXOIIO();
                            II0xO0.xxIXOIIO o002 = oOoXoXO2.o00();
                            if (o002 != null && !TextUtils.isEmpty(o002.oIX0oI())) {
                                this.f33907XX0 = o002.oIX0oI();
                            }
                            if (o002 != null && !TextUtils.isEmpty(o002.I0Io())) {
                                this.f33877I0X0x0oIo = o002.I0Io();
                            }
                            if (o002 != null && !TextUtils.isEmpty(o002.oO())) {
                                this.f33920oX = o002.oO();
                            }
                        }
                    }
                    i2++;
                    if (!this.f33933xXOx.isEmpty()) {
                        break;
                    }
                }
            }
        } else {
            com.octopus.ad.internal.utilities.oIX0oI.oxoX(com.octopus.ad.internal.utilities.oIX0oI.f18697XO, com.octopus.ad.internal.utilities.oIX0oI.xxIXOIIO(R.string.blank_ad));
        }
        if (this.f33933xXOx.isEmpty()) {
            return false;
        }
        this.f33888IoOoo = true;
        return true;
    }

    public String OxI() {
        return this.f33927oxxXoxO;
    }

    public final void Oxx0IOOO(Map<String, List<String>> map) {
        if (map != null) {
            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                if (entry.getKey() != null) {
                    for (String str : entry.getValue()) {
                        if (!TextUtils.isEmpty(str)) {
                            com.octopus.ad.internal.utilities.oIX0oI.ooXIXxIX(com.octopus.ad.internal.utilities.oIX0oI.f18697XO, com.octopus.ad.internal.utilities.oIX0oI.Oxx0xo(R.string.response_header, entry.getKey(), str));
                        }
                    }
                }
            }
        }
    }

    public final boolean Oxx0xo(II0xO0.Oxx0xo oxx0xo) {
        if (oxx0xo.oIX0oI() > 0) {
            for (II0xO0.OxxIIOOXO oxxIIOOXO : oxx0xo.IXxxXO()) {
                this.f33893OOXIXo = oxxIIOOXO.xII();
                if (oxxIIOOXO.XoX() > 0) {
                    for (II0xO0.oxoX oxox : oxxIIOOXO.oxxXoxO()) {
                        if (oxox.Oo() <= 0 || oxox.x0xO0oo().get(0) == null) {
                            if (oxox.ooOOo0oXI() > 0) {
                                for (II0xO0.oIX0oI oix0oi : oxox.oO()) {
                                    if (this.f33893OOXIXo) {
                                        for (int i = 0; i < oix0oi.Oxx0IOOO(); i++) {
                                            if (!x0o.II0XooXoX(oix0oi.XO().get(i).oIX0oI())) {
                                                this.f33939xoxXI.add(oix0oi.XO().get(i).I0Io());
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        if (this.f33939xoxXI.isEmpty()) {
            return false;
        }
        this.f33888IoOoo = true;
        return true;
    }

    public final boolean OxxIIOOXO(II0xO0.Oxx0xo oxx0xo) {
        int i;
        String str;
        if (oxx0xo.oIX0oI() > 0) {
            II0xO0.OxxIIOOXO oxxIIOOXO = oxx0xo.IXxxXO().get(0);
            this.f33916oIX0oI = oxxIIOOXO.OOXIXo();
            this.f33881II0xO0 = oxxIIOOXO.oO();
            this.f33931xI = oxxIIOOXO.Oxx0xo();
            if (oxxIIOOXO.xoXoI() == e.h.PORTRAIT) {
                i = 1;
            } else {
                i = 2;
            }
            this.f33876I0Io = i;
            this.f33896Oxx0IOOO = Integer.parseInt(oxxIIOOXO.XxX0x0xxx());
            this.f33904XO = Integer.parseInt(oxxIIOOXO.ooXIXxIX());
            this.f33900X0IIOO = oxxIIOOXO.X0IIOO();
            List<II0xO0.oxoX> oxxXoxO2 = oxxIIOOXO.oxxXoxO();
            if (oxxXoxO2 != null && oxxXoxO2.size() > 0) {
                this.f33890O0xOxO = oxxXoxO2.get(0).IXxxXO();
                this.f33902XI0IXoo = oxxXoxO2.get(0).Oxx0xo();
                this.f33925oxXx0IX = oxxXoxO2.get(0).xoIox();
            }
            this.f33880II0XooXoX = oxxIIOOXO.XOxIOxOx();
            this.f33940xxIXOIIO = oxxIIOOXO.OI0();
            this.f33936xoIox = oxxIIOOXO.Io();
            this.f33893OOXIXo = oxxIIOOXO.xII();
            this.f33919oOoXoXO = oxxIIOOXO.XX();
            this.f33923ooOOo0oXI = oxxIIOOXO.x0o();
            this.f33928x0XOIxOo = oxxIIOOXO.oOXoIIIo();
            this.f33917oO = oxxIIOOXO.X00IoxXI();
            this.f33930x0xO0oo = oxxIIOOXO.IO();
            this.f33894Oo = oxxIIOOXO.Xx000oIo();
            this.f33885IXxxXO = oxxIIOOXO.o0();
            this.f33913o0 = oxxIIOOXO.oo();
            this.f33906XX = oxxIIOOXO.IoOoX();
            this.f33903XIxXXX0x0 = oxxIIOOXO.I0oOoX();
            if (this.f33880II0XooXoX && this.f33896Oxx0IOOO == 0 && this.f33904XO == 0) {
                this.f33896Oxx0IOOO = CameraManager.DEFAULTHEIGHT;
                this.f33904XO = 1280;
            }
            if (oxxIIOOXO.XoX() > 0) {
                for (II0xO0.oxoX oxox : oxxIIOOXO.oxxXoxO()) {
                    if (oxox.Oo() <= 0 || oxox.x0xO0oo().get(0) == null) {
                        this.f33927oxxXoxO = oxox.oIX0oI();
                        if (oxox.ooOOo0oXI() >= 0) {
                            for (II0xO0.oIX0oI oix0oi : oxox.oO()) {
                                if (this.f33893OOXIXo) {
                                    for (int i2 = 0; i2 < oix0oi.Oxx0IOOO(); i2++) {
                                        if (!x0o.II0XooXoX(oix0oi.XO().get(i2).oIX0oI())) {
                                            this.f33939xoxXI.add(oix0oi.XO().get(i2).I0Io());
                                        }
                                    }
                                }
                                if (oix0oi.oIX0oI() == e.f.RENDER_JSON || oix0oi.oIX0oI() == e.f.RENDER_VIDEO) {
                                    if (oix0oi.Oxx0IOOO() > 0) {
                                        try {
                                            II0xO0.I0Io x0XOIxOo2 = oxox.x0XOIxOo();
                                            if (x0XOIxOo2 != null) {
                                                if (!TextUtils.isEmpty(x0XOIxOo2.oIX0oI())) {
                                                    this.f33915oI0IIXIo.X0o0xo(x0XOIxOo2.oIX0oI());
                                                    this.f33915oI0IIXIo.XO(oxoX.f33946I0Io);
                                                } else {
                                                    this.f33915oI0IIXIo.X0o0xo(x0XOIxOo2.I0Io());
                                                    this.f33915oI0IIXIo.XO(oxoX.f33947oxoX);
                                                }
                                                if (!TextUtils.isEmpty(x0XOIxOo2.X0o0xo())) {
                                                    this.f33898OxxIIOOXO.X0o0xo(x0XOIxOo2.X0o0xo());
                                                    this.f33898OxxIIOOXO.XO(oxoX.f33946I0Io);
                                                } else {
                                                    this.f33898OxxIIOOXO.X0o0xo(x0XOIxOo2.Oxx0IOOO());
                                                    this.f33898OxxIIOOXO.XO(oxoX.f33947oxoX);
                                                }
                                            }
                                            X0o0xo oo0xXOI0I2 = X0o0xo.oo0xXOI0I(new JSONObject(oix0oi.X0o0xo()));
                                            this.f33921oo = oo0xXOI0I2;
                                            oo0xXOI0I2.oxxXoxO(this);
                                            this.f33921oo.oo(IIX0o());
                                            this.f33921oo.xoxXI(IoOoX());
                                            this.f33921oo.I0oOoX(Io());
                                            if (oix0oi.oIX0oI() == e.f.RENDER_VIDEO) {
                                                this.f33921oo.xo0x(true);
                                            }
                                            if (oxox.oOoXoXO() != null) {
                                                X0o0xo(oxox.oOoXoXO());
                                                II0xO0.C0895II0xO0 oOoXoXO2 = oxox.oOoXoXO();
                                                this.f33908Xo0 = oOoXoXO2.oIX0oI();
                                                this.f33909XoI0Ixx0 = oOoXoXO2.xxIXOIIO();
                                                this.f33878I0oOIX = oOoXoXO2.OxI();
                                                this.f33889O0Xx = oOoXoXO2.xoXoI();
                                                X0o0xo x0o0xo = this.f33921oo;
                                                if (!x0o.II0XooXoX(this.f33908Xo0)) {
                                                    str = this.f33908Xo0;
                                                } else {
                                                    str = this.f33889O0Xx;
                                                }
                                                x0o0xo.I0oOIX(str);
                                                this.f33921oo.Io(oxox.oOoXoXO());
                                                II0xO0.xxIXOIIO o002 = oOoXoXO2.o00();
                                                if (o002 != null && !TextUtils.isEmpty(o002.oIX0oI())) {
                                                    this.f33921oo.Ioxxx(o002.oIX0oI());
                                                }
                                                if (o002 != null && !TextUtils.isEmpty(o002.I0Io())) {
                                                    this.f33921oo.ox(o002.I0Io());
                                                }
                                                List<II0xO0.xxIXOIIO> XI0IXoo2 = oOoXoXO2.XI0IXoo();
                                                if (XI0IXoo2 != null && XI0IXoo2.size() > 0) {
                                                    for (int i3 = 0; i3 < XI0IXoo2.size(); i3++) {
                                                        String I0Io2 = XI0IXoo2.get(i3).I0Io();
                                                        if (!TextUtils.isEmpty(I0Io2)) {
                                                            this.f33921oo.ox(I0Io2);
                                                        }
                                                        String oIX0oI2 = XI0IXoo2.get(i3).oIX0oI();
                                                        if (!TextUtils.isEmpty(oIX0oI2)) {
                                                            this.f33921oo.Ioxxx(oIX0oI2);
                                                        }
                                                    }
                                                }
                                            }
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                        if (this.f33921oo != null) {
                                            this.f33888IoOoo = true;
                                            return true;
                                        }
                                    } else {
                                        continue;
                                    }
                                }
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
        } else {
            com.octopus.ad.internal.utilities.oIX0oI.oxoX(com.octopus.ad.internal.utilities.oIX0oI.f18697XO, com.octopus.ad.internal.utilities.oIX0oI.xxIXOIIO(R.string.blank_ad));
        }
        if (this.f33933xXOx.isEmpty()) {
            return false;
        }
        this.f33888IoOoo = true;
        return true;
    }

    public NativeAdResponse X00IoxXI() {
        return this.f33921oo;
    }

    public II0xO0.C0895II0xO0 X0IIOO() {
        return this.f33886Io;
    }

    public final void X0o0xo(II0xO0.C0895II0xO0 c0895II0xO0) {
        this.f33886Io = c0895II0xO0;
        this.f33879I0oOoX = c0895II0xO0.XI0IXoo();
        this.f33918oOXoIIIo = c0895II0xO0.X0IIOO();
        this.f33911Xx000oIo = c0895II0xO0.O0xOxO();
        this.f33899X00IoxXI = c0895II0xO0.oOoXoXO();
        this.f33884IO = c0895II0xO0.x0XOIxOo();
        this.f33932xII = c0895II0xO0.x0xO0oo();
        this.f33929x0o = c0895II0xO0.IXxxXO();
        this.f33905XOxIOxOx = c0895II0xO0.oI0IIXIo();
        this.f33891OI0 = c0895II0xO0.IIXOooo();
        if (TextUtils.isEmpty(this.f33932xII)) {
            this.f33932xII = "octopus";
        }
        if (TextUtils.isEmpty(this.f33884IO)) {
            this.f33884IO = "Octopus";
        }
        if (TextUtils.isEmpty(this.f33929x0o)) {
            this.f33929x0o = "Ad Download";
        }
        if (!TextUtils.isEmpty(this.f33931xI)) {
            if (!this.f33931xI.startsWith(BNWebViewClient.URL_HTTPS_PREFIX) && !this.f33931xI.startsWith(BNWebViewClient.URL_HTTP_PREFIX)) {
                oOoXoXO();
            } else {
                new Oxx0IOOO(this.f33931xI).xoIox(new C1146oIX0oI()).XO();
            }
        }
    }

    public int XI0IXoo() {
        return this.f33876I0Io;
    }

    public void XI0oooXX(boolean z) {
        this.f33883IIXOooo = z;
    }

    public void XIo0oOXIx(int i) {
        List<II0xO0.xxIXOIIO> XI0IXoo2;
        II0xO0.C0895II0xO0 c0895II0xO0 = this.f33886Io;
        if (c0895II0xO0 != null && (XI0IXoo2 = c0895II0xO0.XI0IXoo()) != null) {
            for (int i2 = 0; i2 < XI0IXoo2.size(); i2++) {
                II0xO0.xxIXOIIO xxixoiio = XI0IXoo2.get(i2);
                if (xxixoiio != null && !TextUtils.isEmpty(xxixoiio.OOXIXo())) {
                    new Oxx0IOOO(OI0.Oxx0IOOO(xxixoiio.OOXIXo(), i)).XO();
                }
            }
        }
    }

    public e.a XIxXXX0x0() {
        return this.f33916oIX0oI;
    }

    public final void XO(II0xO0.Oxx0xo oxx0xo) {
        this.f33882IIX0o = oxx0xo.Oo();
        if (!x0XOIxOo(oxx0xo)) {
            return;
        }
        l lVar = this.f33935xo0x;
        if (lVar == l.PREFETCH) {
            if (Oxx0xo(oxx0xo)) {
                return;
            }
        } else if (lVar != l.NATIVE) {
            if (Oo(oxx0xo)) {
                return;
            }
        } else if (OxxIIOOXO(oxx0xo)) {
            return;
        }
        IIXOooo(oxx0xo);
    }

    public II0xO0.IIXOooo XOxIOxOx() {
        return this.f33906XX;
    }

    public long XX() {
        return this.f33925oxXx0IX;
    }

    public void XX0(View view, xoXoI xoxoi) {
        List<II0xO0.xxIXOIIO> XI0IXoo2;
        int i = this.f33897Oxx0xo;
        if (i <= 0) {
            this.f33897Oxx0xo = i + 1;
            if (!x0o.II0XooXoX(this.f33907XX0)) {
                this.f33907XX0 = OI0.XO(this.f33907XX0, "", "", "", "", "", "", "");
                new Oxx0IOOO(this.f33907XX0).XO();
                this.f33907XX0 = "";
            }
            o0xxxXXxX();
            II0xO0.C0895II0xO0 c0895II0xO0 = this.f33886Io;
            if (c0895II0xO0 != null && (XI0IXoo2 = c0895II0xO0.XI0IXoo()) != null) {
                for (int i2 = 0; i2 < XI0IXoo2.size(); i2++) {
                    II0xO0.xxIXOIIO xxixoiio = XI0IXoo2.get(i2);
                    if (xxixoiio != null && !TextUtils.isEmpty(xxixoiio.oIX0oI()) && view != null) {
                        String oIX0oI2 = xxixoiio.oIX0oI();
                        if (oIX0oI2.contains("?rv=1")) {
                            I0oOoX.xoXoI(oIX0oI2);
                        } else {
                            if (this.f33941xxX) {
                                oIX0oI2 = oIX0oI2 + "&opt=10";
                            } else if (this.f33912XxX0x0xxx) {
                                oIX0oI2 = oIX0oI2 + "&opt=1";
                            } else if (!this.f33934xXxxox0I) {
                                oIX0oI2 = oIX0oI2 + "&opt=11";
                            }
                            Oxx0IOOO oxx0IOOO = new Oxx0IOOO(oIX0oI2);
                            if (oIX0oI2.startsWith("http://v.adintl.cn/imp")) {
                                oxx0IOOO.xoIox(new I0Io(xoxoi));
                            }
                            oxx0IOOO.XO();
                        }
                    }
                }
            }
        }
    }

    public void XX0xXo(IXO.oIX0oI oix0oi) {
        this.f33922oo0xXOI0I = oix0oi;
    }

    public boolean Xo0() {
        return this.f33936xoIox;
    }

    public boolean XoI0Ixx0() {
        return this.f33880II0XooXoX;
    }

    public void XoX(View view, int i) {
        oI0IIXIo(view, i, this.f33941xxX, this.f33912XxX0x0xxx);
    }

    public int Xx000oIo() {
        return this.f33930x0xO0oo;
    }

    public List<Pair<i, String>> XxX0x0xxx() {
        return this.f33933xXOx;
    }

    public int o0() {
        return this.f33901X0o0xo;
    }

    public Context o00(View view) {
        Context context = view.getContext();
        if (context instanceof Activity) {
            return context;
        }
        if (view.getRootView() != null) {
            context = view.getRootView().getContext();
            if (context instanceof Activity) {
                return context;
            }
        }
        if (view.getContext() instanceof MutableContextWrapper) {
            context = ((MutableContextWrapper) view.getContext()).getBaseContext();
            if (context instanceof Activity) {
            }
        }
        return context;
    }

    public void o0xxxXXxX() {
        II0xO0.oOoXoXO xoIox2;
        II0xO0.IIXOooo iIXOooo = this.f33906XX;
        if (iIXOooo != null && (xoIox2 = iIXOooo.xoIox()) != null) {
            boolean z = true;
            if (xoIox2.oIX0oI() != 1) {
                z = false;
            }
            this.f33934xXxxox0I = z;
        }
    }

    public void oI0IIXIo(View view, int i, boolean z, boolean z2) {
        Context context;
        int i2;
        List<String> Oo2;
        if (view == null) {
            context = xoIox.oIX0oI().x0xO0oo();
        } else {
            context = view.getContext();
        }
        boolean z3 = true;
        if (z) {
            i2 = 10;
        } else if (z2) {
            i2 = 1;
        } else {
            i2 = i;
        }
        o0IXXIx.II0XooXoX.oIX0oI("OctopusAd", "handleClick========" + this.f33938xoXoI);
        String str = "";
        if (!this.f33938xoXoI) {
            this.f33938xoXoI = true;
            if (!x0o.II0XooXoX(this.f33877I0X0x0oIo)) {
                new Oxx0IOOO(this.f33877I0X0x0oIo).XO();
                this.f33877I0X0x0oIo = "";
            }
            ooOOo0oXI(i2, z, z2);
        }
        o0IXXIx.II0XooXoX.oIX0oI("OctopusAd", "mDeepLinkUrl:" + this.f33909XoI0Ixx0 + ",appDownloadURL = " + this.f33905XOxIOxOx + ",mLandingPageUrl = " + this.f33908Xo0);
        boolean oxoX2 = o0IXXIx.X0o0xo.oxoX(context, this.f33932xII);
        II0xO0.C0895II0xO0.oIX0oI oix0oi = this.f33911Xx000oIo;
        if (oix0oi != null) {
            if (oxoX2) {
                Oo2 = oix0oi.oO();
            } else {
                Oo2 = oix0oi.Oo();
            }
            IO.oIX0oI(Oo2);
        }
        if ((!this.f33940xxIXOIIO || oxoX2 || this.f33899X00IoxXI == 3) && !TextUtils.isEmpty(this.f33909XoI0Ixx0)) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(Uri.decode(this.f33909XoI0Ixx0)));
                intent.setFlags(805339136);
                context.startActivity(intent);
                if (!this.f33895OxI) {
                    this.f33895OxI = true;
                    I0Io(i2, z, z2);
                }
                II0xO0.C0895II0xO0.oIX0oI oix0oi2 = this.f33911Xx000oIo;
                if (oix0oi2 != null) {
                    IO.oIX0oI(oix0oi2.OOXIXo());
                    return;
                }
                return;
            } catch (Exception unused) {
                II0xO0.C0895II0xO0.oIX0oI oix0oi3 = this.f33911Xx000oIo;
                if (oix0oi3 != null) {
                    IO.oIX0oI(oix0oi3.ooOOo0oXI());
                }
                oxoX(context);
                return;
            }
        }
        if (!TextUtils.isEmpty(this.f33905XOxIOxOx) && this.f33899X00IoxXI == 2) {
            if (oxoX2) {
                o0IXXIx.X0o0xo.Oxx0IOOO(context, this.f33932xII);
                II0xO0.C0895II0xO0.oIX0oI oix0oi4 = this.f33911Xx000oIo;
                if (oix0oi4 != null) {
                    IO.oIX0oI(oix0oi4.oIX0oI());
                    return;
                }
                return;
            }
            if (OO() && i2 == 0) {
                i2 = 6;
            }
            File II0xO02 = o0IXXIx.X0o0xo.II0xO0(context);
            if (II0xO02 != null) {
                str = II0xO02.getAbsolutePath();
            }
            String str2 = str;
            if (view != null) {
                context = o00(view);
            }
            IO0XoXxO.I0Io X0o0xo2 = IO0XoXxO.I0Io.XO(context).oOoXoXO(context).II0XooXoX(this.f33924ooXIXxIX).oxoX(this.f33922oo0xXOI0I).X0o0xo(this.f33891OI0);
            if (!OO() && (context instanceof Activity)) {
                z3 = false;
            }
            X0o0xo2.xxIXOIIO(z3).II0xO0(i2).Oxx0IOOO(this.f33886Io).I0Io(new IO0XoXxO.II0xO0(this.f33905XOxIOxOx, this.f33932xII + b.b, this.f33932xII, str2, this.f33884IO, this.f33929x0o, context.getPackageName() + ".octopus.provider", this.f33911Xx000oIo)).ooOOo0oXI();
            return;
        }
        oxoX(context);
    }

    public final String oIX0oI(II0xO0.oIX0oI oix0oi) {
        String str;
        if (oix0oi.oIX0oI() != e.f.RENDER_H5 && oix0oi.oIX0oI() != e.f.RENDER_PIC) {
            return "";
        }
        if (oix0oi.oIX0oI() == e.f.RENDER_PIC) {
            if (XIxXXX0x0() == e.a.ADP_TABLE) {
                str = "cover";
            } else {
                str = "fill";
            }
            String str2 = "<!DOCTYPE html>\n<html lang=\"en\" style=\"width: 100%; height: 100%;\">\n<head>\n    <meta charset=\"UTF-8\">\n    <meta name=\"viewport\" id=\"viewport\" content=\"width=device-width, height=device-height, initial-scale=1\">\n    <title>Document</title>\n</head>\n<body style=\"width: 100%; height: 100%; padding: 0; margin: 0;\">\n<img style=\"width: 100%; height: 100%; object-fit: " + str + "\" src=\"https://v.behe.com/dsp20/ad/2017/5/5/28d147ed3e96a3ba8ac90703e4d66de2.jpg\" alt=\"\"/>\n</body>\n</html><!DOCTYPE html>";
            if (oix0oi.Oxx0IOOO() > 0) {
                return str2.replace("https://v.behe.com/dsp20/ad/2017/5/5/28d147ed3e96a3ba8ac90703e4d66de2.jpg", oix0oi.XO().get(0).I0Io());
            }
        }
        Matcher matcher = Pattern.compile("\\{(\\d+)\\.value\\}").matcher(oix0oi.X0o0xo());
        HashMap hashMap = new HashMap();
        for (int i = 0; i < oix0oi.Oxx0IOOO(); i++) {
            hashMap.put(Integer.valueOf(i), oix0oi.XO().get(i).I0Io());
        }
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            Integer valueOf = Integer.valueOf(Integer.parseInt(matcher.group(1)));
            if (hashMap.get(valueOf) != null) {
                matcher.appendReplacement(stringBuffer, (String) hashMap.get(valueOf));
            } else {
                matcher.appendReplacement(stringBuffer, "");
                com.octopus.ad.internal.utilities.oIX0oI.oxoX(com.octopus.ad.internal.utilities.oIX0oI.f18692Oxx0IOOO, com.octopus.ad.internal.utilities.oIX0oI.x0xO0oo(R.string.invalid_string_placeholder, matcher.group(0)));
            }
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    public int oOXoIIIo() {
        return this.f33894Oo;
    }

    public final void oOoXoXO() {
        if (TextUtils.isEmpty(this.f33931xI)) {
            return;
        }
        try {
            ClipboardManager clipboardManager = (ClipboardManager) xoIox.oIX0oI().x0xO0oo().getSystemService("clipboard");
            if (clipboardManager != null) {
                clipboardManager.setPrimaryClip(ClipData.newPlainText("wordText", this.f33931xI));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean oX() {
        return this.f33885IXxxXO;
    }

    public int oo() {
        return this.f33926oxoX;
    }

    public II0xO0.ooOOo0oXI oo0xXOI0I() {
        return this.f33913o0;
    }

    public final void ooOOo0oXI(int i, boolean z, boolean z2) {
        if (this.f33886Io != null && this.f33879I0oOoX != null) {
            for (int i2 = 0; i2 < this.f33879I0oOoX.size(); i2++) {
                II0xO0.xxIXOIIO xxixoiio = this.f33879I0oOoX.get(i2);
                if (xxixoiio != null && !TextUtils.isEmpty(xxixoiio.I0Io())) {
                    String I0Io2 = xxixoiio.I0Io();
                    if (I0Io2.contains("?rv=1")) {
                        I0oOoX.xoXoI(I0Io2);
                    } else {
                        if (I0Io2.startsWith("http://v.adintl.cn/clk")) {
                            if (z) {
                                I0Io2 = I0Io2 + "&opt=10";
                            } else if (z2) {
                                I0Io2 = I0Io2 + "&opt=1";
                            } else if (i != 0) {
                                I0Io2 = I0Io2 + "&opt=" + i;
                            } else if (!this.f33934xXxxox0I) {
                                I0Io2 = I0Io2 + "&opt=11";
                            }
                        }
                        new Oxx0IOOO(I0Io2).XO();
                    }
                }
            }
            this.f33879I0oOoX = null;
        }
    }

    public II0xO0.C0895II0xO0.oIX0oI ooXIXxIX() {
        return this.f33911Xx000oIo;
    }

    public void ox(boolean z) {
        this.f33912XxX0x0xxx = z;
    }

    public void oxXx0IX() {
        List<II0xO0.xxIXOIIO> XI0IXoo2;
        II0xO0.C0895II0xO0 c0895II0xO0 = this.f33886Io;
        if (c0895II0xO0 != null && (XI0IXoo2 = c0895II0xO0.XI0IXoo()) != null) {
            for (int i = 0; i < XI0IXoo2.size(); i++) {
                OI0.xxIXOIIO(XI0IXoo2.get(i));
            }
        }
    }

    public final void oxoX(Context context) {
        if (!TextUtils.isEmpty(this.f33908Xo0) && this.f33908Xo0.startsWith("http")) {
            if (this.f33878I0oOIX && this.f33883IIXOooo) {
                I0oOoX.xoXoI(this.f33908Xo0);
            } else {
                I0oOoX.o00(context, this.f33908Xo0);
            }
        }
    }

    public int oxxXoxO() {
        return this.f33896Oxx0IOOO;
    }

    public final boolean x0XOIxOo(II0xO0.Oxx0xo oxx0xo) {
        if (oxx0xo.xxIXOIIO() != 0) {
            com.octopus.ad.internal.utilities.oIX0oI.oxoX(com.octopus.ad.internal.utilities.oIX0oI.f18697XO, com.octopus.ad.internal.utilities.oIX0oI.Oxx0xo(R.string.response_error, oxx0xo.ooOOo0oXI(), oxx0xo.x0xO0oo()));
            return false;
        }
        return true;
    }

    public int x0o() {
        return this.f33881II0xO0;
    }

    public void x0xO() {
        II0xO0.C0895II0xO0 c0895II0xO0;
        if (!this.f33914o00 && (c0895II0xO0 = this.f33886Io) != null) {
            this.f33914o00 = true;
            List<II0xO0.xxIXOIIO> XI0IXoo2 = c0895II0xO0.XI0IXoo();
            if (XI0IXoo2 != null) {
                for (int i = 0; i < XI0IXoo2.size(); i++) {
                    II0xO0.xxIXOIIO xxixoiio = XI0IXoo2.get(i);
                    if (xxixoiio != null && !TextUtils.isEmpty(xxixoiio.X0o0xo())) {
                        new Oxx0IOOO(xxixoiio.X0o0xo()).XO();
                    }
                }
            }
        }
    }

    public final void x0xO0oo() {
        if (this.f33939xoxXI.isEmpty()) {
            return;
        }
        IO0XoXxO.oIX0oI.II0xO0(new II0xO0());
    }

    public int xI() {
        return this.f33904XO;
    }

    public int xII() {
        return this.f33890O0xOxO;
    }

    public void xXOx(View view, int i) {
        List<II0xO0.xxIXOIIO> XI0IXoo2;
        II0xO0.C0895II0xO0 c0895II0xO0 = this.f33886Io;
        if (c0895II0xO0 != null && (XI0IXoo2 = c0895II0xO0.XI0IXoo()) != null) {
            for (int i2 = 0; i2 < XI0IXoo2.size(); i2++) {
                OI0.OOXIXo(XI0IXoo2.get(i2));
            }
        }
    }

    public HashMap<String, Object> xXxxox0I() {
        return this.f33892OO;
    }

    public void xo0x(View view) {
        List<II0xO0.xxIXOIIO> XI0IXoo2;
        II0xO0.C0895II0xO0 c0895II0xO0 = this.f33886Io;
        if (c0895II0xO0 != null && (XI0IXoo2 = c0895II0xO0.XI0IXoo()) != null) {
            for (int i = 0; i < XI0IXoo2.size(); i++) {
                OI0.xoIox(XI0IXoo2.get(i));
            }
        }
    }

    public void xoIox(String str, Object obj) {
        this.f33892OO.put(str, obj);
    }

    public boolean xoIxX() {
        return this.f33893OOXIXo;
    }

    public int xoXoI() {
        return this.f33903XIxXXX0x0;
    }

    public boolean xoxXI() {
        return this.f33923ooOOo0oXI;
    }

    public void xxIO(com.octopus.ad.internal.view.II0xO0 iI0xO0) {
        this.f33887IoOoX = iI0xO0;
    }

    public boolean xxIXOIIO() {
        return this.f33937xoIxX;
    }

    public String xxX() {
        return this.f33882IIX0o;
    }

    public oIX0oI(II0xO0.Oxx0xo oxx0xo, Map<String, List<String>> map, l lVar, String str) {
        this.f33881II0xO0 = 0;
        this.f33876I0Io = 1;
        this.f33926oxoX = 0;
        this.f33901X0o0xo = 0;
        this.f33904XO = 0;
        this.f33896Oxx0IOOO = 0;
        this.f33880II0XooXoX = false;
        this.f33940xxIXOIIO = false;
        this.f33936xoIox = false;
        this.f33893OOXIXo = true;
        this.f33919oOoXoXO = false;
        this.f33923ooOOo0oXI = false;
        this.f33928x0XOIxOo = false;
        this.f33917oO = false;
        this.f33930x0xO0oo = 0;
        this.f33894Oo = 0;
        this.f33885IXxxXO = false;
        this.f33897Oxx0xo = 0;
        this.f33915oI0IIXIo = new oxoX();
        this.f33898OxxIIOOXO = new oxoX();
        this.f33883IIXOooo = false;
        this.f33941xxX = false;
        this.f33912XxX0x0xxx = false;
        this.f33934xXxxox0I = true;
        this.f33933xXOx = new LinkedList();
        this.f33939xoxXI = new LinkedList<>();
        this.f33892OO = new HashMap<>();
        this.f33888IoOoo = false;
        this.f33937xoIxX = false;
        if (oxx0xo == null) {
            com.octopus.ad.internal.utilities.oIX0oI.oIX0oI();
            return;
        }
        com.octopus.ad.internal.utilities.oIX0oI.XxX0x0xxx(oxx0xo.toString());
        com.octopus.ad.internal.utilities.oIX0oI.II0xO0(com.octopus.ad.internal.utilities.oIX0oI.f18697XO, com.octopus.ad.internal.utilities.oIX0oI.x0xO0oo(R.string.response_body, com.octopus.ad.internal.utilities.oIX0oI.II0XooXoX()));
        this.f33935xo0x = lVar;
        this.f33924ooXIXxIX = str;
        Oxx0IOOO(map);
        XO(oxx0xo);
        x0xO0oo();
    }

    public oIX0oI(boolean z) {
        this.f33881II0xO0 = 0;
        this.f33876I0Io = 1;
        this.f33926oxoX = 0;
        this.f33901X0o0xo = 0;
        this.f33904XO = 0;
        this.f33896Oxx0IOOO = 0;
        this.f33880II0XooXoX = false;
        this.f33940xxIXOIIO = false;
        this.f33936xoIox = false;
        this.f33893OOXIXo = true;
        this.f33919oOoXoXO = false;
        this.f33923ooOOo0oXI = false;
        this.f33928x0XOIxOo = false;
        this.f33917oO = false;
        this.f33930x0xO0oo = 0;
        this.f33894Oo = 0;
        this.f33885IXxxXO = false;
        this.f33897Oxx0xo = 0;
        this.f33915oI0IIXIo = new oxoX();
        this.f33898OxxIIOOXO = new oxoX();
        this.f33883IIXOooo = false;
        this.f33941xxX = false;
        this.f33912XxX0x0xxx = false;
        this.f33934xXxxox0I = true;
        this.f33933xXOx = new LinkedList();
        this.f33939xoxXI = new LinkedList<>();
        this.f33892OO = new HashMap<>();
        this.f33888IoOoo = false;
        this.f33937xoIxX = z;
    }
}
