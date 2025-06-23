package com.kwad.sdk.core.e;

import XXO0.oIX0oI;
import android.util.Log;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import com.ksad.annotation.invoker.ForInvoker;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes11.dex */
public final class c {
    public static boolean awv = true;
    private static boolean aww = com.kwad.sdk.core.e.a.md.booleanValue();
    private static final com.kwad.sdk.core.e.a.a awx = new b();
    private static final List<com.kwad.sdk.core.e.a.a> awy = new CopyOnWriteArrayList();

    /* loaded from: classes11.dex */
    public interface a {
        void b(com.kwad.sdk.core.e.a.a aVar);
    }

    @ForInvoker(methodId = "registerLogger")
    private static void Ev() {
        com.kwad.sdk.commercial.h.a.register();
    }

    private static void R(final String str, final String str2) {
        a(new a() { // from class: com.kwad.sdk.core.e.c.1
            @Override // com.kwad.sdk.core.e.c.a
            public final void b(com.kwad.sdk.core.e.a.a aVar) {
                aVar.d(str, str2);
            }
        });
    }

    private static void S(String str, String str2) {
        if (str2 != null && str2.length() > 4000) {
            R(str, str2.substring(0, 4000));
            S(str, str2.substring(4000));
        } else {
            R(str, str2);
        }
    }

    public static void T(final String str, String str2) {
        final String dX = dX(str2);
        a(new a() { // from class: com.kwad.sdk.core.e.c.5
            @Override // com.kwad.sdk.core.e.c.a
            public final void b(com.kwad.sdk.core.e.a.a aVar) {
                aVar.v(c.dW(str), dX, true);
            }
        });
    }

    public static void a(com.kwad.sdk.core.e.a.a aVar) {
        List<com.kwad.sdk.core.e.a.a> list = awy;
        if (list.contains(aVar)) {
            return;
        }
        list.add(aVar);
    }

    public static void d(String str, String str2) {
        S(dW(str), dX(str2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String dW(String str) {
        return "KSAd_" + str;
    }

    private static String dX(String str) {
        return str + " " + xz();
    }

    public static void e(final String str, String str2) {
        final String dX = dX(str2);
        a(new a() { // from class: com.kwad.sdk.core.e.c.9
            @Override // com.kwad.sdk.core.e.c.a
            public final void b(com.kwad.sdk.core.e.a.a aVar) {
                aVar.e(c.dW(str), dX);
            }
        });
    }

    public static void i(final String str, String str2) {
        final String dX = dX(str2);
        a(new a() { // from class: com.kwad.sdk.core.e.c.6
            @Override // com.kwad.sdk.core.e.c.a
            public final void b(com.kwad.sdk.core.e.a.a aVar) {
                aVar.i(c.dW(str), dX);
            }
        });
    }

    public static void init(boolean z) {
        awv = z;
        List<com.kwad.sdk.core.e.a.a> list = awy;
        list.clear();
        list.add(awx);
        Ev();
    }

    public static void printStackTrace(final Throwable th) {
        if (th != null) {
            a(new a() { // from class: com.kwad.sdk.core.e.c.2
                @Override // com.kwad.sdk.core.e.c.a
                public final void b(com.kwad.sdk.core.e.a.a aVar) {
                    aVar.printStackTraceOnly(th);
                }
            });
        }
        if (!com.kwad.sdk.core.e.a.md.booleanValue()) {
        } else {
            throw new RuntimeException(th);
        }
    }

    public static void printStackTraceOnly(final Throwable th) {
        if (th != null) {
            a(new a() { // from class: com.kwad.sdk.core.e.c.3
                @Override // com.kwad.sdk.core.e.c.a
                public final void b(com.kwad.sdk.core.e.a.a aVar) {
                    aVar.printStackTraceOnly(th);
                }
            });
        }
    }

    public static void v(final String str, String str2) {
        final String dX = dX(str2);
        a(new a() { // from class: com.kwad.sdk.core.e.c.4
            @Override // com.kwad.sdk.core.e.c.a
            public final void b(com.kwad.sdk.core.e.a.a aVar) {
                aVar.v(c.dW(str), dX);
            }
        });
    }

    public static void w(final String str, String str2) {
        final String dX = dX(str2);
        a(new a() { // from class: com.kwad.sdk.core.e.c.7
            @Override // com.kwad.sdk.core.e.c.a
            public final void b(com.kwad.sdk.core.e.a.a aVar) {
                aVar.w(c.dW(str), dX);
            }
        });
    }

    private static String xz() {
        int i;
        String str;
        if (!aww) {
            return "";
        }
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        if (stackTrace.length > 3) {
            str = stackTrace[3].getFileName();
            i = stackTrace[3].getLineNumber();
        } else {
            i = -1;
            str = "unknown";
        }
        return oIX0oI.I0Io.f4096II0xO0 + str + ':' + i + HexStringBuilder.COMMENT_END_CHAR;
    }

    private static void a(a aVar) {
        for (com.kwad.sdk.core.e.a.a aVar2 : awy) {
            if (aVar2 != null) {
                try {
                    aVar.b(aVar2);
                } catch (Exception unused) {
                }
            }
        }
    }

    public static void e(final String str, String str2, Throwable th) {
        final String dX = dX(str2 + '\n' + Log.getStackTraceString(th));
        a(new a() { // from class: com.kwad.sdk.core.e.c.10
            @Override // com.kwad.sdk.core.e.c.a
            public final void b(com.kwad.sdk.core.e.a.a aVar) {
                aVar.e(c.dW(str), dX);
            }
        });
    }

    public static void w(final String str, Throwable th) {
        final String dX = dX(Log.getStackTraceString(th));
        a(new a() { // from class: com.kwad.sdk.core.e.c.8
            @Override // com.kwad.sdk.core.e.c.a
            public final void b(com.kwad.sdk.core.e.a.a aVar) {
                aVar.w(c.dW(str), dX, com.kwad.sdk.core.e.a.md.booleanValue());
            }
        });
    }
}
