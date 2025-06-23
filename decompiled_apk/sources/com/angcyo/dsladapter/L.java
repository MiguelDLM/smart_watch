package com.angcyo.dsladapter;

import XXO0.oIX0oI;
import android.util.Log;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import java.util.Arrays;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;
import org.json.JSONArray;
import org.json.JSONObject;

@XX({"SMAP\nL.kt\nKotlin\n*S Kotlin\n*F\n+ 1 L.kt\ncom/angcyo/dsladapter/L\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,206:1\n1864#2,3:207\n13579#3,2:210\n*S KotlinDebug\n*F\n+ 1 L.kt\ncom/angcyo/dsladapter/L\n*L\n135#1:207,3\n158#1:210,2\n*E\n"})
/* loaded from: classes7.dex */
public final class L {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final int f5258I0Io = 2;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final Oox.IXxxXO<String, Integer, String, oXIO0o0XI> f5259II0XooXoX;

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final String f5260II0xO0;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public static int f5261IXxxXO = 0;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static int f5262OOXIXo = 0;

    /* renamed from: Oo, reason: collision with root package name */
    @OXOo.oOoXoXO
    public static String f5263Oo = null;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final int f5264Oxx0IOOO = 6;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final int f5265X0o0xo = 4;

    /* renamed from: XO, reason: collision with root package name */
    public static final int f5266XO = 5;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final L f5267oIX0oI;

    /* renamed from: oO, reason: collision with root package name */
    public static int f5268oO = 0;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static int f5269oOoXoXO = 0;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static int f5270ooOOo0oXI = 0;

    /* renamed from: oxoX, reason: collision with root package name */
    public static final int f5271oxoX = 3;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static int f5272x0XOIxOo;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static Oox.IXxxXO<? super String, ? super Integer, ? super String, oXIO0o0XI> f5273x0xO0oo;

    /* renamed from: xoIox, reason: collision with root package name */
    @OXOo.OOXIXo
    public static String f5274xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static boolean f5275xxIXOIIO;

    static {
        L l = new L();
        f5267oIX0oI = l;
        f5260II0xO0 = System.getProperty("line.separator");
        L$DEFAULT_LOG_PRING$1 l$default_log_pring$1 = new Oox.IXxxXO<String, Integer, String, oXIO0o0XI>() { // from class: com.angcyo.dsladapter.L$DEFAULT_LOG_PRING$1
            @Override // Oox.IXxxXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(String str, Integer num, String str2) {
                invoke(str, num.intValue(), str2);
                return oXIO0o0XI.f29392oIX0oI;
            }

            public final void invoke(@OXOo.OOXIXo String tag, int i, @OXOo.OOXIXo String msg) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(tag, "tag");
                kotlin.jvm.internal.IIX0o.x0xO0oo(msg, "msg");
                if (i == 2) {
                    Log.v(tag, msg);
                    return;
                }
                if (i == 3) {
                    Log.d(tag, msg);
                    return;
                }
                if (i == 4) {
                    Log.i(tag, msg);
                } else if (i == 5) {
                    Log.w(tag, msg);
                } else {
                    if (i != 6) {
                        return;
                    }
                    Log.e(tag, msg);
                }
            }
        };
        f5259II0XooXoX = l$default_log_pring$1;
        f5275xxIXOIIO = l.IIXOooo();
        f5274xoIox = "L";
        f5262OOXIXo = 2;
        f5269oOoXoXO = -1;
        f5270ooOOo0oXI = 2;
        f5272x0XOIxOo = -1;
        f5268oO = 2;
        f5273x0xO0oo = l$default_log_pring$1;
        f5261IXxxXO = 3;
    }

    public static /* synthetic */ void OxxIIOOXO(L l, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = l.IIXOooo();
        }
        l.oI0IIXIo(str, z);
    }

    public final void I0Io(@OXOo.OOXIXo Object... msg) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(msg, "msg");
        f5261IXxxXO = 3;
        oIX0oI(Arrays.copyOf(msg, msg.length));
    }

    public final boolean II0XooXoX() {
        return f5275xxIXOIIO;
    }

    @OXOo.OOXIXo
    public final String II0xO0(@OXOo.OOXIXo String msg) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(msg, "msg");
        if (f5268oO <= 0) {
            return msg;
        }
        try {
            if (kotlin.text.OxI.IOOoXo0Ix(msg, "{", false, 2, null) && kotlin.text.OxI.XO0o(msg, org.apache.commons.text.ooOOo0oXI.f33074oOoXoXO, false, 2, null)) {
                return f5260II0xO0 + new JSONObject(msg).toString(f5268oO);
            }
            if (kotlin.text.OxI.IOOoXo0Ix(msg, "[", false, 2, null) && kotlin.text.OxI.XO0o(msg, "]", false, 2, null)) {
                return f5260II0xO0 + new JSONArray(msg).toString(f5268oO);
            }
            return msg;
        } catch (Exception unused) {
            return msg;
        }
    }

    public final void IIX0o(@OXOo.oOoXoXO String str) {
        f5263Oo = str;
    }

    public final boolean IIXOooo() {
        return false;
    }

    @OXOo.oOoXoXO
    public final String IXxxXO() {
        return f5263Oo;
    }

    public final void O0xOxO(@OXOo.OOXIXo Oox.IXxxXO<? super String, ? super Integer, ? super String, oXIO0o0XI> iXxxXO) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iXxxXO, "<set-?>");
        f5273x0xO0oo = iXxxXO;
    }

    @OXOo.OOXIXo
    public final Oox.IXxxXO<String, Integer, String, oXIO0o0XI> OOXIXo() {
        return f5273x0xO0oo;
    }

    public final int Oo() {
        return f5272x0XOIxOo;
    }

    public final void OxI(int i) {
        f5268oO = i;
    }

    @OXOo.OOXIXo
    public final Oox.IXxxXO<String, Integer, String, oXIO0o0XI> Oxx0IOOO() {
        return f5259II0XooXoX;
    }

    public final void Oxx0xo(@OXOo.OOXIXo Object... msg) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(msg, "msg");
        f5261IXxxXO = 4;
        oIX0oI(Arrays.copyOf(msg, msg.length));
    }

    public final void X0IIOO(int i) {
        f5262OOXIXo = i;
    }

    public final void X0o0xo(@OXOo.OOXIXo Object... msg) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(msg, "msg");
        f5261IXxxXO = 6;
        oIX0oI(Arrays.copyOf(msg, msg.length));
    }

    public final void XI0IXoo(int i) {
        f5270ooOOo0oXI = i;
    }

    public final void XIxXXX0x0(@OXOo.OOXIXo String str) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(str, "<set-?>");
        f5274xoIox = str;
    }

    public final void XO(@OXOo.OOXIXo String tag, @OXOo.OOXIXo Object... msg) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tag, "tag");
        kotlin.jvm.internal.IIX0o.x0xO0oo(msg, "msg");
        f5263Oo = tag;
        f5261IXxxXO = 6;
        oIX0oI(Arrays.copyOf(msg, msg.length));
    }

    public final void XxX0x0xxx(int i) {
        f5269oOoXoXO = i;
    }

    public final void o00(boolean z) {
        f5275xxIXOIIO = z;
    }

    public final void oI0IIXIo(@OXOo.OOXIXo String tag, boolean z) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tag, "tag");
        f5274xoIox = tag;
        f5275xxIXOIIO = z;
    }

    public final void oIX0oI(@OXOo.OOXIXo Object... msg) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(msg, "msg");
        if (!f5275xxIXOIIO) {
            return;
        }
        List<StackTraceElement> oIX0oI2 = xI.oIX0oI(ooOOo0oXI(), oOoXoXO());
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        int i = 0;
        for (Object obj : oIX0oI2) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.XoX();
            }
            StackTraceElement stackTraceElement = (StackTraceElement) obj;
            sb.append(oIX0oI.I0Io.f4096II0xO0);
            sb.append(stackTraceElement.getFileName());
            if (i == CollectionsKt__CollectionsKt.oo0xXOI0I(oIX0oI2)) {
                sb.append(":");
                sb.append(stackTraceElement.getLineNumber());
                sb.append(oIX0oI.I0Io.f4095I0Io);
            }
            sb.append(OoOoXO0.xoXoI.f2670oxoX);
            sb.append(stackTraceElement.getMethodName());
            if (i == CollectionsKt__CollectionsKt.oo0xXOI0I(oIX0oI2)) {
                sb.append(":");
                sb.append(Thread.currentThread().getName());
            } else {
                sb.append(OoOoXO0.xoXoI.f2670oxoX);
                sb.append(stackTraceElement.getLineNumber());
                sb.append(" ");
            }
            i = i2;
        }
        sb.append("]");
        String sb2 = sb.toString();
        kotlin.jvm.internal.IIX0o.oO(sb2, "StringBuilder().apply(builderAction).toString()");
        StringBuilder sb3 = new StringBuilder();
        for (Object obj2 : msg) {
            if (obj2 instanceof CharSequence) {
                sb3.append(f5267oIX0oI.II0xO0(String.valueOf(obj2)));
            } else {
                sb3.append(obj2);
            }
        }
        String sb4 = sb3.toString();
        kotlin.jvm.internal.IIX0o.oO(sb4, "StringBuilder().apply(builderAction).toString()");
        f5273x0xO0oo.invoke(x0XOIxOo(), Integer.valueOf(f5261IXxxXO), sb2 + TokenParser.SP + sb4);
        f5263Oo = null;
        f5269oOoXoXO = -1;
        f5272x0XOIxOo = -1;
    }

    public final int oO() {
        return f5261IXxxXO;
    }

    public final int oOoXoXO() {
        int i = f5269oOoXoXO;
        if (i <= 0) {
            return f5262OOXIXo;
        }
        return i;
    }

    public final void oo(@OXOo.OOXIXo String tag, @OXOo.OOXIXo Object... msg) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tag, "tag");
        kotlin.jvm.internal.IIX0o.x0xO0oo(msg, "msg");
        f5263Oo = tag;
        f5261IXxxXO = 5;
        oIX0oI(Arrays.copyOf(msg, msg.length));
    }

    public final void oo0xXOI0I(@OXOo.OOXIXo Object... msg) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(msg, "msg");
        f5261IXxxXO = 5;
        oIX0oI(Arrays.copyOf(msg, msg.length));
    }

    public final int ooOOo0oXI() {
        int i = f5272x0XOIxOo;
        if (i <= 0) {
            return f5270ooOOo0oXI;
        }
        return i;
    }

    public final void ooXIXxIX(@OXOo.OOXIXo Object... msg) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(msg, "msg");
        f5261IXxxXO = 2;
        oIX0oI(Arrays.copyOf(msg, msg.length));
    }

    public final void oxoX(@OXOo.OOXIXo String tag, @OXOo.OOXIXo Object... msg) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tag, "tag");
        kotlin.jvm.internal.IIX0o.x0xO0oo(msg, "msg");
        f5263Oo = tag;
        f5261IXxxXO = 3;
        oIX0oI(Arrays.copyOf(msg, msg.length));
    }

    @OXOo.OOXIXo
    public final String x0XOIxOo() {
        String str = f5263Oo;
        if (str == null) {
            return f5274xoIox;
        }
        return str;
    }

    public final int x0xO0oo() {
        return f5269oOoXoXO;
    }

    public final void xI(@OXOo.OOXIXo String tag, @OXOo.OOXIXo Object... msg) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tag, "tag");
        kotlin.jvm.internal.IIX0o.x0xO0oo(msg, "msg");
        f5263Oo = tag;
        f5261IXxxXO = 2;
        oIX0oI(Arrays.copyOf(msg, msg.length));
    }

    public final void xXxxox0I(int i) {
        f5272x0XOIxOo = i;
    }

    public final String xoIox() {
        return f5260II0xO0;
    }

    public final void xoXoI(@OXOo.OOXIXo String tag, @OXOo.OOXIXo Object... msg) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tag, "tag");
        kotlin.jvm.internal.IIX0o.x0xO0oo(msg, "msg");
        f5263Oo = tag;
        f5261IXxxXO = 4;
        oIX0oI(Arrays.copyOf(msg, msg.length));
    }

    public final int xxIXOIIO() {
        return f5268oO;
    }

    public final void xxX(int i) {
        f5261IXxxXO = i;
    }
}
