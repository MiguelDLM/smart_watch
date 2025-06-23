package com.bestmafen.androidbase.base;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.LayoutRes;
import java.io.Serializable;

/* loaded from: classes8.dex */
public interface oIX0oI {

    /* renamed from: I0Io, reason: collision with root package name */
    @OOXIXo
    public static final String f10328I0Io = "mArg1";

    /* renamed from: II0xO0, reason: collision with root package name */
    @OOXIXo
    public static final String f10329II0xO0 = "mArg0";

    /* renamed from: X0o0xo, reason: collision with root package name */
    @OOXIXo
    public static final String f10330X0o0xo = "mArg3";

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OOXIXo
    public static final C0549oIX0oI f10331oIX0oI = C0549oIX0oI.f10336oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    @OOXIXo
    public static final String f10332oxoX = "mArg2";

    /* renamed from: com.bestmafen.androidbase.base.oIX0oI$oIX0oI, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C0549oIX0oI {

        /* renamed from: I0Io, reason: collision with root package name */
        @OOXIXo
        public static final String f10333I0Io = "mArg1";

        /* renamed from: II0xO0, reason: collision with root package name */
        @OOXIXo
        public static final String f10334II0xO0 = "mArg0";

        /* renamed from: X0o0xo, reason: collision with root package name */
        @OOXIXo
        public static final String f10335X0o0xo = "mArg3";

        /* renamed from: oIX0oI, reason: collision with root package name */
        public static final /* synthetic */ C0549oIX0oI f10336oIX0oI = new C0549oIX0oI();

        /* renamed from: oxoX, reason: collision with root package name */
        @OOXIXo
        public static final String f10337oxoX = "mArg2";
    }

    @oOoXoXO
    String getMArg0();

    int getMArg1();

    @oOoXoXO
    Parcelable getMArg2();

    @oOoXoXO
    Serializable getMArg3();

    void init(@oOoXoXO Bundle bundle);

    boolean initEvent();

    void initView();

    @LayoutRes
    int layoutId();

    void setMArg0(@oOoXoXO String str);

    void setMArg1(int i);

    void setMArg2(@oOoXoXO Parcelable parcelable);

    void setMArg3(@oOoXoXO Serializable serializable);
}
