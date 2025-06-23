package com.jd.ad.sdk.logger;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.jd.ad.sdk.jad_ir.jad_bo;
import com.jd.ad.sdk.jad_ir.jad_dq;
import com.jd.ad.sdk.jad_ir.jad_fs;

/* loaded from: classes10.dex */
public final class Logger {
    public static final int ASSERT = 7;
    public static final int DEBUG = 3;
    public static final int ERROR = 6;
    public static final int INFO = 4;
    public static final int VERBOSE = 2;
    public static final int WARN = 5;

    @NonNull
    private static jad_fs printer = new jad_dq();

    private Logger() {
    }

    public static void addLogAdapter(@NonNull jad_bo jad_boVar) {
        jad_fs jad_fsVar = printer;
        jad_boVar.getClass();
        jad_fsVar.jad_an(jad_boVar);
    }

    public static void clearLogAdapters() {
        printer.jad_an();
    }

    public static void d(@Nullable Object obj) {
        printer.jad_an(obj);
    }

    public static void e(@NonNull String str, @Nullable Object... objArr) {
        if (str == null) {
            str = "";
        }
        printer.jad_an(null, str, objArr);
    }

    public static void i(@NonNull String str, @Nullable Object... objArr) {
        if (str == null) {
            str = "";
        }
        printer.jad_bo(str, objArr);
    }

    public static void json(@Nullable String str) {
        printer.jad_bo(str);
    }

    public static void log(int i, @Nullable String str, @Nullable String str2, @Nullable Throwable th) {
        printer.jad_an(i, str, str2, th);
    }

    public static void printer(@NonNull jad_fs jad_fsVar) {
        jad_fsVar.getClass();
        printer = jad_fsVar;
    }

    public static jad_fs t(@Nullable String str) {
        return printer.jad_an(str);
    }

    public static void v(@NonNull String str, @Nullable Object... objArr) {
        if (str == null) {
            str = "";
        }
        printer.jad_cp(str, objArr);
    }

    public static void w(@NonNull String str, @Nullable Object... objArr) {
        if (str == null) {
            str = "";
        }
        printer.jad_dq(str, objArr);
    }

    public static void wtf(@NonNull String str, @Nullable Object... objArr) {
        if (str == null) {
            str = "";
        }
        printer.jad_an(str, objArr);
    }

    public static void xml(@Nullable String str) {
        printer.jad_cp(str);
    }

    public static void d(@NonNull String str, @Nullable Object... objArr) {
        if (str == null) {
            str = "";
        }
        printer.jad_er(str, objArr);
    }

    public static void e(@Nullable Throwable th, @NonNull String str, @Nullable Object... objArr) {
        if (str == null) {
            str = "";
        }
        printer.jad_an(th, str, objArr);
    }
}
