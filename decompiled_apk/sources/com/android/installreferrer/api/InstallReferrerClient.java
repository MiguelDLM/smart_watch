package com.android.installreferrer.api;

import android.content.Context;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes.dex */
public abstract class InstallReferrerClient {

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface I0Io {

        /* renamed from: II0XooXoX, reason: collision with root package name */
        public static final int f5165II0XooXoX = 1;

        /* renamed from: Oxx0IOOO, reason: collision with root package name */
        public static final int f5166Oxx0IOOO = 0;

        /* renamed from: XO, reason: collision with root package name */
        public static final int f5167XO = -1;

        /* renamed from: xoIox, reason: collision with root package name */
        public static final int f5168xoIox = 3;

        /* renamed from: xxIXOIIO, reason: collision with root package name */
        public static final int f5169xxIXOIIO = 2;
    }

    /* loaded from: classes.dex */
    public static final class II0xO0 {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final Context f5170oIX0oI;

        @UiThread
        public InstallReferrerClient oIX0oI() {
            Context context = this.f5170oIX0oI;
            if (context != null) {
                return new com.android.installreferrer.api.oIX0oI(context);
            }
            throw new IllegalArgumentException("Please provide a valid Context.");
        }

        public II0xO0(Context context) {
            this.f5170oIX0oI = context;
        }
    }

    @UiThread
    public static II0xO0 oxoX(@NonNull Context context) {
        return new II0xO0(context);
    }

    @UiThread
    public abstract boolean I0Io();

    @UiThread
    public abstract ReferrerDetails II0xO0() throws RemoteException;

    @UiThread
    public abstract void X0o0xo(@NonNull InstallReferrerStateListener installReferrerStateListener);

    @UiThread
    public abstract void oIX0oI();
}
