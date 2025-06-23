package com.github.appintro.internal;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.x0XOIxOo;
import XO0OX.xoIox;
import android.util.Log;
import kotlin.jvm.internal.IIX0o;
import kotlin.reflect.oxoX;

/* loaded from: classes9.dex */
public final class LogHelper {

    @OOXIXo
    public static final LogHelper INSTANCE = new LogHelper();

    private LogHelper() {
    }

    private final String cutTagLength(String str, int i) {
        if (str.length() > i) {
            String substring = str.substring(0, i - 1);
            IIX0o.oO(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            return substring;
        }
        return str;
    }

    @x0XOIxOo
    public static final int d(@OOXIXo String tag, @OOXIXo String message) {
        IIX0o.x0xO0oo(tag, "tag");
        IIX0o.x0xO0oo(message, "message");
        return Log.d(tag, message);
    }

    @x0XOIxOo
    @xoIox
    public static final void e(@OOXIXo String tag, @OOXIXo String message) {
        IIX0o.x0xO0oo(tag, "tag");
        IIX0o.x0xO0oo(message, "message");
        e$default(tag, message, null, 4, null);
    }

    public static /* synthetic */ void e$default(String str, String str2, Throwable th, int i, Object obj) {
        if ((i & 4) != 0) {
            th = null;
        }
        e(str, str2, th);
    }

    @x0XOIxOo
    public static final int i(@OOXIXo String tag, @OOXIXo String message) {
        IIX0o.x0xO0oo(tag, "tag");
        IIX0o.x0xO0oo(message, "message");
        return Log.i(tag, message);
    }

    @x0XOIxOo
    @OOXIXo
    public static final String makeLogTag(@OOXIXo Class<?> cls) {
        IIX0o.x0xO0oo(cls, "cls");
        LogHelper logHelper = INSTANCE;
        String simpleName = cls.getSimpleName();
        IIX0o.oO(simpleName, "cls.simpleName");
        return IIX0o.XIxXXX0x0("Log: ", logHelper.cutTagLength(simpleName, 18));
    }

    @x0XOIxOo
    public static final int v(@OOXIXo String tag, @OOXIXo String message) {
        IIX0o.x0xO0oo(tag, "tag");
        IIX0o.x0xO0oo(message, "message");
        return Log.v(tag, message);
    }

    @x0XOIxOo
    @xoIox
    public static final void w(@OOXIXo String tag, @OOXIXo String message) {
        IIX0o.x0xO0oo(tag, "tag");
        IIX0o.x0xO0oo(message, "message");
        w$default(tag, message, null, 4, null);
    }

    public static /* synthetic */ void w$default(String str, String str2, Throwable th, int i, Object obj) {
        if ((i & 4) != 0) {
            th = null;
        }
        w(str, str2, th);
    }

    @x0XOIxOo
    @xoIox
    public static final void wtf(@OOXIXo String tag, @OOXIXo String message) {
        IIX0o.x0xO0oo(tag, "tag");
        IIX0o.x0xO0oo(message, "message");
        wtf$default(tag, message, null, 4, null);
    }

    public static /* synthetic */ void wtf$default(String str, String str2, Throwable th, int i, Object obj) {
        if ((i & 4) != 0) {
            th = null;
        }
        wtf(str, str2, th);
    }

    @x0XOIxOo
    @xoIox
    public static final void e(@OOXIXo String tag, @OOXIXo String message, @oOoXoXO Throwable th) {
        IIX0o.x0xO0oo(tag, "tag");
        IIX0o.x0xO0oo(message, "message");
        Log.e(tag, message, th);
    }

    @x0XOIxOo
    @xoIox
    public static final void w(@OOXIXo String tag, @OOXIXo String message, @oOoXoXO Throwable th) {
        IIX0o.x0xO0oo(tag, "tag");
        IIX0o.x0xO0oo(message, "message");
        Log.w(tag, message, th);
    }

    @x0XOIxOo
    @xoIox
    public static final void wtf(@OOXIXo String tag, @OOXIXo String message, @oOoXoXO Throwable th) {
        IIX0o.x0xO0oo(tag, "tag");
        IIX0o.x0xO0oo(message, "message");
        Log.wtf(tag, message, th);
    }

    @OOXIXo
    public final String makeLogTag(@OOXIXo oxoX<?> cls) {
        IIX0o.x0xO0oo(cls, "cls");
        String xoXoI2 = cls.xoXoI();
        if (xoXoI2 == null) {
            xoXoI2 = "";
        }
        return IIX0o.XIxXXX0x0("Log: ", cutTagLength(xoXoI2, 18));
    }
}
